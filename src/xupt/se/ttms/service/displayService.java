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

	public int addPlay(String path, String name, 
			String type, String director,String performer, String length, String country, 
			String language, String status, String pic, String link,
			String comment,String message) {
		
		Play playObj =  new Play();
		playObj.setPlay_name(name);
		playObj.setPlay_path(path);
		playObj.setPlay_type(type);
		playObj.setPlay_director(director);
		playObj.setPlay_performer(performer);
		playObj.setPlay_length(length);
		playObj.setPlay_country(country);
		playObj.setPlay_language(language);
		playObj.setPlay_status(status);
		playObj.setPlay_pic(pic);
		playObj.setPlay_link(link);
		playObj.setPlay_message(message);
		
		System.out.println(playObj.toString());

		
		return playDao.playInsert(playObj);
	}

}
