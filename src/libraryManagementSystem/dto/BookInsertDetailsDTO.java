package libraryManagementSystem.dto;

public class BookInsertDetailsDTO {

    private String BookID;
    private String BookStatus;

    private String bookName;

    private String authorName;
    private String description;
    private String category;
    private String registerDateTime;

    public BookInsertDetailsDTO(String bookName, String authorName, String description, String category,
            String registerDateTime) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.description = description;
        this.category = category;
        this.registerDateTime = registerDateTime;
    }

    public BookInsertDetailsDTO(String bookID, String bookStatus, String bookName, String description) {
        BookID = bookID;
        BookStatus = bookStatus;
        this.bookName = bookName;
        this.description = description;
    }

    public String getBookStatus() {
        return BookStatus;
    }

    public String getBookID() {
        return BookID;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getRegisterDateTime() {
        return registerDateTime;
    }

}
