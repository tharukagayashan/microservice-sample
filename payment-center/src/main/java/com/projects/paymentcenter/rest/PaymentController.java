package com.projects.paymentcenter.rest;

import com.projects.paymentcenter.dto.PaymentReqDto;
import com.projects.paymentcenter.model.Payment;
import com.projects.paymentcenter.service.PaymentService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<Payment> makePayment(@RequestBody PaymentReqDto paymentReqDto) throws BadRequestException {
        return paymentService.makePayment(paymentReqDto);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayment() {
        return paymentService.getAllPayment();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Payment>> getPaymentByUserId(@PathVariable Long userId) {
        return paymentService.getPaymentByUserId(userId);
    }

}