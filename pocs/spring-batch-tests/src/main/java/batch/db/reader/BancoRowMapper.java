package batch.db.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import batch.db.pojo.Banco;

public class BancoRowMapper implements RowMapper{

	public Object mapRow(ResultSet rs, int idx) throws SQLException {
		Banco banco = new Banco();
		banco.setCdBanco(rs.getInt("cdbanco"));
		banco.setNmBanco(rs.getString("nmbanco"));
		banco.setNmRazaoSocial(rs.getString("nmrazaosocial"));
		banco.setUsuarioUltAlteracao(rs.getString("usuario_ult_alteracao"));
		banco.setDtUltAlteracao(rs.getTimestamp("data_ult_alteracao"));
		return banco;
	}
	
}
