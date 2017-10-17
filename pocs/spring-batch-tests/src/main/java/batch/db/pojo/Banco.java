package batch.db.pojo;

import java.sql.Timestamp;

public class Banco {
	
	private Integer cdBanco;
	private String nmBanco;
	private String nmRazaoSocial;
	
	private Timestamp dtUltAlteracao;
	private String usuarioUltAlteracao;
	
	public Banco() {}

	public Integer getCdBanco() {
		return cdBanco;
	}

	public void setCdBanco(Integer cdBanco) {
		this.cdBanco = cdBanco;
	}

	public String getNmBanco() {
		return nmBanco;
	}

	public void setNmBanco(String nmBanco) {
		this.nmBanco = nmBanco;
	}

	public String getNmRazaoSocial() {
		return nmRazaoSocial;
	}

	public void setNmRazaoSocial(String nmRazaoSocial) {
		this.nmRazaoSocial = nmRazaoSocial;
	}

	public Timestamp getDtUltAlteracao() {
		return dtUltAlteracao;
	}

	public void setDtUltAlteracao(Timestamp dtUltAlteracao) {
		this.dtUltAlteracao = dtUltAlteracao;
	}

	public String getUsuarioUltAlteracao() {
		return usuarioUltAlteracao;
	}

	public void setUsuarioUltAlteracao(String usuarioUltAlteracao) {
		this.usuarioUltAlteracao = usuarioUltAlteracao;
	}	
	
	@Override
	public String toString() {
		return "Banco: " + cdBanco + ", nmBanco: " + nmBanco + ", nmRazaoSocial: " + nmRazaoSocial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdBanco == null) ? 0 : cdBanco.hashCode());
		result = prime * result
				+ ((dtUltAlteracao == null) ? 0 : dtUltAlteracao.hashCode());
		result = prime * result + ((nmBanco == null) ? 0 : nmBanco.hashCode());
		result = prime * result
				+ ((nmRazaoSocial == null) ? 0 : nmRazaoSocial.hashCode());
		result = prime
				* result
				+ ((usuarioUltAlteracao == null) ? 0 : usuarioUltAlteracao
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banco other = (Banco) obj;
		if (cdBanco == null) {
			if (other.cdBanco != null)
				return false;
		} else if (!cdBanco.equals(other.cdBanco))
			return false;
		if (dtUltAlteracao == null) {
			if (other.dtUltAlteracao != null)
				return false;
		} else if (!dtUltAlteracao.equals(other.dtUltAlteracao))
			return false;
		if (nmBanco == null) {
			if (other.nmBanco != null)
				return false;
		} else if (!nmBanco.equals(other.nmBanco))
			return false;
		if (nmRazaoSocial == null) {
			if (other.nmRazaoSocial != null)
				return false;
		} else if (!nmRazaoSocial.equals(other.nmRazaoSocial))
			return false;
		if (usuarioUltAlteracao == null) {
			if (other.usuarioUltAlteracao != null)
				return false;
		} else if (!usuarioUltAlteracao.equals(other.usuarioUltAlteracao))
			return false;
		return true;
	}	
	
}
