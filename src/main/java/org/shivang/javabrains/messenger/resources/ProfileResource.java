package org.shivang.javabrains.messenger.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.shivang.javabrains.messenger.model.Profile;
import org.shivang.javabrains.messenger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	ProfileService proService=new ProfileService();
	
	@GET
	public List<Profile> getAllProfiles(){
		return proService.getAllprofiles();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName){
		return proService.getProfile(profileName);
	}
	
	@POST
	public Profile addProfile(Profile profile){
		return proService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName,Profile profile){
		profile.setProfileName(profileName);
		return proService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public Profile deleteProfile(@PathParam("profileName") String profileName){
		return proService.removeProfile(profileName);
	}

}
