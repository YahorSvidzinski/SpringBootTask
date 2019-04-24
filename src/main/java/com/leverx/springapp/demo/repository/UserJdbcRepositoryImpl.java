package com.leverx.springapp.demo.repository;

import com.leverx.springapp.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserJdbcRepositoryImpl implements CommonUserRepository {

    public static final String SELECT_ID_FROM_USERS_ORDER_BY_ID_DESC_LIMIT_1 = "SELECT id FROM users ORDER BY id DESC LIMIT 1";
    public static final String INSERT_INTO_USERS_FIRST_NAME_SECOND_NAME_VALUES = "INSERT INTO users (first_name, second_name) values (?,?)";
    public static final String SELECT_ID_FIRST_NAME_SECOND_NAME_FROM_USERS_WHERE_ID = "SELECT id, first_name, second_name FROM users WHERE id = ?";
    private final JdbcTemplate jdbcTemplate;

    @Override
    public User save(User user) {
        String sql = INSERT_INTO_USERS_FIRST_NAME_SECOND_NAME_VALUES;
        jdbcTemplate.update(sql, user.getFirstName(), user.getSecondName());
        sql = SELECT_ID_FROM_USERS_ORDER_BY_ID_DESC_LIMIT_1;
        Long id = jdbcTemplate.queryForObject(sql, Long.class);
        user.setId(id);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        String sql = SELECT_ID_FIRST_NAME_SECOND_NAME_FROM_USERS_WHERE_ID;
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT id, first_name, second_name FROM users";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        return this.jdbcTemplate.query(sql, rowMapper);
    }
}
