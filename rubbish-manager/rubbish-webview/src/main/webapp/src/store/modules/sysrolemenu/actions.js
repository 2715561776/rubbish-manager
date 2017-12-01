import Vue from 'vue'

import * as URL from './mutation-types'

export function cleanCurrentSysRoleMenu ({ commit }, params) {
    return commit("cleanCurrentSysRoleMenuByState", params);
}

export function querySysRoleMenu ({ commit }, params) {
    return Vue.http.post(URL.SYSROLEMENU_QUERY,params)
        .then((response) => commit("querySysRoleMenuSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findBySysRoleMenuId ({ commit }, params) {
    return commit("findSysRoleMenuByState", params);
    // return Vue.http.post(URL.SYSROLEMENU_FINDBYID,params)
    //      .then((response) => commit("findBySysRoleMenuIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdateSysRoleMenu ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.SYSROLEMENU_SAVEORUPDATE, params)
            .then((response) => commit("updateSysRoleMenuSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.SYSROLEMENU_SAVEORUPDATE, params)
            .then((response) => commit("saveSysRoleMenuSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deleteSysRoleMenu ({ commit }, params) {
    return Vue.http.post(URL.SYSROLEMENU_DELETE, params)
        .then((response) => commit("deleteSysRoleMenuSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeleteSysRoleMenu ({ commit }, params) {
    return Vue.http.post(URL.SYSROLEMENU_BATCHDELETE, params)
        .then((response) => commit("batchDeleteSysRoleMenuSuccess", response.body))
        .catch(function (error) {console.log(error);});
}