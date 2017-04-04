package com.ayyeka.server.model.api;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;

import com.ayyeka.server.model.api.dataObjects.AggregatedMeasures;
import com.ayyeka.server.model.api.dataObjects.RawMeasure;
import com.ayyeka.server.model.persistency.dataAccessInterfaces.AggregatedMeasuresDao;
import com.ayyeka.server.model.persistency.dataAccessInterfaces.RawMeasureDao;
import com.ayyeka.server.model.persistency.dataTransferObjects.AggregatedMeasuresDto;
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
		
		List<RawMeasureDto> listOfRawMeasureDTOs = new ArrayList<RawMeasureDto>();
		for ( RawMeasure rawMeasure : listOfMeasures ) {
			listOfRawMeasureDTOs.add(DataToDtoConverter.convertToDto(rawMeasure));
		}
	
		rawMeasureDao.saveNewRawMeasuresAsBatch(listOfRawMeasureDTOs);
	}

	@Override
	public void aggregateMeasuresIntoPersistency(List<RawMeasure> listOfMeasures) throws Exception {

		//TBD: This method needs to be completed
		
		RawMeasure firstMeasure = listOfMeasures.get(0);
		Calendar cal = Calendar.getInstance();
		cal.setTime(firstMeasure.getTime());
		int aggYear = cal.get(Calendar.YEAR); 
		int aggMonth = cal.get(Calendar.MONTH); 
		int aggDayOfMonth = cal.get(Calendar.DAY_OF_MONTH); 
		
		AggregatedMeasuresDto aggregatedMeasuresDto = new AggregatedMeasuresDto();
		aggregatedMeasuresDto.setAggregatedYear(aggYear);
		aggregatedMeasuresDto.setAggregatedMonth(aggMonth);
		aggregatedMeasuresDto.setAggregatedDayOfMonth(aggDayOfMonth);
		aggregatedMeasuresDto.setAggregatedTypeId(1);
		aggregatedMeasuredDao.updateAggregatedMeasures(aggregatedMeasuresDto);
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
			
			rawMeasureDao.saveNewRawMeasure(rawMeasureDto);  //save a single raw measure to DB
			
		
		}
		catch (Exception e) {
			//Handle errors (e.g. write errors to log)
		}
		finally {

		}
	}
	
	
	
}
