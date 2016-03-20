package ksu.chakravaram.websevrices.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ksu.chakravaram.DataAccess.DataAccess;
import ksu.chakravaram.mappingclasses.Messages;
import ksu.chakravaram.mappingclasses.Posts;
import ksu.chakravaram.mappingclasses.Profiles;
import ksu.chakravaram.websevrices.model.IntegerResponse;
import ksu.chakravaram.websevrices.model.ValiedUser;
import ksu.chakravaram.websevrices.services.MessageService;

@Path("/profiles")
public class MessageResource {

	MessageService a=new MessageService();
	DataAccess dao=new DataAccess();
	
	@GET
	@Path("/{username}/{password}")
	@Produces({MediaType.APPLICATION_XML})
	public ValiedUser getId(@PathParam("username") String username,@PathParam("password") String password)
	{
		
		ValiedUser v= a.checkUser(username, password);
		return v;
		
	}
	
	@GET
	@Path("/{profile_id}")
	@Produces({MediaType.APPLICATION_XML})
	public Profiles getId(@PathParam("profile_id") String profile_id)
	{
		int pid=Integer.parseInt(profile_id);
		return dao.getProfile(pid);
		
	}
	
	@GET
	@Path("/messages/{profile_id}")
	@Produces({MediaType.APPLICATION_XML})
	public List<Messages> getMsg(@PathParam("profile_id") String profile_id)
	{
		int pid=Integer.parseInt(profile_id);
		return dao.getMessages(pid);
	}
	
	@DELETE
	@Path("/delete/{profile_id}")
	@Produces({MediaType.APPLICATION_XML})
	public IntegerResponse delMsg(@PathParam("profile_id") String profile_id)
	{
		int pid=Integer.parseInt(profile_id);
		IntegerResponse res=a.delete(pid);
		return res;
	}
	
	@POST
	@Path("/create")
	@Consumes({MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_XML})
	public IntegerResponse createProfile(Profiles pof)
	{
		IntegerResponse res=a.create(pof);
		return res;
	}
	

	@POST
	@Path("/newpost")
	@Consumes({MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_XML})
	public IntegerResponse createPost(Posts pof)
	{
		IntegerResponse res=a.createPost(pof);
		return res;
	}

	@GET
	@Path("/allposts")
	@Produces({MediaType.APPLICATION_XML})
	public List<Posts> getPost(@HeaderParam("vijay") String header )
	{
		System.out.println(""+header);
		return dao.getAllPosts();
	
	}
	
}
