package ksu.chakravaram.DataAccess;

import java.util.Date;




import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ksu.chakravaram.mappingclasses.Likes;
import ksu.chakravaram.mappingclasses.Messages;
import ksu.chakravaram.mappingclasses.Posts;
import ksu.chakravaram.mappingclasses.Profiles;
import ksu.chakravaram.websevrices.model.IntegerResponse;

public class DataAccess {

	/*public boolean createProfile(String firstname,String lastname, int phno, Date dob, String username, String password)
	{
		boolean flag=false;
		Profiles p=new Profiles();
	   
		p.setFirstname(firstname);
		p.setLastname(lastname);
		p.setPhno(phno);
		p.setDob(dob);
		p.setUsername(username);
		p.setPassword(password);
		//p.setProfile_id(101);	 
		
		try{
			Configuration cfg=new Configuration().configure("/WebServices_Final1/src/hibernate.cfg.xml");			
			SessionFactory sf=cfg.buildSessionFactory();
	        Session f=sf.openSession();
	       
	        Query query1=f.createQuery("select max(e.profile_id) from Profiles e order by e.firstname desc");
	        System.out.println("desc/////////////////////////////////////n");
	        System.out.println("desc/////////////////////////////////////n");
	       
	         List<Integer> a= query1.list();
	         Integer x=a.get(0);
	         int y=x;
	         System.out.println("fffd");
	         if(y>100)
	        	 p.setProfile_id(y+1);
	         else
	        	 p.setProfile_id(101);	 
	       
			f.save(p);
            f.beginTransaction().commit();
			f.close();			
			System.out.println("profile creation success");
			flag=true;
			
			
		}
		catch(Exception e)
		{
			System.out.println("Error in creating profile"+e);
		}
		return flag;
		
	}*/

	public int getProfileId(String username, String password)
	{
		int flag=0;
		try{
			
			Configuration cfg=new Configuration().configure("./hibernate.cfg.xml");				
			SessionFactory sf=cfg.buildSessionFactory();			
	        Session f=sf.openSession();	    
	        Query query1=f.createQuery("select e.profile_id from Profiles e where e.username=? and e.password=?");
	        query1.setParameter(0, username);
	        query1.setParameter(1, password);
	       
	         List<Integer> a= query1.list();
	         if(a.isEmpty()){
	        	 System.out.println("is not a valied user");
	        	 return flag;
	         }
	        	 
	         else{
	        	 	Integer x=a.get(0);
	        	 	flag=x;
	                f.close();			
			        System.out.println("is valied user");
	         }
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Error in getProfileID"+e);
		}
		return flag;
	}
    
    public Profiles getProfile(int pid)
    {
    	Profiles p=null;
		try{
			
			Configuration cfg=new Configuration().configure("./hibernate.cfg.xml");				
			SessionFactory sf=cfg.buildSessionFactory();			
	        Session f=sf.openSession();	    
	        Query query1=f.createQuery("select e from Profiles e where e.profile_id=?");
	        query1.setParameter(0, pid);
	        
	       
	         List<Profiles> a= query1.list();
	         if(a.isEmpty()){
	        	 System.out.println("is not a valied profile id-doesnot exist");
	        	 return p;
	         }
	        	 
	         else{
	        	 
	        	 p=a.get(0);	        	 
	                f.close();			
			        System.out.println("is valieed profile id");
	         }
		}
		catch(Exception e)
		{
			System.out.println("Error in getProfileID"+e);
		}
		
	         return p;
    }

    public List<Messages> getMessages(int pid)
    {
    	List<Messages> p=null;
		try{
			
			Configuration cfg=new Configuration().configure("./hibernate.cfg.xml");				
			SessionFactory sf=cfg.buildSessionFactory();			
	        Session f=sf.openSession();	    
	        Query query1=f.createQuery("select e from Messages e where e.to_profile_id=?");
	        query1.setParameter(0, pid);
	               p= query1.list();
	               f.close();	
	       
	    /*     
	         if(a.isEmpty()){
	        	 System.out.println("is not a valied profile id-doesnot exist");
	        	 return p;
	         }
	        	 
	         else{
	        	 
	        	 p=a;	        	 
	                f.close();			
			        System.out.println("is valieed profile id messages retriving");
	         }*/
		}
		catch(Exception e)
		{
			System.out.println("Error in getMessages () by Id"+e);
		}
		
	         return p;
    	
    }

    public int deleteProfile(int pid)
    {
    	int flag=0;
		try{
			
			Configuration cfg=new Configuration().configure("./hibernate.cfg.xml");				
			SessionFactory sf=cfg.buildSessionFactory();			
	        Session f=sf.openSession();	    
	        Query query1=f.createQuery("delete from Profiles e where e.profile_id=?");
	        query1.setParameter(0, pid);
	      
	       
	         flag = query1.executeUpdate();
	         if(flag==1)
	        	 System.out.println("successfully deleted profile"+pid);     	 
	         else
  		        System.out.println("coud not delete profile"+pid);
	         
			
			}
		catch(Exception e)
		{
			System.out.println("Error in deleteProfileID"+e);
		}
		return flag;
    	
    }

    public int createProfile(Profiles p)
    {
    	int flag=0;
		try{
			
			Configuration cfg=new Configuration().configure("./hibernate.cfg.xml");				
			SessionFactory sf=cfg.buildSessionFactory();			
	        Session f=sf.openSession();	    
	        Query query1=f.createQuery("select max(e.profile_id) from Profiles e");
		       
	         List<Integer> a= query1.list();
	         Integer x=a.get(0);
	         int y=x;
	         System.out.println("fffd");
	         if(y>100)
	        	 p.setProfile_id(y+1);
	         else
	        	 p.setProfile_id(101);	 
	       
			f.save(p);
           f.beginTransaction().commit();
			f.close();			
			System.out.println("profile creation success");
			flag=1;
	         
			
			}
		catch(Exception e)
		{
			System.out.println("Error in createProfileID"+e);
		}
		return flag;
    	
    }

    public int createPost(Posts p)
    {
    	int flag=0;
		try{
			
			Configuration cfg=new Configuration().configure("./hibernate.cfg.xml");				
			SessionFactory sf=cfg.buildSessionFactory();			
	        Session f=sf.openSession();	    
	        Query query1=f.createQuery("select max(e.post_id) from Posts e");
		       p.setTime(new Date());
	         List<Integer> a= query1.list();
	         Integer x=a.get(0);
	         int y=x;
	         System.out.println("fffd");
	         if(y>300)
	        	 p.setPost_id(y+1);
	         else
	        	 p.setPost_id(301);	 
	       
			f.save(p);
           f.beginTransaction().commit();
			f.close();			
			System.out.println(" succeessfully posted!!");
			flag=1;
	         
			
			}
		catch(Exception e)
		{
			System.out.println("Error in createPost could not post"+e);
		}
		return flag;
    }

    public List<Posts> getAllPosts()
    {
    	List<Posts> p=null;
		try{
			
			Configuration cfg=new Configuration().configure("./hibernate.cfg.xml");				
			SessionFactory sf=cfg.buildSessionFactory();			
	        Session f=sf.openSession();	    
	        
	        Query query1=f.createQuery("select e from Posts e ");
	       
	       
	         List<Posts> a= query1.list();
	         if(a.isEmpty()){
	        	 System.out.println(" there are no posts");
	        	 return p;
	         }
	        	 
	         else{
	        	 
	        	 p=a;	        	 
	                f.close();			
			        System.out.println("is valieed profile id messages retriving");
	         }
		}
		catch(Exception e)
		{
			System.out.println("Error in getAllposts () by Id"+e);
		}
		
	         return p;
    }

    public List<Profiles> getAllProfiles()
    {
    	List<Profiles> p=null;
		try{
			
			Configuration cfg=new Configuration().configure("./hibernate.cfg.xml");				
			SessionFactory sf=cfg.buildSessionFactory();			
	        Session f=sf.openSession();	    
	        Query query1=f.createQuery("select e from Profiles e");
	        List<Profiles> a= query1.list();
	         if(a.isEmpty()){
	        	 System.out.println(" There are no profiles");
	        	 return p;
	         }
	        	 
	         else{
	        	 
	        		 p=a;       	 
	                f.close();			
			        System.out.println("Getting All Profiles");
	         }
		}
		catch(Exception e)
		{
			System.out.println("Error in getALLProfileID"+e);
		}
		
	         return p;
    }
  
    public int sendMsg(Messages p)
    {
    	int flag=0;
		try{
			
			Configuration cfg=new Configuration().configure("./hibernate.cfg.xml");				
			SessionFactory sf=cfg.buildSessionFactory();			
	        Session f=sf.openSession();	    
	        
		       p.setTime(new Date());
	         
	       
			f.save(p);
           f.beginTransaction().commit();
			f.close();			
			System.out.println(" succeessfully posted!!");
			flag=1;
	         
			
			}
		catch(Exception e)
		{
			System.out.println("Error in create nw msg Data Acess"+e);
		}
		return flag;
    }

    public int isLiked(int proid, int pid)
	{
		int flag=0;
		try{
			
			Configuration cfg=new Configuration().configure("./hibernate.cfg.xml");				
			SessionFactory sf=cfg.buildSessionFactory();			
	        Session f=sf.openSession();	    
	        Query query1=f.createQuery("select e from Likes e where e.profile_id=? and e.post_id=?");
	        query1.setParameter(0, proid);
	        query1.setParameter(1, pid);
	       
	         List<Integer> a= query1.list();
	         if(a.isEmpty()){
	        	 System.out.println(" did not like");
	        	 return flag;
	         }
	        	 
	         else{
	        	 	
	        	 	flag=1;
	                f.close();			
			        System.out.println("Already Liked");
	         }
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Error in isLiked()"+e);
		}
		return flag;
	}

    public int like(int proid, int pid)
	{
		int flag=0;
		try{
			
			Configuration cfg=new Configuration().configure("./hibernate.cfg.xml");		
			System.out.println("in likes1");
			SessionFactory sf=cfg.buildSessionFactory();	
			System.out.println("in likes2");
	        Session f=sf.openSession();	    
	        System.out.println("in likes3");
	        Likes l=new Likes();
	        l.setPost_id(pid);
	        l.setProfile_id(proid);
	        System.out.println("in likes4");
	       

			f.save(l);
           f.beginTransaction().commit();
			f.close();			
			System.out.println(" succeessfully posted!!");
			flag=1;
	         
			
			}
		catch(Exception e)
		{
			System.out.println("Error in DataAccesss like()"+e);
		}
		return flag;
    }
    
    
    public int hasLikes(int pid)
	{
    	int a=0;
	
		try{
			
			Configuration cfg=new Configuration().configure("./hibernate.cfg.xml");				
			SessionFactory sf=cfg.buildSessionFactory();			
	        Session f=sf.openSession();	    
	        Query query1=f.createQuery("select distinct e.profile_id from Likes e where e.post_id=?");
	        query1.setParameter(0, pid);
	        List<Integer> list=query1.list();
	        if(list.isEmpty())
	        	a=0;
	        else
	        	a=1;
	       
	           
	         
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Error in isLiked()"+e);
		}
		return a;
    }
    
    
    
    
    public List<Likes> getLikes(int pid)
   	{
    	List<Likes> list=null;
   	
   		try{
   			
   			Configuration cfg=new Configuration().configure("./hibernate.cfg.xml");				
   			SessionFactory sf=cfg.buildSessionFactory();			
   	        Session f=sf.openSession();	    
   	        Query query1=f.createQuery("select distinct e from Likes e where e.post_id=?");
   	        query1.setParameter(0, pid);
   	         list=query1.list();
   	       
   	           
   	         
   			
   			
   			
   		}
   		catch(Exception e)
   		{
   			System.out.println("Error in isLiked()"+e);
   		}
   		return list;
       }
    
    
    
    
    
    
    
    
    
    
}
