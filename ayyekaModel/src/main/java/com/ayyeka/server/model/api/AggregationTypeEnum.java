package com.ayyeka.server.model.api;

import java.util.HashMap;
import java.util.Map;

public enum AggregationTypeEnum {
		UNKNOWN ("", 0),
	   	YEAR("YEAR", 1),
	    MONTH("MONTH", 2),
	    DAY_OF_MONTH("MONTH", 3);
		
	    private String usedName;
	    private int id;

	    AggregationTypeEnum(String usedName, int id) {
	        this.usedName = usedName;
	    }

	    public String usedName() {
	        return usedName;
	    }
	    
	    public int id() {
	        return id;
	    }
	    
	    //This gets the right enum according to given int
	    
		private static Map<Integer, AggregationTypeEnum> map = new HashMap<Integer, AggregationTypeEnum>();
		
		static {
	        for (AggregationTypeEnum aggregationTypeEnum : AggregationTypeEnum.values()) {
	            map.put(aggregationTypeEnum.id, aggregationTypeEnum);
	        }
	    }
		
		public static AggregationTypeEnum valueOf(int id) {
	        return map.get(id);
	    }

}
