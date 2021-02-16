package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.entity.MemberBoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberBoardCommentRepository extends JpaRepository<MemberBoardComment,Long> {

}
