package com.ceragem.crm.cst.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.ceragem.crm.cst.model.BlackCusVo;
import com.ceragem.crm.cst.service.BlackCusService;

/**
 * 
 * @ClassName    BlackCusController
 * @author    황의겸
 * @date    2022. 5. 3.
 * @Version    1.0
 * @description    CRM블랙리스트 Controller
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "blackCus", "{menuCd}/blackCus" })
public class BlackCusController{

	@Autowired
	BlackCusService service; 
	
    //eon
    @Value("${spring.eon.send.url}")
    String eonUrl;
    
    @Value("${spring.eon.send.user}")
    String eonUser;	
	/**
	 * 
	 * @author 황의겸
	 * @date 22022. 5. 3. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM블랙리스트 목록페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
	    model.addAttribute("eonUrl",eonUrl);
        model.addAttribute("eonUser",eonUser);
	    model.addAllAttributes(param);
	    return Utilities.getProperty("tiles.crm") + "cst/CR049";
	}
	/**
	 * 
	 * @author      황의겸
	 * @date        2022. 5. 4.
	 * @return
	 * @throws      Exception
	 * @description 블랙 등록 팝업
	 *                             
	 */
	@GetMapping(value = { "detail/{itgCustNo}" })
	public String detail(BlackCusVo vo, @PathVariable("itgCustNo") String itgCustNo, @RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		// 통합고객번호가 넘어올 경우 
		if( !itgCustNo.equals("null")) {
			vo.setItgCustNo(itgCustNo);
			model.addAttribute("addMode", "U" );
			model.addAttribute("Black", service.get(vo));
		}
		else
		{
			model.addAttribute("addMode", "C" );
		}
		
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "cst/CR050";
	}
	/**
	 * 
	 * @author      황의겸
	 * @date        2022. 5. 9.
	 * @return
	 * @throws      Exception
	 * @description 블랙 상세 팝업
	 *                             
	 */
	@GetMapping(value = { "detailHistory/{itgCustNo}" })
	public String detailHistory(BlackCusVo vo, @PathVariable("itgCustNo") String itgCustNo, @RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAttribute("itgCustNo", itgCustNo);
		model.addAllAttributes(param);
		
		return Utilities.getProperty("tiles.crm.blank") + "cst/CR070";
	}
	/**
	 * 
	 * @author 황의겸
	 * @date 2022. 5. 3. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM블랙리스트 목록검색
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
	    EzPaginationInfo page = param.getPaginationInfo();
	    List<BlackCusVo> list = service.getList(param);
	    page.setTotalRecordCount(service.getListCount(param));
	    return Utilities.getGridData(list,page);
	}
	
	/**
	 * 
	 * @author 황의겸
	 * @date 2022. 5. 3. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM블랙리스트 목록검색
	 *
	 */
	@PostMapping(value = { "getBlackHistoryList" })
	public @ResponseBody Object getBlackHistoryList(@RequestBody EzMap param) throws Exception {
	    EzPaginationInfo page = param.getPaginationInfo();
	    List<BlackCusVo> list = service.getBlackHistoryList(param);
	    page.setTotalRecordCount(service.getBlackHistoryCount(param));
	    return Utilities.getGridData(list,page);
	}
	
	//블랙 고객발송 관련
    @PostMapping(value = { "saveTargetSendInfo" })
    public @ResponseBody Object saveTargetSendInfo(@RequestBody EzMap param) throws Exception {
        return service.saveTargetSendInfo(param);
    }
    
    @PostMapping(value = { "getTargetCustSendList" })
    public @ResponseBody Object getTargetCustSendList(@RequestBody EzMap param) throws Exception {
        EzPaginationInfo page = param.getPaginationInfo();
        List<EzMap> list = service.getTargetCustSendList(param);
        page.setTotalRecordCount(service.getTargetCustSendListCount(param));
        
        return Utilities.getGridData(list,page);
    }
    //블랙 고객발송 관련
	/**
	 * 
	 * @author 황의겸
	 * @date 2022. 5. 4. * @param rparam
	 * @return
	 * @throws Exception
	 * @description CRM블랙리스트 1건검색
	 *
	 */
	@GetMapping(value = { "get" })
	public @ResponseBody Object get(@RequestParam Map<String, Object> rparam) throws Exception {
	    EzMap param = new EzMap(rparam);
	    return service.get(param);
	}
	/**
	 * 
	 * @author 황의겸
	 * @date 2022. 5. 4. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM블랙리스트 저장
	 * */@PostMapping(value = {"save" })
	public @ResponseBody Object save(@RequestBody BlackCusVo vo) throws Exception {
	    return service.save(vo);
	}
	
	/**
	 * 
	 * @author 황의겸
	 * @date 2022. 5. 4. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM블랙리스트 저장
	 *
	 */
	@PostMapping(value = { "saveBlack" })
	public @ResponseBody Object saveBlack(@RequestBody BlackCusVo vo) throws Exception {
	    return service.saveBlack(vo);
	}
		
	/**
	 * 
	 * @author 황의겸
	 * @date 2022. 5. 4. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM블랙리스트 리스트 저장
	 *
	 */
	@PostMapping(value = { "saveBlackList" })
	public @ResponseBody Object saveBlackList(@RequestBody List<BlackCusVo> list) throws Exception {
	    return service.saveBlackList(list);
	}
	
	/**
	 * 
	 * @author 황의겸
	 * @date 2022. 5. 4. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM블랙리스트 리스트 저장
	 *
	 */
	@PostMapping(value = { "deleteBlackList" })
	public @ResponseBody Object deleteBlackList(@RequestBody List<BlackCusVo> list) throws Exception {
	    return service.deleteBlackList(list);
	}
	
	/**
	 * 
	 * @author 황의겸
	 * @date 2022. 5. 4.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description CRM블랙리스트 해제
	 *
	 */
	@PostMapping(value = { "deleteBlack" })
	public @ResponseBody Object deleteBlack(@RequestBody BlackCusVo vo) throws Exception {
	    return service.deleteBlack(vo);
	}
}
