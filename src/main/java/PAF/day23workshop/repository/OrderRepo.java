package PAF.day23workshop.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import PAF.day23workshop.model.Order;


@Repository
public class OrderRepo {

    // First thing import your JDBC
    @Autowired
    JdbcTemplate jdbcTemplate;

    // Secondly you form the query 
    private final static String FIND_ORDERBYID_SQL = "SELECT o.id AS order_id, o.order_date, o.customer_id, od.product_id, (od.quantity * od.unit_price * if(od.discount > 0, od.discount, 1)) AS total_price, (od.quantity * p.standard_cost) AS cost_price "
    + " FROM order_details AS od "
    + " INNER JOIN products AS p "
    + " on od.product_id = p.id "
    + " INNER JOIN orders as o "
    + " ON o.id = od.order_id "
    + " WHERE o.id=?";

    public List<Order> findQrderById(Integer id) {
        return jdbcTemplate.query(FIND_ORDERBYID_SQL, BeanPropertyRowMapper.newInstance(Order.class), id);
    }






}
