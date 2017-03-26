package com.ayyeka.server.model.unitTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.ayyeka.server.model.api.AggregationTypeEnum;
import com.ayyeka.server.model.api.MeasuresHandler;
import com.ayyeka.server.model.api.MeasuresHandlerUsingIbatisImpl;
import com.ayyeka.server.model.api.dataObjects.AggregatedMeasures;
import com.ayyeka.server.model.api.dataObjects.RawMeasure;
import com.ayyeka.server.model.persistency.dataTransferObjects.RawMeasureDto;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MeasuresHandlerTest.class );
    }


    public void testAggregation() throws Exception
    {
    	
	    	//MeasuresHandler measuresHandler = new MeasuresHandlerMock();
	        MeasuresHandler measuresHandler = new MeasuresHandlerUsingIbatisImpl();
	
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
	        
	        measuresHandler.addMeasures(listOfMeasures);
	        
	        AggregatedMeasures aggregatedMeasuresForThisMonth = 
	        		measuresHandler.getAggregatedMeasures(5, new Date(), AggregationTypeEnum.MONTH);
	        
    }
}
