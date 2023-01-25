package com.ceragem.crm.cst.dao;

import com.ceragem.crm.sys.mapper.CrmMapper;

import java.util.List;

import com.ceragem.crm.sys.dao.ICrmDao;

@CrmMapper
public interface BlackCusDao extends ICrmDao {

	<T> List<T> getBlackHistoryList(Object param);
	int getBlackHistoryCount(Object param);
	int updateBlack(Object param);
	int insertBlackHistory(Object param);
	
	//대상 고객발송 관련
    int insertTargetBySms(Object param);
    int insertTargetByMail(Object param);
    <T> List<T> selectTargetCustSendList(Object param);
    int selectTargetCustSendListCount(Object param);
    //대상 고객발송 관련
}
