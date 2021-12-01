package com.example.university.service.impl;

import java.time.LocalDateTime;
import com.example.university.dto.request.TimetableRequestDto;
import com.example.university.model.Group;
import com.example.university.model.Student;
import com.example.university.model.Timetable;
import com.example.university.repository.StudentRepository;
import com.example.university.repository.TimetableRepository;
import com.example.university.service.mapper.impl.TimetableDtoMapper;
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
class TimetableServiceTest {
    @Mock
    private TimetableDtoMapper timetableDtoMapper;
    @Mock
    private TimetableRepository timetableRepository;
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private TimetableServiceImpl timetableService;
    @Captor
    private ArgumentCaptor<Timetable> timetableArgumentCaptor;
    @Captor
    private ArgumentCaptor<LocalDateTime> startDateCaptor;
    @Captor
    private ArgumentCaptor<LocalDateTime> endDateCaptor;

    @Test
    public void update_Ok() {
        TimetableRequestDto dto = new TimetableRequestDto();
        Timetable timetable = new Timetable();
        Mockito.when(timetableDtoMapper.mapToModel(dto)).thenReturn(timetable);
        timetableService.update(dto, 1L);
        Mockito.verify(timetableRepository).save(timetableArgumentCaptor.capture());
        Assertions.assertThat(timetableArgumentCaptor.getValue().getId()).isEqualTo(1L);
    }

    @Test
    public void getAllByStudentAndDate_Ok() {
        Group group = new Group();
        group.setId(1L);
        Student student = new Student();
        student.setGroup(group);
        Mockito.when(studentRepository.getById(1L)).thenReturn(student);
        timetableService.getAllByStudentAndDate(1L, "11.11.2000");
        Mockito.verify(timetableRepository).findAllByGroupAndDate(Mockito.any(),
                startDateCaptor.capture(), endDateCaptor.capture());
        Assertions.assertThat(startDateCaptor.getValue())
                .isEqualTo(LocalDateTime.of(2000, 11, 11, 0, 0));
        Assertions.assertThat(endDateCaptor.getValue())
                .isEqualTo(LocalDateTime.of(2000, 11, 11, 23, 59));
    }
}