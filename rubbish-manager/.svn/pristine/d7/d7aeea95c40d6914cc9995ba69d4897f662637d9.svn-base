import Vue from 'vue'

import * as URL from './mutation-types'

export function queryApplyId ({ commit }, params) {
    return Vue.http.post(URL.APPLY_QUERYBYID,params)
        .then((response) => commit("queryApplyIdSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function cleanCurrentApply ({ commit }, params) {
    return commit("cleanCurrentApplyByState", params);
}

export function queryApply ({ commit }, params) {
    return Vue.http.post(URL.APPLY_QUERY,params)
        .then((response) => commit("queryApplySuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function queryApplyOut ({ commit }, params) {
    return Vue.http.post(URL.APPLY_QUERYOUT,params)
        .then((response) => commit("queryApplySuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findByApplyId ({ commit }, params) {
    return commit("findApplyByState", params);
    // return Vue.http.post(URL.APPLY_FINDBYID,params)
    //      .then((response) => commit("findByApplyIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdateApply ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.APPLY_SAVEORUPDATE, params)
            .then((response) => commit("updateApplySuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.APPLY_SAVEORUPDATE, params)
            .then((response) => commit("saveApplySuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deleteApply ({ commit }, params) {
    return Vue.http.post(URL.APPLY_DELETE, params)
        .then((response) => commit("deleteApplySuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeleteApply ({ commit }, params) {
    return Vue.http.post(URL.APPLY_BATCHDELETE, params)
        .then((response) => commit("batchDeleteApplySuccess", response.body))
        .catch(function (error) {console.log(error);});
}