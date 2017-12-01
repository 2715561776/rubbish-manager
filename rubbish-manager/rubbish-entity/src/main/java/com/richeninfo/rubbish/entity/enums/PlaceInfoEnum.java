package com.richeninfo.rubbish.entity.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/9/27.
 */
public enum PlaceInfoEnum {

    ResidentialArea(1, "居民小区,工地"), //免费
    BusinessArea(2, "商务区"), // 收费
    TransferStation(3, "中转站"),// 已经发布
    Burning(4, "焚烧场,消纳场");


    private int code;
    private String desc;

    PlaceInfoEnum(int code, String desc) {
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
