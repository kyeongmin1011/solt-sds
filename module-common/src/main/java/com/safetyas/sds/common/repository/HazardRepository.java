package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.entity.HazardIdentification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HazardRepository extends JpaRepository<HazardIdentification, Long> {

}
