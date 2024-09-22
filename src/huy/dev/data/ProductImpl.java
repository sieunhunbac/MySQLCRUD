package huy.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductImpl {
	private Connection conn;

	public ProductImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	public int insert() {
        String sql = "INSERT INTO PRODUCTS(ID, NAME, DESCRIPTION, PRICE, QUANTITY, VIEW, CATEGORY_ID) VALUES(7, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, "product Name");
            stmt.setString(2, "product Description");
            stmt.setDouble(3, 3.8);
            stmt.setDouble(4, 100);
            stmt.setInt(5, 10);
            stmt.setInt(6, 1);
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            return generatedKey;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }
	public boolean update() {
        String sql = "UPDATE PRODUCTS SET name = ?, description = ?, thumbnail=?, price = ?, quantity = ?, category_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "product Name");
    stmt.setString(2, "product Description");
    stmt.setString(3, "product Thumbnail");
    stmt.setDouble(4, 100);
    stmt.setInt(5, 10);
    stmt.setInt(6, 1);
           // stmt.setInt(7, product.getId());

            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
	public void select() {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM PRODUCTS";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	int id = rs.getInt("id");
            	String name = rs.getString("name");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                System.out.format("id: %d - name: %s - price: %.2f - quantity: %d%n", id, name, price, quantity);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
