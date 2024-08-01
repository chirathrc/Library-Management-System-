package libraryManagementSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import libraryManagementSystem.dao.entity.ReaderEntity;
import libraryManagementSystem.dao.interfaces.ReaderDAOInterface;
import libraryManagementSystem.database.connection;

public class ReaderDAOImpl implements ReaderDAOInterface {

    Connection DBconnection;

    public ReaderDAOImpl() throws Exception {

        DBconnection = connection.getConection().DatabaseConnection;

    }

    @Override
    public Boolean InsertReader(ReaderEntity readerEntity) throws Exception {

        // System.out.println("Entity : " + readerEntity);

        String query = "INSERT INTO `members`(`NIC`,`member_FName`,`member_LName`,`birthday`,`registerDateTime`,`gender_idgender`,`memberStatus_idmemberStatus`) VALUES (?,?,?,?,?,?,?)";

        PreparedStatement statement = DBconnection.prepareStatement(query);
        statement.setString(1, readerEntity.getReaderNic());
        statement.setString(2, readerEntity.getReaderFname());
        statement.setString(3, readerEntity.getReaderLname());
        statement.setString(4, readerEntity.getReaderBirthday());
        statement.setString(5, readerEntity.getReaderRegisterTime());
        statement.setString(6, readerEntity.getReaderGender());
        statement.setInt(7, readerEntity.getReaderStatus());

        if (statement.executeUpdate() == 1) {

            return true;

        } else {

            return false;
        }

    }

    @Override
    public List<ReaderEntity> LoadAllReaders() throws Exception {

        List<ReaderEntity> ReaderDetails = new ArrayList<>();

        String query = "SELECT * FROM `members` INNER JOIN `gender` ON `members`.`gender_idgender` = `gender`.`idgender`";
        Statement statement = DBconnection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {

            String id = rs.getString("memberID");
            String NIC = rs.getString("NIC");
            String fname = rs.getString("member_FName");
            String lName = rs.getString("member_LName");
            String birthday = rs.getString("birthday");
            String regDateTime = rs.getString("registerDateTime");
            int Status = rs.getInt("memberStatus_idmemberStatus");
            String gender = rs.getString("gender");

            ReaderDetails.add(new ReaderEntity(id, fname, lName, NIC, birthday, gender, regDateTime, Status));

        }

        return ReaderDetails;

    }

    @Override
    public boolean UpdateReader(ReaderEntity readerEntity) throws Exception {

        System.out.println(readerEntity);

        String query = "UPDATE `members` SET `member_FName` = ?, `member_LName` = ?, `memberStatus_idmemberStatus` = ? WHERE `NIC` = ?";

        PreparedStatement statement = DBconnection.prepareStatement(query);
        statement.setString(1, readerEntity.getReaderFname());
        statement.setString(2, readerEntity.getReaderLname());
        statement.setInt(3, readerEntity.getReaderStatus());
        statement.setString(4, readerEntity.getReaderNic());

        if (statement.executeUpdate() == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<ReaderEntity> LoadSelectReaders(String s) throws Exception {

        List<ReaderEntity> ReaderDetails = new ArrayList<>();

        // System.out.println(s);

        String query = "SELECT * FROM members " +
                "INNER JOIN gender ON members.gender_idgender = gender.idgender " +
                "WHERE NIC LIKE ?";
        PreparedStatement preparedStatement = DBconnection.prepareStatement(query);
        preparedStatement.setString(1, "%" + s + "%");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {

            String id = rs.getString("memberID");
            String NIC = rs.getString("NIC");
            String fname = rs.getString("member_FName");
            String lName = rs.getString("member_LName");
            String birthday = rs.getString("birthday");
            String regDateTime = rs.getString("registerDateTime");
            int Status = rs.getInt("memberStatus_idmemberStatus");
            String gender = rs.getString("gender");

            ReaderDetails.add(new ReaderEntity(id, fname, lName, NIC, birthday, gender, regDateTime, Status));

        }

        // System.out.println(ReaderDetails);

        return ReaderDetails;

    }

    @Override
    public Boolean DeleteReader(ReaderEntity entity) throws Exception {

        String query = "DELETE FROM `members` WHERE `NIC` = ?";
        PreparedStatement statement = DBconnection.prepareStatement(query);
        statement.setString(1, entity.getReaderNic());

        if (statement.executeUpdate() == 1) {

            return true;

        } else {

            return false;
        }
    }

}
