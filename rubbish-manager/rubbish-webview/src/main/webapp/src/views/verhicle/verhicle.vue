<template>
    <div class="el-col el-col-24 el-col-xs-24 el-col-sm-22 tabclick" style="height:100%">
        <div class="form_nav el-col el-col-24 el-col-xs-24 el-col-sm-24">
            <div>
                     <span class="wrapper" style="float:left;">
                        <el-button type="primary" @click.stop="addInfo('ruleForm2')">添加车辆</el-button>
                        <el-button type="danger" @click.stop="allDelete">全部删除</el-button>
                      </span>
                <span class="wrapper" style="float:right;">
                        <el-button type="primary" @click.stop="searchCarInfo">查找</el-button>
                      </span>
                <span class="wrapper" style="float:right;margin-right:20px;">
                          <!--<el-button>驾驶员姓名</el-button>-->
                    <!--<el-button>SIM卡号</el-button>-->
                    <!--<el-button>设备ID</el-button>-->
                    <!--<el-button>设备名称</el-button>-->
                    <!--<el-button>车辆</el-button>-->
                    <!--<el-button>车队</el-button>-->
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
                            label="车队名称"
                            show-overflow-tooltip
                            align="center"
                    >
                        <template scope="scope">
                            {{ scope.row.motorcadeName }}
                        </template>
                    </el-table-column>

                    <el-table-column
                            label="所属公司名称"
                            show-overflow-tooltip
                            align="center"
                            prop="biddingCompanyInfo.companyName"
                    >
                    </el-table-column>

                    <el-table-column
                            label="车牌号码"
                            align="center"

                    >
                        <template scope="scope">
                            {{ scope.row.licensePlatNumber}}
                        </template>
                    </el-table-column>

                    <el-table-column
                            label="设备名称"
                            align="center"

                    >
                        <template scope="scope">
                            {{ scope.row.facilityName }}
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
                                <el-tag>{{ scope.row.driverName}}</el-tag>
                            </div>
                        </template>

                    </el-table-column>

                    <el-table-column
                            label="设备ID"
                            align="center"

                    >
                        <template scope="scope">
                            {{ scope.row.facilityId }}
                        </template>
                    </el-table-column>

                    <el-table-column
                            label="驾驶员电话"
                            align="center"

                    >
                        <template scope="scope">
                            {{ scope.row.driverPhone }}
                        </template>
                    </el-table-column>

                    <el-table-column
                            label="修改日期"
                            align="center"
                            min-width="110"
                    >
                        <template scope="scope">
                            <!--<el-icon name="time"></el-icon>-->
                            <span style="margin-left: 10px">{{scope.row.lastupdatedTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}')}}</span>
                        </template>
                    </el-table-column>

                    <el-table-column label="操作"
                                     align="center"
                                     min-width="180"
                    >
                        <template scope="scope">
                            <el-button
                                    size="small"
                                    type = "primary"
                                    @click="handleDownload(scope.$index, scope.row)">资质下载
                            </el-button>
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
        <el-dialog title="添加车辆信息" :visible.sync="dialogFormVisible">
            <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
                <el-form-item label="车队名称" prop="motorcadeName">
                    <el-input type="text" v-model="ruleForm2.motorcadeName" auto-complete="off"
                              placeholder="请输入车队名称"></el-input>
                </el-form-item>

                <el-form-item label="所属公司ID" prop="placeId" v-show="false">
                    <el-input type="text"
                              v-model="ruleForm2.companyId"
                              auto-complete="off"
                              placeholder="请输入所属公司ID"></el-input>
                </el-form-item>

                <el-form-item label="所属公司名称">
                    <el-select v-model="ruleForm2.estimateDriver" placeholder="请输入公司名称" @change="querySearch">
                        <el-option
                                v-for="item in options"
                                :key="item.companyName"
                                :label="item.companyName"
                                :value="item.companyName"
                        >
                        </el-option>
                    </el-select>
                </el-form-item>

                <el-form-item label="车牌号码" prop="licensePlatNumber">
                    <el-input type="text" v-model="ruleForm2.licensePlatNumber" auto-complete="off"
                              placeholder="请输入车队名称"></el-input>
                </el-form-item>
                <el-form-item label="设备名称" prop="facilityName">
                    <el-input v-model="ruleForm2.facilityName" placeholder="请输入设备名称"></el-input>
                </el-form-item>
                <el-form-item label="驾驶员姓名" prop="driverName">
                    <el-input v-model="ruleForm2.driverName" placeholder="请输入驾驶员姓名"></el-input>
                </el-form-item>
                <el-form-item label="设备ID" prop="facilityId">
                    <el-input v-model="ruleForm2.facilityId" placeholder="请输入设备ID"></el-input>
                </el-form-item>
                <el-form-item label="驾驶员电话" prop="driverPhone">
                    <el-input v-model="ruleForm2.driverPhone" placeholder="请输入驾驶员电话"></el-input>
                </el-form-item>

                <el-form-item label="上传" v-show="false" prop="upload">
                    <el-input v-model="ruleForm2.upload" ></el-input>
                </el-form-item>

                <el-form-item>
                    <el-upload
                            class="upload-demo"
                            action="http://180.169.20.145:8094/spring-uploader/test/webUploader"
                            :on-preview="handlePreview"
                            :on-remove="handleRemove"
                            :on-success = "handleSuccess"
                            multiple
                            :on-exceed="handleExceed"
                            :file-list="fileList">
                        <el-button size="small" type="primary">点击上传</el-button>
                        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
                    </el-upload>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <!--<el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>-->
                <el-button type="primary" :disabled="isSubmit" @click="submitForm('ruleForm2')">提交</el-button>
                <el-button @click="dialogFormVisible = false">取消</el-button>
            </div>
        </el-dialog>
        <el-dialog title="编辑车辆信息" :visible.sync="dialogFormVisibleEdit">
            <el-form :model="ruleFormEdit" :rules="rulesEdit" ref="ruleFormEdit" label-width="100px"
                     class="demo-ruleForm">
                <el-form-item label="车队名称" prop="motorcadeName">
                    <el-input type="text" v-model="ruleFormEdit.motorcadeName" auto-complete="off"
                              placeholder="请输入车队名称"></el-input>
                </el-form-item>

                <el-form-item label="所属公司ID" prop="placeId" v-show="false">
                    <el-input type="text"
                              v-model="ruleFormEdit.companyId"
                              auto-complete="off"
                              placeholder="请输入所属公司ID"></el-input>
                </el-form-item>

                <el-form-item label="所属公司名称">
                    <el-select v-model="ruleFormEdit1.companyName" placeholder="请输入公司名称" @change="querySearch">
                        <el-option
                                v-for="item in options"
                                :key="item.companyName"
                                :label="item.companyName"
                                :value="item.companyName"
                        >
                        </el-option>
                    </el-select>
                </el-form-item>

                <el-form-item label="车牌号码" prop="licensePlatNumber">
                    <el-input type="text" v-model="ruleFormEdit.licensePlatNumber" auto-complete="off"
                              placeholder="请输入车队名称"></el-input>
                </el-form-item>
                <el-form-item label="设备名称" prop="facilityName">
                    <el-input v-model="ruleFormEdit.facilityName" placeholder="请输入设备名称"></el-input>
                </el-form-item>
                <el-form-item label="驾驶员姓名" prop="driverName">
                    <el-input v-model="ruleFormEdit.driverName" placeholder="请输入驾驶员姓名"></el-input>
                </el-form-item>
                <el-form-item label="设备ID" prop="facilityId">
                    <el-input v-model="ruleFormEdit.facilityId" placeholder="请输入设备ID"></el-input>
                </el-form-item>
                <el-form-item label="驾驶员电话" prop="driverPhone">
                    <el-input v-model="ruleFormEdit.driverPhone" placeholder="请输入驾驶员电话"></el-input>
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
    import * as actions from '../../store/modules/vehicle/actions'
    export default{

        data() {
            return {
                currentPage: 1,
                input: '',
                height: "",
                size: 10,
                selection: [],
                dialogFormVisible: false,
                dialogFormVisibleEdit: false,
                formLabelWidth: '120px',
                ruleForm2: {
                    motorcadeName: "",
                    licensePlatNumber: '',
                    facilityName: '',
                    driverName: '',
                    facilityId: '',
                    driverPhone: '',
                    upload:'',

                },

                ruleFormEdit: {},
                ruleFormEdit1: {},
                isSubmit: false,
                rules2: {
                    // facilityName driverName facilityId driverPhone
                    motorcadeName: [
                        {required: true, message: '请输入车队名称', trigger: 'blur'},
                    ],
                    licensePlatNumber: [
                        {required: true, message: '请输入车队号码', trigger: 'blur'}
                    ],
                    facilityName: [
                        {required: true, message: '请输入设备名称', trigger: 'blur'}
                    ],
                    driverName: [
                        {required: true, message: '请输入驾驶员姓名', trigger: 'blur'}
                    ],
                    facilityId: [
                        {required: true, message: '请输入设备ID', trigger: 'blur'}
                    ],
                    driverPhone: [
                        {required: true, message: '请输入驾驶员电话', trigger: 'blur'}
                    ],
                },
                rulesEdit: {},
                loading: true,
                options: [],
                fileList: []
            };
        },
        methods: {
            // 上传
            handleRemove(file, fileList) {
                console.log(file, fileList);
            },
            handlePreview(file) {
                console.log(file);
            },
            handleExceed(files, fileList) {
                this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
            },
            handleSuccess(response, file, fileList){
                console.log(file.name)
                console.log(response.result.urls[0])
                this.fileList.push({name:file.name,url:response.result.urls[0]});
                console.log(this.fileList)

            },
            // 下载
            handleDownload(){

            },
            searchCarInfo(){
                this.queryVehicle({
                    page: this.currentpage,
                    input: this.input
                });
            },
            addInfo(formName){
                this.dialogFormVisible = true;
                this.$nextTick(() => {
                    this.$refs[formName].resetFields();
                })
            },
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                this.currentpage = val;
                this.queryVehicle({
                    page: val
                });
            },
            // 编辑
            handleEdit(index, row) {
                this.dialogFormVisibleEdit = true;
                this.ruleFormEdit = row;
                this.ruleFormEdit1 = row.biddingCompanyInfo;
            },
            submitFormEdit(formName){
                this.saveOrUpdateVehicle(this.ruleFormEdit).then(() => this.successEdit());
            },
            // 删除
            handleDelete(index, row) {
                this.$confirm('是否删除该条信息', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteVehicle({
                        id: row.id
                    }).then(() => {
                        this.queryVehicle({
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
                        this.batchDeleteVehicle({items: ids}).then(() => {
                            this.queryVehicle({
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
                console.log(this.fileList);
                let _this = this;
                let tempArr = [];
                this.fileList.forEach((v,i,arr) => {
                    for(let k of Object.keys(v)){
                        console.log(k);
                        if(k === "url"){
                            console.log(v[k]);
                            tempArr.push(v[k]);
                        }
                    }
                })
                console.log(tempArr)
                _this.ruleForm2.upload = tempArr.join(",");
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.saveOrUpdateVehicle(this.ruleForm2).then(() => {
                            this.successSubmit();
                            this.$refs[formName].resetFields();
                        });
                    } else {
                        this.cancelSubmit()
                        return false;
                    }
                });
            },
            successSubmit () {
                this.queryVehicle({}).then(() => {
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
                this.queryVehicle({}).then(() => {
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
            querySearch(queryString) {
                var _this = this;
                this.options.forEach((v, i, arr) => {
                    if (arr[i].companyName === queryString) {
                        _this.ruleForm2.companyId = arr[i].id;
                        _this.ruleFormEdit.companyId = arr[i].id;
                    }
                })

            },
            //action方法
            ...mapActions([
                'findBiddingCompanyInfoByName',
                'queryVehicle',
                'findByVehicleId',
                'saveOrUpdateVehicle',
                'deleteVehicle',
                'batchDeleteVehicle'
            ]),
        },
        mounted(){
            let _this = this;
            // 控制表格高度
            this.height = $(".tabclick").height() - $(".form_nav").height() - 80;
            this.queryVehicle({}).then(() => {
                _this.loading = false;
            });
            this.findBiddingCompanyInfoByName({}).then(() => {
                let res = _this.biddingCompanyInfoList;
                _this.options = res;
            })
        },
        computed: {
            ...mapGetters({
                tableData: "getVehicles",
                total: "getVehicleTotal",
                current: "getCurrentVehicle",
                biddingCompanyInfoList: "getBiddingCompanyInfoList"
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
