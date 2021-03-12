package com.safetyas.sds.common.service;

import com.safetyas.sds.common.entity.msds.MatterData;
import com.safetyas.sds.common.entity.msds.MatterEnv;
import com.safetyas.sds.common.entity.msds.Product;
import com.safetyas.sds.common.entity.msds.ProductMatter;
import com.safetyas.sds.common.entity.msds.ProductMatterEnv;
import com.safetyas.sds.common.entity.msds.ProductMatterHealth;
import com.safetyas.sds.common.entity.msds.ProductMatterLaw;
import com.safetyas.sds.common.entity.msds.ProductMatterPhyscChem;
import com.safetyas.sds.common.entity.msds.ProductMatterPhyscDv;
import com.safetyas.sds.common.model.MatterEnvDTO;
import com.safetyas.sds.common.model.MatterHealthDTO;
import com.safetyas.sds.common.model.MatterLawDTO;
import com.safetyas.sds.common.model.MatterPhyscChemDTO;
import com.safetyas.sds.common.model.MatterPhyscDvDTO;
import com.safetyas.sds.common.model.ProductMatterDTO;
import com.safetyas.sds.common.repository.MatterDataRepository;
import com.safetyas.sds.common.repository.ProductMatterEnvRepository;
import com.safetyas.sds.common.repository.ProductMatterHealthRepository;
import com.safetyas.sds.common.repository.ProductMatterLawRepository;
import com.safetyas.sds.common.repository.ProductMatterPhyscChemRepository;
import com.safetyas.sds.common.repository.ProductMatterPhyscDvRepository;
import com.safetyas.sds.common.repository.ProductMatterRepository;
import com.safetyas.sds.common.repository.ProductRepository;
import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
  private final ModelMapper modelMapper;

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
        .premiumDbYn((matterData.getDbType() == "P") ? "Y" : "N")
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

    // TODO: 문구세팅, 리스트 반환.
  }
}
