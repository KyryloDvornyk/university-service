package com.example.university.service.mapper.impl;

import com.example.university.dto.request.StudentRequestDto;
import com.example.university.dto.response.StudentResponseDto;
import com.example.university.model.Student;
import com.example.university.repository.GroupRepository;
import com.example.university.service.mapper.RequestDtoMapper;
import com.example.university.service.mapper.ResponseDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentDtoMapper implements RequestDtoMapper<StudentRequestDto, Student>,
        ResponseDtoMapper<StudentResponseDto, Student> {
    private final GroupRepository groupRepository;

    public StudentDtoMapper(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Student mapToModel(StudentRequestDto dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setGroup(groupRepository.getById(dto.getGroupId()));
        return student;
    }

    @Override
    public StudentResponseDto mapToDto(Student model) {
        StudentResponseDto dto = new StudentResponseDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setGroupId(model.getGroup().getId());
        return dto;
    }
}
