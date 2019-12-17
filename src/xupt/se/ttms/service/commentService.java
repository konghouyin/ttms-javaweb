package xupt.se.ttms.service;

import xupt.se.ttms.dao.IcommentDao;
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
}
