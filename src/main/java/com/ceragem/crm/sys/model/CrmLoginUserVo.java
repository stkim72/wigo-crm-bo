package com.ceragem.crm.sys.model;

import java.util.List;

import com.ceragem.crm.common.util.Utilities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmLoginUserVo extends CrmJadeHrVo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CrmGrpBaseVo> groupList;
	/*
	 * <p>사용자 그룹 콤마로 구분</p>
	 */
	private String grpCds;
	/*
	 * <p>저장된 아이디</p>
	 */
	private String saveId;

	/**
	 * <p>
	 * 로그인ID
	 * </p>
	 */
	private String loginId;
	/**
	 * <p>
	 * 로그인비밀번호
	 * </p>
	 */
	private String loginPwd;
	/**
	 * <p>
	 * 사용자성별코드
	 * </p>
	 * <p>
	 * 공통코드 : S040
	 * </p>
	 */
	private String userGndrCd;
	/**
	 * <p>
	 * 비밀번호수정일시
	 * </p>
	 */
	private String pwdAmdDt;
	/**
	 * <p>
	 * 최종로그인일시
	 * </p>
	 */
	private String lastLoginDt;
	/**
	 * <p>
	 * 비밀번호만료일시
	 * </p>
	 */
	private String pwdExpDt;
	/**
	 * <p>
	 * 로그인실패수
	 * </p>
	 */
	private Integer loginFailCnt;
	/**
	 * <p>
	 * 삭제여부
	 * </p>
	 * <p>
	 * 공통코드 : S030
	 * </p>
	 */
	private String delYn;

	/**
	 * <p>
	 * 사용자코드
	 * </p>
	 */
	public String getUserCd() {
		return getEmpId();
	}

	public void setUserCd(String userCd) {
		setEmpId(userCd);
	}

//	public String getLoginId() {
//		return getEmpId();
//	}
//
//	public void setLoginId(String loginId) {
//		setEmpId(loginId);
//	}

	/**
	 * <p>
	 * 사용자명
	 * </p>
	 */
	public String getUserNm() {
		return getEmpNm();
	}

	public void setUserNm(String userNm) {
		setEmpNm(userNm);
	}

	public String getUserBirthday() {
		return getBirthday();
	}

	public void setUserBirthday(String userBirthday) {
		setBirthday(userBirthday);
	}

	public boolean hasGroup(String groupCd) {
		if (Utilities.isEmpty(groupCd))
			return false;
		for (int i = 0; groupList != null && i < groupList.size(); i++) {
			if (groupCd.equals(groupList.get(i).getGrpCd()))
				return true;
		}
		return false;
	}
}
