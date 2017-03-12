package org.shivang.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.shivang.javabrains.messenger.database.DatabaseClass;
import org.shivang.javabrains.messenger.model.Message;

public class MessageService {
	
	private static Map<Long,Message> messages=DatabaseClass.getMessages();

	public MessageService(){
		messages.put(1L, new Message(1,"Hello World","Tom"));
		messages.put(2L, new Message(2,"Hello Earth","Harry"));
		messages.put(3L, new Message(3,"Hello Sun","Manny"));
		messages.put(4L, new Message(4,"Hello Mars","Mars"));
	}
	
	public List<Message> getAllMessages(){		
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesYear(int year){		
		
		List<Message> getYearMessage=new ArrayList<Message>();
		Calendar cal=Calendar.getInstance();
		
		for(Message message:messages.values())
		{
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year)
			{
				getYearMessage.add(message);
			}
		}
		
		return getYearMessage;
	}
	
	public List<Message> getMessagesPaginated(int start, int size){
		
		List<Message> outList=new ArrayList<Message>(messages.values());
		
		if(start+size > outList.size()) return new ArrayList<Message>();
		
		return outList.subList(start, start+size);
	}
	
	public Message getMessage(long id){	
		if(id<=0 || id>messages.size())
		{
			return null;
		}
		return messages.get(id);
	}
	
	public Message addMessage(Message msg){		
		msg.setId(messages.size()+1);
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message updateMessage(Message msg){		
		
		if(msg.getId()<=0){ 
			return null;		
		}
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message removeMessage(long id){		
		return messages.remove(id);
	}
	
}
