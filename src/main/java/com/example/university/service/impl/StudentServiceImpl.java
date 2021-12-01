package com.example.university.service.impl;

import com.example.university.dto.request.StudentRequestDto;
import com.example.university.dto.response.StudentResponseDto;
import com.example.university.model.Student;
import com.example.university.repository.StudentRepository;
import com.example.university.service.StudentService;
import com.example.university.service.mapper.impl.StudentDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentDtoMapper studentDtoMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentDtoMapper studentDtoMapper) {
        this.studentRepository = studentRepository;
        this.studentDtoMapper = studentDtoMapper;
    }

    @Override
    public StudentResponseDto save(StudentRequestDto requestDto) {
        Student student = studentDtoMapper.mapToModel(requestDto);
        return studentDtoMapper.mapToDto(studentRepository.save(student));
    }

    @Override
    public StudentResponseDto update(StudentRequestDto requestDto, Long id) {
        Student student = studentDtoMapper.mapToModel(requestDto);
        student.setId(id);
        return studentDtoMapper.mapToDto(studentRepository.save(student));
    }

    @Override
    public StudentResponseDto getById(Long id) {
        return studentDtoMapper.mapToDto(studentRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
