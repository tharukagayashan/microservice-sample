package com.projects.paymentcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentReqDto {
    private String type; // Credit Card, Debit Card, Net Banking, UPI, Wallet
    private double amount;
    private Long userId;
    private String description;
}
