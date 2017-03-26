package com.ayyeka.server.model.persistency.dataTransferObjects;

import java.util.Date;

import com.ayyeka.server.model.api.AggregationTypeEnum;

public class AggregatedMeasuresDto 
{
	private Integer id;
	private Integer deviceId;
	private Integer aggregatedTypeId;
	private Date time;
	private Integer countMeasures;
	private Float average;
	
	//Calculated according to:  aggregatedTypeId and time
	private Date calculatedStartTime;
	private Date calculatedEndTime;

	/**
	 * Updates this.calculatedStartTime and this.calculatedEndTime.
	 * Calculation is done according to:  aggregatedTypeId and time.
	 * For example:  if  aggregatedTypeId is YEAR and time is 2017-03-24
	 *               then calculatedStartTime=2017-01-01, calculatedEndTime=2017-12-31
	 *                
	 */
	public void updaetDateRangeAccordingToAggType() {
		
		AggregationTypeEnum aggregationTypeEnum = AggregationTypeEnum.valueOf(aggregatedTypeId);
		
		//TBD !!!
		switch(aggregationTypeEnum) {
			case YEAR: calculatedStartTime = new Date();
					   calculatedEndTime = new Date();	
					   break;
			case MONTH: calculatedStartTime = new Date();
			   			calculatedEndTime = new Date();	
			   			break;
			case UNKNOWN: calculatedStartTime = new Date();
			   			  calculatedEndTime = new Date();	
			   			  break;
		}
	}
	
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
