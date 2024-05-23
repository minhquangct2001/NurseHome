package com.example.cssk.Service.IService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.zxing.WriterException;
import org.json.JSONObject;

import java.io.IOException;

public interface TwoFactorAuthenticatorService {
    JSONObject update2fa() throws IOException, WriterException;
    JSONObject verifyLogin(String jsonString);


    // Turn off 2FA for a user
    JSONObject off2fa();

    String findUpdate2fa(String jsonString) throws JsonProcessingException;
    JSONObject verifyCreate(String jsonString);
}
