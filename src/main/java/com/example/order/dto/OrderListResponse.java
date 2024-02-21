package com.example.order.dto;

import com.example.order.domain.OrderDetail;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderListResponse {
    private String breadName;
    private String breadCategory;

    @Builder
    public OrderListResponse(String breadName, String breadCategory) {
        this.breadName = breadName;
        this.breadCategory = breadCategory;
    }
}
