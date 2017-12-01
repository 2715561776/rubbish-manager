import Vue from 'vue'

import * as URL from './mutation-types'
// 登录
export function findUserByLoginNameAndPassWord ({ commit }, params) {
    return Vue.http.post(URL.USER_FINDUSERBYLOGINNAMEANDPASSWORD,params)

        .then((response) => commit("findUserByLoginNameAndPassWordSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function cleanCurrentUser ({ commit }, params) {
    return commit("cleanCurrentUserByState", params);
}

export function queryUser ({ commit }, params) {
    return Vue.http.post(URL.USER_QUERY,params)

        .then((response) => commit("queryUserSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function findByUserId ({ commit }, params) {
    return commit("findUserByState", params);
    // return Vue.http.post(URL.USER_FINDBYID,params)
    //      .then((response) => commit("findByUserIdSuccess", response.body))
    //      .catch(function (error) {console.log(error);});
}

export function saveOrUpdateUser ({ commit }, params) {
    if(params.id !== null && params.id !== undefined){
        return Vue.http.post(URL.USER_SAVEORUPDATE, params)
            .then((response) => commit("updateUserSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }else{
        return Vue.http.post(URL.USER_SAVEORUPDATE, params)
            .then((response) => commit("saveUserSuccess", response.body))
            .catch(function (error) {console.log(error);});
    }
}

export function deleteUser ({ commit }, params) {
    return Vue.http.post(URL.USER_DELETE, params)
        .then((response) => commit("deleteUserSuccess", response.body))
        .catch(function (error) {console.log(error);});
}

export function batchDeleteUser ({ commit }, params) {
    return Vue.http.post(URL.USER_BATCHDELETE, params)
        .then((response) => commit("batchDeleteUserSuccess", response.body))
        .catch(function (error) {console.log(error);});
}