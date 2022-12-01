package com.example.RestDemo.repo;

import com.example.RestDemo.entity.User;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.CrudRepositoryExtensionsKt;

public interface UserRepo extends CrudRepository<User,Long> {


}
