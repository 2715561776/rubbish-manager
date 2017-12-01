import * as actions from './actions'
import * as getters from './getters'

// initial state
const initialState = {
  objs: [],
  current: {},
  total:0
}

// mutations
const mutations = {
    cleanCurrentSysMenuByState (state, body) {
        state.current = {};
    },
    querySysMenuSuccess (state, body) {
        const code = body.code;
        if(code == "200"){
            state.objs = body.data.records
            state.total = body.data.total;
        }else if(code == "500"){
            console.log("获取失败:"+body.msg);
        }
    },
    findSysMenuByState (state, data) {
        const record = state.objs.find(p => p.id === data.id);
        if (!record) {
            return null;
        } else {
            state.current = record;
            return record;
        }
    },
    findBySysMenuIdSuccess (state, body) {
        const code = body.code;
        if(code == "200"){
            const data = body.data;
            state.current = data;
            state.objs.push(data);
            console.log("获取成功！");
        }else if(code == "500"){
            console.log("获取失败:"+body.msg);
        }
    },
    saveSysMenuSuccess (state, body) {
        const code = body.code;
        if(code == "200"){
            const data = body.data;
            state.objs.push(data);
            state.current = {};
        }else if(code == "500"){
            console.log("新增失败:"+body.msg);
        }
    },
    updateSysMenuSuccess (state, body) {
        const code = body.code;
        if(code == "200"){
            const data = state.current;
            const index = state.objs.findIndex((p) => p.id === data.id);
            if (index !== -1) {
                state.objs.splice(index, 1, data)
            }
        }else if(code == "500"){
            console.log("更新失败:"+body.msg);
        }
    },
    deleteSysMenuSuccess(state, body) {
        const code = body.code;
        if(code == "200"){
            // const data = body.data;
            const data = state.current;
            state.objs = state.objs.filter(p => p.id !== data.id)
            state.total--;
        }else if(code == "500"){
            console.log("删除失败:"+body.msg);
        }
    },
    batchDeleteSysMenuSuccess(state, body) {
        const code = body.code;
        if(code == "200"){
            const data = body.data;
            for(var i = 0;i < data.length; i++) {
                state.objs = state.objs.filter(p => p.id !== data[i].id)
                state.total--;
            }
        }else if(code == "500"){
            console.log("删除失败:"+body.msg);
        }
    }
}

export default {
  state: { ...initialState },
  actions,
  getters,
  mutations
}
