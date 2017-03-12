package org.shivang.javabrains.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/inject")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectionResource {

	@GET
	@Path("annotation")
	public String getParamAnnotations(@MatrixParam("param") String matParam,
										@HeaderParam("customParam") String headParam){
			return "Matrix:" + matParam + " CustomParam: "+headParam;
	}

	@GET
	@Path("context")
	public String getParamusingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeader){
		
		String path=uriInfo.getAbsolutePath().toString();
		String head=httpHeader.getCookies().toString();
		return path+" Cookie:"+head;
	}
	
}
