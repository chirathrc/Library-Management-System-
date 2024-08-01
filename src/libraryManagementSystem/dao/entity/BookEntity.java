package libraryManagementSystem.dao.entity;

public class BookEntity {

    private String bookId;

    private String bookName;
    private String authorName;
    private String description;
    private String category;
    private int bookStatusID = 1;
    private int bookAvailableStatusID = 1;
    private String registerDateTime;

    private String categoryAsName;
    private String statusAsName;
    private String availabiltyAsName;

    public BookEntity(String bookName, String authorName, String description, String category,
            String registerDateTime) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.description = description;
        this.category = category;
        this.registerDateTime = registerDateTime;
    }

    public BookEntity(String bookId, String bookName, String authorName, String description, int bookStatusID,
            String registerDateTime, String categoryAsName, String statusAsName,
            String availabiltyAsName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.description = description;
        this.bookStatusID = bookStatusID;
        this.registerDateTime = registerDateTime;
        this.categoryAsName = categoryAsName;
        this.statusAsName = statusAsName;
        this.availabiltyAsName = availabiltyAsName;
    }

    public BookEntity(String bookId, String bookName, String authorName, int bookStatusID, int bookAvailableStatusID) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookStatusID = bookStatusID;
        this.bookAvailableStatusID = bookAvailableStatusID;
    }

    public BookEntity(String bookId, String bookName, String description, int bookStatusID) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.description = description;
        this.bookStatusID = bookStatusID;
    }

    public String getBookId() {
        return bookId;
    }

    public String getCategoryAsName() {
        return categoryAsName;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookStatusID(int bookStatusID) {
        this.bookStatusID = bookStatusID;
    }

    public void setBookAvailableStatusID(int bookAvailableStatusID) {
        this.bookAvailableStatusID = bookAvailableStatusID;
    }

    public void setCategoryAsName(String categoryAsName) {
        this.categoryAsName = categoryAsName;
    }

    public void setStatusAsName(String statusAsName) {
        this.statusAsName = statusAsName;
    }

    public void setAvailabiltyAsName(String availabiltyAsName) {
        this.availabiltyAsName = availabiltyAsName;
    }

    public String getStatusAsName() {
        return statusAsName;
    }

    public String getAvailabiltyAsName() {
        return availabiltyAsName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BookEntity() {
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthorName() {
        return authorName;
    }

    @Override
    public String toString() {
        return "BookEntity [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName
                + ", description=" + description + ", category=" + category + ", bookStatusID=" + bookStatusID
                + ", bookAvailableStatusID=" + bookAvailableStatusID + ", registerDateTime=" + registerDateTime
                + ", categoryAsName=" + categoryAsName + ", statusAsName=" + statusAsName + ", availabiltyAsName="
                + availabiltyAsName + "]";
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public int getBookStatusID() {
        return bookStatusID;
    }

    public int getBookAvailableStatusID() {
        return bookAvailableStatusID;
    }

    public String getRegisterDateTime() {
        return registerDateTime;
    }

    public void setRegisterDateTime(String registerDateTime) {
        this.registerDateTime = registerDateTime;
    }

}
