package com.ceragem.crm.mem.dao;

import com.ceragem.crm.sys.mapper.CrmMapper;
import com.ceragem.crm.mem.model.PointIssueVo;
import com.ceragem.crm.sys.dao.ICrmDao;

@CrmMapper
public interface PointIssueDao extends ICrmDao {
	
	int updatePointScore(Object param);
	
	PointIssueVo selectUserInfo(Object param) throws Exception;
	
	PointIssueVo getUsePointForBos(Object param) throws Exception;
	PointIssueVo getOccurPointForBos(Object param) throws Exception;
}