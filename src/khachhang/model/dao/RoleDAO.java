package khachhang.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import catStore.util.DBConnectUtil;
import khachhang.model.bean.Role;

public class RoleDAO {

	

	public List<Role> getRoles(String id) {
		Connection connection = DBConnectUtil.ConnectDB();
		String sql = "select * from Roles r join user_role ur on r.id = ur.roleid where userID = ? ";
		List<Role> listRole = new ArrayList<>();
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, id);
			ResultSet rs = pStatement.executeQuery();
			while(rs.next())
			{
				Role role = new Role(rs.getString("id"), rs.getNString("name"), rs.getNString("description"));
				listRole.add(role);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listRole;
	}

}
