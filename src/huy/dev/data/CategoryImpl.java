package huy.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryImpl {
	private Connection conn;
	
	public CategoryImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public  void select() {
		// TODO Auto-generated method stub
		String sql = "SELECT* FROM CATEGORIES";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs =  stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String thumbnail = rs.getString("thumbnail");
				System.out.format("id:%d - name:%s - thumbnail:%s", id, name, thumbnail).println();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert() {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO categories(ID,NAME, THUMBNAIL) VALUES (?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 3);
			stmt.setString(2, "Ao khoac");
			stmt.setString(3, "asdadad");
			
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}	
	public void update() {
        // TODO Auto-generated method stub
        String sql = "UPDATE CATEGORIES SET name = ?, thumbnail = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "category name");
            stmt.setString(2, "url thumbnail");
            stmt.setInt(3, 1); //1 là id của category
            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	public void delete() {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM CATEGORIES WHERE ID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 120); //id la id của category cần xoá
            stmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	public void find(int id) {
		 String sql = "SELECT * FROM CATEGORIES WHERE ID = ?";
	        try {
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, id); //id la id của category cần tìm
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                String name = rs.getString("name");
	                String thumbnail = rs.getString("thumbnail");
	                System.out.format("%id:%s:%s", id, name, thumbnail).println();
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
	public void findAll() {
        String sql = "SELECT * FROM Users WHERE ID > ? ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 0);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                System.out.format("id:%d-email:%s-password:%s-role:%s", id, email, password, role).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}