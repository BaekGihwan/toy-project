# 기본 프로젝트
이 프로젝트는 모든 프로젝트의 기본을 제공합니다.

## 기술 스택
- react 18.2.0
- typescript 4.9.5
- Spring boot 3.4.3
- storybook 7.6.10
- Mysql
- 
## 프로젝트 구조

```
.
├── app/
│   ├── api.py           # FastAPI 엔드포인트
│   ├── database.py      # 벡터 데이터베이스 관리
│   ├── semantic_search.py # 의미론적 검색 구현
│   ├── slack.py         # Slack 통합
│   ├── summary.py       # 문서 요약
│   ├── utils.py         # 유틸리티 함수
│   ├── qa_utils.py      # QA 관련 유틸리티
│   └── config.py        # 설정
├── chroma_db/           # 벡터 데이터베이스 저장소
├── static/             # 정적 파일
├── logs/               # 로그 파일
├── docs/               # 문서 저장소
└── requirements.txt    # 의존성 패키지
```
