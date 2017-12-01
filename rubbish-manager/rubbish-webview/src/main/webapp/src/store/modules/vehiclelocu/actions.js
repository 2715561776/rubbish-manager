import Vue from 'vue'

import * as URL from './mutation-types'

export function cleanCurrentVehicleLocu ({ commit }, params) {
    return commit("cleanCurrentVehicleLocuByState", params);
}

export function queryVehicleLocu ({ commit }, params) {
    return Vue.http.post(URL.VEHICLELOCU_QUERY,params)
        .then((response) => commit("queryVehicleLocuSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findByVehicleLocuId ({ commit }, params) {
    return commit("findVehicleLocuByState", params);
    // return Vue.http.post(URL.VEHICLELOCU_FINDBYID,params)
    //      .then((response) => commit("findByVehicleLocuIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdateVehicleLocu ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.VEHICLELOCU_SAVEORUPDATE, params)
            .then((response) => commit("updateVehicleLocuSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.VEHICLELOCU_SAVEORUPDATE, params)
            .then((response) => commit("saveVehicleLocuSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deleteVehicleLocu ({ commit }, params) {
    return Vue.http.post(URL.VEHICLELOCU_DELETE, params)
        .then((response) => commit("deleteVehicleLocuSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeleteVehicleLocu ({ commit }, params) {
    return Vue.http.post(URL.VEHICLELOCU_BATCHDELETE, params)
        .then((response) => commit("batchDeleteVehicleLocuSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function queryLastVehicleLocu({ commit }, params) {
    return Vue.http.post(URL.VEHICLELOCU_QUERYLASTVEHICLELOCU,params)
        .then((response) => commit("queryLastVehicleLocuSuccess", response.body))
        .catch(function (error) {console.log(error);});
}