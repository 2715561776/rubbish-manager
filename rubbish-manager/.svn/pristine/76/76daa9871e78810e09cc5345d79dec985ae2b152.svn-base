import Vue from 'vue'

import * as URL from './mutation-types'

export function cleanCurrentSysTask ({ commit }, params) {
    return commit("cleanCurrentSysTaskByState", params);
}

export function querySysTask ({ commit }, params) {
    return Vue.http.post(URL.SYSTASK_QUERY,params)
        .then((response) => commit("querySysTaskSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findBySysTaskId ({ commit }, params) {
    return commit("findSysTaskByState", params);
    // return Vue.http.post(URL.SYSTASK_FINDBYID,params)
    //      .then((response) => commit("findBySysTaskIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdateSysTask ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.SYSTASK_SAVEORUPDATE, params)
            .then((response) => commit("updateSysTaskSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.SYSTASK_SAVEORUPDATE, params)
            .then((response) => commit("saveSysTaskSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deleteSysTask ({ commit }, params) {
    return Vue.http.post(URL.SYSTASK_DELETE, params)
        .then((response) => commit("deleteSysTaskSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeleteSysTask ({ commit }, params) {
    return Vue.http.post(URL.SYSTASK_BATCHDELETE, params)
        .then((response) => commit("batchDeleteSysTaskSuccess", response.body))
        .catch(function (error) {console.log(error);});
}