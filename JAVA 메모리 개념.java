Java Source : 사용자가 작성한 JAVA 코드
Java Compiler : Java 코드를 바이트 코드로 변환

	Class Loader
		- JVM내에 Class Load
		- 연결을 통해 적절히 배치하는 작업 (linking)
		- Runtime 시 동적으로 읽어드려 배치
		
		
	Execution Engine
		- Class Loader를 통해 JVM 내의 바이트 코드를 실행
		- 명령어 단위로 실행
		
	Runtime Data Area
		- JVM이 OS위에서 실행되면서 위해 할당받은 메모리 영역
		- Method Area, Heap, JAVA Stack, PC Registers,
			Native Method Stack Area, Constant Pool
		
	
	Method Area
		- 클래스 정보, 멤버변수 정보, static 메소드와 필드 정보,
			static 변수 정보, 바이트 코드 등을 보관
		- 모든 쓰레드에서 공유
		- GC의 대상 (선택)
		- JVM 시작 시 생성되며, 프로그램 종료 시 해제
		
	Heap Area
		- 데이터를 저장하기 위해 동적으로 할당하여 사용하는 메모리
		- new 연산자로 생성된 객체 또는 인스턴스와 배열을 저장
		- 자동 초기화
		- GC의 대상
		
	Stack Area
		- 메소드 호출 시 데이터 영역이 생성
		- 지역변수, 매개변수, 임시변수, 레퍼런스 변수
		- 연산 중 발생하는 임시 데이터 저장
		- { } 또는 메소드가 끝날 때 해제
		- 자동 초기화 되지 않음
	
	PC Registers
		- 현재 수행 중인 JVM의 명령 주소 저장
		- CPU에서 명령어를 수행하면 CPU는 수행하는 동안 필요한 정보를 CPU내의 기억장치(Register)에 저장
		- 연산 결과값을 전달하기 전에 저장하는 CPU내의 기억장치
		
	Native Method Stack Area
		- JAVA외의 언어로 작성된 Native 코드를 위한 Stack 공간
		- JNI(Java Native Interface)를 통해 호출되는 C/C++ 등의 코드를 수행하기 위한 Stack
		- 타 언어의 매개변수, 지역변수 등.. 을 저장
		
	Constant Pool
		- 클래스나 인터페이스의 상수, 메서드, 필드 등에 대한 레퍼런스
		- 실제 메모리상 주소를 찾을 때 참조하는 영역