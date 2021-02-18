package com.safetyas.sds.common.repository;

import com.safetyas.sds.common.entity.Faq;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.FaqDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Long>, FaqRepositoryCustom {

  Page<FaqDto> selectFaqList(BoardSearchCondition condition, Pageable pageable);
}
