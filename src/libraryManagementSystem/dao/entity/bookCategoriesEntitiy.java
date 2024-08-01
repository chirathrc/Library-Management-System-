package libraryManagementSystem.dao.entity;

public class bookCategoriesEntitiy {

    private String catId;
    private String catName;

    public bookCategoriesEntitiy(String catId, String catName) {
        this.catId = catId;
        this.catName = catName;
    }

    public String getCatId() {
        return catId;
    }

    public String getCatName() {
        return catName;
    }

    @Override
    public String toString() {
        return catName; // This is important for displaying in the ComboBox
    }

}
