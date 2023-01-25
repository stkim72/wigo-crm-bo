package com.ceragem.crm.cusstatus.dao;

import java.util.List;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmCusStatusExpDao extends ICrmDao {

	List<EzMap> selectMemberTypeList(Object param);

	List<EzMap> selectGenderList(Object param);

	List<EzMap> selectMemberGradeList(Object param);
	
	List<EzMap> selectNumberList(Object param);
	
	List<EzMap> selectAgeList(Object param);
	
	List<EzMap> selectWeekList(Object param);

	// 전체인원 경험여부
	int[] getExpPie();

	int[] getExpPie(String strtDt, String endDt);

	// 성별 경험여부
	int[] getExpGenPie();

	int[] getExpGenPie(String strtDt, String endDt);

	// 등급별 경험여부
	int[] getExpGra();

	int[] getExpGra(String strtDt, String endDt);

	// 연령대 경험여부
	int[] getExpAgeBar();

	int[] getExpAgeBar(String strtDt, String endDt);

	// 요일별 경험여부
	int[] getExpDayBar();

	int[] getExpDayBar(String strtDt, String endDt);

}
