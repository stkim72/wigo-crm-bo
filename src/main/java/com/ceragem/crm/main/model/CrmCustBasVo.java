package com.ceragem.crm.main.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmCustBasVo
 * @author    user
 * @date    2022. 4. 19.
 * @Version    1.0
 * @description    CRM고객기본 Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmCustBasVo extends BaseVo {
/**
*
*/
private static final long serialVersionUID = 1L;
/**
 * 통합고객번호
 */
private String itgCustNo;
/**
 * 법인구분여부
 */
private String corpDivYn;
/**
 * 고객명
 */
private String custNm;
/**
 * 성별코드 공통코드 : S040 [M : 남 , F : 여]
 */
private String gndrCd;
/**
 * 생년월일
 */
private String birthday;
/**
 * 사업자등록번호
 */
private String bizNo;
/**
 * 법인등록번호
 */
private String corpRegNo;
/**
 * 법인전화번호
 */
private String corpTelNo;
/**
 * 외국인여부
 */
private String fornYn;
/**
 * 대표명
 */
private String repNm;
/**
 * 이동전화번호
 */
private String mphonNo;

/**
 * 이동전화번호암호화값
 */
private String mphonNoEncVal;

/**
 * 이동전화뒤자리번호
 */
private String mphonBkDgtNo;
/**
 * 이메일주소
 */
private String emailAddr;
/**
 * 담당자명
 */
private String picNm;
/**
 * 담당자이동전화번호
 */
private String picMphonNo;
/**
 * 담당자이동전화뒤자리번호
 */
private String picMphonBkDgtNo;
/**
 * 담당자이메일주소
 */
private String picEmailAddr;
/**
 * 개인정보유효기간시작일시
 */
private String indiInfoValidPerdStaDt;
/**
 * 개인정보유효기간종료일시
 */
private String indiInfoValidPerdEndDt;
/**
 * 고객상태코드 공통코드 : CU020 [001 : 정상 , 002 : 휴면 , 003 : 탈회]
 */
private String custStatusCd;

private String custStatusCdNm;
/**
 * 고객상태변경일시
 */
private String custStatusChngDt;


/**
 * 멤버십예정등급코드
 */
private String mshipExptGradeCd;
/**
 * 멤버십승급점수
 */
private String mshipAdvncmtScore;

/**
 * 고객정보변경일시
 */
private String custInfoChngDt;
/**
 * 고객유형코드 공통코드 : CU030 [001 : 잠재고객 , 002 : 가망고객 , 003 : 체험고객 , 004 : 구매고객 , 005
 * : 추천고객 , 006 : 충성고객]
 */
private String custTypeCd;

private String custTypeCdNm;
/**
 * 고객구분코드 공통코드 : CU010 [001 : 개인 , 002 : 법인]
 */
private String custDivCd = "001";

private String custDivCdNm;
/**
 * 지역코드 공통코드 : CU100 [42 : 강원도 , 41 : 경기도 , 48 : 경상남도 , 47 : 경상북도 , 29 : 광주광역시 ,
 * 27 : 대구광역시 , 30 : 대전광역시 , 26 : 부산광역시 , 11 : 서울특별시 , 36 : 세종특별자치시 , 31 : 울산광역시
 * , 28 : 인천광역시 , 46 : 전라남도 , 45 : 전라북도 , 50 : 제주특별자치도 , 44 : 충청남도 , 43 : 충청북도 ,
 * 99 : 기타]
 */
private String distrctCd;
/**
 * 지역코드명
 */

private String distrctCdNm;
/**
 * 우편번호
 */

private String zipCd;
/**
 * 주소1내용
 */

private String addr1Ctnts;
/**
 * 주소2내용
 */

private String addr2Ctnts;
/**
 * 추천매장번호
 */

private String rcmdStorNo;

private String rcmdStorNoNm;
/**
 * 추천인고객번호
 */

private String rcmdrCustNo;
/**
 * 추천임직원번호
 */

private String rcmdExecvdempNo;
/**
 * 결혼여부
 */

private String marryYn;
/**
 * 대표가구번호
 */

private String repHshldNo;
/**
 * 가족관계코드 공통코드 : CU040 [001 : 부모 , 002 : 배우자 , 003 : 자녀]
 */

private String famlyRelCd;

private String famlyRelCdNm;
/**
 * 주거평수코드 공통코드 : CU050 [001 : 1평 ~ 10평 , 002 : 11평 ~ 20평 , 003 : 21평 ~ 30평 , 004
 * : 30평 ~ 40평 , 005 : 41평 ~ 50평 , 006 : 51평 ~ 60평 , 007 : 61평 ~ 70평 , 008 : 71평
 * ~ 80평 , 009 : 81평 이상]
 */

private String dwelNfpyCd;

private String dwelNfpyCdNm;
/**
 * 관심분야코드 공통코드 : CU060 [001 : 건강 , 002 : 음식 , 003 : 주거 , 004 : 의료 , 005 : 스포츠 ,
 * 006 : 연예]
 */
private String intrstFildCd;

private String intrstFildCdNm;
/**
 * 대표제품번호
 */

private String repGodsNo;

private String repGodsNoNm;
/**
 * 대표사용고객구분코드 공통코드 : CU010 [001 : 개인 , 002 : 법인]
 */

private String repUseCustDivCd;

private String repUseCustDivCdNm;
/**
 * SMS수신동의여부
 */

private String smsRcvAgreeYn;
/**
 * SMS수신동의일시
 */

private String smsRcvAgreeDt;
/**
 * SMS수신동의채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
 */

private String smsRcvAgreeChlCd;

private String smsRcvAgreeChlCdNm;
/**
 * 이메일수신동의여부
 */
private String emailRcvAgreeYn;
/**
 * 이메일수신동의일시
 */

private String emailRcvAgreeDt;
/**
 * 이메일수신동의채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
 */

private String emailRcvAgreeChlCd;

private String emailRcvAgreeChlCdNm;
/**
 * 알람톡수신동의여부
 */

private String alrmTkRcvAgreeYn;
/**
 * 알람톡수신동의일시
 */

private String alrmTkRcvAgreeDt;
/**
 * 알람톡수신동의채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
 */

private String alrmTkRcvAgreeChlCd;

private String alrmTkRcvAgreeChlCdNm;
/**
 * PUSH수신동의여부
 */

private String pushRcvAgreeYn;
/**
 * PUSH수신동의일시
 */

private String pushRcvAgreeDt;
/**
 * PUSH수신동의채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
 */

private String pushRcvAgreeChlCd;

private String pushRcvAgreeChlCdNm;
/**
 * CI인증여부
 */

private String ciCertfYn;
/**
 * CI
 */

private String ci;
/**
 * DI인증여부
 */

private String diCertfYn;
/**
 * DI
 */

private String di;
/**
 * 수신거부여부
 */

private String rcvRfslYn;
/**
 * 멤버십가입여부
 */

private String mshipSbscYn;
/**
 * 멤버십로그인ID
 */

private String mshipLoginId;
/**
 * 멤버십대체번호
 */

private String mshipSbtNo;
/**
 * 멤버십로그인비밀번호
 */

private String mshipLoginPwd;
/**
 * 멤버십최종로그인일시
 */

private String mshipLastLoginDt;
/**
 * 멤버십최종로그인IP주소
 */

private String mshipLastLoginIpAddr;
/**
 * 멤버십최종매장방문일시
 */

private String mshipLastStorVisitDt;
/**
 * 멤버십최종방문매장번호
 */

private String mshipLastVisitStorNo;

private String mshipLastVisitStorNoNm;
/**
 * 멤버십유형코드 공통코드 : MB010 [001 : 임직원 , 002 : 제휴 , 003 : 회원 , 004 : 비회원]
 */

private String mshipTypeCd;

private String mshipTypeCdNm;
/**
 * 멤버십가입일시
 */

private String mshipSbscDt;
/**
 * 멤버십등급코드 공통코드 : MB020 [001 : 일반 , 002 : 화이트 , 003 : 브론즈 , 004 : 실버 , 005 : 골드
 * , 006 : VIP]
 */

private String mshipGradeCd;

private String mshipGradeCdNm;
/**
 * 멤버십등급변경일시
 */

private String mshipGradeChngDt;
/**
 * 멤버십정보변경일시
 */

private String mshipInfoChngDt;
/**
 * 멤버십정보확인자임직원번호
 */

private String mshipInfoConfrExecvdempNo;
/**
 * 제휴임직원번호
 */

private String cprtExecvdempNo;
/**
 * 멤버십탈퇴일시
 */

private String mshipLeaveDt;
/**
 * 소멸포인트한도점수
 */

private Integer extncPointLmtScore;
/**
 * 적립포인트한도점수
 */

private Integer accumPointLmtScore;

/**
 * 잔여포인트점수
 */

private Integer remainPointScore;

/**
 * 멤버십채널코드
 */
private String mshipChlCd;

private String mshipChlCdNm;
/**
 * 블랙등록매장번호
 */
private String bllkRegStorNo;

private String bllkRegStorNoNm;
/**
 * 블랙회원여부
 */
private String bllkmshpYn;
/**
 * 블랙등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
 */
private String bllkRegChlCd;

private String bllkRegChlCdNm;
/**
 * 블랙등록사유내용
 */
private String bllkRegWhyCtnts;
/**
 * 블랙등록일시
 */
private String bllkRegDt;
/**
 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP]
 */
private String regChlCd;

private String regChlCdNm;

private String instTelNoEncVal;

private String instTelNo;

private String instDistrctCd;

private String instDistrctCdNm;

private String instZipCd;

private String instAddr1;

private String instAddr2;


private String jobTelNoEncVal;

private String jobTelNo;

private String jobDistrctCd;

private String jobDistrctCdNm;

private String jobZipCd;

private String jobAddr1;

private String jobAddr2;


private String homeTelNoEncVal;

private String homeTelNo;

private String homeDistrctCd;

private String homeDistrctCdNm;

private String homeZipCd;

private String homeAddr1;

private String homeAddr2;

private Integer blackCnt;


private String cardNo;


private String coupnTypeCd;


private String eventCd;

/**
 * 보호가족 여부
 */
private String prtctFamlyYn;

/**
 * 개인정보취급자번호
 */
private String indiInfoHandlPrsnNo;

/**
 * 접속자IP주소
 */
private String connPrsnIpAddr;

/**
 * 유저CD
 */
private String userCd;

private String amdDt;

/**
 * 연락처일련번호
 */
private String cntplcSeq;
/*
 * 휴면기간코드
 * */
private String dormPerdCd = "1";
}
