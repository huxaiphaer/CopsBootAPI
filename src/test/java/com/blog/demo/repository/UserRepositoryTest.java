package com.blog.demo.repository;

import com.blog.demo.User;
import com.blog.demo.UserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void testStoreUser(){
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.OFFICER);

        User user = repository.save(new User(UUID.randomUUID(),
                "huxy@g,ail.com",
                "my-secrete-password",
                roles));

        assertThat(user).isNotNull();
        assertThat(repository.count()).isEqualTo(1L);
    }
}
