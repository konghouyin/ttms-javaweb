package xupt.se.ttms.dao;

import xupt.se.ttms.domain.Comment;

import java.util.List;

/**
 * @program: ttms-javaweb
 * @author: WolfSky
 * @create: 2019-11-06 10:33
 **/
public interface IcommentDao {
    int commentInsert(Comment comment);

    int commentDelete(int comment_id);

    int commentUpdate(Comment comment);

    List<Comment> getCommentAll();
}
