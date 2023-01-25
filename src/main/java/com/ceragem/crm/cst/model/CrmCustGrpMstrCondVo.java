package com.ceragem.crm.cst.model;

import java.lang.reflect.Field;
import java.util.List;

import com.ceragem.crm.common.model.BaseVo;
import com.ceragem.crm.common.util.Utilities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmCustGrpMstrCondVo extends BaseVo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 고객그룹번호
	 */
	private String custGrpNo;

	/**
	 * 생년월일 시작
	 */
	private String birthdaySta;

	/**
	 * 생년월일 종료
	 */
	private String birthdayEnd;

	/**
	 * 연령대 시작
	 */
	private String ageStt;

	/**
	 * 연령대 종료
	 */
	private String ageEnd;

	/**
	 * 성별코드
	 */
	private String gndrCd;

	/**
	 * 고객상태코드
	 */
	private Object custStatusCd;

	/**
	 * 고객유형코드
	 */
	private Object custTypeCd;

	/**
	 * 고객구분코드
	 */
	private Object custDivCd;

	/**
	 * 지역구분코드
	 */
	private Object distrctDivCd;

	/**
	 * 결혼여부
	 */
	private String marryYn;

	/**
	 * 가족관계코드
	 */
	private Object famlyRelCd;

	/**
	 * 관심분야코드
	 */
	private Object intrstFildCd;

	/**
	 * 주거평수코드
	 */
	private Object dwelNfpyCd;

	/**
	 * 매장번호
	 */
	private Object storNo;

	/**
	 * 가입일 시작
	 */
	private String sbscDaySta;

	/**
	 * 가입일 종료
	 */
	private String sbscDayEnd;

	/**
	 * SMS수신동의여부
	 */
	private String smsRcvAgreeYn;

	/**
	 * 이메일수신동의여부
	 */
	private String emailRcvAgreeYn;

	/**
	 * PUSH수신동의여부
	 */
	private String pushRcvAgreeYn;

	/**
	 * 수신거부여부
	 */
	private String rcvRfslYn;

	/**
	 * 멤버십등급코드
	 */
	private Object mshipGradeCd;

	/**
	 * 멤버십유형코드
	 */
	private Object mshipTypeCd;

	/**
	 * 멤버십가입일 시작
	 */
	private String mshipSbscDaySta;

	/**
	 * 멤버십가입일 종료
	 */
	private String mshipSbscDayEnd;

	/**
	 * 멤버십등급점수 시작
	 */
	private String mshipAdvncmtScoreSta;

	/**
	 * 멤버십등급점수 종료
	 */
	private String mshipAdvncmtScoreEnd;
	

	public String getCustStatusCd() {
		return Utilities.convArryToStrs(this.custStatusCd, ",");
	}

	public List<String> getCustStatusCds() {
		return Utilities.convStrsToArry(this.custStatusCd, ",");
	}

	public String getCustTypeCd() {
		return Utilities.convArryToStrs(this.custTypeCd, ",");
	}

	public List<String> getCustTypeCds() {
		return Utilities.convStrsToArry(this.custTypeCd, ",");
	}

	public String getCustDivCd() {
		return Utilities.convArryToStrs(this.custDivCd, ",");
	}

	public List<String> getCustDivCds() {
		return Utilities.convStrsToArry(this.custDivCd, ",");
	}

	public String getDistrctDivCd() {
		return Utilities.convArryToStrs(this.distrctDivCd, ",");
	}

	public List<String> getDistrctDivCds() {
		return Utilities.convStrsToArry(this.distrctDivCd, ",");
	}

	public String getFamlyRelCd() {
		return Utilities.convArryToStrs(this.famlyRelCd, ",");
	}

	public List<String> getFamlyRelCds() {
		return Utilities.convStrsToArry(this.famlyRelCd, ",");
	}

	public String getIntrstFildCd() {
		return Utilities.convArryToStrs(this.intrstFildCd, ",");
	}

	public List<String> getIntrstFildCds() {
		return Utilities.convStrsToArry(this.intrstFildCd, ",");
	}

	public String getDwelNfpyCd() {
		return Utilities.convArryToStrs(this.dwelNfpyCd, ",");
	}

	public List<String> getDwelNfpyCds() {
		return Utilities.convStrsToArry(this.dwelNfpyCd, ",");
	}

	public String getStorNo() {
		return Utilities.convArryToStrs(this.storNo, ",");
	}

	public List<String> getStorNos() {
		return Utilities.convStrsToArry(this.storNo, ",");
	}

	public String getMshipGradeCd() {
		return Utilities.convArryToStrs(this.mshipGradeCd, ",");
	}

	public List<String> getMshipGradeCds() {
		return Utilities.convStrsToArry(this.mshipGradeCd, ",");
	}

	public String getMshipTypeCd() {
		return Utilities.convArryToStrs(this.mshipTypeCd, ",");
	}

	public List<String> getMshipTypeCds() {
		return Utilities.convStrsToArry(this.mshipTypeCd, ",");
	}

	/**
	 * VO객체의 모든 속성값이 NULL인지를 체크한다.
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean getIsAllDataNull() throws Exception {
		boolean rtnVal = false;
		int rtnIdx = 0;
		for (Field field : this.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			// 아래 속성은 체크를 하지 않는다.
			if (field.getName().equals("serialVersionUID") || field.getName().equals("custGrpNo"))
				continue;
			String sVal = Utilities.nullCheck(field.get(this));

			if (!sVal.equals("")) {
				rtnIdx += 1;
			}
//System.out.println("%%%%%%%%%%%%%% field : "+field.getName()+" | value : " + sVal);
		}
		if (rtnIdx < 1)
			rtnVal = true;
//System.out.println("%%%%%%%getIsAllDataNull%%%%%%% 결과 : "+ rtnVal);
		return rtnVal;
	}
}
