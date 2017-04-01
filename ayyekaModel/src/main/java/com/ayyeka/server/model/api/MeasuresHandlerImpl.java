package com.ayyeka.server.model.api;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;

import com.ayyeka.server.model.api.dataObjects.AggregatedMeasures;
import com.ayyeka.server.model.api.dataObjects.RawMeasure;
import com.ayyeka.server.model.persistency.dataAccessInterfaces.AggregatedMeasuresDao;
import com.ayyeka.server.model.persistency.dataAccessInterfaces.RawMeasureDao;
import com.ayyeka.server.model.persistency.dataTransferObjects.DataToDtoConverter;
import com.ayyeka.server.model.persistency.dataTransferObjects.RawMeasureDto;


public class MeasuresHandlerImpl implements MeasuresHandler {
	
	
	private ExecutorService executorService = null;  //Thread pool
	private RawMeasureDao rawMeasureDao = null;  
	private AggregatedMeasuresDao aggregatedMeasuredDao = null;

	
//------ public -----------------------
	
	
	//Ctor
	public MeasuresHandlerImpl(ExecutorService executorService) {
		
		this.executorService = executorService;
	}
	
	public void setRawMeasureDao(RawMeasureDao rawMeasureDao) {
		this.rawMeasureDao = rawMeasureDao;
	}
	
	public void setAggregatedMeasuresDao(AggregatedMeasuresDao aggregatedMeasuredDao) {
		this.aggregatedMeasuredDao = aggregatedMeasuredDao;
	}
	
	//According to SRP (Single Responsibility Principle), this method won't aggregate the data too
	@Override
	public void saveMeasuresIntoPersistency(List<RawMeasure> listOfMeasures) throws Exception {

		try {
				
			for (RawMeasure rawMeasure : listOfMeasures) {
				
				executorService.submit(   ()->saveSingleRawMeasure(rawMeasure)   );
			}	
			
		}
		catch (Exception e) {
			//Handle errors (e.g. write errors to log)
			throw e;
		}
		finally {
				try {
					aggregatedMeasuredDao.endTransaction();
				}
				catch (Exception e) {
					//Handle errors (e.g. write errors to log)
				}
		}
	}

	@Override
	public void aggregateMeasuresIntoPersistency(List<RawMeasure> listOfMeasures) {
		//TBD:
		
		//Calculate new average:  average = average + ((received value - average) / (old countValues + 1) )
		//
		//aggregatedMeasuresDao.updateAggregatedMeasures(aggregatedMeasuresDto);
		
	}
	
	@Override
	public AggregatedMeasures getAggregatedMeasures(int deviceId, Date time, AggregationTypeEnum aggType) {

		
		return null;
	}
	
	
	
//------ private -----------------------
	
	
	/**
	 * Saves and aggregates the new measured data to persistency
	 * 
	 * @param rawMeasure  a single raw measured data
	 */
	private void saveSingleRawMeasure(RawMeasure rawMeasure) {
		try {


			RawMeasureDto rawMeasureDto = DataToDtoConverter.convertToDto(rawMeasure);			
			
			rawMeasureDao.saveRawMeasure(rawMeasureDto);  //save a single raw measure to DB
			
		
		}
		catch (Exception e) {
			//Handle errors (e.g. write errors to log)
		}
		finally {

		}
	}
	
	
	
}
