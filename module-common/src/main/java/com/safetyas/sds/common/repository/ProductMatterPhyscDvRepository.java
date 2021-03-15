package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.entity.msds.ProductMatterPhyscDv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMatterPhyscDvRepository extends JpaRepository<ProductMatterPhyscDv, Long> {

}
