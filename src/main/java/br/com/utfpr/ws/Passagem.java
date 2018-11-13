package br.com.utfpr.ws;


import java.io.Serializable;

public class Passagem implements Serializable {
	
	private static final long serialVersionUID = 355205998811598069L;

	private int tipo;
	private String origem;
	private String destino;
	private String dataIda;
	private String dataVolta;
	private int numeroPessoas;
	private int preco;
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getDataIda() {
		return dataIda;
	}
	public void setDataIda(String dataIda) {
		this.dataIda = dataIda;
	}
	public String getDataVolta() {
		return dataVolta;
	}
	public void setDataVolta(String dataVolta) {
		this.dataVolta = dataVolta;
	}
	public int getNumeroPessoas() {
		return numeroPessoas;
	}
	public void setNumeroPessoas(int numeroPessoas) {
		this.numeroPessoas = numeroPessoas;
	}
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataIda == null) ? 0 : dataIda.hashCode());
		result = prime * result + ((dataVolta == null) ? 0 : dataVolta.hashCode());
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + numeroPessoas;
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		result = prime * result + tipo;
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
		Passagem other = (Passagem) obj;
		if (dataIda == null) {
			if (other.dataIda != null)
				return false;
		} else if (!dataIda.equals(other.dataIda))
			return false;
		if (dataVolta == null) {
			if (other.dataVolta != null)
				return false;
		} else if (!dataVolta.equals(other.dataVolta))
			return false;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (numeroPessoas != other.numeroPessoas)
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
	
	
}
