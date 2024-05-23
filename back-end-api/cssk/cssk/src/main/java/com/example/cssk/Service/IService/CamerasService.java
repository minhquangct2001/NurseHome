package com.example.cssk.Service.IService;

import org.json.JSONObject;

public interface CamerasService {

    String getAllCameras();

    JSONObject createCameras(String jsonString);

    JSONObject updateCameras(String jsonString, String camerasId);

    JSONObject deleteCameras( String camerasId);

    JSONObject show_result(String status, String message);
}
