package com.nexters.neighborhood.repository;

import com.nexters.neighborhood.entity.Room;
import com.nexters.neighborhood.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by jinhaengji on 2016. 8. 13..
 */
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query(value = "SELECT * FROM room r WHERE r.region_id = ?1", nativeQuery = true)
    List<Room> findRoomsByRegionId(Long regionId);
}
