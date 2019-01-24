package com.stackroute.MuzixApplication.repository;

import com.stackroute.MuzixApplication.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//jpa is having crud menthods...we want to use crud operations pres in JpaRepo(interface)..
@Repository
public interface UserRepository extends MongoRepository<User,Integer> {

}
