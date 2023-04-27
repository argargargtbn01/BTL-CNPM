package assignment.book.controller;

import assignment.book.dto.request.OrderDetailRequestDto;
import assignment.book.entity.OrderDetail;
import assignment.book.service.order.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable Long id){
        OrderDetail orderDetail = orderDetailService.getOrder(id);
        return ResponseEntity.status(HttpStatus.OK).body(orderDetail);
    }

    @GetMapping("/customer/{user_id}")
    public ResponseEntity<?> getOrderByCustomer(@PathVariable Long user_id){
        List<OrderDetail> orderDetail = orderDetailService.getOrderByCustomer(user_id);
        return ResponseEntity.status(HttpStatus.OK).body(orderDetail);
    }

    @GetMapping("/seller/{seller_id}")
    public ResponseEntity<?> getOrderBySeller(@PathVariable Long seller_id){
        List<OrderDetail> orderDetail = orderDetailService.getOrderBySeller(seller_id);
        return ResponseEntity.status(HttpStatus.OK).body(orderDetail);
    }

    @PostMapping("/")
    public ResponseEntity<?> createOrder(@RequestBody OrderDetailRequestDto orderDetailRequestDto){
        orderDetailService.createOrder(orderDetailRequestDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
