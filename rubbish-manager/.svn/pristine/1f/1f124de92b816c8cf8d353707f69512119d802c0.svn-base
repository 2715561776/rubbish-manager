import Vue from 'vue'

import * as URL from './mutation-types'

export function cleanCurrentSysUserRole ({ commit }, params) {
    return commit("cleanCurrentSysUserRoleByState", params);
}

export function querySysUserRole ({ commit }, params) {
    return Vue.http.post(URL.SYSUSERROLE_QUERY,params)
        .then((response) => commit("querySysUserRoleSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findBySysUserRoleId ({ commit }, params) {
    return commit("findSysUserRoleByState", params);
    // return Vue.http.post(URL.SYSUSERROLE_FINDBYID,params)
    //      .then((response) => commit("findBySysUserRoleIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdateSysUserRole ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.SYSUSERROLE_SAVEORUPDATE, params)
            .then((response) => commit("updateSysUserRoleSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.SYSUSERROLE_SAVEORUPDATE, params)
            .then((response) => commit("saveSysUserRoleSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deleteSysUserRole ({ commit }, params) {
    return Vue.http.post(URL.SYSUSERROLE_DELETE, params)
        .then((response) => commit("deleteSysUserRoleSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeleteSysUserRole ({ commit }, params) {
    return Vue.http.post(URL.SYSUSERROLE_BATCHDELETE, params)
        .then((response) => commit("batchDeleteSysUserRoleSuccess", response.body))
        .catch(function (error) {console.log(error);});
}