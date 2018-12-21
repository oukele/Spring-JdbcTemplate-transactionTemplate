package com.oukele.jdbcTemplate;

import com.oukele.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    @Autowired
    private JdbcOperations jdbcOperations;
    @Autowired
    private TransactionTemplate transactionTemplate;


    public List<Map<String, Object>> getToList () {
        List<Map<String, Object>> maps = jdbcOperations.queryForList("select * from user");
        return maps;
    }

    public Map<String, Object> getToMap () {
        String sql = "select * from user where userName = ?";
        Map<String, Object> ret = jdbcOperations.queryForMap(sql, "oukele1");
        return ret;
    }

    public User getToUser () {
        String sql = "select * from user where userName = 'oukele'";

        User user = jdbcOperations.queryForObject(
                sql,
                (rs, rowNum) -> new User(rs.getString(1),rs.getString(2))
        );
        return user;
    }

    public int create(String userName, String password) {

        transactionTemplate.execute(status ->{
            String sql = "insert into user (userName, password) values (?, ?)";
            String sq2 = "insert into user (userName, passord) values ('JavaScript', '2134')";
            jdbcOperations.update(sq2,userName,password);
            return jdbcOperations.update(sql, userName, password);
        });
        return 0;
    }





}
