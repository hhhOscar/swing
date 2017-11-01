
package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java1234.model.User;

public class UserDao {

	/**
	 * µÇÂ¼ÑéÖ¤
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con, User user) throws Exception{
		User resultUser = null;
		String sql = "select * from t_user where userName=? and password=?";
		PreparedStatement pStatement = con.prepareStatement(sql);
		pStatement.setString(1, user.getUserName());
		pStatement.setString(2, user.getPassword());
		ResultSet rs = pStatement.executeQuery();
		if (rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
	}
}
