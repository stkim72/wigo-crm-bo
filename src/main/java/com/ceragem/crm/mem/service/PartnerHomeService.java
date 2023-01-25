package com.ceragem.crm.mem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceragem.crm.api.service.CrmApiService;
import com.ceragem.crm.common.model.BaseVo;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.mem.dao.PartnerHomeDao;
import com.ceragem.crm.mem.model.PartnerHomeVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName PartnerHomeService
 * @author 황재희
 * @date 2022. 4. 22.
 * @Version 1.0
 * @description 제휴사 목록 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class PartnerHomeService extends AbstractCrmService {
	@Autowired
	PartnerHomeDao dao;
	
	@Autowired
	CrmApiService apiService;
	@Value("${spring.api.url.customer-memship}")
	String apiUrlMemship;	
	
	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public <T> List<T> getExecvdempList(Object param) throws Exception {
		return dao.getExecvdempList(param);
	}

	public int getExecvdempListCount(Object param) throws Exception {
		return dao.getExecvdempListCount(param);
	}

	public EzMap saveExecvdempList(List<? extends BaseVo> list) throws Exception {
		List<EzMap> result = new ArrayList<EzMap>();
		for (int i = 0; i < list.size(); i++) {
			result.add(uploadExecvdemp(list.get(i)));
		}
		return Utilities.getSaveResult(result);
	}

	public EzMap uploadExecvdemp(BaseVo vo) throws Exception {
		return Utilities.getInsertResult(insertExecvdemp(vo), vo);
	}

	public int insertExecvdemp(Object param) throws Exception {
		PartnerHomeVo mphonNoVo = (PartnerHomeVo) param;
		
		if (Utilities.isNotEmpty(mphonNoVo.getMphonNo())) {
			String strMphoneNo = mphonNoVo.getMphonNo().replace("-", "");
			
			if(strMphoneNo.length() == 10 && strMphoneNo.substring(0,2).equals("10")){
				strMphoneNo = "0" + strMphoneNo;
			}
			
			//String strFrontNo = strMphoneNo.substring(0, 3);
			String strBackNo = strMphoneNo.substring(strMphoneNo.length() - 4, strMphoneNo.length());
			// MPHON_NO_ENC_VAL에 휴대폰 번호 암호화 값 세팅
			mphonNoVo.setMphonNoEncVal(Utilities.encrypt(strMphoneNo));
			// MPHON_BK_DGT_NO에 휴대폰 뒤 4자리 번호 세팅
			mphonNoVo.setMphonBkDgtNo(strBackNo);
			// MPHON_NO에 휴대폰 패턴 번호 세팅(010-****-1234)
			mphonNoVo.setMphonNo(strMphoneNo);
		}

		return dao.insertExecvdemp(mphonNoVo);
	}

	public EzMap deleteExecvdempList(List<? extends BaseVo> list) throws Exception {
		List<EzMap> result = new ArrayList<EzMap>();
		for (int i = 0; i < list.size(); i++) {
			result.add(saveExecvdemp(list.get(i)));
		}
		return Utilities.getSaveResult(result);
	}
	
	public EzMap deleteAllExecvdempList(Object param) throws Exception {
		List<PartnerHomeVo> list = dao.getAllExecvdempList(param);
		List<EzMap> result = new ArrayList<EzMap>();
		if(list != null) {
			for (int i = 0; i < list.size(); i++) {
				result.add(saveExecvdemp(list.get(i)));
			}
		}
		return Utilities.getSaveResult(result);
	}

	public EzMap saveExecvdemp(BaseVo vo) throws Exception {
		return Utilities.getDeleteResult(deleteExecvdemp(vo));
	}

	public int deleteExecvdemp(Object param) throws Exception {
		return dao.deleteExecvdemp(param);
	}
	
	public int saveGrade(List<PartnerHomeVo> list) throws Exception {
	
		  String url = apiUrlMemship + "/register-alliance"; 
		  
		  for (int i = 0; i < list.size(); i++) {
			  apiService.getApiResultVo(url, list.get(i), "POST", true, PartnerHomeVo.class); 
		  }
		  return 1;
	}
	
	public int saveAllGrade(Object param) throws Exception {
		List<PartnerHomeVo> list = dao.getAllExecvdempList(param);
		if(list != null) {
			String url = apiUrlMemship + "/register-alliance"; 
			for (int i = 0; i < list.size(); i++) {
				apiService.getApiResultVo(url, list.get(i), "POST", true, PartnerHomeVo.class); 
			}
		}
		return 1;
	}
}
