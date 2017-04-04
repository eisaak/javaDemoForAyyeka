package com.ayyeka.server.model.api;

import java.util.Date;
import java.util.List;

import com.ayyeka.server.model.api.dataObjects.AggregatedMeasures;
import com.ayyeka.server.model.api.dataObjects.RawMeasure;
import com.ayyeka.server.model.persistency.dataAccessInterfaces.RawMeasureDao;


/**
 * 
 * This is the main API to handle the measures in the Business Model
 *
 */
public interface MeasuresHandler {
	
	public void setRawMeasureDao(RawMeasureDao rawMeasureDao);
	
	
	void saveMeasuresIntoPersistency(List<RawMeasure> listOfMeasures) throws Exception;

	/**
	 * This method assumes that all the possible aggregation rows in the database are
	 * already inserted manually (with count and average fields containing zero). 
	 */
	void aggregateMeasuresIntoPersistency(List<RawMeasure> listOfMeasures) throws Exception;
		
	AggregatedMeasures getAggregatedMeasures(int deviceId, Date time, AggregationTypeEnum aggType ) throws Exception;
	
}
