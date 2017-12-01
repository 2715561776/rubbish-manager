package com.richeninfo.rubbish.entity.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/9/27.
 */
public enum WxMessageEnum {

    Init(0L, "初始化"), //初始化
    Originate(1L, " 发起中"), // 发起中
    Auditing(2L, "审核中"), // 审核中
    Approved(3L, "审核通过"), // 审核通过
    Reject(4L, "审核退回"), // 审核退回
    WaitSend(5L, "待发送"),// 待发送
    SendEd(6L, "已发送"),// 已发送
    ReSync(7L, "已重新同步");// 已发送

    private Long code;
    private String desc;

    WxMessageEnum(Long code, String desc) {
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
        for (WxMessageEnum s : WxMessageEnum.values())  {
            EnumVo e = new EnumVo(s.getDesc(), s.getCode());
            enums.add(e);

        }
        return enums;

    }


    public static WxMessageEnum codeToEnum(Long code){
        for (WxMessageEnum s : WxMessageEnum.values())  {
            if(code == s.getCode()){
                return s;
            }
        }
        return null;

    }

}
