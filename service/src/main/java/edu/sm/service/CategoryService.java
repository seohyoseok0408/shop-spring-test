package edu.sm.service;

import edu.sm.dao.CategoryDao;
import edu.sm.dto.Category;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryService implements MService<Integer, Category> {
    CategoryDao dao;
    ConnectionPool cp;

    public void setDao(CategoryDao dao) {
        this.dao = dao;
    }

    public void setCp(ConnectionPool cp) {
        this.cp = cp;
    }

    @Override
    public Category add(Category category) throws Exception {
        throw new UnsupportedOperationException("Service에서 카테고리 추가는 지원하지 않습니다.");
    }

    @Override
    public Category modify(Category category) throws Exception {
        throw new UnsupportedOperationException("Service에서 카테고리 수정은 지원하지 않습니다.");
    }

    @Override
    public Boolean remove(Integer categoryId) throws Exception {
        throw new UnsupportedOperationException("Service에서 카테고리 삭제는 지원하지 않습니다.");
    }

    @Override
    public Category get(Integer categoryId) throws Exception {
        throw new UnsupportedOperationException("Service에서 카테고리 단일명 검색은 지원하지 않습니다.");
    }

    @Override
    public List<Category> get() throws Exception {
        Connection conn = cp.getConnection();
        List<Category> categories = null;
        try {
            categories = dao.select(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return categories;
    }
}
