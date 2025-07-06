# 🗂️ 2주차 - Spring Data JPA
> Spring Data JPA를 이용하여 별도의 SQL 쿼리문 없이 IDOL DB를 생성후 로컬 MySQL을 연동해보자!

## 이론 설명
### JPA (Java Persistence API)
- Java 진영의 **표준 ORM 인터페이스 모음**
- ORM 개념을 구체화한 **스펙** (즉, ORM > JPA)
- 다양한 구현체들이 있음 (Hibernate, EclipseLink 등)

### ORM이란?
![image](https://github.com/user-attachments/assets/808dc45d-94cf-4afb-9cf2-2af2abeb4b23)
[사진 출처](https://hanamon.kr/orm%EC%9D%B4%EB%9E%80-nodejs-lib-sequelize-%EC%86%8C%EA%B0%9C/)

ORM은 **Object Relational Mapping**의 약자로,  
애플리케이션의 객체(예: Java 클래스)와 관계형 데이터베이스의 테이블을 **자동으로 매핑**해주는 기술임.

> 예: Java의 데이터 클래스 ↔ DB의 테이블 자동 매핑

---
### ORM의 역할
객체지향 프로그래밍과 관계형 데이터베이스 사이의 구조적 차이로 발생하는 **제약사항을 해결**함.

---
### ORM을 사용하는 이유
- **직관적인 코드로 DB 조작 가능**  
  → SQL 쿼리를 직접 작성하지 않고 객체 지향적으로 데이터 처리 가능  
  → 개발자는 **비즈니스 로직**에 집중 가능

- **재사용성과 유지보수 용이**  
  → 매핑 정보가 설계에 명확히 반영되어 DB 구조를 몰라도 개발 가능  
  → ORM 코드가 독립적이라 재사용이 쉬움

#### Hibernate
- JPA의 대표적인 **구현체**
- 가장 널리 사용되는 ORM 프레임워크 중 하나

#### Spring Data JPA
- Spring에서 JPA를 **더 편리하게 사용할 수 있도록 지원**
- 특징:
  - 인터페이스만 작성해도 CRUD 기능 자동 구현
  - 동적으로 구현 객체를 생성하여 주입
  - Repository 계층의 개발을 단순화

---
## 실습 과정 (POSTMAN)
### 1. 전체 조회 (GET 요청)
![image](https://github.com/user-attachments/assets/053119f3-db15-4ec1-91ac-6f559bcbc490)
- URL: `/api/idols`  
- 요청 방식: `GET`  
- 응답이 정상적으로 동작하면 `[]` (빈 배열) 또는 저장된 데이터 목록이 반환됨.

---
### 2. IDOL DB에 데이터 추가 (POST 요청)
![image](https://github.com/user-attachments/assets/c8125d37-e915-4f3e-b530-13b84d594f36)
- URL: `/api/idols/{/id}`  
- 요청 방식: `POST`  
- 응답이 정상적으로 동작하면 DB안 저장된 데이터 목록이 반환됨.

<img width="857" alt="image" src="https://github.com/user-attachments/assets/c360a205-94e2-4e94-837e-eb7fb8339a06" />

- MySQL 안 Idol_db 안에 정상적으로 값이 들어간 모습.

---
### 3. IDOL DB 데이터 수정 (PUT 요청)
![image](https://github.com/user-attachments/assets/be56a445-537e-4a09-a3eb-e5a8a823eb87)
- URL: `/api/idols/{/id}`  
- 요청 방식: `PUT`  
- 수정하고자 하는 아이돌의 id를 URL에 포함하고, Body에 변경할 데이터를 입력함.

<img width="857" alt="image" src="https://github.com/user-attachments/assets/bc6d1d56-e650-4b34-b154-93a45eb331d0" />

Idol_db 안에 ID(PK)에 해당하는 값이 존재하면 위와 같이 값이 수정되게 됨.

---
### 4. IDOL DB 데이터 삭제 (DELETE 요청)
![image](https://github.com/user-attachments/assets/4e3c5434-108a-483a-b436-7444c8bb61d2)
- URL: `/api/idols/{id}`
- 요청 방식: `DELETE`
- 삭제하고자 하는 아이돌의 id를 URL에 포함하여 요청을 보냄.

<img width="857" alt="image" src="https://github.com/user-attachments/assets/98fea4cb-6129-4bd4-abe1-5f3b50cbf3d6" />

해당 ID에 해당하는 데이터가 정상적으로 삭제된 것을 확인할 수 있음.

## 📌 참고 링크

- [한눈에 보는 ORM 정리 - hanamon.kr](https://hanamon.kr/orm%EC%9D%B4%EB%9E%80-nodejs-lib-sequelize-%EC%86%8C%EA%B0%9C/)
- [Spring Data JPA 공식 문서](https://spring.io/projects/spring-data-jpa)


