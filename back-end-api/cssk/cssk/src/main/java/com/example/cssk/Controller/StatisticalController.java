package com.example.cssk.Controller;
import com.example.cssk.Service.Implement.StatisticalServiceImp;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/statistical")
@CrossOrigin(origins = "http://localhost:3001/")
public class StatisticalController {

    private final StatisticalServiceImp statisticalServiceImp;

    public StatisticalController(StatisticalServiceImp statisticalServiceImp) {
        this.statisticalServiceImp = statisticalServiceImp;
    }

    @GetMapping()
    public String getStatistical(){
        return statisticalServiceImp.getStatistical().toString();
    }
}

