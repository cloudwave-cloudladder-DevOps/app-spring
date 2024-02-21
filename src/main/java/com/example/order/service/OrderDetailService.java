package com.example.order.service;

import com.example.order.domain.Member;
import com.example.order.domain.OrderDetail;
import com.example.order.dto.OrderListResponse;
import com.example.order.dto.OrderRequestDto;
import com.example.order.exception.NotFoundException;
import com.example.order.repository.MemberRepository;
import com.example.order.repository.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderDetailService {
    private final MemberRepository memberRepository;

    private final OrderDetailRepository orderDetailRepository;

    @Transactional
    public void createOrder(OrderRequestDto orderRequestDto) {
        Member member = memberRepository.findByName(orderRequestDto.getName())
                .orElseThrow(() -> new NotFoundException("회원을 조회할 수 없습니다."));
        OrderDetail order = OrderDetail.builder()
                .member(member)
                .breadName(orderRequestDto.getBreadName())
                .breadCategory(orderRequestDto.getBreadCategory())
                .build();
        orderDetailRepository.save(order);
    }

    @Transactional
    public List<OrderListResponse> findOrder(String name) {
        Member member = memberRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("회원을 조회할 수 없습니다."));
        List<OrderDetail> orders = member.getOrders();
        List<OrderListResponse> orderList = orders.stream().map(orderDetail -> OrderListResponse.builder()
                .breadName(orderDetail.getBreadName())
                .breadCategory(orderDetail.getBreadCategory())
                .build()).collect(Collectors.toList());
        return orderList;
    }
}
