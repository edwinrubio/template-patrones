public class PaymentProcessor {
    private PaymentGateway paymentGateway;

    public void setPaymentGateway(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void processPayment(Order order) {
        paymentGateway.processPayment(order);
    }
}
