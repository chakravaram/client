package ksu.chakravaram.websevrices.services;

import ksu.chakravaram.DataAccess.DataAccess;
import ksu.chakravaram.mappingclasses.Messages;
import ksu.chakravaram.mappingclasses.Posts;
import ksu.chakravaram.mappingclasses.Profiles;
import ksu.chakravaram.websevrices.model.IntegerResponse;
import ksu.chakravaram.websevrices.model.ValiedUser;

public class MessageService {

	
	public ValiedUser checkUser(String username, String password)
	{
		System.out.println("in checkUser()");
		 DataAccess a =new DataAccess();
		 ValiedUser v;
		 System.out.println("in checkUser()1111");
		 
		int profile_id =a.getProfileId(username,password);
		System.out.println("in checkUser()");
		if (profile_id==0)
		 v=new ValiedUser(0,0);
		else
			v=new ValiedUser(1,profile_id);
		
		return v;
		
		
	}
	 
	public IntegerResponse delete(int pid)
	{
		 DataAccess a =new DataAccess();
		
		 int c=a.deleteProfile(pid);
		 IntegerResponse i=new IntegerResponse(c);
		 return i;
		 
	}


	public IntegerResponse create(Profiles pid)
	{
		 DataAccess a =new DataAccess();
		
		 int c=a.createProfile(pid);
		 IntegerResponse i=new IntegerResponse(c);
		 return i;
		 
	}

	public IntegerResponse createPost(Posts pid)
	{
		 DataAccess a =new DataAccess();
		
		 int c=a.createPost(pid);
		 IntegerResponse i=new IntegerResponse(c);
		 return i;
		 
	}
	
	public IntegerResponse newMsg(Messages msg)
	{
		 DataAccess a =new DataAccess();
		
		 int c=a.sendMsg(msg);
		 IntegerResponse i=new IntegerResponse(c);
		 return i;
		 
	}
	
	
	public IntegerResponse isLiked(String pfid, String pid)
	{
		 DataAccess a =new DataAccess();
		 int pffid= Integer.parseInt(pfid.trim());
		 int piid=Integer.parseInt(pid.trim());
		
		 int c=a.isLiked(pffid,piid);
		 IntegerResponse i=new IntegerResponse(c);
		 return i;
		 
	}
	
	public IntegerResponse Like(String pfid, String pid)
	{
		 DataAccess a =new DataAccess();
		 int pffid= Integer.parseInt(pfid.trim());
		 int piid=Integer.parseInt(pid.trim());
		
		 int c=a.like(pffid,piid);
		 IntegerResponse i=new IntegerResponse(c);
		 return i;
		 
	}
	public IntegerResponse hasLikes(String pid)
	{
		 DataAccess a =new DataAccess();
		
		 int piid=Integer.parseInt(pid.trim());
		
		 int c=a.hasLikes(piid);
		 IntegerResponse i=new IntegerResponse(c);
		 return i;
		 
	}
	
}
