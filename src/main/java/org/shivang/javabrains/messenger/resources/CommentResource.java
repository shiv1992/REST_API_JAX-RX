package org.shivang.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.eclipse.persistence.oxm.MediaType;
import org.shivang.javabrains.messenger.model.Comments;
import org.shivang.javabrains.messenger.resources.bean.FilterBeanResource;
import org.shivang.javabrains.messenger.service.CommentService;

@Path("/")
public class CommentResource {

	CommentService commService=new CommentService();
	
	@GET
	public List<Comments> getAllMessages(@PathParam("messageID") long messageID){ 
		return commService.getAllComments(messageID);	
	}
	
	@GET
	@Path("/{commentID}")
	public Comments getMessage(@PathParam("messageID") long messageID,@PathParam("commentID") long commentID){
		return commService.getComments(messageID, commentID);
	}
	
	@POST
	public Comments addMessage(Comments comment, @PathParam("messageID") long messageID){
		return commService.addcomments(comment, messageID);
	}
	
	@PUT
	@Path("/{commentID}")
	public Comments updateMessage(Comments comment,@PathParam("messageID") long messageID,@PathParam("commentID") long commentID){
		comment.setId(commentID);
		return commService.updateComments(comment, messageID);
	}
	
	@DELETE
	@Path("/{commentID}")
	public Comments deleteMessage(@PathParam("messageID") long messageID,@PathParam("commentID") long commentID){
		return commService.removeComments(messageID, commentID);
	}
	
	
}
