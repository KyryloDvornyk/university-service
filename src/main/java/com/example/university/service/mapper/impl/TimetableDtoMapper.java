package com.example.university.service.mapper.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import com.example.university.dto.request.TimetableRequestDto;
import com.example.university.dto.response.LectureTimeResponseDto;
import com.example.university.dto.response.StudentTimetableResponseDto;
import com.example.university.dto.response.TimetableResponseDto;
import com.example.university.model.Timetable;
import com.example.university.repository.GroupRepository;
import com.example.university.repository.LectureRepository;
import com.example.university.service.mapper.RequestDtoMapper;
import com.example.university.service.mapper.ResponseDtoMapper;
import com.example.university.util.DateTimePatternUtil;
import org.springframework.stereotype.Component;

@Component
public class TimetableDtoMapper implements RequestDtoMapper<TimetableRequestDto, Timetable>,
        ResponseDtoMapper<TimetableResponseDto, Timetable> {
    private final DateTimeFormatter dateTimeFormatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.DATE_TIME_PATTERN);
    private final DateTimeFormatter timeFormatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.TIME_PATTERN);
    private final GroupRepository groupRepository;
    private final LectureRepository lectureRepository;

    public TimetableDtoMapper(GroupRepository groupRepository, LectureRepository lectureRepository) {
        this.groupRepository = groupRepository;
        this.lectureRepository = lectureRepository;
    }

    @Override
    public Timetable mapToModel(TimetableRequestDto dto) {
        Timetable timetable = new Timetable();
        timetable.setGroup(groupRepository.getById(dto.getGroupId()));
        timetable.setLecture(lectureRepository.getById(dto.getLectureId()));
        timetable.setStartTime(LocalDateTime.parse(dto.getStartTime(), dateTimeFormatter));
        return timetable;
    }

    @Override
    public TimetableResponseDto mapToDto(Timetable model) {
        TimetableResponseDto dto = new TimetableResponseDto();
        dto.setId(model.getId());
        dto.setStartTime(model.getStartTime().format(dateTimeFormatter));
        dto.setGroupId(model.getGroup().getId());
        dto.setLectureId(model.getLecture().getId());
        return dto;
    }

    public StudentTimetableResponseDto mapToDto(List<Timetable> timetables, String studentName, String date) {
        StudentTimetableResponseDto dto = new StudentTimetableResponseDto();
        dto.setDate(date);
        dto.setStudentName(studentName);
        dto.setLectures(timetables.stream()
                .map(this::toLectureTimeResponseDto).collect(Collectors.toList()));
        return dto;
    }

    private LectureTimeResponseDto toLectureTimeResponseDto(Timetable timetable) {
        LectureTimeResponseDto dto = new LectureTimeResponseDto();
        dto.setTime(timetable.getStartTime().format(timeFormatter));
        dto.setName(timetable.getLecture().getSubject());
        return dto;
    }
}
