package com.nexters.neighborhood.dto;

import lombok.Data;

/**
 * Created by Dark on 2016. 8. 26..
 */
@Data
public class RegionSearchDto {
    private Long regionId;
    private Integer memberCount;
    private String name;
    private String description;
    private String notice;
}
