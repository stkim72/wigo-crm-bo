package com.ceragem.crm.backcus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmAsDetailVo extends CrmUserInfoVo{
	/**
	* <p>AS CASE ID</p> 
	*/
    private String asCaseId;
    /**
	* <p>고객 ID</p> 
	*/
    private String customerId;
    /**
	* <p>고객명</p> 
	*/
    private String customerName;
    /**
	* <p>ACCEPT REMARK</p> 
	*/
    private String acceptRemark;
    /**
	* <p>COMPLETE REMARK</p> 
	*/
	private String completeRemark;
	/**
	* <p>방문비용</p> 
	*/
    private String visitCost;
    /**
	* <p>전체비용</p> 
	*/
    private String totalCost;
    /**
	* <p>서비스비용</p> 
	*/
    private String serviceCost;
    /**
	* <p>설치비용</p> 
	*/
    private String installationCost;
    /**
	* <p>완료일자</p> 
	*/
    private String completeDate;
    /**
	* <p>완료시간</p> 
	*/
    private String completeTime;
    /**
	* <p>AS 기사 ID</p> 
	*/
    private String asEngineerId;
    /**
	* <p>전화번호</p> 
	*/
    private String asPhone;
    /**
	* <p>휴대전화번호</p> 
	*/
    private String asMobile;
    /**
	* <p>ZIP CODE</p> 
	*/
    private String asZipcode;
    /**
	* <p>주소</p> 
	*/
    private String asAddress;
    /**
	* <p>상세 주소</p> 
	*/
    private String detailAddr;
    /**
	* <p>이메일</p> 
	*/
    private String asEmail;
}
