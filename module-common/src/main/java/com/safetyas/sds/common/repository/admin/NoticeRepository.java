package com.safetyas.sds.common.repository.admin;

import com.safetyas.sds.common.entity.Notice;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.NoticeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice,Long>, NoticeRepositoryCustom {
}
