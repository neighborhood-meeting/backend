package com.nexters.neighborhood.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Dark on 2016. 8. 23..
 */
@Data
@Entity
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "userId")
    private User recentParticipatedUser;

    @OneToOne(mappedBy = "participation")
    private Article participatedArticle;

    private Date recentParticipatedDate;

    private Long participantCount;

    public void addParticipantCount() {
        if (participantCount == null) {
            this.participantCount = 1L;
            return;
        }

        this.participantCount++;
    }

    @PostPersist
    void recentParticipatedDate() {
        recentParticipatedDate = new Date();
    }
}
