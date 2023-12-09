package com.example.Controller;

import com.example.Model.User;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("user")
    public String addUser(@RequestBody @Valid User user){
       return userService.addUser(user);
    }

    @GetMapping("user/id")
    public User getUserById(@RequestParam Integer id){
        return userService.getUserById(id);
    }



    @PutMapping("user/id/{id}")
    public String updateUserEmail(@PathVariable Integer id , @RequestParam String email){
        return userService.updateUserEmail(id , email);
    }

    @DeleteMapping("user/id")
    public String removeUser(@RequestParam Integer id){
        return userService.removeUser(id);
    }


    @GetMapping("users") // This api will give all users who didn't order anything.
    public List<User> getAllUserWithNoOrders(){
        return userService.getAllUserWithNoOrders();
    }

}
