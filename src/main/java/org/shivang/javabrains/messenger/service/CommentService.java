package org.shivang.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.shivang.javabrains.messenger.database.DatabaseClass;
import org.shivang.javabrains.messenger.model.Comments;
import org.shivang.javabrains.messenger.model.Message;

public class CommentService {

	private static Map<Long,Message> messages=DatabaseClass.getMessages();
	
	public List<Comments> getAllComments(long messageID){	
		Map<Long,Comments> comments=messages.get(messageID).getComments();
		return new ArrayList<Comments>(comments.values());
	}
	
	public Comments getComments(long messageID,long commentID){	
		Map<Long,Comments> comments=messages.get(messageID).getComments();
		return comments.get(commentID);
	}
	
	public Comments addcomments(Comments msg,long messageID){		
		Map<Long,Comments> comments=messages.get(messageID).getComments();
		msg.setId(comments.size()+1);
		comments.put(msg.getId(), msg);
		return msg;
	}
	
	public Comments updateComments(Comments msg,long messageID){		
		
		Map<Long,Comments> comments=messages.get(messageID).getComments();
		if(msg.getId()<=0){ 
			return null;		
		}
		comments.put(msg.getId(), msg);
		return msg;
	}
	
	public Comments removeComments(long messageID,long commentID){		
		
		Map<Long,Comments> comments=messages.get(messageID).getComments();
		return comments.remove(commentID);
	}
}
