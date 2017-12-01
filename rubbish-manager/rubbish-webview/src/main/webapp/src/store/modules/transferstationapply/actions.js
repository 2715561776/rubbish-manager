import Vue from 'vue'

import * as URL from './mutation-types'

export function findPlaceInfoByName ({ commit }, params) {
    return Vue.http.post(URL.PLACEINFO_QUERYPLACEINFOBYNAME,params)
        .then((response) => commit("getPlaceInfoByNameSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findVehicleByInputDriverName ({ commit }, params) {
    return Vue.http.post(URL.VEHICLE_QUERYBYDRIVERNAME,params)
        .then((response) => commit("getVehicleByInputDriverNameSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function cleanCurrentTransferStationApply ({ commit }, params) {
    return commit("cleanCurrentTransferStationApplyByState", params);
}

export function queryTransferStationApply ({ commit }, params) {
    return Vue.http.post(URL.TRANSFERSTATIONAPPLY_QUERY,params)
        .then((response) => commit("queryTransferStationApplySuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findByTransferStationApplyId ({ commit }, params) {
    return commit("findTransferStationApplyByState", params);
    // return Vue.http.post(URL.TRANSFERSTATIONAPPLY_FINDBYID,params)
    //      .then((response) => commit("findByTransferStationApplyIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdateTransferStationApply ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.TRANSFERSTATIONAPPLY_UPDATE, params)
            .then((response) => commit("updateTransferStationApplySuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.TRANSFERSTATIONAPPLY_SAVE, params)
            .then((response) => commit("saveTransferStationApplySuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deleteTransferStationApply ({ commit }, params) {
    return Vue.http.post(URL.TRANSFERSTATIONAPPLY_DELETE, params)
        .then((response) => commit("deleteTransferStationApplySuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeleteTransferStationApply ({ commit }, params) {
    return Vue.http.post(URL.TRANSFERSTATIONAPPLY_BATCHDELETE, params)
        .then((response) => commit("batchDeleteTransferStationApplySuccess", response.body))
        .catch(function (error) {console.log(error);});
}