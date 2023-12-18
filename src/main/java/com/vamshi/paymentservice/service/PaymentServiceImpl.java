package com.vamshi.paymentservice.service;

import com.vamshi.paymentservice.entity.TransactionDetails;
import com.vamshi.paymentservice.model.PaymentRequest;
import com.vamshi.paymentservice.repository.PaymentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public String doPayment(PaymentRequest paymentRequest) {

        log.info("Payment Processing...");

        TransactionDetails tDetails = TransactionDetails.builder()
                .id(UUID.randomUUID().toString())
                .orderId(paymentRequest.getOrderId())
                .paymentMode(paymentRequest.getPaymentMode())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .paymentDate(Instant.now())
                .paymentStatus("SUCCESS")
                .amount(paymentRequest.getAmount())
                .build();

        log.info("Transaction Succeeded");
        paymentRepository.save(tDetails);
        return tDetails.getId();
    }
}
