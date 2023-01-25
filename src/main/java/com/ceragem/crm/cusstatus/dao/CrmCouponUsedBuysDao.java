package com.ceragem.crm.cusstatus.dao;

import java.util.List;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmCouponUsedBuysDao extends ICrmDao{

	List<EzMap> getCoupnMasterForSelect(EzMap param);

	int getCoupnMasterForSelectCount(EzMap param);

	List<EzMap> getCoupnUseBuysList(EzMap param);

	int getCoupnUseBuysCount(EzMap param);

	List<EzMap> getCoupnUseBuyDetailList(EzMap param);

	int getCoupnUseBuyDetailCount(EzMap param);

}
