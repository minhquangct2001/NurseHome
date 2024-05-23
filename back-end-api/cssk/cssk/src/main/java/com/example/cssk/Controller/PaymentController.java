package com.example.cssk.Controller;
import com.example.cssk.Service.Implement.PaymentServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@AllArgsConstructor
public class PaymentController {
    @Autowired
    private final PaymentServiceImp paymentServiceImp;
    @PostMapping()
    public String createBill(@RequestBody String jsonString) throws JsonProcessingException {
        return paymentServiceImp.createPayment(jsonString).toString();
    }
    //@GetMapping()
    //public String get() throws JsonProcessingException {
    //    return paymentServiceImp.fetchDataFromExternalAPI();
    //}
    @GetMapping()
    public String getAll() throws JsonProcessingException {
        return paymentServiceImp.getAllPayment();
    }

    @GetMapping("/cronjob")
    public String createPaymentAuto() {
        return paymentServiceImp.createPaymentAuto();
    }

    @GetMapping("/{paymentID}")
    public String getPaymentID(@PathVariable int paymentID) {
        return paymentServiceImp.getPayment(paymentID);
    }
    @GetMapping("/check/{paymentID}")
    public String check(@PathVariable int paymentID) throws JsonProcessingException {
        return paymentServiceImp.check(paymentID);
    }
}
