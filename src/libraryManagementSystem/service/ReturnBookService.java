package libraryManagementSystem.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import libraryManagementSystem.dao.ReturnBooksDao;
import libraryManagementSystem.dao.entity.ReturnBookEntity;
import libraryManagementSystem.service.serviceInterfaces.BookReturnServiceInterface;

public class ReturnBookService implements BookReturnServiceInterface {

    ReturnBooksDao ReturnBooksDao;

    public ReturnBookService() throws Exception {

        ReturnBooksDao = new ReturnBooksDao();

    }

    @Override
    public List<ReturnBookEntity> ReturnBooks(String NIC) throws Exception {

        List<ReturnBookEntity> list = ReturnBooksDao.getSelectedReadersBooks(NIC);

        if (list.size() != 0) {

            for (ReturnBookEntity r : list) {

                LocalDate today = LocalDate.now();
                LocalDate returnDate = Date.valueOf(r.getReturnDate()).toLocalDate();

                if (today.isBefore(returnDate) || today.isEqual(returnDate)) {

                    r.setLatePanlety(null);

                } else {
                    // Calculate the number of days since the given date
                    long daysPassed = ChronoUnit.DAYS.between(returnDate, today);
                    // System.out.println("Today's date is after the given date.");
                    // System.out.println("Number of days passed since the given date: " +
                    // daysPassed);
                    int Calculate = Integer.parseInt(String.valueOf(daysPassed)) * 200;
                    Double LatePayment = Double.valueOf(String.valueOf(Calculate));

                    r.setLatePanlety(LatePayment);

                }
            }

            return list;

        } else {

            return null;

        }

    }

    @Override
    public boolean ReturnBookFinal(ReturnBookEntity bookEntity, String NIC) throws Exception {

        LocalDate today = LocalDate.now();

        if (bookEntity.getNIC().equals(NIC)) {

            ResultSet rs = ReturnBooksDao.check(bookEntity);

            if (rs.next()) {

                if (bookEntity.getLatePanlety() == null) {

                    return ReturnBooksDao.DeleteBooksAfterReturn(bookEntity);

                } else {

                    return ReturnBooksDao.DeleteBooksAfterReturn(bookEntity, Date.valueOf(today));

                }

            } else {

                return false;

            }

        } else {

            return false;
        }

    }

}
