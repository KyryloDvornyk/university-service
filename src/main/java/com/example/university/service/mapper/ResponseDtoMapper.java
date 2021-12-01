package com.example.university.service.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T model);
}
