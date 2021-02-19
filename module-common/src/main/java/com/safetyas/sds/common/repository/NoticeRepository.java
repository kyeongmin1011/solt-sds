package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.entity.Notice;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice,Long>, NoticeRepositoryCustom {

  List<Notice> findTop5ByOrderByNoticeSeqDesc();
}
