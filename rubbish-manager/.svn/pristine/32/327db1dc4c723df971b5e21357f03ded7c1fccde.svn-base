/*
 * Author xuliangjun Inc.
 * Copyright (c) 2016 - 2017 All Rights Reserved.
 * Powered By [rapid-generator]
 */

package com.richeninfo.rubbish.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.richeninfo.rubbish.entity.mapper.VehicleLocuMapper;
import com.richeninfo.rubbish.entity.model.Apply;
import com.richeninfo.rubbish.entity.model.Vehicle;
import com.richeninfo.rubbish.entity.model.VehicleLocu;
import com.richeninfo.rubbish.entity.model.VehiclePlace;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service("vehicleLocuService")
public class VehicleLocuService extends ServiceImpl<VehicleLocuMapper, VehicleLocu>{

	@Resource
	private ApplyService applyService;

	@Resource
	private VehiclePlaceService vehiclePlaceService;

	public boolean deleteAll() {
		return retBool(baseMapper.deleteAll());
	}

	public void timer(){
		List<Place> placeIdList=new ArrayList<>();
		EntityWrapper<VehicleLocu> vehicleLocuEntityWrapper=new EntityWrapper<>();
		String dateString = getYesterdayString();
		vehicleLocuEntityWrapper.between("created_time",dateString+" 00:00:00",dateString+" 23:59:59");
		vehicleLocuEntityWrapper.isNotNull("temp_num");
		vehicleLocuEntityWrapper.orderBy("facility_no desc,created_time asc");
		List<VehicleLocu> vehicleLocuList=this.selectList(vehicleLocuEntityWrapper);
		Map<String,List<VehicleLocu>> mapVehicleLocuByFacilityNo=vehicleLocuList.stream()
				.collect(Collectors.groupingBy(VehicleLocu::getFacilityNo));
		for(Map.Entry<String,List<VehicleLocu>> entryVehilcleByFacilityNo: mapVehicleLocuByFacilityNo.entrySet()) {
			 //map.keySet()返回的是所有key的值
			 List<VehicleLocu> vehicleLocuListByFacilityNo = entryVehilcleByFacilityNo.getValue();//得到每个key对用value的值
            Map<Integer,List<VehicleLocu>> mapVehicleLocuByTempNum = vehicleLocuListByFacilityNo.stream()
					.collect(Collectors.groupingBy(VehicleLocu::getTempNum));
			for(Map.Entry<Integer,List<VehicleLocu>> entryVehicleLocuByTempNum: mapVehicleLocuByTempNum.entrySet()) {
					List<VehicleLocu> vehicleLocuListByTempNum=entryVehicleLocuByTempNum.getValue();
				if (null!=vehicleLocuListByTempNum&&vehicleLocuListByTempNum.size()>10){//当小于100米的点的个数大于10个点时才认为到达场地了
					Place place=new Place();
					place.setArriveTime(vehicleLocuListByTempNum.get(0).getCreatedTime());
					place.setSimNo(vehicleLocuListByTempNum.get(0).getFacilityNo());
					place.setPlaceId(vehicleLocuListByTempNum.get(0).getPlaceId());
					placeIdList.add(place);
				}
			}
		}

		Map<String,List<Place>> map1=placeIdList.stream()
				.collect(Collectors.groupingBy(Place::getSimNo));
		for(Map.Entry<String,List<Place>> entry: map1.entrySet()) {
			List<Place> placeList =entry.getValue();

			if(null!=placeList&&placeList.size()>0){
				String dateStringTemp=getDateString();
				EntityWrapper<VehiclePlace> vehiclePlaceEntityWrapper=new EntityWrapper<>();
				vehiclePlaceEntityWrapper.lt("arrive_time",dateStringTemp+" 23:59:59");
				vehiclePlaceEntityWrapper.gt("arrive_time",dateStringTemp+" 00:00:00");
				vehiclePlaceEntityWrapper.eq("sim_no",placeList.get(0).getSimNo());
				VehiclePlace vehiclePlace=vehiclePlaceService.selectOne(vehiclePlaceEntityWrapper);
				if(null!=vehiclePlace){
					Place place=new Place();
					place.setArriveTime(vehiclePlace.getArriveTime());
					place.setType(vehiclePlace.getType());
					place.setWeight(vehiclePlace.getWeight());
					if(null!=vehiclePlace.getWeight()){
						place.setWeight(vehiclePlace.getWeight());
					}
//					vehiclePlace
					placeList.add(0,place);
				}
				for(int i=0;i<placeList.size();i++){
					//如果是焚烧场，直接continue
					if(placeList.get(i).getType()==3){
						continue;
					}else if (i!=0&&placeList.get(i).getType()==2&&placeList.get(i-1).getType()==1){
						//往行程单表插入一条记录，从工地--->>>中转站
						Apply apply=new Apply();
						apply.setType(0);
						apply.setStartTime(placeList.get(i-1).getArriveTime());
						apply.setEndTime(placeList.get(i).getArriveTime());
						apply.setWeight(placeList.get(i).getWeight());
						apply.setSimNo(placeList.get(i).getSimNo());
						applyService.insert(apply);
					}else if (i!=0&&placeList.get(i).getType()==3&&placeList.get(i-1).getType()==2){
						//往行程单表插入一条记录，从中转站--->>>焚烧场
						Apply apply=new Apply();
						apply.setType(1);
						apply.setStartTime(placeList.get(i-1).getArriveTime());
						apply.setEndTime(placeList.get(i).getArriveTime());
						apply.setWeight(placeList.get(i-1).getWeight());
						apply.setSimNo(placeList.get(i).getSimNo());
						applyService.insert(apply);
					}else if (i==placeList.size()&&placeList.get(placeList.size()).getType()==1){
						//最后一个场地是垃圾起源地
						//相当于头一天车将垃圾从垃圾源头带回家（计入第二天行程单）
						VehiclePlace vehiclePlace1=new VehiclePlace();
						vehiclePlace1.setArriveTime(placeList.get(placeList.size()).getArriveTime());
						vehiclePlace1.setType(1);
						vehiclePlace1.setSimNo(placeList.get(placeList.size()).getSimNo());
						vehiclePlaceService.insert(vehiclePlace1);
					}else if (i==placeList.size()&&placeList.get(placeList.size()-1).getType()!=1&&placeList.get(placeList.size()).getType()==2){
						//最后一个场地是垃圾起源地
						//相当于头一天车将垃圾从中转站带回家（计入第二天行程单）
						VehiclePlace vehiclePlace1=new VehiclePlace();
						vehiclePlace1.setArriveTime(placeList.get(placeList.size()).getArriveTime());
						vehiclePlace1.setType(1);
						vehiclePlace1.setWeight(placeList.get(placeList.size()).getWeight());
						vehiclePlace1.setSimNo(placeList.get(placeList.size()).getSimNo());
						vehiclePlaceService.insert(vehiclePlace1);
					}
				}
			}
		}
	}

	private String getDateString() {
		Date date=new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String  dateString = format1.format(date);
		dateString=dateString.substring(0,10);
		return dateString;
	}

	private String getYesterdayString() {
		Date as = new Date(new Date().getTime()-24*60*60*1000);
		SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd");
		String time = matter1.format(as);
		return time;
	}

	class Place{
		private Integer placeId;
		private Integer Type;
		private String simNo;
		private Date arriveTime;
		private double weight;

		public Integer getPlaceId() {
			return placeId;
		}

		public void setPlaceId(Integer placeId) {
			this.placeId = placeId;
		}

		public Integer getType() {
			return Type;
		}

		public void setType(Integer type) {
			Type = type;
		}

		public String getSimNo() {
			return simNo;
		}

		public void setSimNo(String simNo) {
			this.simNo = simNo;
		}

		public Date getArriveTime() {
			return arriveTime;
		}

		public void setArriveTime(Date arriveTime) {
			this.arriveTime = arriveTime;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}
	}
}