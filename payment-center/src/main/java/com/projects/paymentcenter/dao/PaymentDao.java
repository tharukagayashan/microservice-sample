package com.projects.paymentcenter.dao;

import com.projects.paymentcenter.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PaymentDao extends MongoRepository<Payment, String> {
    List<Payment> findByUserId(Long userId);
}
