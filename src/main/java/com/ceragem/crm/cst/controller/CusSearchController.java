package com.ceragem.crm.cst.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.ceragem.crm.common.util.Utilities;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.cst.model.CusSearchVo;
import com.ceragem.crm.cst.service.CusSearchService;


/**
 * 
 * @ClassName    CusCeraCkListController
 * @author    황의겸
 * @date    2022. 4. 25.
 * @Version    1.0
 * @description    CRM 회원 선택 팝업 Controller
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value =  "util/searchCust" )
public class CusSearchController{

	@Autowired
	CusSearchService service;
	
	/**
	 * 
	 * @author 황의겸
	 * @date 2022. 4. 25. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM 회원 선택 팝업 목록페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
	    model.addAllAttributes(param);
	    return Utilities.getProperty("tiles.crm") + "cst/CR061";
	}
	
   @GetMapping(value = { "/{bkYn}" })
   public String dataPop(CusSearchVo vo, @PathVariable("bkYn") String bkYn, @RequestParam Map<String, Object> param, ModelMap model) throws Exception {
        model.addAttribute("bkYn", bkYn);
        return Utilities.getProperty("tiles.crm") + "cst/CR061";
    }
   
	/**
	 * 
	 * @author 황의겸
	 * @date 2022. 4. 25. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM 회원 선택 팝업 목록검색
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
	    EzPaginationInfo page = param.getPaginationInfo();
	    List<CusSearchVo> list = service.getList(param);
	    page.setTotalRecordCount(service.getListCount(param));
	    return Utilities.getGridData(list,page);
	}
	
}
