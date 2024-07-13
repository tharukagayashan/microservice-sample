package com.projects.paymentcenter.service;

import com.projects.paymentcenter.dao.PaymentDao;
import com.projects.paymentcenter.dto.PaymentReqDto;
import com.projects.paymentcenter.model.Payment;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentDao paymentDao;

    public PaymentService(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    public ResponseEntity<Payment> makePayment(PaymentReqDto paymentReqDto) throws BadRequestException {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        Payment payment = new Payment();
        payment.setType(paymentReqDto.getType());
        payment.setStatus("Completed");
        payment.setAmount(paymentReqDto.getAmount());
        payment.setDate(date.toString());
        payment.setTime(time.toString());
        payment.setUserId(paymentReqDto.getUserId());
        payment.setDescription(paymentReqDto.getDescription());

        payment = paymentDao.save(payment);
        if (payment.getPaymentId() == null) {
            throw new BadRequestException("Payment failed");
        } else {
            return ResponseEntity.ok(payment);
        }
    }

    public ResponseEntity<List<Payment>> getAllPayment() {
        return ResponseEntity.ok(paymentDao.findAll());
    }

    public ResponseEntity<List<Payment>> getPaymentByUserId(Long userId) {
        return ResponseEntity.ok(paymentDao.findByUserId(userId));
    }
}
