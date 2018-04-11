package edu.uncc.ssdi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import edu.uncc.ssdi.model.Permission;
import edu.uncc.ssdi.util.DBConnection;

@Repository
public class PermDaoImpl implements PermDao{

	@Override
	public int givePermission(Permission permObject) {
	
		
		System.out.println(permObject.getStatus() + " , "+ permObject.getAccessByUserId() + " ,  "+ permObject.getAccessId() );
			Connection conn = null;
			PreparedStatement stmt = null;
			int bool = 0;
			try {

				conn = DBConnection.getDBConnection();

				String query = "update `permission` set  `status` = ? where `access_id` =  ? and `access_by` = ? ";
				stmt = conn.prepareStatement(query);
				
				stmt.setInt(1, permObject.getStatus());
				stmt.setString(2, permObject.getAccessId());
				stmt.setLong(3, permObject.getAccessByUserId());
				
			
				
				 bool = stmt.executeUpdate();
		

				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return bool;

		
		
		
		
	}

}
