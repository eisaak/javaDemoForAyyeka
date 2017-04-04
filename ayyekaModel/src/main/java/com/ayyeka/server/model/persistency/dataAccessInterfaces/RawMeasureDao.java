package com.ayyeka.server.model.persistency.dataAccessInterfaces;

import java.util.List;

import com.ayyeka.server.model.persistency.dataTransferObjects.RawMeasureDto;

public interface RawMeasureDao {
	
	void saveNewRawMeasuresAsBatch(List<RawMeasureDto> listOfRawMeasureDTOs) throws Exception;
	
	void saveNewRawMeasure(RawMeasureDto rawMeasureDto) throws Exception;
	
	RawMeasureDto getRawMeasureById(Integer id) throws Exception;
	
	RawMeasureDto getRawMeasureByInfo(RawMeasureDto rawMeasureDto) throws Exception;
}
