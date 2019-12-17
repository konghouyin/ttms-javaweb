package xupt.se.ttms.dao;

import xupt.se.ttms.domain.Advancedcomment;
import xupt.se.ttms.domain.Comment;
import xupt.se.ttms.domain.ReportComment;

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

	List<Advancedcomment> getplaycomments(String playid);
}
