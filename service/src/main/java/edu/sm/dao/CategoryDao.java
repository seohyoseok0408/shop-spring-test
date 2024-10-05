package edu.sm.dao;

import edu.sm.dto.Category;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements Dao<Integer, Category> {

    @Override
    public Category insert(Category category, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Service에서 카테고리 추가는 지원하지 않습니다.");
    }

    @Override
    public Category update(Category category, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Service에서 카테고리 수정은 지원하지 않습니다.");
    }

    @Override
    public boolean delete(Integer categoryId, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Service에서 카테고리 삭제는 지원하지 않습니다.");
    }

    @Override
    public Category select(Integer categoryId, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Service에서 카테고리 단일명 검색은 지원하지 않습니다.");
    }

    @Override
    public List<Category> select(Connection conn) throws Exception {
        List<Category> categories = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(Sql.SELECT_ALL_CATEGORIES);
            rs = ps.executeQuery();
            while (rs.next()) {
                categories.add(new Category(
                        rs.getInt("category_id"),
                        rs.getString("category_name"),
                        rs.getString("category_detail")
                ));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
            if (rs != null) rs.close();
        }
        return categories;
    }
}
