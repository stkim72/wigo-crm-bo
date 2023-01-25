package com.ceragem.crm.cusstatus.controller;

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
import com.ceragem.crm.cusstatus.service.CrmCouponUsedBuysService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = { "couponUsedBuys" })
@RequiredArgsConstructor
public class CrmCouponUsedBuysController {
	
	@Autowired
	private final CrmCouponUsedBuysService service;

	@GetMapping(value = { "", "index"})
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cusStatus/couponUsedBuys";
	}

	@PostMapping(value = { "getCoupnMasterForSelect" })
	public @ResponseBody Object getCoupnMasterForSelect(@RequestBody EzMap param) throws Exception {
		List<EzMap> list = service.getCoupnMasterForSelect(param);
		EzPaginationInfo page = param.getPaginationInfo();
		page.setTotalRecordCount(service.getCoupnMasterForSelectCount(param));
		return Utilities.getGridData(list,page);
	}
	
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
		List<EzMap> list = service.getList(param);
		EzPaginationInfo page = param.getPaginationInfo();
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list,page);
	}

	@PostMapping(value = { "getCoupnUsedBuysList" })
	public @ResponseBody Object getCoupnUseBuysList(@RequestBody EzMap param) throws Exception {
		List<EzMap> list = service.getCoupnUseBuysList(param);
		EzPaginationInfo page = param.getPaginationInfo();
		page.setTotalRecordCount(service.getCoupnUseBuysCount(param));
		return Utilities.getGridData(list,page);
	}
	
	@GetMapping(value = { "coupnUsedBuysPopup/{mshipCoupnBasNo}/{fromPblsStdDay}/{toPblsStdDay}/{toBuysDay}" })
	public String coupnUsedBuysPopup( @PathVariable("mshipCoupnBasNo") String mshipCoupnBasNo
			, @PathVariable("fromPblsStdDay") String fromPblsStdDay
			, @PathVariable("toPblsStdDay") String toPblsStdDay
			, @PathVariable("toBuysDay") String toBuysDay
			, ModelMap model) throws Exception {
		
		model.addAttribute("mshipCoupnBasNo", mshipCoupnBasNo);
		model.addAttribute("fromPblsStdDay", fromPblsStdDay);
		model.addAttribute("toPblsStdDay", toPblsStdDay);
		model.addAttribute("toBuysDay", toBuysDay);
		return Utilities.getProperty("tiles.crm") + "cusStatus/couponUsedBuysDetail";
	}
	
	@PostMapping(value = { "getCouponUsedBuysDetail" })
	public @ResponseBody Object getCouponUsedBuysDetail(@RequestBody EzMap param) throws Exception {
		
		List<EzMap> list = service.getCoupnUseBuyDetailList(param);
		EzPaginationInfo page = param.getPaginationInfo();
		page.setTotalRecordCount(service.getCoupnUseBuyDetailCount(param));
		return Utilities.getGridData(list,page);
	}
}
