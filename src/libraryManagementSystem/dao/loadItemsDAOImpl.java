package libraryManagementSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import libraryManagementSystem.dao.entity.bookCategoriesEntitiy;
import libraryManagementSystem.dao.entity.genderEntity;
import libraryManagementSystem.dao.interfaces.loadItemsInterfaces;
import libraryManagementSystem.database.connection;

public class loadItemsDAOImpl implements loadItemsInterfaces {

    @Override
    public List<bookCategoriesEntitiy> getAllBookCategories() throws Exception {

        List<bookCategoriesEntitiy> categories = new ArrayList<>();
        String query = "SELECT * FROM `bookcategories`";

        Connection DBconnection = connection.getConection().DatabaseConnection;
        PreparedStatement preparedStatement = DBconnection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            String id = resultSet.getString("idbookCategories");
            String name = resultSet.getString("category");
            // CategoryMap.put(categories, id);
            categories.add(new bookCategoriesEntitiy(id, name));
        }
        return categories;

    }

    @Override
    public List<genderEntity> genderLoading() throws Exception {

        List<genderEntity> gender = new ArrayList<>();
        String query = "SELECT * FROM `gender`";

        Connection DBconnection = connection.getConection().DatabaseConnection;
        PreparedStatement preparedStatement = DBconnection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            String id = resultSet.getString("idgender");
            String name = resultSet.getString("gender");
            // CategoryMap.put(categories, id);

            gender.add(new genderEntity(id, name));

        }
        return gender;

    }

}
