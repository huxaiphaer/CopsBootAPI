package com.blog.demo.repository.jpa;

import com.blog.demo.repository.UniqueIdGenerator;

import java.util.UUID;

public class InMemoryUniqueIdGenerator implements UniqueIdGenerator<UUID> {

    @Override
    public UUID getNextUniqueId() {
        return UUID.randomUUID();
    }
}
