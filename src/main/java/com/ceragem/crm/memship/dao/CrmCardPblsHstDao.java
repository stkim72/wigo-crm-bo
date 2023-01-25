package com.ceragem.crm.memship.dao;

import java.util.List;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.main.model.CrmCustBasVo;
import com.ceragem.crm.memship.model.CrmCardCustBasVo;
import com.ceragem.crm.memship.model.CrmCardPblsHstVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmCardPblsHstDao extends ICrmDao {

	CrmCustBasVo getCustInfo(CrmCardPblsHstVo vo);

	List<CrmCardCustBasVo> getCustInfo(EzMap param);

	int getCustListCount(EzMap param);

}
