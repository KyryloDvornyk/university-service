package com.example.university.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimetableRequestDto {
    private Long groupId;
    private Long lectureId;
    private String startTime;
}
