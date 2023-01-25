package com.ceragem.crm.cst.model;

import java.lang.reflect.Field;
import java.util.List;

import com.ceragem.crm.common.model.BaseVo;
import com.ceragem.crm.common.util.Utilities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmCustGrpCnttHstCondVo extends BaseVo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	* 고객그룹번호 
	*/
	private String custGrpNo;
	
	/**
	* 측정횟수 시작 
	*/
	private String mesrCntSta;
	
	/**
	* 측정횟수 종료 
	*/
	private String mesrCntEnd;
	
	/**
	* 측정일 시작 
	*/
	private String mesrDaySta;
	
	/**
	* 측정일 종료 
	*/
	private String mesrDayEnd;
	
	/**
	* 상담유형코드 
	*/
	private Object cnslgTypeCd;
	
	/**
	* 상담일 시작 
	*/
	private String cnslgDaySta;
	
	/**
	* 상담일 종료 
	*/
	private String cnslgDayEnd;
	
	/**
	* 상담횟수 시작
	*/
	private String cnslgCntSta;
	
	/**
	* 상담횟수 종료
	*/
	private String cnslgCntEnd;
	
	/**
	* DNA검사여부 
	*/
	private String dnaChkYn;
	
	/**
	* DNA검사일 시작 
	*/
	private String dnaChkDaySta;
	
	/**
	* DNA검사일 종료 
	*/
	private String dnaChkDayEnd;
	
	/**
	* 보증 만료일 시작 
	*/
	private String grntExpDaySta;
	
	/**
	* 보증 만료일 종료 
	*/
	private String grntExpDayEnd;
	
	/**
	* AS일 시작 
	*/
	private String asDaySta;
	
	/**
	* AS일 종료 
	*/
	private String asDayEnd;
	
	/**
	* IOT사용 유무
	*/
	private String iotUseExcldYn;
	
	/**
	* IOT사용일 시작 
	*/
	private String iotUseDaySta;
	
	/**
	* IOT사용일 종료 
	*/
	private String iotUseDayEnd;
	
	/**
	* IOT사용 횟수 시작 
	*/
	private String iotUseCntSta;
	
	/**
	* IOT사용 횟수 종료 
	*/
	private String iotUseCntEnd;
	
	/**
	* 체험추천 횟수 시작 
	*/
	private String exprnRcmdCntSta;
	
	/**
	* 체험추천 횟수 종료 
	*/
	private String exprnRcmdCntEnd;
	
	/**
	* 구매추천 횟수 시작 
	*/
	private String buyRcmdCntSta;
	
	/**
	* 구매추천 횟수 종료 
	*/
	private String buyRcmdCntEnd;
	
	/**
	* 가입추천 횟수 시작 
	*/
	private String sbscRcmdCntSta;
	
	/**
	* 가입추천 횟수 종료 
	*/
	private String sbscRcmdCntEnd;
	
	/**
	* 최종활동일 시작 
	*/
	private String rcntlyAtvyDaySta;
	
	/**
	* 최종활동일 종료 
	*/
	private String rcntlyAtvyDayEnd;
	
	/**
	* 매장체험 횟수 시작 
	*/
	private String storExprnCntSta;
	
	/**
	* 매장체험 횟수 종료 
	*/
	private String storExprnCntEnd;
	
	/**
	* 매장체험 기간 시작 
	*/
	private String storExprnPerdSta;
	
	/**
	* 매장체험 기간 종료 
	*/
	private String storExprnPerdEnd;
	
	/**
	* 매장체험 제품번호 
	*/
	private String storExprnGodsNo;
	
	/**
	* 매장체험 제품명
	*/
	private String storExprnGodsNm;
	
	/**
	* 홈체험 여부
	*/
	private String homeExprnExcldYn;
	
	/**
	* 홈체험 기간 시작 
	*/
	private String homeExprnPerdSta;
	
	/**
	* 홈체험 기간 종료 
	*/
	private String homeExprnPerdEnd;
	
	/**
	* 홈체험 제품번호 
	*/
	private String homeExprnGodsNo;
	
	/**
	* 홈체험 제품명 
	*/
	private String homeExprnGodsNm;
	
	
	public String getCnslgTypeCd() {
		return Utilities.convArryToStrs(this.cnslgTypeCd, ",");
	}
	
	public List<String> getCnslgTypeCds() {
		return Utilities.convStrsToArry(this.cnslgTypeCd, ",");
	}
	
	/**
	 * VO객체의 모든 속성값이 NULL인지를 체크한다.
	 * @return
	 * @throws Exception
	 */
	public boolean getIsAllDataNull() throws Exception{
		boolean rtnVal = false;
		int rtnIdx = 0;
		for (Field field : this.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			//아래 속성은 체크를 하지 않는다.
			if(field.getName().equals("serialVersionUID") || field.getName().equals("custGrpNo")) continue;
			String sVal = Utilities.nullCheck(field.get(this));
			
			if(!sVal.equals("")) {
				rtnIdx += 1;
			}
//System.out.println("%%%%%%%%%%%%%% field : "+field.getName()+" | value : " + sVal);
		}
		if(rtnIdx < 1) rtnVal = true;
//System.out.println("%%%%%%%getIsAllDataNull%%%%%%% 결과 : "+ rtnVal);
		return rtnVal;
	}
	
	//세라체크 모든조건 null여부 
	public boolean getIsCeraChkDataNull() throws Exception{
		boolean rtnVal = true;
		if(
			!Utilities.nullCheck(this.mesrCntSta).equals("") ||
			!Utilities.nullCheck(this.mesrCntEnd).equals("") ||
			!Utilities.nullCheck(this.mesrDaySta).equals("") ||
			!Utilities.nullCheck(this.mesrDayEnd).equals("")) {
			rtnVal = false;
		}
		return rtnVal;
	}
	
	//상담이력 모든조건 null여부 
	public boolean getIsCnslDataNull() throws Exception{
		boolean rtnVal = true;
		if(this.cnslgTypeCd != null || 
			!Utilities.nullCheck(this.cnslgDaySta).equals("") ||
			!Utilities.nullCheck(this.cnslgDayEnd).equals("") ||
			!Utilities.nullCheck(this.cnslgCntSta).equals("") ||
			!Utilities.nullCheck(this.cnslgCntEnd).equals("")) {
			rtnVal = false;
		}
		return rtnVal;
	}

	//세라체크DNA 모든조건 null여부 
	public boolean getIsCeraChkDnaDataNull() throws Exception{
		boolean rtnVal = true;
		if(
			!Utilities.nullCheck(this.dnaChkYn).equals("") ||
			!Utilities.nullCheck(this.dnaChkDaySta).equals("") ||
			!Utilities.nullCheck(this.dnaChkDayEnd).equals("")) {
			rtnVal = false;
		}
		return rtnVal;
	}
	
	//AS이력 모든조건 null여부 
	public boolean getIsAsDataNull() throws Exception{
		boolean rtnVal = true;
		if(!Utilities.nullCheck(this.grntExpDaySta).equals("") ||
			!Utilities.nullCheck(this.grntExpDayEnd).equals("") ||
			!Utilities.nullCheck(this.asDaySta).equals("") ||
			!Utilities.nullCheck(this.asDayEnd).equals("")) {
			rtnVal = false;
		}
		return rtnVal;
	}
	
	//IOT사용이력 모든조건 null여부 
	public boolean getIsIotDataNull() throws Exception{
		boolean rtnVal = true;
		if(!Utilities.nullCheck(this.iotUseExcldYn).equals("") ||
			!Utilities.nullCheck(this.iotUseDaySta).equals("") ||
			!Utilities.nullCheck(this.iotUseDayEnd).equals("") ||
			!Utilities.nullCheck(this.iotUseCntSta).equals("") ||
			!Utilities.nullCheck(this.iotUseCntEnd).equals("")) {
			rtnVal = false;
		}
		return rtnVal;
	}
	
	//추천이력 모든조건 null여부 
	public boolean getIsRcmdDataNull() throws Exception{
		boolean rtnVal = true;
		if(!Utilities.nullCheck(this.exprnRcmdCntSta).equals("") ||
			!Utilities.nullCheck(this.exprnRcmdCntEnd).equals("") ||
			!Utilities.nullCheck(this.buyRcmdCntSta).equals("") ||
			!Utilities.nullCheck(this.buyRcmdCntEnd).equals("") ||
			!Utilities.nullCheck(this.sbscRcmdCntSta).equals("") ||
			!Utilities.nullCheck(this.sbscRcmdCntEnd).equals("")) {
			rtnVal = false;
		}
		return rtnVal;
	}
	
	//매장체험이력 모든조건 null여부 
	public boolean getIsStorExprnDataNull() throws Exception{
		boolean rtnVal = true;
		if(!Utilities.nullCheck(this.storExprnCntSta).equals("") ||
			!Utilities.nullCheck(this.storExprnCntEnd).equals("") ||
			!Utilities.nullCheck(this.storExprnPerdSta).equals("") ||
			!Utilities.nullCheck(this.storExprnPerdEnd).equals("") ||
			!Utilities.nullCheck(this.storExprnGodsNo).equals("")) {
			rtnVal = false;
		}
		return rtnVal;
	}
	
	//홈체험이력 모든조건 null여부 
	public boolean getIsHomeExprnDataNull() throws Exception{
		boolean rtnVal = true;
		if(!Utilities.nullCheck(this.homeExprnExcldYn).equals("") ||
			!Utilities.nullCheck(this.homeExprnPerdSta).equals("") ||
			!Utilities.nullCheck(this.homeExprnPerdEnd).equals("") ||
			!Utilities.nullCheck(this.homeExprnGodsNo).equals("")) {
			rtnVal = false;
		}
		return rtnVal;
	}
	
	//최근활동이력 모든조건 null여부 
	public boolean getIsAtvtDataNull() throws Exception{
		boolean rtnVal = true;
		if(!Utilities.nullCheck(this.rcntlyAtvyDaySta).equals("") ||
			!Utilities.nullCheck(this.rcntlyAtvyDayEnd).equals("")) {
			rtnVal = false;
		}
		return rtnVal;
	}
	
}
