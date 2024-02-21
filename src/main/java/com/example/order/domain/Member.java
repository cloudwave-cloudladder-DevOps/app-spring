package com.example.order.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name="member")
@Getter
public class Member {
    @Id
    private String phoneNumber;
    private String name;
    private String password;
    @OneToMany(mappedBy = "member")
    private List<OrderDetail> orders;
}
