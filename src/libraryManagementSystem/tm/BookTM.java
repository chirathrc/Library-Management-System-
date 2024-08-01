package libraryManagementSystem.tm;

public class BookTM {

    private String bookID;
    private String bookName;
    private String authorName;
    private String bookAvilability;

    public BookTM(String bookID, String bookName, String authorName, String bookAvilability) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookAvilability = bookAvilability;
    }

    public String getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getBookAvilability() {
        return bookAvilability;
    }

}
