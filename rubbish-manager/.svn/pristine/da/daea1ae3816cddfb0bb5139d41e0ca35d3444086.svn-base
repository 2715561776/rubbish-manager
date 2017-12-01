<template>
    <div class="main">
        <div class="el-col el-col-24 el-col-xs-24 el-col-sm-5" style="height:100%;">
            <el-tabs type="border-card" class="leftTab" @tab-click="tabClick">
                <el-tab-pane >
                    <el-button type="primary" slot="label">车辆</el-button>
                    <div class="tab-pane-top">
                        <el-input placeholder="请输入内容" style="width:50%" v-model="inputHodometer"></el-input>
                        <el-button type="primary" @click="searchHodometer">查找</el-button>
                    </div>
                    <form>
                        <template>
                            <el-table
                                    :data="tableDataHodometer"
                                    stripe
                                    fit
                                    border
                                    @selection-change="selectionChangeHodometer"
                                    @row-click="clickHodometer"
                                    :max-height="max_heightHodometer"
                                    style="width: 100%">

                                <el-table-column
                                        label="行程单id"
                                        align="center"
                                        property="id"
                                >
                                </el-table-column>

                                <el-table-column
                                        label="车牌号码"
                                        align="center"
                                        property="licensePlatNumber"
                                >
                                </el-table-column>

                                <el-table-column
                                        label="行程单开始时间"
                                        align="center"
                                        min-width="110"
                                >
                                    <template scope="scope">
                                        <!--<el-icon name="time"></el-icon>-->
                                        <span style="margin-left: 10px">{{scope.row.startTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}')}}</span>
                                    </template>
                                </el-table-column>

                                <el-table-column
                                        label="行程单结束时间"
                                        align="center"
                                        min-width="110"
                                >
                                    <template scope="scope">
                                        <!--<el-icon name="time"></el-icon>-->
                                        <span style="margin-left: 10px">{{scope.row.endTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}')}}</span>
                                    </template>
                                </el-table-column>
                            </el-table>

                            <el-pagination
                                    @size-change="handleSizeChangeHodometer"
                                    @current-change="handleCurrentChangeHodometer"
                                    :current-page=currentPageHodometer
                                    :page-size="10"
                                    layout="total, prev, pager, next, jumper"
                                    :total="totalHodometer">
                            </el-pagination>
                        </template>
                    </form>
                </el-tab-pane>
                <el-tab-pane>
                    <el-button type="primary" slot="label">建筑工地</el-button>
                    <div class="">
                        <el-tree
                                :data="treeData"
                                :props="defaultProps"
                                accordion
                                @node-click="handleNodeClick">
                        </el-tree>
                    </div>
                </el-tab-pane>
                <el-tab-pane>
                    <el-button type="primary" slot="label">行程单</el-button>
                    <div class="tab-pane-top">
                        <el-input placeholder="请输入内容" style="width:50%" v-model="inputCommunity"></el-input>
                        <el-button type="primary" @click="searchCommunity">查找</el-button>
                    </div>
                    <form>
                        <template>
                            <el-table
                                    :data="tableDataCommunity"
                                    stripe
                                    fit
                                    @selection-change="selectionChangeCommunity"
                                    :max-height="max_heightCommunity"
                                    @row-click = "rowClickCommunity"
                                    style="width: 100%">

                                <el-table-column
                                        label="场地名称"
                                        show-overflow-tooltip
                                        align="center"
                                        property="name"
                                >
                                </el-table-column>

                                <el-table-column
                                        label="状态"
                                        align="center"
                                >
                                    <template scope="scope">
                                        <!--冻结-->
                                        <el-tag type="success" v-if="scope.row.type == 1">建筑场地</el-tag>
                                        <!--启用-->
                                        <el-tag type="success" v-if="scope.row.type == 2">垃圾中转站</el-tag>
                                        <el-tag type="success" v-if="scope.row.type == 3">垃圾焚烧厂及处理厂</el-tag>
                                    </template>
                                </el-table-column>
                            </el-table>
                            <el-pagination
                                    @size-change="handleSizeChangeCommunity"
                                    @current-change="handleCurrentChangeCommunity"
                                    :current-page=currentPageCommunity
                                    :page-size="10"
                                    layout="total, prev, pager, next, jumper"
                                    :total="totalCommunity">
                            </el-pagination>
                        </template>
                    </form>
                </el-tab-pane>
            </el-tabs>
        </div>
        <div class="el-col el-col-24 el-col-xs-24 el-col-sm-19 tabclick" style="height:100%;position:relative">
            <el-amap ref = "map" vid="amap" :zoom="zoom" :center="center" class="amap-demo" :plugin="plugins"
                     :map-manager="amapManager" :events="events"
            >
                <el-amap-marker v-for="marker in markers" :position="marker.position" :events="marker.events"
                                :visible="marker.visible" :draggable="marker.draggable" :icon="marker.icon"
                                :offset="marker.offset" :angle="marker.angle"
                >

                </el-amap-marker>
                <el-amap-polyline :editable="polyline.editable" :strokeColor="polyline.strokeColor"
                                  :path="polyline.path" :events="polyline.events"></el-amap-polyline>
                <el-amap-info-window v-for="window in windows" :position="window.position" :visible="window.visible"
                :content="window.content"></el-amap-info-window>
                <!--<el-amap-circle v-for="circle in circles" :center="circle.center" :radius="circle.radius" :fillOpacity="circle.fillOpacity" :events="circle.events">-->

                <!--</el-amap-circle>-->
                <el-amap-polygon v-for="(polygon, index) in polygons" :vid="index" :ref="`polygon_${index}`"
                                 :path="polygon.path" :events="polygon.events">

                </el-amap-polygon>
            </el-amap>
            <div :class="[ 'form_tab',arrowFlag? '' : 'width']">
                <div class="form_tab_content">
                    <i v-bind:class="[ arrowFlag ? 'el-icon-arrow-down' : 'el-icon-arrow-up']"
                       @click.stop="arrowDown"></i>
                    <transition enter-active-class="animated fadeInLeft" leave-active-class="animated fadeOutLeft">
                        <el-tabs type="border-card" v-show="arrowFlag">
                            <el-tab-pane label="车辆汇总">
                                <form>
                                    <template>
                                        <div>
                                            <el-table
                                                    :data="tableData"
                                                    border
                                                    stripe
                                                    fit
                                                    height="300"
                                                    style="width: 100%">
                                                <el-table-column
                                                        align="center"
                                                        type="selection"
                                                        width="55">
                                                </el-table-column>

                                                <el-table-column
                                                        label="车队名称"
                                                        align="center"

                                                >
                                                    <template scope="scope">
                                                        <div>
                                                            <el-popover trigger="hover" placement="top">
                                                                <p>车队名称 : {{ scope.row.carName }}</p>
                                                                <div slot="reference" class="name-wrapper">
                                                                    <el-tag>{{ scope.row.carName.substring(0, 6) + "..."}}
                                                                    </el-tag>
                                                                </div>
                                                            </el-popover>
                                                        </div>
                                                    </template>
                                                </el-table-column>

                                                <el-table-column
                                                        label="车牌号码"
                                                        align="center"
                                                >
                                                    <template scope="scope">
                                                        {{ scope.row.carNumber }}
                                                    </template>
                                                </el-table-column>

                                                <el-table-column
                                                        label="设备名称"
                                                        align="center"
                                                >
                                                    <template scope="scope">
                                                        {{ scope.row.deviceName }}
                                                    </template>
                                                </el-table-column>

                                                <el-table-column
                                                        label="驾驶员姓名"
                                                        align="center"
                                                >
                                                    <template scope="scope">
                                                        <!--<el-popover trigger="hover" placement="top">-->
                                                        <!--<p>姓名: {{ scope.row.personName }}</p>-->
                                                        <!--<p>住址: {{ scope.row.address }}</p>-->
                                                        <!--<div slot="reference" class="name-wrapper">-->
                                                        <!--<el-tag>{{ scope.row.personName }}</el-tag>-->
                                                        <!--</div>-->
                                                        <!--</el-popover>-->
                                                        <div slot="reference" class="name-wrapper">
                                                            <el-tag>{{ scope.row.personName }}</el-tag>
                                                        </div>
                                                    </template>

                                                </el-table-column>

                                                <el-table-column
                                                        label="设备ID"
                                                        align="center"
                                                >
                                                    <template scope="scope">
                                                        {{ scope.row.deviceID }}
                                                    </template>
                                                </el-table-column>

                                                <el-table-column
                                                        label="驾驶员电话"
                                                        align="center"
                                                >
                                                    <template scope="scope">
                                                        {{ scope.row.personTel }}
                                                    </template>
                                                </el-table-column>

                                                <el-table-column
                                                        label="修改日期"
                                                        align="center"
                                                >
                                                    <template scope="scope">
                                                        <!--<el-icon name="time"></el-icon>-->
                                                        <span style="margin-left: 10px">{{ scope.row.time }}</span>
                                                    </template>
                                                </el-table-column>

                                                <el-table-column label="操作"
                                                                 align="center"
                                                >
                                                    <template scope="scope">
                                                        <el-button
                                                                size="small"
                                                                @click="handleEdit(scope.$index, scope.row)">编辑
                                                        </el-button>
                                                        <el-button
                                                                size="small"
                                                                type="danger"
                                                                @click="handleDelete(scope.$index, scope.row)"
                                                        >删除
                                                        </el-button>
                                                    </template>
                                                </el-table-column>
                                            </el-table>
                                            <el-pagination
                                                    @size-change="handleSizeChange"
                                                    @current-change="handleCurrentChange"
                                                    :current-page="currentPage"
                                                    :page-sizes="[100, 200, 300, 400]"
                                                    :page-size="100"
                                                    layout="total, prev, pager, next, jumper"
                                                    :total="400">
                                            </el-pagination>
                                        </div>
                                    </template>
                                </form>
                            </el-tab-pane>
                            <el-tab-pane label="传感器数据">传感器数据</el-tab-pane>
                        </el-tabs>
                    </transition>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    import {AMapManager} from 'vue-amap';
    import {mapGetters, mapActions} from 'vuex'
    import * as actions from '../../store/modules/vehiclelocu/actions'
    import {angle} from '../../../assets/js/util'



    let amapManager = new AMapManager();
    export default {
        data() {
            return {
                zoom: 16,
                center: [121.516,31.2729], // 31.2729 121.516
                amapManager,
                events: {
                    init(map) {
                    }
                },
                plugins: [
                    {
                        pName: 'MapType',
                        defaultType: 0,
                        events: {
                            init(instance) {
//                                console.log(instance);
                            }
                        }
                    },
                    {
                        pName: 'OverView',
                        events: {
                            init(instance) {
//                                console.log(instance);
                            }
                        },
                        isOpen: true,
                    },
                    {
                        pName: 'ToolBar',
                        events: {
                            init(instance) {
//                                console.log(instance);
                            }
                        }
                    },
                ],
                markers: [],
                windows: [],

                polyline: {
                    path: [],
                    events: {
                        click(e) {
                            alert('click polyline');
                        },
                        end: (e) => {
                            let newPath = e.target.getPath().map(point => [point.lng, point.lat]);
                            console.log(newPath);
                        }
                    },
                    editable: false,
                },
                circles: [
                    {
                        center: [121.59196, 31.197646],
                        radius: 200,
                        fillOpacity: 0.5,
                        events: {
                            click: () => {
                                alert('click polygon');
                            }
                        }
                    }
                ],
                polygons: [],

                currentPage: 5,

                arrowFlag: false,
                defaultProps: {
                    children: 'vehicleList',
                    label: 'name'
                },
                tableData: [
                    {
                        carName: '方松街道清除公司',
                        carNumber: '沪A23456',
                        deviceName: 'SIM设备',
                        deviceID: '#343434',
                        personName: '宋小明',
                        personTel: '17612108553',
                        time: '2017-10-09',
                        address: '上海市松江区佘山 1518 弄'
                    },{
                        carName: '方松街道清除公司',
                        carNumber: '沪A23456',
                        deviceName: 'SIM设备',
                        deviceID: '#343434',
                        personName: '宋小明',
                        personTel: '17612108553',
                        time: '2017-10-09',
                        address: '上海市松江区佘山 1518 弄'
                    }, {
                        carName: '方松街道清除公司',
                        carNumber: '沪A23456',
                        deviceName: 'SIM设备',
                        deviceID: '#343434',
                        personName: '宋小明',
                        personTel: '17612108553',
                        time: '2017-10-09',
                        address: '上海市松江区佘山 1518 弄'
                    }, {
                        carName: '方松街道清除公司',
                        carNumber: '沪A23456',
                        deviceName: 'SIM设备',
                        deviceID: '#343434',
                        personName: '宋小明',
                        personTel: '17612108553',
                        time: '2017-10-09',
                        address: '上海市松江区佘山 1518 弄'
                    }, {
                        carName: '方松街道清除公司',
                        carNumber: '沪A23456',
                        deviceName: 'SIM设备',
                        deviceID: '#343434',
                        personName: '宋小明',
                        personTel: '17612108553',
                        time: '2017-10-09',
                        address: '上海市松江区佘山 1518 弄'
                    }, {
                        carName: '方松街道清除公司',
                        carNumber: '沪A23456',
                        deviceName: 'SIM设备',
                        deviceID: '#343434',
                        personName: '宋小明',
                        personTel: '17612108553',
                        time: '2017-10-09',
                        address: '上海市松江区佘山 1518 弄'
                    }, {
                        carName: '方松街道清除公司',
                        carNumber: '沪A23456',
                        deviceName: 'SIM设备',
                        deviceID: '#343434',
                        personName: '宋小明',
                        personTel: '17612108553',
                        time: '2017-10-09',
                        address: '上海市松江区佘山 1518 弄'
                    }, {
                        carName: '方松街道清除公司',
                        carNumber: '沪A23456',
                        deviceName: 'SIM设备',
                        deviceID: '#343434',
                        personName: '宋小明',
                        personTel: '17612108553',
                        time: '2017-10-09',
                        address: '上海市松江区佘山 1518 弄'
                    }, {
                        carName: '方松街道清除公司',
                        carNumber: '沪A23456',
                        deviceName: 'SIM设备',
                        deviceID: '#343434',
                        personName: '宋小明',
                        personTel: '17612108553',
                        time: '2017-10-09',
                        address: '上海市松江区佘山 1518 弄'
                    }, {
                        carName: '方松街道清除公司',
                        carNumber: '沪A23456',
                        deviceName: 'SIM设备',
                        deviceID: '#343434',
                        personName: '宋小明',
                        personTel: '17612108553',
                        time: '2017-10-09',
                        address: '上海市松江区佘山 1518 弄'
                    }, {
                        carName: '方松街道清除公司',
                        carNumber: '沪A23456',
                        deviceName: 'SIM设备',
                        deviceID: '#343434',
                        personName: '宋小明',
                        personTel: '17612108553',
                        time: '2017-10-09',
                        address: '上海市松江区佘山 1518 弄'
                    }, {
                        carName: '方松街道清除公司',
                        carNumber: '沪A23456',
                        deviceName: 'SIM设备',
                        deviceID: '#343434',
                        personName: '宋小明',
                        personTel: '17612108553',
                        time: '2017-10-09',
                        address: '上海市松江区佘山 1518 弄'
                    }, {
                        carName: '方松街道清除公司',
                        carNumber: '沪A23456',
                        deviceName: 'SIM设备',
                        deviceID: '#343434',
                        personName: '宋小明',
                        personTel: '17612108553',
                        time: '2017-10-09',
                        address: '上海市松江区佘山 1518 弄'
                    }, {
                        carName: '方松街道清除公司',
                        carNumber: '沪A23456',
                        deviceName: 'SIM设备',
                        deviceID: '#343434',
                        personName: '宋小明',
                        personTel: '17612108553',
                        time: '2017-10-09',
                        address: '上海市松江区佘山 1518 弄'
                    }, {
                        carName: '方松街道清除公司',
                        carNumber: '沪A23456',
                        deviceName: 'SIM设备',
                        deviceID: '#343434',
                        personName: '宋小明',
                        personTel: '17612108553',
                        time: '2017-10-09',
                        address: '上海市松江区佘山 1518 弄'
                    }, {
                        carName: '方松街道清除公司',
                        carNumber: '沪A23456',
                        deviceName: 'SIM设备',
                        deviceID: '#343434',
                        personName: '宋小明',
                        personTel: '17612108553',
                        time: '2017-10-09',
                        address: '上海市松江区佘山 1518 弄'
                    }, {
                        carName: '方松街道清除公司',
                        carNumber: '沪A23456',
                        deviceName: 'SIM设备',
                        deviceID: '#343434',
                        personName: '宋小明',
                        personTel: '17612108553',
                        time: '2017-10-09',
                        address: '上海市松江区佘山 1518 弄'
                    }, {
                        carName: '方松街道清除公司',
                        carNumber: '沪A23456',
                        deviceName: 'SIM设备',
                        deviceID: '#343434',
                        personName: '宋小明',
                        personTel: '17612108553',
                        time: '2017-10-09',
                        address: '上海市松江区佘山 1518 弄'
                    },
                ],
                // 小区
                max_heightCommunity: "",
                currentPageCommunity: 2,
                inputCommunity: "",
                // 行程单
                max_heightHodometer: "",
                currentPageHodometer: 2,
                inputHodometer: "",
            };
        },
        methods: {
            removeMarker() {
                if (!this.markers.length) return;
                this.markers.splice(this.markers.length - 1, 1);
            },
            arrowDown(){
                this.arrowFlag === true ? this.arrowFlag = false : this.arrowFlag = true;
            },
            handleSizeChange(val) {
//                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
//                console.log(`当前页: ${val}`);
            },
            // 小区
            selectionChangeCommunity(){

            },
            handleSizeChangeCommunity(){

            },
            handleCurrentChangeCommunity(){

            },
            rowClickCommunity(row){
                let _this = this;
                this.findByPlaceInfoId({id:row.id}).then(() => {
                    let currentCommunity = _this.currentCommunity.places.split(",");
                    let tmp = [];
                    let len = currentCommunity.length/2;
                    for(let i = 0;i< len;i++){
                        tmp.push(currentCommunity.splice(0,2));
                    }
                    _this.polygons.push({
                        path: [tmp],
                        events: {
                            click: () => {
                                alert('click polygon');
                            }
                        }
                    })

                })

            },
            // 行程单
            selectionChangeHodometer(selection){
                console.log(selection)
            },
            clickHodometer(row){
                let _this = this;
                let start = null;
                let end = null;
                let markerPosition = [];
                _this.polyline.path = [];
                _this.markers = [];
                this.clearMap();
                this.queryVehicleLocu({id: row.id}).then(() => {
                    let res = _this.getVehicleLocus;
                    $.each(res, (i, v) => {
                        // latitude 纬度 x
                        // longitude 经度 y
                        markerPosition.push([res[i].longitude, res[i].latitude]);
                        let marker = {
                            events: {
                                click() {
                                    _this.windows.forEach(window => {
                                        window.visible = false;
                                    });

                                    _this.$nextTick(() => {
                                        _this.windows[i].visible = true;
                                    });
                                }
                            },
                            position: [res[i].longitude, res[i].latitude],
                            icon: "../../../assets/image/gray_car.gif",
                            offset: [-15, -34],
                            angle: 0,
                        };
                        // 只添加第一个点和最后一个点
                        if (i === res.length - 1 || i === 0) {
                            _this.markers.push(marker);
                        }
                        if (i === 1 || i === 0) {
                            start = {
                                start:{
                                    x:res[0].latitude,
                                    y:res[0].longitude,
                                },
                                end:{
                                    x:res[1].latitude,
                                    y:res[1].longitude,
                                }
                            }
                        }
                        if (i === res.length - 1 || i === res.length - 2) {
                            end = {
                                start:{
                                    x:res[res.length - 1].latitude,
                                    y:res[res.length - 1].longitude,
                                },
                                end:{
                                    x:res[res.length - 2].latitude,
                                    y:res[res.length - 2].longitude,
                                }
                            }
                        }
//                        _this.polyline.path.push(marker.position);
                        _this.windows.push({
                            position: marker.position,
                            content: `<div class="prompt"> 沪A2342${ i }</div>`,
                            visible: true
                        });
                    })
                    let startAngle = angle(start.start,start.end);
                    let endAngle = angle(end.start,end.end);
                    _this.markers.forEach((v,i) => {
                        let length = _this.markers.length
                        if(i === 0){
                            v.angle =startAngle + 180;
                        }
                        if(i === length - 1 ){
                            v.angle = endAngle;
                        }
                    })
                });
                // 获取地图实例
                const map = _this.$refs.map.$$getInstance();
                window.initAMapUI();
                AMapUI.load(['ui/misc/PathSimplifier', 'lib/$'], function(PathSimplifier, $) {
                    if (!PathSimplifier.supportCanvas) {
                        alert('当前环境不支持 Canvas！');
                        return;
                    }

                    let pathSimplifierIns = new PathSimplifier({
                        zIndex: 100,
                        //autoSetFitView:false,
                        map: map, //所属的地图实例

                        getPath: function(pathData, pathIndex) {
                            return pathData.path;
                        },
                        getHoverTitle: function(pathData, pathIndex, pointIndex) {

                            if (pointIndex >= 0) {
                                //point
                                return pathData.name + '，点：' + pointIndex + '/' + pathData.path.length;
                            }

                            return pathData.name + '，点数量' + pathData.path.length;
                        },
                        renderOptions: {
                            renderAllPointsIfNumberBelow: 100 //绘制路线节点，如不需要可设置为-1
                        }
                    });
                    //设置数据
                    pathSimplifierIns.setData([{
                        name: '路线0',
                        path: markerPosition,
                    }]);

                    //对第一条线路（即索引 0）创建一个巡航器
                    let navg1 = pathSimplifierIns.createPathNavigator(0, {
                        loop: true, //循环播放
                        speed: 100,//巡航速度，单位千米/小时
                        pathNavigatorStyle: {
                            width: 32,
                            height: 32,
//                                使用图片 这个 路径啊
                            content: PathSimplifier.Render.Canvas.getImageContent('../../../assets/image/gray_car.gif',
                                function onload() {
                                    //图片加载成功，重新绘制一次
                                    pathSimplifierIns.renderLater();
                                },
                                function onerror(e) {
                                    alert('图片加载失败！');
                                }),
                            strokeStyle: null,
                            fillStyle: null,
                        }
                    });
                    navg1.start();
                });
            },



            handleSizeChangeHodometer(){

            },
            handleCurrentChangeHodometer(){

            },

            handleEdit(index, row) {
//                console.log(index, row);
            },
            handleDelete(index, row, tableData) {
                this.tableData.splice(index, 1);
            },
            handleCheckChange(data, checked, indeterminate) {
//                console.log(data, checked, indeterminate);
            },
            handleNodeClick(data,node,self) {
                let _this = this;
                if(node.level === 3 && typeof (data.id) !== undefined){
                    _this.markers = [];
                    this.queryLastVehicleLocu({id:data.id}).then(() => {
                        let marker = {
                            position: [_this.getLastVehicleLocu.longitude, _this.getLastVehicleLocu.latitude],
                            icon: "../../../assets/image/gray_car.gif",
                            offset: [-10, -34],
                            angle: 80,
                        };
                        _this.markers.push(marker);
                    });
                }
            },
            // 点击选项卡时触发的事件
            tabClick(tabs){
                this.clearMap();
            },
            // 点击查询小区
            searchCommunity(){
                let value = this.inputCommunity;
                alert(value);
                this.queryPlaceInfo({
                    input: this.inputCommunity
                });
            },
            // 点击查询行程单
            searchHodometer(){
                let value = this.inputHodometer;
                alert(value);
                this.queryPlaceInfo({
                    input: this.inputHodometer
                });
            },
            // 清空地图
            clearMap(){
                let map = this.$refs.map.$$getInstance();
                map.clearMap();
            },
            //action方法
            ...mapActions([
                'queryPlaceInfo',
                'findByPlaceInfoId',
                'saveOrUpdatePlaceInfo',
                'deletePlaceInfo',
                'batchDeletePlaceInfo',

                // 行程单
                'cleanCurrentApply',
                'queryApply',
                'findByApplyId',
                'saveOrUpdateApply',
                'deleteApply',
                'batchDeleteApply',

                // position
                'queryVehicleLocu',

                //biddingCompanyInfo
                'queryBiddingCompanyInfoWithVehicle',
                //查某辆车最新的坐标
                'queryLastVehicleLocu'
            ]),
        },
        computed: {
            ...mapGetters({
                tableDataCommunity: "getPlaceInfos",
                totalCommunity: "getPlaceInfoTotal",
                currentCommunity: "getCurrentPlaceInfo",

                // 行程单
                tableDataHodometer: 'getApplys',
                totalHodometer: 'getApplyTotal',
                currentHodometer: 'getCurrentApply',

                // position
                getVehicleLocus: 'getVehicleLocus',
                getVehicleLocuTotal: 'getVehicleLocuTotal',
                getCurrentVehicleLocu: 'getCurrentVehicleLocu',


                //biddingCompanyInfo
                treeData : 'getBiddingCompanyInfoWithVehicle',

                getLastVehicleLocu:'getLastVehicleLocu'

            })
        },
        mounted() {
            let _this = this;


            let markers = [];
            let windows = [];
            let polylinePath = [];
            let polygonsPath = [];
            let polygonss = [];

            let num = 4;
            let self = this;

            for (let i = 0; i < num; i++) {
                markers.push({
                    position: [121.59996, 31.197646 + i * 0.001],
                    events: {
                        click() {
                            self.windows.forEach(window => {
                                window.visible = false;
                            });

                            self.$nextTick(() => {
                                self.windows[i].visible = true;
                            });
                        }
                    },

                })
                polygonss.push({
                    path: [],
                    events: {
                        click: () => {
                            alert('click polygon');
                        }
                    }
                })
                polylinePath.push([121.59996, 31.197646 + i * 0.001]);
                windows.push({
                    position: [121.59996, 31.197646 + i * 0.001],
                    content: `<div class="prompt"> 沪A2342${ i }</div>`,
                    visible: true
                });
            }
            // 圆心(x - n,y) r  2
            // (x - n, y -r)
            // (x - (n - r),y)
            // (x - n,y +r)
            // (x - (n + r),y)
            // 四个地块间距 l 17n, w 11h


            const n = 8, r = 2, l = 17, w = 11;
            const polygonsPath0 = [[121.59996 - (n + r / 2) * 0.001, 31.197646 + r / 2 * 0.001],
                [121.59996 - (n - r / 2) * 0.001, 31.197646 + r / 2 * 0.001],
                [121.59996 - (n - r / 2) * 0.001, 31.197646 - r / 2 * 0.001],
                [121.59996 - (n + r / 2) * 0.001, 31.197646 - r / 2 * 0.001]];

            const polygonsPath1 = [[121.59996 - ((n - r / 2) - l) * 0.001, 31.197646 - r / 2 * 0.001],
                [121.59996 - ((n - r / 2) - l) * 0.001, 31.197646 + r / 2 * 0.001],
                [121.59996 + n * 0.001, 31.197646 + r / 2 * 0.001],
                [121.59996 + n * 0.001, 31.197646 - r / 2 * 0.001]];

            const polygonsPath2 = [[121.59996 + n * 0.001, 31.197646 - (r / 2 + w) * 0.001],
                [121.59996 + (n + r ) * 0.001, 31.197646 - (r / 2 + w) * 0.001],
                [121.59996 + (n + r ) * 0.001, 31.197646 - (r / 2 + w + r ) * 0.001],
                [121.59996 + n * 0.001, 31.197646 - (r / 2 + w + r ) * 0.001]];

            const polygonsPath3 = [[121.59996 - (n + r / 2) * 0.001, 31.197646 - (r / 2 + w) * 0.001],
                [121.59996 - (n - r / 2 ) * 0.001, 31.197646 - (r / 2 + w) * 0.001],
                [121.59996 - (n - r / 2 ) * 0.001, 31.197646 - (r / 2 + w + r ) * 0.001],
                [121.59996 - (n + r / 2) * 0.001, 31.197646 - (r / 2 + w + r ) * 0.001]];
            polygonss[0].path = polygonsPath0;
            polygonss[1].path = polygonsPath1;
            polygonss[2].path = polygonsPath2;
            polygonss[3].path = polygonsPath3;
            $.each(polygonss, function (i, v) {
//                polygonss[i].path = polygonsPath+i
            })
//            this.markers = markers;
//            this.windows = windows;
//            this.polyline.path = polylinePath;
            this.polygons = polygonss;


            // 动态计算表格高度

            this.$nextTick(() => {
                let tabs_height = $(".el-tabs").height();
                let tabs__header_height = $(".el-tabs__header").height();
                let tabs__content_height = tabs_height - tabs__header_height;
                $(".leftTab .el-tabs__content").height(tabs_height - tabs__header_height - 30);
                let pagination_height = $(".el-pagination").height();
                let tab_pane_height = $(".tab-pane-top").height();


                // 小区
                let max_heightCommunity = tabs__content_height - pagination_height - tab_pane_height - 30;
                this.max_heightCommunity = max_heightCommunity;
                // 行程单
                let max_heightHodometer = tabs__content_height - pagination_height - tab_pane_height - 30;
                this.max_heightHodometer = max_heightHodometer;

            })


            // 页面加载查询ajax
            // 小区
            this.queryPlaceInfo({});
            // 中标公司
            this.queryBiddingCompanyInfoWithVehicle({}).then(() => {
            });
            // 行程单
            this.queryApply({}).then(() => {
            });

        }
    }
</script>


<style lang="scss" scoped rel="stylesheet/scss">
    .main {
        margin: 10px 15px;
        box-sizing: border-box;
        position: absolute;
        width: calc(100% - 30px);
        height: calc(100% - 100px);
        background: #fff;
        .el-tabs--border-card {
            height: 100%;
            padding: 8px;
            padding-bottom: 0px;
            box-sizing: border-box;
            border: none;
            .el-button {
                padding: 12px;
            }
        }
    }

    .form_nav {
        background: #eff4f8;
        height: 80px;
        padding: 0 15px;
        position: absolute;
        z-index: 999;
        left: 65px;
        top: 15px;
    }

    .form_tab {
        position: absolute;
        z-index: 999;
        left: 0px;
        bottom: 0px;
        width: 100%;
        min-height: 50px;
        background: rgba(255, 255, 255, 0.8);
        &.width {
            width: 60px;
        }
        .form_tab_content {
            position: relative;
            > .el-icon-arrow-down, .el-icon-arrow-up {
                position: absolute;
                font-size: 20px;
                right: 15px;
                top: 20px;
                color: #20a0ff;
                z-index: 999;
            }
        }
    }

    .wrapper {
        line-height: 80px;
    }

    .el-table th {
        background: #eff4f8
    }

    .el-button + .el-button {
        margin-left: 0px;
    }

    .prompt {
        background: white;
        width: 100px;
        height: 30px;
        text-align: center;
    }
</style>
<style lang="scss"  rel="stylesheet/scss">
    .leftTab{
        .el-tabs__header{
            position:absolute;
            left:380px;
            z-index:99999;
            background: #eff4f8;
            height: 80px;
            padding: 0 15px;
            top: 15px;
            border-bottom: 0 !important;
            line-height: 80px;
            .el-tabs__item{
                border:0 !important;
                margin:0 !important;
                padding: 0;
                padding-right:15px;
                &.is-active{
                    border:0;
                    background: #eff4f8 !important;
                    border-color:#eff4f8 !important;
                }
            }
        }
    }

</style>


