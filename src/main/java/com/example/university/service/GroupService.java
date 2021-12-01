package com.example.university.service;

import com.example.university.dto.request.GroupRequestDto;
import com.example.university.dto.response.GroupResponseDto;

public interface GroupService {
    GroupResponseDto save(GroupRequestDto requestDto);

    GroupResponseDto update(GroupRequestDto requestDto, Long id);

    GroupResponseDto getById(Long id);

    void delete(Long id);
}
