package src.org.ccunix.record_manager.util;

import java.util.HashMap;

/**
 * 
 * �Ự���ݹ���
 * @author lenovo
 *
 */
public class SessionDataUtil {
	private static HashMap<String,Object> dataMap=new HashMap<String,Object>();

	public static Object getAttribute(String key) {
		return dataMap.get(key);
	}

	public static void setAttribute(String key,Object obj) {
		dataMap.put(key, obj);
	}
	
	
}
