<template>
  <div>
    <Card :bordered="false">
      <Button type="primary" @click="cleanCurrentUser(),disable = false,formModel=true">新增</Button>
    </Card>
    <Card>
      <p slot="title">数据列表</p>
      <Table :columns="historyColumns" :data="historyData"></Table>
    </Card>
    <Page :total="dataCount" :page-size="pageSize" show-total class="paging" @on-change="change"></Page>
    <Modal
            v-model="submitModel"
            title="提示"
            :loading="loading"
            @on-ok="submit"
            @on-cancel="cancel">
      <p>是否提交内容?</p>
    </Modal>
    <Modal
            v-model="formModel"
            title="表单"
            :loading="loading"
            @on-ok="submitOk"
            @on-cancel="formModel=false">
      <Form ref="current" :model="current" :rules="rule" :label-width="80">
        <FormItem label="姓名">
          <Input v-model="current.userName" :disabled="this.disable == true" placeholder="请输入姓名" />
        </FormItem>
        <FormItem label="登录用户名">
          <Input v-model="current.loginName" :disabled="this.disable == true" placeholder="请输入登录用户名" />
        </FormItem>
        <FormItem label="密码">
          <Input v-model="current.password" :disabled="this.disable == true" placeholder="请输入密码" />
        </FormItem>
        <FormItem label="岗位名称">
          <Input v-model="current.postName" :disabled="this.disable == true" placeholder="请输入岗位名称" />
        </FormItem>
        <FormItem label="状态（启用、冻结）">
          <Input v-model="current.status" :disabled="this.disable == true" placeholder="请输入状态（启用、冻结）" />
        </FormItem>
        <FormItem label="备注信息">
          <Input v-model="current.memo" :disabled="this.disable == true" placeholder="请输入备注信息" />
        </FormItem>
        <FormItem label="创建人账号">
          <Input v-model="current.createdBy" :disabled="this.disable == true" placeholder="请输入创建人账号" />
        </FormItem>
        <FormItem label="创建时间">
          <DatePicker type="datetime" v-model="current.createdTime" :disabled="this.disable == true" format="yyyy-MM-dd HH:mm" placeholder="请选择创建时间"></DatePicker>
        </FormItem>
        <FormItem label="最后修改人账号">
          <Input v-model="current.lastupdatedBy" :disabled="this.disable == true" placeholder="请输入最后修改人账号" />
        </FormItem>
        <FormItem label="最后修改时间">
          <DatePicker type="datetime" v-model="current.lastupdatedTime" :disabled="this.disable == true" format="yyyy-MM-dd HH:mm" placeholder="请选择最后修改时间"></DatePicker>
        </FormItem>
      </Form>
    </Modal>
  </div>
</template>
<style scoped>
  .paging{
    float:right;
    margin-top:10px;
  }
</style>
<script>
    import { mapGetters, mapActions } from 'vuex'
    import * as actions from '../store/modules/user/actions'
    export default {
        data () {
            return {
                pageSize:10,
                currentPage:0,
                disable: false,
                submitModel: false,
                formModel:false,
                loading: true,
                historyColumns: [
                    {
                        title: '姓名',
                        key: 'userName'
                    },
                    {
                        title: '登录用户名',
                        key: 'loginName'
                    },
                    {
                        title: '密码',
                        key: 'password'
                    },
                    {
                        title: '岗位名称',
                        key: 'postName'
                    },
                    {
                        title: '状态（启用、冻结）',
                        key: 'status'
                    },
                    {
                        title: '备注信息',
                        key: 'memo'
                    },
                    {
                        title: '创建人账号',
                        key: 'createdBy'
                    },
                    {
                        title: '创建时间',
                        key: 'createdTime'
                    },
                    {
                        title: '最后修改人账号',
                        key: 'lastupdatedBy'
                    },
                    {
                        title: '最后修改时间',
                        key: 'lastupdatedTime'
                    },
                    {
                        title: '操作',
                        key: 'action',
                        width: 200,
                        align: 'center',
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '5px'
                                    },
                                    on: {
                                        click: () => {
                                            this.find(params.row.id)
                                        }
                                    }
                                }, '查看'),
                                h('Button', {
                                    props: {
                                        type: 'warning',
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '5px'
                                    },
                                    on: {
                                        click: () => {
                                            this.edit(params.row.id)
                                        }
                                    }
                                }, '编辑'),
                                h('Button', {
                                    props: {
                                        type: 'error',
                                        size: 'small'
                                    },
                                    on: {
                                        click: () => {
                                            this.remove(params.row.id)
                                        }
                                    }
                                }, '删除')
                            ]);
                        }
                    }
                ],
                rule: {
                    userName: [
                        {required: false, message: '请输入姓名', trigger: 'red'}
                    ],
                    loginName: [
                        {required: false, message: '请输入登录用户名', trigger: 'red'}
                    ],
                    password: [
                        {required: false, message: '请输入密码', trigger: 'red'}
                    ],
                    postName: [
                        {required: false, message: '请输入岗位名称', trigger: 'red'}
                    ],
                    status: [
                        {required: false, message: '请输入状态（启用、冻结）', trigger: 'red'}
                    ],
                    memo: [
                        {required: false, message: '请输入备注信息', trigger: 'red'}
                    ],
                    createdBy: [
                        {required: false, message: '请输入创建人账号', trigger: 'red'}
                    ],
                    createdTime: [
                        {required: false, message: '请输入创建时间', trigger: 'red'}
                    ],
                    lastupdatedBy: [
                        {required: false, message: '请输入最后修改人账号', trigger: 'red'}
                    ],
                    lastupdatedTime: [
                        {required: false, message: '请输入最后修改时间', trigger: 'red'}
                    ],
                }
            }
        },
        mounted(){
            this.queryUser({
//                userName:"test",
                page:this.currentPage,
            });
        },
        computed:{
            ...mapGetters({
                historyData: 'getUsers',
                dataCount: 'getUserTotal',
                current: 'getCurrentUser'
            })
        },
        methods:{
            //action方法
            ...mapActions([
                'cleanCurrentUser',
                'queryUser',
                'findByUserId',
                'saveOrUpdateUser',
                'deleteUser',
                'batchDeleteUser'
            ]),
            //翻页
            change(val) {
                this.currentPage = val;
                //下一页参数
                this.queryUser({
//                  userName:"123",
                    page:this.currentPage
                });
            },
            edit(index){
                this.findByUserId({
                    "id":index
                });
                this.disable = false;
                this.formModel=true;
                this.submitModel=true;
            },
            find(index){
                this.findByUserId({
                    "id":index
                });
                this.disable = true;
                this.formModel=true;
            },
            submitOk(){
                this.formModel=false;
                if(this.disable == false){
                    this.submitModel=true;
                }
            },
            remove(index){
                this.$Modal.warning({
                    title: '删除',
                    content: '你确定删除数据吗？',
                    onOk: () => {
                        this.deleteUser({
                            "id":index
                        }).then(() => this.$router.go(0));
                    },
                    onCancel: () => {
                        this.$Message.info('取消操作！');
                    }
                });
            },
            submit(){
                this.saveOrUpdateUser(this.current).then(() => this.success());
            },
            success () {
                this.submitModel = false;
                this.$Message.success('提交成功');
            },
            //取消操作
            cancel(){
                this.$Notice.info({
                    title: '通知',
                    desc: '取消操作'
                });
                this.formModel=true;
            }
        }
    }
</script>