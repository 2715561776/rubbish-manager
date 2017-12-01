<template>
    <div class="el-col el-col-24 el-col-xs-24 el-col-sm-24 tabclick" style="height:calc(100% - 80px);position: absolute;
    padding: 0 15px;background: #fff;">
        <div class="form_nav el-col el-col-24 el-col-xs-24 el-col-sm-24">
            <div>
                 <span class="wrapper">
                    <el-form :inline="true" :model="formInline" class="demo-form-inline" ref = "formInline" :rules="rules2">
                          <el-form-item label="司机">
                              <el-autocomplete
                                      v-model="formInline.inputDriverName"
                                      :fetch-suggestions="querySearch"
                                      :trigger-on-focus="false"
                                      @select="handleSelect"
                                      placeholder="请输入司机称谓"
                              >

                              </el-autocomplete>
                          </el-form-item>
                        <el-form-item label="车牌号码">
                                <el-input v-model="formInline.licensePlatNumber" placeholder="请输入车牌号码" :readonly="true"></el-input>
                        </el-form-item>
                         <el-form-item label="垃圾重量">
                                <el-input v-model="formInline.estimateWeight" placeholder="请输入垃圾重量"></el-input>
                          </el-form-item>
                        <el-form-item label="场地">
                            <el-autocomplete
                                    v-model="formInline.inputPlaceInfoName"
                                    :fetch-suggestions="querySearchPlace"
                                    :trigger-on-focus="false"
                                    @select="handleSelectPlace"
                                    placeholder="请输入场地"
                            ></el-autocomplete>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click.capture="submitForm('formInline')">确定</el-button>
                        </el-form-item>
                    </el-form>
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
                        @selection-change="selectionChange"
                        :height="height"
                        style="width: 100%">
                    <el-table-column
                            type="selection"
                            align="center"
                            width="55">
                    </el-table-column>

                    <el-table-column
                            label="司机"
                            align="center"

                    >
                        <template scope="scope">
                            {{ scope.row.driver}}
                        </template>
                    </el-table-column>


                    <el-table-column
                            label="车牌号码"
                            align="center"

                    >
                        <template scope="scope">
                            {{ scope.row.cardNumber}}
                        </template>
                    </el-table-column>

                    <el-table-column
                            label="司机手机号"
                            align="center"

                    >
                        <template scope="scope">
                            {{ scope.row.driverPhone}}
                        </template>
                    </el-table-column>

                    <el-table-column
                            label="垃圾重量（吨）"
                            align="center"

                    >
                        <template scope="scope">
                            {{ scope.row.weight}}
                        </template>
                    </el-table-column>

                    <el-table-column
                            label="设备卡号"
                            align="center"

                    >
                        <template scope="scope">
                            {{ scope.row.facilityNo}}
                        </template>
                    </el-table-column>

                    <el-table-column
                            label="场地ID"
                            align="center"

                    >
                        <template scope="scope">
                            {{ scope.row.placeId}}
                        </template>
                    </el-table-column>

                    <el-table-column prop="placeInfo.name" label="场地ID" align="center">
                    </el-table-column>

                    <el-table-column label="操作"
                                     align="center"
                                     min-width="80"
                    >
                        <template scope="scope">
                            <el-button
                                    size="small"
                                    @click="handleEdit(scope.$index, scope.row)">编辑
                            </el-button>
                            <el-button
                                    size="small"
                                    type="danger"
                                    @click="handleDelete(scope.$index, scope.row)">删除
                            </el-button>
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
        <el-dialog title="编辑场地信息" :visible.sync="dialogFormVisibleEdit">
            <el-form :model="ruleFormEdit" :rules="rulesEdit" ref="ruleFormEdit" label-width="100px"
                     class="demo-ruleForm">

                <el-form-item label="垃圾重量（吨）" prop="weight">
                    <el-input type="text" v-model="ruleFormEdit.weight" auto-complete="off"
                              placeholder="请输入垃圾重量（吨）"></el-input>
                </el-form-item>

                <el-form-item label="车辆ID" prop="vehicleId" v-show= "false">
                    <el-input type="text"
                              v-model="ruleFormEdit.vehicleId"
                              auto-complete="off"
                              placeholder="请输入车辆ID"></el-input>
                </el-form-item>

                <el-form-item label="车牌号码" prop="cardNumber">
                    <el-input type="text" v-model="ruleFormEdit.cardNumber" auto-complete="off"
                              placeholder="请输入车牌号码"
                              :readonly="true"
                    ></el-input>
                </el-form-item>

                <el-form-item label="司机">
                    <el-autocomplete
                            class="inline-input"
                            v-model="ruleFormEdit.driver"
                            :fetch-suggestions="querySearch"
                            :trigger-on-focus="false"
                            @select="handleSelect"
                            placeholder="请输入司机称谓"
                    >

                    </el-autocomplete>
                </el-form-item>


                <el-form-item label="预约司机手机号" prop="driverPhone">
                    <el-input type="text" v-model="ruleFormEdit.driverPhone" auto-complete="off"
                              placeholder="请输入预约司机手机号"></el-input>
                </el-form-item>

                <el-form-item label="设备ID" prop="facilityId">
                    <el-input type="text" v-model="ruleFormEdit.facilityId" auto-complete="off"
                              placeholder="请输入设备ID"></el-input>
                </el-form-item>

                <el-form-item label="设备卡号" prop="facilityNo">
                    <el-input type="text"
                              v-model="ruleFormEdit.facilityNo"
                              :readonly="true"
                              auto-complete="off"
                              placeholder="请输入设备卡号"></el-input>
                </el-form-item>

                <el-form-item label="场地ID" prop="placeId" v-show= "false">
                    <el-input type="text"
                              v-model="ruleFormEdit.placeId"
                              auto-complete="off"
                              placeholder="请输入场地ID"></el-input>
                </el-form-item>

                <el-form-item label="场地">
                    <el-autocomplete
                            class="inline-input"
                            v-model="ruleFormEdit1.name"
                            :fetch-suggestions="querySearchPlace"
                            :trigger-on-focus="false"
                            @select="handleSelectPlace"
                            placeholder="请输入场地"
                    ></el-autocomplete>
                </el-form-item>


            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="submitFormEdit('ruleFormEdit')">提交</el-button>
                <el-button @click="dialogFormVisibleEdit = false">取消</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'
    import * as actions from '../../store/modules/transferstationapply/actions'
    export default{

        data() {
            return {
                loading: true,
                currentPage: 1,
                input: '',
                height: "",
                size: 10,
                selection: [],
                dialogFormVisible: false,
                dialogFormVisibleEdit: false,
                formInline: {
                    inputDriverName: '',
                    licensePlatNumber:"",
                    estimateWeight:"",
                    arrivalTime:"",
                    inputPlaceInfoName:"",
                },
                form: {
                    name: '',
                    region: '',
                    date1: '',
                    date2: '',
                    delivery: false,
                    type: [],
                    resource: '',
                    desc: ''
                },
                formLabelWidth: '120px',
                ruleFormEdit: {},
                ruleFormEdit1: {
                    name:"",
                },

                isSubmit: false,
                rulesEdit: {},
                rules2: {
                    weight: [
                        {required: false, message: '请输入垃圾重量（吨）', trigger: 'blur'}
                    ],
                    vehicleId: [
                        {required: false, message: '请输入车辆ID', trigger: 'blur'}
                    ],
                    cardNumber: [
                        {required: false, message: '请输入车牌号码', trigger: 'blur'}
                    ],
                    driver: [
                        {required: false, message: '请输入司机', trigger: 'blur'}
                    ],
                    driverPhone: [
                        {required: false, message: '请输入司机手机号', trigger: 'blur'}
                    ],
                    facilityId: [
                        {required: false, message: '请输入设备ID', trigger: 'blur'}
                    ],
                    facilityNo: [
                        {required: false, message: '请输入设备卡号', trigger: 'blur'}
                    ],

                    placeId: [
                        {required: false, message: '请输入场地ID', trigger: 'blur'}
                    ],

                },
                cbRes: [
                ],
                cbResPlace: [
                ],
                selectRes :
                    {
                        vehicleId:"",
                        placeInfoId:""
                    }
            };
        },
        methods: {
            querySearch(queryString, cb) {
                var _this = this;
                this.cbRes = [];
                this.findVehicleByInputDriverName({
                     inputDriverName: queryString
                }).then(() => {
                    console.log(this.vehicleList);
                    var res = _this.vehicleList;
                    $.each(res,function(i,v){
                        var driverName = res[i].driverName;
                        var licensePlatNumber = res[i].licensePlatNumber;
                        let id = res[i].id
                        _this.cbRes.push({
                            value:driverName,
                            licensePlatNumber:licensePlatNumber,
                            id : id
                        })
//                        var results = queryString ? _this.cbRes : queryString;
                        cb(_this.cbRes);
                    })
                });
            },
            querySearchPlace(queryString, cb) {
                var _this = this;
                this.cbResPlace = [];
                this.findPlaceInfoByName({
                     inputPlaceInfoName: queryString
                }).then(() => {
                    var res = _this.placeNameList;
                    $.each(res,function(i,v){
                        var inputPlaceInfoName = res[i].name;
                        console.log(res[i])
                        let id = res[i].id
                        _this.cbResPlace.push({
                            value:inputPlaceInfoName,
                            id : id
                        })
                    })
                    cb(_this.cbResPlace);
                });
            },
            handleSelect(item) {
                console.log(item)
                this.formInline.licensePlatNumber = item.licensePlatNumber;
                this.selectRes.vehicleId = item.id;

                this.ruleFormEdit.vehicleId = item.id;

            },
            handleSelectPlace(item) {
                console.log(item)
                this.formInline.inputPlaceInfoName = item.value;
                this.selectRes.placeInfoId = item.id;

                this.ruleFormEdit.placeId = item.id;
            },

            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                this.currentpage = val;
                this.queryTransferStationApply({
                    page:val
                });
            },
            // 编辑
            handleEdit(index, row) {
                this.dialogFormVisibleEdit = true;
                this.ruleFormEdit = row;
                this.ruleFormEdit1=row.placeInfo;
                console.log(row)
            },
            submitFormEdit(){
                this.saveOrUpdateTransferStationApply(this.ruleFormEdit).then(() => this.successEdit());
            },
            // 删除
            handleDelete(index, row) {
                this.$confirm('是否删除该条信息', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteTransferStationApply({
                        id : row.id
                    }).then(() => {
                        this.queryTransferStationApply({
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
                if (this.selection != "") {
                    this.$confirm('是否删除全部信息', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        $.each(_this.selection, function (i, v) {
                            ids.push(_this.selection[i].id);
                        })
                        console.log(ids);
                        this.batchDeleteTransferStationApply({items:ids}).then(() => {
                            this.queryTransferStationApply({
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
                } else {
                    this.$message.error("请勾选信息");
                }
            },
            // 添加
            submitForm(formName) {
                let weight = Number(this.formInline.estimateWeight);
                let vehicleId = this.selectRes.vehicleId;
                let placeInfoId = this.selectRes.placeInfoId
                if (weight != "" && vehicleId != "" && placeInfoId != "" && !isNaN(weight) ) {
                    this.saveOrUpdateTransferStationApply({
                        vehicleId: vehicleId,
                        placeInfoId: placeInfoId,
                        weight: weight,
                    }).then(() => {
                        this.successSubmit()
                        this.$refs[formName].resetFields();
                    });
                } else {
                    this.cancelSubmit();
                }
            },
            successSubmit () {
                this.queryTransferStationApply({}).then(() => {
                    this.dialogFormVisible = false;
                    this.$message({
                        type: 'success',
                        message: '添加成功!'
                    });
                });
            },
            //取消操作
            cancelSubmit(){
                this.$message({
                    type: 'info',
                    message: '请填写完整信息'
                });
            },
            // 修改成功
            successEdit () {
                this.queryTransferStationApply({}).then(() => {
                    this.dialogFormVisibleEdit = false;
                    this.$message({
                        type: 'success',
                        message: '编辑成功!'
                    });
                });

            },
            failEdit(){
                this.$message({
                    type: 'info',
                    message: '编辑失败!'
                });
                this.dialogFormVisibleEdit = false;
            },
            //action方法
            ...mapActions([
                'findPlaceInfoByName',
                'findVehicleByInputDriverName',
                'queryTransferStationApply',
                'findByTransferStationApplyId',
                'saveOrUpdateTransferStationApply',
                'deleteTransferStationApply',
                'batchDeleteTransferStationApply'
            ]),
        },
        mounted(){
            var _this = this;
            // 控制表格高度
            this.height = $(".tabclick").height() - $(".form_nav").height() - 80;
            this.queryTransferStationApply({}).then(() => {
                _this.loading = false;
            });
        },
        computed: {
            ...mapGetters({
                placeNameList:"getPlaceInfoByName",
                vehicleList: "getVehicleByInputDriverName",
                tableData: "getTransferStationApplys",
                total: "getTransferStationApplyTotal",
                current: "getCurrentTransferStationApply"
            })
        },
    }
</script>

<style lang="scss" scoped rel="stylesheet/scss">
    .form_nav {
        > div {
            background: #eff4f8;
            height: 100%;
            padding: 0 15px;
            .wrapper {
                background: red;
                .el-form {
                    padding: 0 15px;
                    .el-form-item {
                        margin-top: 22px;
                        margin-right:20px;
                    }
                }
            }
        }
        background: #fff;
        padding: 10px 0;
    }
</style>
