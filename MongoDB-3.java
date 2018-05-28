[Geometry]

for(var i=0; i<100; i++)db.spatial.insert({pos:[i%10, Math.floor(i/10)]})

db.spatial.insert({pos:[i%10,Math.floor(i/10)]})
db.spatial.find()
db.spatial.createIndex({pos:"2d"})
		//pos 필드를 2d 좌표형식으로 인식, (indexing)

$near : 좌표 기준으로 근처 좌표
 : db.spatial.find({pos:{$near:[5,5]}},{_id:0,pos:1}).limit(8)
 		//좌표 [5,5] 기준으로 가장 근처 좌표 표시

$center: 좌표 기준으로 범위 내의 "원"에 있는 좌표
$within: 범위 내의 자료들을 포함할 때
: db.spatial.find({pos: {$within: {$center:[[5,5],2]}}},{_id:0})
		//좌표 [5,5] 기준으로 크기 "2"내의 반경

$box: 좌표를 시작으로 주어진 좌표까지 박스를 그리고, 그안에 포함된 모든 좌표를 검색
db.spatial.find({pos:{$within:{$box:[[5,5],[7,7]]}}},{_id:0})
//좌표 [5,5]를 시작으로 끝인 [7,7]까지 박스 그림 내 

$polygon
db.spatial.find({pos:{$within: {$polygon:[[3,3],[5,7],[7,4]]}}})

1.건대 입구: 37.540580, 127.069214
2.양재역: 37.484323, 127.034358
3.대전 둔산은하수 아파트: 36.349634, 127.379507
4.답십리역: 37.566839, 127.052606
5.디지털 미디어 시티역: 37.577967, 126.892090
6.제주국제공항: 33.510566, 126.491332
7.서경대학교: 37.615299, 127.013025
8.동국대학교: 37.557656, 127.000818
9.강동역: 37.535991, 127.132208
10.신설동역: 37.575411, 127.024817


Q1. find() 좌표 기준으로 30마일 내 통화기록 찾기
//데이터 생성
db.tel_pos.save({mobile_no:"01023364545",
    last_pos:[
        [37.566839,127.052606],
        [37.577967,126.892090],
        [33.510566,126.491332]
    ]
})
db.tel_pos.save({mobile_no:"01023366545",
    last_pos:[
        [37.615299,127.013025],
        [37.557656,127.000818],
        [37.535991,127.132208]
    ]
})

//인덱스 부여
db.tel_pos.createIndex({last_pos:"2d"})

db.tel_pos.find(

	)

Q2. 해당하는 기준점을 중심으로 떨어진 위치 찾기
db.position.createIndex({loc:"2dsphere"}) //2d 형태 좌표 인덱스

db.position.insert({
	_id:"m239098",
	datatype:NumberLong(1),
	loc : {
		type:"Point"
		coordinates:[127.1058431, 37.5164113]},
		pos_name: ["name=잠실 2호선", "trans_ytpe=지하철"]
	}
})

Q.WORK. 비트 기준으로 4KM 내에 어떤 시설물이 있는지 검사

37.494609, 127.027604 -> 기준좌표 (비트빌)



127.027085, 37.495294 CU

127.030869, 37.495240 GS

127.029348, 37.495563 세븐일레븐

127.028250, 37.493110 CU

127.005537, 37.486390 동우 유치원

127.008625, 37.490949 현대 ESA 2차

127.099201, 37.505501 원각사

126.988043, 37.569958 종로 버거킹

126.962380, 37.393048 평촌 CGV

{

name:"CU"

pos:[

[127.027085, 37.495294],

[127.028250, 37.493110]

]

}

{

name:"GS"

pos:[
[127.030869, 37.495240]
]
}

[DBRef]
o = db.ord.insert({
	ord_id: "2018-05-25-1234",
	customer_name: "Bit Academy",
	emp_name: "COLD BREW",
	total: "5500",
	payment_type:"cash"	
})

db.employees.findOne({job:"CLERK"})

db.ord_detail.insert({
	ord_id : o.ord_id,
	item_id : [
	{
		item_id : "1",
		product_name : "Monami",
		item_price : 500,
		qty : 100,
		price : 50000
	},
	{
		item_id : "2",
		product_name : "A4",
		item_price : 50,
		qty : 100,
		price : 5000
	}
	],
	order_id:[new DBRef("ord",o._id)]
})

//PK의 역할, ord_id 보다 더 빠르다.
//인덱스로만 이루어진 객체
db.ord_detail.findOne()

//ObjectId를 이용한 주문 상세 검색
db.ord_detail.find({order_id:o._id})
db.ord_detail.find({ord_id:o.ord_id})


[집계 연산]
$sum 			: 그룹 별 데이터의 총합 구하기
>> db.employees.aggregate([
	{$group : {_id : "$deptno", sal_sum : {$sum : "$sal"}}}
])

$avg 			: 그룹 별 데이터의 평균 구하기
>> db.employees.aggregate([
	{$group : {_id : "$deptno", sal_avg : {$avg : "$sal"}}}
])

$min 			: 그룹 별 데이터의 최솟값 구하기
>> db.employees.aggregate([
	{$group : {_id : "$deptno", sal_min : {$min : "$sal"}}}
])

$max 			: 그룹 별 데이터의 최댓값 구하기
>> db.employees.aggregate([
	{$group : {_id : "$deptno", sal_max : {$max : "$sal"}}}
])

$push 			: 그룹 별 데이터의 배열 만들어 내기
db.employees.agrregate({
	{$group :{_id:"$deptno", sal_push_array:{$push:"$sal"}}}
})

$addToSet 		: 그룹 별 데이터의 배열 만들어 내기 (중복 제거)
db.employees.aggregate({
	{$group: {_id:"$deptno", sal_add_to_set_array:{$addToSet:"$sat"}}}
})

$first			: 가장 처음에 존재하는 도큐먼트 내용 선택
db.employees.aggregate({
		{$group:{_id:"$deptno", emp_first:{$first:"$ename"}}}
})

$last 			: 가장 마지막에 존재하는 도큐먼트 내용 선택
db.employees.agrregate({
	{$group:{_id:"$deptno", emp_last:{$last:"$ename"}}}
})

[$lookup]

//employees와 link를 하기 위한 동일 필드가 존재하는 컬렉션 생성
db.dept.insert({deptno:10, dname:"전산실", loc:1})
db.dept.insert({deptno:20, dname:"영업팀", loc:2})
db.dept.insert({deptno:30, dname:"관리팀", loc:1})
db.dept.insert({deptno:40, dname:"인사팀", loc:3})

//SQL 비교
SELECT emp.empno, dept.name
  FROM emp,dept
 WHERE emp.deptno = dept.deptno
 

db.employees.aggregate([
	{$match: {deptno:10}},			//10번 부서에서 
	{$project: {empno:1, ename:1, job:1, deptno:1}},
	{$lookup : {
		from : "dept",				//dept 테이블에서 
		localField : "deptno",		//employees.deptno와
		foreignField : "deptno",	//dept.deptno를 JOIN
		as: "dept_info"				//배열 형식의 필드로 OUTPUT

	}
	},
	{$unwind: "$dept_info"},		//dept_info 필드에 있는 배열을 풀어서
	{$lookup: { 					//각각 다른 도큐먼트로 만들어라
		from : "location",
		localField : "dept_info.loc",
		foreignField : "loc",
		as: "local_info"
	}}
	])

//dept와 link 하기 위한 동일 필드 loc를 가진 컬렉션 생성
db.location.insert({loc:1, loc_name:"서울"})
db.location.insert({loc:2, loc_name:"대전"})
db.location.insert({loc:3, loc_name:"대구"})
db.location.insert({loc:4, loc_name:"부산"})

db.unwind: 배열을 풀어서 도큐먼트로 쪼개라
db.unwind.insert({_id:"1", name:"비트", array:["A","B","C"]})
db.unwind.aggregate([{$unwind:"$array"}])


[Rich Document]
 : Embedded Document, Extent Document
 장점: Query 단순, JOIN이 필요 없기 때문
 		데이터 저장에 효과적,
 		빠른 성능 보장
 단점: Embedded가 되는 도큐먼트가 없다면 적합하지 않다.
 	   Embedded Document는 16mb 제한되어 있다.

강한 관계에서는 유리, 약한 관계에서는 불리하다.

[Embedded Document] : 문서안에 문서가 존재하는 형태

db.order.insert({
		ord_id : "2018-05-25-01234",
		customer_name : "BIT",
		emp_name : "HELLO",
		total : "55000",
		payment_type : "Cash",
		item_id:[
		{
			item_id :"1",
			product_name:"monami",
			item_price:500,
			qty:100,
			price:50000
		},
		{
			item_id : "2",
			product_name : "Monami",
			item_price : 50,
			qty : 100,
			price : 5000
		}
		]
	})

[Extent Document]
db.board.insert({
	bidx:31,
	title:"abcd",
	contents:"aaa",	
	userid:1,
	writedate:"18/05/25" ,
	moddate:"18/05/25",
	cnt:1,
	system_name : [{
		system_name:"FILE1.TXT",
		Original_name:"FILE.TXT",
		path:"C:\User\abc\bit...",
		file_size:5021,
		file_type:".TXT",
		down_date:"18/05/25",
		downcnt: 0
	},{
		system_name:"FILE2.TXT",
		Original_name:"FILE.TXT",
		path:"C:\User\abc\bit...",
		file_size:5021,
		file_type:".TXT",
		down_date:"18/05/22",
		downcnt: 2
	},{
		system_name:"FILE3.TXT",
		Original_name:"FILE.TXT",
		path:"C:\User\abc\bit...",
		file_size:5021,
		file_type:".TXT",
		down_date:"18/05/18",
		downcnt: 4
	}
	]
})

db.board.insert({
	bidx:27,
	title:"111",
	contents:"111",
	userid:1,
	write_date:"18/05/25",
	mod_date:"18/05/25",
	cnt:0,
	board_kind:"A"
})

db.board.update({bidx:27},
	{$set:{system_name:[
		{system_name:"update1",
		original_name:"update",
		path:"C:\User\abc\bit...",
		file_size:500,
		file_type:".image\jpg",
		down_date:"18/05/25",
		downcnt:3},
		{system_name:"update2",
		original_name:"update",
		path:"C:\User\abc\bit...",
		file_size:500,
		file_type:".image\jpg",
		down_date:"18/05/25",
		downcnt:3},
		{system_name:"update3",
		original_name:"update",
		path:"C:\User\abc\bit...",
		file_size:500,
		file_type:".image\jpg",
		down_date:"18/05/25",
		downcnt:3}]}})