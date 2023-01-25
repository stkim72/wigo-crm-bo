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
import com.ceragem.crm.mem.model.PartnerHomeVo;
import com.ceragem.crm.mem.service.PartnerHomeService;
import com.ceragem.crm.sys.model.CrmComnCdBaseVo;

/**
 * 
 * @ClassName	PartnerHomeController
 * @author      황재희
 * @date        2022. 4. 18.
 * @Version     1.0
 * @description 제휴사정보 Controller
 * @Company     Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "partnerHome", "{menuCd}/partnerHome" })
public class PartnerHomeController{

	@Autowired
	PartnerHomeService service;
	
	/**
	*
	* @author      황재희
	* @date        2022. 4. 18.
	* @param       model
	* @return
	* @throws      Exception
	* @description 제휴사정보 홈 페이지
	*
	*/
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
	    model.addAllAttributes(param);
	    return Utilities.getProperty("tiles.crm") + "mem/MB063";
	}
	
	/**
	 *
	 * @author      황재희
	 * @date        2022. 4. 21.
	 * @return
	 * @throws      Exception
	 * @description 제휴사 목록 검색
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
	    EzPaginationInfo page = param.getPaginationInfo();
	    List<PartnerHomeVo> list = service.getList(param);
	    page.setTotalRecordCount(service.getListCount(param));
	    return Utilities.getGridData(list,page);
	}
	
	/**
	 *
	 * @author      황재희
	 * @date        2022. 4. 22.
	 * @return
	 * @throws      Exception
	 * @description 제휴사 임직원 리스트 검색
	 *
	 */
	@PostMapping(value = { "getExecvdempList" })
	public @ResponseBody Object getExecvdempList(@RequestBody EzMap param) throws Exception {
	    EzPaginationInfo page = param.getPaginationInfo();
	    List<PartnerHomeVo> list = service.getExecvdempList(param);
	    page.setTotalRecordCount(service.getExecvdempListCount(param));
	    return Utilities.getGridData(list,page);
	}
	
	/**
	 * 
	 * @author      황재희
	 * @date        2022. 4. 22.
	 * @param 		vo
	 * @return
	 * @throws      Exception
	 * @description 제휴사 정보 저장
	 *
	 */
	@PostMapping(value = { "save" })
	public @ResponseBody Object save(@RequestBody PartnerHomeVo vo) throws Exception {
	    return service.save(vo);
	}
	
	/**
	 * 
	 * @author      황재희
	 * @date        2022. 4. 22.
	 * @param 		vo
	 * @return
	 * @throws      Exception
	 * @description 제휴사 임직원 정보(엑셀업로드) 저장
	 *
	 */
	@PostMapping(value = { "saveExecvdempList" })
	public @ResponseBody Object saveExecvdempList(@RequestBody List<PartnerHomeVo> list) throws Exception {
	    return service.saveExecvdempList(list);
	}
	
	/**
	 * 
	 * @author      황재희
	 * @date        2022. 4. 25.
	 * @param 		vo
	 * @return
	 * @throws      Exception
	 * @description 제휴사 대상고객 삭제
	 *
	 */
	@PostMapping(value = { "deleteExecvdempList" })
	public @ResponseBody Object deleteExecvdempList(@RequestBody List<PartnerHomeVo> list) throws Exception {
	    return service.deleteExecvdempList(list);
	}
	
	
	@PostMapping(value = { "deleteAllExecvdempList" })
	public @ResponseBody Object deleteAllExecvdempList(@RequestBody EzMap param) throws Exception {
	    return service.deleteAllExecvdempList(param);
	}
	
	@PostMapping(value = { "saveList" })
	public @ResponseBody Object saveList(@RequestBody List<CrmComnCdBaseVo> list) throws Exception {
		return service.saveList(list);
	}
	
	/**
	*
	* @author      황재희
	* @date        2022. 4. 27.
	* @param       model
	* @return
	* @throws      Exception
	* @description 제휴사 대상고객 목록
	*
	*/
	@GetMapping(value = { "partnerHomeExecvdempList" })
	public String partnerHomeExecvdempList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "mem/MB090_1";
	}
	
	/**
	*
	* @author      황재희
	* @date        2022. 4. 28.
	* @param       model
	* @return
	* @throws      Exception
	* @description 제휴사 임직원정보 일괄등록
	*
	*/
	@GetMapping(value = { "partnerHomeExecvdempUpload" })
	public String PartnerHomeExecvdempUpload(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "mem/MB090_2";
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
		return Utilities.getProperty("tiles.crm.blank") + "cst/CusRecommendList";
	}
	
	/**
	 * 
	 * @author      황재희
	 * @date        2022. 9. 19.
	 * @param 		vo
	 * @return
	 * @throws      Exception
	 * @description 제휴사 대상고객 등급부여
	 *
	 */
	@PostMapping(value = { "saveGrade" })
	public @ResponseBody Object saveGrade(@RequestBody List<PartnerHomeVo> list) throws Exception {
	    return service.saveGrade(list);
	}
	
	@PostMapping(value = { "saveAllGrade" })
	public @ResponseBody Object saveAllGrade(@RequestBody EzMap param) throws Exception {
	    return service.saveAllGrade(param);
	}
}