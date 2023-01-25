package com.ceragem.crm.memship.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CrmGodsBasVo
 * @author user
 * @date 2022. 5. 4.
 * @Version 1.0
 * @description CRM제품기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmGodsBasVo extends BaseVo {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	/**
	 * 제품번호
	 */
	private String godsNo;
	/**
	 * 제품명
	 */
	private String godsNm;
	/**
	 * 제품그룹코드
	 */
	private String godsGrpCd;
	/**
	 * 제품유형코드
	 */
	private String godsTypeCd;
	/**
	 * 제품상세유형코드
	 */
	private String godsDtlTypeCd;
	/**
	 * SAP자재코드
	 */
	private String sapProdCd;
	/**
	 * 색상명
	 */
	private String colrNm;
	/**
	 * 사용여부
	 */
	private String useYn;
	/**
	 * 시리얼사용여부
	 */
	private String serialUseYn;
	/**
	 * 재고관리여부
	 */
	private String stockMngYn;
	/**
	 * 판매여부
	 */
	private String salesYn;
	/**
	 * 차용재고여부
	 */
	private String borrwStockYn;
	/**
	 * 유통기한사용여부
	 */
	private String expryUseYn;
	/**
	 * 소비자금액
	 */
	private Integer cnsrAmt;
	/**
	 * 재고관리단위
	 */
	private String stockMngUnit;
	/**
	 * 구입금액
	 */
	private Integer prchsAmt;
	/**
	 * 도매금액
	 */
	private Integer whsalAmt;
	/**
	 * 판매금액
	 */
	private Integer salesAmt;
	/**
	 * 통화코드
	 */
	private String currCd;
	/**
	 * 입고처명
	 */
	private String stwhPlceNm;
	/**
	 * 제조사명
	 */
	private String manufacerNm;
	/**
	 * AS보증기간
	 */
	private Integer asGrntPerd;
	/**
	 * 내용연수수
	 */
	private Integer duryearCnt;
	/**
	 * 창고코드
	 */
	private String whousCd;
	/**
	 * 창고명
	 */
	private String whousNm;

	/**
	 * 제품군명
	 */
	private String godsTypeCdNm;
	/**
	 * 제품분류
	 */
	private String godsClassCd;

}
