package com.example.idol_db.idol.service

import com.example.idol_db.idol.dto.IdolResponseDto
import com.example.idol_db.idol.dto.IdolRequestDto
import com.example.idol_db.idol.entity.Idol
import com.example.idol_db.idol.repository.IdolRepository
import com.example.idol_db.common.exception.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class IdolService {
    //lateinit var서비스를 실행한 뒤 생기는 변수
    @Autowired
    private lateinit var idolRepository: IdolRepository

    /*
    idol 맴버 조회
     */
    fun getIdols() : List<IdolResponseDto>{
        val result = idolRepository.findAll()
        return result.map { it.toResponse() }
    }

    /*
    idol id별 조회
     */
    fun getIdolById(id : Long) : IdolResponseDto {
        val idol = idolRepository.findByIdOrNull(id) ?: throw NotFoundException("존재하지 않는 ID입니다.")
        return idol.toResponse()
    }

    /*
    idol 생성 서비스로직
     */
    fun postIdol(idolRequestDto: IdolRequestDto) : IdolResponseDto {
        val result = idolRepository.save(idolRequestDto.toEntity())
        return result.toResponse()
    }


    /*
    id가 존재하면 새로운 idolRequestDto 로 업데이트함.
     */
    fun putIdol(id: Long, idolRequestDto : IdolRequestDto) : IdolResponseDto {
        val getIdol : Idol = idolRepository.findByIdOrNull(id) ?: throw NotFoundException(msg = "존재하지 않는 ID입니다.")

        val newIdol : IdolRequestDto = IdolRequestDto(
            id = getIdol.id,
            name = idolRequestDto.name,
            age = idolRequestDto.age,
            groupName = idolRequestDto.groupName
        )

        val result = idolRepository.save(newIdol.toEntity())
        return result.toResponse()
    }

    /*
    idol 삭제 서비스로직
     */
    fun deleteIdol(id : Long) : Unit{
        idolRepository.deleteById(id)
    }
}