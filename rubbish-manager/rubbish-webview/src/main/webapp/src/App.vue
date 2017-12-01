<template>
    <div id="app">
        <router-view></router-view>
    </div>
</template>

<script>
    import $ from 'jquery'
    import headerTemp from './components/header.vue'


    export default {
        name: 'app',
        data() {
            return{

            }
        },
    }

    // 基于准备好的dom，初始化echarts实例
//    var myChart = echarts.init(document.getElementById('main'));
//    // 绘制图表
//    myChart.setOption({
//        title: { text: 'ECharts 入门示例' },
//        tooltip: {},
//        xAxis: {
//            data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
//        },
//        yAxis: {},
//        series: [{
//            name: '销量',
//            type: 'bar',
//            data: [5, 20, 36, 10, 10, 20]
//        }]
//    });
</script>

<style lang="scss" scoped rel="stylesheet/scss">
    #app{
        width:100%;
        height:100%;
        background:#f1f4f9;
        .el-table .cell, .el-table th>div{
            padding-left:8px;
            padding-right:8px;
        }
    }
</style>
