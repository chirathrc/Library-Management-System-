package libraryManagementSystem.dao.interfaces;

import java.util.List;

import libraryManagementSystem.dao.entity.BookEntity;
import libraryManagementSystem.dao.entity.ReaderEntity;

public interface BookIssuingInterface {

    public abstract ReaderEntity GetSearchReader(String nic) throws Exception;

    public abstract BookEntity GetSearchBook(String ID) throws Exception;

    public abstract Boolean SaveBookIssuing(List<BookEntity> list, String NIC, String CurrentDate, String Returndate)
            throws Exception;

}
