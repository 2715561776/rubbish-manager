<template>
    <div class="login-container">
        <el-form class="card-box login-form" autoComplete="on" :model="loginForm" :rules="loginRules" ref="loginForm"
                 label-position="left">
            <h3 class="title">方松街道建筑垃圾青云管理系统登录</h3>

            <el-form-item prop="username">
        <span class="svg-container svg-container_login">
          <i class="iconfont icon-admin"></i>
        </span>
                <el-input name="username" type="text" v-model="loginForm.username" autoComplete="on"
                          placeholder="请输入用户名"/>
            </el-form-item>

            <el-form-item prop="password">
        <span class="svg-container">
          <i class="iconfont icon-password"></i>
        </span>
                <el-input name="password" :type="pwdType" @keyup.enter.native="handleLogin" v-model="loginForm.password"
                          autoComplete="on"
                          placeholder="请输入密码"/>
                <span class='show-pwd' @click='showPwd'><i class="iconfont icon-eye"></i></span>
            </el-form-item>

            <el-button type="primary" style="width:100%;margin-bottom:30px;" :loading="loading"
                       @click.native.prevent="handleLogin">登录
            </el-button>

        </el-form>
    </div>
</template>

<script>
    import {isvalidUsername} from '../../../assets/js/validate'
    import {locationStroageObj} from '../../../assets/js/util'

    import {mapGetters, mapActions} from 'vuex'
    export default {
        name: 'login',
        data() {
            const validateUsername = (rule, value, callback) => {
                if (!isvalidUsername(value)) {
                    callback(new Error('请输入正确的用户名'))
                } else {
                    callback()
                }
            }
            const validatePassword = (rule, value, callback) => {
                if (value.length < 6) {
                    callback(new Error('密码不能小于6位'))
                } else {
                    callback()
                }
            }
            return {
                loginForm: {
                    username: '',
                    password: ''
                },
                loginRules: {
                    username: [{required: true, trigger: 'blur', validator: validateUsername}],
                    password: [{required: true, trigger: 'blur', validator: validatePassword}]
                },
                pwdType: 'password',
                loading: false,
            }
        },
        methods: {
            showPwd() {
                if (this.pwdType === 'password') {
                    this.pwdType = ''
                } else {
                    this.pwdType = 'password'
                }
            },
            handleLogin() {
                this.$refs.loginForm.validate(valid => {
                    if (valid) {
                        this.loading = true;
                        let loginName = this.loginForm.username.trim();
                        let passWord = this.loginForm.password.trim()
                        this.findUserByLoginNameAndPassWord({
                            loginName: loginName,
                            passWord: passWord,
                        }).then(() => {
                            let res = this.userList;
                            if (res === "") {
                                this.$router.push({path: '/'});
                                this.loading = false;
                                this.$message.error('请输入正确的用户名和密码');
                            } else {
                                this.loading = false;
                                this.$message({
                                    type: 'success',
                                    message: '登录成功!'
                                });
                                let userList = this.userList;
                                locationStroageObj.updateOrSave("userList",userList);
                                this.$router.push({path: '/carPosition'});
                            }
                        }).catch(() => {
                            this.loading = false
                        })
                    } else {
                        this.$message.error('请输入正确的用户名和密码')
                        return false
                    }
                })
            },
            //action方法
            ...mapActions([
                "findUserByLoginNameAndPassWord",
                'queryUser',
                'findByUserId',
                'saveOrUpdateUser',
                'deleteUser',
                'batchDeleteUser'
            ]),
        },
        computed: {
            ...mapGetters({
                userList: 'user',
                tableData: "getUsers",
                total: "getUserTotal",
                current: "getCurrentUser"
            })
        },
    }
</script>

<style rel="stylesheet/scss" lang="scss">
    $bg: "../../../assets/image/login3.png";
    $dark_gray: #889aa4;
    $light_gray: #eee;
    $form_bg: rgba(73, 80, 96, .6);

    .login-container {
        position: relative;
        width: 100%;
        height: 100%;
        height: 100vh;
        background: url($bg);
        background-size: cover;
        input:-webkit-autofill {
            -webkit-box-shadow: 0 0 0px 1000px #293444 inset !important;
            -webkit-text-fill-color: #fff !important;
        }
        input {
            background: transparent;
            border: 0px;
            -webkit-appearance: none;
            border-radius: 0px;
            padding: 12px 5px 12px 15px;
            color: $light_gray;
            height: 47px;
        }
        .el-input {
            display: inline-block;
            height: 47px;
            width: 85%;
        }
        .tips {
            font-size: 14px;
            color: #fff;
            margin-bottom: 10px;
        }
        .svg-container {
            padding: 6px 5px 6px 15px;
            color: $dark_gray;
            vertical-align: middle;
            width: 30px;
            display: inline-block;
            &_login {
                font-size: 20px;
            }
        }
        .title {
            font-size: 26px;
            font-weight: 400;
            color: $light_gray;
            margin: 0px auto 40px auto;
            text-align: center;
            font-weight: bold;
        }
        .login-form {
            position: absolute;
            left: 0;
            right: 0;
            width: 400px;
            padding: 35px 35px 15px 35px;
            margin: 120px auto;
            background: $form_bg;
            z-index: 999;
        }
        .el-form-item {
            border: 1px solid rgba(255, 255, 255, 0.1);
            background: rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            color: #454545;
        }
        .show-pwd {
            position: absolute;
            right: 10px;
            top: 7px;
            font-size: 16px;
            color: $dark_gray;
            cursor: pointer;
        }
        .thirdparty-button {
            position: absolute;
            right: 35px;
            bottom: 28px;
        }
    }
</style>
