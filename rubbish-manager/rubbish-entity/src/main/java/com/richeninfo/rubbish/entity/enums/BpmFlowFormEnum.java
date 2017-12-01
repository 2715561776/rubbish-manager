package com.richeninfo.rubbish.entity.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/9/27.
 */
public enum BpmFlowFormEnum {

    Auditing("WA", " 签核中"), // 签核中
    Approved("AP", "同意"), // 审核通过
    Reject("RJ", "拒绝");// 审核退回

    private String code;
    private String desc;

    BpmFlowFormEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static List<EnumVo> EnumToList(){

        List<EnumVo> enums = new ArrayList<EnumVo>();
        for (BpmFlowFormEnum s : BpmFlowFormEnum.values())  {
            EnumVo e = new EnumVo(s.getDesc(), s.getCode());
            enums.add(e);

        }
        return enums;

    }


    public static BpmFlowFormEnum codeToEnum(String code){
        for (BpmFlowFormEnum s : BpmFlowFormEnum.values())  {
            if(code == s.getCode()){
                return s;
            }
        }
        return null;

    }
}
