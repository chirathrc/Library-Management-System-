package libraryManagementSystem.dto;

public class BookBorrowingConfirmDTO {

    private boolean confirmation;
    private String Returndate;

    public BookBorrowingConfirmDTO(boolean confirmation, String returndate) {
        this.confirmation = confirmation;
        Returndate = returndate;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public String getReturndate() {
        return Returndate;
    }

}
