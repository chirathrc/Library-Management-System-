package libraryManagementSystem.service.serviceInterfaces;

import java.util.List;

import libraryManagementSystem.dao.entity.BookEntity;
import libraryManagementSystem.dto.BookInsertDetailsDTO;

public interface BookServiceCRUD {

    public boolean bookInsert(BookInsertDetailsDTO bookInsertDetailsDTO);

    public List<BookEntity> LoadAllBooks() throws Exception;

    public boolean UpdateBook(BookInsertDetailsDTO bookInsertDetailsDTO) throws Exception;

    public List<BookEntity> LoadSearchAllBooks(String search) throws Exception;

    public Boolean DeleteBook(int id) throws Exception; 

}
