package com.ayyeka.server.model.api.dataObjects;

import java.util.Date;

public class RawMeasure 
{
	private Integer id;
	private Integer deviceId;
	private Date time;
	private float measuredValue;


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

	public float getMeasuredValue() {
		return measuredValue;
	}
	
	public void setMeasuredValue(float measuredValue) {
		this.measuredValue = measuredValue;
	}
	

}
