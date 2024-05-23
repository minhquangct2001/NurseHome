package com.example.cssk.Controller;
import com.example.cssk.Service.Implement.RoomServiceImp;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
@CrossOrigin(origins = "http://localhost:3001/")
public class RoomController {

    private final RoomServiceImp roomServiceImp;


    public RoomController(RoomServiceImp roomServiceImp) {
        this.roomServiceImp = roomServiceImp;
    }

    @GetMapping()
    public String getAll(){
        return String.valueOf(roomServiceImp.getAllUser());
    }

    @GetMapping("/info")
    public String getInfo(){
        return String.valueOf(roomServiceImp.getInfoAllRoom());
    }

    @GetMapping("/{room}")
    public String getRooms(@PathVariable String room){
        return String.valueOf(roomServiceImp.getRoom(room));
    }

    @PostMapping()
    public String createRoom(@RequestBody String jsonString){
        return String.valueOf(roomServiceImp.createRoom(jsonString));
    }

    @PutMapping()
    public String updateRoom(@RequestBody String jsonString){
        return String.valueOf(roomServiceImp.updateRoom(jsonString));
    }

    @DeleteMapping()
    public String deleteRoom(@RequestBody String jsonString){
        return String.valueOf(roomServiceImp.deleteRoom(jsonString));
    }

    @GetMapping("/service/{serviceId}")
    public String findRoomService(@PathVariable Long serviceId){
        return String.valueOf(roomServiceImp.chooseService(serviceId));
    }

    @GetMapping("/getAllRoomElderly")
    public String getInfoLocation(){
        return String.valueOf(roomServiceImp.getAllRoomElderly());
    }

}

