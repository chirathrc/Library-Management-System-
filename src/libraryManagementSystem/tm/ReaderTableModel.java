package libraryManagementSystem.tm;

public class ReaderTableModel {

    private String ReaderName;
    private String ReaderId;
    private String ReaderNIC;
    private String ReaderGender;
    private String ReaderBirthday;
    private String ReaderRegTime;
    private int ReaderStatus;

    public String getReaderName() {
        return ReaderName;
    }

    public String getReaderId() {
        return ReaderId;
    }

    public String getReaderNIC() {
        return ReaderNIC;
    }

    public String getReaderGender() {
        return ReaderGender;
    }

    public String getReaderBirthday() {
        return ReaderBirthday;
    }

    @Override
    public String toString() {
        return "ReaderTableModel [ReaderName=" + ReaderName + ", ReaderId=" + ReaderId + ", ReaderNIC=" + ReaderNIC
                + ", ReaderGender=" + ReaderGender + ", ReaderBirthday=" + ReaderBirthday + ", ReaderRegTime="
                + ReaderRegTime + ", ReaderStatus=" + ReaderStatus + "]";
    }

    public String getReaderRegTime() {
        return ReaderRegTime;
    }

    public int getReaderStatus() {
        return ReaderStatus;
    }

    public ReaderTableModel(String readerName, String readerId, String readerNIC, String readerGender,
            String readerBirthday, String readerRegTime, int readerStatus) {
        ReaderName = readerName;
        ReaderId = readerId;
        ReaderNIC = readerNIC;
        ReaderGender = readerGender;
        ReaderBirthday = readerBirthday;
        ReaderRegTime = readerRegTime;
        ReaderStatus = readerStatus;
    }

}
