package com.example.test.demo.Controllers;

import com.example.test.demo.Models.Order;
import com.example.test.demo.Models.ResponseObject;
import com.example.test.demo.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getOrderById(@PathVariable int id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "query order successfully", order));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "can not find order with id = " + id, ""));
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insertOrder(@RequestBody Order newOrder) {
        Order savedOrder = orderRepository.save(newOrder);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "insert order successfully", savedOrder));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateOrder(@PathVariable int id, @RequestBody Order updatedOrder) {
        Optional<Order> existingOrder = orderRepository.findById(id);
        if (existingOrder.isPresent()) {
            updatedOrder.setOrderID(id);
            Order savedOrder = orderRepository.save(updatedOrder);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "update order successfully", savedOrder));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "can not find order with id = " + id, ""));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteOrder(@PathVariable int id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "delete order successfully", ""));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false", "can not find order with id = " + id, ""));
        }
    }
}
