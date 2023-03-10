package com.ceragem.crm.sys.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmXlsDnldHstVo extends CrmSnstvInfoInqryHstVo {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	/**
	 * <p>
	 * 다운로드이력코드
	 * </p>
	 */
	private String dnldHstCd;
	/**
	 * <p>
	 * 메뉴코드
	 * </p>
	 */
	private String menuCd;
	/**
	 * <p>
	 * 다운로드명
	 * </p>
	 */
	private String dnldNm;

	private String menuNm;
	private String menuPath;
}
