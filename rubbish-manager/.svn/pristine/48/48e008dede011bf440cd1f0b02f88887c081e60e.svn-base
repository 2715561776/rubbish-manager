package com.richeninfo.rubbish.bdposition;

import cn.hylexus.jt808.server.TCPServer;
import com.richeninfo.rubbish.bdposition.handler.ServiceHandler;
import com.richeninfo.rubbish.bdposition.service.MsgProcessService;

/**
 * 执行main方法
 * java -jar rubbish-bd-position-exec.jar
 */
public class TCPServerMain {
	public static void main(String[] args) {
		GeoUtil.getDistanceOfMeter(0.010000707d,832313590000000d,-166760.02d,0.00004511981d);
		TCPServer server = new TCPServer(8888, new ServiceHandler(new MsgProcessService()));
		server.startServer();
	}
}