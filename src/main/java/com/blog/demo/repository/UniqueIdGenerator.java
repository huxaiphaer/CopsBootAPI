package com.blog.demo.repository;

public interface UniqueIdGenerator<T> {
    T getNextUniqueId();
}
