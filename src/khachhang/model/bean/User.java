package khachhang.model.bean;

import catStore.util.CatStoreException;
import catStore.util.LogFactory;
import khachhang.model.bo.UserBO;

public class User {

	private String id,username,password,fullname,address,phone,avatar;
    private UserBO userBO = new UserBO();

	

	

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws CatStoreException {
        if(phone.length() == 10)
        this.phone = phone;
        else
        {
            throw new CatStoreException("Phone number");
        }
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public User(String id, String username, String password, String fullname, String address, String phone,
			String avatar) throws CatStoreException{
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.address = address;
		setPhone(phone);
		this.avatar = avatar;
	}

	/**
	 * 
	 */
	public User() {
		
	}
	
	
}
