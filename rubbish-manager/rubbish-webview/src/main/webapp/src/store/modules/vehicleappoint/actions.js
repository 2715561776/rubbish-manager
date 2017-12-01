import Vue from 'vue'

import * as URL from './mutation-types'

export function cleanCurrentVehicleAppoint ({ commit }, params) {
    return commit("cleanCurrentVehicleAppointByState", params);
}

export function queryVehicleAppoint ({ commit }, params) {
    return Vue.http.post(URL.VEHICLEAPPOINT_QUERY,params)
        .then((response) => commit("queryVehicleAppointSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findByVehicleAppointId ({ commit }, params) {
    return commit("findVehicleAppointByState", params);
    // return Vue.http.post(URL.VEHICLEAPPOINT_FINDBYID,params)
    //      .then((response) => commit("findByVehicleAppointIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdateVehicleAppoint ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.VEHICLEAPPOINT_SAVEORUPDATE, params)
            .then((response) => commit("updateVehicleAppointSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.VEHICLEAPPOINT_SAVEORUPDATE, params)
            .then((response) => commit("saveVehicleAppointSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deleteVehicleAppoint ({ commit }, params) {
    return Vue.http.post(URL.VEHICLEAPPOINT_DELETE, params)
        .then((response) => commit("deleteVehicleAppointSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeleteVehicleAppoint ({ commit }, params) {
    return Vue.http.post(URL.VEHICLEAPPOINT_BATCHDELETE, params)
        .then((response) => commit("batchDeleteVehicleAppointSuccess", response.body))
        .catch(function (error) {console.log(error);});
}