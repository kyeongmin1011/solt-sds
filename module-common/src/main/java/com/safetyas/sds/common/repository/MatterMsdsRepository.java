package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.entity.msds.ProductMatterMsds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatterMsdsRepository extends JpaRepository<ProductMatterMsds, Long> {

}