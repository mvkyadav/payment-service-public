package com.vamshi.paymentservice.service;

import com.vamshi.paymentservice.entity.TransactionDetails;
import com.vamshi.paymentservice.model.PaymentRequest;

public interface PaymentService {

    String doPayment(PaymentRequest paymentRequest);

}
