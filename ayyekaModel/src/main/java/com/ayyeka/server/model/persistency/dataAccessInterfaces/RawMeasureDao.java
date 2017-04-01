package com.ayyeka.server.model.persistency.dataAccessInterfaces;

import com.ayyeka.server.model.persistency.dataTransferObjects.RawMeasureDto;

public interface RawMeasureDao 
{
	void saveRawMeasure(RawMeasureDto rawMeasureDto) throws Exception;
	
	RawMeasureDto getRawMeasureById(Integer id) throws Exception;
	
	RawMeasureDto getRawMeasureByInfo(RawMeasureDto rawMeasureDto) throws Exception;
}
