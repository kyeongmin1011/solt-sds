package com.safetyas.sds.admin.api.service;

import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.FaqDto;
import com.safetyas.sds.common.service.admin.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminFaqService {

  private final FaqService faqService;

  public FaqDto selectFaq(Long id) {
    return faqService.selectFaq(id);
  }

  public void insertFaq(FaqDto faqDto) {
    faqService.insertFaq(faqDto.toEntity());
  }

  public void updateFaq(Long id,FaqDto faqDto) {
    faqService.updateFaq(id,faqDto);
  }

  public void deleteFaq(Long id) {
    faqService.deleteFaq(id);
  }

  public Page<FaqDto> selectFaqList(BoardSearchCondition condition, Pageable pageable) {
    return faqService.selectFaqList(condition,pageable);
  }
}
