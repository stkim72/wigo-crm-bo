package com.ceragem.crm.mem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.mem.dao.PromotionListDao;
import com.ceragem.crm.mem.model.PromotionListVo;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmMshipPromBasService
 * @author    황재희
 * @date    2022. 5. 23.
 * @Version    1.0
 * @description    CRM멤버십프로모션기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class PromotionListService extends AbstractCrmService {
	   @Autowired
	   PromotionListDao dao;
	
	   @Override
	   public ICrmDao getDao() {
	       return dao;
	   }
	   
	   public int copyPromotion(PromotionListVo vo) {
			return dao.copyPromotion(vo);
	   }
	   
	   public <T> List<T> getBosOrderList(Object param) throws Exception {
			return dao.getBosOrderList(param);
	   }
	   
	   public int getBosOrderListCount(Object param) throws Exception {
			return dao.getBosOrderListCount(param);
	   }
	   
	   public <T> List<T> getPointList(Object param) throws Exception {
			return dao.getPointList(param);
	   }
	  
	   public int getPointListCount(Object param) throws Exception {
			return dao.getPointListCount(param);
	   }
	   
	   public <T> List<T> getCoupnList(Object param) throws Exception {
			return dao.getCoupnList(param);
	  }
	 
	  public int getCoupnListCount(Object param) throws Exception {
			return dao.getCoupnListCount(param);
	  }
	  
	  public String getMaxPromNo() {
			return dao.getMaxPromNo();
	  }
	  
	  public int copyPromStore(EzMap parm) {
			return dao.copyPromStore(parm);
	  }
		
	  public int copyPromGods(EzMap parm) {
			return dao.copyPromGods(parm);
	  }

	public EzMap getPromInfo(EzMap param) {
		return dao.getPromInfo(param);
	}
	
	public List<String> getPromStorList(EzMap param) {
		return dao.getPromStorList(param);
	}
	
	public List<String> getPromGodsList(EzMap param) {
		return dao.getPromGodsList(param);
	}

	public <T> List<T> getPosOrderList(EzMap param) {
		return dao.getPosOrderList(param);
	}

	public int getPosOrderListCount(EzMap param) {
		return dao.getPosOrderListCount(param);
	}

	public List<EzMap> getOrderList(EzMap param) {
		return dao.getOrderList(param);
	}
}
