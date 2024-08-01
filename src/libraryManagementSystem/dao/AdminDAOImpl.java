package libraryManagementSystem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import libraryManagementSystem.dao.entity.AdminEntity;
import libraryManagementSystem.dao.interfaces.Daointerfaces;
import libraryManagementSystem.database.connection;

public class AdminDAOImpl implements Daointerfaces {

    @Override
    public AdminEntity adminSignIn(String username) {
        AdminEntity admin = null;
        try {
            String query = "SELECT * FROM `admin` WHERE `userName` = ?";
            PreparedStatement statement = connection.getConection().DatabaseConnection.prepareStatement(query);
            statement.setString(1, username);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                admin = new AdminEntity();
                admin.setUserName(rs.getString("userName"));
                admin.setfName(rs.getString("fName"));
                admin.setlName(rs.getString("lName"));
                admin.setPassword(rs.getString("password"));

                // System.out.println(admin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return admin;
    }
}
