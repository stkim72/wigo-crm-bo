package com.ceragem.crm.mem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.mem.dao.PointUseDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    PointUseService
 * @author    황의겸
 * @date    2022. 6. 9.
 * @Version    1.0
 * @description    포인트사용현황 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class PointUseService extends AbstractCrmService {
   @Autowired
   PointUseDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
   
   public <T> List<T> getMonthPointSumList(Object param) throws Exception {
	   return dao.getMonthPointSumList(param);
   }
   
   public <T> List<T> getMonthPointList(Object param) throws Exception {
       return dao.getMonthPointList(param);
   }
   
   public <T> List<T> getPointExtinctionList(Object param) throws Exception {
       return dao.getPointExtinctionList(param);
   }
   public int getPointExtinctionListCount(Object param)  throws Exception {
       return dao.getPointExtinctionListCount(param);
   }
   
}
