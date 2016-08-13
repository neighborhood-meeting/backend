package com.nexters.neighborhood.repository;

import com.nexters.neighborhood.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample, String> {
}
