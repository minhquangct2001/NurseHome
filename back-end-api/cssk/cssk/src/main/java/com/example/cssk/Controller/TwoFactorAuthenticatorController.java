package com.example.cssk.Controller;


import com.example.cssk.Service.Implement.TwoFactorAuthenticatorImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.zxing.WriterException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class TwoFactorAuthenticatorController {

    private final TwoFactorAuthenticatorImp twoFactorAuthenticator;

    @Autowired
    public TwoFactorAuthenticatorController(TwoFactorAuthenticatorImp twoFactorAuthenticator) {
        this.twoFactorAuthenticator = twoFactorAuthenticator;
    }

    @GetMapping()
    public String get2fa() throws JsonProcessingException {
        return twoFactorAuthenticator.generateSecretKey().toString();
    }

    @GetMapping("/{SecretKey}")
    public String get2fa(@PathVariable String SecretKey) throws JsonProcessingException {
        return twoFactorAuthenticator.generateOtp(SecretKey).toString();
    }


    @PostMapping()
    public String check2fa(@RequestBody String jsonString) throws JsonProcessingException {
        return String.valueOf(twoFactorAuthenticator.verifyOtp(jsonString));
    }


    @PostMapping("/user")
    public String check2faUser(@RequestBody String jsonString) throws JsonProcessingException {
        return String.valueOf(twoFactorAuthenticator.verifyOtpUser(jsonString));
    }

    @PostMapping("/2fa")
    public String create2fa(@RequestBody String jsonString) throws IOException, WriterException {
        JSONObject requestData = new JSONObject(jsonString);
        if (!requestData.has("secretKey") && requestData.has("username")) {
            return String.valueOf(twoFactorAuthenticator.update2fa());
        } else {
            return String.valueOf(twoFactorAuthenticator.findUpdate2fa(jsonString));
        }
    }

    @PostMapping("/2faVerify")
    public String verifyCreate(@RequestBody String jsonString) {
        return String.valueOf(twoFactorAuthenticator.verifyCreate(jsonString));

    }

    @PostMapping("/verifyLogin")
    public String verifyLogin(@RequestBody String jsonString) {
        return String.valueOf(twoFactorAuthenticator.verifyLogin(jsonString));

    }

    @GetMapping("/off2fa")
    public String off2fa() {
        return String.valueOf(twoFactorAuthenticator.off2fa());

    }
}
