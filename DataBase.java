package emp4layer;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataBase 
{
	public int insert(Emp emp)
	{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iprime_assignment","root","12345");
			ps =con.prepareStatement("insert into emp3 values(?,?,?,?,?); ");
			ps.setString(1,emp.getName());
			ps.setInt(2,emp.getAge());
			ps.setString(3,emp.getDesig());
			ps.setInt(4,emp.getSal());
			ps.setString(5,emp.getEmailId());
			return ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) con.close();
				if(ps != null)ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return 0;
		
		
	}
	public List<Emp> display()
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iprime_assignment","root","12345");
			ps = con.prepareStatement("select * from emp3");
			rs = ps.executeQuery();
			Emp em;
			while(rs.next()) {
				em = new Clerk();
				em.setName(rs.getString(1));
				em.setAge(rs.getInt(2));
				em.setDesig(rs.getString(3));
				em.setSal(rs.getInt(4));
				em.setEmailId(rs.getString(5));
				list.add(em);
			}
			
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(con!=null) con.close();
					if(ps!=null) ps.close();
					if(rs!=null) rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}
	public boolean raiseSal(Emp emp) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iprime_assignment","root","12345");
			ps = con.prepareStatement("select * from emp3 where desig = ?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ps.setString(1,emp.getDesig());
			rs = ps.executeQuery();
			while(rs.next()) {
				String email = rs.getString("emailId");
				ps = con.prepareStatement("update emp3 set sal = ? where emailId = ?");
				ps.setString(2,email);
				emp.setSal(rs.getInt("sal"));
				emp.raiseSal();
				ps.setInt(1,emp.getSal());
				ps.executeUpdate();
//				rs.updateInt("sal",emp.getSal());
//				rs.updateRow();
			}
			return true;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null) con.close();
				if(ps!=null) ps.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
}
