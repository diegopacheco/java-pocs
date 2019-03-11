package com.github.diegopacheco.rest.assured.fun.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;  

public class UserDao { 

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){ 
      List<User> userList = null; 
      try { 
         File file = new File("Users.dat"); 
         if (!file.exists()) { 
            User user = new User(1, "Mahesh", "Teacher"); 
            userList = new ArrayList<User>(); 
            userList.add(user); 
            saveUserList(userList); 
         } 
         else{ 
            FileInputStream fis = new FileInputStream(file); 
            ObjectInputStream ois = new ObjectInputStream(fis); 
            userList = (List<User>) ois.readObject(); 
            ois.close(); 
         } 
      } catch (Exception e) { 
         e.printStackTrace(); 
         throw new RuntimeException(e);
      }   
      return userList; 
   } 
   private void saveUserList(List<User> userList){ 
      try { 
         File file = new File("Users.dat"); 
         FileOutputStream fos;  
         fos = new FileOutputStream(file); 
         ObjectOutputStream oos = new ObjectOutputStream(fos); 
         oos.writeObject(userList); 
         oos.close(); 
      } catch (Exception e) { 
         e.printStackTrace();
         throw new RuntimeException(e);
      } 
   }
   
   public static void main(String[] args) {
		User u1 = new User();
		u1.setId(1);
		u1.setName("Diego");
		u1.setProfession("Sofware Architect");
		
		User u2 = new User();
		u2.setId(2);
		u2.setName("Gandalfy");
		u2.setProfession("White Wizard Cat");
		
		UserDao dao = new UserDao();
		dao.saveUserList(Arrays.asList(new User[]{u1,u2}));
		System.out.println("users persisted");
	}
}
