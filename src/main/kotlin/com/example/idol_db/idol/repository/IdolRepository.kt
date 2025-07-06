package com.example.idol_db.idol.repository

import com.example.idol_db.idol.entity.Idol
import org.springframework.data.jpa.repository.JpaRepository

//스프링 데이터 JPA를 사용하려면 JpaRepository를 상속받은 공용 인터페이스만 생성하면 됨.
//공용 인터페이스 <T, ID> T : 엔티티 타입, ID는 식별자 타입(PK)
interface IdolRepository : JpaRepository<Idol, Long>