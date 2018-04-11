package edu.uncc.ssdi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.uncc.ssdi.model.Permission;
import edu.uncc.ssdi.util.DBConnection;

@Repository
public class PermDaoImpl implements PermDao{

	@Override
	public int givePermission(Permission permObject) {
	
		
	//	System.out.println(permObject.getStatus() + " , "+ permObject.getAccessByUserId() + " ,  "+ permObject.getId() );
			Connection conn = null;
			PreparedStatement stmt = null;
			int bool = 0;
			try {

				conn = DBConnection.getDBConnection();

				String query = "update `permission` set  `status` = ? where `digital_id` =  ? and `access_by` = ? ";
				stmt = conn.prepareStatement(query);
				
				stmt.setInt(1, permObject.getStatus());
				stmt.setString(2, permObject.getId());
				stmt.setLong(3, permObject.getAccessByUserId());
				
			
				
				 bool = stmt.executeUpdate();
		

				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return bool;

		
		
		
		
	}

	@Override
	public List<Permission> getAllRequests(String digitalId) {
		
		 List<Permission> listRequests = null;
		Connection conn = null;
		PreparedStatement stmt = null;
	
		try {

			conn = DBConnection.getDBConnection();

			String query = "select * from  `permission` where digital_id  =  ? and  `status` = 4 ";
			stmt = conn.prepareStatement(query);
		
			stmt.setString(1, digitalId);

			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.isBeforeFirst()  && rs.getRow() == 0) {    
				listRequests = new ArrayList<Permission>();
			} 
			while (rs.next()) {
			
				Permission permObj = new Permission();
				
				permObj.setId(rs.getString("digital_id"));
				permObj.setAccessByUserId(Long.parseLong(rs.getString("access_by")));
				permObj.setStatus(Integer.parseInt(rs.getString("status")));
				listRequests.add(permObj);
				
			}
	

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listRequests;

		
		
		
		
		
	}

}
