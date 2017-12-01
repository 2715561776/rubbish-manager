<template>
    <div>
        <div class = "header">
            <div class = "title">方松街道建筑垃圾青云管理系统平台</div>
            <el-menu class="el-menu-demo" id = "admin" mode="horizontal">
                <el-submenu index="2">
                    <template slot="title">{{user}}</template>
                    <el-menu-item index="1" @click = "loginOut">退出登录</el-menu-item>
                </el-submenu>
            </el-menu>
            <div class = "menu-item">
                <el-menu :default-active="route" class="el-menu-demo" mode="horizontal" >
                    <el-menu-item v-for="(value, key, index) in sysMenuList" :index="String(value.sort)"><router-link  :to = "value.menuHref">{{value.menuName}}</router-link></el-menu-item>
                    <!--<el-menu-item index="1"><router-link to = "/carPosition">位置监控</router-link></el-menu-item>-->
                    <!--&lt;!&ndash;<el-menu-item index="2"><router-link to = "./infoAnalyse">报表分析</router-link></el-menu-item>&ndash;&gt;-->
                    <!--&lt;!&ndash;<el-menu-item index="2"><router-link to = "/table">出站</router-link></el-menu-item>&ndash;&gt;-->
                    <!--&lt;!&ndash;<el-menu-item index="6"><router-link to = "/table2">进站</router-link></el-menu-item>&ndash;&gt;-->


                    <!--<el-menu-item index="3"><router-link to = "/verhicleSide">车辆信息维护</router-link></el-menu-item>-->
                    <!--<el-menu-item index="4"><router-link to = "/baseInfoManageSide">基础信息维护</router-link></el-menu-item>-->
                    <!--<el-menu-item index="5"><router-link to = "/transferStationSide">中转站</router-link></el-menu-item>-->
                    <!--<el-menu-item index="5"><router-link to = "/vehicleAppointSide">预约信息</router-link></el-menu-item>-->


                </el-menu>
            </div>
        </div>
        <transition enter-active-class="animated fadeIn" leave-active-class="animated fadeOut">
            <router-view></router-view>
        </transition>
    </div>

</template>

<script>
    import {mapGetters, mapActions} from 'vuex'
    import {locationStroageObj} from '../../assets/js/util';

    export default {
        data() {
            return{
                route:"",
                user:"",
                sysMenuList:[],
            }
        },
        mounted(){
            var route = this.$route.path;
            if(route === "/carPosition"){
                this.route = "1";
            }else if(route === "/table"){
                this.route = "2";
            }else if(route === "/carInfo"){
                this.route = "3";
            }else if(route === "/baseInfoManage"){
                this.route = "4";
            }else if(route === "/verhicleAppoint"){
                this.route = "5";
            }else{
                this.route = "1";
            }

            let userList = locationStroageObj.get('userList');
            this.user = userList.loginName;
            let sysMenuListTemp = userList.sysMenuList;
            this.sysMenuList = sysMenuListTemp;
        },
        methods:{
            loginOut(){
                locationStroageObj.delete("userList");
                this.$router.push({ path: '/login' });
            }
        },
        computed:{
            ...mapGetters({
                userList:'user',
                tableData: "getUsers",
                total : "getUserTotal",
                current: "getCurrentUser"
            })
        },
    }
</script>

<style lang="scss" scoped rel="stylesheet/scss">
    .header{
        height: 80px;
        background-color: #20a0ff;
        /*background-color: #3a7dd8;*/
        color: #fff;
        top: 0;
        left: 0;
        line-height: 80px;
        z-index: 100;
        position: relative;
        padding:0 15px;
        margin:0 auto;
        .title{
            float:left;
            font-weight:700;
            font-size:24px;
        }
        #admin{
            float:right;
            font-size:16px;
            padding:0 15px;
            background-color: #20a0ff;
            height:100%;
            border:0;
            color: #fff;
            >.el-submenu{
                height:100%;
            }
            &:hover{
                padding:0 15px;
                cursor: pointer;
                float:right;
                font-size:16px;
                background-color: rgba(255,255,255,0.2);
                text-decoration: none;
                -webkit-transition: background-color .3s ease 0s;
                -moz-transition: background-color .3s ease 0s;
                -o-transition: background-color .3s ease 0s;
                -ms-transition: background-color .3s ease 0s;
                transition: background-color .3s ease 0s;
            };
        }
        .menu-item{
            float:left;
            transform:translateX(25%);
            height:100%;
        }
        .el-menu--horizontal {
            background-color: #20a0ff;
            .el-menu-item{
                height:80px;
                line-height:80px;
                color:#fff;
                font-size:16px;
                border:none;
                padding: 0px;
                &+.el-menu-item{
                    margin-left:10px;
                }
                &:hover{
                    border:none;
                    background-color: rgba(255,255,255,0.2);
                    text-decoration: none;
                    -webkit-transition: background-color .3s ease 0s;
                    -moz-transition: background-color .3s ease 0s;
                    -o-transition: background-color .3s ease 0s;
                    -ms-transition: background-color .3s ease 0s;
                    transition: background-color .3s ease 0s;
                }
                a{
                    display:inline-block;
                    text-align: center;
                    padding:0 20px;
                }
                &.is-active{
                    border:none;
                    background-color: rgba(255,255,255,0.2);
                    text-decoration: none;
                    -webkit-transition: background-color .3s ease 0s;
                    -moz-transition: background-color .3s ease 0s;
                    -o-transition: background-color .3s ease 0s;
                    -ms-transition: background-color .3s ease 0s;
                    transition: background-color .3s ease 0s;
                }
            }
        }
    }
</style>

<style lang="scss" rel="stylesheet/scss">
    #admin {
        >.el-submenu {
            height:100%;
            .el-submenu__title {
                height: 100%;
                line-height: 80px;
                border-bottom: 0;
                color:#fff;
                font-size: 16px;
                .el-submenu__icon-arrow{
                    font-size: 20px;
                    color: #fff
                }
                &:hover{
                    border:none;
                    background-color: rgba(255,255,255,0.2);
                    text-decoration: none;
                    -webkit-transition: background-color .3s ease 0s;
                    -moz-transition: background-color .3s ease 0s;
                    -o-transition: background-color .3s ease 0s;
                    -ms-transition: background-color .3s ease 0s;
                    transition: background-color .3s ease 0s;
                }
                a{
                    display:inline-block;
                    text-align: center;
                    padding:0 20px;
                }
                &.is-active{
                    border:none;
                    background-color: rgba(255,255,255,0.2);
                    text-decoration: none;
                    -webkit-transition: background-color .3s ease 0s;
                    -moz-transition: background-color .3s ease 0s;
                    -o-transition: background-color .3s ease 0s;
                    -ms-transition: background-color .3s ease 0s;
                    transition: background-color .3s ease 0s;
                }
            }
            .el-menu{
                left:-20px;
                width:150px;
                box-shadow: 0 0 10px #333;
                .el-menu-item{
                    color:#999;
                    text-align:center;
                    height: 60px;
                    line-height: 60px;
                    width: 100%;
                    min-width: 100px;
                    margin:0;
                    &:hover{
                        color:#333;
                    }
                    &.is-active{
                        color:#333;
                    }
                }
            }
        }
    }

</style>
