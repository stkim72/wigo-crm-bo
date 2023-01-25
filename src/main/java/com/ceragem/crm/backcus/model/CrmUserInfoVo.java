package com.ceragem.crm.backcus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmUserInfoVo{
	/**
    * <p>No.</p> 
    */
    private String userNum;
    /**
    * <p>사용자명</p> 
    */
    private String userName;
    /**
    * <p>사용자 ID</p> 
    */
    private String loginId;
    /**
    * <p>전화번호</p> 
    */
    private String userPhoneNumber;
    /**
    * <p>성별</p> 
    */
    private String userGender;
    /**
    * <p>이메일</p> 
    */
    private String userEmail;
    /**
    * <p>생년월일</p> 
    */
    private String userBirth;
    /**
    * <p>주소</p> 
    */
    private String userAddr;
    /**
	* <p>등록일자</p> 
	*/
    private String createdAt;
    /**
	* <p>수정일자</p> 
	*/
    private String updatedAt;
    /**
	* <p>메모</p> 
	*/
    private String userMemo;
	/**
	* <p>정보제공동의</p> 
	*/
    private String confirmAgreement;
}
