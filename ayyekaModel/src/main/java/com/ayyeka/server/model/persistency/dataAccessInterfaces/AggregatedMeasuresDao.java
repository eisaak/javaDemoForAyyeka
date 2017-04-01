package com.ayyeka.server.model.persistency.dataAccessInterfaces;

import com.ayyeka.server.model.persistency.dataTransferObjects.AggregatedMeasuresDto;


public interface AggregatedMeasuresDao 
{
	public void startTransaction() throws Exception;
	public void commitTransaction() throws Exception;
	public void endTransaction() throws Exception;
	
	void saveAggregatedMeasures(AggregatedMeasuresDto aggregatedMeasuresDto) throws Exception;
	
	AggregatedMeasuresDto getAggregatedMeasuresById(Integer id) throws Exception;
	
	AggregatedMeasuresDto getAggregatedMeasuresByInfo(AggregatedMeasuresDto aggregatedMeasuresDto) throws Exception;

	void updateAggregatedMeasures(AggregatedMeasuresDto aggregatedMeasuresDto) throws Exception;
}
