package com.example.idol_db.idol.controller

import com.example.idol_db.idol.dto.IdolRequestDto
import com.example.idol_db.idol.dto.IdolResponseDto
import com.example.idol_db.idol.service.IdolService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/idols")
class IdolController {
    @Autowired
    private lateinit var idolService: IdolService

    //아이돌 조회 전체 api
    @GetMapping
    private fun getIdols() : ResponseEntity<List<IdolResponseDto>>{
        val result = idolService.getIdols()
        return ResponseEntity.status(HttpStatus.OK).body(result)
    }

    //아이돌 id별 조회 api
    @GetMapping("/{id}")
    private fun getIdolById(@PathVariable id : Long) : ResponseEntity<IdolResponseDto>{
        val result = idolService.getIdolById(id)
        return ResponseEntity.status(HttpStatus.OK).body(result)
    }

    //아이돌을 생성하는 api
    @PostMapping("/{id}")
    private fun postIdol(@RequestBody idolRequestDto: IdolRequestDto) : ResponseEntity<IdolResponseDto>{
        val result = idolService.postIdol(idolRequestDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(result)
    }

    //아이돌 수정 api
    @PutMapping("/{id}")
    private fun putIdol(@PathVariable id: Long, @RequestBody idolRequestDto: IdolRequestDto) : ResponseEntity<IdolResponseDto>{
        val result = idolService.putIdol(id, idolRequestDto)
        return ResponseEntity.status(HttpStatus.OK).body(result)
    }

    //아이돌 삭제 api
    @DeleteMapping("/{id}")
    private fun deleteIdol(@PathVariable id: Long) : ResponseEntity<String>{
        val result = idolService.deleteIdol(id)
        return ResponseEntity.status(HttpStatus.OK).body("$id 아이디가 삭제되었습니다.")
    }
}