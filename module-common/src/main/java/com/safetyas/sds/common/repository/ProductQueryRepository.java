package com.safetyas.sds.common.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.safetyas.sds.common.entity.Product;
import com.safetyas.sds.common.model.CbiDocumentDTO;
import com.safetyas.sds.common.model.OrAgencyDTO;
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
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import static com.safetyas.sds.common.entity.QMember.member;
import static com.safetyas.sds.common.entity.QMemberInfo.memberInfo;
import static com.safetyas.sds.common.entity.QMemberSupplier.memberSupplier;
import static com.safetyas.sds.common.entity.QOrAgency.orAgency;
import static com.safetyas.sds.common.entity.QProduct.product;
import static com.safetyas.sds.common.entity.QRenewAgency.renewAgency;
import static com.safetyas.sds.common.entity.QRevisionAgency.revisionAgency;
import static com.safetyas.sds.common.entity.QSubmissionAgency.submissionAgency;
import static com.safetyas.sds.common.entity.QTranslationAgency.translationAgency;

@Repository
public class ProductQueryRepository {

  private final JPAQueryFactory queryFactory;

  public ProductQueryRepository(EntityManager em) {
    this.queryFactory = new JPAQueryFactory(em);
  }

  public Product selectProductCbiAgencyById(Long id) {
    return queryFactory.selectFrom(product)
        .where(product.productSeq.eq(id), product.agencyCbiYn.eq("Y"))
        .fetchOne();
  }

  public List<SubmissionAgencyDTO> selectProductSubmissionAgency(Long id) {
    return queryFactory
        .select(new QSubmissionAgencyDTO(submissionAgency.state, submissionAgency.note))
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

  public TranslationAgencyProgressDTO selectTranslationProgress(Long id) {
    return queryFactory
        .select(new QTranslationAgencyProgressDTO(translationAgency.state, translationAgency.note,
            translationAgency.inDate))
        .from(product)
        .leftJoin(product.translationAgencyList, translationAgency)
        .where(product.productSeq.eq(id), product.agencyTranslateYn.eq("Y"))
        .fetchOne();
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
        .select(new QCbiDocumentDTO(product.productUid,memberInfo.companyName,memberInfo.companyAddr1,memberInfo.companyAddr2))
        .from(product)
        .leftJoin(product.memberSupplier, memberSupplier)
        .leftJoin(memberSupplier.member, member)
        .leftJoin(member.memberInfo,memberInfo)
        .where(product.productSeq.eq(productSeq))
        .fetchOne();
  }
}
