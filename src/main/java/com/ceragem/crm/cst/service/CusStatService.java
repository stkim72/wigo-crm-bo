package com.ceragem.crm.cst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.CusStatDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CusStatService
 * @author    user
 * @date    2022. 7. 18.
 * @Version    1.0
 * @description    CRM고객기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CusStatService extends AbstractCrmService {
   @Autowired
   CusStatDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
   
   public <T> List<T> getMemberStat1List(Object param) throws Exception {
       return dao.getMemberStat1List(param);
   }
   
   public <T> List<T> getMemberStat2List(Object param) throws Exception {
       return dao.getMemberStat2List(param);
   }
   
   public <T> List<T> getMemberStat3List(Object param) throws Exception {
       return dao.getMemberStat3List(param);
   }
   
   public <T> List<T> getActiveStat1List(Object param) throws Exception {
       return dao.getActiveStat1List(param);
   }
   public <T> List<T> getActiveStat2List(Object param) throws Exception {
       return dao.getActiveStat2List(param);
   }
   public <T> List<T> getActiveStat3List(Object param) throws Exception {
       return dao.getActiveStat3List(param);
   }
   
   public <T> List<T> getCeraCkStat1List(Object param) throws Exception {
       return dao.getCeraCkStat1List(param);
   }
   public <T> List<T> getCeraCkStat2List(Object param) throws Exception {
       return dao.getCeraCkStat2List(param);
   }
   public <T> List<T> getCeraCkStat3List(Object param) throws Exception {
       return dao.getCeraCkStat3List(param);
   }
   
   public <T> List<T> getGradeStat1List(Object param) throws Exception {
       return dao.getGradeStat1List(param);
   }
   
   public <T> List<T> getRecommendStat1List(Object param) throws Exception {
       return dao.getRecommendStat1List(param);
   }
   public <T> List<T> getRecommendStat2List(Object param) throws Exception {
       return dao.getRecommendStat2List(param);
   }
   public <T> List<T> getRecommendStat3List(Object param) throws Exception {
       return dao.getRecommendStat3List(param);
   }
   public <T> List<T> getRecommendStat4List(Object param) throws Exception {
       return dao.getRecommendStat4List(param);
   }
   public <T> List<T> getRecommendStat5List(Object param) throws Exception {
       return dao.getRecommendStat5List(param);
   }
   public <T> List<T> getRecommendStat6List(Object param) throws Exception {
       return dao.getRecommendStat6List(param);
   }
   
   public <T> List<T> getIotUseAgeStats(Object param) throws Exception {
       return dao.selectIotUseAgeStats(param);
   }
   
   public <T> List<T> getIotUseAgeModeStats(Object param) throws Exception {
       return dao.selectIotUseAgeModeStats(param);
   }
   
   public <T> List<T> getIotUseGndrStats(Object param) throws Exception {
       return dao.selectIotUseGndrStats(param);
   }
   
   public <T> List<T> getIotUseGndrModeStats(Object param) throws Exception {
       return dao.selectIotUseGndrModeStats(param);
   }
   
   public <T> List<T> getIotUseGradeStats(Object param) throws Exception {
       return dao.selectIotUseGradeStats(param);
   }
   
   public <T> List<T> getExperienceStatList(Object param) throws Exception {
       return dao.getExperienceStatList(param);
   }
   
   public int getExperienceStatListCount(Object param)throws Exception {
       return dao.getExperienceStatListCount(param);
   } 
}
