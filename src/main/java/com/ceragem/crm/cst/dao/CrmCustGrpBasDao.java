package com.ceragem.crm.cst.dao;

import java.util.List;

import com.ceragem.crm.cst.model.CrmCustGrpBasVo;
import com.ceragem.crm.cst.model.CrmCustGrpCnttHstCondVo;
import com.ceragem.crm.cst.model.CrmCustGrpDealHstCondVo;
import com.ceragem.crm.cst.model.CrmCustGrpMstrCondVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmCustGrpBasDao extends ICrmDao {
	//고객그룹 기본정보 관련
	<T> List<T> selectGroupBasList(Object param);
	int selectGroupBasListCount(Object param);
	CrmCustGrpBasVo selectGroupBasInfo(Object param) throws Exception;
	int insertGroupBasInfo(Object param);
	int updateGroupBasInfo(Object param);
	int deleteGroupBasInfo(Object param);
	//고객그룹 기본정보 관련
	
	//고객마스터 조건정보 관련
	CrmCustGrpMstrCondVo selectMstrCondInfo(Object param) throws Exception;
	int insertMstrCondInfo(Object param);
	int updateMstrCondInfo(Object param);
	int deleteMstrCondInfo(Object param);
	//고객마스터 조건정보 관련
	
	//접촉이력 조건정보 관련
	CrmCustGrpCnttHstCondVo selectCnttHstCondInfo(Object param) throws Exception;
	int insertCnttHstCondInfo(Object param);
	int updateCnttHstCondInfo(Object param);
	int deleteCnttHstCondInfo(Object param);
	int selectExprnGodsSearchListCount(Object param);
	<T> List<T> selectExprnGodsSearchList(Object param);
	//접촉이력 조건정보 관련
	
	//거래이력 조건정보 관련
	CrmCustGrpDealHstCondVo selectDealHstCondInfo(Object param) throws Exception;
	int insertDealHstCondInfo(Object param);
	int updateDealHstCondInfo(Object param);
	int deleteDealHstCondInfo(Object param);
	int deleteDealGodsCondInfo(Object param);
	int selectDealGodsSearchListCount(Object param);
	<T> List<T> selectDealGodsSearchList(Object param);
	<T> List<T> selectDealGodsCondList(Object param);
	int insertDealGodsCondList(Object param);
	int deleteDealGodsCondList(Object param);
	//거래이력 조건정보 관련
	
	//대상 고객추출 관련
	<T> List<T> selectTargetSearchList(Object param);
	int selectTargetSearchPagingListCount(Object param);
	<T> List<T> selectTargetSearchPagingList(Object param);
	int selectTargetWithQueryCount(Object param);
	<T> List<T> selectTargetWithQuery(Object param);
	int saveTargetQuery(Object param);
	//대상 고객추출 관련
	
	//대상 고객선정 관련
	<T> List<T> selectTargetRelList(Object param);
	int selectTargetRelListCount(Object param);
	<T> List<T> selectTargetCustNoEmptyList(Object param);
	int updateTargetCustNoEmpty(Object param);
	int deleteTargetRelAll(Object param);
	int deleteTargetRelList(Object param);
	int updateTargetRelList(Object param);
	int insertTargetRelExcelInfo(Object param);
	int insertTargetRelInfo(Object param);
	int insertTargetRelList(Object param);
	int insertTargetRelInpQuery(Object param);
	//대상 고객선정 관련
	
	//대상 고객검색 관련
	<T> List<T> selectTargetCustGradeList(Object param);
	<T> List<T> selectTargetCustList(Object param);
	int selectTargetCustListCount(Object param);
	//대상 고객검색 관련
	
	//대상 고객발송 관련
	int deleteTargetSendGroup(Object param);
	int insertTargetSendGroup(Object param);
	int insertTotalTargetSendGroup(Object param);
	int insertTargetBySms(Object param);
	int insertTotalTargetBySms(Object param);
	int insertTargetByMail(Object param);
	int insertTotalTargetByMail(Object param);
	<T> List<T> selectTargetCustSendList(Object param);
	int selectTargetCustSendListCount(Object param);
	//대상 고객발송 관련
}
