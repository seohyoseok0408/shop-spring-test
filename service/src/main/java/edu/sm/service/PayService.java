package edu.sm.service;

import edu.sm.dao.PayDao;
import edu.sm.dto.Pay;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PayService implements MService<Integer, Pay> {
    PayDao dao;
    ConnectionPool cp;

    public void setDao(PayDao dao) {
        this.dao = dao;
    }

    public void setCp(ConnectionPool cp) {
        this.cp = cp;
    }

    @Override
    public Pay add(Pay pay) throws Exception {
        Connection conn = cp.getConnection();
        try {
            conn.setAutoCommit(false);
            dao.insert(pay, conn);
            conn.commit();
            System.out.println("결제 추가됨");
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return pay;
    }

    @Override
    public Pay modify(Pay pay) throws Exception {
        throw new UnsupportedOperationException("지원하지 않는 기능입니다.");
    }

    @Override
    public Boolean remove(Integer id) throws Exception {
        throw new UnsupportedOperationException("지원하지 않는 기능입니다.");
    }

    @Override
    public Pay get(Integer payId) throws Exception {
        throw new UnsupportedOperationException("지원하지 않는 기능입니다.");
    }

    @Override
    public List<Pay> get() throws Exception {
        throw new UnsupportedOperationException("지원하지 않는 기능입니다.");
    }

    // 특정 주문 ID로 결제 정보 조회
    public Pay getByOrderId(int oid) throws Exception {
        Connection conn = cp.getConnection();
        Pay pay = null;
        try {
            pay = dao.selectByOrderId(oid, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return pay;
    }
}
