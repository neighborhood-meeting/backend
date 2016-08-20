package com.nexters.neighborhood.controller;

import com.nexters.neighborhood.entity.Region;
import com.nexters.neighborhood.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */

@RestController
@RequestMapping("/api/v1")
public class RegionController {

    @Autowired
    private RegionRepository regionRepository;

//    @Autowired
//    private UserRepository userRepository;

    /** API Start **/
//    @RequestMapping(value = "/regions/join/{roomId}",method = {RequestMethod.POST})
//    @ResponseBody
//    public String makeRoom(@PathVariable Long roomId, @RequestBody User user) {
////        User savedUser = userRepository.findByToken(user.getToken());
////        Region savedRoom = regionRepository.findOne(roomId);
////
////        List<Region> regions = savedUser.getRegions();
////        regions.add(savedRoom);
////
////        userRepository.saveAndFlush(savedUser);
//
//        return "success";
//    }

    @RequestMapping(value = "/rooms/region/{regionId}",method = {RequestMethod.POST})
    @ResponseBody
    public String makeRoom(@PathVariable Long regionId, @RequestBody Region region) {
        regionRepository.save(region);

        return region.toString();
    }

    @RequestMapping(value = "/rooms/region/{regionId}",method = {RequestMethod.GET})
    @ResponseBody
    public List<Region> findRoomsByRegionId(@PathVariable Long regionId) {
        return regionRepository.findRoomsByRegionId(regionId);
    }

    /** 해당하는 방 정보 주기 **/
    @RequestMapping(value = "/rooms/{id}",method = {RequestMethod.GET})
    @ResponseBody
    public Region rooms(@PathVariable Long id) { /** 정보가 post형식으로 body를 통해서 오기 때문에 **/
        return regionRepository.findOne(id);
    }

    /** API End **/

    /** 모든 방 정보 전달하기 **/
    @RequestMapping(value = "/rooms", method = {RequestMethod.GET})
    @ResponseBody
    public List<Region> rooms() {
        return regionRepository.findAll(); /** 모든 방 리스트 보여주기 **/
    }

    /** 방 생성 **/
    @RequestMapping(value = "/rooms",method = {RequestMethod.POST})
    @ResponseBody
    public String rooms(@RequestBody Region region) { /** 정보가 post형식으로 body를 통해서 오기 때문에 **/
        regionRepository.save(region); /** 저장 **/

        return region.toString();
    }

    /** 해당하는 방 삭제 **/
    @RequestMapping(value = "/rooms/{id}",method = {RequestMethod.DELETE})
    @ResponseBody
    public String roomDelete(@PathVariable Long id) { /** 정보가 post형식으로 body를 통해서 오기 때문에 **/
        Region region = regionRepository.findOne(id);
        regionRepository.delete(region);

        return "success!";
    }

    /** 해당하는 방 수정 **/
    @RequestMapping(value = "/rooms/{id}",method = {RequestMethod.PUT})
    @ResponseBody
    public String roomModify(@PathVariable Long id, @RequestBody Region region) { /** 정보가 post형식으로 body를 통해서 오기 때문에 **/
        Region savedRegion = regionRepository.findOne(id);

        if (region.getName() != null) {
            savedRegion.setName(region.getName());
        }

        if (region.getDescription() != null) {
            savedRegion.setDescription(region.getDescription());
        }

        if (region.getNotice() != null) {
            savedRegion.setNotice(region.getNotice());
        }

        regionRepository.save(savedRegion);

        return savedRegion.toString();
    }
}
