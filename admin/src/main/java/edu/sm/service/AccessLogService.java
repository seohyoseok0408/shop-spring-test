package edu.sm.service;

import edu.sm.dao.AccessLogDao;
import edu.sm.dto.AccessLog;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

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
            conn.setAutoCommit(false);
            dao.insert(accessLog, conn);
            conn.commit();
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
        throw new UnsupportedOperationException("Access logs can't be updated.");
    }

    @Override
    public Boolean remove(Integer logId) throws Exception {
        throw new UnsupportedOperationException("Access logs can't be deleted.");
    }

    @Override
    public AccessLog get(Integer logId) throws Exception {
        Connection conn = cp.getConnection();
        AccessLog accessLog = null;
        try {
            accessLog = dao.select(logId, conn);
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
        List<AccessLog> accessLogs = null;
        try {
            accessLogs = dao.select(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return accessLogs;
    }

    // 시간별 접속 통계
    public List<String> getHourlyStats() throws Exception {
        return executeStatsQuery(dao::selectHourlyStats);
    }

    // 일별 접속 통계
    public List<String> getDailyStats() throws Exception {
        return executeStatsQuery(dao::selectDailyStats);
    }

    // 요일별 접속 통계
    public List<String> getWeeklyStats() throws Exception {
        return executeStatsQuery(dao::selectWeeklyStats);
    }

    // 월별 접속 통계
    public List<String> getMonthlyStats() throws Exception {
        return executeStatsQuery(dao::selectMonthlyStats);
    }

    // 연도별 접속 통계
    public List<String> getYearlyStats() throws Exception {
        return executeStatsQuery(dao::selectYearlyStats);
    }

    // 통계 조회 공통 메서드: Connection을 한 번만 가져오고, 여러 쿼리에 사용
    private List<String> executeStatsQuery(StatsQueryExecutor executor) throws Exception {
        Connection conn = cp.getConnection();
        List<String> stats;
        try {
            stats = executor.execute(conn);  // Connection을 한 번만 가져옴
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return stats;
    }

    // 함수형 인터페이스 정의
    @FunctionalInterface
    private interface StatsQueryExecutor {
        List<String> execute(Connection conn) throws Exception;
    }
}
