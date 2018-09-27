import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="TB_PROD")
public class Produto {
	public static enum Categoria{
		Eletronico, Alimento, Vestuario, Transporte
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	//nullable = "not null"
	//unique = "não se repetir"
	@Column(name="nm_prod", nullable = false, unique = true)
	private String nome;
	
	private Double preco;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCriacao;
	
	
	@Enumerated(EnumType.ORDINAL)
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="fabricante_id", referencedColumnName="id")
	private Fabricante fabricante;
	
	public Produto() {
		dataCriacao = new GregorianCalendar();
		categoria = Categoria.Eletronico;
	}

	public Produto(Integer id, String nome, Double preco) {
		this();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}


	
	
	
}
