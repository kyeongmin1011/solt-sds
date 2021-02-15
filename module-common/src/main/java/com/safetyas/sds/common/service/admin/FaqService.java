package com.safetyas.sds.common.service.admin;

import com.safetyas.sds.common.entity.Faq;
import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.model.FaqDto;
import com.safetyas.sds.common.repository.MemberRepository;
import com.safetyas.sds.common.repository.admin.FaqRepository;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FaqService {

  private final MemberRepository memberRepository;
  private final FaqRepository faqRepository;
  private final ModelMapper modelMapper;

  @Transactional
  public FaqDto selectFaq(Long id) {
    return modelMapper.map(faqRepository.findById(id), FaqDto.class);
  }

  @Transactional
  public void insertFaq(Faq faq) {
    Member member = memberRepository.findById(1L).orElseThrow(NoSuchElementException::new);
    faq.updateMember(member);
    faqRepository.save(faq);
  }

  @Transactional
  public void updateFaq(Long id, FaqDto faqDto) {
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
}
