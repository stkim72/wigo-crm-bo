package com.ceragem.crm.sys.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrmFileBaseVo extends BaseVo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * <p>
	 * 파일코드
	 * </p>
	 */
	private String fileCd;
	/**
	 * <p>
	 * 파일순번
	 * </p>
	 */
	private Integer fileOdrg;
	/**
	 * <p>
	 * 파일명
	 * </p>
	 */
	private String fileNm;
	/**
	 * <p>
	 * 파일크기
	 * </p>
	 */
	private Long fileSize;
	/**
	 * <p>
	 * 파일저장명
	 * </p>
	 */
	private String fileSaveNm;
	/**
	 * <p>
	 * 파일URL
	 * </p>
	 */
	private String fileUrl;
	/**
	 * <p>
	 * 파일확장자명
	 * </p>
	 */
	private String fileExtNm;
	/**
	 * <p>
	 * MIME유형명
	 * </p>
	 */
	private String mimeTypeNm;
}
