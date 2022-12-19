/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author juliancastillo
 */
@Entity
@Table(name = "ProductoTest")
public class ProductoTestModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "NombreProducto")
    @Basic(optional = false)
    private String nombreProducto;
    @Column(name = "Precio")
    @Basic(optional = false)
    private int precio;
    @Column(name = "Peso")
    @Basic(optional = false)
    private int peso;
    @Column(name = "Categoria")
    @Basic(optional = false)
    private String categoria;
    @Column(name = "Stock")
    @Basic(optional = false)
    private int stock;

    @Column(name = "FechaCreacion")
    @Basic(optional = false)
    private Date fechaCreacion;

    public ProductoTestModel() {
    }

    public ProductoTestModel(int id, String nombreProducto, int precio, int peso, String categoria, int stock, Date fechaCreacion) {
        super();
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.peso = peso;
        this.categoria = categoria;
        this.stock = stock;
        this.fechaCreacion = fechaCreacion;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
