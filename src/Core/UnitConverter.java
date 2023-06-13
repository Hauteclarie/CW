package com.Janus.Core;

public class UnitConverter {
	public UnitConverter() {
		
	}
	
	public static double convert(String inputUnitString, String outputUnitString, double value) {
		
		double bytes = 0;
		double result = 0;
		
		if(inputUnitString.startsWith("B")) {
			bytes = value;
		}else if (inputUnitString.startsWith("K")) {
			bytes = value * Math.pow(1024, 1);
		}else if (inputUnitString.startsWith("M")) {
			bytes = value * Math.pow(1024, 2);
		}else if (inputUnitString.startsWith("G")) {
			bytes = value * Math.pow(1024, 3);
		}
		
		if(outputUnitString.startsWith("B")) {
			result = bytes;
		}else if (outputUnitString.startsWith("K")) {
			result = bytes / Math.pow(1024, 1);
		}else if (outputUnitString.startsWith("M")) {
			result = bytes / Math.pow(1024, 2);
		}else if (outputUnitString.startsWith("G")) {
			result = bytes / Math.pow(1024, 3);
		}
		
		return result;
		
	}
}
