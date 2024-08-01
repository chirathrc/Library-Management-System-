package libraryManagementSystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import libraryManagementSystem.dao.entity.ReturnBookEntity;
import libraryManagementSystem.dao.interfaces.ReturnBooksDAOInterface;
import libraryManagementSystem.database.connection;

public class ReturnBooksDao implements ReturnBooksDAOInterface {

    Connection DBconnection;

    public ReturnBooksDao() throws Exception {

        DBconnection = connection.getConection().DatabaseConnection;
    }

    @Override
    public List<ReturnBookEntity> getSelectedReadersBooks(String NIC) throws Exception {

        List<ReturnBookEntity> list = new ArrayList<>();

        String query = "SELECT * FROM `borrowingbooks` INNER JOIN `books` ON `borrowingbooks`.`books_idbooks` = `books`.`idbooks` INNER JOIN `members` ON `borrowingbooks`.`members_NIC` = `members`.`NIC` WHERE `members_NIC` = ?";

        PreparedStatement statement = DBconnection.prepareStatement(query);
        statement.setString(1, NIC);

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {

            list.add(new ReturnBookEntity(rs.getString("NIC"),
                    rs.getString("member_FName") + " " + rs.getString("member_LName"),
                    rs.getString("birthday"),
                    rs.getString("idbooks"),
                    rs.getString("name"),
                    rs.getString("author"),
                    rs.getString("borrowingDate"),
                    rs.getString("returnDate"),
                    rs.getString("borrowingId")));

        }

        return list;

    }

    @Override
    public Boolean DeleteBooksAfterReturn(ReturnBookEntity bookEntity) throws Exception {

        int status = 1;

        String query = "DELETE FROM `borrowingbooks` WHERE `borrowingId` = ? AND `members_NIC` = ? AND `books_idbooks` = ?";
        PreparedStatement statement = DBconnection.prepareStatement(query);

        statement.setString(1, bookEntity.getIssuingId());
        statement.setString(2, bookEntity.getNIC());
        statement.setString(3, bookEntity.getBookID());

        String AvailableStatusUpdate = "UPDATE `books` SET `bookAvalaiblityStatus_idbookAvalaiblityStatus` = ? WHERE `idbooks` = ?";
        PreparedStatement AvailableStatusUpdatestatement = DBconnection.prepareStatement(AvailableStatusUpdate);

        AvailableStatusUpdatestatement.setInt(1, status);
        AvailableStatusUpdatestatement.setString(2, bookEntity.getBookID());

        if (statement.executeUpdate() == 1 && AvailableStatusUpdatestatement.executeUpdate() == 1) {
            return true;
        }

        return false;
    }

    @Override
    public Boolean DeleteBooksAfterReturn(ReturnBookEntity bookEntity, Date d) throws Exception {

        int status = 1;

        String query = "DELETE FROM `borrowingbooks` WHERE `borrowingId` = ? AND `members_NIC` = ? AND `books_idbooks` = ?";
        PreparedStatement statement = DBconnection.prepareStatement(query);

        statement.setString(1, bookEntity.getIssuingId());
        statement.setString(2, bookEntity.getNIC());
        statement.setString(3, bookEntity.getBookID());

        String query2 = "INSERT INTO `latepayments`(`Amount`, `Date`, `members_NIC`) VALUES (?, ?, ?)";
        PreparedStatement statement02 = DBconnection.prepareStatement(query2);
        statement02.setDouble(1, bookEntity.getLatePanlety());
        statement02.setDate(2, d);
        statement02.setString(3, bookEntity.getNIC());

        String AvailableStatusUpdate = "UPDATE `books` SET `bookAvalaiblityStatus_idbookAvalaiblityStatus` = ? WHERE `idbooks` = ?";
        PreparedStatement AvailableStatusUpdatestatement = DBconnection.prepareStatement(AvailableStatusUpdate);

        AvailableStatusUpdatestatement.setInt(1, status);
        AvailableStatusUpdatestatement.setString(2, bookEntity.getBookID());

        if (statement.executeUpdate() == 1 && statement02.executeUpdate() == 1
                && AvailableStatusUpdatestatement.executeUpdate() == 1) {
            return true;
        }

        return false;
    }

    @Override
    public ResultSet check(ReturnBookEntity bookEntity) throws Exception {
        String query = "SELECT * FROM `borrowingbooks` WHERE `borrowingId` = ? AND `members_NIC` = ? AND `books_idbooks` = ?";
        PreparedStatement statement = DBconnection.prepareStatement(query);

        statement.setString(1, bookEntity.getIssuingId());
        statement.setString(2, bookEntity.getNIC());
        statement.setString(3, bookEntity.getBookID());

        return statement.executeQuery();
    }

}
