package xupt.se.ttms.factory;

import xupt.se.ttms.dao.*;
import xupt.se.ttms.dao.impl.*;

public class daoFactory {

	public static IuserDao createUserDao() {
		return new userDaoImpl();
	}

	public static IreporttypeDao createReportTypeDao(){
		return new reporttypeDaoImpl();
	}

	public static IcommentDao createCommentDao() {
	    return new commentDaoImpl();
	}
	
	public static IcinemaDao createCinemaDao() {
	    return new cinemaDaoImpl();
	}
	
	public static IseatDao createSeatDao() {
	    return new seatDaoImpl();
	}
}
