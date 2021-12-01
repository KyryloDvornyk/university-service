package com.example.university.service.impl;

import com.example.university.dto.request.LectureRequestDto;
import com.example.university.model.Lecture;
import com.example.university.repository.LectureRepository;
import com.example.university.service.mapper.impl.LectureDtoMapper;
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
class LectureServiceTest {
    @Mock
    private LectureDtoMapper lectureDtoMapper;
    @Mock
    private LectureRepository lectureRepository;
    @InjectMocks
    private LectureServiceImpl lectureService;
    @Captor
    private ArgumentCaptor<Lecture> lectureArgumentCaptor;

    @Test
    public void update_Ok() {
        LectureRequestDto dto = new LectureRequestDto();
        Lecture lecture = new Lecture();
        Mockito.when(lectureDtoMapper.mapToModel(dto)).thenReturn(lecture);
        lectureService.update(dto, 1L);
        Mockito.verify(lectureRepository).save(lectureArgumentCaptor.capture());
        Assertions.assertThat(lectureArgumentCaptor.getValue().getId()).isEqualTo(1L);
    }
}