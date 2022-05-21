package com.example.demo.Register.Service;

import com.example.demo.Register.Helper.RoomFeatureHelper;
import com.example.demo.Register.Models.RoomFeature;

import java.util.List;

public interface IRoomFeatureService {

    void createRoomFeature(RoomFeatureHelper roomFeatureHelper);

    List<RoomFeature> getAllRoomFeaturesByRoomType(String roomType);
}
