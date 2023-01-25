package com.ceragem.crm.memship.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.main.service.CrmCustBasService;
import com.ceragem.crm.mem.service.PartnerHomeService;
import com.ceragem.crm.memship.model.CrmCardPblsHstVo;
import com.ceragem.crm.memship.model.CrmMshipCardBasVo;
import com.ceragem.crm.memship.service.CrmCardPblsHstService;
import com.ceragem.crm.memship.service.CrmGodsBasService;
import com.ceragem.crm.memship.service.CrmMshipApplyChlRelService;
import com.ceragem.crm.memship.service.CrmMshipApplyGodsRelService;
import com.ceragem.crm.memship.service.CrmMshipApplyStorRelService;
import com.ceragem.crm.memship.service.CrmMshipCardBasService;
import com.ceragem.crm.memship.service.CrmStorBasService;
import com.ceragem.crm.sys.service.CrmComnCdService;


/**
 * 
 * @ClassName    CrmMshipCardBasController
 * @author    user
 * @date    2022. 4. 28.
 * @Version    1.0
 * @description    CRM멤버십카드기본 Controller
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
//@Slf4j
@Controller
@RequestMapping(value = { "crmMshipCardHst", "{menuCd}/crmMshipCardHst" })
public class CrmMshipCardHstController{
	
	

	@Autowired
	CrmMshipCardBasService service;


	@Autowired
	CrmComnCdService codeService;
	

	@Autowired
	CrmGodsBasService serviceGodsBase;

	@Autowired
	CrmMshipApplyStorRelService serviceStoreRel;


	@Autowired
	CrmMshipApplyGodsRelService serviceGodsRel;


	@Autowired
	CrmMshipApplyChlRelService serviceChlRel;


	@Autowired
	CrmStorBasService serviceStroeBase;
	
	
	@Autowired
	CrmCardPblsHstService serviceCardHst;
	
	@Autowired
	CrmCustBasService serviceCustBase;
	
	@Autowired
	PartnerHomeService servicePartner;


	/**
	 * 
	 * @author user
	 * @date 2022. 4. 28. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM멤버십카드기본 목록페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		
		return Utilities.getProperty("tiles.crm") + "memship/crmMshipCardHstList";
	}
	
	

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 28. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM멤버십카드기본 목록검색
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmMshipCardBasVo> list = service.getList(param);
		page.setTotalRecordCount(service.getListCount(param));


		return Utilities.getGridData(list,page);
	}
	
	

	/**
	 * 
	 * @author user
	 * @date 2022. 5. 4. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM카드발행이력 목록검색
	 *
	 */
	@PostMapping(value = { "getCardHstList" })
	public @ResponseBody Object getCardHstList(@RequestBody EzMap param) throws Exception {
	    EzPaginationInfo page = param.getPaginationInfo();
	    List<CrmCardPblsHstVo> list = serviceCardHst.getList(param);
	    page.setTotalRecordCount(serviceCardHst.getListCount(param));
	    return Utilities.getGridData(list,page);
	}
	
		
	

}
