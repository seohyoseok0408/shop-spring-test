package edu.sm.dao;

import edu.sm.dto.Customer;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements Dao<Integer, Customer> {

    @Override
    public Customer insert(Customer customer, Connection conn) throws Exception {
        return null;
    }

    @Override
    public Customer update(Customer customer, Connection conn) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.UPDATE_CUSTOMER);
            ps.setString(1, customer.getCname());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPhone());
            ps.setString(4, customer.getNick_name());
            ps.setInt(5, customer.getCid());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return customer;
    }

    @Override
    public boolean delete(Integer i, Connection conn) throws Exception {
        boolean flag = false;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Sql.DELETE_CUSTOMER);
            ps.setInt(1, i);
            int result = ps.executeUpdate();
            if (result == 1) {
                flag = true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return flag;
    }

    @Override
    public Customer select(Integer i, Connection conn) throws Exception {
        return null;
    }

    @Override
    public List<Customer> select(Connection con) throws Exception {
        List<Customer> customers = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(Sql.SELECT_CUSTOMER_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCid(rs.getInt("cid"));
                customer.setEmail(rs.getString("email"));
                customer.setCname(rs.getString("cname"));
                customer.setPhone(rs.getString("phone"));
                customer.setBirth_date(rs.getDate("birth_date"));
                customer.setNick_name(rs.getString("nick_name"));
                customer.setGrade(rs.getInt("grade"));
                customer.setJoin_date(rs.getTimestamp("join_date"));
                customers.add(customer);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return customers;  // 리스트 반환
    }


    public List<Customer> selectByName(String name, Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Customer> customers = new ArrayList<>();
        try {
            ps = conn.prepareStatement(Sql.SELECT_CUSTOMER_BY_NAME); // SQL 쿼리에서 이름으로 찾기
            ps.setString(1, "%" + name + "%"); // 이름에 대해 부분 매칭
            rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCid(rs.getInt("cid"));
                customer.setEmail(rs.getString("email"));
                customer.setCname(rs.getString("cname"));
                customer.setPhone(rs.getString("phone"));
                customer.setBirth_date(rs.getDate("birth_date"));
                customer.setNick_name(rs.getString("nick_name"));
                customer.setGrade(rs.getInt("grade"));
                customer.setJoin_date(rs.getTimestamp("join_date"));
                customers.add(customer);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return customers;
    }

    public Customer selectByEmail(String email, Connection conn) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer customer = null;
        try {
            ps = conn.prepareStatement(Sql.SELECT_CUSTOMER_EMAIL);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                customer = new Customer();
                customer.setCid(rs.getInt("cid"));
                customer.setPwd(rs.getString("pwd"));
                customer.setCname(rs.getString("cname"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));
                customer.setBirth_date(rs.getDate("birth_date"));
                customer.setNick_name(rs.getString("nick_name"));
                customer.setGrade(rs.getInt("grade"));
                customer.setJoin_date(rs.getTimestamp("join_date"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return customer;
    }

}