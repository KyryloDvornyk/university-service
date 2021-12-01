package com.example.university.service;

import com.example.university.dto.request.LectureRequestDto;
import com.example.university.dto.response.LectureResponseDto;

public interface LectureService {
    LectureResponseDto save(LectureRequestDto requestDto);

    LectureResponseDto update(LectureRequestDto requestDto, Long id);

    LectureResponseDto getById(Long id);

    void delete(Long id);
}
