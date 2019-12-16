package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.dao.IplayDao;
import xupt.se.ttms.dao.impl.playDaoImpl;
import xupt.se.ttms.domain.Play;
import xupt.se.ttms.factory.daoFactory;

public class displayService {
	private IplayDao playDao =daoFactory.createPlayDao();
	
	public List<Play> getallplay(){	
		List<Play> plist=playDao.getPlayAll();
		return plist;
	} 
}
