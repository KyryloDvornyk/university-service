package com.example.university.controller;

import com.example.university.dto.request.StudentRequestDto;
import com.example.university.dto.response.StudentResponseDto;
import com.example.university.service.StudentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentResponseDto create(@RequestBody StudentRequestDto requestDto) {
        return studentService.save(requestDto);
    }

    @GetMapping("/{id}")
    public StudentResponseDto readById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @PutMapping("/{id}")
    public StudentResponseDto update(@PathVariable Long id, @RequestBody StudentRequestDto requestDto) {
        return studentService.update(requestDto, id);
    }

    @DeleteMapping("/{id}")
    public StudentResponseDto delete(@PathVariable Long id) {
        StudentResponseDto responseDto = studentService.getById(id);
        studentService.delete(id);
        return responseDto;
    }
}
