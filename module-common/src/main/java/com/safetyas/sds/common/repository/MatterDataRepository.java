package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.entity.msds.MatterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatterDataRepository extends JpaRepository<MatterData, String> {

}
