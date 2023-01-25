package com.ceragem.crm.backcus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmUserInfoDetailVo extends CrmUserInfoVo{
    /**
	* <p>등급 코드</p> 
	*/
    private String gradeCd;
    /**
	* <p>등급 레벨</p> 
	*/
    private String gradeLevel;
    /**
	* <p>외국인 유저</p> 
	*/
    private String foreignUser;
    /**
	* <p>매장 방문 여부</p> 
	*/
    private String storeVisit;
    /**
	* <p>추천 직원 ID</p> 
	*/
    private String recomStoreId;
}
