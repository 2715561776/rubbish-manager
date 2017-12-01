package com.richeninfo.rubbish.bdposition.service;

import cn.hylexus.jt808.server.SessionManager;
import cn.hylexus.jt808.service.BaseMsgProcessService;
import cn.hylexus.jt808.service.codec.MsgDecoder;
import cn.hylexus.jt808.service.codec.MsgEncoder;
import cn.hylexus.jt808.vo.PackageData;
import cn.hylexus.jt808.vo.PackageData.MsgHeader;
import cn.hylexus.jt808.vo.Session;
import cn.hylexus.jt808.vo.req.LocationInfoUploadMsg;
import cn.hylexus.jt808.vo.req.TerminalAuthenticationMsg;
import cn.hylexus.jt808.vo.req.TerminalRegisterMsg;
import cn.hylexus.jt808.vo.resp.ServerCommonRespMsgBody;
import cn.hylexus.jt808.vo.resp.TerminalRegisterMsgRespBody;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.itcloudinfo.commons.util.GeoUtil;
import com.itcloudinfo.commons.util.StringUtil;
import com.richeninfo.rubbish.entity.enums.ApplyEnum;
import com.richeninfo.rubbish.entity.enums.ApplyStatusEnum;
import com.richeninfo.rubbish.entity.enums.TransferStationApplyEnum;
import com.richeninfo.rubbish.entity.enums.VehicleAppointEnum;
import com.richeninfo.rubbish.entity.model.*;
import com.richeninfo.rubbish.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("msgProcessService")
public class MsgProcessService extends BaseMsgProcessService {

    @Resource
    private TransferStationApplyService transferStationApplyService;

    @Resource
    private VehicleAppointService vehicleAppointService;

    @Resource
    private ApplyService applyService;

    @Resource
    private PlaceInfoService placeInfoService;

    @Resource
    private VehicleLocuService vehicleLocuService;

    @Resource
    private VehicleTempService vehicleTempService;

    private static final Logger logger = LoggerFactory.getLogger(MsgProcessService.class);
    private MsgEncoder msgEncoder;
    private MsgDecoder msgDecoder;
    private SessionManager sessionManager;

    public MsgProcessService() {
        this.msgEncoder = new MsgEncoder();
        this.msgDecoder = new MsgDecoder();
        this.sessionManager = SessionManager.getInstance();
    }

    public void processRegisterMsg(TerminalRegisterMsg msg) throws Exception {
        logger.info("终端注册:{}", JSON.toJSONString(msg, true));

        final String sessionId = Session.buildId(msg.getChannel());
        Session session = sessionManager.findBySessionId(sessionId);
        if (session == null) {
            session = Session.buildSession(msg.getChannel(), msg.getMsgHeader().getTerminalPhone());
        }
        session.setAuthenticated(true);
        session.setTerminalPhone(msg.getMsgHeader().getTerminalPhone());
        sessionManager.put(session.getId(), session);

        TerminalRegisterMsgRespBody respMsgBody = new TerminalRegisterMsgRespBody();
        respMsgBody.setReplyCode(TerminalRegisterMsgRespBody.success);
        respMsgBody.setReplyFlowId(msg.getMsgHeader().getFlowId());

        String uuid= StringUtil.getUID32();
        // TODO 鉴权码暂时写死
        logger.info("UUID是多少:{}",uuid);
        respMsgBody.setReplyToken(uuid);
        int flowId = super.getFlowId(msg.getChannel());
        byte[] bs = this.msgEncoder.encode4TerminalRegisterResp(msg, respMsgBody, flowId);
        logger.info("注册成功:{}",this.msgDecoder.bytes2PackageData(bs).toString());
        super.send2Client(msg.getChannel(), bs);
    }

    public void processAuthMsg(TerminalAuthenticationMsg msg) throws Exception {
        // TODO 暂时每次鉴权都成功
        logger.info("终端鉴权:{}", JSON.toJSONString(msg, true));

        final String sessionId = Session.buildId(msg.getChannel());
        Session session = sessionManager.findBySessionId(sessionId);
        if (session == null) {
            session = Session.buildSession(msg.getChannel(), msg.getMsgHeader().getTerminalPhone());
        }
        session.setAuthenticated(true);
        session.setTerminalPhone(msg.getMsgHeader().getTerminalPhone());
        sessionManager.put(session.getId(), session);

        ServerCommonRespMsgBody respMsgBody = new ServerCommonRespMsgBody();
        respMsgBody.setReplyCode(ServerCommonRespMsgBody.success);
        respMsgBody.setReplyFlowId(msg.getMsgHeader().getFlowId());
        respMsgBody.setReplyId(msg.getMsgHeader().getMsgId());
        int flowId = super.getFlowId(msg.getChannel());
        byte[] bs = this.msgEncoder.encode4ServerCommonRespMsg(msg, respMsgBody, flowId);
        super.send2Client(msg.getChannel(), bs);
    }

    public void processTerminalHeartBeatMsg(PackageData req) throws Exception {
        logger.info("心跳信息:{}", JSON.toJSONString(req, true));
        final MsgHeader reqHeader = req.getMsgHeader();
        ServerCommonRespMsgBody respMsgBody = new ServerCommonRespMsgBody(reqHeader.getFlowId(), reqHeader.getMsgId(),
                ServerCommonRespMsgBody.success);
        int flowId = super.getFlowId(req.getChannel());
        byte[] bs = this.msgEncoder.encode4ServerCommonRespMsg(req, respMsgBody, flowId);
        super.send2Client(req.getChannel(), bs);
    }

    public void processTerminalLogoutMsg(PackageData req) throws Exception {
        logger.info("终端注销:{}", JSON.toJSONString(req, true));
        final MsgHeader reqHeader = req.getMsgHeader();
        ServerCommonRespMsgBody respMsgBody = new ServerCommonRespMsgBody(reqHeader.getFlowId(), reqHeader.getMsgId(),
                ServerCommonRespMsgBody.success);
        int flowId = super.getFlowId(req.getChannel());
        byte[] bs = this.msgEncoder.encode4ServerCommonRespMsg(req, respMsgBody, flowId);
        super.send2Client(req.getChannel(), bs);
    }

    public void processLocationInfoUploadMsg(LocationInfoUploadMsg req) throws Exception {
        logger.info("位置 信息:{}", JSON.toJSONString(req, true));
        recordLocation(req);
//        processVehicalLocus(req);
        final MsgHeader reqHeader = req.getMsgHeader();
        ServerCommonRespMsgBody respMsgBody = new ServerCommonRespMsgBody(reqHeader.getFlowId(), reqHeader.getMsgId(),
                ServerCommonRespMsgBody.success);
        int flowId = super.getFlowId(req.getChannel());
        byte[] bs = this.msgEncoder.encode4ServerCommonRespMsg(req, respMsgBody, flowId);
        super.send2Client(req.getChannel(), bs);
    }

    private void recordLocation(LocationInfoUploadMsg req) {
        VehicleLocu vehicleLocu=new VehicleLocu();

        List<PlaceInfo> placeInfoList=placeInfoService.selectList(new EntityWrapper<>());
        EntityWrapper<VehicleTemp> vehicleTempEntityWrapper=new EntityWrapper<>();
        vehicleTempEntityWrapper.eq("sim_no",req.getMsgHeader().getTerminalPhone());
        VehicleTemp vehicleTemp=vehicleTempService.selectOne(vehicleTempEntityWrapper);

        for(PlaceInfo placeInfo:placeInfoList){
            String[] places=placeInfo.getPlaces().split(",");
            List<Double> distances=new ArrayList<>();
            for(int i=0;i<places.length;i+=2){
                distances.add(GeoUtil.getDistanceOfMeter(Double.parseDouble(places[i]),Double.parseDouble(places[i+1]),req.getLatitude(),req.getLongitude()));
            }
            //取一个场地中最近点的距离
            Optional<Double> op=distances.stream()
                    .min(Double::compare);

            if(op.get()<100){
                vehicleTemp.setPlaceId(placeInfo.getId());
                vehicleTemp.setFlag(1);//在接近地点中
                vehicleTempService.updateById(vehicleTemp);
                vehicleLocu.setPlaceId(placeInfo.getId());
                vehicleLocu.setTempNum(vehicleTemp.getTempNum());
            }else if(op.get()>100&&vehicleTemp.getFlag()==1){
                vehicleTemp.setTempNum(vehicleTemp.getTempNum()+1);
                vehicleTemp.setFlag(0);//远离地点
                vehicleTempService.updateById(vehicleTemp);
            }
        }

//        vehicleLocu.setApplyID(apply.getId());
        vehicleLocu.setFacilityNo(req.getMsgHeader().getTerminalPhone());
//                vehicleLocu.setCardNumber();
        vehicleLocu.setCurrentTime(req.getTime());
        vehicleLocu.setCreatedTime(new Date());
        vehicleLocu.setLastupdatedTime(new Date());
        vehicleLocu.setLatitude(req.getLatitude()/1000000);
        vehicleLocu.setLongitude(req.getLongitude()/1000000);
        vehicleLocuService.insert(vehicleLocu);
    }

    private void processVehicalLocus(LocationInfoUploadMsg req) {
        String terminalPhone=req.getMsgHeader().getTerminalPhone();
        EntityWrapper<TransferStationApply> transferStationApplyEntityWrapper=new EntityWrapper<TransferStationApply>();
        transferStationApplyEntityWrapper.and("status={0} or status={1}", TransferStationApplyEnum.Before,TransferStationApplyEnum.Working);
        transferStationApplyEntityWrapper.eq("FACILITY_NO",terminalPhone);
        TransferStationApply transferStationApply=transferStationApplyService.selectOne(transferStationApplyEntityWrapper);
        PlaceInfo placeInfo= placeInfoService.selectById(transferStationApply.getPlaceId());
        Double distanceOfTranseferToProcess= GeoUtil.getDistanceOfMeter(placeInfo.getLatitude(),placeInfo.getLongitude(),req.getLatitude(),req.getLongitude());
        if(null!=transferStationApply){
            if(null==transferStationApply.getApplyId() && distanceOfTranseferToProcess<100) {
                Apply apply = new Apply();
                apply.setType(1);
                apply.setCreatedTime(new Date());
                apply.setLastupdatedTime(new Date());
                apply.setStatus(ApplyStatusEnum.Begin.getCode());//开始
                apply.setSimNo(terminalPhone);
                applyService.insert(apply);
                transferStationApply.setApplyId(apply.getId());
                transferStationApply.setStatus(TransferStationApplyEnum.Working.getCode());
                transferStationApplyService.updateById(transferStationApply);
                VehicleLocu vehicleLocu=new VehicleLocu();
                vehicleLocu.setApplyId(apply.getId());
                vehicleLocu.setFacilityNo(terminalPhone);
//                vehicleLocu.setCardNumber();
                vehicleLocu.setCurrentTime(req.getTime());
                vehicleLocu.setCreatedTime(new Date());
                vehicleLocu.setLastupdatedTime(new Date());
                vehicleLocu.setLatitude(req.getLatitude());
                vehicleLocu.setLongitude(req.getLongitude());
                vehicleLocuService.insert(vehicleLocu);

            }else {
                    Apply apply=applyService.selectById(transferStationApply.getApplyId());
                    PlaceInfo placeInfoOfTraseferStation=placeInfoService.selectById(101);
                    Double distanceOfTranseferToProcess1=GeoUtil.getDistanceOfMeter(placeInfoOfTraseferStation.getLatitude(),placeInfoOfTraseferStation.getLongitude(),req.getLatitude(),req.getLongitude());
                    if(null!=apply&&apply.getStatus()!=2&&distanceOfTranseferToProcess1>100){
                        apply.setStatus(ApplyStatusEnum.Working.getCode());
                        applyService.updateById(apply);
                        VehicleLocu vehicleLocu=new VehicleLocu();
                        vehicleLocu.setApplyId(apply.getId());
                        vehicleLocu.setFacilityNo(terminalPhone);
//                vehicleLocu.setCardNumber();
                        vehicleLocu.setCurrentTime(req.getTime());
                        vehicleLocu.setCreatedTime(new Date());
                        vehicleLocu.setLastupdatedTime(new Date());
                        vehicleLocu.setLatitude(req.getLatitude());
                        vehicleLocu.setLongitude(req.getLongitude());
                        vehicleLocuService.insert(vehicleLocu);
                    }else if (null!=apply&&apply.getStatus()!=2&&distanceOfTranseferToProcess1<100){
                        transferStationApply.setStatus(TransferStationApplyEnum.End.getCode());
                        transferStationApplyService.updateById(transferStationApply);
                        apply.setStatus(ApplyStatusEnum.End.getCode());
                        applyService.updateById(apply);
                        VehicleLocu vehicleLocu=new VehicleLocu();
                        vehicleLocu.setApplyId(apply.getId());
                        vehicleLocu.setFacilityNo(terminalPhone);
//                vehicleLocu.setCardNumber();
                        vehicleLocu.setCurrentTime(req.getTime());
                        vehicleLocu.setCreatedTime(new Date());
                        vehicleLocu.setLastupdatedTime(new Date());
                        vehicleLocu.setLatitude(req.getLatitude());
                        vehicleLocu.setLongitude(req.getLongitude());
                        vehicleLocuService.insert(vehicleLocu);
                    }
            }
        }

        EntityWrapper<VehicleAppoint> vehicleAppointEntityWrapper=new EntityWrapper<VehicleAppoint>();
        vehicleAppointEntityWrapper.and("status={0} or status={1}", VehicleAppointEnum.Before,VehicleAppointEnum.Working);
        vehicleAppointEntityWrapper.eq("FACILITY_NO",terminalPhone);
        VehicleAppoint vehicleAppoint=vehicleAppointService.selectOne(vehicleAppointEntityWrapper);
        PlaceInfo placeInfo1=placeInfoService.selectById(vehicleAppoint.getPlaceId());
        Double distanceOfSourceToTransefer=GeoUtil.getDistanceOfMeter(placeInfo1.getLatitude(),placeInfo1.getLongitude(),req.getLatitude(),req.getLongitude());
        if(null!=vehicleAppoint){
            if(null==vehicleAppoint.getApplyId() && distanceOfSourceToTransefer<100) {
                Apply apply = new Apply();
                apply.setType(0);
                apply.setCreatedTime(new Date());
                apply.setLastupdatedTime(new Date());
                apply.setStatus(ApplyStatusEnum.Begin.getCode());//开始
                apply.setSimNo(terminalPhone);
                applyService.insert(apply);
                vehicleAppoint.setApplyId(apply.getId());
                vehicleAppoint.setStatus(VehicleAppointEnum.Working.getCode());
                vehicleAppointService.updateById(vehicleAppoint);
                VehicleLocu vehicleLocu=new VehicleLocu();
                vehicleLocu.setApplyId(apply.getId());
                vehicleLocu.setFacilityNo(terminalPhone);
//                vehicleLocu.setCardNumber();
                vehicleLocu.setCurrentTime(req.getTime());
                vehicleLocu.setCreatedTime(new Date());
                vehicleLocu.setLastupdatedTime(new Date());
                vehicleLocu.setLatitude(req.getLatitude());
                vehicleLocu.setLongitude(req.getLongitude());
                vehicleLocuService.insert(vehicleLocu);

            }else {
                Apply apply=applyService.selectById(vehicleAppoint.getApplyId());
                PlaceInfo placeInfoOfTraseferStation=placeInfoService.selectById(100);
                Double distanceOfSourceToTransefer1=GeoUtil.getDistanceOfMeter(placeInfoOfTraseferStation.getLatitude(),placeInfoOfTraseferStation.getLongitude(),req.getLatitude(),req.getLongitude());
                if(null!=apply&&apply.getStatus()!=2&&distanceOfSourceToTransefer1>100){
                    apply.setStatus(ApplyStatusEnum.Working.getCode());
                    applyService.updateById(apply);
                    VehicleLocu vehicleLocu=new VehicleLocu();
                    vehicleLocu.setApplyId(apply.getId());
                    vehicleLocu.setFacilityNo(terminalPhone);
//                vehicleLocu.setCardNumber();
                    vehicleLocu.setCurrentTime(req.getTime());
                    vehicleLocu.setCreatedTime(new Date());
                    vehicleLocu.setLastupdatedTime(new Date());
                    vehicleLocu.setLatitude(req.getLatitude());
                    vehicleLocu.setLongitude(req.getLongitude());
                    vehicleLocuService.insert(vehicleLocu);
                }else if (null!=apply&&apply.getStatus()!=2&&distanceOfSourceToTransefer1<100){
                    vehicleAppoint.setStatus(VehicleAppointEnum.End.getCode());
                    vehicleAppointService.updateById(vehicleAppoint);
                    apply.setStatus(ApplyStatusEnum.End.getCode());
                    applyService.updateById(apply);
                    VehicleLocu vehicleLocu=new VehicleLocu();
                    vehicleLocu.setApplyId(apply.getId());
                    vehicleLocu.setFacilityNo(terminalPhone);
//                vehicleLocu.setCardNumber();
                    vehicleLocu.setCurrentTime(req.getTime());
                    vehicleLocu.setCreatedTime(new Date());
                    vehicleLocu.setLastupdatedTime(new Date());
                    vehicleLocu.setLatitude(req.getLatitude());
                    vehicleLocu.setLongitude(req.getLongitude());
                    vehicleLocuService.insert(vehicleLocu);
                }
            }
        }
    }
}
