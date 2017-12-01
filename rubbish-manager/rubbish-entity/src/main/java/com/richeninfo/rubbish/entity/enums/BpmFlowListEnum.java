package com.richeninfo.rubbish.entity.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/9/27.
 */
public enum BpmFlowListEnum {

    WaitSign("W", " 待签核"), // 待签核
    CurrentSign("U", "当前人签核"), // 当前人签核
    SignEd("A", "已签核");// 已签核

    private String code;
    private String desc;

    BpmFlowListEnum(String code, String desc) {
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
        for (BpmFlowListEnum s : BpmFlowListEnum.values())  {
            EnumVo e = new EnumVo(s.getDesc(), s.getCode());
            enums.add(e);

        }
        return enums;

    }


    public static BpmFlowListEnum codeToEnum(String code){
        for (BpmFlowListEnum s : BpmFlowListEnum.values())  {
            if(code == s.getCode()){
                return s;
            }
        }
        return null;

    }
}
