package com.example.order.controller;

import com.example.order.domain.Message;
import com.example.order.dto.OrderRequestDto;
import com.example.order.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @PostMapping("/order")
    @ResponseBody
    public ResponseEntity<String> order(@RequestBody OrderRequestDto orderRequestDto) {
        orderDetailService.createOrder(orderRequestDto);
        return ResponseEntity.ok("성공적으로 주문이 완료되었습니다.");
    }
}
