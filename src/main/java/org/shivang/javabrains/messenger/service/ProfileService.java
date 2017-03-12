package org.shivang.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.shivang.javabrains.messenger.database.DatabaseClass;
import org.shivang.javabrains.messenger.model.Profile;

public class ProfileService {

	private static Map<String,Profile> profiles=DatabaseClass.getProfiles();

	public ProfileService(){
		profiles.put("TomH",new Profile(1L,"TomH","Tom","Henry"));
		profiles.put("TalJ",new Profile(2L,"TalJ","Tally","Junior"));
			}
	
	public List<Profile> getAllprofiles(){		
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){	
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){		
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){		
		
		if(profile.getProfileName().isEmpty()) return null;
		
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){		
		return profiles.remove(profileName);
	}
}
