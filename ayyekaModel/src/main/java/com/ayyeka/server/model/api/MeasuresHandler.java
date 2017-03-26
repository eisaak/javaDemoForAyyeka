package com.ayyeka.server.model.api;

import java.util.Date;
import java.util.List;

import com.ayyeka.server.model.api.dataObjects.AggregatedMeasures;
import com.ayyeka.server.model.api.dataObjects.RawMeasure;


/**
 * 
 * This is the main API to handle the measures in the Business Model
 *
 */
public interface MeasuresHandler {
	
	void addMeasures(List<RawMeasure> listOfMeasures);
	
	//int getDeviceId(....);
	
	AggregatedMeasures getAggregatedMeasures(int deviceId, Date time, AggregationTypeEnum aggType );
	
}
