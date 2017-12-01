package com.richeninfo.rubbish.bdposition.handler;

import cn.hylexus.jt808.common.TPMSConsts;
import cn.hylexus.jt808.service.codec.MsgDecoder;
import cn.hylexus.jt808.service.handler.DefaultServerHandler;
import cn.hylexus.jt808.vo.PackageData;
import cn.hylexus.jt808.vo.req.LocationInfoUploadMsg;
import cn.hylexus.jt808.vo.req.TerminalAuthenticationMsg;
import cn.hylexus.jt808.vo.req.TerminalRegisterMsg;
import com.richeninfo.rubbish.bdposition.service.MsgProcessService;
import io.netty.channel.ChannelHandler.Sharable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * 处理请求逻辑
 */
@Sharable
public class ServiceHandler extends DefaultServerHandler {
    private static final Logger logger = LoggerFactory.getLogger(ServiceHandler.class);
    private final MsgDecoder decoder = new MsgDecoder();
    @Resource
    private MsgProcessService service;

    public ServiceHandler(MsgProcessService service) {
        super(service);
        this.service = service;
    }

    @Override
    public void processPackageData(PackageData packageData) {
        final PackageData.MsgHeader header = packageData.getMsgHeader();
        logger.info(">>>>>packageData.info,packageData={}",packageData);
        // 1. 终端心跳-消息体为空 ==> 平台通用应答
        if (TPMSConsts.msg_id_terminal_heart_beat == header.getMsgId()) {
            logger.info(">>>>>[终端心跳],phone={},flowid={}", header.getTerminalPhone(), header.getFlowId());
            try {
                this.service.processTerminalHeartBeatMsg(packageData);
                logger.info("<<<<<[终端心跳],phone={},flowid={}", header.getTerminalPhone(), header.getFlowId());
            } catch (Exception e) {
                logger.error("<<<<<[终端心跳]处理错误,phone={},flowid={},err={}", header.getTerminalPhone(), header.getFlowId(),
                        e.getMessage());
                e.printStackTrace();
            }
        }
        // 5. 终端鉴权 ==> 平台通用应答
        else if (TPMSConsts.msg_id_terminal_authentication == header.getMsgId()) {
            logger.info(">>>>>[终端鉴权],phone={},flowid={}", header.getTerminalPhone(), header.getFlowId());
            try {
                TerminalAuthenticationMsg authenticationMsg = new TerminalAuthenticationMsg(packageData);
                this.service.processAuthMsg(authenticationMsg);
                logger.info("<<<<<[终端鉴权],phone={},flowid={}", header.getTerminalPhone(), header.getFlowId());
            } catch (Exception e) {
                logger.error("<<<<<[终端鉴权]处理错误,phone={},flowid={},err={}", header.getTerminalPhone(), header.getFlowId(),
                        e.getMessage());
                e.printStackTrace();
            }
        }
        // 6. 终端注册 ==> 终端注册应答
        else if (TPMSConsts.msg_id_terminal_register == header.getMsgId()) {
            logger.info(">>>>>[终端注册],phone={},flowid={}", header.getTerminalPhone(), header.getFlowId());
            try {
                TerminalRegisterMsg msg = this.decoder.toTerminalRegisterMsg(packageData);
                logger.info("终端正在注册");
                this.service.processRegisterMsg(msg);
                logger.info("<<<<<[终端注册],phone={},flowid={}", header.getTerminalPhone(), header.getFlowId());
            } catch (Exception e) {
                logger.error("<<<<<[终端注册]处理错误,phone={},flowid={},err={}", header.getTerminalPhone(), header.getFlowId(),
                        e.getMessage());
                e.printStackTrace();
            }
        }
        // 7. 终端注销(终端注销数据消息体为空) ==> 平台通用应答
        else if (TPMSConsts.msg_id_terminal_log_out == header.getMsgId()) {
            logger.info(">>>>>[终端注销],phone={},flowid={}", header.getTerminalPhone(), header.getFlowId());
            try {
                this.service.processTerminalLogoutMsg(packageData);
                logger.info("<<<<<[终端注销],phone={},flowid={}", header.getTerminalPhone(), header.getFlowId());
            } catch (Exception e) {
                logger.error("<<<<<[终端注销]处理错误,phone={},flowid={},err={}", header.getTerminalPhone(), header.getFlowId(),
                        e.getMessage());
                e.printStackTrace();
            }
        }
        // 3. 位置信息汇报 ==> 平台通用应答
        else if (TPMSConsts.msg_id_terminal_location_info_upload == header.getMsgId()) {
            logger.info(">>>>>[位置信息],phone={},flowid={}", header.getTerminalPhone(), header.getFlowId());
            try {
                LocationInfoUploadMsg locationInfoUploadMsg = this.decoder.toLocationInfoUploadMsg(packageData);
                System.out.println(locationInfoUploadMsg);
                this.service.processLocationInfoUploadMsg(locationInfoUploadMsg);
                logger.info("<<<<<[位置信息],phone={},flowid={}", header.getTerminalPhone(), header.getFlowId());
            } catch (Exception e) {
                logger.error("<<<<<[位置信息]处理错误,phone={},flowid={},err={}", header.getTerminalPhone(), header.getFlowId(),
                        e.getMessage());
                e.printStackTrace();
            }
        }
        // 其他情况
        else {
            logger.error(">>>>>>[未知消息类型],phone={},msgId={},package={}", header.getTerminalPhone(), header.getMsgId(),
                    packageData);
        }
    }
}
