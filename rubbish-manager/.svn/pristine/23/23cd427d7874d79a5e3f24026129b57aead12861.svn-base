import Vue from 'vue'

import * as URL from './mutation-types'

export function cleanCurrentSysTasklog ({ commit }, params) {
    return commit("cleanCurrentSysTasklogByState", params);
}

export function querySysTasklog ({ commit }, params) {
    return Vue.http.post(URL.SYSTASKLOG_QUERY,params)
        .then((response) => commit("querySysTasklogSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findBySysTasklogId ({ commit }, params) {
    return commit("findSysTasklogByState", params);
    // return Vue.http.post(URL.SYSTASKLOG_FINDBYID,params)
    //      .then((response) => commit("findBySysTasklogIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdateSysTasklog ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.SYSTASKLOG_SAVEORUPDATE, params)
            .then((response) => commit("updateSysTasklogSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.SYSTASKLOG_SAVEORUPDATE, params)
            .then((response) => commit("saveSysTasklogSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deleteSysTasklog ({ commit }, params) {
    return Vue.http.post(URL.SYSTASKLOG_DELETE, params)
        .then((response) => commit("deleteSysTasklogSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeleteSysTasklog ({ commit }, params) {
    return Vue.http.post(URL.SYSTASKLOG_BATCHDELETE, params)
        .then((response) => commit("batchDeleteSysTasklogSuccess", response.body))
        .catch(function (error) {console.log(error);});
}