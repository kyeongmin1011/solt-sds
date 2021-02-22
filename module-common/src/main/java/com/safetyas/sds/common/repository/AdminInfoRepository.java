package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.entity.AdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminInfoRepository extends JpaRepository<AdminInfo, Long> {

}
