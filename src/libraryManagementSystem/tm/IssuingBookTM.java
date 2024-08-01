package libraryManagementSystem.tm;

public class IssuingBookTM {

    private String idBook;
    private String nameBook;
    private String authorBook;

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    public IssuingBookTM() {
    }

    public String getIdBook() {
        return idBook;
    }

    public IssuingBookTM(String idBook, String nameBook, String authorBook) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.authorBook = authorBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public String getAuthorBook() {
        return authorBook;
    }

}
