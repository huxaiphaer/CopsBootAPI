package com.blog.demo.repository;

import com.blog.demo.UserId;

import java.util.UUID;

public class UserRepositoryImpl implements UserRepositoryCustom{

    private final UniqueIdGenerator<UUID> generator;

    public UserRepositoryImpl(UniqueIdGenerator<UUID> generator) {
        this.generator = generator;
    }

    @Override
    public UserId nextId() {
        return null;
    }
}
