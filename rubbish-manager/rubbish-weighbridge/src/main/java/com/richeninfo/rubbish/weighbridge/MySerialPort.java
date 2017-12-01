package com.richeninfo.rubbish.weighbridge;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.richeninfo.rubbish.entity.model.Vehicle;
import com.richeninfo.rubbish.entity.model.VehicleLocu;
import com.richeninfo.rubbish.service.VehicleLocuService;
import com.richeninfo.rubbish.service.VehicleService;
import com.richeninfo.rubbish.service.util.SpringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Date;


public class MySerialPort {
//
//	@Resource
	private VehicleLocuService vehicleLocuService;


	public MySerialPort(VehicleLocuService vehicleLocuService){
		this.vehicleLocuService=vehicleLocuService;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String portName = "COM3";
		int timeWait = 3;
		CommPortIdentifier portIdentifier = null;
		SerialPort  sPort = null;
		BufferedInputStream in = null;
		byte[] data = new byte[1024];
		int dataLen = 0;
		try {
			System.out.println("com口个数："+SerialTool.findPort().size());
			SerialPort serialPort=SerialTool.openPort("COM4",1200);
			while (true){
				try {
					SerialTool.readFromPort(serialPort);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sPort.close();
		}


	}

	public void start(String portName,int baudrate){
		EntityWrapper<Vehicle> vehicleEntityWrapper=new EntityWrapper<>();


		SerialPort  sPort = null;
		try {
			vehicleLocuService.selectList(new EntityWrapper<>());
			System.out.println("com口个数："+SerialTool.findPort().size());
			SerialPort serialPort=SerialTool.openPort(portName,baudrate);
			while (true){
				try {
					Thread.sleep(1000);
					Double weight=SerialTool.readFromPort(serialPort);
					VehicleLocu vehicleLocu=new VehicleLocu();
					vehicleLocu.setLatitude(Float.parseFloat(String.valueOf(weight)));
					vehicleLocuService.insert(vehicleLocu);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sPort.close();
		}

	}

}
