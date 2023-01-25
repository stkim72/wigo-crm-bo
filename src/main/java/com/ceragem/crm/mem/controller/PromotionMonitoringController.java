package com.ceragem.crm.mem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.mem.model.PromotionListVo;
import com.ceragem.crm.mem.model.PromotionMonitoringVo;
import com.ceragem.crm.mem.service.PromotionMonitoringService;

/**
 * 
 * @ClassName PromotionMonitoringController
 * @author 황재희
 * @date 2022. 6. 20.
 * @Version 1.0
 * @description 프로모션 모니터링 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "promotionMonitoring", "{menuCd}/promotionMonitoring" })
public class PromotionMonitoringController {

	@Autowired
	PromotionMonitoringService service;

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 6. 20. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 프로모션 모니터링 목록페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "mem/MB041";
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 6. 20. * @param param
	 * @return
	 * @throws Exception
	 * @description 프로모션 모니터링 목록검색
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
//		List<PromotionMonitoringVo> list = service.getList(param);
		List<PromotionMonitoringVo> list = service.getListAddCount(param);
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 6. 20. * @param rparam
	 * @return
	 * @throws Exception
	 * @description 프로모션 모니터링 1건검색
	 *
	 */
	@GetMapping(value = { "get" })
	public @ResponseBody Object get(@RequestParam Map<String, Object> rparam) throws Exception {
		EzMap param = new EzMap(rparam);
		return service.get(param);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 6. 20. * @param vo
	 * @return
	 * @throws Exception
	 * @description 프로모션 모니터링 저장
	 */
	@PostMapping(value = { "save" })
	public @ResponseBody Object save(@RequestBody PromotionMonitoringVo vo) throws Exception {
		return service.save(vo);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 6. 20. * @param vo
	 * @return
	 * @throws Exception
	 * @description 프로모션 모니터링 중지, 재실행
	 */
	@PostMapping(value = { "savePromotionStatus" })
	public @ResponseBody Object savePromotionStatus(@RequestBody PromotionMonitoringVo vo) throws Exception {
		return service.savePromotionStatus(vo);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 6. 20. * @param list
	 * @return
	 * @throws Exception
	 * @description 프로모션 모니터링 리스트 저장
	 *
	 */
	@PostMapping(value = { "saveList" })
	public @ResponseBody Object saveList(@RequestBody List<PromotionMonitoringVo> list) throws Exception {
		return service.saveList(list);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 6. 20.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description 프로모션 모니터링 리스트 삭제
	 *
	 */
	@PostMapping(value = { "deleteList" })
	public @ResponseBody Object deleteList(@RequestBody List<PromotionMonitoringVo> list) throws Exception {
		return service.deleteList(list);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 6. 21.
	 * @return
	 * @throws Exception
	 * @description 프로모션 모니터링 간접반응 팝업(그리드 더블 클릭)
	 * 
	 */
	@GetMapping(value = { "indirectPopupBos/{mshipPromBasNo}" })
	public String indirectPopupBos(PromotionMonitoringVo vo, @PathVariable("mshipPromBasNo") String mshipPromBasNo,
			@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		vo.setMshipPromBasNo(mshipPromBasNo);
		model.addAttribute("PromotionMonitoring", service.get(vo));
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "mem/MB210";
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 6. 21.
	 * @return
	 * @throws Exception
	 * @description 프로모션 모니터링 간접반응 팝업(그리드 더블 클릭)
	 * 
	 */
	@GetMapping(value = { "indirectPopupPos/{mshipPromBasNo}" })
	public String indirectPopupPos(PromotionMonitoringVo vo, @PathVariable("mshipPromBasNo") String mshipPromBasNo,
			@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		vo.setMshipPromBasNo(mshipPromBasNo);
		model.addAttribute("PromotionMonitoring", service.get(vo));
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "mem/MB210_1";
	}

	/**
	 *
	 * @author 황재희
	 * @date 2022. 6. 22.
	 * @return
	 * @throws Exception
	 * @description 프로모션 모니터링 간접반응 리스트 검색
	 *
	 */
	@PostMapping(value = { "getIndirectUserListBos" })
	public @ResponseBody Object getIndirectUserListBos(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();

		List<PromotionListVo> list = service.getBosOrderListMonitor(param);
		page.setTotalRecordCount(service.getBosOrderListCountMonitor(param));

		return Utilities.getGridData(list, page);
	}

	/**
	 *
	 * @author 황재희
	 * @date 2022. 6. 22.
	 * @return
	 * @throws Exception
	 * @description 프로모션 모니터링 간접반응 리스트 검색
	 *
	 */
	@PostMapping(value = { "getIndirectUserListPos" })
	public @ResponseBody Object getIndirectUserListPos(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();

		List<PromotionListVo> list = service.getPosOrderListMonitor(param);
		page.setTotalRecordCount(service.getPosOrderListCountMonitor(param));

		return Utilities.getGridData(list, page);
	}
}
