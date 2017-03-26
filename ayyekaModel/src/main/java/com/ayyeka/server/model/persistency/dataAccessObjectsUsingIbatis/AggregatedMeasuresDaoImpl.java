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
	
	
	public void addAggregatedMeasures(AggregatedMeasuresDto aggregatedMeasuresDto)  throws Exception {
		
		sqlmapClient.insert("aggregatedMeasures.addAggregatedMeasures", aggregatedMeasuresDto);
	}


	public AggregatedMeasuresDto getAggregatedMeasuresById(Integer id)  throws Exception {

		return (AggregatedMeasuresDto)sqlmapClient.queryForObject("aggregatedMeasures.getRawMeasureById", id);
	}


	public AggregatedMeasuresDto getAggregatedMeasuresByInfo(AggregatedMeasuresDto aggregatedMeasuresDto) throws Exception {
		
		return (AggregatedMeasuresDto)sqlmapClient.queryForObject("aggregatedMeasures.getRawMeasureByInfo", aggregatedMeasuresDto);
	}

	
	public void updateAggregatedMeasures(AggregatedMeasuresDto aggregatedMeasuresDto) throws Exception {
		
		sqlmapClient.update("aggregatedMeasures.updateAggregatedMeasures", aggregatedMeasuresDto);
	}


}

