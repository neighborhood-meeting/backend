package com.nexters.neighborhood.service;

import com.google.common.collect.Lists;
import com.nexters.neighborhood.dto.RoomDto;
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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(RegionDto regionDto) {
        Region region = new Region();

        region.setName(regionDto.getName());
        region.setDescription(regionDto.getDescription());
        region.setNotice(regionDto.getNotice());

        regionRepository.saveAndFlush(region);
    }

    public void joinRoom(UserIdAndRegionId userIdAndRegionId) throws ExceedLimitRegionCountException, DuplicatedRoomCanNotJoinException {
        User user = userRepository.findOne(userIdAndRegionId.getUserId());

        List<Region> regions = user.getRegions();

        if (isExceededLimitRegionCount(regions)) {
            throw new ExceedLimitRegionCountException("가입할 수 있는 방의 최대 갯수를 넘었습니다.");
        }

        if (isJoinedDuplicatedRoom(userIdAndRegionId)) {
            throw new DuplicatedRoomCanNotJoinException("동일한 방에 다시 가입하실 수 없습니다.");
        }

        Region region = regionRepository.findOne(userIdAndRegionId.getRegionId());

        user.addRegion(region);

        userRepository.save(user);
    }

    private boolean isJoinedDuplicatedRoom(UserIdAndRegionId userIdAndRegionId) {
        String sql = "select * from user_region where user_id = ? and region_id = ?";

        List<Map<String, Object>> queryResults = jdbcTemplate.queryForList(sql, new Object[]{userIdAndRegionId.getUserId(), userIdAndRegionId.getRegionId()});

        if (queryResults.isEmpty()) {
            return false;
        }

        return true;
    }

    private boolean isExceededLimitRegionCount(List<Region> regions) {
        return regions.size() == 3;
    }

    public List<RoomDto> findRegionsByUserId(Long userId) {
        String sql = "select * from regions where id in (select region_id from user_region where user_id = ?)";

        List<Map<String, Object>> queryResults = jdbcTemplate.queryForList(sql, new Object[]{userId});

        List<RoomDto> rooms = Lists.newArrayList();

        if (queryResults.isEmpty()) {
            return Lists.newArrayList();
        }

        for (Map<String, Object> queryResult : queryResults) {
            RoomDto room = new RoomDto();

            room.setId((Long) queryResult.get("id"));
            room.setDescription((String) queryResult.get("description"));
            room.setName((String) queryResult.get("name"));
            room.setNotice((String) queryResult.get("notice"));

            rooms.add(room);
        }

        return rooms;
    }
}