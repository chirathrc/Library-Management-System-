package libraryManagementSystem.service.serviceInterfaces;

import java.util.List;

import libraryManagementSystem.dao.entity.BookEntity;
import libraryManagementSystem.dao.entity.ReaderEntity;
import libraryManagementSystem.dto.BookBorrowingConfirmDTO;
import libraryManagementSystem.dto.ReaderInsertDetailsDTO;

public interface BookIssuingServiceInterfaces {

    public ReaderEntity giveSearchReader(String nic) throws Exception;

    public BookEntity giveSelectBook(String ID) throws Exception;

    public BookBorrowingConfirmDTO IssuingBookFinal(String NIC, List<BookEntity> list,ReaderInsertDetailsDTO reader) throws Exception;

}
