package edu.sm.service;

import edu.sm.dao.AccessLogDao;
import edu.sm.dto.AccessLog;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AccessLogService implements MService<Integer, AccessLog> {
    AccessLogDao dao;
    ConnectionPool cp;

    public void setDao(AccessLogDao dao) {
        this.dao = dao;
    }

    public void setCp(ConnectionPool cp) {
        this.cp = cp;
    }

    @Override
    public AccessLog add(AccessLog accessLog) throws Exception {
        Connection conn = cp.getConnection();
        try {
            conn.setAutoCommit(false);
            dao.insert(accessLog, conn);
            conn.commit();
            System.out.println("AccessLog 추가됨");
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return accessLog;
    }

    @Override
    public AccessLog modify(AccessLog accessLog) throws Exception {
        throw new UnsupportedOperationException("로그는 수정할 수 없습니다..");
    }

    @Override
    public Boolean remove(Integer logId) throws Exception {
        throw new UnsupportedOperationException("로그는 삭제할 수 없습니다.");
    }

    @Override
    public AccessLog get(Integer logId) throws Exception {
        throw new UnsupportedOperationException("Service에서 지원하지 않는 기능입니다.");
    }

    @Override
    public List<AccessLog> get() throws Exception {
        throw new UnsupportedOperationException("Service에서 지원하지 않는 기능입니다.");
    }
}
