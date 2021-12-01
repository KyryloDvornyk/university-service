package com.example.university.controller;

import com.example.university.dto.request.GroupRequestDto;
import com.example.university.dto.response.GroupResponseDto;
import com.example.university.service.GroupService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public GroupResponseDto create(@RequestBody GroupRequestDto requestDto) {
        return groupService.save(requestDto);
    }

    @GetMapping("/{id}")
    public GroupResponseDto readById(@PathVariable Long id) {
        return groupService.getById(id);
    }

    @PutMapping("/{id}")
    public GroupResponseDto update(@PathVariable Long id, @RequestBody GroupRequestDto requestDto) {
        return groupService.update(requestDto, id);
    }

    @DeleteMapping("/{id}")
    public GroupResponseDto delete(@PathVariable Long id) {
        GroupResponseDto responseDto = groupService.getById(id);
        groupService.delete(id);
        return responseDto;
    }
}
