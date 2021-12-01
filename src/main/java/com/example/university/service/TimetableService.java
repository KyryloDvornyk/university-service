package com.example.university.service;

import com.example.university.dto.request.TimetableRequestDto;
import com.example.university.dto.response.StudentTimetableResponseDto;
import com.example.university.dto.response.TimetableResponseDto;

public interface TimetableService {
    TimetableResponseDto save(TimetableRequestDto requestDto);

    TimetableResponseDto update(TimetableRequestDto requestDto, Long id);

    TimetableResponseDto getById(Long id);

    StudentTimetableResponseDto getAllByStudentAndDate(Long studentId, String date);

    void delete(Long id);
}
