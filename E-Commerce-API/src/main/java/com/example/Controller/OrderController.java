package com.example.Controller;

import com.example.Model.Order;
import com.example.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // not needed as those classes which implemented jpa repository already has @Repository on them so here it is optional
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("order")
    public String postOrder(@RequestBody Order order){
        return orderService.postOrder(order);
    }

    @DeleteMapping("order")
    public String deleteOrder(@RequestParam Integer id){
        return orderService.deleteOrder(id);
    }

    @GetMapping("orders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
}
