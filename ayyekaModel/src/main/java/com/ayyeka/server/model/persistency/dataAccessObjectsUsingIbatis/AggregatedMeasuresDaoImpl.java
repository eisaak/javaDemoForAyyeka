package com.ayyeka.server.model.persistency.dataAccessObjectsUsingIbatis;

import com.ayyeka.server.model.persistency.dataAccessInterfaces.AggregatedMeasuresDao;
import com.ayyeka.server.model.persistency.dataTransferObjects.AggregatedMeasuresDto;
import com.ibatis.sqlmap.client.SqlMapClient;

public class AggregatedMeasuresDaoImpl implements AggregatedMeasuresDao
{

	private SqlMapClient sqlmapClient = null;
	

	public AggregatedMeasuresDaoImpl(SqlMapClient sqlmapClient) {
		
		this.sqlmapClient = sqlmapClient;
	}
	
	public void startTransaction() throws Exception {
		sqlmapClient.startTransaction();
	}
	
	public void commitTransaction() throws Exception  {
		sqlmapClient.commitTransaction();
	}

	public void endTransaction() throws Exception  {
		sqlmapClient.endTransaction();
	}

	public void saveAggregatedMeasures(AggregatedMeasuresDto aggregatedMeasuresDto)  throws Exception {
		
		sqlmapClient.insert("aggregatedMeasures.addAggregatedMeasures", aggregatedMeasuresDto);
	}


	public AggregatedMeasuresDto getAggregatedMeasuresById(Integer id)  throws Exception {

		return (AggregatedMeasuresDto)sqlmapClient.queryForObject("aggregatedMeasures.getAggregatedMeasuresById", id);
	}


	public AggregatedMeasuresDto getAggregatedMeasuresByInfo(AggregatedMeasuresDto aggregatedMeasuresDto) throws Exception {
		
		return (AggregatedMeasuresDto)sqlmapClient.queryForObject("aggregatedMeasures.getAggregatedMeasuresByInfo", aggregatedMeasuresDto);
	}

	
	public void updateAggregatedMeasures(AggregatedMeasuresDto aggregatedMeasuresDto) throws Exception {
		
		sqlmapClient.update("aggregatedMeasures.updateAggregatedMeasures", aggregatedMeasuresDto);
	}


}

