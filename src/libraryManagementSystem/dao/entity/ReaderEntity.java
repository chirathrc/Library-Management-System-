package libraryManagementSystem.dao.entity;

public class ReaderEntity {

    private String id = null;
    private String ReaderFname;
    private String ReaderLname;
    private String ReaderNic;
    private String ReaderBirthday;
    private String ReaderGender;
    private String ReaderRegisterTime;
    public int ReaderStatus;

    public String getReaderFname() {
        return ReaderFname;
    }

    public ReaderEntity(String ReaderNic, String readerFname, String readerLname, String readerBirthday) {
        this.ReaderNic = ReaderNic;
        ReaderFname = readerFname;
        ReaderLname = readerLname;
        ReaderBirthday = readerBirthday;
    }

    public String getReaderLname() {
        return ReaderLname;
    }

    public int getReaderStatus() {
        return ReaderStatus;
    }

    public ReaderEntity(String id, String readerFname, String readerLname, String readerNic, String readerBirthday,
            String readerGender, String readerRegisterTime, int readerStatus) {
        this.id = id;
        ReaderFname = readerFname;
        ReaderLname = readerLname;
        ReaderNic = readerNic;
        ReaderBirthday = readerBirthday;
        ReaderGender = readerGender;
        ReaderRegisterTime = readerRegisterTime;
        ReaderStatus = readerStatus;
    }

    public String getReaderNic() {
        return ReaderNic;
    }

    public String getReaderBirthday() {
        return ReaderBirthday;
    }

    @Override
    public String toString() {
        return "ReaderEntity [ReaderFname=" + ReaderFname + ", ReaderLname=" + ReaderLname + ", ReaderNic=" + ReaderNic
                + ", ReaderBirthday=" + ReaderBirthday + ", ReaderGender=" + ReaderGender + ", ReaderRegisterTime="
                + ReaderRegisterTime + ", ReaderStatus=" + ReaderStatus + "]";
    }

    public String getReaderGender() {
        return ReaderGender;
    }

    public String getReaderRegisterTime() {
        return ReaderRegisterTime;
    }

    public String getId() {
        return id;
    }

}
