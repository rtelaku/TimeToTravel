package com.example.demo.Register.Service;

import com.example.demo.Register.Helper.RoomFeatureHelper;
import com.example.demo.Register.Models.RoomFeature;
import com.example.demo.Register.Repository.RoomFeatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomFeatureService implements IRoomFeatureService{

    private RoomFeatureRepository roomFeatureRepository;
    private IRoomService iRoomService;

    public RoomFeatureService(RoomFeatureRepository roomFeatureRepository, IRoomService iRoomService) {
        this.roomFeatureRepository = roomFeatureRepository;
        this.iRoomService=iRoomService;
    }

    @Override
    public void createRoomFeature(RoomFeatureHelper roomFeatureHelper) {
        RoomFeature roomFeature = new RoomFeature(roomFeatureHelper.getFeature(), roomFeatureHelper.getRoomType());
        this.roomFeatureRepository.save(roomFeature);

    }

    @Override
    public List<RoomFeature> getAllRoomFeaturesByRoomType(String roomType) {
        return this.roomFeatureRepository.getRoomFeaturesByRoomType(roomType);
    }
}
