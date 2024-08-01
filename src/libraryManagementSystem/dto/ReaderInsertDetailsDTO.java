package libraryManagementSystem.dto;

public class ReaderInsertDetailsDTO {

    private String ReaderFname;
    private String ReaderLname;
    private String ReaderNic;
    private String ReaderBirthday;
    private String ReaderGender;
    private String ReaderRegisterTime;
    public int ReaderStatus;

    public ReaderInsertDetailsDTO() {
    }

    public ReaderInsertDetailsDTO(String readerFname, String readerLname, String readerNic, String readerBirthday,
            String readerGender, String readerRegisterTime, int readerStatus) {
        ReaderFname = readerFname;
        ReaderLname = readerLname;
        ReaderNic = readerNic;
        ReaderBirthday = readerBirthday;
        ReaderGender = readerGender;
        ReaderRegisterTime = readerRegisterTime;
        ReaderStatus = readerStatus;
    }

    public String getReaderFname() {
        return ReaderFname;
    }

    public void setReaderFname(String readerFname) {
        ReaderFname = readerFname;
    }

    public void setReaderLname(String readerLname) {
        ReaderLname = readerLname;
    }

    public void setReaderNic(String readerNic) {
        ReaderNic = readerNic;
    }

    public void setReaderBirthday(String readerBirthday) {
        ReaderBirthday = readerBirthday;
    }

    public void setReaderGender(String readerGender) {
        ReaderGender = readerGender;
    }

    public void setReaderRegisterTime(String readerRegisterTime) {
        ReaderRegisterTime = readerRegisterTime;
    }

    public void setReaderStatus(int readerStatus) {
        ReaderStatus = readerStatus;
    }

    public String getReaderRegisterTime() {
        return ReaderRegisterTime;
    }

    public String getReaderLname() {
        return ReaderLname;
    }

    public String getReaderNic() {
        return ReaderNic;
    }

    public String getReaderBirthday() {
        return ReaderBirthday;
    }

    public String getReaderGender() {
        return ReaderGender;
    }

    public int getReaderStatus() {
        return ReaderStatus;
    }

    @Override
    public String toString() {
        return "ReaderInsertDetailsDTO [ReaderFname=" + ReaderFname + ", ReaderLname=" + ReaderLname + ", ReaderNic="
                + ReaderNic + ", ReaderBirthday=" + ReaderBirthday + ", ReaderGender=" + ReaderGender
                + ", ReaderRegisterTime=" + ReaderRegisterTime + ", ReaderStatus=" + ReaderStatus + "]";
    }

}
