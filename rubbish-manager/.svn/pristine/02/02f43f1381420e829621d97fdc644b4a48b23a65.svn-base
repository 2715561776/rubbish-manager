import Vue from 'vue'

import * as URL from './mutation-types'

export function cleanCurrentSysRole ({ commit }, params) {
    return commit("cleanCurrentSysRoleByState", params);
}

export function querySysRole ({ commit }, params) {
    return Vue.http.post(URL.SYSROLE_QUERY,params)
        .then((response) => commit("querySysRoleSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findBySysRoleId ({ commit }, params) {
    return commit("findSysRoleByState", params);
    // return Vue.http.post(URL.SYSROLE_FINDBYID,params)
    //      .then((response) => commit("findBySysRoleIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdateSysRole ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.SYSROLE_SAVEORUPDATE, params)
            .then((response) => commit("updateSysRoleSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.SYSROLE_SAVEORUPDATE, params)
            .then((response) => commit("saveSysRoleSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deleteSysRole ({ commit }, params) {
    return Vue.http.post(URL.SYSROLE_DELETE, params)
        .then((response) => commit("deleteSysRoleSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeleteSysRole ({ commit }, params) {
    return Vue.http.post(URL.SYSROLE_BATCHDELETE, params)
        .then((response) => commit("batchDeleteSysRoleSuccess", response.body))
        .catch(function (error) {console.log(error);});
}