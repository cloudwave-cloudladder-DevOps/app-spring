package com.example.order.controller;

import com.example.order.domain.Message;
import com.example.order.dto.OrderRequestDto;
import com.example.order.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @PostMapping("/order")
    public ResponseEntity<Message> order(@RequestBody OrderRequestDto orderRequestDto) {
        orderDetailService.createOrder(orderRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new Message("주문이 완료되었습니다."));
    }
}
