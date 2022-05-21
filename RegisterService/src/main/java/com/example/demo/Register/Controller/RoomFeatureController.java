package com.example.demo.Register.Controller;

import com.example.demo.Register.Helper.RoomFeatureHelper;
import com.example.demo.Register.Models.RoomFeature;
import com.example.demo.Register.Service.IRoomFeatureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/register/roomFeature")
public class RoomFeatureController {
    private IRoomFeatureService iRoomFeatureService;

    public RoomFeatureController(IRoomFeatureService iRoomFeatureService) {
        this.iRoomFeatureService = iRoomFeatureService;
    }

    @PostMapping("/create")
    public void createRoomFeature(@RequestBody RoomFeatureHelper roomFeatureHelper){
        this.iRoomFeatureService.createRoomFeature(roomFeatureHelper);
    }

    @GetMapping("/get/all/{roomType}")
    public List<RoomFeature> getAllByRoomId(@PathVariable("roomType") String roomType){
        return this.iRoomFeatureService.getAllRoomFeaturesByRoomType(roomType);
    }
}
