package com.vamshi.paymentservice.controller;

import com.vamshi.paymentservice.entity.TransactionDetails;
import com.vamshi.paymentservice.model.PaymentRequest;
import com.vamshi.paymentservice.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping
    public ResponseEntity<String> doPayment(@RequestBody PaymentRequest paymentRequest) {
        log.info("PaymentController -> doPayment Method");
        log.info("Payment Controller -> paymentRequest :{}", paymentRequest);
        String transactionId = paymentService.doPayment(paymentRequest);
        return new ResponseEntity<>(transactionId, HttpStatus.OK);
    }
}
