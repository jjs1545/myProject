[Sharding & Replica Set]

 Sharding : 데이터를 분할해서 처리
 Replica Set : 복제 셋(복구 용도)
  => 거의 같이 사용

  config 서버를 Replica Set으로 생성
  3.4버전부터는 반드시 config서버를 Replica Set으로 생성

  1. config의 ReplicaSet 설정 
  mongod --configsvr --replSet <세트 이름>
  --dbpath <config 서버 경로> --port <포트번호>

  mongod --configsvr --replSet config1 --dbpath C:\Users\BIT\Desktop\shard\config1 --port 20001
  mongod --configsvr --replSet config1 --dbpath C:\Users\bit34\shard\config1 --port 20001

  mongod --configsvr --replSet config1 --dbpath C:\Users\bit34\shard\config1 --port 20001
  mongod --configsvr --replSet config2 --dbpath C:\Users\bit34\shard\config2 --port 20002
  mongod --configsvr --replSet config3 --dbpath C:\Users\bit34\shard\config3 --port 20003

 2. 서버 접속
 mongo --host localhost --port 20001 

 3. 여러 서버를 묶는 작업
 rs.initiate({_id:"configRep!",configsvr:true,members:[{_id:0, host:"localhost:20001"},{_id:1, host:"localhost:20001"},{_id:2, host:"localhost:20001"}]})

 mongod --configsvr --replSet configRepl --dbpath C:\Users\bit34\shard\config1 --port 20001
 mongod --configsvr --replSet configRepl --dbpath C:\Users\bit34\shard\config2 --port 20002
 mongod --configsvr --replSet configRepl --dbpath C:\Users\bit34\shard\config3 --port 20003

 rs.initiate(
        {
        _id:"configRepl",
         configsvr:true,
        members:[
           {_id:0, host:"localhost:20001"},
           {_id:1, host:"localhost:20002"},
           {_id:2, host:"localhost:20003"}
    ]
}
)

 [shard 만들기]
 1. 폴더 생성 
 shard > shard1 > shardRepl1 > data > db
 				  shardRepl2 > data > db
 				  shardRepl3 > data > db
 shard > shard1 > shardRepl1 > data > db
 				  shardRepl2 > data > db
 				  shardRepl3 > data > db
 shard > shard1 > shardRepl1 > data > db
 				  shardRepl2 > data > db
 				  shardRepl3 > data > db	 			  


 2. ReplicaSet 설정
 mongod --shardsvr --replSet shardRepl1 --dbpath C:\Users\bit34\shard\shard\shard1\shardRepl1\data\db --port 20011
 mongod --shardsvr --replSet shardRepl1 --dbpath C:\Users\bit34\shard\shard\shard1\shardRepl2\data\db --port 20012
 mongod --shardsvr --replSet shardRepl1 --dbpath C:\Users\bit34\shard\shard\shard1\shardRepl3\data\db --port 20013
 
 mongod --shardsvr --replSet shardRepl2 --dbpath C:\Users\bit34\shard\shard\shard2\shardRepl1\data\db --port 20021
 mongod --shardsvr --replSet shardRepl2 --dbpath C:\Users\bit34\shard\shard\shard2\shardRepl2\data\db --port 20022
 mongod --shardsvr --replSet shardRepl2 --dbpath C:\Users\bit34\shard\shard\shard2\shardRepl3\data\db --port 20023

 mongod --shardsvr --replSet shardRepl3 --dbpath C:\Users\bit34\shard\shard\shard3\shardRepl1\data\db --port 20031
 mongod --shardsvr --replSet shardRepl3 --dbpath C:\Users\bit34\shard\shard\shard3\shardRepl2\data\db --port 20032
 mongod --shardsvr --replSet shardRepl3 --dbpath C:\Users\bit34\shard\shard\shard3\shardRepl3\data\db --port 20033
 //... 9개 전부 실행

3. 3개의 서버를 묶는 작업
//11, 12, 13
//21, 22, 23
//31, 32, 33
mongo --host localhost --port 20031
mongo --host localhost --port 20032
mongo --host localhost --port 20033

rs.initiate({_id:"shardRepl3",members:[{_id:0, host:"localhost:20031"},{_id:1, host:"localhost:20032"},{_id:2, host:"localhost:20033"}]})


4.mongos 연결하기 (클라이언트를 위한 통로 생성)
mongos --configdb configRepl/localhost:20001,localhost:20002,localhost:20003 --port 20000
//20000번 포트로 몽고스 연결 
//config로 가능 mongos 통로
//직접 가진 못해서 20000 포트를 통해 연결

5.사드 붙이기
mongo --host localhost --port 20000
//mongos 접속 후 쉘 명령창 "mongos>"확인

mongos>
sh.addShard("shardRepl1/localhost:20011")
sh.addShard("shardRepl1/localhost:20021")
sh.addShard("shardRepl1/localhost:20031")

sh.status() //상태 확인

6. 샤딩 가능한 데이터베이스 등록
sh.enableSharding("<database>")
mongos> sh.enableSharding("test")

7. 인덱스 생성
db.things.createIndex({empno:1})
//샤딩 설정 전에 인덱스 생성
//단일 인덱스만 가능

8.인덱스를 통한 샤드 키 생성
use admin //관리자 권한으로 실행
sh.shardCollection("test.things",{emp:"hashed"})
//샤딩 가능한 컬렉션 등록 (해쉬)

db.runCommand({listshards:1})
//샤드 확인 

9. 테스트 
 만개의 데이터를 넣어서 확인
 for(var n=0; n<10000; n++){db.things.save({empno:n, ename:"test", sal:1000})}

 > mongo localhost:20011 (Primary) //14192개 
 > mongo localhost:20021 (Primary) //13966개 
 > mongo localhost:20031 (Primary) //14122개 

6736 0 6710

[Shard Key]
Hashed Shard Key
 : 유일한 값으로 키 값을 설정
 	중복된 값이 많다면 데이터가 몰릴 수 있다.
 	키를 기준으로 분배!

Ranged Shard Key
 : 데이터가 한 곳에 몰릴 수 있다.
 (1~1000은 shard1, 1001-3000은 shard2. ...)

사용자가 강제로 복구 

 [master_slave]
1. master 서버 실행 

 mongod --dbpath <마스터 경로> --port 10000 --master
 //서버를 실행시키겠다. 지정된 경로, 포트 지정, 옵션을 마스터 -> 지정된 경로에 몽고디비 서버를 만들겠다
 
 >(새로운cmd) mongod --dbpath C:\Users\bit34\repl\master --port 10000 --master

2. slave 서버 실행

mongod --dbpath <슬레이브 경로> --port 10001 
--slave --source localhost:10000
// 슬레이브 서버는 마스터 서버의 종속도 표기.

>(새로운cmd) mongod --dbpath C:\Users\bit34\repl\slave1 --port 10001 --slave --source localhost:10000
>(새로운cmd) mongod --dbpath C:\Users\bit34\repl\slave2 --port 10002 --slave --source localhost:10000

3. master 서버 접속 

->(새로운cmd) 마스터 서버로 접속 shell 명령어창을 띄운다
>mongo localhost:10000 (몽고 마스터의 ip로 접속)

4. slave 서버 접속

->(새로운cmd) 슬레이브1 서버로 접속 shell 명령어창을 띄운다
>mongo localhost:10001
접속 후 데이터 제어가 불가능!
(slave 서버는 일반적으로 볼 수 없다.)

rs.slaveOk() //이 명령어로 슬레이브 조작 가능
db.user.find()로 조회는 가능하지만,
db.user.insert()로 데이터 삽입은 불가!
// not master 에러
--> 마스터에 있는 데이터를 슬레이브에서 백업하는 용도로 슬레이브를 사용한다.

use admin 관리자 권한
db.shutdownServer() //서버 강제 종료

cmd> del 경로\*.*
cmd> del C:\user\bit34\repl\master\*.* --> 경로에 있는 \파일명.파일확장자 데이터 모두 삭제

cmd> copy 슬레이브 경로\*.* 마스터 경로\*.* --> 슬레이브 경로에 있는 것을 모두 마스터 경로에
cmd> copy C:\Users\bit34\repl\slave1\*.* C:\Users\bit34\repl\master\*.*

사용자가 지정하는 방식. (잘 사용 안한다.)


아비터를 이용한 복구
 [arbit]
 --아비터(arbiter): PRIMARY 삭제시 PRIMARY가 Slave로 변경 PRIMARY를 다시 살리면 Slave가 PRIMARY고 PRIMARY는 SECONDARY로 된다. 

 1. 서버 실행
 Primary Server 생성
 > mongod --dbpath disk1의 경로 --port 10001 --replSet rptmongo --oplogSize10
 > mongod --dbpath C:\Users\bit34\replsets\disk1 --port 10001 --replSet rptmongo --oplogSize 10
 
 --oplogSize 10
 --레플리카 세트 크기 지정
 --생략 시 1GB로 지정, 

 2. Primary Server 접속 (쉘 실행)
 > mongo localhost:10001/admin
 //관리자 데이터베이스 바로 접속


 rs.initiate()
 //리플리카 셋 초기화
 //OTHER> 라면, 엔터 한번 더 쳐서
 //PRIMARY> 로..

 3. Secondary Server 생성
 mongod --dbpath disk2의 경로 --port 10002 -replSet rptmongo --oplogSize 10
 > mongod --dbpath C:\Users\bit34\replsets\disk2 --port 10002 -replSet rptmongo --oplogSize 10

 4. Arbiter Server 생성
 mongod --dbpath arbit의 경로 --port 10003 --replSet rptmongo --pologSize 10
 > mongod --dbpath C:\Users\bit34\replsets\arbit --port 10003 --replSet rptmongo --oplogSize 10

 5. 슬레이브 추가
 PRIMARY> rs.add("localhost:10002")
 PRIMARY> rs.add("192.168.1.28:10002")
 // localhost보단 ip 주소로 직접 해라.

 6. 아비터 추가
 Primary Server에서
 PRIMARY> rs.addArb("localhost:10003")

 7. 정보 확인
 > db.printReplicationInfo()

 8. Primary 셧다운 후 10002번 접속 (Slave)
 		//이전 SECONDARY가 PRIMARY로 되었는지 확인!
 		--아비터(arbiter): PRIMARY 삭제시 PRIMARY가 Slave로 변경 PRIMARY를 다시 살리면 Slave가 PRIMARY고 PRIMARY는 SECONDARY로 된다. 


 9.disk3 생성후 서버 접속

> mongod --dbpath C:\Users\bit34\replsets\disk3 --port 10004 -replSet rptmongo --oplogSize 10
