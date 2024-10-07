package edu.sm.service;

import edu.sm.dao.OrderDao;
import edu.sm.dto.Order;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class OrderService implements MService<Integer, Order> {

    private OrderDao dao;  // OrderDao 주입받기
    private ConnectionPool cp;  // ConnectionPool 주입받기

    // Spring에서 주입받기 위한 setter 메서드 추가
    public void setDao(OrderDao dao) {
        this.dao = dao;
    }

    public void setCp(ConnectionPool cp) {
        this.cp = cp;
    }

    @Override
    public Order add(Order order) throws Exception {
        Connection conn = cp.getConnection();
        try {
            conn.setAutoCommit(false);
            dao.insert(order, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return order;
    }

    @Override
    public Order modify(Order order) throws Exception {
        Connection conn = cp.getConnection();
        try {
            dao.update(order, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return order;
    }

    @Override
    public Boolean remove(Integer oid) throws Exception {
        throw new UnsupportedOperationException("주문은 삭제할 수 없습니다.");
    }

    @Override
    public Order get(Integer oid) throws Exception {
        Connection conn = cp.getConnection();
        Order order = null;
        try {
            order = dao.select(oid, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return order;
    }

    @Override
    public List<Order> get() throws Exception {
        Connection conn = cp.getConnection();
        List<Order> orders = null;
        try {
            orders = dao.select(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return orders;
    }

    // 고객 ID로 주문 목록 조회 메서드 추가
    public List<Order> getByCustomerId(int cid) throws Exception {
        Connection conn = cp.getConnection();
        List<Order> orders = null;
        try {
            orders = dao.selectByCid(cid, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return orders;
    }

    // 주문 상태별 조회
    public List<Order> getOrdersByStatus(String status) throws Exception {
        Connection conn = cp.getConnection();
        List<Order> orders = null;
        try {
            orders = dao.selectOrdersByStatus(status, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return orders;
    }

    // 주문 상태 업데이트
    public void updateOrderStatus(int oid, String status) throws Exception {
        Connection conn = cp.getConnection();
        try {
            dao.updateOrderStatus(oid, status, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
    }

    // 일별 주문 통계 조회
    public List<Map<String, Object>> getDailyOrderStats() throws Exception {
        Connection conn = cp.getConnection();
        List<Map<String, Object>> stats = null;
        try {
            stats = dao.selectDailyOrderStats(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return stats;
    }

    // 월별 주문 통계 조회
    public List<Map<String, Object>> getMonthlyOrderStats() throws Exception {
        Connection conn = cp.getConnection();
        List<Map<String, Object>> stats = null;
        try {
            stats = dao.selectMonthlyOrderStats(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return stats;
    }
}
