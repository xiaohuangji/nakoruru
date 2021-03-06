package com.reminder.mcp.log;


import com.reminder.util.JsonUtil;
import com.reminder.util.TypeUtils;
import org.apache.log4j.Logger;


public class LoggerInformation {

    private static final Logger logger= Logger.getLogger(LoggerInformation.class);
	
	public static void LoggerErr(String prompt){
		logger.error(prompt);
	}
	
	public static void LoggerErr(String prompt,Exception e){
		logger.error(prompt,e);
	}
	
	public static void LoggerErr(Logger logger,String prompt,Exception e){
		logger.error(prompt, e);
	}
	
	public static void LoggerErr(Logger logger,String prompt,Exception e,Object ...objects){
		prompt = prompt + objectsToString(objects);
		logger.error(prompt,e);
	}
	
	public static void LoggerErrMessage(Logger logger,String prompt){
		logger.error(prompt);
	}
	
	public static void LoggerInfo(Logger logger,String prompt){
		if(logger.isInfoEnabled()){
			logger.info(prompt);
		}
	}
	
	public static void LoggerInfo(Logger logger,String prompt,Exception e){
		if(logger.isInfoEnabled()){
			logger.info(prompt,e);
		}
	}
	
	public static void LoggerInfo(Logger logger,String prompt,Object ...objects){
		prompt = prompt + objectsToString(objects);
		if(logger.isInfoEnabled()){
			logger.info(prompt);
		}
	}
	
	public static void LoggerInfo(Logger logger,String prompt,Exception e,Object ...objects){
		prompt = prompt + objectsToString(objects);
		if(logger.isInfoEnabled()){
			logger.info(prompt,e);
		}
	}
	
	private static String objectsToString(Object ...objects){
		StringBuilder builder = new StringBuilder();
		for(Object obj : objects){
			if(obj ==  null)
			{
				builder.append("null");
				builder.append("::");
				continue;
			}
			if(TypeUtils.isBaseType(obj.getClass())){
				builder.append(obj);
			}else{
				try {
					builder.append(JsonUtil.toJson(obj));
				} catch (Exception e1) {
//					e1.printStackTrace();
					return "";
				}
			}
			builder.append("::");
		}
		return builder.toString();
	}
}
