
<template>
    <div class = "el-col el-col-24 el-col-xs-24 el-col-sm-22 tabclick" style = "height:100%">
        <div class = "form_nav el-col el-col-24 el-col-xs-24 el-col-sm-24">
            <div>
                     <span class="wrapper" style = "float:left;">
                        <el-button type="primary" @click.stop="addInfo('ruleForm2')">添加用户信息</el-button>
                        <el-button type="danger" @click.stop = "allDelete">全部删除</el-button>
                      </span>
                <span class="wrapper" style = "float:right;">
                        <el-button type="primary" @click.stop = "searchCarInfo">查找</el-button>
                      </span>
                <span class="wrapper" style = "float:right;margin-right:20px;">
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
                        @selection-change = "selectionChange"
                        :height = "height"
                        style="width: 100%">
                    <el-table-column
                            type="selection"
                            align = "center"
                            width="55">
                    </el-table-column>

                    <el-table-column
                            label="用户名称"
                            show-overflow-tooltip
                            align = "center"
                    >
                        <template scope="scope">
                            {{ scope.row.userName }}
                        </template>
                    </el-table-column>

                    <el-table-column
                            label="登录用户名"
                            align = "center"

                    >
                        <template scope="scope">
                            {{ scope.row.loginName}}
                        </template>
                    </el-table-column>

                    <el-table-column
                            label="密码"
                            align = "center"

                    >
                        <template scope="scope">
                            {{ scope.row.password }}
                        </template>
                    </el-table-column>

                    <el-table-column
                            label="岗位名称"
                            align = "center"

                    >
                        <template scope="scope">
                            {{ scope.row.postName}}
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
                            label="创建人"
                            align = "center"

                    >
                        <template scope="scope">
                            {{ scope.row.createdBy }}
                        </template>
                    </el-table-column>
                    <el-table-column
                            label="备注信息"
                            align = "center"
                            show-overflow-tooltip
                    >
                        <template scope="scope">
                            {{ scope.row.memo }}
                        </template>
                    </el-table-column>

                    <el-table-column
                            label="修改日期"
                            align = "center"
                            min-width ="110"
                    >
                        <template scope="scope">
                            <!--<el-icon name="time"></el-icon>-->
                            {{scope.row.lastupdatedTime | parseTime('{y}-{m}-{d} {h}:{i}:{s}')}}
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
                        @current-change="handleCurrentChange"
                        :current-page=currentPage
                        :page-sizes="[10]"
                        :page-size="size"
                        layout="total, prev, pager, next, jumper"
                        :total="total">
                </el-pagination>
            </template>
        </form>
        <el-dialog title="添加用户信息" :visible.sync="dialogFormVisible">
            <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
                <el-form-item label="用户名称" prop="userName">
                    <el-input type="text" v-model="ruleForm2.userName" auto-complete="off" placeholder="请输入用户名称"></el-input>
                </el-form-item>
                <el-form-item label="登录用户名" prop="loginName">
                    <el-input type="text" v-model="ruleForm2.loginName" auto-complete="off" placeholder="请输入登录用户名称"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input v-model="ruleForm2.password"></el-input>
                </el-form-item>
                <el-form-item label="岗位名称" prop="postName">
                    <el-input v-model="ruleForm2.postName"></el-input>
                </el-form-item>
                <el-form-item label="状态" prop="status">
                    <el-radio-group v-model="ruleForm2.status">
                        <el-radio class="radio" label = "1">启用</el-radio>
                        <el-radio class="radio" label = "0">冻结</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="备注" prop="memo">
                    <el-input v-model="ruleForm2.memo"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <!--<el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>-->
                <el-button type="primary" :disabled="isSubmit" @click="submitForm('ruleForm2')">提交</el-button>
                <el-button @click="dialogFormVisible = false">取消</el-button>
            </div>
        </el-dialog>
        <el-dialog title="编辑用户信息" :visible.sync="dialogFormVisibleEdit">
            <el-form :model="ruleFormEdit" :rules="rulesEdit" ref="ruleFormEdit" label-width="100px" class="demo-ruleForm">
                <el-form-item label="用户名称" prop="userName">
                    <el-input type="text" v-model="ruleFormEdit.userName" auto-complete="off" placeholder="请输入用户名称"></el-input>
                </el-form-item>
                <el-form-item label="登录用户名" prop="loginName">
                    <el-input type="text" v-model="ruleFormEdit.loginName" auto-complete="off" placeholder="请输入登录用户名称"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input v-model="ruleFormEdit.password"></el-input>
                </el-form-item>
                <el-form-item label="岗位名称" prop="postName">
                    <el-input v-model="ruleFormEdit.postName"></el-input>
                </el-form-item>
                <el-form-item label="状态" prop="status">
                    <el-radio-group v-model="ruleFormEdit.status">
                        <el-radio class="radio" label = "1" >启用</el-radio>
                        <el-radio class="radio" label = "0" >冻结</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="备注" prop="memo">
                    <el-input v-model="ruleFormEdit.memo"></el-input>
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
    import * as actions from '../../store/modules/user/actions'
    export default{

        data() {
            return {
                loading: true,
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
                    userName :"",
                    loginName: '',
                    password:'',
                    postName:'',
                    status:"1",
                    memo:'',
                    createdBy:"",
                    createdTime:""
                },
                ruleFormEdit:{
                    userName :"",
                    loginName: '',
                    password:'',
                    postName:'',
                    status:"1",
                    memo:'',
                    createdBy:"",
                    createdTime:""
                },
                isSubmit:false,
                rules2: {
                    //userName loginName password postName status memo
                    userName: [
                        { required: true, message: '请输入用户名', trigger: 'blur' },
                    ],
                    loginName: [
                        { required: true, message: '请输入登录用户名', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'blur' }
                    ],
                    postName: [
                        { required: true, message: '请输入岗位名称', trigger: 'blur' }
                    ],
                    status: [
                        { required: true, message: '请选择状态', trigger: 'change' }
                    ],
                    memo: [
                        { required: true, message: '备注', trigger: 'blur' }
                    ],
                },
                rulesEdit:{}
            };
        },
        methods: {
            searchCarInfo(){
                this.queryUser({
                    page:this.currentpage,
                    input:this.input
                });
            },
            handleCurrentChange(val) {
                this.currentpage = val;
                this.queryUser({
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
                this.saveOrUpdateUser(this.ruleFormEdit).then(() => this.successEdit());
            },
            // 删除
            handleDelete(index, row) {
                this.$confirm('是否删除该条信息', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteUser({
                        id : row.id
                    }).then(() => {
                        this.queryUser({
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
                        this.batchDeleteUser({items:ids}).then(() => {
                            this.queryUser({
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
                        this.saveOrUpdateUser(this.ruleForm2).then(() => {
                            this.successSubmit()
                            this.$refs[formName].resetFields();
                        });
                    } else {
                        this.cancelSubmit();
                        return false;
                    }
                })
            },
            successSubmit () {

                this.queryUser({}).then(() => {
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
                this.queryUser({}).then(() => {
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
                'queryUser',
                'findByUserId',
                'saveOrUpdateUser',
                'deleteUser',
                'batchDeleteUser'
            ]),
        },
        mounted(){
            let _this = this;
            // 控制表格高度
            this.height = $(".tabclick").height() - $(".form_nav").height() - 80;
            this.queryUser({}).then(() => {
                _this.loading = false;
            });
        },
        computed:{
            ...mapGetters({
                tableData: "getUsers",
                total : "getUserTotal",
                current: "getCurrentUser"
            })
        },
    }
</script>

<style lang="scss" scoped rel="stylesheet/scss">
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