package com.nexters.neighborhood.service;

import com.nexters.neighborhood.entity.Participation;
import com.nexters.neighborhood.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dark on 2016. 8. 27..
 */
@Service
public class ParticipationService {

    @Autowired
    private ParticipationRepository participationRepository;

    public List<Participation> findByUserId(Long userId) {
        return participationRepository.findByUserId(userId);
    }
}
