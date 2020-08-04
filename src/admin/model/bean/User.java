/*
 * @author hoangnguyen
 * @date Apr 23, 2020
 * @version 1.0
 */

package admin.model.bean;

import java.util.ArrayList;

public class User {
	private String id;
	private String username;
	private String password;
	private String fullname;
	private String address;
	private String phonenumber;
	private ArrayList<Role> roles;
	
	public User(String id, String username, String password, String fullname, String address, String phonenumber,
			ArrayList<Role> roles) {
		super();
		this.setId(id);
		this.setUsername(username);
		this.setPassword(password);
		this.setFullname(fullname);
		this.setAddress(address);
		this.setPhonenumber(phonenumber);
		this.setRoles(roles);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public ArrayList<Role> getRoles() {
		return roles;
	}
	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}
}
