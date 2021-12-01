package com.example.university.service.mapper.impl;

import com.example.university.dto.request.LectureRequestDto;
import com.example.university.dto.response.LectureResponseDto;
import com.example.university.model.Lecture;
import com.example.university.service.mapper.RequestDtoMapper;
import com.example.university.service.mapper.ResponseDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class LectureDtoMapper implements RequestDtoMapper<LectureRequestDto, Lecture>,
        ResponseDtoMapper<LectureResponseDto, Lecture> {
    @Override
    public Lecture mapToModel(LectureRequestDto dto) {
        Lecture lecture = new Lecture();
        lecture.setSubject(dto.getSubject());
        return lecture;
    }

    @Override
    public LectureResponseDto mapToDto(Lecture model) {
        LectureResponseDto dto = new LectureResponseDto();
        dto.setId(model.getId());
        dto.setSubject(model.getSubject());
        return dto;
    }
}
