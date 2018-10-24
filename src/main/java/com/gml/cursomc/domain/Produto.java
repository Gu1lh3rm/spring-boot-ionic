package com.gml.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Produto implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double preco;

    private String imgUrl;
    private String imgSmallUrl;


    @JsonManagedReference
    @OneToMany(mappedBy = "produto")
    private List<ProdutoFile> file = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "PRODUTO_CATEGORIA",
        joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itens = new HashSet<>();

    @JsonIgnore
    public List<Pedido> getPedidos() {
        List<Pedido> lista = new ArrayList<>();
        for (ItemPedido x : itens){
            lista.add(x.getPedido());
        }
        return lista;
    }




    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }


    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Produto() {
    }

    public Produto(Integer id, String nome, Double preco, String imgUrl, String imgSmallUrl) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.imgUrl = imgUrl;
        this.imgSmallUrl = imgSmallUrl;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgSmallUrl() {
        return imgSmallUrl;
    }

    public void setImgSmallUrl(String imgSmallUrl) {
        this.imgSmallUrl = imgSmallUrl;
    }

    public List<ProdutoFile> getProdutoFiles() {
        return file;
    }

    public void setProdutoFiles(List<ProdutoFile> file) {
        this.file = file;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Produto{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", preco=").append(preco);
        sb.append(", imgUrl='").append(imgUrl).append('\'');
        sb.append(", imgSmallUrl='").append(imgSmallUrl).append('\'');
        sb.append(", file=").append(file);
        sb.append(", categorias=").append(categorias);
        sb.append(", itens=").append(itens);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(getId(), produto.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
