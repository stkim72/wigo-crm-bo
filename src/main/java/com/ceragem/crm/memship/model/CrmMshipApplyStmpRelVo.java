package com.ceragem.crm.memship.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmMshipApplyStmpRelVo extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String stmpHstSeq;
	private String mshipStmpBasNo;
	private String itgCustNo;
	private String mshipGradeCd;
	private String storNo;
	private String accumDt;
	private String useDt;
	private String stmpBasNm;
	private String fromUsePossDt;
	private String toUsePossDt;
	private String buyGodsNo;
	private Integer stmpAccumQnty;
	private Integer issueCnt;
	private Integer ordrQnty;
	private Integer ordrAmt;
	private Integer payAmt;
	private String payChlCd;
	private String pblsStmpNo;
	private String statusCd;
	private String coupnNo;
	private Integer pointScore;
	private String chitNo;
	private String admtMethCd;
	private String useTypeCd;
	private String amdrId;
	private String amdDt;
	private String regrId;
	private String regDt;
	private String regChlCd;
}
