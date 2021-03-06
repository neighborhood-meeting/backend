package com.nexters.neighborhood.controller.region;

import com.nexters.neighborhood.dto.RegionSearchDto;
import com.nexters.neighborhood.exception.DuplicatedRoomCanNotJoinException;
import com.nexters.neighborhood.exception.ExceedLimitRegionCountException;
import com.nexters.neighborhood.dto.RegionDto;
import com.nexters.neighborhood.controller.user.UserIdAndRegionId;
import com.nexters.neighborhood.service.RegionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @RequestMapping(value = "/regions",method = {RequestMethod.POST})
    @ResponseBody
    public String makeRoom(@RequestBody RegionDto regionDto) {
        regionService.save(regionDto);

        return "success!";
    }

    @RequestMapping(value = "/regions/join",method = {RequestMethod.POST})
    @ResponseBody
    public String joinRegion(@RequestBody UserIdAndRegionId userIdAndRegionId) throws ExceedLimitRegionCountException, DuplicatedRoomCanNotJoinException {
        regionService.joinRoom(userIdAndRegionId);

        return "success!";
    }

    @RequestMapping(value = "/regions",method = {RequestMethod.GET})
    @ResponseBody
    public List<RegionDto> getRegions(@RequestParam Long userId) throws ExceedLimitRegionCountException, DuplicatedRoomCanNotJoinException {
        return regionService.findRegionsByUserId(userId);
    }

    @RequestMapping(value = "/regions/search",method = {RequestMethod.GET})
    @ResponseBody
    public List<RegionSearchDto> getSearchedRegions(@RequestParam String regionName) {
        return regionService.findRegionsLikeRegionName(regionName);
    }


}
