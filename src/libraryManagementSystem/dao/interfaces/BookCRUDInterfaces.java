package libraryManagementSystem.dao.interfaces;

import java.sql.ResultSet;
import java.util.List;

import libraryManagementSystem.dao.entity.BookEntity;

public interface BookCRUDInterfaces {

    public boolean insertBook(BookEntity bookEntity);

    public ResultSet getSelectedBookDetails(String KeyWord) throws Exception;

    public List<BookEntity> getAllBookDetails() throws Exception;

    public Boolean updateBook(BookEntity bookEntity) throws Exception;

    public List<BookEntity> getSerachBookDetails(String search) throws Exception;

    public Boolean DeleteBook(int id) throws Exception; 

}
