package com.example.demo;

import com.example.demo.interfaces.IProducto;
import com.example.demo.model.ProductoTestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Autowired
	private IProducto iAsignation;

	@Override
	public void run(String ... args)throws Exception{
		ProductoTestModel productoTestModel=new ProductoTestModel();
		productoTestModel.setNombreProducto("semillas");
		productoTestModel.setCategoria("grano");
		productoTestModel.setPrecio(200);
		productoTestModel.setPeso(100);
		productoTestModel.setStock(15);
		Date fecha = new Date();
		productoTestModel.setFechaCreacion(fecha);
		iAsignation.save(productoTestModel);
	}
}
