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

