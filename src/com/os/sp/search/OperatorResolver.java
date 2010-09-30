package com.os.sp.search;

public final class OperatorResolver {
	
	public static String resolve(Operator op, String fieldName, String value) {
		
   		String tpl = op.getTemplate();
   		tpl = tpl.replace("$(F)", fieldName);
   		tpl = tpl.replace("$(V)", prepareValue(op, value));
   		return tpl;
	}
	
	private static String prepareValue(Operator op, String value) {
		String res = value;
		
   		if (op.getType() == Type.STRING) {
   	   		if (op.getName().equals(Operator.STR_MATCHES)) {
   	   			// replace asterisk with %
   	   			res = res.replaceAll("\\*", "%");
   	   		}
   	   		
   	   		// escape single quotes
   	   		res = res.replaceAll("'", "\\\\'");
   		}

		return res;
	}

}
