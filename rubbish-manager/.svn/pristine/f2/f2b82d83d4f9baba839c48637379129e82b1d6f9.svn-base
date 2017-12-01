import Vue from 'vue'

import * as URL from './mutation-types'

export function cleanCurrentVehicleDetail ({ commit }, params) {
    return commit("cleanCurrentVehicleDetailByState", params);
}

export function queryVehicleDetail ({ commit }, params) {
    return Vue.http.post(URL.VEHICLEDETAIL_QUERY,params)
        .then((response) => commit("queryVehicleDetailSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findByVehicleDetailId ({ commit }, params) {
    return commit("findVehicleDetailByState", params);
    // return Vue.http.post(URL.VEHICLEDETAIL_FINDBYID,params)
    //      .then((response) => commit("findByVehicleDetailIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdateVehicleDetail ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.VEHICLEDETAIL_SAVEORUPDATE, params)
            .then((response) => commit("updateVehicleDetailSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.VEHICLEDETAIL_SAVEORUPDATE, params)
            .then((response) => commit("saveVehicleDetailSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deleteVehicleDetail ({ commit }, params) {
    return Vue.http.post(URL.VEHICLEDETAIL_DELETE, params)
        .then((response) => commit("deleteVehicleDetailSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeleteVehicleDetail ({ commit }, params) {
    return Vue.http.post(URL.VEHICLEDETAIL_BATCHDELETE, params)
        .then((response) => commit("batchDeleteVehicleDetailSuccess", response.body))
        .catch(function (error) {console.log(error);});
}