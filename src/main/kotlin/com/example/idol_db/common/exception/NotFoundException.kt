package com.example.idol_db.common.exception


//커스텀 예외처리 Exception
class NotFoundException (
    val msg : String = "에러가 발생하였습니다."
) : RuntimeException()