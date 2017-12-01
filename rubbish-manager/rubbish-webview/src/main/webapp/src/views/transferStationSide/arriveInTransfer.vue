<template>
    <div class="el-col el-col-24 el-col-xs-24 el-col-sm-24 tabclick"
         style="height:calc(100% - 80px);position: absolute;padding: 0 15px;background: #fff;">
        <div class="form_nav el-col el-col-24 el-col-xs-24 el-col-sm-24">
            <div>
                <span class="wrapper">
                    <el-form :inline="true" :model="formInline" class="demo-form-inline" ref="formInline">
                        <div class = "formInline_left">
                            <el-form-item label="垃圾重量">
                            <el-input placeholder="请输入垃圾重量" v-model="formInline.weight"></el-input>
                        </el-form-item>

                            <el-form-item label="行程单">
                                <el-autocomplete
                                        v-model="formInline.applyId"
                                        :fetch-suggestions="querySearchPlace"
                                        :trigger-on-focus="false"
                                        @select="handleSelectPlace"
                                        placeholder="请输入查找行程单"
                                ></el-autocomplete>
                            </el-form-item>
                            <el-form-item>
                            <el-button type="primary" @click.capture="submitForm('formInline')">确定</el-button>
                        </el-form-item>
                        </div>

                        <div class = "formInline_right">
                            <el-form-item>
                                <el-input v-model="input" placeholder="请输入内容"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click.stop="searchCarInfo">查找</el-button>
                            </el-form-item>
                        </div>

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
                            label="行程单ID"
                            align="center"

                    >
                        <template scope="scope">
                            {{ scope.row.id}}
                        </template>
                    </el-table-column>


                    <!--（0：建筑场地到中转站，1：中转站到焚烧厂，处理厂）-->
                    <el-table-column
                            label="类型"
                            align="center"

                    >
                        <template scope="scope">
                            <el-tag  v-if="scope.row.type == 1">中转站到焚烧厂</el-tag>
                            <el-tag type="info" v-if="scope.row.type == 0">建筑场地到中转站</el-tag>
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
                            label="车牌号码"
                            align="center"

                    >
                        <template scope="scope">
                            {{ scope.row.licensePlatNumber}}
                        </template>
                    </el-table-column>


                    <el-table-column
                            label="sim卡号"
                            align="center"

                    >
                        <template scope="scope">
                            {{ scope.row.simNo}}
                        </template>
                    </el-table-column>

                    <!--0:开始  1:进行中  2结束-->
                    <el-table-column
                            label="状态"
                            align="center"

                    >
                        <template scope="scope">
                            <el-tag  v-if="scope.row.status == 1">进行中</el-tag>
                            <el-tag type="info" v-if="scope.row.status == 0">开始</el-tag>
                            <el-tag type="success" v-if="scope.row.status == 2">结束</el-tag>
                        </template>
                    </el-table-column>



                    <el-table-column
                            label="行程单开始时间"
                            align="center"
                            min-width="100"
                    >
                        <template scope="scope">
                            <!--<el-icon name="time"></el-icon>-->
                            <span style="margin-left: 10px">{{scope.row.startTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}')}}</span>
                        </template>
                    </el-table-column>


                    <el-table-column
                            label="行程单结束时间"
                            align="center"
                            min-width="100"
                    >
                        <template scope="scope">
                            <!--<el-icon name="time"></el-icon>-->
                            <span style="margin-left: 10px">{{scope.row.endTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}')}}</span>
                        </template>
                    </el-table-column>


                    <el-table-column label="操作"
                                     align="center"
                                     min-width="80"
                    >
                        <template scope="scope">
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
                        :page-size="size"
                        layout="total, prev, pager, next, jumper"
                        :total="total">
                </el-pagination>
            </template>
        </form>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'
    import * as actions from '../../store/modules/apply/actions'
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
                ruleFormEdit: {
                },
                formInline:{
                    applyId:"",
                    weight:"",
                },
                isSubmit: false,
                loading:true,
                cbResPlace:'',
            };
        },
        methods: {
            searchCarInfo(){
                this.queryApply({
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
                this.queryApply({
                    page: val
                });
            },
            querySearchPlace(queryString, cb) {
                var _this = this;
                this.cbResPlace = [];
                this.queryApplyId({
                    applyId: queryString
                }).then(() => {
                    var res = _this.idList;
                    console.log(res);
                    $.each(res,function(i,v){
                        let id = res[i].id
                        _this.cbResPlace.push({
                            value:id,
                        })
                    })
                    cb(_this.cbResPlace);
                });
            },
            handleSelectPlace(item) {
                console.log(item)
                this.formInline.applyId = item.value;
            },

            // 删除
            handleDelete(index, row) {
                this.$confirm('是否删除该条信息', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteApply({
                        id: row.id
                    }).then(() => {
                        this.queryApply({
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
                        this.batchDeleteApply({items: ids}).then(() => {
                            this.queryApply({
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
                let weight = Number(this.formInline.weight);
                let applyId = this.formInline.applyId;
                console.log(weight,applyId )
                if (weight != "" && applyId != "" && !isNaN(weight)) {
                    this.saveOrUpdateApply({
                        id: applyId,
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
                this.queryApply({}).then(() => {
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
                this.queryApply({}).then(() => {
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
                'queryApplyId',
                'queryApply',
                'findByApplyId',
                'saveOrUpdateApply',
                'deleteApply',
                'batchDeleteApply'
            ]),
        },
        mounted(){
            let _this = this;
            // 控制表格高度
            this.height = $(".tabclick").height() - $(".form_nav").height() - 80;
            this.queryApply({}).then(() => {
                _this.loading = false;
            });
        },
        computed: {
            ...mapGetters({
                idList:"getIdList",
                tableData: "getApplys",
                total: "getApplyTotal",
                current: "getCurrentApply"
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
                    clear: both;
                    overflow: hidden;
                    .formInline_right{
                        float: right;
                    }
                    .formInline_left{
                        float: left;
                    }
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
