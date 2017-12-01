// 截取字符串
export function cutstr(str, len) {
    var temp,
        icount = 0,
        patrn = /[^\x00-\xff]/,
        strre = "";
    for (var i = 0; i < str.length; i++) {
        if (icount < len - 1) {
            temp = str.substr(i, 1);
            if (patrn.exec(temp) == null) {
                icount = icount + 1
            } else {
                icount = icount + 2
            }
            strre += temp
        } else {
            break;
        }
    }
    return strre + "..."
}
// 格式化时间
export function parseTime(time, cFormat) {
    if (arguments.length === 0) {
        return null
    }
    if(time == " " && time == " " && time == null){
        return null;
    }
    if ((time + '').length === 10) {
        time = +time * 1000
    }

    const format = cFormat || '{y}-{m}-{d} {h}:{i}:{s}'
    let date
    if (typeof time === 'object') {
        date = time
    } else {
        date = new Date(parseInt(time))
    }
    const formatObj = {
        y: date.getFullYear(),
        m: date.getMonth() + 1,
        d: date.getDate(),
        h: date.getHours(),
        i: date.getMinutes(),
        s: date.getSeconds(),
        a: date.getDay()
    }
    const time_str = format.replace(/{(y|m|d|h|i|s|a)+}/g, (result, key) => {
        let value = formatObj[key]
        if (key === 'a') return ['一', '二', '三', '四', '五', '六', '日'][value - 1]
        if (result.length > 0 && value < 10) {
            value = '0' + value
        }
        return value || 0
    })
    return time_str
}
// 求取两点之间的夹角
export function angle(start,end){
    let diff_x = end.x - start.x,
        diff_y = end.y - start.y;
    //返回角度,不是弧度
    return 360*Math.atan(diff_y/diff_x)/(2*Math.PI);
}
// 增删改查
export const locationStroageObj = {
    get:function(item){
        return JSON.parse(window.sessionStorage.getItem(item));
    },
    updateOrSave:function(item,value){
        if(typeof value === "string"){
            window.sessionStorage.setItem(item,value);
        }else{
            window.sessionStorage.setItem(item,JSON.stringify(value));
        }
    },
    delete:function(item){
        window.sessionStorage.removeItem(item);
    }
}