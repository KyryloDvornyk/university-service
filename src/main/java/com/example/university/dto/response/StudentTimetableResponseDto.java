package com.example.university.dto.response;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class StudentTimetableResponseDto {
    private String studentName;
    private String date;
    private List<LectureTimeResponseDto> lectures = new ArrayList<>();
}
