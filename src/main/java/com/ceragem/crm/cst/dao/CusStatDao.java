package com.ceragem.crm.cst.dao;

import com.ceragem.crm.sys.mapper.CrmMapper;

import java.util.List;

import com.ceragem.crm.sys.dao.ICrmDao;

@CrmMapper
public interface CusStatDao extends ICrmDao {
	<T> List<T> getMemberStat1List(Object param);

	<T> List<T> getMemberStat2List(Object param);

	<T> List<T> getMemberStat3List(Object param);

	<T> List<T> getActiveStat1List(Object param);

	<T> List<T> getActiveStat2List(Object param);

	<T> List<T> getActiveStat3List(Object param);

	<T> List<T> getCeraCkStat1List(Object param);

	<T> List<T> getCeraCkStat2List(Object param);

	<T> List<T> getCeraCkStat3List(Object param);

	<T> List<T> getGradeStat1List(Object param);

	<T> List<T> getRecommendStat1List(Object param);

	<T> List<T> getRecommendStat2List(Object param);

	<T> List<T> getRecommendStat3List(Object param);

	<T> List<T> getRecommendStat4List(Object param);

	<T> List<T> getRecommendStat5List(Object param);

	<T> List<T> getRecommendStat6List(Object param);

	<T> List<T> selectIotUseAgeStats(Object param);

	<T> List<T> selectIotUseAgeModeStats(Object param);

	<T> List<T> selectIotUseGndrStats(Object param);

	<T> List<T> selectIotUseGndrModeStats(Object param);

	<T> List<T> selectIotUseGradeStats(Object param);

	<T> List<T> getExperienceStatList(Object param);

	int getExperienceStatListCount(Object param);
}
