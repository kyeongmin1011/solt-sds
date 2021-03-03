package com.safetyas.sds.common.entity.msds;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "sds_user_product_msds")   // 물질 msds 문서 정보
public class UserProductMsds {

    @Id
    @Column(name = "user_product_msds_seq", length = 20)
    private Long userProductMsdsSeq;

    private String step01_01;
    private String step01_02;
    private String step01_03;
    private String step01_04;
    private String step01_05;

    private String step02_01;
    private String step02_02;
    private String step02_03;
    private String step02_04;
    private String step02_05;
    private String step01_06;
    private String step01_07;
    private String step01_08;

    private String step04_01;
    private String step04_02;
    private String step04_03;
    private String step04_04;
    private String step04_05;

    private String step05_01;
    private String step05_02;
    private String step05_03;

    private String step06_01;
    private String step06_02;
    private String step06_03;

    private String step07_01;
    private String step07_02;

    private String step08_01;
    private String step08_02;
    private String step08_03;
    private String step08_04;
    private String step08_05;

    private String step10_01;
    private String step10_02;
    private String step10_03;
    private String step10_04;

    private String step11_01;

    private String step13_01;
    private String step13_02;

    private String step14_01;
    private String step14_02;
    private String step14_03;
    private String step14_04;
    private String step14_05;
    private String step14_06;
    private String step14_07;

    private String step15_01;
    private String step15_02;
    private LocalDate step15_03;
    private String step15_04;
}
