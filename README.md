
# MTVS, Lounge Reservation 📖

## 🪑Intro: 서비스 소개
<br/>
<strong>MTVS, Reservation</strong>이란 메타버스 아카데미 학생들을 위한 라운지 예약 시스템으로,<br/>
온라인으로 편하게 예약하여 중복없이 사용할 수 있습니다.<br/>
추가로 메인페이지에 존재하는 게시판에서<br/>
학생들간의 소통이 가능하며, 불편사항 또한 접수받을 수 있는 서비스입니다.

<br/>

### ⭐️ Feat: 주요 기능 소개

#### 1) 라운지 예약 서비스
라운지를 이용하기 위한 예약 서비스를 제공하며 날짜별, 시간대별로 예약할 수 있습니다.
사용자에게 편의성을 제공합니다.

#### 2) 커뮤니티
게시판에서 사용자들끼리 각종 정보와 자유로운 게시글을 통해 자유로이 소통할 수 있으며,
불편게시판에서는 이용에 관한 불편사항을 제시하여 운영진들이 확인 후 피드백할 수 있는 환경을 제공합니다.

#### 3) 마이페이지
나의 정보를 확인할 수 있습니다.

<br/>
📅 <strong>프로젝트 기간</strong> : 2023.06.21 ~ 2023.06.28 (약 8일)


## 🛠 개발 환경

- Language  : Java 11 (OpenJDK 11.0.15.9-1)
- Front : Bootstrap(2.7.12)
- 형상 관리 : Github

[//]: # (여기는 참고용)
- Language  : Java (OpenJDK 8)
- DBMS : Oracle (11g)
- Server : Apache Tomcat (8.5)
- Front : HTML5, CSS3, JavaScript, jQuery, Bootstrap
- Server Programming : JSP/Servlet, AJAX
- Framework : Spring, MyBatis
- Build Tool : Maven
- IDE : Eclipse, Visual Studio Code, sqldeveloper
- Modeling Tool : StarUML, erdcloud, 카카오오븐
- 형상 관리 : Github
- API : Summernote, I'm port, Kakao sendLink, Naver login, Daum map

[//]: # (여기는 참고용)

<br>



## 🗂 Directory: 디렉토리 구조

```
/src/main
├── application                      사용자가 파일을 실행하면서 여러 로직들이 조합
│   ├── controller                   사용자의 요청을 받아 각 서비스에 전달, 응답을 뷰에 전달
│   ├── service                      도메인 서비스의 로직들을 조합하여 기능을 실행
│   ├── view                         사용자가 요청을 보내고 응답을 받는 화면. 여기서는 콘솔의 역할
├── domain                           Entity, Repository 관리 - DB 테이블과 entity를 1:1 매칭
│   ├── entity                       DB의 데이터를 조회하는 로직
│   ├── repository                   DB에 데이터가 저장되기 전에 검증하는 로직 및 테스트를 위해 초기화 하는 로직 구현
│   └── service                      각 객체의 개별적인 기능을 하는 로직
├── dto                              객체 정보 정의
├── infra                            #infra
└────── database                     데이터베이스
/src/test
└── test                             테스트코드 관련 설정 파일

``` 

## 테스트
```
1. Domain의 UserRepositoryTest        사용자의 이름을 입력받을 때 2~5글자 사이인지 확인.
                                      숫자, 특수문자 등이 들어갈 때 IllegalArgumentException 발생하는지 확인.
2. service의 MonsterCServiceTest      몬스터의 공격 성공 확률이 80%인지 확인.
3. service의 UserServiceTest          스톤의 갯수가 3 이상이면, 레벨이 오르는지 확인.
``` 

<br/>

`api` : 서버와의 통신을 위한 폴더입니다. axios를 활용한 작업을 주로 담당합니다.

`assets` : 컴포넌트를 구성하는 이미지파일들을 저장하기위한 폴더 입니다.

`components` : 페이지를 구성하는 컴포넌트들을 정리하기위한 폴더입니다.

`hooks` : 커스텀 훅을 정리하기 위한 폴더입니다.

`pages` : 서비스를 구성하는 페이지를 정리하기 위한 폴더입니다.

`redux` : 전역변수를 관리하는 store와 modules를 정리하기 위한 폴더입니다.

`shared` : 라우팅을 위한 폴더입니다. 서브라우터를 활용하여 더 세분화하여 정리하였습니다.

`utils` : 유용하게 쓸 수 있는 함수와 글로벌하게 적용되는 컴포넌트들을 관리하기 위한 폴더입니다.


## 📔 Architecture: 서비스 아키텍쳐

![Slice 4](https://user-images.githubusercontent.com/102432453/194732437-e582ef0a-5d9a-4772-8f46-95208a556585.jpg)

![image](https://user-images.githubusercontent.com/103619605/182366619-1c5ad67d-7b9d-4844-bcef-00ca75498f61.png)
<br>
<br>
<br>



## 📌 SW유스케이스
위키 - [USECASE](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki/USECASE)

![image](https://github.com/MTVS-CodeMagician/MTVS-reserve/assets/136250818/4b428dd6-c93c-4213-8d21-743f1d1681fc)
<br>
<br>
<br>


## 🧾 서비스 흐름도
위키 - [FlowChart](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki/Flow-Chart)

![image](https://github.com/MTVS-CodeMagician/MTVS-reserve/assets/136250818/a76c1027-3ade-4284-aec0-96be084f5995)
<br>
<br>
<br>

## 📊 E-R Diagram
위키 - [ERD](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki/ERD)

![MagicPot_ERD](https://user-images.githubusercontent.com/78246187/127444877-dda61529-a8ff-40ce-bb8b-bff21db3ea05.png) <br><br>

![image](https://user-images.githubusercontent.com/103619605/182579207-e5070ca5-2cde-43d1-94f7-5414a2d56a9f.png)
<br>
<br>
<br>

## ✅ 화면 구성

### 회원가입 / 메인화면 / 사용자 튜토리얼 화면
![image](https://user-images.githubusercontent.com/103620466/182588812-326be119-90cb-4264-b3f1-bb7eb059888f.png)
<br>
<br>

### 매장 보기 화면 (전체 매장 / 카테고리 선택 / 매장명 검색)
![image](https://user-images.githubusercontent.com/103620466/182589092-43fdf433-026b-47da-9d48-a5c5105ecdf3.png)
<br>
<br>

### 커뮤니티 게시판 화면 / 리뷰 등록 / 리뷰 수정
![image](https://user-images.githubusercontent.com/103620466/182589351-00081d31-ca43-4193-9fb2-23fa1b506990.png)
<br>
<br>

### 등급 시각화 / 리워드 화면 / 신규 매장등록 화면
![image](https://user-images.githubusercontent.com/103620466/182589764-d97e7c59-957b-47aa-a884-1e62ba9cd57d.png)
<br>
<br>
<br>

<br>


### 게시판
![image](https://github.com/MTVS-CodeMagician/MTVS-reserve/assets/136250818/717be6ad-d808-4748-88a5-3befa06b5697)

## 게시판2
![image](https://github.com/MTVS-CodeMagician/MTVS-reserve/assets/136250818/26e9f513-535e-4517-bde2-635924ccaddd)

<br>
<br>
<br>



## 💻 팀원 소개


| 이름                                                           | 포지션    | 담당 기능 구현          |
|--------------------------------------------------------------|--------| ----------------------------------------|
| <a href="https://github.com/jinvvoo" target='_blank'>김진우</a> | `서버개발` | `커뮤니티 게시글 및 댓글 CRUD, 무한스크롤, 좋아요 기능` `모임 소통의장 CRUD`| 
| <a href="https://github.com/jinvvoo" target='_blank'>김태현</a> | `서버개발`   | `메인 페이지` `데일리 미션` `뱃지 시스템` `마이 페이지` `제로샵(온라인)` `구글 로그인` `자동 배포`| 
| <a href="https://github.com/jinvvoo" target='_blank'>전태현</a> | `서버개발`   | `모임 페이지` `모임 CRUD` `카카오로그인` `제로샵(오프라인)` | 
| <a href="https://github.com/jinvvoo" target='_blank'>정민호</a> | `서버개발`   | `커뮤니티 댓글 CRUD` `모임 좋아요 및 태그조회` `커뮤니티 태그조회` `모임후기 CRUD` `커뮤니티, 모임 검색`| 
| <a href="https://github.com/jinvvoo" target='_blank'>진용민</a> | `서버개발`   | `커뮤니티 댓글 CRUD` `모임 좋아요 및 태그조회` `커뮤니티 태그조회` `모임후기 CRUD` `커뮤니티, 모임 검색`| 

<br>

<table>
  <tr>
    <td align="center"><img src="https://item.kakaocdn.net/do/fd49574de6581aa2a91d82ff6adb6c0115b3f4e3c2033bfd702a321ec6eda72c" width="100" height="100"/></td>
    <td align="center"><img src="https://mb.ntdtv.kr/assets/uploads/2019/01/Screen-Shot-2019-01-08-at-4.31.55-PM-e1546932545978.png" width="100" height="100"/></td>
    <td align="center"><img src="https://www.rcreplicas.co.kr/shopimages/rcreplicas/0540030004873.jpg?1662014818" width="100" height="100"/></td>
    <td align="center"><img src="https://i.pinimg.com/236x/ed/bb/53/edbb53d4f6dd710431c1140551404af9.jpg" width="100" height="100"/></td>
    <td align="center"><img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fpost.phinf.naver.net%2FMjAxOTA1MTZfMTk5%2FMDAxNTU3OTM3Nzk5OTc2.RYHaYoOO6PJpy1jJB3aphq0xufqtFmXAKcbUrxRIoyIg.hRUVOlJAPZf8GvyovPIkDmhC6ZqhIF5pKkibnDTCBKYg.JPEG%2FIAGU9C6_iwxod_Z2Q7dYWNGdnGx4.jpg&type=sc960_832" width="100" height="100"/></td>
  </tr>

  <tr>
    <td align="center"><a href="https://github.com/Chaeyuny" target='_blank'>김진우</a></td>
    <td align="center"><a href="https://github.com/hyunUChoi" target='_blank'>김태현</a></td>
    <td align="center"><a href="https://github.com/run-acorn" target='_blank'>전태현</a></td>
    <td align="center"><a href="https://github.com/3susu3" target='_blank'>정민호</a></td>
    <td align="center"><a href="https://github.com/CodeJugller" target='_blank'>진용민</a></td>
  </tr>

  <tr>
    <td align="center"><b>서버개발</b></td>
    <td align="center"><b>서버개발</b></td>
    <td align="center"><b>서버개발</b></td>
    <td align="center"><b>서버개발</b></td>
    <td align="center"><b>서버개발</b></td>
  </tr>

</table>


<br>


## 📌 Trouble Shooting: 트러블 슈팅

<details> <summary>➡️ 😛김민석: 새로고침시 데이터가 안불러와지는 문제가 있었습니다. </summary> <div markdown="1">
  <br/>

**`문제원인`**
* 인터셉터를 사용하기에 토큰이 자동으로 담겨 서버에 요청을 보내는 줄 알았는데 새로고침을 할 경우 인터셉터가 실행되기전에 요청을 보내고 있었습니다. [개발자도구]의 [네트워크]에서 로그를 보고 토큰이 담겨지지 않은 것을 확인할 수 있었습니다.

**`해결방안`**
* useEffect를 통해 axios인스턴스를 실행시켜 데이터를 불러왔었는데, 인스턴스가 실행되기전에 sessionStorage.setItem으로 토큰을 담는 코드를 작성해주었습니다.

**`자세한 내용`**
* [React | 새로고침시 데이터가 안불러와지는 문제](https://velog.io/@shackstack/React-%EC%83%88%EB%A1%9C%EA%B3%A0%EC%B9%A8%EC%8B%9C-%EB%8D%B0%EC%9D%B4%ED%84%B0%EA%B0%80-%EC%95%88%EB%B6%88%EB%9F%AC%EC%99%80%EC%A7%80%EB%8A%94-%EB%AC%B8%EC%A0%9C)


  </div>
  </details>

<details> <summary>➡️ 🥸오정진: React slick 각 자식요소에 Margin 및 Padding css 설정이 안 되는 이슈를 발견하였습니다. </summary> <div markdown="1">
  <br/>

**`문제원인`**
* 라이브러리 특성상 기본적으로 설정되어 있는 css 파일들이 있기에, 기존의 설정되어 있는 css가 우선적으로 선언되어 내가 선언하는 css가 적용이 되지 않는 문제를 발견하였습니다.


**`해결방안`**
* react slick build시 사용되는 slick.css와 slick-theme.css를 따로 빼와서 margin과 padding default 값을 삭제 해, 원하는 대로 css 수정을 가능하게 변경하였습니다.

  </div>
  </details>
 
<br>

# Wiki
### [Home](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki)

### 프로젝트 세부 사항
* [Notion] <br>
* [Testcode] <br>
* [API] <br>

### 협업
* [ProjectBoard] <br>
* [깃플로우](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki/%EA%B9%83%ED%94%8C%EB%A1%9C%EC%9A%B0) <br>

### 적용 기술 및 전략
* [USECASE](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki/USECASE)
* [ERD](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki/ERD)
* [Github-Flow](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki/Github-Flow)
* [Flow-Chart](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki/Flow-Chart)
* [Figma](https://github.com/MTVS-CodeMagician/MTVS-reserve/wiki/Figma)
