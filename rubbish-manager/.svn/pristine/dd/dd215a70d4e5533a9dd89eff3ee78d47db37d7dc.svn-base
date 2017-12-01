import Vue from 'vue'

import * as URL from './mutation-types'

export function cleanCurrentSysLog ({ commit }, params) {
    return commit("cleanCurrentSysLogByState", params);
}

export function querySysLog ({ commit }, params) {
    return Vue.http.post(URL.SYSLOG_QUERY,params)
        .then((response) => commit("querySysLogSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findBySysLogId ({ commit }, params) {
    return commit("findSysLogByState", params);
    // return Vue.http.post(URL.SYSLOG_FINDBYID,params)
    //      .then((response) => commit("findBySysLogIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdateSysLog ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.SYSLOG_SAVEORUPDATE, params)
            .then((response) => commit("updateSysLogSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.SYSLOG_SAVEORUPDATE, params)
            .then((response) => commit("saveSysLogSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deleteSysLog ({ commit }, params) {
    return Vue.http.post(URL.SYSLOG_DELETE, params)
        .then((response) => commit("deleteSysLogSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeleteSysLog ({ commit }, params) {
    return Vue.http.post(URL.SYSLOG_BATCHDELETE, params)
        .then((response) => commit("batchDeleteSysLogSuccess", response.body))
        .catch(function (error) {console.log(error);});
}