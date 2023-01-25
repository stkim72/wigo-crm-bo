package com.ceragem.crm.memship.dao;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmCoupnPblsHstDao extends ICrmDao {

	int updateCancel(String[] arrHisSeq);

	int updatePblsHist(EzMap result);

	int deleteCoupon(String[] arrHisSeq);

}
