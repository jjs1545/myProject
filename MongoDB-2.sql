===============================================

Aggregate Framework 변경 연산자 (결과 반영)
$add			두개의 값을 환산
$devide			두개의 값을 나눈 결과
$mod 			첫 번째 값을 두번째값으로 나눈 나머지 값
$multiply		두개의 값을 곱한 결과
$subtract 		두개의 값을 뺄셈 결과

$ifNull			NULL 검사
 > $ifNull:["$comm", 0]
 		comm이 Null이면 0으로, 아니면 원래 값 
$substr
 > $substr:["$ename", 1, 2]
 		이름을 첫번째 부터 2바이트 자르기

$toLower		문자열을 소문자로
$toUpper		문자열을 대문자로
$strcasecmp		문자열을 비교 후 같으면 1, 다르면 -1
 > $strcasecmp:["$ename","SMIT"]
 		ename이 SMITH면 1, 다르면 -1

============ Scale Up과 Scale Out =============

 Scale Up

 수직 확장, 성능 확장, H/W(장비 확장)
 유지 비용이 비교적 변화가 적다.
 장애 발생 시 전체 영향으로 될 수 있다.

 Scale Out
 
 수평 확장, 지속 확장 
 유지 비용이 확장 대수에 따라 변화가 크다.
 장애 발생 시 전체 영향의 가능성이 적다.

 트랜잭션(Database Transaction)
 		: 데이터 처리의 단위 (상호작용)단위

 ex) 월급을 주는 기업, 월급을 받는 직원 
		: 기업 계좌 감소 -> 직원 계좌 증가 

 [ACID]
 Atomicity(원자성): 트랜잭션 수행 중간에는 중단되지 않는다.
 					기업의 계좌 감소 성공! 만약, 직원 계좌 증가가 실패라면?
 					수행 중간에 실패가 없게끔 만들어주는 방법 

 Consistency(일관성): 트랜잭션이 정상적으로 수행됐다면, 데이터베이스의 데이터는 일관성으로
 					  유지되어야 한다.

 Isolation(독립성): 트랜잭션 수행 시 다른 트랜잭션의 작업이 끼어들지 못하도록 보장.
 					기업 계좌가 감소하고 직원 계좌가 증가해야하는데,
 					중간에 계좌 조회라는 트랜잭션이 끼어들어선 안된다!

 Durablity(지속성): 트랜잭션 성공 시 해당 결과는 지속적이어야 한다. 
 					트랜잭션 정상적 수행 후에 로그로 기록되어,
 					시스템 장애 전 상태로 복구하는 방법


[Index]
 Index의 존재 의미
 		: 데이터 처리의 속도를 빠르게 하기 위함
 Document의 Field에 Indexing,
 Key 값을 기준으로 B-Tree를 생성하여 처리한다.

 [ensureIndex()]
  db.COLLECTION_NAME.ensureIndex({KEY:1})
  db.members.ensureIndex({"member, name" : 1})
  //컬렉션에 해당 필드에 새 인덱스를 작성

  background(Boolean): Background에 Index를 구축
  					    default false, (선택) true

  unique(Boolean): 고유 인덱스
  					_id처럼 컬렉션에 단 한개만 존재 하도록

createIndex()
db.COLLECTION_NAME.createIndex({KEY : 1}) // 인덱스 생성
> db.members.createIndex({"salary" : 1})
> db.members.createIndex({"age" : 1, "salary" : -1})

getIndex()
db.COLLECION_NAME.getIndexes()
> db.members.getIndexes()

dropIndex()
db.COLLECTION_NAME.dropIndexes() // _id를 제외한 모든 인덱스 삭제
db.COLLECTION_NAME.dropIndex({KEY : 1}) // 해당 제거
> db.members.dropIndexes()
> db.members.dropIndex({"salary" : 1})

Work.
 members Collection의
 age는 내림차순, salary는 오름차순으로
 indexing 하여라.
 그리고 출력 시 정렬된 상태로 표시하라.

 >db.members.createIndex({"age":-1, "salary":1})
  db.members.find().sort({"age":-1, "salary":1})

[reIndex()]
 db.COLLECTION_NAME.reIndex()
 db.members.reIndex()
 //인덱스 재배치
 //인덱스를 삭제 후 다시 생성
 //주기적으로 검색이 느려지면 사용!
 //용량을 재 배치하여 줄여준다.


[인덱스 종류]

 - index _id
 		: 따로 지정하지 않으면,
 		  자동으로 ObjectId를 설정
 		  unique로 되어있어, 중복 방지

 - Single Field
 		: _id index 외에 MongoDB 제공하는 문서 단일 필드
 		  사용자 정의 오름, 내림(정렬)을 지원

 - Compound Field (Compound Key Index, 복합 인덱스)
 		: 나열된 필드의 순서를 따른다.
 		  첫 필드의 정렬된 데이터를 가지고 다음 필드 설정

========== 단일 인덱스 vs 복합 인덱스 ==============

-단일 인덱스

> db.employees.createIndex({"empno":1})
  //empno를 이용하여 검색할 때 오름차순 검색
> db.employees.createIndex({"deptno":1})
  //deptno를 이용하여 검색할 때 오름차순 검색

VS

-복합 인덱스

> db.employees.createIndex({"empno":1,"deptno":-1})
  //empno를 오름차순 검색 후에
  //해당 결과물을 가지고 내림차순으로 검색


***** 싱글키는 단순 출력 시, 복합 키는 상세 검색 시
***** 필드마다 인덱스가 부여된다. 
***** 검색이 잦은 필드에만 인덱스 부여 ! (신중하게 결정)

 - MultiKey Index
 		: 배열 값을 가진 필드의 indexing
 		  배열의 각 용소에 대한 index key를 생성

 - GeoSpatial Index 
 		: Map(지도)의 xPos, yPos같은 좌표를 
 		  효율적으로 처리하기 위한 indexing
 		  ex) 특정 좌표의 반경 데이터를 검색

 - Text Index
 		: Text Data 처리를 위한 indexing
 		  Test 검색 쿼리를 지원
 		  (문자열, 문자열 요소의 배열)
 		  단, Collection에는 최대 하나의 Text Index
 		- 가중치 지정
 				: A에 대한 검색 가중치 점수를 부여
 				  (중요성 확장)
 		- 와일드 카드
 				: Text의 여러 필드 indexing
 				  Collection의 각 document에 대한
 				  문자열 데이터가 존재하는 모든 필드를
 				  indexing 해준다.
> db.COLLECTION_NAME.createIndex({"$**":"text"})

- Hash Index
	   : B-Tree가 아닌 Hash DataStruct 사용 (정렬 X)

[인덱스 속성] (Index Properties)
-Unique Indexes
	  : _id 처럼 Collection에 단 하나만 존재하는 속성
	  	indexing field의 중복을 허용하지 않는다.
	  : db.COLLECTION_NAME.createIndex({"KEY":1}, {unique:true})
	  > db.members.createIndex({"salary":1}, {unique:true})

	  [제한 사항] 
	  이미 중복된 document data가 존재한다면,
	  indexing을 허용하지 않는다.

-Partial Indexes
	  : 필터 표현식에 따라 일부 document만 indexing
	  : db.COLLECTION_NAME.createIndex(
	  				   {"KEY":1, "KEY":-1},
	  				   {partialFilterExpression: 
	  				   	 {"KEY":필터 표현식}
	  				   })

	  > db.members.createIndex({"age":1, "salary":-1},
	  	{partialFilterExpression:{"salary":{$gte:10000}}})
 
 문제(부분 인덱스 발동이 되는지 않되는지))	
   ==== db.employees.createIndex({"deptno":1,"ename":1},{partialFilterExpression:{"sal": {$gt:500}}}) ==== 인덱스		
		

	ex)	db.employees.find({deptno:10},sal:{$gt:2000})				 //partial O
		--ename, deptno 필드로 검색 시
		--sal field가 $gt:500이상으로 검색된다면,
		--인덱스가 추가 발동
		db.employees.find({deptno:10})								 //partial X --> deptno은 있지만 salay가 없다.
		db.employees.find({deptno:20},sal:{$lt:2000})				 //partial x --> 조건은 맞지만 2천 이하의 값은 200 300 도 포함이므로 500이상인 조건이랑 다르다 	
 		db.employees.find({ename:"SMITH",sal:{$gt:500}})			 //partial x --> 맨첫번째에 있는 deptno로 오름차순이 진행된다 여기에선 deptno이 없으므로 indexing이 동작 안한다.
		db.employees.find({deptno:20, ename:"ADRAM", sal:{$gt:500}}) //partial O

-TTL Indexes
	  : document의 생명 주기를 설정 (expire)
	  	속성 설정 시 해당 시간이 지나면
	  	컬렉션에서 제거
	  	_id 필드로 생성할 수 없다.
	  	단일 필드 인덱스, 복합 indexing 불가!

	  > db.COLLECTION_NAME.createIndex(
	  	{"KEY":1},{expireAfterSeconds:1800})
	  > db.members.createIndex(
	  	{"age":1},{expireAfterSeconds:1800})
	  //age 필드에 생성한 인덱스를 30분 후 삭제 


-Sparse Indexes
	  : field가 전체 document에 비해 밀도가 낮은 경우
	  	해당 field 자체가 많이 없을 경우
	  > db.employees.createIndex({comm:1}, {sparse:true})
	  > db.employees.find({comm:{$gte:2000}})
	  //comm이 2000이상인 직원을 찾을 때,
	  //comm 존재하지 않으면 검색 대상에서 제외 (검색 X)