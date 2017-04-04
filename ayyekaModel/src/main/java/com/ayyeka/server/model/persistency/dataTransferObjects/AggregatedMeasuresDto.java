package com.ayyeka.server.model.persistency.dataTransferObjects;


import com.ayyeka.server.model.api.AggregationTypeEnum;

public class AggregatedMeasuresDto 
{
	private Integer id;
	private Integer deviceId;
	private Integer aggregatedTypeId;
	private Integer aggregatedYear;
	private Integer aggregatedMonth;
	private Integer aggregatedDayOfMonth;
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

	public Integer getAggregatedYear() {
		return aggregatedYear;
	}

	public void setAggregatedYear(Integer aggregatedYear) {
		this.aggregatedYear = aggregatedYear;
	}

	public Integer getAggregatedMonth() {
		return aggregatedMonth;
	}

	public void setAggregatedMonth(Integer aggregatedMonth) {
		this.aggregatedMonth = aggregatedMonth;
	}

	public Integer getAggregatedDayOfMonth() {
		return aggregatedDayOfMonth;
	}

	public void setAggregatedDayOfMonth(Integer aggregatedDayOfMonth) {
		this.aggregatedDayOfMonth = aggregatedDayOfMonth;
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
