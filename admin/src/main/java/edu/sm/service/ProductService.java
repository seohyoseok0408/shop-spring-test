package edu.sm.service;

import edu.sm.dao.ProductDao;
import edu.sm.dto.Product;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.util.List;

public class ProductService implements MService<Integer, Product> {
    private ProductDao dao;  // 의존성 주입을 받도록 수정
    private ConnectionPool cp;  // 의존성 주입을 받도록 수정

    // Spring을 통해 주입받기 위한 setter 메서드 추가
    public void setDao(ProductDao dao) {
        this.dao = dao;
    }

    public void setCp(ConnectionPool cp) {
        this.cp = cp;
    }

    @Override
    public Product add(Product product) throws Exception {
        Connection conn = cp.getConnection();
        try {
            conn.setAutoCommit(false);
            dao.insert(product, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return product;
    }

    @Override
    public Product modify(Product product) throws Exception {
        Connection conn = cp.getConnection();
        try {
            dao.update(product, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return product;
    }

    @Override
    public Boolean remove(Integer pid) throws Exception {
        throw new UnsupportedOperationException("상품 삭제 불가능");
    }

    @Override
    public Product get(Integer pid) throws Exception {
        Connection conn = cp.getConnection();
        Product product = null;
        try {
            product = dao.select(pid, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return product;
    }

    @Override
    public List<Product> get() throws Exception {
        Connection conn = cp.getConnection();
        List<Product> products = null;
        try {
            products = dao.select(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return products;
    }

    // 카테고리별로 상품을 조회하는 메서드
    public List<Product> getProductsByCategory(int categoryId) throws Exception {
        Connection conn = cp.getConnection();
        List<Product> products;
        try {
            products = dao.selectByCategory(categoryId, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return products;
    }

    public List<Product> getProductsSortedBy(String sortBy, Integer categoryId) throws Exception {
        Connection conn = cp.getConnection();
        List<Product> products = null;
        try {
            products = dao.selectAllSortedBy(sortBy, categoryId, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return products;
    }
}
