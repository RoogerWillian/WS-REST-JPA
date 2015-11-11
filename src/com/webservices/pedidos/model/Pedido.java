package com.webservices.pedidos.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private Double vlt_total;

	private Date data_atual;

	@ManyToMany
	@JoinTable(	name = "pedido_produtos", 
				joinColumns = @JoinColumn(name = "prod_codigo"), 
				inverseJoinColumns = @JoinColumn(name = "ped_codigo") )
	private List<Produto> produtos;

	@ManyToOne
	@JoinColumn(name = "mesa_cod")
	private Mesa mesa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getVlt_total() {
		return vlt_total;
	}

	public void setVlt_total(Double vlt_total) {
		this.vlt_total = vlt_total;
	}

	public Date getData_atual() {
		return data_atual;
	}

	public void setData_atual(Date data_atual) {
		this.data_atual = data_atual;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Pedido other = (Pedido) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
