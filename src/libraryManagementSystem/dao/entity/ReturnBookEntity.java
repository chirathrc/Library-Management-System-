package libraryManagementSystem.dao.entity;

public class ReturnBookEntity {

    private String NIC;
    private String ReaderName;
    private String Birthday;

    private String BookID;
    private String BookName;
    private String BookAuthor;

    private String IssuingDate;
    private String ReturnDate;
    private String IssuingId;

    private Double LatePanlety;

    public ReturnBookEntity() {
    }

    public ReturnBookEntity(String nIC, String readerName, String birthday, String bookID, String bookName,
            String bookAuthor, String issuingDate, String returnDate, String issuingId) {
        NIC = nIC;
        ReaderName = readerName;
        Birthday = birthday;
        BookID = bookID;
        BookName = bookName;
        BookAuthor = bookAuthor;
        IssuingDate = issuingDate;
        ReturnDate = returnDate;
        IssuingId = issuingId;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String nIC) {
        NIC = nIC;
    }

    public String getReaderName() {
        return ReaderName;
    }

    public void setReaderName(String readerName) {
        ReaderName = readerName;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookAuthor() {
        return BookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        BookAuthor = bookAuthor;
    }

    public String getIssuingDate() {
        return IssuingDate;
    }

    public void setIssuingDate(String issuingDate) {
        IssuingDate = issuingDate;
    }

    public String getReturnDate() {
        return ReturnDate;
    }

    @Override
    public String toString() {
        return "ReturnBookEntity [NIC=" + NIC + ", ReaderName=" + ReaderName + ", Birthday=" + Birthday + ", BookID="
                + BookID + ", BookName=" + BookName + ", BookAuthor=" + BookAuthor + ", IssuingDate=" + IssuingDate
                + ", ReturnDate=" + ReturnDate + ", IssuingId=" + IssuingId + ", LatePanlety=" + LatePanlety + "]";
    }

    public void setReturnDate(String returnDate) {
        ReturnDate = returnDate;
    }

    public String getIssuingId() {
        return IssuingId;
    }

    public void setIssuingId(String issuingId) {
        IssuingId = issuingId;
    }

    public Double getLatePanlety() {
        return LatePanlety;
    }

    public void setLatePanlety(Double latePanlety) {
        LatePanlety = latePanlety;
    }

}
