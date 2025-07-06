package com.example.idol_db.idol.entity

import com.example.idol_db.idol.dto.IdolResponseDto
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Idol (
    //pk 식별자
    @Id
    //pk 생성전략 (AUTO, IDENTITY, SEQUENCE, TABLE)
    /**
     * AUTO : JPA 구현체에 따라 적절한 전략을 자동으로 선택합니다.
     * IDENTITY : 데이터베이스의 자동 증가 기능을 사용합니다.
     * SEQUENCE : 데이터베이스 시퀀스를 사용하여 키를 생성합니다. (사용자가 직접 전략을 정해놓은 것)
     * TABLE : 별도의 테이블을 키 생성에 사용합니다.(보통 Sequence Object를 지원하지 않는 데이터베이스에서 Sequence 전략처럼 사용하고 싶을 때 사용할 수 있는 전략입니다.
     * 이는 키 생성 전용 테이블을 별도로 하나 만들어서 데이터베이스 시퀀스 오브젝트를 흉내내는 역할)
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,
    @Column(nullable = true)
    var name : String,
    @Column(nullable = true)
    var age : Int,
    @Column(nullable = true)
    var groupName : String?,
) {
    fun toResponse() : IdolResponseDto = IdolResponseDto(
        id = id,
        name = name,
        age = age,
        groupName = groupName ?: "없음"
    )
}