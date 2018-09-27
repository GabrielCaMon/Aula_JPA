import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.ArrayList;
import java.util.List;



import javax.persistence.*;

@Entity

public class Fabricante {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String sede;
	
	// CascadeType pode ser CascadeType.ALL (cascade de tudo)
	//eager traz tudo de uma vez
	@OneToMany(mappedBy="fabricante", cascade={CascadeType.PERSIST, CascadeType.REMOVE},fetch=FetchType.EAGER)// se não colocar fetch por padrão, fica lazy
	private List<Produto> produto = new ArrayList<>();
	

	public Fabricante(){
		
			}
	
	public Fabricante(Integer id, String nome, String sede) {
		this();
		this.id = id;
		this.nome = nome;
		this.sede = sede;
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

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}
	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	
	
}
