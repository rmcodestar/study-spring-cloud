## 들어가기 앞서

### 12 factor rule
* Codebase
    * One codebase tracked in revision control, many deploys
* Dependencies
    * Explicitly declare and isolate dependencies
* Config
    * Store config in the environment
* Backing service
    * Treat backing services as attached resources
* Build, release, run
    * Strictly separate build and run stages
* Processes
    * Execute the app as one or more stateless processes
* Port binding
    * Export services via port binding
* Concurrency
    * Scale out via the process model
* Disposability
    * Maximize robustness with fast startup and graceful shutdown
* Dev/prod parity
    * Keep development, staging, and production as similar as possible
* Logs
    * Treat logs as event streams
* Admin processes
    * Run admin/management tasks as one-off processes

### 스프링 클라우드의 기능
* 분산/버전 컨피규레이션
* 서비스 등록 및 디스커버리
* 라우팅
* 서비스 간의 호출
* 부하 분산
* 서킷 브레이커
* 분산 메시징


## Configuration
스프링 부트와 달리 스프링 클라우드는 원격의 저장소에서 컨피규레이션을 가져온다

부트스트랜 컨테스트 : 메인 애플케이션의 부모 `bootstrap.yml`을 사용한다
```yml
spring:
    application:
        name: person-service
    cloud:
        config:
            uri: http://127.0.0.1:8080
```


## 스프링 클라우드 넷플리스
* 유레카 (spring-cloud-starter-eureka) - 서비스 디스커버리
    * 클라이언트는 항상 애플리케이션의 일부로 원격의 디스커버리 서버에 연결하는 일을 한다.
    * 연결되면, 서비스 이름과 네트워크 위치를 담은 등록 메시지를 보낸다.
* 주울 (spring-cloud-starter-zuul) - 라우팅
    * JVM 기반의 라우터, 서버 측 분산과 일부 필터링을 수행한다
* 리본 (spring-cloud-starter-ribbon) - 부하 분산
    * TCP, UDP, HTTP등 프로토콜을 지원하며 동기방식의 REST 호출 뿐만 아니라 비동기 또는 리액티브 모델도 지원한다.
* 페인 (spring-cloud-starter-feign) - 선언적인 REST 클라이언트
    * 웹 서비스 클라이언트를 쉽게 작성하도록 도와준다.
* 히스트릭스 (sprnig-cloud-starter-hystrix) - 서킷 브레이커
    * 서킷 브레이커 시간 만료가 되었을 때 실행돼야 하는 폴백 로직을 쉽게 설정할 수 있다
* 아카이우스 - 컨피규레이션 관리
    * 변경 전의 원본을 가져오거나 변경사항을 클라이언트에 전달하는 방법으로 컨피규레이션을 갱신한다.
    
    
