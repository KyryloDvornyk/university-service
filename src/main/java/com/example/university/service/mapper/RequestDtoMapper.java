package com.example.university.service.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToModel(D dto);
}
