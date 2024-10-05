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
            ps.setInt(1, accessLog.getCid()); // 사용자 ID
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (ps != null) ps.close();
        }
        return accessLog;
    }

    @Override
    public AccessLog update(AccessLog accessLog, Connection conn) throws Exception {
        throw new UnsupportedOperationException("로그는 수정할 수 없습니다..");
    }

    @Override
    public boolean delete(Integer logId, Connection conn) throws Exception {
        throw new UnsupportedOperationException("로그는 삭제할 수 없습니다.");
    }

    @Override
    public AccessLog select(Integer logId, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Service에서 지원하지 않는 기능입니다.");
    }

    @Override
    public List<AccessLog> select(Connection conn) throws Exception {
        throw new UnsupportedOperationException("Service에서 지원하지 않는 기능입니다.");
    }
}
