package com.example.university.service.mapper.impl;

import java.time.LocalDateTime;
import com.example.university.dto.request.TimetableRequestDto;
import com.example.university.dto.response.TimetableResponseDto;
import com.example.university.model.Group;
import com.example.university.model.Lecture;
import com.example.university.model.Timetable;
import com.example.university.repository.GroupRepository;
import com.example.university.repository.LectureRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TimetableDtoMapperTest {
    @Mock
    private GroupRepository groupRepository;
    @Mock
    private LectureRepository lectureRepository;
    @InjectMocks
    private TimetableDtoMapper timetableDtoMapper;

    @Test
    public void mapToModel_Ok() {
        TimetableRequestDto dto = new TimetableRequestDto();
        dto.setGroupId(1L);
        dto.setStartTime("11.11.2021 11:00");
        dto.setLectureId(1L);
        Group group = new Group();
        Mockito.when(groupRepository.getById(1L)).thenReturn(group);
        Lecture lecture = new Lecture();
        Mockito.when(lectureRepository.getById(1L)).thenReturn(lecture);
        Timetable actual = timetableDtoMapper.mapToModel(dto);
        Timetable expected = new Timetable();
        expected.setLecture(lecture);
        expected.setGroup(group);
        expected.setStartTime(LocalDateTime.of(2021, 11, 11, 11, 0));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mapToDto_Ok() {
        Timetable timetable = new Timetable();
        timetable.setStartTime(LocalDateTime.of(2021, 11, 11, 11, 0));
        timetable.setId(1L);
        Group group = new Group();
        group.setId(1L);
        timetable.setGroup(group);
        Lecture lecture = new Lecture();
        lecture.setId(1L);
        timetable.setLecture(lecture);
        TimetableResponseDto actual = timetableDtoMapper.mapToDto(timetable);
        TimetableResponseDto expected = new TimetableResponseDto();
        expected.setStartTime("11.11.2021 11:00");
        expected.setLectureId(1L);
        expected.setGroupId(1L);
        expected.setId(1L);
        Assertions.assertEquals(expected, actual);
    }
}