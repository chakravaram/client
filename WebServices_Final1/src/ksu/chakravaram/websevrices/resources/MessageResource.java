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
import ksu.chakravaram.mappingclasses.Comments;
import ksu.chakravaram.mappingclasses.Likes;
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
		List<Messages> msgs=dao.getMessages(pid);
		return msgs;
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
	
	
	
	@POST
	@Path("/sendmsg")
	@Consumes({MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_XML})
	public IntegerResponse newMsg(Messages msg)
	{
		IntegerResponse res=a.newMsg(msg);
		return res;
	}
	
	

	@POST
	@Path("/sendcmt")
	@Consumes({MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_XML})
	public IntegerResponse newCmt(Comments cmt)
	{
		IntegerResponse res=a.newCmt(cmt);
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
	
	@GET
	@Path("/allprofiles")
	@Produces({MediaType.APPLICATION_XML})
	public List<Profiles> getAllProfiles()
	{
		//System.out.println(""+header);
		return dao.getAllProfiles();
	
	}
	
	
	@GET
	@Path("/getcomments/{post_id}")
	@Produces({MediaType.APPLICATION_XML})
	public List<Comments> getComments(@PathParam("post_id") String post_id)
	{
		//System.out.println(""+header);
		List<Comments> c=dao.getComments(Integer.parseInt(post_id.trim()));
		return c;
	
	}
	
	

	@GET
	@Path("/isliked/{profile_id}/{post_id}")
	@Produces({MediaType.APPLICATION_XML})
	public IntegerResponse isLiked(@PathParam("post_id") String post_id,@PathParam("profile_id") String profile_id)
	{
		
		IntegerResponse v= a.isLiked(profile_id,post_id);
		return v;
		
	}
	
	@GET
	@Path("/like/{profile_id}/{post_id}")
	
	@Produces({MediaType.APPLICATION_XML})
	public IntegerResponse like(@PathParam("post_id") String post_id,@PathParam("profile_id") String profile_id)
	{
		IntegerResponse res=a.Like(profile_id,post_id);
		return res;
	}
	
	@GET
	@Path("/haslikes/{post_id}")
	
	@Produces({MediaType.APPLICATION_XML})
	public IntegerResponse allike(@PathParam("post_id") String post_id)
	{
		IntegerResponse res=a.hasLikes(post_id);
		return res;
	}
	
	@GET
	@Path("/getlikes/{post_id}")
	
	@Produces({MediaType.APPLICATION_XML})
	public List<Likes> getlikes(@PathParam("post_id") String post_id)
	{
		List<Likes> res=dao.getLikes(Integer.parseInt(post_id.trim()));
		return res;
	}
	
	
	///////////////////////// SECURED METHODS  ///////////
	
	@GET
	@Path("/message/{profile_id}")
	@Produces({MediaType.APPLICATION_XML})
	public List<Messages> getMsga(@PathParam("profile_id") String profile_id)
	{
		int pid=Integer.parseInt(profile_id);
		List<Messages> msgs=dao.getMessages(pid);
		return msgs;
	}
	
	@DELETE
	@Path("/del/{profile_id}")
	@Produces({MediaType.APPLICATION_XML})
	public IntegerResponse delMsgs(@PathParam("profile_id") String profile_id)
	{
		int pid=Integer.parseInt(profile_id);
		IntegerResponse res=a.delete(pid);
		return res;
	}
	
	
}
