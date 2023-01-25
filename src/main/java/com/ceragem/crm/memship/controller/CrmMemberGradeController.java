package com.ceragem.crm.memship.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ceragem.crm.common.model.EzException;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.main.model.CrmCustBasVo;
import com.ceragem.crm.main.service.CrmCustBasService;

/**
 * 
 * @ClassName CrmMemberGradeController
 * @author 김성태
 * @date 2022. 6. 10.
 * @Version 1.0
 * @description 멤버쉽등급위치 표
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Controller
@RequestMapping(value = { "{menuCd}/mshipGrdeLoc" })
public class CrmMemberGradeController {

	@Autowired
	CrmCustBasService service;

	/**
	 * 
	 * @author 김성태
	 * @date 2022. 6. 10.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 멤버십위치 팝업
	 *
	 */
	@GetMapping(value = { "/{itgCustNo}" })
	public String init(@PathVariable("itgCustNo") String itgCustNo, @RequestParam Map<String, Object> param,
			ModelMap model) throws Exception {
		model.addAllAttributes(param);
		model.addAttribute("itgCustNo", itgCustNo);
		EzMap so = new EzMap();
		so.setString("itgCustNo", itgCustNo);
		CrmCustBasVo cust = service.get(so);
		if (cust == null)
			throw new EzException();
		
//		cust.setMshipGradeCd("003");
//		cust.setMshipAdvncmtScore("1512345");
//		cust.setCustTypeCd("003");
		
		int devide = 10000;
		model.addAttribute("cust", cust);
		model.addAttribute("myScore", Utilities.getNumberString(Utilities.parseInt(cust.getMshipAdvncmtScore())/devide));
		int myLevel = Utilities.parseInt( cust.getCustTypeCd());
		if(myLevel <1)
			myLevel = 1;
		if(myLevel > 5)
			myLevel = 5;
		model.addAttribute("myLevel", myLevel);
		int myScore = Utilities.parseInt(cust.getMshipAdvncmtScore())/devide;
		int myGrade = Utilities.parseInt(cust.getMshipGradeCd());
		int nextGrade = myGrade;
		String myGradeCd = "00" + myGrade;
		model.addAttribute("myGradeCd", myGradeCd);
		List<EzMap> list = service.getMemberShipScoreList(so);
		for (int i = 0; i < list.size(); i++) {
			int grade =list.get(i).getInt("gradeCd"); 
			int val = list.get(i).getInt("gradeVal")/devide; 
			if(grade == myGrade + 1)
			{
				nextGrade =grade;
				model.addAttribute("nextGradeName", list.get(i).getString("gradeNm"));
				model.addAttribute("nextOffset", Utilities.getNumberString(val - myScore ));
			}
			if(myGrade == grade)
				model.addAttribute("myGradeName", list.get(i).getString("gradeNm"));
			model.addAttribute("grade" + list.get(i).getString("gradeCd"),
					Utilities.getNumberString(list.get(i).getInt("gradeVal")/devide));
			model.addAttribute("gradeNm" + list.get(i).getString("gradeCd"),list.get(i).getString("gradeNm"));
		}
		
		model.addAttribute("myGrade",myGrade);
		model.addAttribute("myGradeCd",cust.getMshipGradeCd());
		model.addAttribute("nextGrade", nextGrade);
		model.addAttribute("gradeList", list);

		return Utilities.getProperty("tiles.crm.blank") + "memship/membershipLocation";
	}

}
