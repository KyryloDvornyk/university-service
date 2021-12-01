package com.example.university.service.impl;

import com.example.university.dto.request.GroupRequestDto;
import com.example.university.dto.response.GroupResponseDto;
import com.example.university.model.Group;
import com.example.university.repository.GroupRepository;
import com.example.university.service.GroupService;
import com.example.university.service.mapper.impl.GroupDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final GroupDtoMapper groupDtoMapper;

    public GroupServiceImpl(GroupRepository groupRepository, GroupDtoMapper groupDtoMapper) {
        this.groupRepository = groupRepository;
        this.groupDtoMapper = groupDtoMapper;
    }

    @Override
    public GroupResponseDto save(GroupRequestDto requestDto) {
        Group group = groupDtoMapper.mapToModel(requestDto);
        return groupDtoMapper.mapToDto(groupRepository.save(group));
    }

    @Override
    public GroupResponseDto update(GroupRequestDto requestDto, Long id) {
        Group group = groupDtoMapper.mapToModel(requestDto);
        group.setId(id);
        return groupDtoMapper.mapToDto(groupRepository.save(group));
    }

    @Override
    public GroupResponseDto getById(Long id) {
        return groupDtoMapper.mapToDto(groupRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        groupRepository.deleteById(id);
    }
}
