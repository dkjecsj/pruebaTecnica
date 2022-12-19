/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.interfaces.IProducto;
import com.example.demo.interfaces.IVenta;
import com.example.demo.mapper.*;
import com.example.demo.model.ProductoTestModel;
import com.example.demo.model.VentaTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author juliancastillo
 */
@Service
public class ApplicationVentaService {

    @Autowired
    private IProducto iAsignation;

    @Autowired
    private IVenta iVenta;


    public Boolean venta(VentaDto ventaDto) {
        Map<String, Object> responses = new HashMap<>();
        Optional<ProductoTestModel> productoTestModel = iAsignation.findById(ventaDto.getId());
       int stock= productoTestModel.get().getStock();

       if((stock-ventaDto.getStock())<0){
           return false;
       }
        stock=stock-ventaDto.getStock();
        productoTestModel.get().setStock(stock);
        iAsignation.save(productoTestModel.get());
        VentaTest ventaTest = new VentaTest();
        ventaTest.setProductoTestId(productoTestModel.get().getId());
        ventaTest.setNombreProducto(productoTestModel.get().getNombreProducto());
        iVenta.save(ventaTest);
        responses.put("Creacion Correcta", ventaTest);
        return true;
    }
    public Boolean ventas(VentasDto ventaDto) {
        Optional<ProductoTestModel> productoTestModel = iAsignation.findById(ventaDto.getId());
        int stock= productoTestModel.get().getStock();

        if((stock-ventaDto.getStock())<0){
            return false;
        }
        stock=stock-ventaDto.getStock();
        productoTestModel.get().setStock(stock);
        iAsignation.save(productoTestModel.get());
        VentaTest ventaTest = new VentaTest();
        ventaTest.setProductoTestId(productoTestModel.get().getId());
        ventaTest.setNombreProducto(productoTestModel.get().getNombreProducto());
        iVenta.save(ventaTest);
        return true;
    }
}
