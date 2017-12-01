
<template>
        <div class = "el-col el-col-24 el-col-xs-24 el-col-sm-22 tabclick" style = "height:100%">
            <div class = "form_nav el-col el-col-24 el-col-xs-24 el-col-sm-24">
                <div>
                     <span class="wrapper" style = "float:left;">
                        <el-button type="primary" @click.stop="addInfo('ruleForm2')">添加场地信息</el-button>
                        <el-button type="danger" @click.stop = "allDelete">全部删除</el-button>
                      </span>
                    <span class="wrapper" style = "float:right;">
                        <el-button type="primary" @click.stop = "searchCarInfo">查找</el-button>
                      </span>
                    <span class="wrapper" style = "float:right;margin-right:20px;">
                          <el-input v-model="input" placeholder="请输入内容"></el-input>
                      </span>
                </div>
            </div>
            <form>
                <template>
                    <el-table
                            v-loading.lock="loading"
                            :data="tableData"
                            border
                            stripe
                            fit
                            @selection-change = "selectionChange"
                            :height = "height"
                            style="width: 100%">
                        <el-table-column
                                type="selection"
                                align = "center"
                                width="55">
                        </el-table-column>

                        <el-table-column
                                label="场地名称"
                                show-overflow-tooltip
                                align = "center"
                        >
                            <template scope="scope">
                                {{ scope.row.name }}
                            </template>
                        </el-table-column>

                        <el-table-column
                                label="联系人"
                                align = "center"

                        >
                            <template scope="scope">
                                {{ scope.row.contacter}}
                            </template>
                        </el-table-column>

                        <el-table-column
                                label="状态"
                                align = "center"

                        >
                            <template scope="scope">
                                <!--冻结-->
                                <el-tag type="success" v-if="scope.row.type == 1">建筑工地</el-tag>
                                <!--启用-->
                                <el-tag type="success" v-if="scope.row.type == 2">垃圾中转站</el-tag>
                                <el-tag type="success" v-if="scope.row.type == 3">垃圾焚烧厂及处理厂</el-tag>
                            </template>
                        </el-table-column>


                        <el-table-column
                                label="状态"
                                align = "center"

                        >
                            <template scope="scope">
                                <!--冻结-->
                                <el-tag type="success" v-if="scope.row.status == 1">启用</el-tag>
                                <!--启用-->
                                <el-tag type="gray" v-if="scope.row.status == 0">冻结</el-tag>
                            </template>
                        </el-table-column>


                        <el-table-column
                                label="修改日期"
                                align = "center"
                                min-width="110"
                        >
                            <template scope="scope">
                                <!--<el-icon name="time"></el-icon>-->
                                <span style="margin-left: 10px">{{scope.row.lastupdatedTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}')}}</span>
                            </template>
                        </el-table-column>

                        <el-table-column label="操作"
                                         align = "center"
                                         min-width="80"
                        >
                            <template scope="scope">
                                <el-button
                                        size="small"
                                        @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                                <el-button
                                        size="small"
                                        type="danger"
                                        @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                    <el-pagination
                            @size-change="handleSizeChange"
                            @current-change="handleCurrentChange"
                            :current-page=currentPage
                            :page-sizes="[10]"
                            :page-size="size"
                            layout="total, prev, pager, next, jumper"
                            :total="total">
                    </el-pagination>
                </template>
            </form>
            <el-dialog title="添加场地信息" :visible.sync="dialogFormVisible">
                <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="场地名称" prop="name">
                        <el-input type="text" v-model="ruleForm2.name" auto-complete="off" placeholder="请输入企业名称"></el-input>
                    </el-form-item>
                    <el-form-item label="联系人" prop="contacter">
                        <el-input type="text" v-model="ruleForm2.contacter" auto-complete="off" placeholder="请输入车队名称"></el-input>
                    </el-form-item>
                    <el-form-item label="场地类型" prop="type">
                        <el-radio-group v-model="ruleForm2.type">
                            <el-radio class="radio" label = "1" >建筑工地</el-radio>
                            <el-radio class="radio" label = "2" >垃圾中转站</el-radio>
                            <el-radio class="radio" label = "3" >垃圾焚烧厂及处理厂</el-radio>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item label="状态" prop="status">
                        <el-radio-group v-model="ruleForm2.status">
                            <el-radio class="radio" label = "1" >启用</el-radio>
                            <el-radio class="radio" label = "0" >冻结</el-radio>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item label="点的坐标" prop="places">
                        <el-button @click = "dialogFormVisiblePosition = true">获取点的坐标</el-button>
                        <el-input type = "text" :readonly=true  v-model="ruleForm2.places"></el-input>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button type="primary" :disabled="isSubmit" @click="submitForm('ruleForm2')">提交</el-button>
                    <el-button @click="dialogFormVisible = false">取消</el-button>
                </div>
            </el-dialog>
            <el-dialog title="编辑场地信息" :visible.sync="dialogFormVisibleEdit">
                <el-form :model="ruleFormEdit" :rules="rulesEdit" ref="ruleFormEdit" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="场地名称" prop="name">
                        <el-input type="text" v-model="ruleFormEdit.name" auto-complete="off" placeholder="请输入企业名称"></el-input>
                    </el-form-item>
                    <el-form-item label="联系人" prop="contacter">
                        <el-input type="text" v-model="ruleFormEdit.contacter" auto-complete="off" placeholder="请输入联系人"></el-input>
                    </el-form-item>
                    <el-form-item label="场地类型" prop="type">
                        <el-radio-group v-model="ruleFormEdit.type">
                            <el-radio class="radio" label = "1" >建筑工地</el-radio>
                            <el-radio class="radio" label = "2" >垃圾中转站</el-radio>
                            <el-radio class="radio" label = "3" >垃圾焚烧厂及处理厂</el-radio>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item label="状态" prop="status">
                        <el-radio-group v-model="ruleFormEdit.status">
                            <el-radio class="radio" label = "1" >启用</el-radio>
                            <el-radio class="radio" label = "0" >冻结</el-radio>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item label="点的坐标" prop="place">
                        <el-button @click = "dialogFormVisiblePosition = true">获取点的坐标</el-button>
                        <el-input type = "text" :readonly=true v-model="ruleFormEdit.places"></el-input>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <!--<el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>-->
                    <el-button type="primary" @click="submitFormEdit('ruleFormEdit')">提交</el-button>
                    <el-button @click="dialogFormVisibleEdit = false">取消</el-button>
                </div>
            </el-dialog>

            <el-dialog title="选择场地坐标" :visible.sync="dialogFormVisiblePosition">
                <template>
                    <div class="amap-page-container">
                        <el-amap
                            ref="map"
                            vid="amapDemo"
                            :center="center"
                            :zoom="zoom"
                            class="amap-demo"
                            :amap-manager="amapManager"
                            :events="events">
                            <el-amap-marker v-for="marker in markers" :position="marker.position" :events="marker.events" :visible="marker.visible" :draggable="marker.draggable">

                            </el-amap-marker>
                            <el-amap-polygon v-for="(polygon, index) in polygons" :vid="index" :ref="`polygon_${index}`" :path="polygon.path" :events="polygon.events">

                            </el-amap-polygon>
                        </el-amap>
                        <div class="toolbar">
                            <!--position: [{{ lng }}, {{ lat }}] address: {{ address }}-->
                            <el-button type="primary" @click="resetMap">重置地图</el-button>
                        </div>
                    </div>
                </template>
                <div slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="getPosition">提交</el-button>
                    <el-button @click="dialogFormVisiblePosition = false">取消</el-button>
                </div>
            </el-dialog>

        </div>
</template>

<script>
    import { AMapManager } from 'vue-amap';
    import { mapGetters, mapActions } from 'vuex'
    import * as actions from '../../store/modules/placeinfo/actions'
    let amapManager = new AMapManager();
    export default{

        data:function() {
            let self = this;
            return {
                loading:true,
                currentPage: 1,
                input: '',
                height:"",
                size:10,
                selection: [],
                dialogFormVisible: false,
                dialogFormVisibleEdit : false,
                form: {
                    name: '',
                    region: '',
                    date1: '',
                    date2: '',
                    delivery: false,
                    type: "",
                    resource: '',
                    desc: ''
                },
                formLabelWidth: '120px',
                ruleForm2: {
                    name :"",
                    contacter: '',
                    type:"1",
                    status:"1",
                    places:"",
                },

                ruleFormEdit:{

                },
                isSubmit:false,
                rulesEdit:{},
                rules2: {
                    // companyName contacter status
                    name: [
                        { required: true, message: '请输入场地名称', trigger: 'blur' },
                    ],
                    companyName: [
                        { required: true, message: '请输入企业名称', trigger: 'blur' },
                    ],
                    contacter: [
                        { required: true, message: '请输入联系人', trigger: 'blur' }
                    ],
                    type: [
                        { required: true, message: '请选择场地类型', trigger: 'change' }
                    ],
                    status: [
                        { required: true, message: '请选择状态', trigger: 'change' }
                    ],
                    places:[
                        { required: true, message: '请选取点的坐标', trigger: 'blur' }
                    ],
                },
                dialogFormVisiblePosition:false,
                zoom: 12,
                center: [121.59996, 31.197646],

                address: '',
                markers :[],
                markerIndex:0,
                amapManager: amapManager,
                polygons: [{
                    path: [],
                    events: {
                        click: () => {

                        }
                    }
                }],

                events: {
                    click(e) {
                        let { lng, lat } = e.lnglat;
                        self.lng = lng;
                        self.lat = lat;

                        // 这里通过高德 SDK 完成。
                        var geocoder = new AMap.Geocoder({
                            radius: 1000,
                            extensions: "all"
                        });
                        geocoder.getAddress([lng ,lat], function(status, result) {
                            if (status === 'complete' && result.info === 'OK') {
                                if (result && result.regeocode) {
                                    self.address = result.regeocode.formattedAddress;
                                    self.$nextTick(() => {
                                        let marker = {
                                            position: [lng,lat],
                                            events: {
                                                click: (e) => {
//                                                    alert('click marker');
                                                    if (!self.markers.length) return;
                                                    console.log(self.markers)
                                                    console.log(self.markerIndex)
//                                                    self.markers.splice(self.markerIndex, 1);
//                                                    self.markers.splice(self.markers.length - 1, 1);
//                                                    let p = [e.lnglat.lng, e.lnglat.lat];
//                                                    $.each(self.markers,(i,v) => {
//                                                        console.log(i,v)
//                                                        console.log(p)
//                                                        console.log(self.markers[i].position)
//                                                        if(p === self.markers[i].position){
//                                                            console.log(i,self.markers[i])
//                                                        }
//                                                    })

                                                },
                                                dragend: (e) => {
                                                    self.markers[0].position = [e.lnglat.lng, e.lnglat.lat];
                                                }
                                            },
                                            visible: true,
                                            draggable: false,
                                            markerIndex:self.markerIndex++,
                                        };

                                        self.markers.push(marker);
                                        // 画出地块

                                        self.polygons[0].path.push([lng,lat]);
                                        console.log( self.polygons[0].path)
                                    });
                                }
                            }
                        });
                    }
                },
                lng: 0,
                lat: 0,
            };
        },
        methods: {
            searchCarInfo(){
                this.queryPlaceInfo({
                    page:this.currentpage,
                    input:this.input
                });
            },
            formatter(row, column) {
                return row.address;
            },
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                this.currentpage = val;
                this.queryPlaceInfo({
                    page:val
                });
            },
            // 添加信息
            addInfo(formName){
                this.dialogFormVisible = true;
                this.$nextTick(() => {
                    this.$refs[formName].resetFields();
                })


            },
            // 编辑
            handleEdit(index, row) {
                this.dialogFormVisibleEdit = true;
                this.ruleFormEdit = row;
            },
            submitFormEdit(){
                this.saveOrUpdatePlaceInfo(this.ruleFormEdit).then(() => this.successEdit());
            },
            // 删除
            handleDelete(index, row) {
                this.$confirm('是否删除该条信息', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deletePlaceInfo({
                        id : row.id
                    }).then(() => {
                        this.queryPlaceInfo({
                            page:this.currentpage
                        }).then(() => {
                            this.$message({
                                type: 'success',
                                message: '删除成功!'
                            });
                        });
                    });
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },
            // 勾选
            selectionChange(selection){
                this.selection = selection;
            },
            // 点击删除操作
            allDelete(){
                var _this = this;
                var ids = [];
                if(this.selection != "") {
                    this.$confirm('是否删除全部信息', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        $.each(_this.selection, function (i, v) {
                            ids.push(_this.selection[i].id);
                        })
                        console.log(ids);
                        this.batchDeletePlaceInfo({items:ids}).then(() => {
                            this.queryPlaceInfo({
                                page: this.currentpage
                            }).then(() => {
                                this.$message({
                                    type: 'success',
                                    message: '删除成功!'
                                });
                            });
                        });


                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: '已取消删除'
                        });
                    });
                }else{
                    this.$message.error("请勾选信息");
                }
            },
            // 添加
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.saveOrUpdatePlaceInfo(this.ruleForm2).then(() => {
                            this.successSubmit();
                            this.$refs[formName].resetFields();
                        });
                    } else {
                        this.cancelSubmit();
                        return false;
                    }
                })
            },
            successSubmit () {
                this.queryPlaceInfo({}).then(() => {
                    this.$message({
                        type: 'success',
                        message: '添加成功!'
                    });
                    this.dialogFormVisible = false;
                });
            },
            //取消操作
            cancelSubmit(){
                this.$message({
                    type: 'info',
                    message: '取消操作'
                });
            },
            // 修改成功
            successEdit () {
                this.queryPlaceInfo({}).then(() => {
                    this.$message({
                        type: 'success',
                        message: '编辑成功!'
                    });
                    this.dialogFormVisibleEdit = false;
                });
            },
            failEdit(){
                this.$message({
                    type: 'info',
                    message: '编辑失败!'
                });
                this.dialogFormVisibleEdit = false;
            },
            // 控制地图显示
            resetMap(){
                this.polygons[0].path = [];
                this.markers = [];
            },
            // 获取点的坐标
            getPosition(){
                // 判断地图里面至少有三个点
                if(this.polygons[0].path.length < 3){
                    this.$message({
                        type: 'info',
                        message: '请至少选择三个点'
                    });
                    this.resetMap();
                }else{
                    this.$message({
                        type: 'success',
                        message: '坐标选取成功!'
                    });
                    var position = String(this.polygons[0].path);
                    console.log(String(position));
                    this.ruleForm2.places = position;
                }
                this.dialogFormVisiblePosition = false;

            },
            //action方法
            ...mapActions([
                'queryPlaceInfo',
                'findByPlaceInfoId',
                'saveOrUpdatePlaceInfo',
                'deletePlaceInfo',
                'batchDeletePlaceInfo'
            ]),
        },
        mounted(){
            let _this = this;
            // 控制表格高度
            this.height = $(".tabclick").height() - $(".form_nav").height() - 80;
            this.queryPlaceInfo({}).then(() => {
                _this.loading = false;
            });


        },
        computed:{
            ...mapGetters({
                tableData: "getPlaceInfos",
                total : "getPlaceInfoTotal",
                current: "getCurrentPlaceInfo"
            })
        },
    }
</script>

<style lang="scss" scoped rel="stylesheet/scss">
    .amap-demo {
        height: 300px;
    }
    .form_nav{
        > div{
            background:#eff4f8;
            height:100%;
            width: calc(100% - 15px);
            padding: 0 15px;
            .wrapper{
                line-height:60px;
            }
        }
        background:#fff;
        height:80px;
        padding: 10px 0;
        margin:10px 0;
    }
</style>
