
package org.example;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDao {

    private JdbcTemplate jdbcTemplate;


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // insert
    public int insert(int StdId, String StdName, String StdAddress , String number , String Department) {
        String sql = "INSERT INTO student (StdId, StdName, StdAddress, number , Department) VALUES (?, ?, ?,?,?)";
        return jdbcTemplate.update(sql, StdId, StdName, StdAddress,number,Department);
    }

    //  ALL
    public List<Student> getAll() {
        String sql = "SELECT StdId, StdName, StdAddress, number , Department FROM student";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Student(
                        rs.getInt("StdId"),
                        rs.getString("StdName"),
                        rs.getString("StdAddress"),
                        rs.getString("number"),
                        rs.getString("Department")
                )
        );
    }


    //READ ONE BY ID
    public Student findById(int StdId) {
        String sql = "SELECT StdId, StdName, StdAddress, number, Department " +
                "FROM student WHERE StdId = ?";

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                        new Student(
                                rs.getInt("StdId"),
                                rs.getString("StdName"),
                                rs.getString("StdAddress"),
                                rs.getString("number"),
                                rs.getString("Department")
                        ),
                StdId
        );
    }


    // U — UPDATE
    public int update(int StdId, String StdName, String StdAddress , String number , String Department) {
        String sql =
                "UPDATE student SET StdName = ?, StdAddress = ? , number = ? , Department = ? WHERE id = ?";

        return jdbcTemplate.update(sql, StdName, StdAddress,number,Department, StdId);
    }

    // D — DELETE
    public int delete(int StdId) {
        String sql = "DELETE FROM student WHERE StdId = ?";

        return jdbcTemplate.update(sql, StdId);
    }


}
