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
import com.ceragem.crm.mem.model.CalculateStatusVo;
import com.ceragem.crm.mem.model.CouponUseVo;
import com.ceragem.crm.mem.model.PointUseVo;
import com.ceragem.crm.mem.service.CalculateStatusService;
import com.ceragem.crm.mem.service.CouponUseService;
import com.ceragem.crm.mem.service.PointUseService;

/**
 * 
 * @ClassName    BlackCusController
 * @author    안재홍
 * @date    2022. 5. 3.
 * @Version    1.0
 * @description    CRM정산현황 Controller
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "memberCalcStatus", "{menuCd}/memberCalcStatus" })
public class CalculateStatusController{

	@Autowired
	CalculateStatusService calculateStatusService;
	@Autowired
	PointUseService pointService;
	@Autowired
	CouponUseService couponService;
	
	/**
	 * 
	 * @author 안재홍
	 * @date 22022. 6. 8. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CalculateStatus 페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
	    model.addAllAttributes(param);
	    return Utilities.getProperty("tiles.crm") + "mem/MB053";
	}
	
	
	@GetMapping(value = { "detailPoint" })
	public String detailPoint(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "mem/MB054";
	}
	
	// 월별포인트합계
	@GetMapping(value = { "monthPointSum" })
	public String monthSum(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "mem/monthPointSum";
	}
	
	// 포인트내역(건별)
	@GetMapping(value = { "point" })
	public String point(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "mem/MB054";
	}
	// 소멸포인트내역(건별)
    @GetMapping(value = { "pointExtinction" })
    public String pointExtinction(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
        model.addAllAttributes(param);
        return Utilities.getProperty("tiles.crm") + "mem/MB176";
    }
	
	// 쿠폰내역(건별)
	@GetMapping(value = { "coupon" })
	public String coupon(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "mem/MB056";
	}
	
	// 포인트 사용/적립현황
	@PostMapping(value = { "getMonthPointSumList" })
	public @ResponseBody Object getMonthPointSumList(@RequestBody EzMap param) throws Exception {
	   List<PointUseVo> list = pointService.getMonthPointSumList(param);
	   return Utilities.getGridData(list);
	}
	
	// 포인트 사용/적립현황
    @PostMapping(value = { "getMonthPointList" })
    public @ResponseBody Object getMonthPointList(@RequestBody EzMap param) throws Exception {
       List<PointUseVo> list = pointService.getMonthPointList(param);
       return Utilities.getGridData(list);
    }
    
	// 포인트 사용/적립현황
	@PostMapping(value = { "getPointList" })
	public @ResponseBody Object getPointList(@RequestBody EzMap param) throws Exception {
	   EzPaginationInfo page = param.getPaginationInfo();
	   List<PointUseVo> list = pointService.getList(param);
	   page.setTotalRecordCount(pointService.getListCount(param));
	   return Utilities.getGridData(list,page);
	}
	
	// 소멸포인트내역(건별) 목록
    @PostMapping(value = { "getPointExtinctionList" })
    public @ResponseBody Object getPointExtinctionList(@RequestBody EzMap param) throws Exception {
       EzPaginationInfo page = param.getPaginationInfo();
       List<PointUseVo> list = pointService.getPointExtinctionList(param);
       page.setTotalRecordCount(pointService.getPointExtinctionListCount(param));
       return Utilities.getGridData(list,page);
    }
    
	// 정산현황 목록
	@PostMapping(value = { "getCalculateStatusList" })
	public @ResponseBody Object getCalculateStatusList(@RequestBody EzMap param) throws Exception {
	   EzPaginationInfo page = param.getPaginationInfo();
	   List<CalculateStatusVo> list = calculateStatusService.getList(param);
	   page.setTotalRecordCount(calculateStatusService.getListCount(param));
	   return Utilities.getGridData(list,page);
	}

	@GetMapping(value = { "detailCoupon" })
	public String detailCoupon(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "mem/MB056";
	}

	// 무폰 사용/적립현황
	@PostMapping(value = { "getCouponList" })
	public @ResponseBody Object getCouponList(@RequestBody EzMap param) throws Exception {
	   EzPaginationInfo page = param.getPaginationInfo();
	   List<CouponUseVo> list = couponService.getList(param);
	   page.setTotalRecordCount(couponService.getListCount(param));
	   return Utilities.getGridData(list,page);
	}	

}
