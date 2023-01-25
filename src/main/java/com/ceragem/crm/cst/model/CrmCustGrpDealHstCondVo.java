package com.ceragem.crm.cst.model;

import java.lang.reflect.Field;
import java.util.List;

import com.ceragem.crm.common.model.BaseVo;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.util.Utilities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmCustGrpDealHstCondVo extends BaseVo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	* 고객그룹번호 
	*/
	private String custGrpNo;
	
	/**
	* 거래일 시작 
	*/
	private String dealDaySta;
	
	/**
	* 거래일 종료 
	*/
	private String dealDayEnd;
	
	/**
	* 구매총금액 시작 
	*/
	private String buyTotAmtSta;
	
	/**
	* 구매총금액 종료 
	*/
	private String buyTotAmtEnd;
	
	/**
	* 결제총금액 시작 
	*/
	private String payTotAmtSta;
	
	/**
	* 결제총금액 종료 
	*/
	private String payTotAmtEnd;
	
	/**
	* 구매채널코드 
	*/
	private Object buyChlCd;
	
	/**
	* 제품적용 여부 
	*/
	private Object godsExcldYn;
	
	/**
	* 제품조건 리스트 
	*/
	private List<EzMap> godsList;
	
	
	public String getBuyChlCd() {
		return Utilities.convArryToStrs(this.buyChlCd, ",");
	}
	
	public List<String> getBuyChlCds() {
		return Utilities.convStrsToArry(this.buyChlCd, ",");
	}
	
	/**
	 * VO객체의 모든 속성값이 NULL인지를 체크한다.
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public boolean getIsAllDataNull() throws Exception{
		boolean rtnVal = false;
		int rtnIdx = 0;
		for (Field field : this.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			//아래 속성은 체크를 하지 않는다.
			if(field.getName().equals("serialVersionUID") || field.getName().equals("custGrpNo") || field.getName().equals("godsExcldYn")) continue;
			String sVal = "";
			
			if(field.getName().equals("godsList")) {
				List<EzMap> godsList = (List<EzMap>)field.get(this);
				if(godsList != null&&godsList.size() > 0) {
						sVal = Utilities.nullCheck(godsList);
				}
			}else {
				sVal = Utilities.nullCheck(field.get(this));
			}
			
			if(!sVal.equals("")) {
				rtnIdx += 1;
			}
//System.out.println("%%%%%%%%%%%%%% field : "+field.getName()+" | value : " + sVal);
		}
		if(rtnIdx < 1) rtnVal = true;
//System.out.println("%%%%%%%getIsAllDataNull%%%%%%% 결과 : "+ rtnVal);
		return rtnVal;
	}
}
