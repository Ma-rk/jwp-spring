### 2. 서버가 시작하는 시점에 부모 ApplicationContext와 자식 ApplicationContext가 초기화되는 과정에 대해 구체적으로 설명해라.
- 설정파일을 통해 디펜던시 유효성 확인
- 부모 컨텍스트 생성
- 부모 컨텍스트에 의존성을 주입
- 자식 컨텍스트 생성


### 3. 서버 시작 후 http://localhost:8080으로 접근해서 질문 목록이 보이기까지 흐름에 대해 최대한 구체적으로 설명하라. - 리퀘스트 발생
- DispatchServlet을 통해 알맞은 controller 호출
- 내부 로직 수행(service, dao등)
- viewResolver를 통해 알맞은 model과 view를 전달
- 브라우저에서 화면 랜더링


### 9. UserService와 QnaService 중 multi thread에서 문제가 발생할 가능성이 있는 소스는 무엇이며, 그 이유는 무엇인가?
- UserService에 문제의 가능성이 있다.
- 기본적으로 싱글톤으로 작동하기 때문이다.
- @Scope("prototype") 어노테이션을 붙여줘서 해결할 수 있다.
