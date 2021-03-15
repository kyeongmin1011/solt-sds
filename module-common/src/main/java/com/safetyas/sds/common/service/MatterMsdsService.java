package com.safetyas.sds.common.service;

import com.safetyas.sds.common.repository.MatterMsdsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatterMsdsService {

  private final MatterMsdsRepository matterMsdsRepository;

  public void updateStep01() {

  }

  /**
   * step2 구분값을 업데이트.
   */
  public void updateStep02() {
    ResetPhrases();
  }

  /**
   * step2 유해성 위험성 선택 구분값에 따른 문구 다시 설정.
   */
  public void ResetPhrases() {

  }

  /**
   * step4 응급조치 요령 업데이트
   * (ProductMatterMsds)
   */
  public void updateStep04() {

  }

  /**
   * step5 폭발 화재시 대처방법 업데이트
   * (ProductMatterMsds)
   */
  public void updateStep05() {

  }

  /**
   * step6 누출사고시 대처방법 업데이트
   * (ProductMatterMsds)
   */
  public void updateStep06() {

  }

  /**
   * step7 취급 및 저장방법 업데이트
   * (ProductMatterMsds)
   */
  public void updateStep07() {

  }

  /**
   * step8 노출방지 및 저장방법 업데이트
   * (ProductMatterMsds)
   */
  public void updateStep08() {

  }

  /**
   * step9 물리화학적 특성 업데이트
   * (ProductMatter)
   */
  public void updateStep09() {

    resetDevisions();
  }

  /**
   * 물리화학적 특성에 따른 구분값 업데이트하고 문구도 업데이트
   */
  public void resetDevisions () {

  }

  /**
   * step10 안정성 및 반응성 업데이트
   */
  public void updateStep10() {

  }

  /**
   * step11 독성에 관한 정보 업데이트
   * 가. 가능성이 높은 노출 경로에 관한 커스텀 정보
   * 나. 건강유해성 정보 (ProductMatter)
   */
  public void updateStep11() {

  }

  /**
   * step12 환경에 미치는 영향 업데이트
   * (ProductMatter)
   */
  public void updateStep12() {

  }

  /**
   * step13 폐기시 주의사항 업데이트
   * (ProductMatterMsds)
   */
  public void updateStep13() {

  }

  /**
   * step14 운송에 필요한 정보 업데이트
   * (ProductMatterMsds)
   */
  public void updateStep14() {

  }

  /**
   * step15 법적 규제현황 업데이트
   * (ProductMatterMsds)
   */
  public void updateStep15() {

  }

  /**
   * step16 그밖에 참고사항 업데이트
   * (ProductMatterMsds)
   */
  public void updateStep16() {

  }

}
