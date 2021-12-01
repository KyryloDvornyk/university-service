package com.example.university.service.impl;

import com.example.university.dto.request.GroupRequestDto;
import com.example.university.model.Group;
import com.example.university.repository.GroupRepository;
import com.example.university.service.mapper.impl.GroupDtoMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GroupServiceTest {
    @Mock
    private GroupDtoMapper groupDtoMapper;
    @Mock
    private GroupRepository groupRepository;
    @InjectMocks
    private GroupServiceImpl groupService;
    @Captor
    private ArgumentCaptor<Group> groupArgumentCaptor;

    @Test
    public void update_Ok() {
        GroupRequestDto dto = new GroupRequestDto();
        Group group = new Group();
        Mockito.when(groupDtoMapper.mapToModel(dto)).thenReturn(group);
        groupService.update(dto, 1L);
        Mockito.verify(groupRepository).save(groupArgumentCaptor.capture());
        Assertions.assertThat(groupArgumentCaptor.getValue().getId()).isEqualTo(1L);
    }
}