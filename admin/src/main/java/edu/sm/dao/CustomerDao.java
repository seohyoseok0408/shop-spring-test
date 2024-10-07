package edu.sm.dao;

import edu.sm.dto.Customer;
import edu.sm.frame.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements Dao<Integer, Customer> {

    private static final String INSERT_CUSTOMER = "INSERT INTO customer (cid, pwd, cname, email, phone, birth_date, nick_name, grade, join_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_CUSTOMER = "UPDATE customer SET pwd = ?, cname = ?, email = ?, phone = ?, birth_date = ?, nick_name = ?, grade = ? WHERE cid = ?";
    private static final String DELETE_CUSTOMER = "DELETE FROM customer WHERE cid = ?";
    private static final String SELECT_CUSTOMER = "SELECT * FROM customer WHERE cid = ?";
    private static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM customer";
    private static final String LOGIN_CUSTOMER = "SELECT * FROM customer WHERE email = ? AND pwd = ?";
    private static final String SELECT_BY_NAME = "SELECT * FROM customer WHERE cname LIKE ?";

    @Override
    public Customer insert(Customer customer, Connection conn) throws Exception {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_CUSTOMER)) {
            ps.setInt(1, customer.getCid());
            ps.setString(2, customer.getPwd());
            ps.setString(3, customer.getCname());
            ps.setString(4, customer.getEmail());
            ps.setString(5, customer.getPhone());
            ps.setDate(6, customer.getBirth_date());
            ps.setString(7, customer.getNick_name());
            ps.setInt(8, customer.getGrade());
            ps.setTimestamp(9, customer.getJoin_date());
            ps.executeUpdate();
            return customer;
        }
    }

    @Override
    public Customer update(Customer customer, Connection conn) throws Exception {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_CUSTOMER)) {
            ps.setString(1, customer.getPwd());
            ps.setString(2, customer.getCname());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPhone());
            ps.setDate(5, customer.getBirth_date());
            ps.setString(6, customer.getNick_name());
            ps.setInt(7, customer.getGrade());
            ps.setInt(8, customer.getCid());
            ps.executeUpdate();
            return customer;
        }
    }

    @Override
    public boolean delete(Integer cid, Connection conn) throws Exception {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_CUSTOMER)) {
            ps.setInt(1, cid);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Customer select(Integer cid, Connection conn) throws Exception {
        try (PreparedStatement ps = conn.prepareStatement(SELECT_CUSTOMER)) {
            ps.setInt(1, cid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Customer(
                            rs.getInt("cid"),
                            rs.getString("pwd"),
                            rs.getString("cname"),
                            rs.getString("email"),
                            rs.getString("phone"),
                            rs.getDate("birth_date"),
                            rs.getString("nick_name"),
                            rs.getInt("grade"),
                            rs.getTimestamp("join_date")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Customer> select(Connection conn) throws Exception {
        List<Customer> customers = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL_CUSTOMERS);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                customers.add(new Customer(
                        rs.getInt("cid"),
                        rs.getString("pwd"),
                        rs.getString("cname"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getDate("birth_date"),
                        rs.getString("nick_name"),
                        rs.getInt("grade"),
                        rs.getTimestamp("join_date")
                ));
            }
        }
        return customers;
    }

    // 로그인 기능 구현
    public Customer login(String email, String pwd, Connection conn) throws Exception {
        try (PreparedStatement ps = conn.prepareStatement(LOGIN_CUSTOMER)) {
            ps.setString(1, email);
            ps.setString(2, pwd);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Customer(
                            rs.getInt("cid"),
                            rs.getString("pwd"),
                            rs.getString("cname"),
                            rs.getString("email"),
                            rs.getString("phone"),
                            rs.getDate("birth_date"),
                            rs.getString("nick_name"),
                            rs.getInt("grade"),
                            rs.getTimestamp("join_date")
                    );
                }
            }
        }
        return null;
    }

    // 이름으로 고객 검색 기능 구현
    public List<Customer> getByName(String cname, Connection conn) throws Exception {
        List<Customer> customers = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_NAME)) {
            ps.setString(1, "%" + cname + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    customers.add(new Customer(
                            rs.getInt("cid"),
                            rs.getString("pwd"),
                            rs.getString("cname"),
                            rs.getString("email"),
                            rs.getString("phone"),
                            rs.getDate("birth_date"),
                            rs.getString("nick_name"),
                            rs.getInt("grade"),
                            rs.getTimestamp("join_date")
                    ));
                }
            }
        }
        return customers;
    }
}
