package com.codegym.cglazadaplusproject.dao;

import com.codegym.cglazadaplusproject.constant.QueryConstant;
import com.codegym.cglazadaplusproject.model.Category;
import com.codegym.cglazadaplusproject.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO {
    private final Connection connection = JDBCConnection.getConnection();
        @Override
        public List<Category> getAllCategory() {
            List<Category> categories = new ArrayList<>();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(QueryConstant.GET_ALL_CATEGORY);
                preparedStatement.setBoolean(1, false);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int categoryId = resultSet.getInt("category_id");
                    String categoryName = resultSet.getString("category_name");
                    boolean isDelete = resultSet.getBoolean("is_delete");
                    categories.add(new Category(categoryId, categoryName, isDelete));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return categories;
        }
}
