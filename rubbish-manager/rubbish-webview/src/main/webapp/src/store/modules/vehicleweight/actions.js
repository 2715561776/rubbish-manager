import Vue from 'vue'

import * as URL from './mutation-types'

export function cleanCurrentVehicleWeight ({ commit }, params) {
    return commit("cleanCurrentVehicleWeightByState", params);
}

export function queryVehicleWeight ({ commit }, params) {
    return Vue.http.post(URL.VEHICLEWEIGHT_QUERY,params)
        .then((response) => commit("queryVehicleWeightSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findByVehicleWeightId ({ commit }, params) {
    return commit("findVehicleWeightByState", params);
    // return Vue.http.post(URL.VEHICLEWEIGHT_FINDBYID,params)
    //      .then((response) => commit("findByVehicleWeightIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdateVehicleWeight ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.VEHICLEWEIGHT_SAVEORUPDATE, params)
            .then((response) => commit("updateVehicleWeightSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.VEHICLEWEIGHT_SAVEORUPDATE, params)
            .then((response) => commit("saveVehicleWeightSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deleteVehicleWeight ({ commit }, params) {
    return Vue.http.post(URL.VEHICLEWEIGHT_DELETE, params)
        .then((response) => commit("deleteVehicleWeightSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeleteVehicleWeight ({ commit }, params) {
    return Vue.http.post(URL.VEHICLEWEIGHT_BATCHDELETE, params)
        .then((response) => commit("batchDeleteVehicleWeightSuccess", response.body))
        .catch(function (error) {console.log(error);});
}