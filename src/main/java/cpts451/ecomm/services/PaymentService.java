package cpts451.ecomm.services;

import cpts451.ecomm.entities.Payment;

public interface PaymentService {
    Payment find(int id);

    Iterable<Payment> findAll();

    Payment save(Payment payment);

    void deleteById(int id);
}
