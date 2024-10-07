package edu.sm.service;

import edu.sm.dao.OrderDetailDao;
import edu.sm.dto.OrderDetail;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.util.List;

public class OrderDetailService implements MService<Integer, OrderDetail> {

    private OrderDetailDao dao;  // OrderDetailDao 주입받기
    private ConnectionPool cp;  // ConnectionPool 주입받기

    // Spring에서 주입받기 위한 setter 메서드 추가
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
        throw new UnsupportedOperationException("Order details cannot be modified.");
    }

    @Override
    public Boolean remove(Integer orderDetailId) throws Exception {
        throw new UnsupportedOperationException("Order details cannot be removed.");
    }

    @Override
    public OrderDetail get(Integer orderDetailId) throws Exception {
        Connection conn = cp.getConnection();
        OrderDetail orderDetail = null;
        try {
            orderDetail = dao.select(orderDetailId, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return orderDetail;
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

    // 주문 번호로 OrderDetail 목록을 조회하는 메서드 추가
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
