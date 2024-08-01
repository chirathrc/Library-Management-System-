package libraryManagementSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import libraryManagementSystem.dao.entity.BookEntity;
import libraryManagementSystem.dao.entity.ReaderEntity;
import libraryManagementSystem.dao.interfaces.BookIssuingInterface;
import libraryManagementSystem.database.connection;

public class BookIssuingDAO implements BookIssuingInterface {

    Connection DbConnection;

    public BookIssuingDAO() throws Exception {

        DbConnection = connection.getConection().DatabaseConnection;

    }

    @Override
    public ReaderEntity GetSearchReader(String nic) throws Exception {

        String query = "SELECT * FROM `members` WHERE `NIC` = ? AND `memberStatus_idmemberStatus` = '1'";

        PreparedStatement statement = DbConnection.prepareStatement(query);
        statement.setString(1, nic);

        ResultSet rs = statement.executeQuery();
        if (rs.next()) {

            return new ReaderEntity(rs.getString("NIC"), rs.getString("member_FName"), rs.getString("member_LName"),
                    rs.getString("birthday"));

        }

        return null;
    }

    @Override
    public BookEntity GetSearchBook(String ID) throws Exception {

        String query = "SELECT * FROM `books` WHERE `idbooks` = ?";
        PreparedStatement statement = DbConnection.prepareStatement(query);
        statement.setString(1, ID);

        ResultSet rs = statement.executeQuery();
        if (rs.next()) {

            return new BookEntity(rs.getString("idbooks"), rs.getString("name"), rs.getString("author"),
                    rs.getInt("bookStatus_idbookStatus"), rs.getInt("bookAvalaiblityStatus_idbookAvalaiblityStatus"));

        }

        return null;

    }

    @Override
    public Boolean SaveBookIssuing(List<BookEntity> list, String NIC, String CurrentDate, String Returndate)
            throws Exception {

        // System.out.println(CurrentDate);
        // System.out.println(Returndate);
        // System.out.println(list);

        int status = 2;

        String query = "INSERT INTO `borrowingbooks`(`books_idbooks`,`members_NIC`,`borrowingDate`,`returnDate`) VALUES(?,?,?,?)";
        PreparedStatement statement = DbConnection.prepareStatement(query);

        String AvailableStatusUpdate = "UPDATE `books` SET `bookAvalaiblityStatus_idbookAvalaiblityStatus` = ? WHERE `idbooks` = ?";
        PreparedStatement AvailableStatusUpdatestatement = DbConnection.prepareStatement(AvailableStatusUpdate);

        boolean b = false;

        for (BookEntity bookEntity : list) {

            statement.setString(1, bookEntity.getBookId());
            statement.setString(2, NIC);
            statement.setString(3, CurrentDate);
            statement.setString(4, Returndate);

            AvailableStatusUpdatestatement.setInt(1, status);
            AvailableStatusUpdatestatement.setString(2, bookEntity.getBookId());

            if (statement.executeUpdate() == 1 && AvailableStatusUpdatestatement.executeUpdate() == 1) {

                b = true;

            }

            if (b == false) {

                return b;

            }

        }

        return b;

    }

}
