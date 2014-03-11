package curso.dao;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import dto.UsuarioInformeDTO;

@Component
public class UsuarioJDBCDAO {

	@Autowired
	private DataSource dataSource;

	private NamedParameterJdbcTemplate nameJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.nameJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<UsuarioInformeDTO> buscarPersonalizado() {
		String sql = "select u.nombre, c.nombre as nomCiudad, u.edad from usuario u, ciudad c where u.ciudad_nacimiento = c.id";
		return nameJdbcTemplate.query(sql,
				new BeanPropertyRowMapper<UsuarioInformeDTO>(
						UsuarioInformeDTO.class));
	}

	public void llamarSP() {
		try {
			String getDBUSERByUserIdSql = "{call getDBUSERByUserId(?,?,?,?)}";
			CallableStatement callableStatement = dataSource.getConnection()
					.prepareCall(getDBUSERByUserIdSql);
			callableStatement.setInt(1, 10);
			
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(4, java.sql.Types.DATE);

			// execute getDBUSERByUserId store procedure
			callableStatement.executeUpdate();

			String userName = callableStatement.getString(2);
			String createdBy = callableStatement.getString(3);
			Date createdDate = callableStatement.getDate(4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
