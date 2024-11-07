package tobyspring.hellospring.hellospring;

public class ObjectFactory {
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }

    public ExRateProvider exRateProvider(){
        return new WebApiExRateProvider();
    }
}
