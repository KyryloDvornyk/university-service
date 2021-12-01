package com.example.university.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.example.university.dto.request.TimetableRequestDto;
import com.example.university.dto.response.StudentTimetableResponseDto;
import com.example.university.dto.response.TimetableResponseDto;
import com.example.university.model.Group;
import com.example.university.model.Student;
import com.example.university.model.Timetable;
import com.example.university.repository.StudentRepository;
import com.example.university.repository.TimetableRepository;
import com.example.university.service.TimetableService;
import com.example.university.service.mapper.impl.TimetableDtoMapper;
import com.example.university.util.DateTimePatternUtil;
import org.springframework.stereotype.Service;

@Service
public class TimetableServiceImpl implements TimetableService {
    private static final String START_TIME = " 00:00";
    private static final String END_TIME = " 23:59";
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.DATE_TIME_PATTERN);
    private final TimetableRepository timetableRepository;
    private final TimetableDtoMapper timetableDtoMapper;
    private final StudentRepository studentRepository;

    public TimetableServiceImpl(TimetableRepository timetableRepository,
                                TimetableDtoMapper timetableDtoMapper,
                                StudentRepository studentRepository) {
        this.timetableRepository = timetableRepository;
        this.timetableDtoMapper = timetableDtoMapper;
        this.studentRepository = studentRepository;
    }

    @Override
    public TimetableResponseDto save(TimetableRequestDto requestDto) {
        Timetable timetable = timetableDtoMapper.mapToModel(requestDto);
        return timetableDtoMapper.mapToDto(timetableRepository.save(timetable));
    }

    @Override
    public TimetableResponseDto update(TimetableRequestDto requestDto, Long id) {
        Timetable timetable = timetableDtoMapper.mapToModel(requestDto);
        timetable.setId(id);
        return timetableDtoMapper.mapToDto(timetableRepository.save(timetable));
    }

    @Override
    public TimetableResponseDto getById(Long id) {
        return timetableDtoMapper.mapToDto(timetableRepository.getById(id));
    }

    @Override
    public StudentTimetableResponseDto getAllByStudentAndDate(Long studentId, String date) {
        Student student = studentRepository.getById(studentId);
        Group group = student.getGroup();
        LocalDateTime startDate = LocalDateTime.parse(date + START_TIME, formatter);
        LocalDateTime endDate = LocalDateTime.parse(date + END_TIME, formatter);
        return timetableDtoMapper.mapToDto(
                timetableRepository.findAllByGroupAndDate(group, startDate, endDate), student.getName(), date);
    }

    @Override
    public void delete(Long id) {
        timetableRepository.deleteById(id);
    }
}
