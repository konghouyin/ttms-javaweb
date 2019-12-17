package xupt.se.ttms.service;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import xupt.se.ttms.dao.IplayDao;
import xupt.se.ttms.dao.impl.playDaoImpl;
import xupt.se.ttms.domain.Play;
import xupt.se.ttms.factory.daoFactory;
import xupt.se.ttms.util.JSONTool;
import xupt.se.ttms.util.httpClient;

public class displayService {
	private IplayDao playDao = daoFactory.createPlayDao();

	public List<Play> getallplay() {
		List<Play> plist = playDao.getPlayAll();
		return plist;
	}

	public JSONObject analysisPath(String path) {
		String movieMessageString = httpClient.getMovieIndex(path);
		JSONObject aJsonObject;
		try {
			aJsonObject = JSON.parseObject(movieMessageString);
		} catch (Exception e) {
			aJsonObject = null;
		}
		return aJsonObject;
	}

	public JSONObject analysisIndex(JSONObject all) {
		if (all == null) {
			return null;
		} else {
			JSONTool jsonTool = new JSONTool(all);
			return (JSONObject) jsonTool.getJSONObject("index.base");
		}
	}
}
