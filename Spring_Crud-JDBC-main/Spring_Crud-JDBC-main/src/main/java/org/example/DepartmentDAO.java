package org.example;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DepartmentDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // insert
    public int insert(int CId, String CName, String CIName , int CFee) {
        String sql = "INSERT INTO department (CId, CName, CIName, CFee ) VALUES (?, ?, ?,?)";
        return jdbcTemplate.update(sql, CId, CName, CIName, CFee);
    }

    //  ALL
    public List<department> getAll() {
        String sql = "SELECT CId, CName, CIName, CFee  FROM department";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new department(
                        rs.getInt("CId"),
                        rs.getString("CName"),
                        rs.getString("CIName"),
                        rs.getInt("CFee")
                )
        );
    }

    // UPDATE
    public int update(int CId, String CName, String CIName , int CFee) {
        String sql =
                "UPDATE department SET CName = ?, CIName = ? , CFee = ? WHERE CId = ?";

        return jdbcTemplate.update(sql,CName, CIName, CFee, CId);
    }

    // D — DELETE
    public int delete(int CId) {
        String sql = "DELETE FROM department WHERE CId = ?";

        return jdbcTemplate.update(sql, CId);
    }

}
