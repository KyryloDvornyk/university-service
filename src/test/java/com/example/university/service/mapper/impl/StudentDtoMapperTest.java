package com.example.university.service.mapper.impl;

import com.example.university.dto.request.StudentRequestDto;
import com.example.university.dto.response.StudentResponseDto;
import com.example.university.model.Group;
import com.example.university.model.Student;
import com.example.university.repository.GroupRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StudentDtoMapperTest {
    @Mock
    private GroupRepository groupRepository;
    @InjectMocks
    private StudentDtoMapper studentDtoMapper;

    @Test
    public void mapToModel_Ok() {
        StudentRequestDto dto = new StudentRequestDto();
        dto.setGroupId(1L);
        dto.setName("studentName");
        Group group = new Group();
        Mockito.when(groupRepository.getById(1L)).thenReturn(group);
        Student actual = studentDtoMapper.mapToModel(dto);
        Student expected = new Student();
        expected.setName("studentName");
        expected.setGroup(group);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mapToDto_Ok() {
        Student student = new Student();
        student.setName("studentName");
        student.setId(1L);
        Group group = new Group();
        group.setId(1L);
        student.setGroup(group);
        StudentResponseDto actual = studentDtoMapper.mapToDto(student);
        StudentResponseDto expected = new StudentResponseDto();
        expected.setName("studentName");
        expected.setId(1L);
        expected.setGroupId(1L);
        Assertions.assertEquals(expected, actual);
    }
}