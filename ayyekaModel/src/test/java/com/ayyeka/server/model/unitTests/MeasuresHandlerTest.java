package com.ayyeka.server.model.unitTests;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ayyeka.server.model.api.AggregationTypeEnum;
import com.ayyeka.server.model.api.MeasuresHandler;
import com.ayyeka.server.model.api.MeasuresHandlerImpl;
import com.ayyeka.server.model.api.dataObjects.AggregatedMeasures;
import com.ayyeka.server.model.api.dataObjects.RawMeasure;
import com.ayyeka.server.model.persistency.dataAccessInterfaces.RawMeasureDao;
import com.ayyeka.server.model.persistency.dataAccessObjectsUsingIbatis.RawMeasureDaoImpl;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import junit.framework.TestCase;

/**
 * Unit test
 */
public class MeasuresHandlerTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MeasuresHandlerTest( String testName )
    {
        super( testName );
    }

    public void testAggregation() throws Exception
    {
    		//------------------------------------------------------------------------------
    		//Initialize and inject dependencies (Late Spring can be used for doing this)
    		//------------------------------------------------------------------------------
    	
			Reader reader = Resources.getResourceAsReader("sql-maps-config.xml");
			SqlMapClient sqlmapClient = SqlMapClientBuilder.buildSqlMapClient (reader);
			
			//Dependency injection using CTOR because I don't want 
			//the RawMeasureDao interface to contain the method setSqlMapClient()
    		RawMeasureDao rawMeasureDao = new RawMeasureDaoImpl(sqlmapClient); 

    		ExecutorService executorService = Executors.newFixedThreadPool(10);
	        MeasuresHandler measuresHandler = new MeasuresHandlerImpl(executorService);
	        measuresHandler.setRawMeasureDao(rawMeasureDao);   //dependency injection

	        
    		//------------------------------------------------------------------------------
	        //Create input and request the model to save it into persistency
    		//------------------------------------------------------------------------------
	        
	        //User only knows about RawMeasure POJO and knows nothing about 
	        //  RawMeasureDto, iBatis, mySql 
	        RawMeasure rawMeasure = null;
	        
	        List<RawMeasure> listOfMeasures = new ArrayList<>();
	
	        rawMeasure = new RawMeasure();
	        rawMeasure.setDeviceId(5);
	        rawMeasure.setTime(new Date());
	        rawMeasure.setMeasuredValue(22.5f);
	        listOfMeasures.add(rawMeasure);
	        
	        rawMeasure = new RawMeasure();
	        rawMeasure.setDeviceId(5);
	        rawMeasure.setTime(new Date());
	        rawMeasure.setMeasuredValue(23.2f);
	        listOfMeasures.add(rawMeasure);
	        
	        measuresHandler.saveMeasuresIntoPersistency(listOfMeasures);
	        
	        measuresHandler.aggregateMeasuresIntoPersistency(listOfMeasures);
	        
	        
    		//------------------------------------------------------------------------------
	        //Request for aggregated data
    		//------------------------------------------------------------------------------	        
	        
	        AggregatedMeasures aggregatedMeasuresForThisMonth = 
	        		measuresHandler.getAggregatedMeasures(5, new Date(), AggregationTypeEnum.MONTH);
	        
    }
}
