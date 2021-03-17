package com.safetyas.sds.common.service;

import com.safetyas.sds.common.entity.info.InfoHazardGrade;
import com.safetyas.sds.common.entity.info.InfoPhrase;
import com.safetyas.sds.common.entity.msds.MatterData;
import com.safetyas.sds.common.entity.msds.Product;
import com.safetyas.sds.common.entity.msds.ProductMatter;
import com.safetyas.sds.common.entity.msds.ProductMatterEnv;
import com.safetyas.sds.common.entity.msds.ProductMatterHealth;
import com.safetyas.sds.common.entity.msds.ProductMatterLaw;
import com.safetyas.sds.common.entity.msds.ProductMatterPhyscChem;
import com.safetyas.sds.common.entity.msds.ProductMatterPhyscDv;
import com.safetyas.sds.common.model.info.InfoHazardGradeDTO;
import com.safetyas.sds.common.model.msds.MatterEnvDTO;
import com.safetyas.sds.common.model.msds.MatterHealthDTO;
import com.safetyas.sds.common.model.msds.MatterLawDTO;
import com.safetyas.sds.common.model.msds.MatterPhyscChemDTO;
import com.safetyas.sds.common.model.msds.MatterPhyscDvDTO;
import com.safetyas.sds.common.model.ProductMatterDTO;
import com.safetyas.sds.common.modelMapper.ModelMapperUtils;
import com.safetyas.sds.common.repository.MatterDataRepository;
import com.safetyas.sds.common.repository.ProductMatterEnvRepository;
import com.safetyas.sds.common.repository.ProductMatterHealthRepository;
import com.safetyas.sds.common.repository.ProductMatterLawRepository;
import com.safetyas.sds.common.repository.ProductMatterPhyscChemRepository;
import com.safetyas.sds.common.repository.ProductMatterPhyscDvRepository;
import com.safetyas.sds.common.repository.ProductMatterRepository;
import com.safetyas.sds.common.repository.ProductRepository;
import com.safetyas.sds.common.repository.info.InfoHazardGradeRepository;
import com.safetyas.sds.common.repository.info.InfoPhraseQueryRepository;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import lombok.RequiredArgsConstructor;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductMatterService {

  private final ProductMatterRepository productMatterRepository;
  private final ProductRepository productRepository;
  private final MatterDataRepository matterDataRepository;
  private final ProductMatterHealthRepository productMatterHealthRepository;
  private final ProductMatterEnvRepository productMatterEnvRepository;
  private final ProductMatterLawRepository productMatterLawRepository;
  private final ProductMatterPhyscDvRepository productMatterPhyscDvRepository;
  private final ProductMatterPhyscChemRepository productMatterPhyscChemRepository;
  private final InfoHazardGradeRepository infoHazardGradeRepository;
  private final InfoPhraseQueryRepository infoPhraseQueryRepository;

  public void insertProductMatter(ProductMatter productMatter) {
    productMatterRepository.save(productMatter);
  }

  public void updateProductMatter(Long productMatterSeq, ProductMatterDTO productMatterDTO) {
    ProductMatter productMatter = productMatterRepository.findById(productMatterSeq)
        .orElseThrow(NoSuchElementException::new);
    productMatter.updateProductMatter(productMatterDTO);
    productMatterRepository.save(productMatter);
  }

  public void deleteProductMatter(Long productMatterSeq) {
    ProductMatter productMatter = productMatterRepository.findById(productMatterSeq)
        .orElseThrow(NoSuchElementException::new);
    productMatter.updateDelDate();
    productMatterRepository.save(productMatter);
  }

  /**
   * 오픈소스 물질 라이브러리에서 가져온 정보로 제품 물질 입력.
   * - 오픈소스 데이터 가져오기.v
   * - 제품 물질에 오픈소스 데이터 세팅 v
   * - 제품 물질 구분값에 따른 msds 문구 세팅
   * - ProductMatter 리스트 반환.
   */
  public void insertFromMatterData(String matterDataKey, Long productSeq) {
    System.out.println("params3: matterdatakey "+matterDataKey+", productseq "+productSeq);

    MatterData matterData = matterDataRepository.findById(matterDataKey)
        .orElseThrow(NoSuchElementException::new);
    MatterEnvDTO matterEnvDTO = MatterEnvDTO.of(matterData.getMatterEnv());
    MatterHealthDTO matterHealthDTO = MatterHealthDTO.of(matterData.getMatterHealth());
    MatterPhyscDvDTO matterPhyscDvDTO = MatterPhyscDvDTO.of(matterData.getMatterPhyscDv());
    MatterPhyscChemDTO matterPhyscChemDTO = MatterPhyscChemDTO.of(matterData.getMatterPhyscChem());
    MatterLawDTO matterLawDTO = MatterLawDTO.of(matterData.getMatterLaw());

    Product product = productRepository.findById(productSeq)
        .orElseThrow(NoSuchElementException::new);

    ProductMatter productMatter = ProductMatter.builder()
        .cas(matterData.getCas())
        .chemName(matterData.getChemName())
        .premiumDbYn((matterData.getDbType().equals("P")) ? "Y" : "N")
        .matterDatabaseKey(matterData.getMatterDataKey())
        .product(product)
        .build();
    productMatterRepository.save(productMatter);

    ProductMatterEnv productMatterEnv = ProductMatterEnv.toEntity(matterEnvDTO);
    productMatterEnv.setProductMatter(productMatter);
    productMatterEnvRepository.save(productMatterEnv);

    ProductMatterHealth productMatterHealth = ProductMatterHealth.toEntity(matterHealthDTO);
    productMatterHealth.setProductMatter(productMatter);
    productMatterHealthRepository.save(productMatterHealth);

    ProductMatterPhyscDv productMatterPhyscDv = ProductMatterPhyscDv.toEntity(matterPhyscDvDTO);
    productMatterPhyscDv.setProductMatter(productMatter);
    productMatterPhyscDvRepository.save(productMatterPhyscDv);

    ProductMatterPhyscChem productMatterPhyscChem = ProductMatterPhyscChem.toEntity(matterPhyscChemDTO);
    productMatterPhyscChem.setProductMatter(productMatter);
    productMatterPhyscChemRepository.save(productMatterPhyscChem);

    ProductMatterLaw productMatterLaw = ProductMatterLaw.toEntity(matterLawDTO);
    productMatterLaw.setProductMatter(productMatter);
    productMatterLawRepository.save(productMatterLaw);

    String matterType = "";
    if (matterPhyscChemDTO.getAa1Apr().contains("고체")) {
      matterType = "solid";
    }else if (matterPhyscChemDTO.getAa1Apr().contains("액체")) {
      matterType = "liquid";
    } else if (matterPhyscChemDTO.getAa1Apr().contains("기체")) {
      matterType = "gas";
    }

    List<String> keyList = getKeyList(matterPhyscDvDTO, matterHealthDTO, productMatterEnv);

    Map<String, Object> param = new HashMap<>();
    param.put("matterType", matterType);
    param.put("keyList", keyList);

    List<InfoPhrase> infoPhraseList = infoPhraseQueryRepository.selectMsdsPhrase(param);
// TODO: 문구세팅, 리스트 반환.
    Map<String, String> phraseMap = new HashMap<>();


  }

  public List<String> getKeyList(MatterPhyscDvDTO matterPhyscDvDTO, MatterHealthDTO matterHealthDTO, ProductMatterEnv productMatterEnv) {
    List<String> divList = new ArrayList<>();
    divList.add(matterPhyscDvDTO.getDivisionA01());
    divList.add(matterPhyscDvDTO.getDivisionA02());
    divList.add(matterPhyscDvDTO.getDivisionA03());
    divList.add(matterPhyscDvDTO.getDivisionA04());
    divList.add(matterPhyscDvDTO.getDivisionA05());
    divList.add(matterPhyscDvDTO.getDivisionA06());
    divList.add(matterPhyscDvDTO.getDivisionA07());
    divList.add(matterPhyscDvDTO.getDivisionA08());
    divList.add(matterPhyscDvDTO.getDivisionA09());
    divList.add(matterPhyscDvDTO.getDivisionA10());
    divList.add(matterPhyscDvDTO.getDivisionA11());
    divList.add(matterPhyscDvDTO.getDivisionA12());
    divList.add(matterPhyscDvDTO.getDivisionA13());
    divList.add(matterPhyscDvDTO.getDivisionA14());
    divList.add(matterPhyscDvDTO.getDivisionA15());
    divList.add(matterPhyscDvDTO.getDivisionA16());
    divList.add(matterPhyscDvDTO.getDivisionA17());
    divList.add(matterPhyscDvDTO.getDivisionA18());
    divList.add(matterPhyscDvDTO.getDivisionA19());
    divList.add(matterHealthDTO.getDivisionB01());
    divList.add(matterHealthDTO.getDivisionB02());
    divList.add(matterHealthDTO.getDivisionB03());
    divList.add(matterHealthDTO.getDivisionB04());
    divList.add(matterHealthDTO.getDivisionB05());
    divList.add(matterHealthDTO.getDivisionB06());
    divList.add(matterHealthDTO.getDivisionB07());
    divList.add(matterHealthDTO.getDivisionB08());
    divList.add(matterHealthDTO.getDivisionB09());
    divList.add(matterHealthDTO.getDivisionB10());
    divList.add(matterHealthDTO.getDivisionB11());
    divList.add(matterHealthDTO.getDivisionB12());
    divList.add(matterHealthDTO.getDivisionB13());
    divList.add(matterHealthDTO.getDivisionB14());
    divList.add(matterHealthDTO.getDivisionB15());
    divList.add(matterHealthDTO.getDivisionB16());
    divList.add(matterHealthDTO.getDivisionB17());
    divList.add(matterHealthDTO.getDivisionB18());
    divList.add(productMatterEnv.getDivisionC01());
    divList.add(productMatterEnv.getDivisionC02());
    divList.add(productMatterEnv.getDivisionC03());

    // 모든 구분값 hazard_grade_key 리스트
    List<String> keyList = new ArrayList<>();

    // 모든 구분값 리스트
    List<InfoHazardGrade> allHazardGrade = infoHazardGradeRepository.findAllByOrderByHazardGradeKeyAsc();
    List<InfoHazardGradeDTO> hazardGradeDTOList = ModelMapperUtils.getModelMapper()
        .map(allHazardGrade, new TypeToken<List<InfoHazardGradeDTO>>() {
        }.getType());

    for(InfoHazardGradeDTO grade : hazardGradeDTOList ) {
      if(grade.getKor().equals(divList.get(grade.getElementNum()-1))) {
        keyList.add(grade.getHazardGradeKey());
      }
    }

    return keyList;
  }

}
