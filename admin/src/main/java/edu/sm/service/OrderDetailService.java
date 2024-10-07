package edu.sm.service;

import edu.sm.dao.OrderDetailDao;
import edu.sm.dto.OrderDetail;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.util.List;

public class OrderDetailService implements MService<Integer, OrderDetail> {

    private OrderDetailDao dao;
    private ConnectionPool cp;

    public void setDao(OrderDetailDao dao) {
        this.dao = dao;
    }

    public void setCp(ConnectionPool cp) {
        this.cp = cp;
    }

    @Override
    public OrderDetail add(OrderDetail orderDetail) throws Exception {
        Connection conn = cp.getConnection();
        try {
            conn.setAutoCommit(false);
            dao.insert(orderDetail, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return orderDetail;
    }

    @Override
    public OrderDetail modify(OrderDetail orderDetail) throws Exception {
        throw new UnsupportedOperationException("Order details cannot be updated.");
    }

    @Override
    public Boolean remove(Integer orderDetailId) throws Exception {
        throw new UnsupportedOperationException("Order details cannot be deleted.");
    }

    @Override
    public OrderDetail get(Integer id) throws Exception {
        throw new UnsupportedOperationException("Order details cannot be retrieved by id.");
    }

    @Override
    public List<OrderDetail> get() throws Exception {
        Connection conn = cp.getConnection();
        List<OrderDetail> orderDetails = null;
        try {
            orderDetails = dao.select(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return orderDetails;
    }

    // 특정 주문 ID로 주문 상세 내역 조회
    public List<OrderDetail> getByOid(int oid) throws Exception {
        Connection conn = cp.getConnection();
        List<OrderDetail> orderDetails = null;
        try {
            orderDetails = dao.selectByOid(oid, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return orderDetails;
    }
}
