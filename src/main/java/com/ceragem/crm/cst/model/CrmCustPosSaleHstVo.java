package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustPosSaleHstVo
 * @author    user
 * @date    2022. 6. 16.
 * @Version    1.0
 * @description    CRMPOS매출이력 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCustPosSaleHstVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;


/**
* 매출조회시작일자 
*/
private String strtDt;
/**
* 매출조회종료일자 
*/
private String endDt;

    /**
    * 매출일자 
    */
    private String saleDate;
    /**
    * 거래번호 
    */
    private String dealNo;
    /**
    * POS번호 
    */
    private String posNo;
    /**
    * 매장번호 
    */
    private String storNo;
    /**
    * 거래구분코드 
    */
    private String dealDivCd;
    /**
    * 거래구분명 
    */
    private String dealDivNm;
    /**
    * 통합고객번호 
    */
    private String itgCustNo;
    /**
    * 구매수량 
    */
    private Integer buyQnty;
    /**
    * 총매출금액 
    */
    private Integer totSaleAmt;
    /**
    * 할인금액 
    */
    private Integer dcAmt;
    /**
    * 실매출금액 
    */
    private Integer actsalAmt;
    /**
    * 부가세금액 
    */
    private Integer vatAmt;
    /**
    * 순매출금액 
    */
    private Integer netsalAmt;
}
