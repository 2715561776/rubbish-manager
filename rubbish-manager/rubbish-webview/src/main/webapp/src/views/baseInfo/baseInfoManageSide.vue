
<template>
    <div class = "main">
        <div class = "el-col el-col-24 el-col-xs-24 el-col-sm-2" style = "height:100%">
            <el-menu :default-active="route" class="el-menu-vertical-demo" style = "background:#fff;height:calc(100% - 10px);padding-top:10px">
                <el-menu-item index="1"><router-link to = "/baseInfo/User"><span>用户</span></router-link></el-menu-item>
                <el-menu-item index="2"><router-link to = "/baseInfo/PlaceInfo"><span>场地信息</span></router-link></el-menu-item>
            </el-menu>
        </div>
        <transition enter-active-class="animated zoomIn" leave-active-class="animated zoomOut">
            <router-view></router-view>
        </transition>
    </div>
</template>

<script>
    import Transfer from "../../../node_modules/iview/src/components/transfer/transfer";
    export default{
        components: {Transfer},
        data() {
            return {
                route: "",
            };
        },
        mounted(){
            var route = this.$route.path;
            if(route === "/baseInfoManageSide"){
                this.route = "1";
            }
            if(route === "/baseInfo/User"){
                this.route = "1";
            }
            if(route === "/baseInfo/PlaceInfo"){
                this.route = "2";
            }

        }
    }
</script>

<style lang="scss" scoped rel="stylesheet/scss">
    .main{
        margin:10px 15px;
        box-sizing: border-box;
        position: absolute;
        width: calc(100% - 30px);
        height: calc(100% - 100px);
        background:#fff;
        ul.el-menu{
            height:100%;
            background:#20a0ff;
            .el-menu-item{
                text-align:center;
                height:80px;
                &,.el-submenu__title{
                    transition:none;
                }
                &:hover{
                    text-align:center;
                    height:80px;
                    border-bottom:3px solid #fff;
                }
                a {
                    display: inline-block;
                    text-align: center;
                    height: 60px;
                    color: #20a0ff;
                    width:100%;
                    span{
                        display:inline-block;
                        height:60px;
                        text-align: center;
                    }
                }
                &.is-active a{
                    display: inline-block;
                    text-align: center;
                    height: 60px;
                    color: #20a0ff;
                    width:100%;
                    span{
                        display:inline-block;
                        text-align: center;
                        height: 60px;
                        border-bottom: 3px solid #20a0ff !important;
                    }
                }
                &:hover a {
                    display: inline-block;
                    text-align: center;
                    height: 60px;
                    color: #20a0ff;
                    width:100%;
                    span{
                        display:inline-block;
                        text-align: center;
                        height: 60px;
                        border-bottom: 3px solid #20a0ff !important;
                    }
                }
            }
        }
    }
</style>
