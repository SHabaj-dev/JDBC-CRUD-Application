package CRUD_App;

import java.sql.*;

public class StudentDAO {
    final String url = "jdbc:mysql://localhost:3306/mydatabase";
    final String userName = "root";
    final String password = "shabaj@1452";

    Connection con;

    public StudentDAO(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void print(ResultSet rs) throws SQLException {
        System.out.printf("%d \t %s \t %s \t %s \n", rs.getInt(1), rs.getString(2), rs.getString(3),
                rs.getString(4));
    }

    public void showTable(){
        final String query = "SELECT * FROM student";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                print(rs);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showData(int student_id){
        final String query = "SELECT * FROM student WHERE student_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, student_id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                print(rs);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(int student_id, String first_name, String last_name, String branch){
        final String query = "INSERT INTO student VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, student_id);
            ps.setString(2, first_name);
            ps.setString(3, last_name);
            ps.setString(4, branch);
            int rowsAffected = ps.executeUpdate();
            ps.close();
            return rowsAffected;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }

    public int deleteData(int student_id){
        final String query = "DELETE FROM student WHERE student_id = ?";
        int rowsAffected = 0;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, student_id);
            rowsAffected = ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
