package libraryManagementSystem.dao.interfaces;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

import libraryManagementSystem.dao.entity.ReturnBookEntity;

public interface ReturnBooksDAOInterface {

    public List<ReturnBookEntity> getSelectedReadersBooks(String NIC) throws Exception;

    public Boolean DeleteBooksAfterReturn(ReturnBookEntity bookEntity) throws Exception;

    public Boolean DeleteBooksAfterReturn(ReturnBookEntity bookEntity, Date d) throws Exception;

    public ResultSet check(ReturnBookEntity bookEntity) throws Exception;

}
