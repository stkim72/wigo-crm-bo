package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.cst.dao.CrmCustBasCompanyListDao;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    CrmCustBasCompanyListService
 * @author    user
 * @date    2022. 4. 19.
 * @Version    1.0
 * @description    CRM고객기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustBasCompanyListService extends AbstractCrmService {
   @Autowired
   CrmCustBasCompanyListDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   } 
}
