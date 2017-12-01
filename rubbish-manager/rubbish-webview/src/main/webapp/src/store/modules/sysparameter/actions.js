import Vue from 'vue'

import * as URL from './mutation-types'

export function cleanCurrentSysParameter ({ commit }, params) {
    return commit("cleanCurrentSysParameterByState", params);
}

export function querySysParameter ({ commit }, params) {
    return Vue.http.post(URL.SYSPARAMETER_QUERY,params)
        .then((response) => commit("querySysParameterSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findBySysParameterId ({ commit }, params) {
    return commit("findSysParameterByState", params);
    // return Vue.http.post(URL.SYSPARAMETER_FINDBYID,params)
    //      .then((response) => commit("findBySysParameterIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdateSysParameter ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.SYSPARAMETER_SAVEORUPDATE, params)
            .then((response) => commit("updateSysParameterSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.SYSPARAMETER_SAVEORUPDATE, params)
            .then((response) => commit("saveSysParameterSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deleteSysParameter ({ commit }, params) {
    return Vue.http.post(URL.SYSPARAMETER_DELETE, params)
        .then((response) => commit("deleteSysParameterSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeleteSysParameter ({ commit }, params) {
    return Vue.http.post(URL.SYSPARAMETER_BATCHDELETE, params)
        .then((response) => commit("batchDeleteSysParameterSuccess", response.body))
        .catch(function (error) {console.log(error);});
}