package br.com.utfpr.ws;


import java.io.Serializable;

public class Pacote implements Serializable {

	
	private static final long serialVersionUID = 6013111924231293273L;
	
	private Passagem passagem;
	private Hospedagem hospedagem;
	public Passagem getPassagem() {
		return passagem;
	}
	public void setPassagem(Passagem passagem) {
		this.passagem = passagem;
	}
	public Hospedagem getHospedagem() {
		return hospedagem;
	}
	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hospedagem == null) ? 0 : hospedagem.hashCode());
		result = prime * result + ((passagem == null) ? 0 : passagem.hashCode());
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
		Pacote other = (Pacote) obj;
		if (hospedagem == null) {
			if (other.hospedagem != null)
				return false;
		} else if (!hospedagem.equals(other.hospedagem))
			return false;
		if (passagem == null) {
			if (other.passagem != null)
				return false;
		} else if (!passagem.equals(other.passagem))
			return false;
		return true;
	}
}
