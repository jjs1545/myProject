=NoSQL=

단어 뜻 그 자체를 따지자면 "Not only SQL"로, SQL만을 사용하지 않는 데이터베이스 관리 시스템(DBMS)을 지칭하는 단어이다. 
관계형 데이터베이스를 사용하지 않는다는 의미가 아닌, 여러 유형의 데이터베이스를 사용하는 것이다.
데이터를 조직하는 방법에는 리스트, 해시, 트리, 그래프 등의 다양한 방법이 있고 각각은 장점과 단점이 명확하기 때문에 단순히 NoSQL 이라고만 해서는 너무 뜬구름 잡는 얘기가 된다. 저 단어는 RDBMS가 데이터베이스의 거의 전부를 차지할 정도로 독점적인 지위를 차지하고 있는 현재 상황에 반발하는 정신을 담고 있다.
“Not Only SQL” : 데이터를 저장하는 데에는 SQL 외에 다른 방법들도 있다.
NoSQL이라고 하는 말은 No 'English' 라고 하는 말과 마찬가지다. 세상에는 영어 말고도 수많은 언어가 존재한다. 
MongoDB에서 사용하는 쿼리 언어와 CouchDB에서 사용하는 쿼리 언어는 서로 전혀 다르다. 그럼에도 이 두 쿼리 언어는 같은 NoSQL 카테고리에 속한다. 
어쨌거나 SQL이 아니기 때문이다. 또한 NoSQL이 No RDBMS를 의미하지는 않는다. BerkleyDB같은 예외가 있기 때문이다. 그리고 No RDBMS가 NoSQL인 것도 아니다. 
SQL호환 레이어를 제공하는 KV-store라는 예외가 역시 존재한다. 물론 KV-store의 특징상 range query를 where절에 넣을 수 없으므로 완전한 SQL은 못 되고 SQL의 부분집합 정도를 제공한다.
사실 아직까지 NoSQL에 내려진 구체적인 정의는 없다. 하지만 NoSQL이라 불리는 데이터베이스들은 대체로 다음과 같은 공통적인 성향을 보인다.
대부분 클러스터에서 실행할 목적으로 만들어졌기 때문에 관계형 모델을 사용하지 않는다. 그러나 모든 NoSQL 데이터베이스가 클러스터에서 실행되도록 맞춰진 것은 아니다. 예
를 들어 NoSQL 데이터 모델 중 하나인 그래프 데이터베이스는 관계형 데이터베이스와 비슷한 분산 모델을 사용한다.
오픈 소스이다. 비오픈 소스 프로젝트도 있긴 하지만, 대부분 그렇다.
보통 21세기 초반 웹 환경의 필요에 기초를 두고 있어서, 이 시기에 개발된 시스템만을 NoSQL이라고 부른다. 따라서 그 이전에 만들어진 ODBMS(Objective Database Management System)은 NoSQL에 해당하지 않는다.
스키마 없이 동작하며, 구조에 대한 정의를 변경할 필요 없이 데이터베이스 레코드에 자유롭게 필드를 추가할 수 있다.


요약 : 대부분이 오픈 소스고, 21세기 초반에 개발되었으며 SQL을 사용하지 않는 Schema-less 데이터베이스.

RDBMS
 스키마 : 데이터베이스 사용에 있어서의 규칙
 제약사항이 존재한다
 효율적으로 공간 사용

NoSQL
 전통적인 관계형 데이터베이스 보다 덜 제한적
 제약사항이 없고, 데이터를 무더기로 넣는 느낌
 데이터의 빠른 처리 가능
 Sharding : 데이터를 분할 저장
 Replica Set : 데이터 복제 세트 (백업, 복구) 
 디자인의 단순화, 수평적 확장성 추구
 빅데이터와 실시간 웹 애플리케이션용

=========몽고 DB==========

mongod : 서버실행 
mongo  : 몽고 쉘 실행 

show dbs 
현재 데이터베이스 확인

db.hostInfo()
host 정보 확인

RDBMS vs NoSQL

RDMBS: CREATE TABLE EMP();
NoSQL: > db.createCollection("emp")

INSERT INTO emp(empno, ename) VALUES(100, "BIT");
> db.emp.insert({empno:1001, ename:"BIT"})

UPDATE dept SET deptno=30, ename="HI" WHERE empno=1001;
> db.dept.update({empno:1001}, {$set:{deptno:30, ename:"HI"}})

컬렉션 생성
> db.createCollection(
	"emp", 
	{capped:true, 
	 size:2100000000, 
	 max:500000
	 })

	capped: 데이터의 유지를 하지 않는다.
	크기 21억 바이트가 채워지면,
	데이터를 모두 지우고 다시 사용.
	false라면 이어서 붙여 사용.
	size: 컬렉션의 크기
	max: 하나의 데이터 크기 (50만 바이트)

컬렉션 삭제
db.emp.drop()

컬렉션을 생성하지 않고 삽입하고자 하면,
자동으로 컬렉션을 생성!

db.employees.insert({ 
	empno: 7369,
	ename: "SMITH",
	job: "CLERK",
	hiredate:"17-12-1980",
	salary: 800,
	deptno:20
	})

db.employees.insert({ 
	empno: 7499,
	ename: "ALLEN",
	job: "SALEMAN",
	hiredate:"20-02-1981",
	salary: 1600,
	comm: 300,
	deptno:30
	})

db.employees.insert({ 
	empno: 7521,
	ename: "WARD",
	job: "SALEMAN",
	hiredate:"22-02-1981",
	salary: 1250,
	comm: 300,
	deptno:30
	})

db.employees.insert({ 
	empno: 7341,
	ename: "JOHNES",
	job: "MANAGER",
	hiredate:"21-05-1981",
	salary: 2250,
	comm: 250,
	deptno:30
	})

컬렉션 데이터 확인
db.employees.find()
db.employees.find().pretty()

비교 연산자
$eq 	해당 값과 일치하는 값 
$ne 	해당 값과 일치하지 않은 값
$gt 	해당 값보다 큰 값
$gte 	해당 값보다 크거나 같은 값
$lt 	해당 값보다 작은 값
$lte 	해당 값보다 작거나 같은 값 
$in 	해당 배열에 포함되어 있는 값
$nin 	해당 배열에 포함되지 않은 값


논리 연산자
$or 	조건 중 하나라도 true -> true
$and 	조건 모두가 true -> true
$not 	조건이 ture->false, false->true
$nor 	조건 모두가 false -> true

SELECT * FROM employees
> db.employees.find()
> db.employees.find().pretty

SELECT * FROM employees
 WHERE salary > 1000
   AND deptno < 30;
> 
db.employees.find(
		{ $and: [
					{ sal: {$gt: 1000}},
					{ deptno: {$lt:30}}
				]
		}
)

SELECT * FROM employees
 WHERE sal < 2000
 	OR sal > 1000

 >
db.employees.find({$or:[{sal: {$lt:2000}}, {sal: {$gt:1000}}]})

SELECT * FROM employees
 WHERE deptno = 30,
 ORDER BY ename DESC;
 >db.employees.find({
 	deptno: 30
 	}).sort({ename:-1})

 sort({ename: 1}): 이름 기준 오름차순
 sort({deptno: -1}): 부서번호 기준 내림차순

 SELECT COUNT(*)
   FROM employees
  WHERE sal > 2500;
 > db.employees.find({
 	sal:{$gt:2500}
 	}).count()


 SELECT *
   FROM employees
  WHERE depno IN(10, 30)
 > db.employees.find({deptno:{$in:[10,30]}})

 SELECT *
   FROM employees
  WHERE ename LIKE '%A%';
 > db.employees.find({ename: /A/}) 

 SELECT *
   FROM employees
  WHERE ename LIKE 'A%'; // A로 시작
 > db.employees.find({ename:/^A/})

 SELECT *
   FROM employees
  WHERE ename LIKE '%S'; // S로 끝
 > db.employees.find({ename:/S$/})


 해당 필드가 존재하는지
 > db.employees.find({comm:{$exists:true}})

 필드의 타입 검사
 > db.employees.find({comm:{$type:1}})

 1: double
 2: String
 3: Object 
 4: Array
 ...
 20가지 

SELECT ename, empno FROM employees
> db.employees.find({},{ename:1,empno:1})

ObjectID 필드는 내부적으로 검색!!

find()
find({조건절}, {필드})

db.employees.find({$or:[{sal: {$lt:2000}}, {sal: {$gt:1000}}]})

Q1.
SELECT * FROM employees WHERE job='CLERK' AND sal >= 1000;
>db.employees.find({$and:[{sal:{$gte:1000}},{job:/CLERK/}]})

Q2.
SELECT * FROM employees WHERE job='SALEMAN' AND deptno = 30;
>db.employees.find({$and:[{job:/SALEMAN/},{deptno:30}]})

Q3.
SELECT empno, ename, sal FROM employees WHERE sal <= 1000;
>db.employees.find({},{empno:1,ename:1,sal:1},{$and:[{job:/SALEMAN/},{deptno:30}]})

Q4.
SELECT empno, ename, job FROM employees WHERE deptno=10 OR deptno=30;
>db.employees.find({},{empno:1,ename:1,job:1},{$or:[{deptno:10},{deptno:30}]})

Q5.
SELECT empno, ename, sal, job FROM employees
 WHERE (job = 'SALEMAN' or job = 'CLERK')
   AND sal >= 1000 AND sal <= 3500;

>db.employees.find(
	{
	$and:[
			{$or:[
				{job:'SALESMAN'},{job:'CLERK'}
				]
			},
			{sal:{$gte:100}},{sal:{$lte:3500}}
		]
	},
	{_id:0,empno:1,ename:1,sal:1,job:1}
	)

===jandi에서 받은 json 파일 import

json 데이터 import
mongoimport --db [데이터베이스 이름]
			--collection [컬렉션 이름]
			--type [데이터 형식]
			--drop
			--file "[파일 이름, 확장자]""

>mongoimport --db test --collection zipcode
			 --type json --drop
			 --file "zipcode.json"


Aggregate: 집계
내부 문서 연산 시 속도를 빠르게 처리한다.
ex) RDBMS에서의 min, sum, max...

$match: 연결 연산자 (WHERE, HAVING)
$project: 결과를 투영 (SELECT)
$group: 그룹화 (GROUP BY)


부서별 급여 합계
db.employees.aggregate([{
   $group:{_id:"$deptno",total_sal:{$sum: '$sal'}}},
{$project : {_id:1 , total_sal:1}}])
// GROUP BY depno, SUM(sal) AS total_sal

부서가 30인 직원의 직업별 총 급여
db.employees.aggregate([
      {$match : {deptno : 30}},
      {$group : {_id : "$job",total_sal : {$sum : "$sal"}}},
      {$project : {_id :1, total_sal : 1}}
])

도시별 인구수 합계
db.zipcode.aggregate([
{$group:{_id:"$city",total_pop:{$sum:"$pop"}}
}])

//GROUP만 되는 이유
//aggreate pipeline: document를 staram화

db.zipcode.find({state:"NY", city:"NEW YORK"})

주별 인구수가 제일 많은 곳과 적은 곳
db.zipcode.aggregate([
	{$group: {_id:"$state", max_pop:{$max:"$pop"}, min_pop:{$min:"$pop"}}}
	])

주별 인구수의 합이 제일 많은 곳과 적은 곳의 차
db.zipcode.aggregate([
	{$group:
		{_id:"$state", sum_pop:{$sum:"$pop"}}
	},
	{$group:
		{_id:0, max_pop:{$max:"$sum_pop"}, min_pop:{$min:"$sum_pop"}}
	},
	{$project:
		{_id:new ObjectId(), subtract_pop:{$subtract:["$max_pop", "$min_pop"]}}
	}
])

NEW YORK에서 인구수가 가장 많은 곳의 zipcode
db.zipcode.aggregate([
	{$match: {city:"NEW YORK"}},
	{$group:{_id:0, max_pop:{$max:"$pop"}}
	}
	])

//내림차순으로 정렬해서 하나만 집계하겠다.
db.zipcode.aggregate([
	{$match: {city:"NEW YORK"}},
	{$project: {pop:"$pop",zipcode:"$_id"}},
	{$sort: {pop:-1}},
	{$limit:1}
	])

주별 인구수 평균
db.zipcode.aggregate([
	{$group: {_id:{state:"$state", city:"$city"}, pop:{$sum:"$pop"}}},
	{$group: {_id: "$_id.state", avgCityPop: {$avg:"$pop"}}}
	])	

db.members.insert([
{"_id":1,"member":{"name":"Georgi","gender":"M"}, "age":45, "salary":14000},
{"_id":2,"member":{"name":"Bezalel","gender":"W"}, "age":42, "salary":11000},
{"_id":3,"member":{"name":"Parto","gender":"M"}, "age":36, "salary":13500},
{"_id":4,"member":{"name":"Christan","gender":"W"}, "age":27, "salary":12200},
{"_id":5,"member":{"name":"Kyoichi","gender":"M"}, "age":33, "salary":11700},
{"_id":6,"member":{"name":"Anneke","gender":"W"}, "age":41, "salary":14300}
])

나이를 내림차순 정렬
> db.members.find().sort({"age":-1})

나이는 오름차순, 급여는 내림차순
> db.members.find().sort({"age":1, "salary":-1})

[createCollection()]
> db.createCollection(name, options)
{
	name: 생성할 컬렉션의 이름,
	options: (선택) 메모리 관련 옵션 지정
	{
		capped (Boolean)
				: true인 경우 고정된 크기의 컬렉션
				  size option 설정 필수!
				  size over 시 오래된 항목을 덮어 씌움

		autoIndexID (Boolean)
				: true시 자동으로 _id Field 값 지정
		size (Number)
				: capped의 크기를 지정 (capped = true)
		max (Number)
				: 최대 document의 개수
	}
}

[drop()]
db.COLLECTION_NAME.drop() //컬렉션 삭제

[Mongo DB DataType]
 String: UTF-8
 Boolean
 Integer
 Double 
 Min/Max keys: 최소/최대 값과 비교하는데 사용
 Arrays
 Timestamp
 Object
 Null
 Symbol : String과 비슷하나, 고정기호 유형을 사용할 때 
 Date 
 Object ID 
 Binary data 
 Code: JS Code를 저장하는데 사용
 Regular Expression: 정규 표현식을 저장하는데 사용

 [insert()]
 >db.COLLECTION_NAME.inset(document)

 [find()]
 >db.COLLECTION_NAME.find()

 [pretty()]
 >db.COLLECTION_NAME.find().pretty()

 [조건 연산자]
 Equlity { <key> : <value> }
 >db.COLLECTION_NAME.find({"name":"latte"})
 sql> WHERE name = "latte"

 Less Than { <key> : {$lt:<value>}}
 >db.COLLECTION_NAME.find({"age":{$lt:6}})
 sql> WHERE age < 6
 ...

 Not Equals { <key> : {$ne:<value>}}
 >db.COLLECTION_NAME.find({"age":{$ne:3}})
 sql> WHERE age != 3

 [update()]
 db.COLLECTION_NAME.update(SELECTION_CRITERIA, UPDATED_DATA)
 >db.employees.update({"name" : "SMITH"}, {$set:{"name":"MONGO"}})

 [save()]
 db.COLLECTION_NAME.save({_id:ObjectID(), NEW_DATA})
 >db.employees.save({"_id" : ObjectId("5b0220d19442cd4bf97cfae3"), "ename" : "MONGO", "height":180})
 
 [update()와 save()의 차이]
  - update는 기존의 데이터를 수정
  - save는 덮어 씌우는 방법

db.employees.save({"_id" : ObjectId("5b0220d19442cd4bf97cfae3"), "ename" : "SAVE_DATA", "height":180})
db.employees.save({"_id" : ObjectId("5b0220d19442cd4bf97cfae3"
  					"ename" : "SAVE_DATA"})

[remove()]
 db.COLLECTION_NAME.remove(DELETION_CRITERIA)
 >db.employees.remove({ "ename": "UPSERT_DATA"})
 //같은 value의 Data에서 하나만 삭제하고자 할 때(첫 번째) 
 >db.employees.remove({ })

[find()]
 db.COLLECTION_NAME.find({ }, { KEY:1 })
 >db.members.find({ }, {"age": 0})		// age필드를 제외한 출력!
 >db.members.find({ }, {"age": 1})		// age만 출력 !
 >db.members.find({ }, {"gender": 0})	// KEY를 못찾는다.
 >db.members.find({ }, {"member.gender":0})
 >db.members.find({ }, {"member.gender":1})

 [limit()]
 >db.COLLECTION_NAME.find().limit(NUMBER)
 >db.members.find().limit(2)

 [skip()]
 >db.COLLECTION_NAME.find().skip(NUMBER)
 >db.COLLECTION_NAME.find().limit(NUMBER).skip(NUMBER)
 >db.members.find().skip(2)
 >db.members.find().limit(3).skip(1)

 [sort()]
 >db.COLLECTION_NAME.find().sort({KEY:SORT_NUMBER})
 >db.members.find().sort({"salary":1})
 >db.members.find({},
 				 {"salary":1, _id:0}
 				 ).sort({"salary":-1})

 MA 주의 모든 도시를 구하시오.
 >db.zipcode.aggregate([
 	{$match: {state:"MA"}},
 	{$project: {city: 1}}
 	])

 인구수가 많은 순으로 10개의 도시 및 인구수를 구하시오.
 >db.zipcode.aggregate([
 	{$project: {city:1, pop:1}},
 	{$sort: {pop:-1}},
 	{$limit:10}
 	])

 MA 주의 도시 중 인구가 1000이하인 도시를 구하시오.
  db.zipcode.aggregate([
	{$match : {state : "MA"}},
	{$group : {_id : "$city", total_pop : {$sum : "$pop"}}},
	{$match : {total_pop : {$lte : 1000}}},
	{$project : {city : 1}}
])

 <employees collection aggregation>
 1. 부서 번호가 10이고, 급여가 500이상 3000이하인 사람이면서,
 	직업이 CLERK이거나 SALESMAN인 사람의 
 	empno, ename, job, sal을 출력 하시오.

> db.employees.aggregate([
	{$match:{$and:[{deptno:10},{sal:{$gte:500}},{sal:{$lte:3000}},
	{$or:[{job:"CLERK"},{job:"SALESMAN"}]}]} },
	{$project:{empno:1,ename:1,job:1,sal:1}} ])


 2. 부서번호가 30인 사람의
 	empno, ename, sal, comm을 출력하는데,
 	comm이 없으면 0으로 표시하고,
 	sal+comm을 total_sal로 표기하시오.
 	hint: {$ifNull:["comm", 0]} --> 사용하기
 		  {$add:["$sal", "$comm"]}

> db.employees.aggreagte([
	{$match: },
	{$ifNull:["comm",0]}
	{$project:{empno:1,ename:1,sal:1,comm:1}}
	])
}

3. 주마다 몇개의 도시가 있는지 구하시오.
> db.zipcode.aggregate([
	{$group:{}}
	{$project:{city:1,state:1}}
	])

>db.zipcode.aggregate([
	{$group : {_id : "$state", count : {$sum : 1}}},
	{$project : {state : 1, count : 1}}
])

4. 인구수가 10만 이상인 주를 구하시오.

>db.zipcode.aggregate([
	{$match:{pop:{$gte:100000}}},
	{$project:{state:1,pop:1}}
	])

5. WA주는 몇개의 도시를 갖고 있는지 구하시오.

>db.zipcode.aggregate([
	{$match:{state:"WA"}},
	{$group:{_id:"$state",count:{$sum:1}}},
	])



