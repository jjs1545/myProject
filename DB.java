DB 접속
mysql -u root -p 

DB 확인
show databases;

DB 생성 (hellodb)
create database hellodb;

DB 사용 (hellodb 사용)
use hellodb;

현재 DB의 Table 확인
show tables;

테이블 생성
create table 테이블_이름 (
	id      INT,
	addr    VARCHAR(30)
)

create? 정의어 

table column: id, addr
table row type: INT, VARCHAR(30)

테이블 확인
describe [table name];
 >describe emp;

테이블 삭제
drop table 테이블_이름;
 > drop table emp;

데이터 삽입
insert int 테이블_이름 values (
	'data', 'data', .... , 'data'
	);

테이블 데이터 전부 조회
SELECT * FROM 테이블_이름;
 > SELECT * FROM emp;

테이블 특정 ROW 조회
SELECT * FROM emp where name = "전지영";
 > SELECT * FROM [테이블] where [조건절];

테이블 특정 컬럼 조회
SELECT [컬럼1, 컬럼2 ... ] FROM [table];
 > SELECT name, start_date FROM emp;

테이블 특정 컬럼 정렬 조회
SELECT [컬럼1, 컬럼2 ... ] FROM [table]
 order by [정렬 기준];
 > SELECT name, start_date FROM emp
 	order by start_date;

 > SELECT name, start_date FROM emp
 	order by start_date desc;

NULL를 제외한 조회
 SELECT [컬럼] FROM [테이블]
  where [데이터] is not null;
 > SELECT name, commission_pct FROM emp
  where commission_pct is not null;

 NULL값 조회 -> is NULL값

정규 표현식
 _ : 하나의 문자
 % : 문자열에 대응

> SELECT name, dept_id FROM emp where name LIKE "박";
 where name like "최%";
//성이 최씨인 사람 조회

> SELECT name, dept_id FROM emp
 where name like "%해숙";
//이름이 해숙인 사람 조회

> SELECT name, dept_id FROM emp
 where name like "__";
//이름이 두글자인 사람 조회

ALIAS(별칭) 활용
SELECT [컬럼] as [별칭] FROM [테이블];
 > SELECT name as 이름,
  		  dept_id as 부서번호,
  		  salary as 연봉
   FROM emp;
//컬럼의 이름이 바뀌는 것은 아니다.
//조회 시 원하는 이름으로 확인하겠다.

중복을 제거한 조회
 > SELECT dept_id FROM emp; //전부 조회
//나는 부서 번호의 종류만 알고 싶다.
 > SELECT distinct dept_id FROM emp;

정렬된 상태의 조회
 > SELECT start_date as 입사일
   FROM emp
   order by start_date ASC;
   //order by [칼럼 or 표현식] (ASC or DESC);
ASC  : 오름차순, 디폴트이므로 생략 가능!
DESC : 내림 차순

//TODO
//Q1.
//emp 테이블에서 이름, 부서번호, 입사일을 부서번호 순으로 조회하시오.

//Q2.
//emp 테이블에서 1994년 입사한 사람의
//이름, 입사일 연봉을 연봉 순으로 조회하시오/

조건절 (where)
-산술 비교 연산자
입사일이 1995년 이후 입사한 직원의 이름과 입사일을 조회.
SELECT name as 이름,
		start_date as 입사일
FROM emp
where start_date >= '1995-01-01'; 

-논리 연산자
연봉이 2400보다 많고, 1995년 이전에 입사한 직원의 이름과 입사일과 급여를 조회
 > SELECT name as 이름,
 		  start_date as 입사일,
 		  salary as 급여
   FROM emp
   where salary > 2400
   	 and start_date < '1995-01-01'; 

-IN 연산자
부서 번호가 110, 112, 118에 속한 사원의
이름, 부서 번호, 이메일 조회
 > SELECT name as 이름,
 		  dept_id as 부서 번호,
 		  mailid as 이메일
   FROM emp
   where dept_id in('110', 112, 118);
//쿼리는 공백문자 기준으로 구분,
//별칭이나 기타 내용을 명시할 때 묶어라.

- like 연산자
 %: 여러개의 문자열
 _: 하나의 문자

1995년에 입사한 직원의 이름, 연봉을 조회
 > SELECT name as 이름,
 		  salary as 연봉
   FROM emp
   where start_date like '1995%';
   //산술 연산자로 변환
   where start_date >= '1995-01-01';
   	 and start_date <= '1995-12-31';

MySQL 함수 
- UCASE, UPPER 
부서 번호가 110인 직원의 이메일을 대문자로 조회
 > SELECT UCASE('mysql'), LCASE('MYSQL');
 > SELECT name as 이름,
 		  mailid as 이메일
   FROM emp
   where dept_id = 110;

- LCASE, LOWER

SELECT uscase(concat(name, ' ', mailid))
FROM emp;

- LCASE, LOWER
 > SELECT LCASE('HELLO MYSQL');

- substring
 > SELECT substring('hello mysql', 2, 7);
 //2번째 문자부터 7개를 잘라라.
 > SELECT substring('hello mysql', 2, 3);
 //2번쨰 문자부터 3대를 추출해라.
 입사일이 1995년인 직원의 이름, 입사(월,일)을 조회

- LPAD, RPAD
 > SELECT LPAD('oh', s, '*');
_ _ _o h 의 빈공간을 *
 > SELECT RPAD('yes', 7, '@');
y e s _ _ _ _ 의 빈공간을 @

직원의 급여를 조회하되, 4자리 기준으로 빈 공간은 * 표시
조회 결과는 이름, 급여를 나타내라.
 > SELECT name as 이름,
 		  LPAD(salary, 4, '*') as 급여
   FROM emp;

- TRIM, LTRIM, RTRIM
 > SELECT LTRIM('	coffee	') as 왼,
 		  RTRIM('	court	') as 오;

 > SELECT name as 이름,
 		  TRIM(LEADING '*'					 //2.*을 모두 자른다.
 		  FROM LPAD(salary, 5, '*')) as 급여 //1.LPAD에서 *로 채운것을
   FROM emp;
//	*로 빈공간을 채운 LPAD로부터 *을 읽어라!
//  그리고 TRIM 해라.
// TRIM(LEADING ...): 왼쪽에서 읽어들여라.
// TRIM(TRAILING ...): 오른쪽에서 읽어들여라.


 > SELECT TRIM(BOTH '*' FROM '***abc***') as A,
 		  TRIM(BOTH '*' FROM '****bcd**') as B,
 		  TRIM(BOTH '*' FROM '*12abcd**') as C,
 		  TRIM(BOTH '*' FROM '*****de**') as D;

  // TRIM(BOTH ... ) : 양쪽에서 읽어들여라.

// MySql Interactive Mode
// 문자형은 왼쪽 정렬로 출력
// 숫자형은 오른쪽 정렬로 출력
 > SELECT name AS 이름,
 		  CAST(TRIM(TRAILING '*'
 		  	FROM RPAD(salary, 10, '*')) as unsigned) AS 급여
 	FROM emp;

 - ABS(): 절대값 함수
  > SELECT ABS(100) as '100',
  		 ABS(-100) as '-100';

 - MOD(n,m): n을 m으로 나눈 나머지
  > SELECT MOD(123, 4),
  		   MOD(27, 3),
  		   (27 % 3)
  		   ;

 - FLOOR(n): n보다 크지 않은 정수를 반환
 				(소수점 내림)
 - CEILING(n): n보다 작지 않은 정수를 반환
 				(소수점 올림)

 > SELECT FLOOR(3.14), FLOOR(-3.14),
 		  CEILING(3.14), CEILING(-3.14)
 		  ;

 - ROUND(n): n에 가까운 정수를 반환
 				(소수점 반올림)
 > SELECT ROUND(3.14), ROUND(3.68),
 		  ROUND(-3.14), ROUND(-3.68)
 		  ;

- POW(n, m): n의 m제곱 승 반환
> SELECT POW(2,5), POW(2,-5);
//		2^5				2^-5

- SIGN(n): 부호 정보를 반환
//음수면 -1, 0이면 0, 양수면 1
> SELECT SIGN(3.14), SIGN(-3.14), SIGN(0);

- GREATEST(n, m, ...) 
//인자 중 가장 큰 값을 반환
- LEAST(n, m, ...)
//인자 중 가장 작은 값을 반환
> SELECT GREATEST(3.14, 5, 2) as GREATEST,
		 LEAST(3.14, 5, 2) as 'LEAST'
		 ;

//실수의 포함인 경우 실수형으로 비교한다.
> SELECT GREATEST('a', 'A', 'B') as 'GREATEST',
		 LEAST('a', 'A', 'B') as 'LEAST';
//아스키 코드의 크기 기준이 아니다.

- CURDATE(), CURRENT_DATE
		: 오늘 날짜를 반환
 > SELECT CURDATE(), CURRENT_DATE;

- CURTIME(), CURRENT_TIME
 		: 현재 시간을 반환
 > SELECT CURTIME(), CURRENT_TIME;

- STSDATE(), NOW(), CURRENT_TIMESTAMP
		: 오늘 날짜와 시간을 반환
 > SELECT SYSDATE(), NOW(), CURRENT_TIMESTAMP;

 - DATE_FORMAT(DATE, FORMAT)
 		 : 입력된 날짜(DATE)를 원하는 형식(FORMAT) 반환
 > SELECT DATE_FORMAT(CURDATE(), '%Y %M %W')
 		  as '오늘의 날짜';
 > SELECT DATE_FORMAT(CURDATE(), '%y %m %w')
 		  as '오늘의 날짜';
 > SELECT DATE_FORMAT(CURDATE(), '%Y. %m. %d')
 		  as '오늘의 날짜';

- PERIOD_DIFF(m1, m2)
		: 두 날짜의 차이(달)을 반환
		: YYYYMM, YYMM
각 직원들의 근속월수를 조회
 > SELECT name as 이름,
 		  start_date as 입사일,
 PERIOD_DIFF(DATE_FORMAT(CURDATE(), '%Y%m'),
 			 DATE_FORMAT(start_date, '%Y%m'))
 			 as 근속월수
 FROM emp;

Q_1
SELECT name, title, salary, dept_id
FROM emp
WHERE dept_id IN(112,118) and salary>=1500 and salary<=4000
ORDER BY salary DESC;


Q_2
SELECT name, title, salary, dept_id
FROM emp
WHERE dept_id IN(112,118) and salary>=1500 and salary<=4000
ORDER BY salary DESC;

Q_3
SELECT name, title, salary
FROM emp
WHERE title like '%부장' and salary>=3000;

Q_4
SELECT name, title, salary
FROM emp
WHERE dept_id IN(112,113,117,118) and (title LIKE '%부장' OR title = '과장') and (salary BETWEEN 2300 AND 3000)
ORDER BY dept_id ASC;

Q_5
SELECT name, title, salary, start_date
FROM emp
WHERE (title Like '%부장' OR title Like '%과장') and start_date LIKE "19%-03-%";

Q_6
SELECT name, (salary*16)+1000 as 직원연봉
FROM emp;

Q_7
SELECT name, salary
FROM emp
WHERE 



SELECT name, title, salary
FROM emp
WHERE dept_id in (112, 113, 117, 118) and salary in (SELECT salary FROM emp WHERE title LIKE '%부장' OR title LIKE '%과장') and salary BETWEEN 2300 AND 3000
ORDER BY dept_id ASC;

- CAST(형 변환)
 > SELECT cast('123' as unsigned);
 //문자열 '123'을 부호 없는 정수로 변환
 > SELECT cast(1-2 as singed) as 'signed',
 		  cast(1-2 as unsinged) as 'unsigned'
 		  ;

//기본 연산을 BIGINT (8byte)


COUNT(expr): NULL이 아닌 row의 개수 반환
COUNT(DISTINCT, expr)
		: NULL 아닌 row의 개수 반환
		  (중복을 제외)
COUNT(*): row의 개수 반환 (NULL 포함)
AVG(expr): 평균 값을 반환
MAX(expr): 최대 값을 반환
MIN(expr): 최소 값을 반환
SUM(expr): 합계를 반환

부서 번호 111인 부서의 급여 합계와 평균을 조회
> SELECT SUM(salary), AVG(salary)
  FROM emp
  WHERE dept_id=111;

부서 번호 111인 부서의 인원 수를 조회
 > SELECT count(*)
   FROM emp
   WHERE dept_id = 111;


//SELECT 형태
SELECT(DISTINCT) [컬럼] (ALIAS) [별칭]
FROM     [테이블]
WHERE    [조건식]
GROUP BY [컬럼]
HAVING 	 [조건식]
ORDER BY [컬럼 or 표현식] (ASC, DESC)

급여가 2000이상인 사원의 이름과 급여를 조회
 > SELECT name as '이름',
 		  salary as '급여'
   FROM emp
   WHERE salary >= 2000
   GROUP BY title
   HAVING title = '사원';

직급별 직급, 평균 연봉, 인원 수를 출력하되,
급여가 1000이상인 직원만 구하도록
 > SELECT title as '직급', AVG(salary) as '평균 연봉', COUNT(*) as '인원 수'
   FROM emp
   WHERE salary >= 1000
   GROUP BY title;

직급별 부서 번호가 113인 직원의 평균 급여 조회
 > SELECT AVG(salary) as 평균급여
   FROM emp
   WHERE dept_id=113
   group by title;


Primary Key(PK): 기본키, 고유키, 유일키 테이블에서 유일하게 식별하기 위한 키
1. 중복할 수 없다.
2. NULL값을 허용하지 않는다.

Foregin Key(FK): 외래 키
1. 다른 테이블의 참조되는 기본 키(컬럼)

EQUIJOIN
employees 테이블과 dept_manager 테이블을 JOIN,
first_name,last_name ,from_date를 조회 

>select concat(employees.last_name, ''
   , employees.first_name
   )as name,
   dept_manager.from_date
   from employees, dept_manager
   where employees.emp_no = dept_manager.emp_no;

employees와 titles를 JOIN 하여 이름과 직책을 조회하시오

>select employees.first_name as first_name, employees.last_name as last_name,
  titles.title as 제목
  from employees,titles
  where employees.emp_no = titles.emp_no;



employees와 titles를 JOIN하여

이름과 직책을 조회
 > SELECT CONCAT(e.last_name
 				 , ' '
 				 , e.first_name
 				 ) AS '이름',
 		  t.title AS '직책'
   FROM employees e, titles t   	
   WHERE e.emp_no = t.emp_no;



- INNER JOIN
두 테이블 데이터의 교집합
> SELECT CONCAT(e.last_name
				, ' '
				, e.first_name
				) AS '이름',
		t.title AS '직책'
  FROM employees e 
  INNER JOIN titles t
  ON e.emp_no = t.emp_no;


 CROSS JOIN
 > SELECT CONCAT(e.last_name
 				, ' '
 				, e.first_name
 				) AS '이름',
 		 t.title AS '직책'
 	FROM employees e
 	CROSS JOIN titles t  
 	WHERE t.title = Staff;

NATURAL JOIN
EQUI JOIN과 동일
두 테이블의 동일한 이름을 가진 컬럼이 모두 조인
 //TODO
 > SELECT CONCAT(e.last_name
  				  , ' '
  				  , e.first_name
  				  ) AS '이름',
  		   d.dept_no AS '부서번호'
  	FROM   employees e, dept_manager d
  	WHERE e.emp_no = d.emp_no;
 
 > SELECT CONCAT(e.last_name
 				, ' '
 				, e.first_name
 				) AS '이름',
 		  d.dept_no AS '부서번호'
   FROM employees e
   NATURAL JOIN dept_manager d;

ON
> SELECT DISTINCT e.emp_no, e.hire_date
	FROM employees e
	JOIN titles t ON (e.emp_no = t.emp_no)
	JOIN dept_manager d ON (e.emp_no = d.emp_no);


employees, titles 두 테이블 조인하여
직원의 이름과 직책을 조회하되,
여성 엔지니어만 출력하라...
>
SELECT e.last_name, t.title
FROM employees e
NATURAL JOIN titles t
WHERE e.gender = 'F'
	AND t.title = 'Engineer'
LIMIT 20;

직원별 사번, 전체 이름, 부서를 조회
> SELECT e.emp_no, 
		 CONCAT(e.last_name
		 		, ' '
		 		, e.first_name
		 		) AS '이름',
		 d.dept_name AS '부서'
  FROM employees e 
  INNER JOIN departments d
  LIMIT 50;

직원별 사번, 전체 이름, 연봉을 조회

 > SELECT e.emp_no AS '사번',
 		  CONCAT(e.last_name
 		  		, ' '
 		  		, e.first_name) AS '이름'
 		  s.salary AS '연봉'
   FROM employees e, salaries s
   WHERE e.emp_no = s.emp_no
   	 AND s.to_date LIKE '9%' 
   LIMIT 30;

JOIN 

INNER JOIN
명시적 표현법
> SELECT e.first_name, t.title
  FROM employees emp e 
  INNER JOIN titles t 
  ON e.emp_no = t.emp_no;

묵시적 표현법
> SELECT e.first_name, t.title
  FROM employees e, titles t
  WHERE e.emp_no = t.emp_no;

CROSS JOIN (곱집합) 
> SELECT *
	FROM employees   //employees : 3
  CROSS JOIN titles: //titles : 4
// 3 * 4 의 총 12개의 row 조회

Cartesian JOIN
 - Cartesian Product
 - Join을 통해서 데이터를 얻어오는데,
   원하지 않게 모든 데이터를 얻어오는 경우
 - * 조건절을 이용하여 원하는 것만 JOIN

 NATURAL JOIN
  - 조인 조건없이 묵시적 연결
 > SELECT e.first_name, t.title
 	 FROM employees e
   NATURAL JOIN titles t;
//단점: 동일한 이름을 가진 컬럼 모두! JOIN

JOIN - USING
 - NATURAL JOIN의 단점을 보완
 - 특정 컬럼만 조인하고 싶을 때 USING(emp_no)
> SELECT e.first_name, t.title
 	FROM employees e
  NATURAL JOIN titles t USING(emp_no);

CROSS JOIN (곱집합)
> SELECT *
	FROM employees 		//employees : 3
	CROSS JOIN titles;  //titles : 4

OUTER JOIN (합집합) 
- FULL OUTER JOIN (UNION)
> SELECT e.emp_no
	FROM employees e 
  UNION ALL
  SELECT t.emp_no
  	FROM titles t
  LIMIT 30;

- UNION
  두 테이블의 동일한 컬럼을 조회
 1. 조회하고자하는 컬럼 일치
 2. 하나의 ORDER BY 사용
 3. 기본적으로 중복을 허용 하지 않는다.
 4. UNION ALL 중복값 포함 전부를 꺼내라 

- LEFT JOIN
왼쪽 테이블의 모든 결과를 가져오고,
오른쪽 테이블의 데이터들과 연결
연결되는 데이터가 없다면, NULL

> SELECT e.first_name, t.title
	FROM employees e
	LEFT JOIN titles t
	ON e.emp_no = t.emp_no
	LIMIT 30;

- RIGHT JOIN
오른쪽 테이블의 데이터를 가져오고,
왼쪽 테이블의 데이터와 연결
연결되는 데이터가 없다면, NULL을 채워준다.


Subquery
형태: 
	SELECT [컬럼]
	  FROM [테이블]
	 WHERE [연산자] ( SELECT [컬럼]
	 				   FROM [테이블]
	 				)

연산자
단일 서브쿼리 : =, >, <, >=, <=, <>
다중 서브쿼리 : IN, ANY, ALL, NOT IN

Fai Bale이 근무 하는 부서의
직원의 사번, 전체 이름 조회
 > SELECT e.emp_no AS '사번',
 		  CONCAT(e.first_name, ' ', e.last_name) AS '이름',
 		  d.dept_name AS '부서'
     FROM employees e, departments d, dept_emp de
    WHERE e.emp_no = de.emp_no
      AND de.dept_no = d.dept_no
      AND de.dept_no = (
      					SELECT dm.dept_no 
      					  FROM employees e, dept_emp dm
      					 WHERE e.emp_no = dm.emp_no
      					   AND CONCAT(e.first_name, ' ', e.last_name) = 'Fai Bale'
      					)
      LIMIT 30;

현재 급여가 80000 이상인 직원의 전체 이름 조회
 > SELECT e.emp_no, CONCAT(e.first_name, ' ', e.last_name) AS '이름'
 	 FROM employees e
 	WHERE e.emp_no = ANY(SELECT s.emp_no
 						   FROM salaries s
 						  WHERE salary >= 80000
 						  	AND to_date LIKE '9%')
 	LIMIT 30;

테이블 생성
create table [테이블] (
 [컬럼] [타입] [NULL or NOT NULL] [DEFAULT] [AUTO_INCREMENT]

 PRIMARY KEY(컬럼) 
);

CREATE TABLE member (
	no INT NOT NULL,
	email CHAR(50) NOT NULL,
	passwd CHAR(20) NOT NULL,
	name CHAR(25),
	departmentname CHAR(25),
	PRIMARY KEY(no)
);

테이블 수정

추가
ALTER TABLE [테이블]
  ADD [컬럼] [타입] ...
> ALTER TABLE member
	ADD age INT NOT NULL;

변경
ALTER TABLE [테이블]
CHANGE [컬럼] [타입] ...
> ALTER TABLE member
  CHANGE age addr VARCHAR(3);

테이블명 변경
ALTER TABLE [테이블] RENAME [변경 이름]
>ALTER TABLE member RENAME person;

데이터 삽입 
INSERT INTO [테이블] (컬럼1, ... , 컬럼4)
	   VALUES (컬럼1의 값, ... , 4의 값)
> INSERT INTO person
	   VALUES (1, 'abc', 'aaa', 'joon', 'hozen', 'H' );

데이터 변경
UPDATE [테이블]
   SET 컬럼1=컬럼의 값, ....
 WHERE [조건절]	//특정 row만 변경 가능!
> UPDATE person
	 SET passwd = '123'
   WHERE no=1;

데이터 삭제
DELETE FROM [테이블]
 WHERE [조건절]

DELETE FROM person
 WHERE no = 1;

컬럼 삭제
ALTER TABLE [테이블]
		DROP [컬럼];

> ALTER TABLE person
		 DROP addr;

테이블 삭제
DROPTABLE [테이블];
> DROP TABLE person;

CREATE TABLE t_board (
	no INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(20),
	writer VARCHAR(10),
	reg_data DATE,
	PRIMARY KEY(no)
	);


=========몽고 DB==========

mongod : 서버실행 
mongo  : 몽고 쉘 실행 