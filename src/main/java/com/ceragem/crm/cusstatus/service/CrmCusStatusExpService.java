package com.ceragem.crm.cusstatus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.cusstatus.dao.CrmCusStatusExpDao;
import com.ceragem.crm.cusstatus.model.CrmResponseVo;
import com.ceragem.crm.sys.service.AbstractCrmService;

import lombok.RequiredArgsConstructor;

/**
 * @author Yongho Kim(yong_ho.kim@kt.com)
 *
 */

@Service
@RequiredArgsConstructor
public class CrmCusStatusExpService extends AbstractCrmService {
	private final CrmCusStatusExpDao dao;

	@Override
	public CrmCusStatusExpDao getDao() {
		return dao;
	}

	// 전체 경험여부
	public int[] getExpPie() {
		return dao.getExpPie();
	}

	public int[] getExpPie(CrmResponseVo param) {
		String strtDt, endDt;
		strtDt = param.getStrtDt();
		endDt = param.getEndDt();

		return dao.getExpPie(strtDt, endDt);
	}

	// 성별 경험여부
	public int[] getExpGenPie() {
		return dao.getExpGenPie();
	}

	public int[] getExpGenPie(CrmResponseVo param) {
		String strtDt, endDt;
		strtDt = param.getStrtDt();
		endDt = param.getEndDt();

		return dao.getExpGenPie(strtDt, endDt);
	}

	// 등급별 경험여부
	public int[] getExpGra() {
		return dao.getExpGra();
	}

	public int[] getExpGra(CrmResponseVo param) {
		String strtDt, endDt;
		strtDt = param.getStrtDt();
		endDt = param.getEndDt();

		return dao.getExpGra(strtDt, endDt);
	}

	// 연령별 경험여부
	public int[] getExpAgeBar() {
		return dao.getExpAgeBar();
	}

	public int[] getExpAgeBar(CrmResponseVo param) {
		String strtDt, endDt;
		strtDt = param.getStrtDt();
		endDt = param.getEndDt();

		return dao.getExpAgeBar(strtDt, endDt);
	}

	// 요일별 경험여부
	public int[] getExpDayBar() {
		return dao.getExpDayBar();
	}

	public int[] getExpDayBar(CrmResponseVo param) {
		String strtDt, endDt;
		strtDt = param.getStrtDt();
		endDt = param.getEndDt();

		return dao.getExpDayBar(strtDt, endDt);
	}

	public List<EzMap> getMemberTypeList(Object param) {
		return dao.selectMemberTypeList(param);

	}

	public List<EzMap> getGenderList(Object param) {
		return dao.selectGenderList(param);
	}
	
	public List<EzMap> getMemberGradeList(Object param) {
		return dao.selectMemberGradeList(param);
	}
	
	public List<EzMap> getNumberList(Object param) {
		return dao.selectNumberList(param);
	}
	
	
	public List<EzMap> getAgeList(Object param) {
		return dao.selectAgeList(param);
	}
	
	public List<EzMap> getWeekList(Object param) {
		return dao.selectWeekList(param);
	}
}
