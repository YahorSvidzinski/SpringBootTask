package com.leverx.springapp.demo.repository;

import com.leverx.springapp.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserJdbcRepositoryImpl implements UserJdbcRepository {

    public static final String INSERT_USER = "INSERT INTO users (first_name, second_name) values (?,?)";
    public static final String GET_USER_BY_ID = "SELECT id, first_name, second_name FROM users WHERE id = ?";
    public static final String GET_USERS = "SELECT id, first_name, second_name FROM users";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public User save(User user) {
        var keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_USER, new String[]{"id"});
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getSecondName());
            return ps;
        }, keyHolder);
        user.setId((Long) keyHolder.getKey());
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        var rowMapper = new BeanPropertyRowMapper<User>(User.class);
        var user = jdbcTemplate.queryForObject(GET_USER_BY_ID, rowMapper, id);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll() {
        var rowMapper = new BeanPropertyRowMapper<User>(User.class);
        return jdbcTemplate.query(GET_USERS, rowMapper);
    }
}
