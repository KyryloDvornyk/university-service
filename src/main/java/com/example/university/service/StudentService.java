package com.example.university.service;

import com.example.university.dto.request.StudentRequestDto;
import com.example.university.dto.response.StudentResponseDto;

public interface StudentService {
    StudentResponseDto save(StudentRequestDto requestDto);

    StudentResponseDto update(StudentRequestDto requestDto, Long id);

    StudentResponseDto getById(Long id);

    void delete(Long id);
}
