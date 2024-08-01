package libraryManagementSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import libraryManagementSystem.dao.entity.BookEntity;
import libraryManagementSystem.dao.interfaces.BookCRUDInterfaces;

public class BookDAOImpl implements BookCRUDInterfaces {

    private Connection connection;

    public BookDAOImpl() throws Exception {

        connection = libraryManagementSystem.database.connection.getConection().DatabaseConnection;

    }

    @Override
    public boolean insertBook(BookEntity bookEntity) {

        try {

            String query = "INSERT INTO `books`(`name`,`description`,`author`,`registerDate`,`bookStatus_idbookStatus`,`bookCategories_idbookCategories`,`bookAvalaiblityStatus_idbookAvalaiblityStatus`) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, bookEntity.getBookName());
            statement.setString(2, bookEntity.getDescription());
            statement.setString(3, bookEntity.getAuthorName());
            statement.setString(4, bookEntity.getRegisterDateTime());
            statement.setString(5, String.valueOf(bookEntity.getBookStatusID()));
            statement.setString(6, bookEntity.getCategory());
            statement.setString(7, String.valueOf(bookEntity.getBookAvailableStatusID()));

            int a = statement.executeUpdate();

            if (a == 1) {

                return true;
            } else {

                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }

    }

    @Override
    public ResultSet getSelectedBookDetails(String KeyWord) throws Exception {

        String query = "SELECT * FROM `books` WHERE `name` LIKE ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, "%" + KeyWord + "%");

        return preparedStatement.executeQuery();

    }

    @Override
    public List<BookEntity> getAllBookDetails() throws Exception {

        ArrayList<BookEntity> book = new ArrayList<>();

        String query = "SELECT * FROM `books` INNER JOIN `bookcategories` ON `books`.`bookCategories_idbookCategories` = `bookcategories`.`idbookCategories` INNER JOIN `bookavalaiblitystatus` ON `books`.`bookAvalaiblityStatus_idbookAvalaiblityStatus` = `bookavalaiblitystatus`.`idbookAvalaiblityStatus` INNER JOIN `bookstatus` ON `books`.`bookStatus_idbookStatus` = `bookstatus`.`idbookStatus`";
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {

            book.add(new BookEntity(rs.getString("idbooks"), rs.getString("name"), rs.getString("author"),
                    rs.getString("description"),
                    rs.getInt("bookStatus_idbookStatus"), rs.getString("registerDate"), rs.getString("category"),
                    rs.getString("bookStatus"), rs.getString("avalability")));

        }

        return book;

    }

    @Override
    public Boolean updateBook(BookEntity bookEntity) throws Exception {

        

        String query = "UPDATE `books` SET `name` = ? , `description` = ?, `bookStatus_idbookStatus` = ?  WHERE `idbooks` = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, bookEntity.getBookName());
        statement.setString(2, bookEntity.getDescription());
        statement.setInt(3, bookEntity.getBookStatusID());
        statement.setString(4, bookEntity.getBookId());

        if (statement.executeUpdate() == 1) {

            return true;

        }

        return false;

    }

    @Override
    public List<BookEntity> getSerachBookDetails(String search) throws Exception {

        ArrayList<BookEntity> book = new ArrayList<>();

        String query = "SELECT * FROM `books` INNER JOIN `bookcategories` ON `books`.`bookCategories_idbookCategories` = `bookcategories`.`idbookCategories` INNER JOIN `bookavalaiblitystatus` ON `books`.`bookAvalaiblityStatus_idbookAvalaiblityStatus` = `bookavalaiblitystatus`.`idbookAvalaiblityStatus` INNER JOIN `bookstatus` ON `books`.`bookStatus_idbookStatus` = `bookstatus`.`idbookStatus` WHERE `name` LIKE ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "%" + search + "%");

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {

            book.add(new BookEntity(rs.getString("idbooks"), rs.getString("name"), rs.getString("author"),
                    rs.getString("description"),
                    rs.getInt("bookStatus_idbookStatus"), rs.getString("registerDate"), rs.getString("category"),
                    rs.getString("bookStatus"), rs.getString("avalability")));

        }

        return book;
    }

    @Override
    public Boolean DeleteBook(int id) throws Exception {

        String query = "DELETE FROM `books` WHERE `idbooks` = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        if (statement.executeUpdate() == 1) {

            return true;

        }

        return false;
    }

}
