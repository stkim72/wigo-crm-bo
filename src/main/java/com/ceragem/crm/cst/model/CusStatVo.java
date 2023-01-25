package com.ceragem.crm.cst.model;

import com.ceragem.crm.common.model.BaseVo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName CusStatVo
 * @author user
 * @date 2022. 7. 18.
 * @Version 1.0
 * @description CRM고객기본 Vo
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CusStatVo extends BaseVo {
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
	 * 성별코드
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
	 * 고객상태코드
	 */
	private String custStatusCd;
	/**
	 * 고객상태변경일시
	 */
	private String custStatusChngDt;
	/**
	 * 고객정보변경일시
	 */
	private String custInfoChngDt;
	/**
	 * 고객유형코드
	 */
	private String custTypeCd;
	/**
	 * 고객구분코드
	 */
	private String custDivCd;
	/**
	 * 지역코드
	 */
	private String distrctCd;
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
	 * 가족관계코드
	 */
	private String famlyRelCd;
	/**
	 * 주거평수코드
	 */
	private String dwelNfpyCd;
	/**
	 * 관심분야코드
	 */
	private String intrstFildCd;
	/**
	 * 대표제품번호
	 */
	private String repGodsNo;
	/**
	 * 대표사용고객구분코드
	 */
	private String repUseCustDivCd;
	/**
	 * SMS수신동의여부
	 */
	private String smsRcvAgreeYn;
	/**
	 * SMS수신동의일시
	 */
	private String smsRcvAgreeDt;
	/**
	 * SMS수신동의채널코드
	 */
	private String smsRcvAgreeChlCd;
	/**
	 * 이메일수신동의여부
	 */
	private String emailRcvAgreeYn;
	/**
	 * 이메일수신동의일시
	 */
	private String emailRcvAgreeDt;
	/**
	 * 이메일수신동의채널코드
	 */
	private String emailRcvAgreeChlCd;
	/**
	 * 알람톡수신동의여부
	 */
	private String alrmTkRcvAgreeYn;
	/**
	 * 알람톡수신동의일시
	 */
	private String alrmTkRcvAgreeDt;
	/**
	 * 알람톡수신동의채널코드
	 */
	private String alrmTkRcvAgreeChlCd;
	/**
	 * PUSH수신동의여부
	 */
	private String pushRcvAgreeYn;
	/**
	 * PUSH수신동의일시
	 */
	private String pushRcvAgreeDt;
	/**
	 * PUSH수신동의채널코드
	 */
	private String pushRcvAgreeChlCd;
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
	 * 제휴회사번호
	 */
	private String cprtCmpNo;
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
	/**
	 * 멤버십유형코드
	 */
	private String mshipTypeCd;
	/**
	 * 멤버십가입일시
	 */
	private String mshipSbscDt;
	/**
	 * 멤버십등급코드
	 */
	private String mshipGradeCd;
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
	/**
	 * 블랙등록매장번호
	 */
	private String bllkRegStorNo;
	/**
	 * 블랙회원여부
	 */
	private String bllkmshpYn;
	/**
	 * 블랙등록채널코드
	 */
	private String bllkRegChlCd;
	/**
	 * 블랙등록사유내용
	 */
	private String bllkRegWhyCtnts;
	/**
	 * 블랙등록일시
	 */
	private String bllkRegDt;
	/**
	 * 보호가족여부
	 */
	private String prtctFamlyYn;
	/**
	 * 멤버십예정등급코드
	 */
	private String mshipExptGradeCd;
	/**
	 * 멤버십승급점수
	 */
	private Integer mshipAdvncmtScore;
	/**
	 * 휴면기간코드
	 */
	private String dormPerdCd;
	/**
	 * 등록채널코드 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS ,
	 * BOS : BOS , MEM : 멤버십 , CRA : 세라체크 , DNA : 세라DNA , IoT : IoT]
	 */
	private String regChlCd;

	/**
	 * 월간일간구분(조회조건)
	 */
	private String searchDiv;
	/**
	 * 시작월(조회조건)
	 */
	private String strtDtM;
	/**
	 * 종료월(조회조건)
	 */
	private String endDtM;
	/**
	 * 시작일(조회조건)
	 */
	private String strtDtD;
	/**
	 * 종료일(조회조건)
	 */
	private String endDtD;

	/**
	 * 신규회원(전체)
	 */
	private String totalNewCnt;
	/**
	 * 신규회원(남성)
	 */
	private String totalManNewCnt;
	/**
	 * 신규회원(여성)
	 */
	private String totalWomanNewCnt;
	/**
	 * 신규회원(성별정보없음)
	 */
	private String totalEtcNewCnt;
	/**
	 * 휴면회원(전체)
	 */
	private String totalDormCnt;
	/**
	 * 휴면회원(남성)
	 */
	private String totalManDormCnt;
	/**
	 * 휴면회원(여성)
	 */
	private String totalWomanDormCnt;
	/**
	 * 휴면회원(성별정보없음)
	 */
	private String totalEtcDormCnt;
	/**
	 * 탈퇴회원(전체)
	 */
	private String totalLveCnt;
	/**
	 * 탈퇴회원(남성)
	 */
	private String totalManLveCnt;
	/**
	 * 탈퇴회원(여성)
	 */
	private String totalWomanLveCnt;
	/**
	 * 탈퇴회원(성별정보없음)
	 */
	private String totalEtcLveCnt;

	/**
	 * 10대(미만포함)
	 */
	private String age10;
	/**
	 * 20대
	 */
	private String age20;
	/**
	 * 30대
	 */
	private String age30;
	/**
	 * 40대
	 */
	private String age40;
	/**
	 * 50대
	 */
	private String age50;
	/**
	 * 60대
	 */
	private String age60;
	/**
	 * 70대 이상
	 */
	private String age70;
	/**
	 * 연령정보 없음
	 */
	private String ageetc;

	/**
	 * 일자
	 */
	private String sbscDt;
	/**
	 * 성별정보없음
	 */
	private String totalEtcCnt;

	/**
	 * 활동회원 전체
	 */
	private String totalCnt;
	/**
	 * 활동회원 남성
	 */
	private String totalManCnt;
	/**
	 * 활동회원 여성
	 */
	private String totalWomanCnt;
	/**
	 * 활동회원 구분
	 */
	private String statType;
	/**
	 * 활동회원 구분명
	 */
	private String statTypeNm;
	/**
	 * 등급코드
	 */
	private String comnCd;
	/**
	 * 등급코드명
	 */
	private String comnCdNm;
	/**
	 * 등급별 활동 회원
	 */
	private String totalActCnt;

	/**
	 * 매장명
	 */
	private String storNm;
	/**
	 * 순위
	 */
	private String rank;
	/**
	 * 추천횟수
	 */
	private String count;
	/**
	 * 세라체크 일자
	 */
	private String startTime;

	/**
	 * 체험일자
	 */
	private String exprnDate;
	/**
	 * 매장코드
	 */
	private String storCd;
	/**
	 * 체험모델
	 */
	private String itemNm;
	/**
	 * 나이
	 */
	private String ageCdNm;
	/**
	 * 체험경험여부
	 */
	private String exprnCmptYn;
}
