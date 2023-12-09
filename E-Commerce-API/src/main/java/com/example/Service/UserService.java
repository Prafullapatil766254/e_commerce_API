package com.example.Service;

import com.example.Model.Order;
import com.example.Model.User;
import com.example.Repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    IUserRepo userRepo;

    public String addUser(User user) {
        userRepo.save(user);
        return "User added successfully...you now can order products.";
    }

    public User getUserById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }


    public String updateUserEmail(Integer id, String email) {
        Optional<User> optional = userRepo.findById(id);

        if(optional.isPresent()){
            User user = optional.get();
            user.setUserEmail(email);
            userRepo.save(user);
            return "User email updated successfully..";
        }else{
            return "User not found..Please enter valid user id";
        }

    }

    public String removeUser(Integer id) {
        Optional<User> optional = userRepo.findById(id);

        if(optional.isPresent()){
            User user = optional.get();
            userRepo.delete(user);
            return "User deleted successfully..";
        }else{
            return "User not found..Please enter valid user id";
        }
    }

    public List<User> getAllUserWithNoOrders(){
//       List<User> users = userRepo.findAll();
//
//       List<User> usersWithNoOrders = new ArrayList<>();
//
//       for(User user : users){
//           List<Order> orders = user.getOrder();
//           if(orders == null){
//               usersWithNoOrders.add(user);
//           }
//       }
//       return usersWithNoOrders;

        return userRepo.findByOrderIsNull();
    }
}
