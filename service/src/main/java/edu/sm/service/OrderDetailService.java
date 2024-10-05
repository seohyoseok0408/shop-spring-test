package edu.sm.service;

import edu.sm.dao.OrderDetailDao;
import edu.sm.dto.OrderDetail;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailService implements MService<Integer, OrderDetail> {
    OrderDetailDao dao;
    ConnectionPool cp;

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
            System.out.println("OrderDetail 추가됨");
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
        throw new UnsupportedOperationException("OrderDetail은 수정이 불가합니다.");
    }

    @Override
    public Boolean remove(Integer orderDetailId) throws Exception {
        throw new UnsupportedOperationException("OrderDetail은 수정이 불가합니다.");
    }

    @Override
    public OrderDetail get(Integer id) throws Exception {
        throw new UnsupportedOperationException("지원하지 않는 기능입니다.");
    }

    @Override
    public List<OrderDetail> get() throws Exception {
        throw new UnsupportedOperationException("Service에서 지원하지 않는 기능입니다.");
    }

    // 특정 주문에 대한 주문 상세 목록을 조회하는 메서드
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
