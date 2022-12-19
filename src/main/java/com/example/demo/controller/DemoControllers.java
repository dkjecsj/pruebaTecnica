/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.mapper.*;
import com.example.demo.model.ProductoTestModel;
import com.example.demo.service.ApplicationService;
import com.example.demo.service.ApplicationVentaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author juliancastillo
 */
@Controller
public class DemoControllers {

    @Autowired
    ApplicationService applicationService;
    @Autowired
    ApplicationVentaService applicationVentaService;


    @GetMapping("/find")
    public String listar(Model model) {
        model.addAttribute("productos", applicationService.findAll());
        return "index";
    }
    @GetMapping("/new")
    public String agregar(Model model) {
        model.addAttribute("producto", new ProductoTestModel());
        return "forms";
    }
    @PostMapping("/save")
    public String save(ProductoTestModel productoTestModel, Model model) {
        applicationService.save(productoTestModel);
        return "redirect:/find";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        ProductoTestModel productoTestModelOptional =applicationService.findId(id);
        model.addAttribute("producto",productoTestModelOptional);
        return "forms";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, Model model){
       applicationService.delete(id);
        return "redirect:/find";
    }
    @GetMapping("/vender/{id}")
    public String vender(@PathVariable int id, Model model){
        ProductoTestModel productoTestModelOptional =applicationService.findId(id);
        model.addAttribute("producto",productoTestModelOptional);
        return "formsVenta";
    }
    @PostMapping("/saveVenta")
    public String saveVenta(VentasDto ventasDto, Model model) {
        if(applicationVentaService.ventas(ventasDto)){
            return "redirect:/find";
        }
        ProductoTestModel productoTestModelOptional =applicationService.findId(ventasDto.getId());
        model.addAttribute("producto",productoTestModelOptional);
        return "formsVentaError";
    }
}
