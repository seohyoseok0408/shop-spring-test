package edu.sm.service;

import edu.sm.dao.DiscountDao;
import edu.sm.dto.Discount;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DiscountService implements MService<Integer, Discount> {
    DiscountDao dao;
    ConnectionPool cp;

    public void setDao(DiscountDao dao) {
        this.dao = dao;
    }

    public void setCp(ConnectionPool cp) {
        this.cp = cp;
    }

    @Override
    public Discount add(Discount discount) throws Exception {
        throw new UnsupportedOperationException("Service에서 지원하지 않는 기능입니다.");
    }

    @Override
    public Discount modify(Discount discount) throws Exception {
        throw new UnsupportedOperationException("Service에서 지원하지 않는 기능입니다.");
    }

    @Override
    public Boolean remove(Integer disId) throws Exception {
        throw new UnsupportedOperationException("Service에서 지원하지 않는 기능입니다.");
    }

    @Override
    public Discount get(Integer disId) throws Exception {
        Connection conn = cp.getConnection();
        Discount discount = null;
        try {
            discount = dao.select(disId, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return discount;
    }

    @Override
    public List<Discount> get() throws Exception {
        throw new UnsupportedOperationException("Service에서 지원하지 않는 기능입니다.");
    }
}
