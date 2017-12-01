
<template>
    <div class = "main">
        <div class = "el-col el-col-24 el-col-xs-24 el-col-sm-2" style = "height:100%">
            <el-menu :default-active="route" class="el-menu-vertical-demo" style = "background:#fff;height:calc(100% - 10px);padding-top:10px">
                <el-menu-item index="1"><router-link to = "/vehicleAppoint/vehicleAppoint"><span>预约</span></router-link></el-menu-item>
                <!--<el-menu-item index="2"><router-link to = "/vehicleAppoint/test"><span>test</span></router-link></el-menu-item>-->
                <!--<el-menu-item index="3"><router-link to = "/vehicleAppoint/demo5"><span>demo</span></router-link></el-menu-item>-->

            </el-menu>
        </div>
        <transition enter-active-class="animated zoomIn" leave-active-class="animated zoomOut">
            <router-view></router-view>
        </transition>
    </div>
</template>

<script>
    export default{
        data() {
            return {
                route: "",
            };
        },
        mounted(){
            var route = this.$route.path;
            if(route === "/vehicleAppointSide/vehicleAppoint"){
                this.route = "1";
            }
            if(route === "/vehicleAppointSide"){
                this.route = "1";
            }
        }
    }
</script>

