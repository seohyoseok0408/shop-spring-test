package edu.sm.service;

import edu.sm.dao.CustomerDao;
import edu.sm.dto.Customer;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.util.List;

public class CustomerService implements MService<Integer, Customer> {

    private CustomerDao dao;
    private ConnectionPool cp;

    public void setDao(CustomerDao dao) {
        this.dao = dao;
    }

    public void setCp(ConnectionPool cp) {
        this.cp = cp;
    }

    @Override
    public Customer add(Customer customer) throws Exception {
        Connection conn = cp.getConnection();
        try {
            conn.setAutoCommit(false);
            dao.insert(customer, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return customer;
    }

    @Override
    public Customer modify(Customer customer) throws Exception {
        Connection conn = cp.getConnection();
        try {
            dao.update(customer, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return customer;
    }

    @Override
    public Boolean remove(Integer cid) throws Exception {
        Connection conn = cp.getConnection();
        boolean result;
        try {
            result = dao.delete(cid, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return result;
    }

    @Override
    public Customer get(Integer cid) throws Exception {
        Connection conn = cp.getConnection();
        Customer customer = null;
        try {
            customer = dao.select(cid, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return customer;
    }

    @Override
    public List<Customer> get() throws Exception {
        Connection conn = cp.getConnection();
        List<Customer> customers = null;
        try {
            customers = dao.select(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return customers;
    }

    // 이름으로 고객 검색 메서드 추가
    public List<Customer> getByName(String cname) throws Exception {
        Connection conn = cp.getConnection();
        List<Customer> customers = null;
        try {
            customers = dao.selectByName(cname, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return customers;
    }
}
