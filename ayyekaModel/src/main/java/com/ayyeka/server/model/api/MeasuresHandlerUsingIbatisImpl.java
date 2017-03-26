package com.ayyeka.server.model.api;

import java.io.Reader;
import java.util.Date;
import java.util.List;

import com.ayyeka.server.model.api.dataObjects.AggregatedMeasures;
import com.ayyeka.server.model.api.dataObjects.RawMeasure;
import com.ayyeka.server.model.persistency.dataAccessInterfaces.RawMeasureDao;
import com.ayyeka.server.model.persistency.dataAccessObjectsUsingIbatis.RawMeasureDaoImpl;
import com.ayyeka.server.model.persistency.dataTransferObjects.DataToDtoConverter;
import com.ayyeka.server.model.persistency.dataTransferObjects.RawMeasureDto;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class MeasuresHandlerUsingIbatisImpl implements MeasuresHandler {
	
	
	private Reader readerForIbatisMapsConfig = null;
	private SqlMapClient sqlmapClient = null;
	
	
//------ public -----------------------
	
	
	//Ctor
	public MeasuresHandlerUsingIbatisImpl() throws Exception {
		
		readerForIbatisMapsConfig = Resources.getResourceAsReader("sql-maps-config.xml");
		sqlmapClient = SqlMapClientBuilder.buildSqlMapClient (readerForIbatisMapsConfig);
	}
	
	
	@Override
	public void addMeasures(List<RawMeasure> listOfMeasures) {

		try {
			
			sqlmapClient.startTransaction(); //Either all list of measure is saved or none of them (on an error)
	
			//I use here Java 8 stream with parallel multi-threading instead of manually using ExecutorService for pool of threads
			listOfMeasures.stream().parallel().forEach(
					measure -> saveAndAggregateMeasure(measure) );
			
			sqlmapClient.commitTransaction();
		}
		catch (Exception e) {
			//Handle errors (e.g. write errors to log)
		}
		finally {
			if (sqlmapClient!=null) {
				try {
					sqlmapClient.endTransaction();
				}
				catch (Exception e) {
					//Handle errors (e.g. write errors to log)
				}
			}
		}
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
	private void saveAndAggregateMeasure(RawMeasure rawMeasure) {
		try {

			RawMeasureDao rawMeasureDao = new RawMeasureDaoImpl(sqlmapClient);

			RawMeasureDto rawMeasureDto = DataToDtoConverter.convertToDto(rawMeasure);			
			
			rawMeasureDao.addRawMeasure(rawMeasureDto);  //save a single raw measure to DB
			
			createOrUpdateAllAggregationsInPersistency(rawMeasureDto);  //
					
		
		}
		catch (Exception e) {
			//Handle errors (e.g. write errors to log)
		}
		finally {

		}
	}
	
	
	private void createOrUpdateAllAggregationsInPersistency(RawMeasureDto rawMeasureDto) {
		
		//TBD:
		
		//Calculate new average:  average = average + ((received value - average) / (old countValues + 1) )
		//
		//AggregatedMeasuresDao aggregatedMeasuresDao = new AggregatedMeasuresDaoImpl(sqlmapClient);
		//aggregatedMeasuresDao.updateAggregatedMeasures(aggregatedMeasuresDto);

	}



	
}
