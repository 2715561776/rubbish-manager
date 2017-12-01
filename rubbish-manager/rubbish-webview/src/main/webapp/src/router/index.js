import Vue from 'vue'
import Router from 'vue-router'
import * as filters from "../../assets/js/util" // 导入工具函数


import Table from '@/components/Table'


import CarPosition from '@/views/positionWatch/carPosition'

import VerhicleSide from '@/views/verhicle/verhicleSide'
import Verhicle from '@/views/verhicle/verhicle'
import BiddingCompany from '@/views/verhicle/biddingCompany'

import BaseInfoManageSide from '@/views/baseInfo/baseInfoManageSide'
import User from '@/views/baseInfo/User'
import placeInfo from '@/views/baseInfo/placeInfo'

// 其他的页面
import transferStationApply from '@/views/transferStation/transferStationApply'
import arriveInTransfer from '@/views/transferStation/arriveInTransfer'


import vehicleAppointSide from '@/views/vehicleAppoint/vehicleAppointSide'
import vehicleAppoint from '@/views/vehicleAppoint/vehicleAppoint'
// import Test from '@/views/vehicleAppoint/test'
// import details from '@/views/vehicleAppoint/details'
//
// import demo5 from '@/views/vehicleAppoint/demo5'
// import demo6 from '@/views/vehicleAppoint/demo6'

import transferStationSide from '@/views/transferStationSide/transferStationSide'
import applyIn from '@/views/transferStationSide/applyIn'
import applyOut from '@/views/transferStationSide/applyOut'




// 404 页面
import error from '@/views/errorPage/404'
// login
import login from '@/views/login/index'
// header
import headerPage from '../components/header.vue'



Vue.use(Router)
//global utility filters.
Object.keys(filters).forEach(key => {
    Vue.filter(key, filters[key])
})
export default new Router({
    mode: 'history',
    scrollBehavior: () => ({ y: 0 }), // 滚动条滚动的行为，不加这个默认就会记忆原来滚动条的位置
    routes:[
        {
            path: '*',
            component: error
        },
        {
            path: '/headerPage',
            component: headerPage,
            children:[
                {
                    path: '/table2',
                    // component: Table
                    component: arriveInTransfer
                },
                {
                    path: '/table',
                    // component: Table
                    component: transferStationApply
                },
                {
                    path: '/vehicleAppoint',
                    component: vehicleAppoint
                },
                {
                    path: '/carPosition',
                    component: CarPosition
                },
                {
                    path: '/verhicleSide',
                    component: VerhicleSide,
                    children:[
                        {
                            path: '/verhicleSide/verhicle',
                            component: Verhicle,
                        },
                        {
                            path: '/verhicleSide/biddingCompany',
                            component: BiddingCompany,
                        },
                        {
                            path: "",
                            component: Verhicle
                        }
                    ]
                },
                {
                    path: '/transferStationSide',
                    component: transferStationSide,
                    children:[
                        {
                            path: '/verhicleSide/applyIn',
                            component: applyIn,
                        },
                        {
                            path: '/verhicleSide/applyOut',
                            component: applyOut,
                        },
                        {
                            path: "",
                            component: Verhicle
                        }
                    ]
                },
                {
                    path: '/baseInfoManageSide',
                    component: BaseInfoManageSide,
                    children:[
                        {
                            path: '/baseInfo/User',
                            component: User,
                        },
                        {
                            path: '/baseInfo/placeInfo',
                            component: placeInfo,
                        },
                        {
                            path: '',
                            component: User,
                        },
                    ]
                },
                {
                    path: '/vehicleAppointSide',
                    component: vehicleAppointSide,
                    children:[
                        {
                            path: '/vehicleAppoint/vehicleAppoint',
                            component: vehicleAppoint,
                        },
                        // {
                        //     path: '/vehicleAppoint/Test',
                        //     component: Test,
                        //     children:[
                        //         {
                        //             path: '/vehicleAppoint/Test/:personName',
                        //             component: details,
                        //         },
                        //     ]
                        // },
                        // {
                        //     path: '/vehicleAppoint/demo5',
                        //     component: demo5,
                        //
                        // },
                        // {
                        //     path: '/vehicleAppoint/demo6/:personName',
                        //     component: demo6,
                        // },
                        {
                            path: '',
                            component: vehicleAppoint,
                        }
                    ]
                },
                {
                    path: '/user',
                    component: User
                },
            ]
        },
        {
            path: '/login',
            component: login
        },
        {
            path: '/',
            component: login
        },
    ]
})


