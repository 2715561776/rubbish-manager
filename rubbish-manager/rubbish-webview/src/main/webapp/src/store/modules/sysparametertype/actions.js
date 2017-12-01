import Vue from 'vue'

import * as URL from './mutation-types'

export function cleanCurrentSysParameterType ({ commit }, params) {
    return commit("cleanCurrentSysParameterTypeByState", params);
}

export function querySysParameterType ({ commit }, params) {
    return Vue.http.post(URL.SYSPARAMETERTYPE_QUERY,params)
        .then((response) => commit("querySysParameterTypeSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findBySysParameterTypeId ({ commit }, params) {
    return commit("findSysParameterTypeByState", params);
    // return Vue.http.post(URL.SYSPARAMETERTYPE_FINDBYID,params)
    //      .then((response) => commit("findBySysParameterTypeIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdateSysParameterType ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.SYSPARAMETERTYPE_SAVEORUPDATE, params)
            .then((response) => commit("updateSysParameterTypeSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.SYSPARAMETERTYPE_SAVEORUPDATE, params)
            .then((response) => commit("saveSysParameterTypeSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deleteSysParameterType ({ commit }, params) {
    return Vue.http.post(URL.SYSPARAMETERTYPE_DELETE, params)
        .then((response) => commit("deleteSysParameterTypeSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeleteSysParameterType ({ commit }, params) {
    return Vue.http.post(URL.SYSPARAMETERTYPE_BATCHDELETE, params)
        .then((response) => commit("batchDeleteSysParameterTypeSuccess", response.body))
        .catch(function (error) {console.log(error);});
}