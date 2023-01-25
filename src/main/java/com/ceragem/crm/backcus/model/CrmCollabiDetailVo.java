package com.ceragem.crm.backcus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmCollabiDetailVo extends CrmUserInfoVo{
	/**
	* <p>Seq</p> 
	*/
    private String collabiSeq;
    /**
	* <p>상담일자</p> 
	*/
    private String counselDt;
    /**
	* <p>HMS</p> 
	*/
    private String collabiHms;
    /**
	* <p>상담원명</p> 
	*/
    private String agentNm;
    /**
	* <p>전화번호</p> 
	*/
	private String userPhone;
	/**
	* <p>고객명</p> 
	*/
    private String clientNm;
    /**
	* <p>질문</p> 
	*/
    private String clientQ;
    /**
	* <p>답변</p> 
	*/
    private String clientA;
}
