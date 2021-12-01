package com.example.market.persistence.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Categoria {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_categoria")
    private Integer idCCategoria;

    private String descripcion;
    private boolean estado;


    @OneToMany (mappedBy = "categoria")
    private List<Producto> productos;

    public Integer getIdCCategoria() {
        return idCCategoria;
    }

    public void setIdCCategoria(Integer idCCategoria) {
        this.idCCategoria = idCCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
