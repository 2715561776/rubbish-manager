package com.richeninfo.rubbish.entity.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/9/27.
 */
public enum FlowFormEnum {

    Init(0L, "起草中"), //起草中
    Auditing(1L, " 签核中"), // 签核中
    Approved(2L, "审核通过"), // 审核通过
    Reject(3L, "审核退回"),// 审核退回
    ReSync(4L, "已重新同步"),// 已重新同步
    AlreadyPublish(5L, "已经发布");// 已经发布

    private Long code;
    private String desc;

    FlowFormEnum(Long code, String desc) {
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
