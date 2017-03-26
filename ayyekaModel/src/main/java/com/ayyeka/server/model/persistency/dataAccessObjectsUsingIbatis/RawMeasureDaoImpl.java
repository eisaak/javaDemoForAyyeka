package com.ayyeka.server.model.persistency.dataAccessObjectsUsingIbatis;

import com.ayyeka.server.model.persistency.dataAccessInterfaces.RawMeasureDao;
import com.ayyeka.server.model.persistency.dataTransferObjects.RawMeasureDto;
import com.ibatis.sqlmap.client.SqlMapClient;

public class RawMeasureDaoImpl implements RawMeasureDao
{
	
	private SqlMapClient sqlmapClient = null;
	
	
	public RawMeasureDaoImpl(SqlMapClient sqlmapClient) {
		
		this.sqlmapClient = sqlmapClient;
	}
	
	public void addRawMeasure(RawMeasureDto rawMeasureDto) throws Exception {
		
		sqlmapClient.insert("rawMeasure.addRawMeasure", rawMeasureDto);
	}

	
	public RawMeasureDto getRawMeasureById(Integer id) throws Exception {
		
		return (RawMeasureDto)sqlmapClient.queryForObject("rawMeasure.getRawMeasureById", id);
	}
	
	public RawMeasureDto getRawMeasureByInfo(RawMeasureDto rawMeasureDto) throws Exception {

		return (RawMeasureDto)sqlmapClient.queryForObject("rawMeasure.getRawMeasureByInfo", rawMeasureDto);
	}

	public void deleteRawMeasureById(Integer id) throws Exception {
		
		sqlmapClient.delete("rawMeasure.deleteRawMeasureById", id);
	}




}

