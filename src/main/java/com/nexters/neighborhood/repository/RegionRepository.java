package com.nexters.neighborhood.repository;

import com.nexters.neighborhood.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */
public interface RegionRepository extends JpaRepository<Region, Long> {

    @Query(value = "SELECT * FROM room r WHERE r.region_id = ?1", nativeQuery = true)
    List<Region> findRoomsByRegionId(Long regionId);
}
