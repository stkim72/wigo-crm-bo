package com.ceragem.crm.main.dao;

import java.util.List;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.main.model.CrmCustBasVo;
import com.ceragem.crm.memship.model.AdvnCmtVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmCustBasDao extends ICrmDao {

	List<EzMap> selectMemberShipScoreList(Object param) throws Exception;
	
	int saveRepCntplcToN(Object param);
	int saveRepCntplcToY(Object param);
	
	//대상 고객발송 관련
    int insertTargetBySms(Object param);
    int insertTargetByMail(Object param);
    <T> List<T> selectTargetCustSendList(Object param);
    int selectTargetCustSendListCount(Object param);
	int updateAdvn(CrmCustBasVo crmCustBasVo);

	void pubAdvnPoint(AdvnCmtVo advnCmtVo);

	CrmCustBasVo selectAdvn(CrmCustBasVo crmCustBasVo);
}
