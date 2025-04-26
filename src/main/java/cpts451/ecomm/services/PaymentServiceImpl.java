package cpts451.ecomm.services;

import cpts451.ecomm.entities.Payment;
import cpts451.ecomm.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) { this.paymentRepository = paymentRepository; }

    /**
     * finds payment by id
     * @param id the id of the payment we're looking for
     * @return the payment if found, otherwise null
     */
    @Override
    public Payment find(int id) { return paymentRepository.findById(id).orElse(null); }

    /**
     * finds all payments
     * @return a collection of payments
     */
    @Override
    public Iterable<Payment> findAll() { return paymentRepository.findAll(); }

    /**
     * saves a payment
     * @param payment the payment we're saving
     * @return the payment we just saved
     */
    @Override
    public Payment save(Payment payment) { return paymentRepository.save(payment); }

    /**
     * deletes a Payment from the repository
     * @param id the id of the payment to delete
     */
    @Override
    public void deleteById(int id) { paymentRepository.deleteById(id); }
}
