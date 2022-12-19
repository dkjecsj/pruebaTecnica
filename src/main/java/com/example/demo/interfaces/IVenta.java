/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.interfaces;

import com.example.demo.model.VentaTest;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author juliancastillo
 */
@Repository
public interface IVenta extends CrudRepository<VentaTest, Integer>{
    
    List<VentaTest> findAll();
}
