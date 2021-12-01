package com.example.university.dto.response;

import lombok.Data;

@Data
public class TimetableResponseDto {
    private Long id;
    private Long groupId;
    private Long lectureId;
    private String startTime;
}
