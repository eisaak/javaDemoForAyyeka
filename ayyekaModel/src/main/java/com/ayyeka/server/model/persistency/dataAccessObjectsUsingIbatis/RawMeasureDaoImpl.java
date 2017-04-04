package com.ayyeka.server.model.persistency.dataAccessObjectsUsingIbatis;

import java.io.Reader;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ayyeka.server.model.persistency.dataAccessInterfaces.RawMeasureDao;
import com.ayyeka.server.model.persistency.dataTransferObjects.RawMeasureDto;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class RawMeasureDaoImpl implements RawMeasureDao
{	
	
	private Reader readerForIbatisMapsConfig = null;
	private SqlMapClient sqlmapClient = null;
	
	ExecutorService executorService = Executors.newFixedThreadPool(10);
	
//------ public -----------------------
	
	
	//Ctor
	public RawMeasureDaoImpl() throws Exception {
		
		readerForIbatisMapsConfig = Resources.getResourceAsReader("sql-maps-config.xml");
		sqlmapClient = SqlMapClientBuilder.buildSqlMapClient (readerForIbatisMapsConfig);
	}
	
	public RawMeasureDaoImpl(SqlMapClient sqlmapClient) {
		
		this.sqlmapClient = sqlmapClient;
	}
	
	@Override
	public void saveNewRawMeasure(RawMeasureDto rawMeasureDto) throws Exception {
		
		sqlmapClient.insert("rawMeasure.addRawMeasure", rawMeasureDto);
	}

	@Override   
	public void saveNewRawMeasuresAsBatch(List<RawMeasureDto> listOfRawMeasureDTOs) throws Exception {

		//sqlmapClient.startTransaction()
			
		sqlmapClient.startBatch();
		
		for (RawMeasureDto rawMeasureDto : listOfRawMeasureDTOs) {
			sqlmapClient.insert("rawMeasure.addRawMeasure", rawMeasureDto);
		}
		
		sqlmapClient.executeBatch();
	}
	
	@Override
	public RawMeasureDto getRawMeasureById(Integer id) throws Exception {
		
		return (RawMeasureDto)sqlmapClient.queryForObject("rawMeasure.getRawMeasureById", id);
	}
	
	@Override
	public RawMeasureDto getRawMeasureByInfo(RawMeasureDto rawMeasureDto) throws Exception {

		return (RawMeasureDto)sqlmapClient.queryForObject("rawMeasure.getRawMeasureByInfo", rawMeasureDto);
	}

	public void deleteRawMeasureById(Integer id) throws Exception {
		
		sqlmapClient.delete("rawMeasure.deleteRawMeasureById", id);
	}






}

