package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.entity.MemberSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberSupplierRepository extends JpaRepository<MemberSupplier, Long> {

}
