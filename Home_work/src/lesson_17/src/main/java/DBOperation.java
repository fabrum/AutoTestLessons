import java.sql.*;

public class DBOperation {
    String url = "jdbc:mysql://localhost:3306/cedrs?useSSL=false";
    String user = "root";
    String password = "Ser!2345";
    String query = "SELECT * From new_table ";



    public String Get(int id, int tip) {
        String anser = "";
        try (Connection con = DriverManager.getConnection(url,user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query + "where id = " + id +";")) {
            if (rs.next()) {
                anser = (rs.getString(tip));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return anser;
    }



}
