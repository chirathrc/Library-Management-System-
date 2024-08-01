package libraryManagementSystem.tm;

public class ReturnTM {

    private String bookID;
    private String BookName;
    private String BookAutor;
    private String IssuingDate;
    private String dueReturnDate;
    private Double LatePanelty;
    private String IssuingId;

    public ReturnTM() {
    }

    public String getBookID() {
        return bookID;
    }

    public ReturnTM(String bookID, String bookName, String bookAutor, String issuingDate, String dueReturnDate,
            Double latePanelty, String issuingId) {
        this.bookID = bookID;
        BookName = bookName;
        BookAutor = bookAutor;
        IssuingDate = issuingDate;
        this.dueReturnDate = dueReturnDate;
        LatePanelty = latePanelty;
        IssuingId = issuingId;
    }

    public String getIssuingId() {
        return IssuingId;
    }

    public void setIssuingId(String issuingId) {
        IssuingId = issuingId;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookAutor() {
        return BookAutor;
    }

    public void setBookAutor(String bookAutor) {
        BookAutor = bookAutor;
    }

    public String getIssuingDate() {
        return IssuingDate;
    }

    public void setIssuingDate(String issuingDate) {
        IssuingDate = issuingDate;
    }

    public String getDueReturnDate() {
        return dueReturnDate;
    }

    public void setDueReturnDate(String dueReturnDate) {
        this.dueReturnDate = dueReturnDate;
    }

    public Double getLatePanelty() {
        return LatePanelty;
    }

    public void setLatePanelty(Double latePanelty) {
        LatePanelty = latePanelty;
    }

}
