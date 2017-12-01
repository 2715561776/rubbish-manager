package com.richeninfo.rubbish.entity.enums;

import java.util.ArrayList;
import java.util.List;

public enum WbContentEnum {


    Init(0L, "初始化"), //初始化
    Launch(1L, " 发起中"), // 发起中
    Inaudit(2L, "审核中"), // 审核中
    Sendlater(3L, "待发送"),// 待发送
    Returned(4L, "已退回"),// 已退回
    Sendout(5L, "已退回"),// 已发送
    Archived(9L, "已归档");// 已归档


    private Long code;
    private String desc;

    WbContentEnum(Long code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
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
        for (FlowFormEnum s : FlowFormEnum.values())  {
            EnumVo e = new EnumVo(s.getDesc(), s.getCode());
            enums.add(e);

        }
        return enums;

    }


    public static FlowFormEnum codeToEnum(Long code){
        for (FlowFormEnum s : FlowFormEnum.values())  {
            if(code == s.getCode()){
                return s;
            }
        }
        return null;

    }
}
