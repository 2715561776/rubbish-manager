
<template>
    <div class = "main">
        <div class = "el-col el-col-24 el-col-xs-24 el-col-sm-2" style = "height:100%">
            <el-menu :default-active="route" class="el-menu-vertical-demo" style = "background:#fff;height:calc(100% - 10px);padding-top:10px">
                <el-menu-item index="1"><router-link to = "/verhicleSide/applyIn"><span>输入垃圾</span></router-link></el-menu-item>
                <el-menu-item index="2"><router-link to = "/verhicleSide/applyOut"><span>输出垃圾</span></router-link></el-menu-item>
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
            if(route === "/verhicleSide/verhicle"){
                this.route = "1";
            }
            if(route === "/verhicleSide"){
                this.route = "1";
            }
            if(route === "/verhicleSide/biddingCompany"){
                this.route = "2";
            }
        }
    }
</script>

