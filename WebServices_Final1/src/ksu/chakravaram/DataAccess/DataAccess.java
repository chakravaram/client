package ksu.chakravaram.DataAccess;

import java.util.Date;




import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ksu.chakravaram.mappingclasses.Messages;
import ksu.chakravaram.mappingclasses.Posts;
import ksu.chakravaram.mappingclasses.Profiles;

public class DataAccess {

	public boolean createProfile(String firstname,String lastname, int phno, Date dob, String username, String password)
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
			flag=true;
			
			
		}
		catch(Exception e)
		{
			System.out.println("Error in creating profile"+e);
		}
		return flag;
		
	}

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
	        
	       
	         List<Messages> a= query1.list();
	         if(a.isEmpty()){
	        	 System.out.println("is not a valied profile id-doesnot exist");
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
	        	 p.setProfile_id(301);	 
	       
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
}
