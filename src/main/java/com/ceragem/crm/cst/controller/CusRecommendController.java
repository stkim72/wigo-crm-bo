package com.ceragem.crm.cst.controller;

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
import com.ceragem.crm.cst.model.CusRecommendVo;
import com.ceragem.crm.cst.service.CusRecommendService;

/**
 * 
 * @ClassName	CusRecommendController
 * @author      황재희
 * @date        2022. 4. 28.
 * @Version     1.0
 * @description 설문이력 Controller
 * @Company     Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "cusRecommendList", "{menuCd}/cusRecommendList" })
public class CusRecommendController{

	@Autowired
	CusRecommendService service;
	
	/**
	*
	* @author      황재희
	* @date        2022. 4. 28.
	* @param       model
	* @return
	* @throws      Exception
	* @description 설문이력 페이지
	*
	*/
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
	    model.addAllAttributes(param);
	    return Utilities.getProperty("tiles.crm") + "cst/CR029";
	}
	
	/**
	 *
	 * @author      황재희
	 * @date        2022. 4. 28.
	 * @return
	 * @throws      Exception
	 * @description 설문이력 검색
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
	    EzPaginationInfo page = param.getPaginationInfo();
	    List<CusRecommendVo> list = service.getList(param);
	    page.setTotalRecordCount(service.getListCount(param));
	    return Utilities.getGridData(list,page);
	}
	
	/**
	*
	* @author      황재희
	* @date        2022. 4. 28.
	* @param       model
	* @return
	* @throws      Exception
	* @description 설문이력 탭 연결
	*
	*/
	@GetMapping(value = { "CusRecommendList" })
	public String CusRecommendList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "cst/CR029";
	}
}