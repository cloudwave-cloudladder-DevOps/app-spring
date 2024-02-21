package com.example.order.service;

import com.example.order.domain.OrderDetail;
import com.example.order.dto.OrderRequestDto;
import com.example.order.repository.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Transactional
    public void createOrder(OrderRequestDto orderRequestDto) {
        OrderDetail order = OrderDetail.builder()
                .breadName(orderRequestDto.getBreadName())
                .breadCategory(orderRequestDto.getBreadCategory())
                .build();
        orderDetailRepository.save(order);
    }
}
