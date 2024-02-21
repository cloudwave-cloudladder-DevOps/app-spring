package com.example.order.domain;

import com.example.order.dto.OrderRequestDto;
import com.example.order.repository.OrderDetailRepository;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name="order_detail")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String breadName;
    private String breadCategory;
    @ManyToOne
    @JoinColumn(name = "member_phone_number", referencedColumnName = "phoneNumber")
    private Member member;

    @Builder
    public OrderDetail(String breadName, String breadCategory, Member member) {
        this.breadName = breadName;
        this.breadCategory = breadCategory;
        this.member = member;
    }
}
