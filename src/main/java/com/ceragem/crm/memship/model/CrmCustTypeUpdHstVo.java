package com.ceragem.crm.memship.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustTypeUpdHstVo
 * @author    user
 * @date    2022. 7. 3.
 * @Version    1.0
 * @description    고객유형업데이트이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCustTypeUpdHstVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 고객유형업데이트기본번호 
    */
    private String custTypeUpdBas;
    /**
    * 현재 유형코드(변경전) 
    */
    private String custTypeCd;
    private String custTypeCdNm;
    /**
    * 변경된 유형 코드 
    */
    private String upCustTypeCd;
    private String upCustTypeCdNm;
    /**
    * 통합고객기본번호 
    */
    private String itgCustNo;
    private String custNm;

    private int bbCnt;  // 본인 구매 수
    private int brCnt; // 추천인 구매 수
    private int hhCnt;  // 홈카페 수
    private int wwCnt;  // 웰카페 수
    private int mmCnt;  // 수신동의 수
    
}
