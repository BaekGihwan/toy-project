# 토이프로젝트 
이 저장소는 다양한 기술 스택을 경험하고 학습하기 위해 만들어진 토이 프로젝트 입니다.  
프론트엔드, 백엔드, 데이터베이스, CI/CD 등 여러 분야의 예제와 실습 코드를 포함합니다.

## 🛠️기술 스택
- 프론트엔드 : React, TypeScript, StoryBook
- 백엔드 : Spring boot, JPA
- 데이터베이스 : MySql
- 기타 : 

## 📁프로젝트 구조

```
.
├── backend/                                 # 백엔드(Spring Boot) 소스 코드
│   └── src/
│       └── main/
│           └── java/project/backend/api/
│               ├── common/                 # 공통 설정 및 상수
│               │   ├── config/             # 프로젝트에서 사용하는 설정  정의
│               │   └── constants/          # 프로젝트에서 사용하는 상수 정의
│               ├── lotto/                  # 로또 도메인 관련 코드
│               │   ├── controller/         # API 컨트롤러
│               │   ├── domain/             # 엔티티 및 도메인 모델
│               │   ├── sdo/                # DTO/SDO 객체
│               │   └── service/            # 서비스 계층
│               │       ├── crud/           # crud를 담당하는 서비스 
│               │       ├── flow/           # 복잡한 비즈니스 플로우 처리 서비스
│               │   └── store/jpa/          # JPA 기반 데이터 저장소
│               │       ├── jpo/            # JPA Entity 클래스 (DB 매핑용)
│               │       ├── reposiroty/     # JPA Repository 인터페이스 (DB 접근)
│               └── Application.java        # 스프링 부트 진입점
│       └── resources/                      # 백엔드 리소스(설정 등)
│   └── test/java/project/backend/api/      # 백엔드 테스트 코드
│   └── build.gradle                        # 백엔드 Gradle 빌드 파일
├── frontend/                               # 프론트엔드(React 등) 소스 코드
│   └── public/                             # 정적 파일을 저장하는 폴더
│   └── src/                                # 소스 코드가 위치하는 폴더
│       └── features/                       # 각 기능(Feature)별로 코드 분리
│           └── lotto                       # 로또 관련 기능 폴더
│               └── page/                   # 페이지 단위 코드
│                   └── main/               # 메인 페이지 관련 코드
│   └── page/                               # 메인페이지 폴더
├── build.gradle                            # 루트 Gradle 빌드 파일
└── settings.gradle                         # 루트 Gradle 셋팅 파일
```
## 🚀 주요 기능

- **React 기반 UI** 및 Storybook을 통한 컴포넌트 관리  
- **Spring Boot** 및 JPA 기반 백엔드 서비스  
- **MySQL** 연동 및 데이터 관리  
1. **로또 Feature**
   - 회원가입 및 로그인 (JWT 인증)
   - 로또 번호 자동 추천 및 저장
   - 지난 회차 로또 당첨 결과 조회
   - 당첨 번호 통계 분석
   - 관리자 전용 대시보드
   - RESTful API 제공
   - 반응형 UI 지원

2. **모립 Feature**
   - 재작 중

## ⚙️설치 및 실행

#### 1. 레포지토리 클론

```
bash
# 디렉토리 이동 cd my-folder 
# git clone https://github.com/BaekGihwan/toy-project.git
```

#### 2.프론트엔드 실행
```
bash
# 디렉토리 이동 cd my-folder/frontend
# npm instrall
# npm start
```
#### 3. 데이터베이스 준비
MySQL 환경 구성 필요

## 📄문서
제작 중

## 📬기여
이 프로젝트는 학습 및 실험 목적의 토이 프로젝트입니다.
이슈 및 PR 환영합니다!

## 📝라이선스
없음
