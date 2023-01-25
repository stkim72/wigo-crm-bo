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
import com.ceragem.crm.mem.model.PointIssueVo;
import com.ceragem.crm.mem.service.PointIssueService;

/**
 * 
 * @ClassName	PointIssueController
 * @author      황재희
 * @date        2022. 4. 18.
 * @Version     1.0
 * @description 포인트 발행 목록 Controller
 * @Company     Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "pointIssue", "{menuCd}/pointIssue" })
public class PointIssueController{

	@Autowired
	PointIssueService service;
	
	/**
	 *
	 * @author      황재희
	 * @date        2022. 4. 18.
	 * @param       model
	 * @return
	 * @throws      Exception
	 * @description 포인트 발행 목록 페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
	    model.addAllAttributes(param);
	    return Utilities.getProperty("tiles.crm") + "mem/MB020";
	}
	
	/**
	 *
	 * @author      황재희
	 * @date        2022. 4. 18.
	 * @return
	 * @throws      Exception
	 * @description 포인트 발행 목록 검색
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
	    EzPaginationInfo page = param.getPaginationInfo();
	    
	    List<PointIssueVo> list = service.getList(param);
	    page.setTotalRecordCount(service.getListCount(param));
	    return Utilities.getGridData(list,page);
	}
	
	/**
	 * 
	 * @author      황재희
	 * @date        2022. 4. 18.
	 * @return
	 * @throws      Exception
	 * @description 포인트 발행 상세 팝업
	 *                             
	 */
	@GetMapping(value = { "regPopup/{itgCustNo}" })
	public String regPopup(PointIssueVo vo, @PathVariable("itgCustNo") String itgCustNo, @RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		vo.setItgCustNo(itgCustNo);
		model.addAttribute("PointIssue", service.selectUserInfo(vo));
		return Utilities.getProperty("tiles.crm") + "mem/MB021";
	}
	
	/**
	 * 
	 * @author      황재희
	 * @date        2022. 5. 3.
	 * @return
	 * @throws      Exception
	 * @description 포인트 발행 상세 팝업(그리드 더블 클릭)
	 *                             
	 */
	@GetMapping(value = { "detail/{pointHstSeq}" })
	public String detail(PointIssueVo vo, @PathVariable("pointHstSeq") String pointHstSeq, @RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		vo.setPointHstSeq(pointHstSeq);
		model.addAttribute("PointIssue", service.get(vo));
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "mem/MB021_1";
	}
	
	/**
	 * 
	 * @author      황재희
	 * @date        2022. 4. 18.
	 * @param vo
	 * @return
	 * @throws      Exception
	 * @description 포인트 상세 등록
	 *
	 */
	@PostMapping(value = { "save" })
	public @ResponseBody Object save(@RequestBody PointIssueVo vo) throws Exception {
	    return service.save(vo);
	}
	
	/**
	 * 
	 * @author      황재희
	 * @date        2022. 4. 26.
	 * @param vo
	 * @return
	 * @throws      Exception
	 * @description 포인트 증감 내역 팝업
	 *
	 */
	@GetMapping(value = { "IncreasePop" })
	public String addressPop(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "mem/IncreasePop";
	}
	
	/**
	 * 
	 * @author      황재희
	 * @date        2022. 5. 6.
	 * @param 		vo
	 * @return
	 * @throws      Exception
	 * @description 포인트발생내역, 잔여포인트 저장
	 *
	 */
	@PostMapping(value = { "savePointScoreList" })
	public @ResponseBody Object savePointScoreList(@RequestBody List<PointIssueVo> list) throws Exception {
	    return service.savePointScoreList(list);
	}
}