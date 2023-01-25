package com.ceragem.crm.mem.dao;

import com.ceragem.crm.sys.mapper.CrmMapper;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.mem.model.PromotionListVo;
import com.ceragem.crm.sys.dao.ICrmDao;

import java.util.List;

@CrmMapper
public interface PromotionListDao extends ICrmDao {
	int copyPromotion(PromotionListVo vo);
	
	<T> List<T> getBosOrderList(Object param);
	
	int getBosOrderListCount(Object param);
	
	<T> List<T> getPointList(Object param);
	
	int getPointListCount(Object param);
	
	<T> List<T> getCoupnList(Object param);
	
	int getCoupnListCount(Object param);
	
	String getMaxPromNo();
	
	int copyPromStore(EzMap parm);

	int copyPromGods(EzMap parm);

	EzMap getPromInfo(EzMap param);

	List<String> getPromStorList(EzMap param);

	List<String> getPromGodsList(EzMap param);

	<T> List<T> getPosOrderList(EzMap param);

	int getPosOrderListCount(EzMap param);

	List<EzMap> getOrderList(EzMap param);

}
