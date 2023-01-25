package com.ceragem.crm.mem.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    ProductHomeVo
 * @author    황의겸
 * @date    2022. 5. 12.
 * @Version    1.0
 * @description    제품 정보 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class ProductHomeVo extends BaseVo {
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
    * 제품분류코드 
    */
    private String godsClassCd;
    /**
    * 소비자금액 
    */
    private Integer cnsrAmt;
    /**
    * 사용여부 
    */
    private String useYn;
    /**
    * 사용여부 
    */
    private String productUseYn;
    
    /**
    * GODS_GRP_CD 
    */
    private String godsGrpCd;
}