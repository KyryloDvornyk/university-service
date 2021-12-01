package com.example.university.controller;

import com.example.university.dto.request.TimetableRequestDto;
import com.example.university.dto.response.StudentTimetableResponseDto;
import com.example.university.dto.response.TimetableResponseDto;
import com.example.university.service.TimetableService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timetables")
public class TimetableController {
    private final TimetableService timetableService;

    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @PostMapping
    public TimetableResponseDto create(@RequestBody TimetableRequestDto requestDto) {
        return timetableService.save(requestDto);
    }

    @GetMapping("/{id}")
    public TimetableResponseDto readById(@PathVariable Long id) {
        return timetableService.getById(id);
    }

    @GetMapping
    public StudentTimetableResponseDto readAllByStudentAndDate(@RequestParam Long studentId,
                                                               @RequestParam String date) {
        return timetableService.getAllByStudentAndDate(studentId, date);
    }

    @PutMapping("/{id}")
    public TimetableResponseDto update(@PathVariable Long id, @RequestBody TimetableRequestDto requestDto) {
        return timetableService.update(requestDto, id);
    }

    @DeleteMapping("/{id}")
    public TimetableResponseDto delete(@PathVariable Long id) {
        TimetableResponseDto responseDto = timetableService.getById(id);
        timetableService.delete(id);
        return responseDto;
    }
}
