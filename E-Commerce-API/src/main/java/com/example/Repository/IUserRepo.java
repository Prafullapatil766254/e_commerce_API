package com.example.Repository;

import com.example.Model.Order;
import com.example.Model.User;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {
    List<User> findByOrderIsNull();
}
