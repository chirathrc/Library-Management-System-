package libraryManagementSystem.service;

import libraryManagementSystem.dao.AdminDAOImpl;
import libraryManagementSystem.dao.entity.AdminEntity;
import libraryManagementSystem.dao.interfaces.Daointerfaces;

public class AdminService {

    private Daointerfaces adminDAO;
    public static AdminEntity admin;

    public AdminService() {

        adminDAO = new AdminDAOImpl();

    }

    public boolean signIn(String username, String password) {

        admin = adminDAO.adminSignIn(username);
        if (admin != null && admin.getPassword().equals(password)) {

            return true;

        }
        
        return false;

    }

}
