import Vue from 'vue'
import VueAMap from 'vue-amap';
import VueResource from 'vue-resource'
import App from './App.vue'
import iview from 'iview'
import  router from './router/index'
import 'iview/dist/styles/iview.css'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'
// 运动和去除elelment的一些预设样式
import '../assets/css/animate.css';
import '../assets/css/index.scss';

import {locationStroageObj} from '../assets/js/util';





window.onload = function () {
    Vue.config.productionTip = false

    Vue.use(iview);
    Vue.use(ElementUI);
    Vue.use(VueAMap);
    Vue.use(VueResource);
    VueAMap.initAMapApiLoader({
        key: '6fbe55c2696465509cb458c444e7a74f',
        plugin: ['Geocoder','AMap.Autocomplete', 'AMap.PlaceSearch', 'AMap.Scale', 'AMap.OverView', 'AMap.ToolBar', 'AMap.MapType', 'AMap.PolyEditor', 'AMap.CircleEditor'],
        // 引入map ui报错bug暂未修复
        // uiVersion: '1.0.11',
    });
    // 使用router配置拦截
   router.beforeEach((to, from, next) => {
       let token =  locationStroageObj.get("userList");
       if (!token) { // 没有登录
           if (to.path !== '/login') {
               return next({ path: '/login' })
           } else {
               next()
           }
       }else {
           if (to.path === '/login') {
               return next({path: '/carPosition'})
           }
           if (to.path === '/') {
               return next({path: '/carPosition'})
           }
           next()
       }
    })
    new Vue({
        el: '#app',
        router,
        store,
        template: '<App/>',
        components: { App }
    })

}

