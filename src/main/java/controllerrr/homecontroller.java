package controllerrr;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entitiess.User;

@Controller
public class homecontroller {
	
	@RequestMapping("/home")
	public String home() {
		
		return "home";
	}
	
	@RequestMapping("/insertdata")
	public String insertform(Model mod) {
		User u = new User();
		mod.addAttribute("userdata", u);
		return "insertdata";
	}
	
	@RequestMapping(value="/insertrecord", method=RequestMethod.POST)
	public String insertrecord(@ModelAttribute("userdata") User data) {
		int uid = data.getUid();
		String uname = data.getUname();
		String uemail = data.getUemail();
//		System.out.println(uid + " " + uname + " " + uemail);
		Session s = null;
		try {				
			Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
			SessionFactory sf = con.buildSessionFactory();
			s = sf.openSession();
			Transaction tx = s.beginTransaction();
			
			User back = new User();
			back.setUid(uid);
			back.setUname(uname);
			back.setUemail(uemail);
			
			s.save(back);
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			return "errorpage";
		}
		finally {
			if(s!=null) {
				s.close();
			}
		}
		
		return "insertRecord";
	}
	
	@RequestMapping("/deletedata")
	public String deleteById(Model mod) {
		User u = new User();
		mod.addAttribute("deleterId",u);
		return "deletedata";
	}
	
	@RequestMapping(value="/deleterecord", method = RequestMethod.POST)
	public String deleterecord(@ModelAttribute("deleterId") User idobj) {
		int uid = idobj.getUid();
		Session s = null;
		try {
			User ob = new User();
			ob.setUid(uid);
			Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
			SessionFactory sf = con.buildSessionFactory();
			s = sf.openSession();
			Transaction tx = s.beginTransaction();
			s.delete(ob);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(s!=null) {
				s.close();
			}
		}
		return "deleteRecord";
	}
	
	@RequestMapping("/completedata")
	public String showdata(Model mod) {
		Session s = null;
		try {
			Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
			SessionFactory sf = con.buildSessionFactory();
			s = sf.openSession();
			Query q = s.createQuery("from User");
			@SuppressWarnings("unchecked") //specifying Parameter is considered better and a good practice.
			List<User> l = q.list();
			Iterator<User> i = l.iterator();
			mod.addAttribute("data", i);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(s!=null) {
				s.close();
			}
		}
		
		return "data";
	}
	
	@RequestMapping("/searchbyid")
	public String searchbyid(Model mod) {
		User u = new User();
		mod.addAttribute("userid", u);
		return "searchdata";
	}
	
	@RequestMapping(value="/searchrecord", method = RequestMethod.POST)
	public String searchrecord(@ModelAttribute("userid") User u, Model mod) {
		int uid = u.getUid();
		Session s = null;
		try {
			Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
			SessionFactory sf = con.buildSessionFactory();
			s = sf.openSession();
			Query q = s.createQuery("from User where uid = " + uid);
			List<User> l = q.list();
			Iterator<User> i = l.iterator();
			mod.addAttribute("searchresult", i);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(s!=null) {
				s.close();
			}
		}
		return "searchRecord";
	}
	
	@RequestMapping("/updatedata")
	public String updatedata(Model mod) {
		User u = new User();
		mod.addAttribute("updateddata", u);
		
		return "updatedata";
	}
	
	@RequestMapping(value="/updaterecord", method = RequestMethod.POST)
	public String updaterecord(@ModelAttribute("updateddata") User u) {
		int uid = u.getUid();
		String uname = u.getUname();
		String uemail = u.getUemail();
		Session s = null;
		try {
			User ob = new User();
			ob.setUid(uid);
			ob.setUname(uname);
			ob.setUemail(uemail);
			
			Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
			SessionFactory sf = con.buildSessionFactory();
			s = sf.openSession();
			Transaction tx = s.beginTransaction();
			s.update(ob);
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(s!=null) {
				s.close();
			}
		}
		return "updateRecord";
	}
	
}
