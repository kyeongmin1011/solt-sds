package com.safetyas.sds.common.service.admin;

import com.safetyas.sds.common.entity.Faq;
import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.model.BoardSearchCondition;
import com.safetyas.sds.common.model.FaqDTO;
import com.safetyas.sds.common.repository.FaqRepository;
import com.safetyas.sds.common.repository.MemberRepository;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FaqService {

  private final MemberRepository memberRepository;
  private final FaqRepository faqRepository;
  private final ModelMapper modelMapper;

  @Transactional
  public FaqDTO selectFaq(Long id) {
    return modelMapper.map(faqRepository.findById(id), FaqDTO.class);
  }

  @Transactional
  public long insertFaq(Faq faq) {
    Member member = memberRepository.findById(1L).orElseThrow(NoSuchElementException::new);
    faq.updateMember(member);
    return faqRepository.save(faq).getFaqSeq();
  }

  @Transactional
  public void updateFaq(Long id, FaqDTO faqDto) {
    Faq faq = faqRepository.findById(id).orElseThrow(NoSuchElementException::new);
    faq.updateFaq(faqDto);
    faqRepository.save(faq);
  }

  @Transactional
  public void deleteFaq(Long id) {
    Faq faq = faqRepository.findById(id).orElseThrow(NoSuchElementException::new);
    faq.updateDelDate();
    faqRepository.save(faq);
  }

  public Page<FaqDTO> selectFaqList(Pageable pageable, BoardSearchCondition condition) {
    return faqRepository.selectFaqList(pageable, condition);
  }
}
