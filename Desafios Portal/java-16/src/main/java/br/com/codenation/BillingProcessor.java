package br.com.codenation;

import br.com.codenation.paymentmethods.PaymentMethod;

public class BillingProcessor {

    private PaymentMethod paymentMethod;

    public Double calculate( Order order ) {
        return order.getPaymentMethod().getPaymentStrategy().calculate(order.getPrice());
    }
  }