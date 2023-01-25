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
import com.ceragem.crm.mem.model.PromotionPointListVo;
import com.ceragem.crm.mem.service.PromotionPointListService;

/**
 * 
 * @ClassName      PromotionPointListController
 * @author    	   황재희
 * @date    	   2022. 5. 12.
 * @Version    	   1.0
 * @description    프로모션 탭 포인트현황 Controller
 * @Company    	   Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "promotionPointList", "{menuCd}/promotionPointList" })
public class PromotionPointListController{

	@Autowired
	PromotionPointListService service;
	
	/**
	 * 
	 * @author 		황재희
	 * @date 		2022. 5. 12. * @param param
	 * @param 		model
	 * @return
	 * @throws 	    Exception
	 * @description 프로모션 탭 포인트현황 목록페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
	    model.addAllAttributes(param);
	    return Utilities.getProperty("tiles.crm") + "mem/MB050";
	}
	
	/**
	 * 
	 * @author 		황재희
	 * @date 		2022. 5. 12. * @param param
	 * @return
	 * @throws 		Exception
	 * @description 프로모션 탭 포인트현황 목록검색
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
	    EzPaginationInfo page = param.getPaginationInfo();
	    List<PromotionPointListVo> list = service.getList(param);
	    page.setTotalRecordCount(service.getListCount(param));
	    return Utilities.getGridData(list,page);
	}
	
	/**
	 * 
	 * @author 		황재희
	 * @date 		2022. 5. 12. * @param rparam
	 * @return
	 * @throws 		Exception
	 * @description 프로모션 탭 포인트현황 1건검색
	 *
	 */
	@GetMapping(value = { "get" })
	public @ResponseBody Object get(@RequestParam Map<String, Object> rparam) throws Exception {
	    EzMap param = new EzMap(rparam);
	    return service.get(param);
	}
	/**
	 * 
	 * @author 		황재희
	 * @date 		2022. 5. 12. * @param vo
	 * @return
	 * @throws 		Exception
	 * @description 프로모션 탭 포인트현황 저장
	 * */@PostMapping(value = {"save" })
	public @ResponseBody Object save(@RequestBody PromotionPointListVo vo) throws Exception {
	    return service.save(vo);
	}
	
	/**
	 * 
	 * @author 		황재희
	 * @date 		2022. 5. 12. * @param list
	 * @return
	 * @throws 		Exception
	 * @description 프로모션 탭 포인트현황 리스트 저장
	 *
	 */
	@PostMapping(value = { "saveList" })
	public @ResponseBody Object saveList(@RequestBody List<PromotionPointListVo> list) throws Exception {
	    return service.saveList(list);
	}
	/**
	 * 
	 * @author 		황재희
	 * @date 		2022. 5. 12.
	 * @param 		list
	 * @return
	 * @throws 		Exception
	 * @description 프로모션 탭 포인트현황 리스트 삭제
	 *
	 */
	@PostMapping(value = { "deleteList" })
	public @ResponseBody Object deleteList(@RequestBody List<PromotionPointListVo> list) throws Exception {
	    return service.deleteList(list);
	}
}
