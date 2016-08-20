package com.nexters.neighborhood.service;

import com.nexters.neighborhood.exception.DuplicatedRoomCanNotJoinException;
import com.nexters.neighborhood.exception.ExceedLimitRegionCountException;
import com.nexters.neighborhood.dto.RegionDto;
import com.nexters.neighborhood.controller.model.UserIdAndRegionId;
import com.nexters.neighborhood.entity.Region;
import com.nexters.neighborhood.entity.User;
import com.nexters.neighborhood.repository.RegionRepository;
import com.nexters.neighborhood.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Dark on 2016. 8. 20..
 */
@Slf4j
@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private UserRepository userRepository;

    public void save(RegionDto regionDto) {
        Region region = new Region();

        region.setName(regionDto.getName());
        region.setDescription(regionDto.getDescription());
        region.setNotice(region.getNotice());

        regionRepository.saveAndFlush(region);
    }

    public void joinRoom(UserIdAndRegionId userIdAndRegionId) throws ExceedLimitRegionCountException, DuplicatedRoomCanNotJoinException {
        User user = userRepository.findOne(userIdAndRegionId.getUserId());

        List<Region> regions = user.getRegions();

        if (isExceededLimitRegionCount(regions)) {
            throw new ExceedLimitRegionCountException("가입할 수 있는 방의 최대 갯수를 넘었습니다.");
        }

        Region region = regionRepository.findOne(userIdAndRegionId.getRegionId());

        user.addRegion(region);

        try {
            userRepository.save(user);
        } catch (Exception e) {
            log.error("RegionService joinRoom Fail! {}", e);

            throw new DuplicatedRoomCanNotJoinException("동일한 방에 다시 가입하실 수 없습니다.");
        }
    }

    private boolean isExceededLimitRegionCount(List<Region> regions) {
        return regions.size() == 3;
    }
}