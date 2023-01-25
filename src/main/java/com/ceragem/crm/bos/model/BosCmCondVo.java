package com.ceragem.crm.bos.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BosCmCondVo {
	String randomKey;
	String crmUsrId = "crm";
	String usrLocale = "ko";
	String crmYn = "Y";
	String crmJobSe = "";
}
