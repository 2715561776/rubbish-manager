import Vue from 'vue'

import * as URL from './mutation-types'

export function cleanCurrentSysMenu ({ commit }, params) {
    return commit("cleanCurrentSysMenuByState", params);
}

export function querySysMenu ({ commit }, params) {
    return Vue.http.post(URL.SYSMENU_QUERY,params)
        .then((response) => commit("querySysMenuSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findBySysMenuId ({ commit }, params) {
    return commit("findSysMenuByState", params);
    // return Vue.http.post(URL.SYSMENU_FINDBYID,params)
    //      .then((response) => commit("findBySysMenuIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdateSysMenu ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.SYSMENU_SAVEORUPDATE, params)
            .then((response) => commit("updateSysMenuSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.SYSMENU_SAVEORUPDATE, params)
            .then((response) => commit("saveSysMenuSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deleteSysMenu ({ commit }, params) {
    return Vue.http.post(URL.SYSMENU_DELETE, params)
        .then((response) => commit("deleteSysMenuSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeleteSysMenu ({ commit }, params) {
    return Vue.http.post(URL.SYSMENU_BATCHDELETE, params)
        .then((response) => commit("batchDeleteSysMenuSuccess", response.body))
        .catch(function (error) {console.log(error);});
}