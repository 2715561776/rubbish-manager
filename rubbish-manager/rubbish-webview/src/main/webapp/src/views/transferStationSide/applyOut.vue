<template>
        <div class = "el-col el-col-24 el-col-xs-24 el-col-sm-22 tabclick" style = "height:100%">
            <div class = "form_nav el-col el-col-24 el-col-xs-24 el-col-sm-24">
                <div>
                     <span class="wrapper" style = "float:left;">
                        <el-button type="info" @click.stop="dialogFormVisible = true">添加场地信息</el-button>
                        <el-button type="danger" @click.stop = "allDelete">全部删除</el-button>
                      </span>
                    <span class="wrapper" style = "float:right;">
                        <el-button type="info" @click.stop = "searchCarInfo">查找</el-button>
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
                                label="行程单Id"
                                align = "center"

                        >
                            <template scope="scope">
                                {{ scope.row.id}}
                            </template>
                        </el-table-column>
            
			   <!--<el-table-column-->
                                <!--label="类型（0：建筑场地到中转站，1：中转站到焚烧厂，处理厂）"-->
                                <!--align = "center"-->

                        <!--&gt;-->
                            <!--<template scope="scope">-->
                                <!--{{ scope.row.type}}-->
                            <!--</template>-->
                        <!--</el-table-column>-->
            
            
			   <el-table-column
                                label="垃圾重量（吨）"
                                align = "center"

                        >
                            <template scope="scope">
                                {{ scope.row.weight}}
                            </template>
                        </el-table-column>
            
            
			   <!--<el-table-column-->
                                <!--label="车辆ID"-->
                                <!--align = "center"-->

                        <!--&gt;-->
                            <!--<template scope="scope">-->
                                <!--{{ scope.row.vehicleId}}-->
                            <!--</template>-->
                        <!--</el-table-column>-->
            
            
			   <el-table-column
                                label="车牌号码"
                                align = "center"

                        >
                            <template scope="scope">
                                {{ scope.row.licensePlatNumber}}
                            </template>
                        </el-table-column>
            
            
			   <el-table-column
                                label="sim卡号"
                                align = "center"

                        >
                            <template scope="scope">
                                {{ scope.row.simNo}}
                            </template>
                        </el-table-column>
            
            
			   <!--<el-table-column-->
                                <!--label="0:开始  1:进行中  2结束"-->
                                <!--align = "center"-->

                        <!--&gt;-->
                            <!--<template scope="scope">-->
                                <!--{{ scope.row.status}}-->
                            <!--</template>-->
                        <!--</el-table-column>-->
            
            
			   <!--<el-table-column-->
                                <!--label="创建人"-->
                                <!--align = "center"-->

                        <!--&gt;-->
                            <!--<template scope="scope">-->
                                <!--{{ scope.row.createdBy}}-->
                            <!--</template>-->
                        <!--</el-table-column>-->
            
            
			    <!--<el-table-column-->
                                <!--label="createdTime"-->
                                <!--align = "center"-->
                                <!--min-width="100"-->
                        <!--&gt;-->
                            <!--<template scope="scope">-->
                                <!--&lt;!&ndash;<el-icon name="time"></el-icon>&ndash;&gt;-->
                                <!--<span style="margin-left: 10px">{{scope.row.createdTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}')}}</span>-->
                            <!--</template>-->
                        <!--</el-table-column>-->

            
            
			   <!--<el-table-column-->
                                <!--label="最后修改人账号"-->
                                <!--align = "center"-->

                        <!--&gt;-->
                            <!--<template scope="scope">-->
                                <!--{{ scope.row.lastupdatedBy}}-->
                            <!--</template>-->
                        <!--</el-table-column>-->
            
            
			    <!--<el-table-column-->
                                <!--label="lastupdatedTime"-->
                                <!--align = "center"-->
                                <!--min-width="100"-->
                        <!--&gt;-->
                            <!--<template scope="scope">-->
                                <!--&lt;!&ndash;<el-icon name="time"></el-icon>&ndash;&gt;-->
                                <!--<span style="margin-left: 10px">{{scope.row.lastupdatedTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}')}}</span>-->
                            <!--</template>-->
                        <!--</el-table-column>-->

            
            
			    <el-table-column
                                label="行程单开始时间"
                                align = "center"
                                min-width="100"
                        >
                            <template scope="scope">
                                <!--<el-icon name="time"></el-icon>-->
                                <span style="margin-left: 10px">{{scope.row.startTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}')}}</span>
                            </template>
                        </el-table-column>

            
            
			    <el-table-column
                                label="行程单结束时间"
                                align = "center"
                                min-width="100"
                        >
                            <template scope="scope">
                                <!--<el-icon name="time"></el-icon>-->
                                <span style="margin-left: 10px">{{scope.row.endTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}')}}</span>
                            </template>
                        </el-table-column>



                        <el-table-column
                                prop="startPlaceInfo.name"
                                label="起点">
                        </el-table-column>

                        <el-table-column
                                prop="endPlaceInfo.name"
                                label="终点">
                        </el-table-column>
            

                       

                        <!--<el-table-column label="操作"-->
                                         <!--align = "center"-->
                                         <!--min-width="80"-->
                        <!--&gt;-->
                            <!--<template scope="scope">-->
                                <!--<el-button-->
                                        <!--size="small"-->
                                        <!--@click="handleEdit(scope.$index, scope.row)">编辑</el-button>-->
                                <!--<el-button-->
                                        <!--size="small"-->
                                        <!--type="danger"-->
                                        <!--@click="handleDelete(scope.$index, scope.row)">删除</el-button>-->
                            <!--</template>-->
                        <!--</el-table-column>-->
                    </el-table>
                    <el-pagination
                            @size-change="handleSizeChange"
                            @current-change="handleCurrentChange"
                            :current-page=currentPage
                            :page-sizes="[10]"
                            :page-size="size"
                            layout="total, sizes, prev, pager, next, jumper"
                            :total="total">
                    </el-pagination>
                </template>
            </form>
            <el-dialog title="添加场地信息" :visible.sync="dialogFormVisible">
                <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
			  <el-form-item label="类型（0：建筑场地到中转站，1：中转站到焚烧厂，处理厂）" prop="type">
                        <el-input type="text" v-model="ruleForm2.type" auto-complete="off" placeholder="请输入类型（0：建筑场地到中转站，1：中转站到焚烧厂，处理厂）"></el-input>
                    </el-form-item>
            
			  <el-form-item label="垃圾重量（吨）" prop="weight">
                        <el-input type="text" v-model="ruleForm2.weight" auto-complete="off" placeholder="请输入垃圾重量（吨）"></el-input>
                    </el-form-item>
            
			  <el-form-item label="车辆ID" prop="vehicleId">
                        <el-input type="text" v-model="ruleForm2.vehicleId" auto-complete="off" placeholder="请输入车辆ID"></el-input>
                    </el-form-item>
            
			  <el-form-item label="车牌号码" prop="licensePlatNumber">
                        <el-input type="text" v-model="ruleForm2.licensePlatNumber" auto-complete="off" placeholder="请输入车牌号码"></el-input>
                    </el-form-item>
            
			  <el-form-item label="sim卡号" prop="simNo">
                        <el-input type="text" v-model="ruleForm2.simNo" auto-complete="off" placeholder="请输入sim卡号"></el-input>
                    </el-form-item>
            
			  <el-form-item label="0:开始  1:进行中  2结束" prop="status">
                        <el-input type="text" v-model="ruleForm2.status" auto-complete="off" placeholder="请输入0:开始  1:进行中  2结束"></el-input>
                    </el-form-item>
            
			  <el-form-item label="创建人" prop="createdBy">
                        <el-input type="text" v-model="ruleForm2.createdBy" auto-complete="off" placeholder="请输入创建人"></el-input>
                    </el-form-item>
            
			  <el-form-item label="createdTime" prop="createdTime">
                        <el-input type="text" v-model="ruleForm2.createdTime" auto-complete="off" placeholder="请输入createdTime"></el-input>
                    </el-form-item>
            
			  <el-form-item label="最后修改人账号" prop="lastupdatedBy">
                        <el-input type="text" v-model="ruleForm2.lastupdatedBy" auto-complete="off" placeholder="请输入最后修改人账号"></el-input>
                    </el-form-item>
            
			  <el-form-item label="lastupdatedTime" prop="lastupdatedTime">
                        <el-input type="text" v-model="ruleForm2.lastupdatedTime" auto-complete="off" placeholder="请输入lastupdatedTime"></el-input>
                    </el-form-item>
            
			  <el-form-item label="行程单开始时间" prop="startTime">
                        <el-input type="text" v-model="ruleForm2.startTime" auto-complete="off" placeholder="请输入行程单开始时间"></el-input>
                    </el-form-item>
            
			  <el-form-item label="行程单结束时间" prop="endTime">
                        <el-input type="text" v-model="ruleForm2.endTime" auto-complete="off" placeholder="请输入行程单结束时间"></el-input>
                    </el-form-item>
            
			  <el-form-item label="起点" prop="startPlace">
                        <el-input type="text" v-model="ruleForm2.startPlace" auto-complete="off" placeholder="请输入起点"></el-input>
                    </el-form-item>
            
			  <el-form-item label="终点" prop="endPlace">
                        <el-input type="text" v-model="ruleForm2.endPlace" auto-complete="off" placeholder="请输入终点"></el-input>
                    </el-form-item>
            
                    
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button type="primary" :disabled="isSubmit" @click="submitForm('ruleForm2')">提交</el-button>
                    <el-button @click="dialogFormVisible = false">取消</el-button>
                </div>
            </el-dialog>
            <el-dialog title="编辑场地信息" :visible.sync="dialogFormVisibleEdit">
                <el-form :model="ruleFormEdit" :rules="rulesEdit" ref="ruleFormEdit" label-width="100px" class="demo-ruleForm">
				
			    <el-form-item label="类型（0：建筑场地到中转站，1：中转站到焚烧厂，处理厂）" prop="type">
                        <el-input type="text" v-model="ruleFormEdit.type" auto-complete="off" placeholder="请输入类型（0：建筑场地到中转站，1：中转站到焚烧厂，处理厂）"></el-input>
                    </el-form-item>
            
			    <el-form-item label="垃圾重量（吨）" prop="weight">
                        <el-input type="text" v-model="ruleFormEdit.weight" auto-complete="off" placeholder="请输入垃圾重量（吨）"></el-input>
                    </el-form-item>
            
			    <el-form-item label="车辆ID" prop="vehicleId">
                        <el-input type="text" v-model="ruleFormEdit.vehicleId" auto-complete="off" placeholder="请输入车辆ID"></el-input>
                    </el-form-item>
            
			    <el-form-item label="车牌号码" prop="licensePlatNumber">
                        <el-input type="text" v-model="ruleFormEdit.licensePlatNumber" auto-complete="off" placeholder="请输入车牌号码"></el-input>
                    </el-form-item>
            
			    <el-form-item label="sim卡号" prop="simNo">
                        <el-input type="text" v-model="ruleFormEdit.simNo" auto-complete="off" placeholder="请输入sim卡号"></el-input>
                    </el-form-item>
            
			    <el-form-item label="0:开始  1:进行中  2结束" prop="status">
                        <el-input type="text" v-model="ruleFormEdit.status" auto-complete="off" placeholder="请输入0:开始  1:进行中  2结束"></el-input>
                    </el-form-item>
            
			    <el-form-item label="创建人" prop="createdBy">
                        <el-input type="text" v-model="ruleFormEdit.createdBy" auto-complete="off" placeholder="请输入创建人"></el-input>
                    </el-form-item>
            
			    <el-form-item label="createdTime" prop="createdTime">
                        <el-input type="text" v-model="ruleFormEdit.createdTime" auto-complete="off" placeholder="请输入createdTime"></el-input>
                    </el-form-item>
            
			    <el-form-item label="最后修改人账号" prop="lastupdatedBy">
                        <el-input type="text" v-model="ruleFormEdit.lastupdatedBy" auto-complete="off" placeholder="请输入最后修改人账号"></el-input>
                    </el-form-item>
            
			    <el-form-item label="lastupdatedTime" prop="lastupdatedTime">
                        <el-input type="text" v-model="ruleFormEdit.lastupdatedTime" auto-complete="off" placeholder="请输入lastupdatedTime"></el-input>
                    </el-form-item>
            
			    <el-form-item label="行程单开始时间" prop="startTime">
                        <el-input type="text" v-model="ruleFormEdit.startTime" auto-complete="off" placeholder="请输入行程单开始时间"></el-input>
                    </el-form-item>
            
			    <el-form-item label="行程单结束时间" prop="endTime">
                        <el-input type="text" v-model="ruleFormEdit.endTime" auto-complete="off" placeholder="请输入行程单结束时间"></el-input>
                    </el-form-item>
            
			    <el-form-item label="起点" prop="startPlace">
                        <el-input type="text" v-model="ruleFormEdit.startPlace" auto-complete="off" placeholder="请输入起点"></el-input>
                    </el-form-item>
            
			    <el-form-item label="终点" prop="endPlace">
                        <el-input type="text" v-model="ruleFormEdit.endPlace" auto-complete="off" placeholder="请输入终点"></el-input>
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
    import { mapGetters, mapActions } from 'vuex'
    import * as actions from '../../store/modules/apply/actions'
    export default{

        data() {
            return {
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
                    type: [],
                    resource: '',
                    desc: ''
                },
                formLabelWidth: '120px',
                ruleForm2: {
                    name :"",
                    contacter: '',
                    status:1
                },

                ruleFormEdit:{

                },

                isSubmit:false,
                rulesEdit:{},
                rules2: {
                        type: [
                            {required: false, message: '请输入类型（0：建筑场地到中转站，1：中转站到焚烧厂，处理厂）', trigger: 'blur'}
                        ],
                        weight: [
                            {required: false, message: '请输入垃圾重量（吨）', trigger: 'blur'}
                        ],
                        vehicleId: [
                            {required: false, message: '请输入车辆ID', trigger: 'blur'}
                        ],
                        licensePlatNumber: [
                            {required: false, message: '请输入车牌号码', trigger: 'blur'}
                        ],
                        simNo: [
                            {required: false, message: '请输入sim卡号', trigger: 'blur'}
                        ],
                        status: [
                            {required: false, message: '请输入0:开始  1:进行中  2结束', trigger: 'blur'}
                        ],
                        createdBy: [
                            {required: false, message: '请输入创建人', trigger: 'blur'}
                        ],
                        createdTime: [
                            {required: false, message: '请输入createdTime', trigger: 'blur'}
                        ],
                        lastupdatedBy: [
                            {required: false, message: '请输入最后修改人账号', trigger: 'blur'}
                        ],
                        lastupdatedTime: [
                            {required: false, message: '请输入lastupdatedTime', trigger: 'blur'}
                        ],
                        startTime: [
                            {required: false, message: '请输入行程单开始时间', trigger: 'blur'}
                        ],
                        endTime: [
                            {required: false, message: '请输入行程单结束时间', trigger: 'blur'}
                        ],
                        startPlace: [
                            {required: false, message: '请输入起点', trigger: 'blur'}
                        ],
                        endPlace: [
                            {required: false, message: '请输入终点', trigger: 'blur'}
                        ],
                  
                }
            };
        },
        methods: {
            searchCarInfo(){
                this.queryApplyOut({
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
                this.queryApplyOut({
                    page:val
                });
            },
			// 添加信息
            addInfo(formName){
                this.dialogFormVisible = true;
                this.$refs[formName].resetFields();
            },
            // 编辑
            handleEdit(index, row) {
                this.dialogFormVisibleEdit = true;
                this.ruleFormEdit = row;
            },
            submitFormEdit(){
                this.saveOrUpdateApply(this.ruleFormEdit).then(() => this.successEdit());
            },
            // 删除
            handleDelete(index, row) {
                this.$confirm('是否删除该条信息', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteApply({
                        id : row.id
                    }).then(() => {
                        this.queryApplyOut({
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
                        this.batchDeleteApply({items:ids}).then(() => {
                            this.queryApplyOut({
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
                        this.saveOrUpdateApply(this.ruleForm2).then(() => this.successSubmit());
                        this.$refs[formName].resetFields();
                    } else {
                        this.cancelSubmit();
                        return false;
                    }
                })
            },
            successSubmit () {
				 this.queryApplyOut({}).then(() => {
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
               this.queryApplyOut({}).then(() => {
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
                'queryApplyOut',
                'findByApplyId',
                'saveOrUpdateApply',
                'deleteApply',
                'batchDeleteApply'
            ]),
        },
        mounted(){
            // 控制表格高度
            this.height = $(".tabclick").height() - $(".form_nav").height() - 80;
            this.queryApplyOut({});
        },
        computed:{
            ...mapGetters({
                tableData: "getApplys",
                total : "getApplyTotal",
                current: "getCurrentApply"
            })
        },
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
                }
                &.is-active a{
                    display:inline-block;
                    height:60px;
                    border-bottom: 3px solid #20a0ff !important;
                }
                &:hover a {
                    display:inline-block;
                    text-align: center;
                    height: 60px;
                    border-bottom: 3px solid #20a0ff !important;
                }
            }
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
    }
    .el-table th{
        background:#eff4f8
    }
    .el-button+.el-button {
        margin-left: 0px;
    }
    .el-pagination button, .el-pagination span{
        cursor: pointer;
    }
</style>
