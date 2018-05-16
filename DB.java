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