package com.example.university.controller;

import com.example.university.dto.request.LectureRequestDto;
import com.example.university.dto.response.LectureResponseDto;
import com.example.university.service.LectureService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lectures")
public class LectureController {
    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @PostMapping
    public LectureResponseDto create(@RequestBody LectureRequestDto requestDto) {
        return lectureService.save(requestDto);
    }

    @GetMapping("/{id}")
    public LectureResponseDto readById(@PathVariable Long id) {
        return lectureService.getById(id);
    }

    @PutMapping("/{id}")
    public LectureResponseDto update(@PathVariable Long id,
                                     @RequestBody LectureRequestDto lectureRequestDto) {
        return lectureService.update(lectureRequestDto, id);
    }

    @DeleteMapping("/{id}")
    public LectureResponseDto delete(@PathVariable Long id) {
        LectureResponseDto responseDto = lectureService.getById(id);
        lectureService.delete(id);
        return responseDto;
    }
}
