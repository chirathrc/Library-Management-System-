package libraryManagementSystem.dao.entity;

public class AdminEntity {

    private String userName;
    private String fName;
    private String lName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getfName() {
        return fName;
    }

    @Override
    public String toString() {
        return "AdminEntity [userName=" + userName + ", fName=" + fName + ", lName=" + lName + ", password=" + password
                + "]";
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
