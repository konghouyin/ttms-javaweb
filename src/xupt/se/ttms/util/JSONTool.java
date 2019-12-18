package xupt.se.ttms.util;

import com.alibaba.fastjson.JSONObject;

public class JSONTool{
	
	private JSONObject object;
	
	public JSONTool(JSONObject object) {
		this.object = object;
	}
	
	public Object getJSONObject(String rule) {
		String[] backStrings = rule.split("\\.");
		Object backObject = this.object;
		for(int i= 0;i<backStrings.length;i++) {
			try {
				backObject = ((JSONObject) backObject).getJSONObject(backStrings[i]);
			} catch (Exception e) {
				backObject = ((JSONObject) backObject).getJSONArray(backStrings[i]);
			}
		}
		return backObject;
	}
}
