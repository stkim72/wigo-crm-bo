package com.ceragem.crm.mem.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.ceragem.crm.common.util.Utilities;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.mem.model.ProductHomeVo;
import com.ceragem.crm.mem.service.ProductHomeService;
import com.ceragem.crm.sys.model.CrmComnCdBaseVo;
import com.ceragem.crm.sys.service.CrmComnCdService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName ProductHomeController
 * @author 홍의겸
 * @date 2022. 5. 12.
 * @Version 1.0
 * @description 제품정보 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Slf4j
@Controller
@RequestMapping(value = { "productHome", "{menuCd}/productHome" })
public class ProductHomeController {

	@Autowired
	ProductHomeService service;
	@Autowired
	CrmComnCdService crmComnCdService;

	/**
	 *
	 * @author 홍의겸
	 * @date 2022. 5. 12.
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 제품군 정보 홈 페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "mem/MB074";
	}

	/**
	 *
	 * @author 홍의겸
	 * @date 2022. 5. 12.
	 * @return
	 * @throws Exception
	 * @description 제품정보 목록 검색
	 *
	 */
	@PostMapping(value = { "getCrmComnCdList" })
	public @ResponseBody Object getCrmComnCdList(@RequestBody EzMap param) throws Exception {
		log.debug("getCrmComnCdList");
		EzPaginationInfo page = param.getPaginationInfo();
		List<EzMap> list = crmComnCdService.getList(param);
		page.setTotalRecordCount(crmComnCdService.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 *
	 * @author 홍의겸
	 * @date 2022. 5. 12.
	 * @return
	 * @throws Exception
	 * @description 제품정보 목록 검색
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<ProductHomeVo> list = service.getList(param);
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author 홍의겸
	 * @date 2022. 5. 12.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 제품정보 저장
	 *
	 */
	@PostMapping(value = { "save" })
	public @ResponseBody Object save(@RequestBody ProductHomeVo vo) throws Exception {
		return service.save(vo);
	}

	@PostMapping(value = { "saveList" })
	public @ResponseBody Object saveList(@RequestBody List<CrmComnCdBaseVo> list) throws Exception {
		return service.saveList(list);
	}
}