package ksu.chakravaram.DataAccess;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;







import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ksu.chakravaram.mappingclasses.Messages;
import ksu.chakravaram.mappingclasses.Posts;
import ksu.chakravaram.mappingclasses.Profiles;
import ksu.chakravaram.websevrices.model.ValiedUser;
import ksu.chakravaram.websevrices.services.MessageService;

public class InsertData {

	public InsertData() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	MessageService s=new MessageService();
	//	ValiedUser v=s.checkUser("vijay", "vijay");
		//System.out.println(""+v.getFlag()+""+v.getProfile_id());
		
/*		Messages st=new Messages();
		
		st.setFrom_profile_id(103);
		st.setMessage("this is from 103 to 101");
		st.setTo_profile_id(101);
		st.setTime(new Date());
	*/
		Posts st=new Posts();
		st.setPost("Welcome All!");
		st.setPost_id(301);
		st.setProfile_id(101);
		st.setTime(new Date());
		
		
		
		Profiles p=new Profiles();
		File file = new File("C:/Users/chakravaram/Desktop/vx.JPG");
        byte[] bFile = new byte[(int) file.length()];
        
        try {
	     FileInputStream fileInputStream = new FileInputStream(file);
	     //convert file into array of bytes
	     fileInputStream.read(bFile);
	     fileInputStream.close();
        } catch (Exception e) {
	     e.printStackTrace();
        }
        p.setFirstname("vijay");
        p.setLastname("chakravaram");
        p.setDob(new Date());
        p.setPassword("vijay");
        p.setPhno("3145707395");
        p.setProfile_id(101);
        p.setImage(bFile);
        p.setUsername("vijay");
        
		
		Configuration cfg=new Configuration().configure();
	
		System.out.println("vijay0");
		
		//cfg.configure("./hibernate.cfg.xml");
		
	try{
		SessionFactory sf=cfg.buildSessionFactory();
		
	
		Session f=sf.openSession();
		System.out.println("vijay1");
	f.save(p);
	f.save(st);
	System.out.println("vijay12");
	f.beginTransaction().commit();
		f.close();
		System.out.println("vijay2");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
		

	}

}
