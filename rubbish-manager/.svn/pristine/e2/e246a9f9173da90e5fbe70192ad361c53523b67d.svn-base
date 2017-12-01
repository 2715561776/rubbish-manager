<template>
    <div class="el-col el-col-24 el-col-xs-24 el-col-sm-22 tabclick" style="height:100%">
        <div class="form_nav el-col el-col-24 el-col-xs-24 el-col-sm-24">
            <div>
             <span class="wrapper" style="float:left;">
                    <el-button type="primary" @click.stop="addInfo('ruleForm2')">添加预约</el-button>
                    <el-button type="danger" @click.stop="allDelete">全部删除</el-button>
              </span>
                <span class="wrapper" style="float:right;">
                        <el-button type="primary" @click.stop="searchCarInfo">查找</el-button>
                      </span>
                <span class="wrapper" style="float:right;margin-right:20px;">
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
                        @selection-change="selectionChange"
                        :height="height"
                        style="width: 100%">
                    <el-table-column
                            type="selection"
                            align="center"
                            width="55">
                    </el-table-column>

                    <el-table-column
                            label="预计垃圾重量（吨）"
                            align="center"

                    >
                        <template scope="scope">
                            {{ scope.row.estimateWeight}}
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
                            label="预约司机"
                            align="center"

                    >
                        <template scope="scope">
                            {{ scope.row.estimateDriver}}
                        </template>
                    </el-table-column>


                    <el-table-column
                            label="预约司机手机号"
                            align="center"

                    >
                        <template scope="scope">
                            {{ scope.row.estimateDriverPhone}}
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
                            label="预计到达时间"
                            align="center"
                            min-width="110"
                    >
                        <template scope="scope">
                            <!--<el-icon name="time"></el-icon>-->
                            <span style="margin-left: 10px">{{scope.row.arrivalTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}')}}</span>
                        </template>
                    </el-table-column>


                    <el-table-column
                            label="实际到达时间"
                            align="center"
                            min-width="110"
                    >
                        <template scope="scope">
                            <!--<el-icon name="time"></el-icon>-->
                            <span style="margin-left: 10px">{{scope.row.actualTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}')}}</span>
                        </template>
                    </el-table-column>

                    <el-table-column prop="placeInfo.name" label="预约场地ID" align="center">
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
        <el-dialog title="添加预约" :visible.sync="dialogFormVisible">
            <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
                <el-form-item label="预计垃圾重量（吨）" prop="estimateWeight">
                    <el-input type="text" v-model="ruleForm2.estimateWeight" auto-complete="off"
                              placeholder="请输入预计垃圾重量（吨）"></el-input>
                </el-form-item>


                <el-form-item label="车牌号码" prop="cardNumber">
                    <el-input type="text" v-model="ruleForm2.cardNumber" auto-complete="off" placeholder="请选择输入预约司机"
                              :readonly="true"></el-input>
                </el-form-item>


                <el-form-item label="预约司机">
                    <el-autocomplete
                            class="inline-input"
                            v-model="ruleForm2.estimateDriver"
                            :fetch-suggestions="querySearch"
                            :trigger-on-focus="false"
                            @select="handleSelect"
                            placeholder="请选择输入预约司机"
                    >

                    </el-autocomplete>
                </el-form-item>

                <el-form-item label="预约司机手机号" prop="estimateDriverPhone">
                    <el-input type="text" v-model="ruleForm2.estimateDriverPhone" auto-complete="off"
                              placeholder="请选择输入预约司机" :readonly="true"></el-input>
                </el-form-item>

                <el-form-item label="设备卡号" prop="facilityNo">
                    <el-input type="text" v-model="ruleForm2.facilityNo" auto-complete="off" placeholder="请选择输入预约司机"
                              :readonly="true"></el-input>
                </el-form-item>


                <el-form-item label="预计到达时间" prop="arrivalTime">
                    <el-date-picker
                            v-model="ruleForm2.arrivalTime"
                            type="datetime"
                            placeholder="请输入最早到达时间">
                    </el-date-picker>
                </el-form-item>

                <el-form-item label="实际到达时间" prop="actualTime">
                    <el-date-picker
                            v-model="ruleForm2.actualTime"
                            type="datetime"
                            placeholder="请输入实际到达时间">
                    </el-date-picker>
                </el-form-item>

                <el-form-item label="预约场地ID" prop="placeId" v-show=false>
                    <el-input type="text" v-model="ruleForm2.placeId" auto-complete="off"
                              placeholder="请输入预约场地ID"></el-input>
                </el-form-item>

                <el-form-item label="场地">
                    <el-autocomplete
                            class="inline-input"
                            v-model="ruleForm2.inputPlaceInfoName"
                            :fetch-suggestions="querySearchPlace"
                            :trigger-on-focus="false"
                            @select="handleSelectPlace"
                            placeholder="请选择输入场地"
                    ></el-autocomplete>
                </el-form-item>


            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" :disabled="isSubmit" @click="submitForm('ruleForm2')">提交</el-button>
                <el-button @click="dialogFormVisible = false">取消</el-button>
            </div>
        </el-dialog>
        <el-dialog title="编辑场地信息" :visible.sync="dialogFormVisibleEdit">
            <el-form :model="ruleFormEdit" :rules="rulesEdit" ref="ruleFormEdit" label-width="100px"
                     class="demo-ruleForm">
                <el-form-item label="预计垃圾重量（吨）" prop="estimateWeight">
                    <el-input type="text" v-model="ruleFormEdit.estimateWeight" auto-complete="off"
                              placeholder="请输入预计垃圾重量（吨）"></el-input>
                </el-form-item>


                <el-form-item label="车牌号码" prop="cardNumber">
                    <el-input type="text" v-model="ruleFormEdit.cardNumber" auto-complete="off" placeholder="请输入车牌号码"
                              :readonly="true"></el-input>
                </el-form-item>


                <el-form-item label="预约司机">
                    <el-autocomplete
                            class="inline-input"
                            v-model="ruleFormEdit.estimateDriver"
                            :fetch-suggestions="querySearch"
                            :trigger-on-focus="false"
                            @select="handleSelect"
                            placeholder="请输入司机称谓"
                    >

                    </el-autocomplete>
                </el-form-item>

                <el-form-item label="预约司机手机号" prop="estimateDriverPhone">
                    <el-input type="text" v-model="ruleFormEdit.estimateDriverPhone" auto-complete="off"
                              placeholder="请输入预约司机手机号" :readonly="true"></el-input>
                </el-form-item>


                <el-form-item label="设备卡号" prop="facilityNo">
                    <el-input type="text" v-model="ruleFormEdit.facilityNo" auto-complete="off" placeholder="请输入设备卡号"
                              :readonly="true"></el-input>
                </el-form-item>


                <el-form-item label="预计到达时间" prop="arrivalTime">
                    <el-date-picker
                            v-model="ruleFormEdit.arrivalTime"
                            type="datetime"
                            placeholder="请输入预计到达时间">
                    </el-date-picker>
                </el-form-item>

                <el-form-item label="实际到达时间" prop="actualTime">
                    <el-date-picker
                            v-model="ruleFormEdit.actualTime"
                            type="datetime"
                            placeholder="请输入实际到达时间">
                    </el-date-picker>
                </el-form-item>

                <el-form-item label="预约场地ID" prop="placeId" v-show=false>
                    <el-input type="text" v-model="ruleFormEdit.placeId" auto-complete="off"
                              placeholder="请输入预约场地ID"></el-input>
                </el-form-item>

                <el-form-item label="场地">
                    <el-autocomplete
                            v-model="ruleFormEdit1.name"
                            :fetch-suggestions="querySearchPlace"
                            :trigger-on-focus="false"
                            @select="handleSelectPlace"
                            placeholder="请输入场地"
                    ></el-autocomplete>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <!--<el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>-->
                <el-button type="primary" @click="submitFormEdit('ruleFormEdit')">提交</el-button>
                <el-button @click="dialogFormVisibleEdit = false">取消</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'
    import * as actions from '../../store/modules/vehicleappoint/actions'
    import * as actions1 from '../../store/modules/transferstationapply/actions'
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
                placeIdIsShow: false,
                ruleForm2: {
                    inputDriverName: '',
                    driverPhone: "",
                    licensePlatNumber: "",
                    simNo: "",
                    estimateWeight: "",
                    arrivalTime: "",
                    inputPlaceInfoName: "",
                    actualTime:"",
                },
                ruleFormEdit: {

                },
                ruleFormEdit1: {
                    name:"",
                },

                isSubmit: false,
                rulesEdit: {},
                rules2:{},
                selectRes: {
                    vehicleId: "",
                    placeInfoId: ""
                },
                formInline: {
                    inputDriverName: '',
                    driverPhone: '',
                    licensePlatNumber: "",
                    simNo: "",
                    estimateWeight: "",
                    arrivalTime: "",
                    inputPlaceInfoName: "",
                },
            };
        },
        methods: {
            // 添加信息
            addInfo(formName){
                this.dialogFormVisible = true;
                this.$nextTick(() => {
                    this.$refs[formName].resetFields();
                })
            },
            searchCarInfo(){
                this.queryVehicleAppoint({
                    page:this.currentpage,
                    input:this.input
                });
            },
            querySearch(queryString, cb) {
                var _this = this;
                this.cbRes = [];
                this.formInline.licensePlatNumber = "",
                this.findVehicleByInputDriverName({
                    inputDriverName: queryString
                }).then(() => {
                    var res = _this.vehicleList;
                    $.each(res, function (i, v) {
                        var driverName = res[i].driverName;
                        var licensePlatNumber = res[i].licensePlatNumber;
                        var driverPhone = res[i].driverPhone;
                        var facilityNo = res[i].facilityNo;
                        _this.cbRes.push({
                            value: driverName,
                            licensePlatNumber: licensePlatNumber,
                            driverPhone: driverPhone,
                            facilityNo: facilityNo
                        })
                    })
                    console.log(_this.cbRes+"_this.cbRes")
                    cb(_this.cbRes);
                });

            },
            querySearchPlace(queryString, cb) {
                var _this = this;
                this.cbResPlace = [];
                this.formInline.inputPlaceInfoName = "",
                this.findPlaceInfoByName({
                    inputPlaceInfoName: queryString
                }).then(() => {
                    var res = _this.placeNameList;
                    console.log(res);
                    $.each(res, function (i, v) {
                        var inputPlaceInfoName = res[i].name;
                        let id = res[i].id
                        _this.cbResPlace.push({
                            value: inputPlaceInfoName,
                            id: id
                        })
                    })
                    console.log(_this.cbResPlace + "cbResPlace");
                    cb(_this.cbResPlace);
                });

            },
            handleSelect(item) {
                console.info(item);
                var licensePlatNumber = item.licensePlatNumber;
                console.info(licensePlatNumber);
                var driverPhone = item.driverPhone;
                var facilityNo = item.facilityNo;
                this.ruleFormEdit.cardNumber = licensePlatNumber;
                this.ruleFormEdit.estimateDriverPhone = driverPhone;
                this.ruleFormEdit.facilityNo = facilityNo;
                this.ruleForm2.cardNumber = licensePlatNumber;
                this.ruleForm2.estimateDriverPhone = driverPhone;
                this.ruleForm2.facilityNo = facilityNo;
            },
            handleSelectPlace(item){
                var id = item.id;
                this.ruleFormEdit.placeId = id;
                this.ruleForm2.placeId = id;
            },
            searchCarInfo(){
                this.queryVehicleAppoint({
                    page: this.currentpage,
                    input: this.input
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
                this.queryVehicleAppoint({
                    page: val
                });
            },
            // 编辑
            handleEdit(index, row) {
                this.ruleFormEdit = row;
                this.ruleFormEdit1=row.placeInfo;
                this.dialogFormVisibleEdit = true;
            },
            submitFormEdit(){
                this.saveOrUpdateVehicleAppoint(this.ruleFormEdit).then(() => this.successEdit());
            },
            // 删除
            handleDelete(index, row) {
                this.$confirm('是否删除该条信息', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteVehicleAppoint({
                        id: row.id
                    }).then(() => {
                        this.queryVehicleAppoint({
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
                        this.batchDeleteVehicleAppoint({items: ids}).then(() => {
                            this.queryVehicleAppoint({
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
                this.saveOrUpdateVehicleAppoint(this.ruleForm2).then(() => {
                    this.successSubmit()
                    this.$refs[formName].resetFields();
                });
            },
            successSubmit () {
                this.queryVehicleAppoint({}).then(() => {
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
                    message: '取消操作'
                });
            },
            // 修改成功
            successEdit () {
                this.queryVehicleAppoint({}).then(() => {
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
                'queryVehicleAppoint',
                'findVehicleByInputDriverName',
                'findByVehicleAppointId',
                'saveOrUpdateVehicleAppoint',
                'deleteVehicleAppoint',
                'batchDeleteVehicleAppoint'
            ]),
        },
        mounted(){
            let _this = this;
            // 控制表格高度
            this.height = $(".tabclick").height() - $(".form_nav").height() - 80;
            this.queryVehicleAppoint({}).then(() => {
                _this.loading = false;
            });
            console.log(this.tableData)
        },
        computed: {
            ...mapGetters({
                placeNameList: "getPlaceInfoByName",
                vehicleList: "getVehicleByInputDriverName",
                tableData: "getVehicleAppoints",
                total: "getVehicleAppointTotal",
                current: "getCurrentVehicleAppoint"
            })
        },
    }
</script>

<style lang="scss" scoped rel="stylesheet/scss">
    .form_nav {
        > div {
            background: #eff4f8;
            height: 100%;
            width: calc(100% - 15px);
            padding: 0 15px;
            .wrapper {
                line-height: 60px;
            }
        }
        background: #fff;
        height: 80px;
        padding: 10px 0;
        margin: 10px 0;
    }
</style>
