package edu.sm.dao;

import edu.sm.dto.AccessLog;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccessLogDao implements Dao<Integer, AccessLog> {

    @Override
    public AccessLog insert(AccessLog accessLog, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.INSERT_ACCESS_LOG);
            ps.setInt(1, accessLog.getCid());
            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
        }
        return accessLog;
    }

    @Override
    public AccessLog update(AccessLog accessLog, Connection conn) throws Exception {
        throw new UnsupportedOperationException("접속 로그는 수정할 수 없습니다.");
    }

    @Override
    public boolean delete(Integer id, Connection conn) throws Exception {
        throw new UnsupportedOperationException("접속 로그는 삭제할 수 없습니다.");
    }

    @Override
    public AccessLog select(Integer id, Connection conn) throws Exception {
        AccessLog accessLog = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(Sql.SELECT_ACCESS_LOG_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                accessLog = new AccessLog(
                        rs.getInt("log_id"),
                        rs.getInt("cid"),
                        rs.getTimestamp("access_time")
                );
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return accessLog;
    }

    @Override
    public List<AccessLog> select(Connection conn) throws Exception {
        List<AccessLog> logs = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(Sql.SELECT_ALL_ACCESS_LOGS);
            rs = ps.executeQuery();
            while (rs.next()) {
                logs.add(new AccessLog(
                        rs.getInt("log_id"),
                        rs.getInt("cid"),
                        rs.getTimestamp("access_time")
                ));
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return logs;
    }

    public List<String> selectHourlyStats(Connection conn) throws Exception {
        List<String> stats = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(Sql.SELECT_HOURLY_ACCESS_STATS);
            rs = ps.executeQuery();
            while (rs.next()) {
                stats.add(rs.getString(1) + " : " + rs.getInt(2));
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return stats;
    }

    public List<String> selectDailyStats(Connection conn) throws Exception {
        List<String> stats = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(Sql.SELECT_DAILY_ACCESS_STATS);
            rs = ps.executeQuery();
            while (rs.next()) {
                stats.add(rs.getString(1) + " : " + rs.getInt(2));
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return stats;
    }

    public List<String> selectWeeklyStats(Connection conn) throws Exception {
        List<String> stats = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(Sql.SELECT_WEEKLY_ACCESS_STATS);
            rs = ps.executeQuery();
            while (rs.next()) {
                stats.add(rs.getString(1) + " : " + rs.getInt(2));
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return stats;
    }

    public List<String> selectMonthlyStats(Connection conn) throws Exception {
        List<String> stats = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(Sql.SELECT_MONTHLY_ACCESS_STATS);
            rs = ps.executeQuery();
            while (rs.next()) {
                stats.add(rs.getString(1) + " : " + rs.getInt(2));
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return stats;
    }

    public List<String> selectYearlyStats(Connection conn) throws Exception {
        List<String> stats = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(Sql.SELECT_YEARLY_ACCESS_STATS);
            rs = ps.executeQuery();
            while (rs.next()) {
                stats.add(rs.getString(1) + " : " + rs.getInt(2));
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return stats;
    }
}
