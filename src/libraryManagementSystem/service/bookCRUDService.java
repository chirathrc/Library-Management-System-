package libraryManagementSystem.service;

import java.util.List;

import libraryManagementSystem.dao.BookDAOImpl;
import libraryManagementSystem.dao.entity.BookEntity;
import libraryManagementSystem.dto.BookInsertDetailsDTO;
import libraryManagementSystem.service.serviceInterfaces.BookServiceCRUD;

public class bookCRUDService implements BookServiceCRUD {

    private BookDAOImpl bookDAOImpl;

    public bookCRUDService() throws Exception {

        bookDAOImpl = new BookDAOImpl();

    }

    @Override
    public boolean bookInsert(BookInsertDetailsDTO bookInsertDetailsDTO) {

        return bookDAOImpl
                .insertBook(new BookEntity(bookInsertDetailsDTO.getBookName(), bookInsertDetailsDTO.getAuthorName(),
                        bookInsertDetailsDTO.getDescription(), bookInsertDetailsDTO.getCategory(),
                        bookInsertDetailsDTO.getRegisterDateTime()));

    }

    @Override
    public List<BookEntity> LoadAllBooks() throws Exception {

        return bookDAOImpl.getAllBookDetails();
    }

    @Override
    public boolean UpdateBook(BookInsertDetailsDTO bookInsertDetailsDTO) throws Exception {

        return bookDAOImpl
                .updateBook(new BookEntity(bookInsertDetailsDTO.getBookID(), bookInsertDetailsDTO.getBookName(),
                        bookInsertDetailsDTO.getDescription(), Integer.parseInt(bookInsertDetailsDTO.getBookStatus())));

    }

    @Override
    public List<BookEntity> LoadSearchAllBooks(String search) throws Exception {

        return bookDAOImpl.getSerachBookDetails(search);
    }

    @Override
    public Boolean DeleteBook(int id) throws Exception {

        return bookDAOImpl.DeleteBook(id);

    }

}
