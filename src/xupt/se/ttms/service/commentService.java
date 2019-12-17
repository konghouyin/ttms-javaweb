package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.dao.IcommentDao;
import xupt.se.ttms.domain.Advancedcomment;
import xupt.se.ttms.domain.Comment;
import xupt.se.ttms.factory.*;

/**
 * @program: ttms-javaweb
 * @author: WolfSky
 * @create: 2019-12-16 19:49
 **/
public class commentService {
    private IcommentDao commentDao = daoFactory.createCommentDao();

    public int commentAdd(Comment comment){
        commentDao.commentInsert(comment);
        return 1;
    }
    
    public List<Advancedcomment> getplaycomment(String playid){
    	
    	List<Advancedcomment> comments=commentDao.getplaycomments(playid);
    	
    	return comments;
    }
}
