package com.safetyas.sds.common.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.entity.msds.Product;
import com.safetyas.sds.common.entity.msds.ProductMatter;
import com.safetyas.sds.common.model.CbiDocumentDTO;
import com.safetyas.sds.common.model.OrAgencyDTO;
import com.safetyas.sds.common.model.ProductDTO;
import com.safetyas.sds.common.model.ProductSearchCondition;
import com.safetyas.sds.common.model.QCbiDocumentDTO;
import com.safetyas.sds.common.model.QOrAgencyDTO;
import com.safetyas.sds.common.model.QRenewAgencyDTO;
import com.safetyas.sds.common.model.QRevisionAgencyProgressDTO;
import com.safetyas.sds.common.model.QRevisionAgencyRequestInfoDTO;
import com.safetyas.sds.common.model.QSubmissionAgencyDTO;
import com.safetyas.sds.common.model.QTranslationAgencyProgressDTO;
import com.safetyas.sds.common.model.QTranslationAgencyRequestInfoDTO;
import com.safetyas.sds.common.model.RenewAgencyDTO;
import com.safetyas.sds.common.model.RevisionAgencyProgressDTO;
import com.safetyas.sds.common.model.RevisionAgencyRequestInfoDTO;
import com.safetyas.sds.common.model.SubmissionAgencyDTO;
import com.safetyas.sds.common.model.TranslationAgencyProgressDTO;
import com.safetyas.sds.common.model.TranslationAgencyRequestInfoDTO;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import static com.safetyas.sds.common.entity.QMember.member;
import static com.safetyas.sds.common.entity.QMemberInfo.memberInfo;
import static com.safetyas.sds.common.entity.QMemberSupplier.memberSupplier;
import static com.safetyas.sds.common.entity.agency.QOrAgency.orAgency;
import static com.safetyas.sds.common.entity.agency.QRenewAgency.renewAgency;
import static com.safetyas.sds.common.entity.agency.QRevisionAgency.revisionAgency;
import static com.safetyas.sds.common.entity.agency.QSubmissionAgency.submissionAgency;
import static com.safetyas.sds.common.entity.agency.QTranslationAgency.translationAgency;
import static com.safetyas.sds.common.entity.msds.QProduct.product;
import static org.reflections.util.Utils.isEmpty;

@Repository
public class ProductQueryRepository {

  private final JPAQueryFactory queryFactory;

  public ProductQueryRepository(EntityManager em, ModelMapper modelMapper) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  public Product selectProductCbiAgencyById(Long id) {
    return queryFactory.selectFrom(product)
        .where(product.productSeq.eq(id), product.agencyCbiYn.eq("Y"))
        .fetchOne();
  }

  public List<SubmissionAgencyDTO> selectProductSubmissionAgency(Long id) {
    return queryFactory
        .select(new QSubmissionAgencyDTO(submissionAgency.inDate, submissionAgency.state,
            submissionAgency.note))
        .from(product)
        .leftJoin(product.submissionAgencyList, submissionAgency)
        .where(product.productSeq.eq(id), product.agencySubmissionYn.eq("Y"))
        .fetch();
  }

  public List<OrAgencyDTO> selectProductOrAgency(Long id) {
    return queryFactory
        .select(new QOrAgencyDTO(orAgency.state, orAgency.note))
        .from(product)
        .leftJoin(product.orAgencyList, orAgency)
        .where(product.productSeq.eq(id), product.agencyOrYn.eq("Y"))
        .fetch();
  }

  public List<RenewAgencyDTO> selectProductRenewAgency(Long id) {
    return queryFactory
        .select(new QRenewAgencyDTO(renewAgency.state, renewAgency.note))
        .from(product)
        .leftJoin(product.renewAgencyList, renewAgency)
        .where(product.productSeq.eq(id), product.agencyRenewYn.eq("Y"))
        .fetch();
  }

  public List<RevisionAgencyProgressDTO> selectRevisionProgress(Long id) {
    return queryFactory
        .select(new QRevisionAgencyProgressDTO(revisionAgency.state, revisionAgency.note))
        .from(product)
        .leftJoin(product.revisionAgencyList, revisionAgency)
        .where(product.productSeq.eq(id), product.agencyRevisionYn.eq("Y"))
        .fetch();
  }

  public RevisionAgencyRequestInfoDTO selectRevisionRequestInfo(Long id) {
    return queryFactory
        .select(new QRevisionAgencyRequestInfoDTO(product.revisionLanguage))
        .from(product)
        .where(product.productSeq.eq(id), product.agencyRevisionYn.eq("Y"))
        .fetchOne();
  }

  public List<TranslationAgencyProgressDTO> selectTranslationProgress(Long id) {
    return queryFactory
        .select(new QTranslationAgencyProgressDTO(translationAgency.inDate, translationAgency.state,
            translationAgency.note))
        .from(product)
        .leftJoin(product.translationAgencyList, translationAgency)
        .where(product.productSeq.eq(id), product.agencyTranslateYn.eq("Y"))
        .fetch();
  }

  public TranslationAgencyRequestInfoDTO selectTranslationRequestInfo(Long id) {
    return queryFactory
        .select(new QTranslationAgencyRequestInfoDTO(product.translationLanguage))
        .from(product)
        .where(product.productSeq.eq(id), product.agencyTranslateYn.eq("Y"))
        .fetchOne();
  }

  public CbiDocumentDTO selectCbiDocument(Long productSeq) {
    return queryFactory
        .select(
            new QCbiDocumentDTO(product.productUid, memberInfo.companyName, memberInfo.companyAddr1,
                memberInfo.companyAddr2))
        .from(product)
        .leftJoin(product.memberSupplier, memberSupplier)
        .leftJoin(memberSupplier.member, member)
        .leftJoin(member.memberInfo, memberInfo)
        .where(product.productSeq.eq(productSeq))
        .fetchOne();
  }

  public Page<ProductDTO> selectProductList(Pageable pageable,
      ProductSearchCondition condition) {
    /*QueryResults<ProductDTO> results = queryFactory
        .select(new QProductDTO(
            product.inDate,
            product.productSeq,
            product.productUid,
            product.finalSaveYn,
            product.language,
            product.agencyTranslateYn,
            product.agencyRevisionYn,
            product.tonsYear,
            product.agencySubmissionYn,
            product.agencyCbiDocYn,
            product.orYn))*/
    QueryResults<Product> results = queryFactory
        .selectFrom(product)
        .where(productUidEq(condition.getProductUid()), product.delDate.isNull())
        .offset(pageable.getOffset())
        .orderBy(product.productSeq.desc())
        .limit(pageable.getPageSize())
        .fetchResults();

    List<ProductDTO> collect = results.getResults()
        .stream()
        .map(product -> new ProductDTO(product.getInDate(), product.getProductSeq(),
            product.getProductUid(), product.getFinalSaveYn(), product.getLanguage(),
            product.getAgencyTranslateYn(), product.getAgencyRevisionYn(), product.getTonsYear(),
            product.getAgencySubmissionYn(), product.getAgencyCbiDocYn(), product.getOrYn(),
            product.getProductMatterList()
                .stream()
                .map(ProductMatter::getCas)
                .collect(Collectors.toList())))
        .collect(Collectors.toList());

    long total = results.getTotal();

    return new PageImpl<>(collect, pageable, total);
  }

  private BooleanExpression productUidEq(String productUid) {
    return isEmpty(productUid) ? null : product.productUid.eq(productUid);
  }

  public List<ProductDTO> selectProductLibrary(Long seq) {
    List<Product> productList = queryFactory.select(product)
        .from(product)
        .where(product.productSeq.eq(seq))
        .fetch();

    List<ProductDTO> productDTOList = productList
        .stream()
        .map(product -> new ProductDTO(product.getInDate(), product.getModDate(),
            product.getProductSeq(),
            product.getProductUid(),
            product.getProductMatterList()
                .stream()
                .map(ProductMatter::getCas)
                .collect(Collectors.toList())))
        .collect(Collectors.toList());

    return productDTOList;
  }
}
