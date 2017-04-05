package com.ayyeka.server.model.persistency.dataTransferObjects;

import com.ayyeka.server.model.api.dataObjects.AggregatedMeasures;
import com.ayyeka.server.model.api.dataObjects.RawMeasure;

/** Note: According to SRP (Single Responsibility Principle) these conversions 
      are done here and not in the DataTransferObjects.
*/
public class DataToDtoConverter {
	

	public static RawMeasureDto convertToDto( RawMeasure rawMeasure ) {
		
		RawMeasureDto result = new RawMeasureDto();
		
		result.setId(rawMeasure.getId());
		result.setTime(rawMeasure.getTime());
		result.setDeviceId(rawMeasure.getDeviceId());
		result.setMeasuredValue(rawMeasure.getMeasuredValue());
		
		return result;
	}
	
	public static AggregatedMeasuresDto convertToDto
						(AggregatedMeasures aggregatedMeasures) {
		
		AggregatedMeasuresDto result = new AggregatedMeasuresDto();
		
		result.setId(aggregatedMeasures.getId());
		result.setAggregatedYear(aggregatedMeasures.getAggregatedYear());
		result.setAggregatedMonth(aggregatedMeasures.getAggregatedMonth());
		result.setAggregatedDayOfMonth(aggregatedMeasures.getAggregatedDayOfMonth());
		result.setDeviceId(aggregatedMeasures.getDeviceId());
		result.setCountMeasures(aggregatedMeasures.getCountMeasures());
		result.setAverage(aggregatedMeasures.getAverage());
		
		return result;
	}
	
	
	
}
