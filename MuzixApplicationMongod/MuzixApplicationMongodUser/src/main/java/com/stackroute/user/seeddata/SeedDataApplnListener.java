package com.stackroute.user.seeddata;

import com.stackroute.user.domain.User;
import com.stackroute.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;


@Configuration
public class SeedDataApplnListener  implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private UserRepository userRepository;    //or u can take object of User services and call .saveUser method(either way is fine)

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        userRepository.save(new User(1,"A","abc"));
        userRepository.save(new User(2,"B","def"));
        userRepository.save(new User(3,"C","ghi"));
    }
}
