package br.com.hrpayroll.controllers;

import br.com.hrpayroll.entities.Payment;
import br.com.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    
    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable(value = "workerId") Long workerId,
                                              @PathVariable(value = "days") Integer days){
        Payment payment = paymentService.getPayment(workerId,days);
        return ResponseEntity.ok(payment);

    }

    public ResponseEntity<Payment> getPaymentAlternative( Long workerId, Integer days){
    	 Payment payment = new Payment("Teste", 400.0, days);

    	 return ResponseEntity.ok(payment);
    }
    
}
