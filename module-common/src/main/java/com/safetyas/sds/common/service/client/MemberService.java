package com.safetyas.sds.common.service.client;

import com.safetyas.sds.common.entity.Member;
import com.safetyas.sds.common.entity.MemberInfo;
import com.safetyas.sds.common.entity.MemberSupplier;
import com.safetyas.sds.common.repository.MemberInfoRepository;
import com.safetyas.sds.common.repository.MemberRepository;
import com.safetyas.sds.common.repository.MemberSupplierQueryRepository;
import com.safetyas.sds.common.repository.MemberSupplierRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
  private final MemberInfoRepository memberInfoRepository;
  private final MemberSupplierRepository memberSupplierRepository;
  private final MemberSupplierQueryRepository memberSupplierQueryRepository;

  @Transactional
  public Optional<Member> findMemberByMemberId(String memberId) {
    return memberRepository.findByMemberId(memberId);
  }

  /**
   * 멤버 가져오기
   * @param memberSeq
   */
  public Optional<Member> findMemberById(Long memberSeq) {
    return memberRepository.findById(memberSeq);
  }

  /**
   * 멤버 저장
   * @param member
   * @return
   */
  public long saveMember(Member member) {
    Member savedMember = memberRepository.save(member);
    return savedMember.getMemberSeq();
  }

  /**
   * 멤버 추가정보 저장
   * @param memberInfo
   * @return
   */
  public MemberInfo saveMemberInfo(MemberInfo memberInfo) {
    return memberInfoRepository.save(memberInfo);
  }

  /**
   * 멤버 정보 반환
   * @param memberId
   */
  public Optional<Member> selectMemberInfo(String memberId) {
    return memberRepository.findByMemberId(memberId);
  }

  /**
   * 공급자 리스트
   * @return list
   */
  public List<MemberSupplier> selectMemberSuppliers(Long memberSeq) {
    return memberSupplierQueryRepository.selectMemberSuppliers(memberSeq);
  }

  /**
   * 공급자 저장
   * @param memberSupplier 공급자
   * @return 공급자
   */
  public MemberSupplier saveMemberSupplier(MemberSupplier memberSupplier) {
    return memberSupplierRepository.save(memberSupplier);
  }

  /**
   * 공급자에 상품 있는지 체크
   * @param memberSupplierSeq
   * @return
   */
  public boolean checkMemberSupplierProduct(Long memberSupplierSeq) {
    return memberSupplierQueryRepository
        .existsByProduct(memberSupplierSeq);
  }

  /**
   * 공급자 가져오기
   * @param memberSupplierSeq
   */
  public Optional<MemberSupplier> selectMemberSupplier(Long memberSupplierSeq) {
    return memberSupplierRepository.findById(memberSupplierSeq);
  }

  /**
   * 공급자 삭제
   * @param memberSupplierSeq
   */
  public void deleteMemberSupplier(Long memberSupplierSeq) {
    memberSupplierRepository.deleteById(memberSupplierSeq);
  }
}
