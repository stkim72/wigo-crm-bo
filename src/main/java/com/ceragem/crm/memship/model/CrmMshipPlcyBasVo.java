package com.ceragem.crm.memship.model;

import com.ceragem.crm.common.model.BaseVo;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @ClassName    CrmMshipPlcyBasVo
 * @author    user
 * @date    2022. 5. 11.
 * @Version    1.0
 * @description    undefined Vo
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Getter
@Setter
public class CrmMshipPlcyBasVo extends BaseVo {
    /**
    *
    */
private static final long serialVersionUID = 1L;
    /**
    * 멤버십정책기본번호 
    */
    private String mshipPlcyBasNo;
    /**
    * 멤버십등급코드 
    */
    private String mshipGradeCd;
    private String mshipGradeCdNm;
    /**
    * 회원등급코드 
    */
    private String mshpGradeCd;
    private String mshpGradeCdNm;
    /**
    * 멤버십정책명 
    */
    private String mshipPlcyNm;
    /**
    * 멤버십정책내용 
    */
    private String mshipPlcyCtnts;
    /**
    * 제휴회사번호 
    */
    private String cprtCmpNo;
    private String cprtCmpNoNm; 
    /**
    * 적용기준시작년월일 
    */
    private String applyStdStaYmd;
    private String sapplyStdStaYmd; // 검색용
    /**
    * 적용기준종료년월일 
    */
    private String applyStdEndYmd;
    private String sapplyStdEndYmd; // 검색용
    /**
    * 산정기준월 
    */
    private String extrcStdMonth;
    /**
    * 승급시작점수 
    */
    private String advncmtStaScore;
    /**
    * 승급종료점수 
    */
    private String advncmtEndScore;
    /**
    * 산정보존월 
    */
    private String extrcKeepMonth;
    /**
    * 산정기준2월 
    */
    private String extrcStd2Month;
    /**
    * 등급보존점수 
    */
    private String gradeKeepScore;
    /**
    * 등급보존2점수 
    */
    private String gradeKeep2Score;
    /**
    * 등급보존월 
    */
    private String gradeKeepMonth;
    
    /**
    * 구매보상승급율 
    */
    private double buyRewardAdvncmtRate;
    /**
    * 구매추천보상승급율 
    */
    private double buyRcmdRewardAdvncmtRate;
    /**
    * 구매적립포인트율 
    */
    private double buyAccumPointRate;
    /**
    * 가입포인트점수 
    */
    private Integer sbscPointScore;
    /**
    * 적립한도포인트점수 
    */
    private Integer accumLmtPointScore;
    /**
    * 구매추천포인트율 
    */
    private double buyRcmdPointRate;
    /**
    * 구매승급포인트점수 
    */
    private String buyAdvncmtPointScore;
    /**
    * 사용한도포인트점수 
    */
    private Integer useLmtPointScore;
    /**
    * 포인트소멸알림여부 
    */
    private String pointExtncAlertYn;
    /**
    * 포인트소멸알림기간 
    */
    private String pointExtncAlertPerd;
    /**
    * 선물포인트유효기간 
    */
    private Integer giftPointValidPerd;
    /**
    * 자사몰무료배송여부 
    */
    private String mycomMallFreeDlvYn;
    /**
    * 무료서비스연장개월수 
    */
    private Integer freeSvcExtnsnMonsCnt;
    /**
    * 세라케어쿠폰제공개월수 
    */
    private Integer ceracCoupnPrvMonsCnt;
    /**
    * 상태코드 
    */
    private String statusCd;
    private String statusCdNm;
    /**
    * 등록채널코드 
    * 공통코드 : S000 [CRM : CRM , CTC : 상담 , AS : AS , SAP : SAP , POS : POS]
    */
    private String regChlCd;
    private String regChlCdNm;
    
    /**
     * 가입포인트적용기준코드 
     */
     private String sbscPointApplyStdCd;
     
     
     /**
      * 승급포인트적용기준코드 
      */
      private String advncmtPointApplyStdCd;
      
      
     
}
