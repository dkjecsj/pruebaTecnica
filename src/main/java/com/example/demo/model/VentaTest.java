/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import java.io.Serializable;
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
@Table(name = "VentaTest")
public class VentaTest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ProductoTestId")
    @Basic(optional = false)
    private int productoTestId;
    @Column(name = "NombreProducto")
    @Basic(optional = false)
    private String nombreProducto;


    public VentaTest() {
    }

    public VentaTest(int id, int productoTestId, String nombreProducto) {
        super();
        this.id = id;
        this.productoTestId = productoTestId;
        this.nombreProducto = nombreProducto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductoTestId() {
        return productoTestId;
    }

    public void setProductoTestId(int productoTestId) {
        this.productoTestId = productoTestId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
