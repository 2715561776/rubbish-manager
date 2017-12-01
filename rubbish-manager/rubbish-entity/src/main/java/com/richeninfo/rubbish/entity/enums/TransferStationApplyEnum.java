package com.richeninfo.rubbish.entity.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/9/27.
 */
public enum TransferStationApplyEnum {

    Before(0, "行程单未开始"), //行程单开始
    Working(1,"行程单进行中"),
    End(2, "行程单结束"); // 行程单结束

    private int code;
    private String desc;

    TransferStationApplyEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
