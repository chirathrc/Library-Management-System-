package libraryManagementSystem.dao.entity;

public class genderEntity {

    private String genderId;
    private String gender;

    public genderEntity(String genderId, String gender) {
        this.genderId = genderId;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }

    public String getGenderId() {
        return genderId;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
