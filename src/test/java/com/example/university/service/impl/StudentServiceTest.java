package com.example.university.service.impl;

import com.example.university.dto.request.StudentRequestDto;
import com.example.university.model.Student;
import com.example.university.repository.StudentRepository;
import com.example.university.service.mapper.impl.StudentDtoMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private StudentDtoMapper studentDtoMapper;
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentServiceImpl studentService;
    @Captor
    private ArgumentCaptor<Student> studentArgumentCaptor;

    @Test
    public void update_Ok() {
        StudentRequestDto dto = new StudentRequestDto();
        Student student = new Student();
        Mockito.when(studentDtoMapper.mapToModel(dto)).thenReturn(student);
        studentService.update(dto, 1L);
        Mockito.verify(studentRepository).save(studentArgumentCaptor.capture());
        Assertions.assertThat(studentArgumentCaptor.getValue().getId()).isEqualTo(1L);
    }
}