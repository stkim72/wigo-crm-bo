package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustExprnHstVo
 * @author    user
 * @date    2022. 7. 15.
 * @Version    1.0
 * @description    CRM고객체험이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCustExprnHstVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * CUST_EXPRN_HST_NO 
    */
    private String custExprnHstNo;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * 회사코드 
    */
    private String cmpCd;
    /**
    * 영업조직코드 
    */
    private String salesOrgCd;
    /**
    * 점포코드 
    */
    private String storCd;
    /**
    * 체험일자 
    */
    private String exprnDate;
    /**
    * 체험번호 
    */
    private Integer exprnNo;
    /**
    * 좌석번호 
    */
    private String seatNo;
    /**
    * 상품코드 
    */
    private String itemCd;
    /**
    * 상품명 
    */
    private String itemNm;
    /**
    * 체험완료여부 
    */
    private String exprnCmptYn;
    /**
    * 체험삭제여부 
    */
    private String exprnDelYn;
    /**
    * 회원번호 
    */
    private String mshpNo;
    /**
    * 회원명 
    */
    private String mshpNm;
    /**
    * 회원ID 
    */
    private String mshpId;
    /**
    * 추천회원번호 
    */
    private String rcmdMshpNo;
    /**
    * 체험쿠폰번호 
    */
    private String exprnCoupnNo;
    /**
    * 승인번호 
    */
    private String apprNo;
    /**
    * 연령코드 
    */
    private String ageCd;
    /**
    * 연령코드명 
    */
    private String ageCdNm;
    /**
    * 성별코드 
    */
    private String gndrCd;
    /**
    * 성별코드명 
    */
    private String gndrCdNm;
    /**
    * 방문경험코드 
    */
    private String visitExprcCd;
    /**
    * 방문경험코드명 
    */
    private String visitExprcCdNm;
    /**
    * 유입경로코드 
    */
    private String ingrsPathCd;
    /**
    * 유입경로코드명 
    */
    private String ingrsPathCdNm;
    /**
    * 체험경험코드 
    */
    private String exprnExprcCd;
    /**
    * 체험경험코드명 
    */
    private String exprnExprcCdNm;    
    /**
    * 사용주의체크여부 
    */
    private String useAttenCheckYn;
    /**
    * 체험모드코드 
    */
    private String exprnModeCd;
    /**
    * 체험모드코드명 
    */
    private String exprnModeCdNm;
    /**
    * 상세모드코드 
    */
    private String dtlModeCd;
    /**
    * 상세모드코드명 
    */
    private String dtlModeCdNm;
    /**
    * 체험시작시간 
    */
    private String exprnStaHour;
    /**
    * 체험종료시간 
    */
    private String exprnEndHour;
    /**
    * 체험시간 
    */
    private Integer exprnHour;
    /**
    * 체험강도 
    */
    private String exprnStrth;
    /**
    * 체험강도명 
    */
    private String exprnStrthNm;
    /**
    * 내부기기온도 
    */
    private Integer insideEqpmtTmprt;
    /**
    * 복부마사지사용여부 
    */
    private String abmsgUseYn;
    /**
    * 체험중중간체크여부 
    */
    private String exprnMidcheckYn;
    /**
    * 구매상담여부 
    */
    private String buyCnslYn;
    /**
    * 체험평가코드 
    */
    private String exprnEstmtCd;
    /**
    * 체험평가코드명 
    */
    private String exprnEstmtCdNm;
    /**
    * 상담내용 
    */
    private String cnslCtnts;
}
