package com.ceragem.crm.mem.controller;

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
import com.ceragem.crm.mem.model.CalculateStatusSAPDayVo;
import com.ceragem.crm.mem.service.CalculateStatusSAPDayService;
import com.ceragem.crm.mem.service.CalculateStatusSAPExtinctionService;
import com.ceragem.crm.mem.service.CalculateStatusSAPSynthesisService;

/**
 * 
 * @ClassName    CalculateStatusSAPDayController
 * @author    안재홍
 * @date    2022. 5. 3.
 * @Version    1.0
 * @description    CRM일별사용SAP(설치일기준) Controller
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "memberCalculateStatusSAP", "{menuCd}/memberCalculateStatusSAP" })
public class CalculateStatusSAPDayController{

	@Autowired
	CalculateStatusSAPDayService calculateStatusSAPDayService;
	@Autowired
	CalculateStatusSAPExtinctionService calculateStatusSAPExtinctionService;
	@Autowired
	CalculateStatusSAPSynthesisService calculateStatusSAPSynthesisService;	
	
	/**
	 * 
	 * @author 안재홍
	 * @date 22022. 6. 8. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CalculateStatusSAPDay 페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
	    model.addAllAttributes(param);
	    return Utilities.getProperty("tiles.crm") + "mem/MB173";
	}
	

	@GetMapping(value = { "extinction" })
	public String extinction(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "mem/MB174";
	}
	
	@GetMapping(value = { "synthesis" })
	public String synthesis(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "mem/MB175";
	}
//	
//	// 월별포인트합계
//	@GetMapping(value = { "monthPointSum" })
//	public String monthSum(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
//		
//		model.addAllAttributes(param);
//		return Utilities.getProperty("tiles.crm") + "mem/monthPointSum";
//	}
//	
//	// 포인트내역(건별)
//	@GetMapping(value = { "point" })
//	public String point(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
//		
//		model.addAllAttributes(param);
//		return Utilities.getProperty("tiles.crm") + "mem/MB054";
//	}
//	
//	// 쿠폰내역(건별)
//	@GetMapping(value = { "coupon" })
//	public String coupon(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
//		
//		model.addAllAttributes(param);
//		return Utilities.getProperty("tiles.crm") + "mem/MB056";
//	}
//	
//	// 포인트 사용/적립현황
//	@PostMapping(value = { "getMonthPointSumList" })
//	public @ResponseBody Object getMonthPointSumList(@RequestBody EzMap param) throws Exception {
//	   List<PointUseVo> list = pointService.getMonthPointSumList(param);
//	   return Utilities.getGridData(list);
//	}
//	
//	// 포인트 사용/적립현황
//	@PostMapping(value = { "getPointList" })
//	public @ResponseBody Object getPointList(@RequestBody EzMap param) throws Exception {
//	   EzPaginationInfo page = param.getPaginationInfo();
//	   List<PointUseVo> list = pointService.getList(param);
//	   page.setTotalRecordCount(pointService.getListCount(param));
//	   return Utilities.getGridData(list,page);
//	}
	
	// 월별사용SAP(설치일기준) 목록
	@PostMapping(value = { "getCalculateStatusSAPDayList" })
	public @ResponseBody Object getCalculateStatusSAPDayList(@RequestBody EzMap param) throws Exception {
	   EzPaginationInfo page = param.getPaginationInfo();
	   List<CalculateStatusSAPDayVo> list = calculateStatusSAPDayService.getList(param);
	   page.setTotalRecordCount(calculateStatusSAPDayService.getListCount(param));
	   return Utilities.getGridData(list,page);
	}
	// 월별SAP(적립/소멸) 목록
	@PostMapping(value = { "getCalculateStatusSAPExtinctionList" })
	public @ResponseBody Object getCalculateStatusSAPExtinctionList(@RequestBody EzMap param) throws Exception {
	   EzPaginationInfo page = param.getPaginationInfo();
	   List<CalculateStatusSAPDayVo> list = calculateStatusSAPExtinctionService.getList(param);
	   page.setTotalRecordCount(calculateStatusSAPExtinctionService.getListCount(param));
	   return Utilities.getGridData(list,page);
	}	

	@PostMapping(value = { "getCalculateStatusSAPSynthesisList" })
	public @ResponseBody Object getCalculateStatusSAPSynthesisList(@RequestBody EzMap param) throws Exception {
	   EzPaginationInfo page = param.getPaginationInfo();
	   List<CalculateStatusSAPDayVo> list = calculateStatusSAPSynthesisService.getList(param);
	   page.setTotalRecordCount(calculateStatusSAPSynthesisService.getListCount(param));
	   return Utilities.getGridData(list,page);
	}	
	
//	@GetMapping(value = { "detailCoupon" })
//	public String detailCoupon(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
//		
//		model.addAllAttributes(param);
//		return Utilities.getProperty("tiles.crm.blank") + "mem/MB056";
//	}
//
//	// 무폰 사용/적립현황
//	@PostMapping(value = { "getCouponList" })
//	public @ResponseBody Object getCouponList(@RequestBody EzMap param) throws Exception {
//	   EzPaginationInfo page = param.getPaginationInfo();
//	   List<CouponUseVo> list = couponService.getList(param);
//	   page.setTotalRecordCount(couponService.getListCount(param));
//	   return Utilities.getGridData(list,page);
//	}	
	
    /**
     * SAP PNT 포인트 사용 완료 처리 IF
     * 
     * @param param
     * @return
     * @throws Exception
     */
	@PostMapping(value = { "/saveCalculateStatusSAPDay" })
    public @ResponseBody Object saveCalculateStatusSAPDay(@RequestBody Object obj) throws Exception {
        return calculateStatusSAPDayService.calculateStatusSAPDay(obj);
    }
	
    /**
     * SAP PNT 포인트적립/소멸 완료 IF
     * 
     * @param param
     * @return
     * @throws Exception
     */
    @PostMapping(value = { "/saveCalculateStatusSAPExtinction" })
    public @ResponseBody Object saveCalculateStatusSAPExtinction(@RequestBody Object obj) throws Exception {
        return calculateStatusSAPExtinctionService.calculateStatusSAPExtinction(obj);
    }
    
    /**
     * SAP PNT 포인트적립/소멸 완료 IF
     * 
     * @param param
     * @return
     * @throws Exception
     */
    @PostMapping(value = { "/saveCalculateStatusSAPSynthesis" })
    public @ResponseBody Object saveCalculateStatusSAPSynthesis(@RequestBody Object obj) throws Exception {
        return calculateStatusSAPSynthesisService.calculateStatusSAPSynthesisn(obj);
    }    
}
