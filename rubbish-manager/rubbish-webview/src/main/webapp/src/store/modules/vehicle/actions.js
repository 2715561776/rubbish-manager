import Vue from 'vue'

import * as URL from './mutation-types'

export function cleanCurrentVehicle ({ commit }, params) {
    return commit("cleanCurrentVehicleByState", params);
}

export function queryVehicle ({ commit }, params) {
    return Vue.http.post(URL.VEHICLE_QUERY,params)
        .then((response) => commit("queryVehicleSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findByVehicleId ({ commit }, params) {
    return commit("findVehicleByState", params);
    // return Vue.http.post(URL.VEHICLE_FINDBYID,params)
    //      .then((response) => commit("findByVehicleIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdateVehicle ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.VEHICLE_SAVEORUPDATE, params)
            .then((response) => commit("updateVehicleSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.VEHICLE_SAVEORUPDATE, params)
            .then((response) => commit("saveVehicleSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deleteVehicle ({ commit }, params) {
    return Vue.http.post(URL.VEHICLE_DELETE, params)
        .then((response) => commit("deleteVehicleSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeleteVehicle ({ commit }, params) {
    return Vue.http.post(URL.VEHICLE_BATCHDELETE, params)
        .then((response) => commit("batchDeleteVehicleSuccess", response.body))
        .catch(function (error) {console.log(error);});
}