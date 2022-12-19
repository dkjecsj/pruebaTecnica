/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.interfaces.IProducto;
import com.example.demo.interfaces.IVenta;
import com.example.demo.mapper.CreateDto;
import com.example.demo.mapper.DeleteDto;
import com.example.demo.mapper.UpdateDto;
import com.example.demo.model.ProductoTestModel;
import com.example.demo.model.VentaTest;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author juliancastillo
 */
@Service
public class ApplicationService {

    @Autowired
    private IProducto iAsignation;

    public Object create(CreateDto createDto) {
        Map<String, Object> responses = new HashMap<>();
        ProductoTestModel productoTestModel = new ProductoTestModel();
        productoTestModel.setNombreProducto(createDto.getNombreProducto());
        productoTestModel.setCategoria(createDto.getCategoria());
        productoTestModel.setPrecio(createDto.getPrecio());
        productoTestModel.setPeso(createDto.getPeso());
        productoTestModel.setStock(createDto.getStock());
   Date fecha = new Date();
        productoTestModel.setFechaCreacion(fecha);
        iAsignation.save(productoTestModel);
        responses.put("Creacion Correcta", productoTestModel);
        return responses;
    }
    public Object update(UpdateDto updateDto) {
        Map<String, Object> responses = new HashMap<>();
        Optional<ProductoTestModel> productoTestModel = iAsignation.findById(updateDto.getId());
        productoTestModel.get().setNombreProducto(updateDto.getNombreProducto());
        productoTestModel.get().setCategoria(updateDto.getCategoria());
        productoTestModel.get().setPrecio(updateDto.getPrecio());
        productoTestModel.get().setPeso(updateDto.getPeso());
        productoTestModel.get().setStock(updateDto.getStock());
        Date fecha = new Date();
        productoTestModel.get().setFechaCreacion(fecha);
        iAsignation.save(productoTestModel.get());
        responses.put("Modificacion Correcta", productoTestModel);
        return responses;
    }
    public Object delete(DeleteDto deleteDto) {
        Map<String, Object> responses = new HashMap<>();
         iAsignation.deleteById(deleteDto.getId());
        responses.put("Eliminacion Correcta", "OK");
        return responses;
    }
    public Object find() {
        Map<String, Object> responses = new HashMap<>();
        Iterable<ProductoTestModel> productoTestModel =   iAsignation.findAll();
        responses.put("Lista Correcta", productoTestModel);
        return responses;
    }
    public List<ProductoTestModel> findAll() {
       return iAsignation.findAll();

    }
    public void save(ProductoTestModel createDto) {
        ProductoTestModel productoTestModel = new ProductoTestModel();
        productoTestModel.setId(createDto.getId());
        productoTestModel.setNombreProducto(createDto.getNombreProducto());
        productoTestModel.setCategoria(createDto.getCategoria());
        productoTestModel.setPrecio(createDto.getPrecio());
        productoTestModel.setPeso(createDto.getPeso());
        productoTestModel.setStock(createDto.getStock());
        Date fecha = new Date();
        productoTestModel.setFechaCreacion(fecha);
        iAsignation.save(productoTestModel);

    }
    public ProductoTestModel findId(int id) {
        Optional<ProductoTestModel> productoTestModel = iAsignation.findById(id);
        return productoTestModel.get();
    }
    public void delete(int id) {
        iAsignation.deleteById(id);
    }
}
