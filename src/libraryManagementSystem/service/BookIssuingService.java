package libraryManagementSystem.service;


import java.time.LocalDate;
import java.util.List;

import libraryManagementSystem.dao.BookIssuingDAO;
import libraryManagementSystem.dao.entity.BookEntity;
import libraryManagementSystem.dao.entity.ReaderEntity;
import libraryManagementSystem.dto.BookBorrowingConfirmDTO;
import libraryManagementSystem.dto.ReaderInsertDetailsDTO;
import libraryManagementSystem.service.serviceInterfaces.BookIssuingServiceInterfaces;

public class BookIssuingService implements BookIssuingServiceInterfaces {

    BookIssuingDAO bookIssuingDAO;

    public BookIssuingService() throws Exception {

        bookIssuingDAO = new BookIssuingDAO();
    }

    @Override
    public ReaderEntity giveSearchReader(String nic) throws Exception {

        if (nic != null) {

            return bookIssuingDAO.GetSearchReader(nic);

        } else {

            return null;

        }

    }

    @Override
    public BookEntity giveSelectBook(String ID) throws Exception {

        if (ID != null) {

            BookEntity bookEntity = bookIssuingDAO.GetSearchBook(ID);

            if (bookEntity != null) {

                if (bookEntity.getBookAvailableStatusID() == 1 && bookEntity.getBookStatusID() == 1) {

                    return bookEntity;

                } else {

                    return null;

                }

            } else {

                return null;

            }

        } else {

            return null;

        }

    }

    @Override
    public BookBorrowingConfirmDTO IssuingBookFinal(String NIC, List<BookEntity> list, ReaderInsertDetailsDTO reader)
            throws Exception {

        LocalDate IssuingDate = LocalDate.now();
        LocalDate Returndate = IssuingDate.plusDays(7);

        System.out.println(NIC);
        System.out.println(list);
        System.out.println(reader);

        if (NIC.equals(reader.getReaderNic())) {

            if (bookIssuingDAO.SaveBookIssuing(list, NIC, String.valueOf(IssuingDate), String.valueOf(Returndate))) {

                return new BookBorrowingConfirmDTO(true, String.valueOf(Returndate));

            }

           
            return new BookBorrowingConfirmDTO(false, String.valueOf(Returndate));

        }

        return new BookBorrowingConfirmDTO(false, String.valueOf(Returndate));

    }

}
