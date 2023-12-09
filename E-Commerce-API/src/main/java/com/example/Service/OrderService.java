package com.example.Service;

import com.example.Model.Order;
import com.example.Model.User;
import com.example.Repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    IOrderRepo orderRepo;

    public String postOrder(Order order) {
        order.setOrderDateTime(LocalDateTime.now());
        orderRepo.save(order);
        return "Order successfully posted..";
    }

    public String deleteOrder(Integer id) {
        Optional<Order> optional = orderRepo.findById(id);

        if(optional.isPresent()){
            Order order = optional.get();
            orderRepo.delete(order);
            return "Order deleted successfully..";
        }else{
            return "Order not found..Please enter valid order id";
        }
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}
