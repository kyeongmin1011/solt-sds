package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.entity.ProductMatter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMatterRepository extends JpaRepository<ProductMatter,Long> {

}
