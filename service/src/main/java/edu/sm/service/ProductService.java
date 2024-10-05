package edu.sm.service;

import edu.sm.dao.ProductDao;
import edu.sm.dto.Product;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductService implements MService<Integer, Product> {
    ProductDao dao;
    ConnectionPool cp;

    public void setDao(ProductDao dao) {
        this.dao = dao;
    }

    public void setCp(ConnectionPool cp) {
        this.cp = cp;
    }

    @Override
    public Product add(Product product) throws Exception {
        throw new UnsupportedOperationException("Servie에서 지원하지 않는 기능입니다.");
    }

    @Override
    public Product modify(Product product) throws Exception {
        throw new UnsupportedOperationException("Servie에서 지원하지 않는 기능입니다.");
    }

    @Override
    public Boolean remove(Integer pid) throws Exception {
        throw new UnsupportedOperationException("상품은 삭제가 불가합니다.");
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
        throw new UnsupportedOperationException("Servie에서 지원하지 않는 기능입니다.");
    }

    public List<Product> getPublicProducts() throws Exception {
        Connection conn = cp.getConnection();
        List<Product> products = null;
        try {
            products = dao.selectPublicProducts(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return products;
    }

    // 공개된 상품을 카테고리별로 조회
    public List<Product> getPublicProductsByCategory(int categoryId) throws Exception {
        Connection conn = cp.getConnection();
        List<Product> products;
        try {
            products = dao.selectPublicByCategory(categoryId, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return products;
    }

    // 공개된 상품을 상품명으로 조회
    public List<Product> getPublicByName(String pname) throws Exception {
        Connection conn = cp.getConnection();
        List<Product> products = null;
        try {
            products = dao.selectPublicByName(pname, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return products;
    }
}
