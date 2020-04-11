package com.blog.demo;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "copsboot_user")
public class User  {

    @Id
    private UUID id;
    private String name;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Set<UserRole> roles;

    protected User(){

    }

    public User(UserId id, String name, String password, Set<UserRole> roles) {
        //super(id);
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }
}
