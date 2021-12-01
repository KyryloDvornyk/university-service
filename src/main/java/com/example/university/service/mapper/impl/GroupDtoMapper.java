package com.example.university.service.mapper.impl;

import com.example.university.dto.request.GroupRequestDto;
import com.example.university.dto.response.GroupResponseDto;
import com.example.university.model.Group;
import com.example.university.service.mapper.RequestDtoMapper;
import com.example.university.service.mapper.ResponseDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class GroupDtoMapper implements RequestDtoMapper<GroupRequestDto, Group>,
        ResponseDtoMapper<GroupResponseDto, Group> {
    @Override
    public Group mapToModel(GroupRequestDto dto) {
        Group group = new Group();
        group.setName(dto.getName());
        return group;
    }

    @Override
    public GroupResponseDto mapToDto(Group model) {
        GroupResponseDto dto = new GroupResponseDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        return dto;
    }
}
