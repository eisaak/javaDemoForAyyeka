package com.ayyeka.server.model.api.dataObjects;

import java.util.Date;

public class AggregatedMeasures 
{
	private Integer id;
	private Integer deviceId;
	private Integer aggregatedTypeId;
	private Date time;
	private Integer countMeasures;
	private Float average;	

	public Integer getAggregatedTypeId() {
		return aggregatedTypeId;
	}
	public void setAggregatedTypeId(Integer aggregatedTypeId) {
		this.aggregatedTypeId = aggregatedTypeId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getCountMeasures() {
		return countMeasures;
	}
	public void setCountMeasures(Integer countMeasures) {
		this.countMeasures = countMeasures;
	}
	public Float getAverage() {
		return average;
	}
	public void setAverage(Float average) {
		this.average = average;
	}
	
}
