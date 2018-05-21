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
> db.createCollection({"emp, {capped:true, size:2100000000, max:5000000"})