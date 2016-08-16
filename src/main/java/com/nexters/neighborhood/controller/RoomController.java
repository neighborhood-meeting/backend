package com.nexters.neighborhood.controller;

import com.nexters.neighborhood.entity.Room;
import com.nexters.neighborhood.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */

@RestController
@RequestMapping("/api")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    /** API Start **/
    @RequestMapping(value = "/rooms/region/{regionId}",method = {RequestMethod.POST})
    @ResponseBody
    public String makeRoom(@PathVariable Long regionId, @RequestBody Room room) {
        room.setRegionId(regionId);

        roomRepository.save(room);

        return room.toString();
    }

    @RequestMapping(value = "/rooms/region/{regionId}",method = {RequestMethod.GET})
    @ResponseBody
    public List<Room> findRoomsByRegionId(@PathVariable Long regionId) {
        return roomRepository.findRoomsByRegionId(regionId);
    }

    /** 해당하는 방 정보 주기 **/
    @RequestMapping(value = "/rooms/{id}",method = {RequestMethod.GET})
    @ResponseBody
    public Room rooms(@PathVariable Long id) { /** 정보가 post형식으로 body를 통해서 오기 때문에 **/
        return roomRepository.findOne(id);
    }

    /** API End **/

    /** 모든 방 정보 전달하기 **/
    @RequestMapping(value = "/rooms", method = {RequestMethod.GET})
    @ResponseBody
    public List<Room> rooms() {
        return roomRepository.findAll(); /** 모든 방 리스트 보여주기 **/
    }

    /** 방 생성 **/
    @RequestMapping(value = "/rooms",method = {RequestMethod.POST})
    @ResponseBody
    public String rooms(@RequestBody Room room) { /** 정보가 post형식으로 body를 통해서 오기 때문에 **/
        roomRepository.save(room); /** 저장 **/

        return room.toString();
    }

    /** 해당하는 방 삭제 **/
    @RequestMapping(value = "/rooms/{id}",method = {RequestMethod.DELETE})
    @ResponseBody
    public String roomDelete(@PathVariable Long id) { /** 정보가 post형식으로 body를 통해서 오기 때문에 **/
        Room room = roomRepository.findOne(id);
        roomRepository.delete(room);

        return "success!";
    }

    /** 해당하는 방 수정 **/
    @RequestMapping(value = "/rooms/{id}",method = {RequestMethod.PUT})
    @ResponseBody
    public String roomModify(@PathVariable Long id, @RequestBody Room room) { /** 정보가 post형식으로 body를 통해서 오기 때문에 **/
        Room savedRoom = roomRepository.findOne(id);

        if (room.getName() != null) {
            savedRoom.setName(room.getName());
        }

        if (room.getDescription() != null) {
            savedRoom.setDescription(room.getDescription());
        }

        if (room.getOwnerId() != null) {
            savedRoom.setOwnerId(room.getOwnerId());
        }

        if (room.getNotice() != null) {
            savedRoom.setNotice(room.getNotice());
        }

        roomRepository.save(savedRoom);

        return savedRoom.toString();
    }
}
