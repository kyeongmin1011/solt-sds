package com.safetyas.sds.common.repository.msds;

import com.safetyas.sds.common.entity.msds.ProductMatterPhyscChem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMatterPhyscChemRepository extends JpaRepository<ProductMatterPhyscChem, Long> {

}
