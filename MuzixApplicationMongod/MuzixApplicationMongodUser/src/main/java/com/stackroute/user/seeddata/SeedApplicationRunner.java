/*
package com.stackroute.user.seedComponent;

import com.stackroute.user.domain.User;
import com.stackroute.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class SeedApplicationRunner implements ApplicationRunner {

    @Autowired
    private UserRepository UserRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        UserRepository.save(new User("A","abc"));
        UserRepository.save(new User("B","def"));
        UserRepository.save(new User("C","ghi"));
    }
}
*/
