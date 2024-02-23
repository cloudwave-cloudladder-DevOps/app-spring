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

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @PostMapping("/order")
    public ResponseEntity<?> order(@RequestBody OrderRequestDto orderRequestDto) {
        orderDetailService.createOrder(orderRequestDto);

        Map<String, String> response = new HashMap<>();
        response.put("message", "성공적으로 주문이 완료되었습니다.");

        return ResponseEntity.ok(response);
    }
}
