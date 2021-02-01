package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.entity.MemberBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberBoardRepository extends JpaRepository<MemberBoard, Long> {

}
