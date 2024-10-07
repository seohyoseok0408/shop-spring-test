package edu.sm.service;

import edu.sm.dao.AccessLogDao;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;
import edu.sm.dto.AccessLog;

import java.sql.Connection;
import java.util.List;

public class AccessLogService implements MService<Integer, AccessLog> {
    private AccessLogDao dao;
    private ConnectionPool cp;

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
            dao.insert(accessLog, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return accessLog;
    }

    @Override
    public AccessLog modify(AccessLog accessLog) throws Exception {
        throw new UnsupportedOperationException("접속 로그는 수정할 수 없습니다.");
    }

    @Override
    public Boolean remove(Integer id) throws Exception {
        throw new UnsupportedOperationException("접속 로그는 삭제할 수 없습니다.");
    }

    @Override
    public AccessLog get(Integer id) throws Exception {
        Connection conn = cp.getConnection();
        AccessLog accessLog;
        try {
            accessLog = dao.select(id, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return accessLog;
    }

    @Override
    public List<AccessLog> get() throws Exception {
        Connection conn = cp.getConnection();
        List<AccessLog> accessLogs;
        try {
            accessLogs = dao.select(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return accessLogs;
    }

    public List<String> getHourlyStats() throws Exception {
        Connection conn = cp.getConnection();
        List<String> stats;
        try {
            stats = dao.selectHourlyStats(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return stats;
    }

    public List<String> getDailyStats() throws Exception {
        Connection conn = cp.getConnection();
        List<String> stats;
        try {
            stats = dao.selectDailyStats(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return stats;
    }

    public List<String> getWeeklyStats() throws Exception {
        Connection conn = cp.getConnection();
        List<String> stats;
        try {
            stats = dao.selectWeeklyStats(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return stats;
    }

    public List<String> getMonthlyStats() throws Exception {
        Connection conn = cp.getConnection();
        List<String> stats;
        try {
            stats = dao.selectMonthlyStats(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return stats;
    }

    public List<String> getYearlyStats() throws Exception {
        Connection conn = cp.getConnection();
        List<String> stats;
        try {
            stats = dao.selectYearlyStats(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return stats;
    }
}
