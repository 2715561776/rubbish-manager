import Vue from 'vue'

import * as URL from './mutation-types'

export function cleanCurrentBiddingCompanyInfo ({ commit }, params) {
    return commit("cleanCurrentBiddingCompanyInfoByState", params);
}

export function queryBiddingCompanyInfo ({ commit }, params) {
    return Vue.http.post(URL.BIDDINGCOMPANYINFO_QUERY,params)
        .then((response) => commit("queryBiddingCompanyInfoSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findBiddingCompanyInfoByName ({ commit }, params) {
    return Vue.http.post(URL.FINDBIDDINGCOMPANYINFO,params)
        .then((response) => commit("findBiddingCompanyInfoList", response.body))
        .catch(function (error) {console.log(error);});
}

export function findBiddingCompanyInfoByID ({ commit }, params) {
    return commit("findBiddingCompanyInfoByState", params);
    // return Vue.http.post(URL.BIDDINGCOMPANYINFO_FINDBYID,params)
    //      .then((response) => commit("findByBiddingCompanyInfoIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdateBiddingCompanyInfo ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.BIDDINGCOMPANYINFO_SAVEORUPDATE, params)
            .then((response) => commit("updateBiddingCompanyInfoSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.BIDDINGCOMPANYINFO_SAVEORUPDATE, params)
            .then((response) => commit("saveBiddingCompanyInfoSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deleteBiddingCompanyInfo ({ commit }, params) {
    return Vue.http.post(URL.BIDDINGCOMPANYINFO_DELETE, params)
        .then((response) => commit("deleteBiddingCompanyInfoSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeleteBiddingCompanyInfo ({ commit }, params) {
    return Vue.http.post(URL.BIDDINGCOMPANYINFO_BATCHDELETE, params)
        .then((response) => commit("batchDeleteBiddingCompanyInfoSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function queryBiddingCompanyInfoWithVehicle ({ commit }, params) {
    return Vue.http.post(URL.BIDDINGCOMPANYINFO_QUERYBIDDINGCOMPANYINFOWITHVEHICLE, params)
        .then((response) => commit("queryBiddingCompanyInfoWithVehicleSuccess", response.body))
        .catch(function (error) {console.log(error);});
}
