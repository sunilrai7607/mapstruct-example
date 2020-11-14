package com.example.explore.mapper;

public interface BaseMapper<I, O> {
    O map(I input);
}
