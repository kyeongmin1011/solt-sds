package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
