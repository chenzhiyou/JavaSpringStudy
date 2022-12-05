package spring_transaction.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import spring_transaction.dao.IFruitsDao;
import spring_transaction.entity.Fruits;

@Repository
public class FruitsDaoImpl implements IFruitsDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DruidDataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Fruits getFruits(){
        Fruits fruits = jdbcTemplate.queryForObject(
                "select * from fruits where fid=3",
                new BeanPropertyRowMapper<>(Fruits.class));
        return fruits;
    }

    @Override
    public void sub() {
        jdbcTemplate.update(
                "update fruits set inum=imum-3 where fid=3"
        );

    }

    @Override
    public void save() {
        jdbcTemplate.update(
                "update fruits set inum=imum+3 where fid=4"
        );
    }
}
