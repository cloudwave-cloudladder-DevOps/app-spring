package com.example.order.controller;

import com.example.order.domain.OrderDetail;
import com.example.order.dto.OrderListRequest;
import com.example.order.dto.OrderListResponse;
import com.example.order.dto.OrderRequestDto;
import com.example.order.repository.OrderDetailRepository;
import com.example.order.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tlij")
@RequiredArgsConstructor
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @PostMapping("/order")
    public ResponseEntity<String> order(@RequestBody OrderRequestDto orderRequestDto) {
        orderDetailService.createOrder(orderRequestDto);
        return ResponseEntity.ok("주문이 완료 되었습니다.");
    }

    @GetMapping
    public List<OrderListResponse> findOrders(@RequestBody OrderListRequest orderListRequest) {
        return orderDetailService.findOrder(orderListRequest.getName());
    }
}
