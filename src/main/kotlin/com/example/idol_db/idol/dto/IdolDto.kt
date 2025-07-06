package com.example.idol_db.idol.dto

import com.example.idol_db.idol.entity.Idol

/**
 * toEntity() 요청 데이터를 DB 저장용 객체로 변환
 * toResponse()	DB 데이터를 응답용 형태로 변환
 *
 * 클라이언트로부터 받은 데이터를 그대로 DB에 저장하면 보안 문제나 무결성 문제 발생 가능.
 * DB에서 꺼낸 Entity에는 사용자에게 보여주면 안 되는 정보가 있을 수 있음. (예: 비밀번호, 내부 ID 등)
 *
 * toEntity()와 toResponse()를 사용하는 이유는 계층 간 역할 분리를 명확히 하기 위해서
 *
Entity = 원본 데이터 저장고
Dto = 사용자와 주고받는 택배 상자
toEntity() = 포장 풀기
toResponse() = 포장해서 보내기
**/

data class IdolRequestDto (
    val id : Long,
    var name : String,
    var age : Int,
    var groupName : String?,
){
    fun toEntity() : Idol = Idol(
        id = id,
        name = name,
        age = age,
        groupName = groupName
    )
}

data class IdolResponseDto (
    val id : Long,
    var name : String,
    var age : Int,
    var groupName : String,
){
    fun toResponse() : Idol = Idol(
        id = id,
        name = name,
        age = age,
        groupName = groupName
    )
}