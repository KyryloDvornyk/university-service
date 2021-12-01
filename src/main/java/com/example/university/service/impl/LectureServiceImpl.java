package com.example.university.service.impl;

import com.example.university.dto.request.LectureRequestDto;
import com.example.university.dto.response.LectureResponseDto;
import com.example.university.model.Lecture;
import com.example.university.repository.LectureRepository;
import com.example.university.service.LectureService;
import com.example.university.service.mapper.impl.LectureDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;
    private final LectureDtoMapper lectureDtoMapper;

    public LectureServiceImpl(LectureRepository lectureRepository, LectureDtoMapper lectureDtoMapper) {
        this.lectureRepository = lectureRepository;
        this.lectureDtoMapper = lectureDtoMapper;
    }

    @Override
    public LectureResponseDto save(LectureRequestDto requestDto) {
        Lecture lecture = lectureDtoMapper.mapToModel(requestDto);
        return lectureDtoMapper.mapToDto(lectureRepository.save(lecture));
    }

    @Override
    public LectureResponseDto update(LectureRequestDto requestDto, Long id) {
        Lecture lecture = lectureDtoMapper.mapToModel(requestDto);
        lecture.setId(id);
        return lectureDtoMapper.mapToDto(lectureRepository.save(lecture));
    }

    @Override
    public LectureResponseDto getById(Long id) {
        return lectureDtoMapper.mapToDto(lectureRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        lectureRepository.deleteById(id);
    }
}
