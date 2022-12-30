package com.invoke.proc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void criarProcH2() {
		StringBuilder consulta = new StringBuilder();
		consulta.append("CREATE ALIAS consulta AS $$")
			.append(" ResultSet query(Connection conn, Integer codigo) throws SQLException {")
			.append(" String sql = \"SELECT * FROM produtos WHERE codigo =\"+ codigo ;")
			.append(" return conn.createStatement().executeQuery(sql);")
			.append(" } $$;");
		try {
			jdbcTemplate.execute(consulta.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		StringBuilder consultaTodos = new StringBuilder();
		consultaTodos.append("CREATE ALIAS consultaTodos AS $$")
			.append(" ResultSet query(Connection conn) throws SQLException {")
			.append(" String sql = \"SELECT * FROM produtos\";")
			.append(" return conn.createStatement().executeQuery(sql);")
			.append(" } $$;");
		try {
			jdbcTemplate.execute(consultaTodos.toString());
		} catch (Exception e) {
			System.out.println(e);
		}		
		
	}
}
