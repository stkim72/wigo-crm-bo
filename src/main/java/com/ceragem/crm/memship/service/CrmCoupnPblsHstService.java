package com.ceragem.crm.memship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.memship.dao.CrmCoupnPblsHstDao;
import com.ceragem.crm.memship.model.CrmCoupnPblsHstVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName CrmCoupnPblsHstService
 * @author user
 * @date 2022. 5. 3.
 * @Version 1.0
 * @description CRM쿠폰발행이력 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCoupnPblsHstService extends AbstractCrmService {
	@Autowired
	CrmCoupnPblsHstDao dao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public Object updateCancel(List<CrmCoupnPblsHstVo> list) {
		StringBuffer bf = new StringBuffer();
		String hisSeq = "";
		int ret = 0;
		for (CrmCoupnPblsHstVo vo : list) {
			bf.append(vo.getCoupnPblsHstSeq());
			bf.append(",");
		}
		hisSeq = bf.toString();
		String[] arrHisSeq = hisSeq.substring(0, hisSeq.length() - 1).toString().split(",");
		if (arrHisSeq.length > 0) {
			ret = dao.updateCancel(arrHisSeq);
		}

		return ret;
	}

	public int updatePblsHist(EzMap result) {
		return dao.updatePblsHist(result);
	}

	public int deleteCoupon(List<CrmCoupnPblsHstVo> list) {
		
		StringBuffer bf = new StringBuffer();
		String hisSeq = "";
		int ret = 0;
		for (CrmCoupnPblsHstVo vo : list) {
			bf.append(vo.getCoupnPblsHstSeq());
			bf.append(",");
		}
		hisSeq = bf.toString();
		String[] arrHisSeq = hisSeq.substring(0, hisSeq.length() - 1).toString().split(",");
		if (arrHisSeq.length > 0) {
			ret = dao.deleteCoupon(arrHisSeq);
		}

		return ret;
	}
}
