import Vue from 'vue'

import * as URL from './mutation-types'

export function cleanCurrentPlaceInfo ({ commit }, params) {
    return commit("cleanCurrentPlaceInfoByState", params);
}

export function queryPlaceInfo ({ commit }, params) {
    return Vue.http.post(URL.PLACEINFO_QUERY,params)
        .then((response) => commit("queryPlaceInfoSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findByPlaceInfoId ({ commit }, params) {
    return commit("findPlaceInfoByState", params);
    // return Vue.http.post(URL.PLACEINFO_FINDBYID,params)
    //      .then((response) => commit("findByPlaceInfoIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdatePlaceInfo ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.PLACEINFO_SAVEORUPDATE, params)
            .then((response) => commit("updatePlaceInfoSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.PLACEINFO_SAVEORUPDATE, params)
            .then((response) => commit("savePlaceInfoSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deletePlaceInfo ({ commit }, params) {
    return Vue.http.post(URL.PLACEINFO_DELETE, params)
        .then((response) => commit("deletePlaceInfoSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeletePlaceInfo ({ commit }, params) {
    return Vue.http.post(URL.PLACEINFO_BATCHDELETE, params)
        .then((response) => commit("batchDeletePlaceInfoSuccess", response.body))
        .catch(function (error) {console.log(error);});
}