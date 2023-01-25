package com.ceragem.crm.mem.controller;

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
import com.ceragem.crm.mem.model.StipulationListVo;
import com.ceragem.crm.mem.service.StipulationListService;

/**
 * 
 * @ClassName	StipulationListController
 * @author      황재희
 * @date        2022. 4. 8.
 * @Version     1.0
 * @description 약관 목록 Controller
 * @Company     Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "stipulationList", "{menuCd}/stipulationList" })
public class StipulationListController{

	@Autowired
	StipulationListService service;
	
	/**
	 *
	 * @author      황재희
	 * @date        2022. 4. 8.
	 * @param       model
	 * @return
	 * @throws      Exception
	 * @description 약관 목록 페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
	    model.addAllAttributes(param);
	    return Utilities.getProperty("tiles.crm") + "mem/MB072";
	}
	
	/**
	 *
	 * @author      황재희
	 * @date        2022. 4. 8.
	 * @return
	 * @throws      Exception
	 * @description 약관 목록 검색
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
	    EzPaginationInfo page = param.getPaginationInfo();
	    List<StipulationListVo> list = service.getList(param);
	    page.setTotalRecordCount(service.getListCount(param));
	    return Utilities.getGridData(list,page);
	}
	
	/**
	 * 
	 * @author      황재희
	 * @date        2022. 4. 8.
	 * @return
	 * @throws      Exception
	 * @description 약관 상세 팝업
	 *                             
	 */
	@GetMapping(value = { "detail/{stpltNo}" })
	public String detail(StipulationListVo vo, @PathVariable("stpltNo") String stpltNo, @RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		
		if(stpltNo.equals("null")) {
			StipulationListVo info = service.getKey();
			vo.setStpltNo(info.getStpltNo());
			model.addAttribute("Stipulation", info);
		}else {
			vo.setStpltNo(stpltNo);
			model.addAttribute("Stipulation", service.get(vo));
		}
		
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "mem/MB073";
	}
	
	/**
	 * 
	 * @author      황재희
	 * @date        2022. 4. 13.
	 * @param vo
	 * @return
	 * @throws      Exception
	 * @description 약관 상세 저장
	 *
	 */
	@PostMapping(value = { "save" })
	public @ResponseBody Object save(@RequestBody StipulationListVo vo) throws Exception {
	    return service.save(vo);
	}
}