package com.ceragem.crm.cusstatus.dao;

import java.util.List;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmCusStatusDao extends ICrmDao {
	List<Integer> getGradePie();

	List<Integer> getGradePie(String strtDt, String endDt);

	List<Integer> getGradeBar();

	List<Integer> getGradeBar(String strtDt, String endDt);

	String[] monthRegCntM(EzMap param);

	int[] monthRegCnt(EzMap param);

	List<EzMap> selectGndrInfo(Object param);

	List<EzMap> selectAgeInfo(Object param);

	List<String> gradeLevel();

}
