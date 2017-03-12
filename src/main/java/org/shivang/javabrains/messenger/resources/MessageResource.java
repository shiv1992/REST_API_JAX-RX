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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.shivang.javabrains.messenger.model.Message;
import org.shivang.javabrains.messenger.resources.bean.FilterBeanResource;
import org.shivang.javabrains.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
		MessageService msgService=new MessageService();
		
		@GET
		public List<Message> getAllMessages(@BeanParam FilterBeanResource filter){
			if(filter.getYear()>0){
				return msgService.getAllMessagesYear(filter.getYear());
			}
			
			if(filter.getStart()>=0 && filter.getSize()>0){
				return msgService.getMessagesPaginated(filter.getStart(), filter.getSize());
			}
			 
			
			return msgService.getAllMessages();
		}
		
		@GET
		@Path("/{messageID}")
		public Message getMessage(@PathParam("messageID") long ID){
			//return Response.status(Status.BAD_REQUEST).entity(msgService.getMessage(ID)).build();
			return msgService.getMessage(ID);
		}
		
		@POST
		public Message addMessage(Message msg){
			return msgService.addMessage(msg);
		}
		
		@PUT
		@Path("/{messageID}")
		public Message updateMessage(@PathParam("messageID") long ID,Message msg){
			msg.setId(ID);
			return msgService.updateMessage(msg);
		}
		
		@DELETE
		@Path("/{messageID}")
		public Message deleteMessage(@PathParam("messageID") long ID){
			return msgService.removeMessage(ID);
		}
		
		@Path("/{messageID}/comments")
		public CommentResource getMessageComments(){
			return new CommentResource();
		}
		
}
