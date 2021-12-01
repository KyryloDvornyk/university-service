package com.example.university.service.mapper.impl;

import com.example.university.dto.request.LectureRequestDto;
import com.example.university.dto.response.LectureResponseDto;
import com.example.university.model.Lecture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LectureDtoMapperTest {
    @Autowired
    private LectureDtoMapper lectureDtoMapper;

    @Test
    public void mapToModel_Ok() {
        LectureRequestDto dto = new LectureRequestDto();
        dto.setSubject("subject");
        Lecture actual = lectureDtoMapper.mapToModel(dto);
        Lecture expected = new Lecture();
        expected.setSubject("subject");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mapToDto_Ok() {
        Lecture lecture = new Lecture();
        lecture.setSubject("subject");
        lecture.setId(1L);
        LectureResponseDto actual = lectureDtoMapper.mapToDto(lecture);
        LectureResponseDto expected = new LectureResponseDto();
        expected.setSubject("subject");
        expected.setId(1L);
        Assertions.assertEquals(expected, actual);
    }
}