/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.mapper.CreateDto;
import com.example.demo.mapper.DeleteDto;
import com.example.demo.mapper.UpdateDto;
import com.example.demo.mapper.VentaDto;
import com.example.demo.model.ProductoTestModel;
import com.example.demo.service.ApplicationService;
import com.example.demo.service.ApplicationVentaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juliancastillo
 */
@RestController
public class DemoController {

    @Autowired
    ApplicationService applicationService;
    @Autowired
    ApplicationVentaService applicationVentaService;

    @GetMapping("/hello")
    public String hello() {
        return String.format("Hello world!");
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createTest(@RequestBody CreateDto createDto) throws JsonProcessingException {
        Map<String, Object> responses = new HashMap<>();
        Map<String, Object> error = new HashMap<>();
        try {
            return new ResponseEntity(applicationService.create(createDto), HttpStatus.OK);

        } catch (Throwable ex) {
            error.put("mensajeError", ex.getMessage());
            responses.put("status", false);
            responses.put("body", "");
            responses.put("error", error);
            return new ResponseEntity(responses, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> updateTest(@RequestBody UpdateDto updateDto) throws JsonProcessingException {
        Map<String, Object> responses = new HashMap<>();
        Map<String, Object> error = new HashMap<>();
        try {
            return new ResponseEntity(applicationService.update(updateDto), HttpStatus.OK);

        } catch (Throwable ex) {
            error.put("mensajeError", ex.getMessage());
            responses.put("status", false);
            responses.put("body", "");
            responses.put("error", error);
            return new ResponseEntity(responses, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<Map<String, Object>> deleteTest(@RequestBody DeleteDto deleteDto) throws JsonProcessingException {
        Map<String, Object> responses = new HashMap<>();
        Map<String, Object> error = new HashMap<>();
        try {
            return new ResponseEntity(applicationService.delete(deleteDto), HttpStatus.OK);

        } catch (Throwable ex) {
            error.put("mensajeError", ex.getMessage());
            responses.put("status", false);
            responses.put("body", "");
            responses.put("error", error);
            return new ResponseEntity(responses, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findAll")
    public ResponseEntity<Map<String, Object>> findTest() throws JsonProcessingException {
        Map<String, Object> responses = new HashMap<>();
        Map<String, Object> error = new HashMap<>();
        try {
            return new ResponseEntity(applicationService.find(), HttpStatus.OK);

        } catch (Throwable ex) {
            error.put("mensajeError", ex.getMessage());
            responses.put("status", false);
            responses.put("body", "");
            responses.put("error", error);
            return new ResponseEntity(responses, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/ventaTest")
    public ResponseEntity<Map<String, Object>> ventaTest(@RequestBody VentaDto ventaDto) throws JsonProcessingException {
        Map<String, Object> responses = new HashMap<>();
        Map<String, Object> error = new HashMap<>();
        try {

            if(applicationVentaService.venta(ventaDto)){
       return new ResponseEntity(true, HttpStatus.OK);
            }else{
                return new ResponseEntity("No es posible realizar venta", HttpStatus.OK);

            }
        } catch (Throwable ex) {
            error.put("mensajeError", ex.getMessage());
            responses.put("status", false);
            responses.put("body", "");
            responses.put("error", error);
            return new ResponseEntity(responses, HttpStatus.NOT_FOUND);
        }
    }


}
