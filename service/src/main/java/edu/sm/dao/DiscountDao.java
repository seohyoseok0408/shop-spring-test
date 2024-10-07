package edu.sm.dao;

import edu.sm.dto.Discount;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DiscountDao implements Dao<Integer, Discount> {

    @Override
    public Discount insert(Discount discount, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Service에서 지원하지 않는 기능입니다.");
    }

    @Override
    public Discount update(Discount discount, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Service에서 지원하지 않는 기능입니다.");
    }

    @Override
    public boolean delete(Integer disId, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Service에서 지원하지 않는 기능입니다.");
    }

    @Override
    public Discount select(Integer disId, Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Discount discount = null;
        try {
            ps = conn.prepareStatement(Sql.SELECT_DISCOUNT_BY_ID);
            ps.setInt(1, disId);
            rs = ps.executeQuery();
            if (rs.next()) {
                discount = new Discount(
                        rs.getInt("dis_id"),
                        rs.getString("dis_name"),
                        rs.getFloat("dis_rate"),
                        rs.getDate("dis_start"),
                        rs.getDate("dis_end")
                );
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
            if (rs != null) rs.close();
        }
        return discount;
    }

    @Override
    public List<Discount> select(Connection conn) throws Exception {
        throw new UnsupportedOperationException("Service에서 지원하지 않는 기능입니다.");
    }
}
