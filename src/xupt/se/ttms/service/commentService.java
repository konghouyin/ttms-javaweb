package xupt.se.ttms.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;

import xupt.se.ttms.dao.IcommentDao;
import xupt.se.ttms.domain.Advancedcomment;
import xupt.se.ttms.domain.Comment;
import xupt.se.ttms.domain.ReportComment;
import xupt.se.ttms.domain.backMessage;
import xupt.se.ttms.factory.*;

import java.util.List;

/**
 * @program: ttms-javaweb
 * @author: WolfSky
 * @create: 2019-12-16 19:49
 **/
public class commentService {
	private IcommentDao commentDao = daoFactory.createCommentDao();

	public int commentAdd(String comment_msg, String grade,int play_id,int user_id) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// 从前端或者自己模拟一个日期格式，转为String即可
		String dateStr = format.format(date);
		Comment comment = new Comment();

		comment.setUser_id(user_id);
		comment.setComment_message(comment_msg);
		comment.setComment_grade(Integer.valueOf(grade));
		comment.setComment_status(1);
		comment.setPlay_id(play_id);
		comment.setComment_time(dateStr);
		commentDao.commentInsert(comment);
		return 1;
	}

	public List<Advancedcomment> getplaycomment(String playid) {

		List<Advancedcomment> comments = commentDao.getplaycomments(playid);

		return comments;
	}

	public int update(int comment_id){
		int i = commentDao.commentDelete(comment_id);
		return i;
	}

	public int overdule(int comment_id,int status){
		commentDao.commentUpdate(comment_id,status);
		return 1;
	}
}
