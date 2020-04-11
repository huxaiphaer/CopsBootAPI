package com.blog.demo;

import com.blog.demo.entity.AbstractEntityId;

import java.util.UUID;

public class UserId extends AbstractEntityId<UUID> {

    protected UserId(){

    }

    public UserId(UUID id){
        super(id);
    }

}
