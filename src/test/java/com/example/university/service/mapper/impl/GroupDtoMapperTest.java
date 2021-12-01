package com.example.university.service.mapper.impl;

import com.example.university.dto.request.GroupRequestDto;
import com.example.university.dto.response.GroupResponseDto;
import com.example.university.model.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GroupDtoMapperTest {
    @Autowired
    private GroupDtoMapper groupDtoMapper;

    @Test
    public void mapToModel_Ok() {
        GroupRequestDto dto = new GroupRequestDto();
        dto.setName("groupName");
        Group actual = groupDtoMapper.mapToModel(dto);
        Group expected = new Group();
        expected.setName("groupName");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mapToDto_Ok() {
        Group group = new Group();
        group.setName("groupName");
        group.setId(1L);
        GroupResponseDto actual = groupDtoMapper.mapToDto(group);
        GroupResponseDto expected = new GroupResponseDto();
        expected.setName("groupName");
        expected.setId(1L);
        Assertions.assertEquals(expected, actual);
    }
}