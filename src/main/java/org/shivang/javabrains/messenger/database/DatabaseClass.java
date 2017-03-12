package org.shivang.javabrains.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.shivang.javabrains.messenger.model.Message;
import org.shivang.javabrains.messenger.model.Profile;

public class DatabaseClass {

	private static Map<Long,Message> messages=new HashMap<>();
	private static Map<String,Profile> profiles=new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		synchronized(messages){
			return messages;
		}
	}
	public static Map<String, Profile> getProfiles() {
		synchronized(profiles){
			return profiles;
		}
	}
		
}
