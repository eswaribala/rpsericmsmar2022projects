package com.eric.paymentapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eric.paymentapi.models.Payment;

public interface PaymentRepository extends MongoRepository<Payment,Long>{

}
