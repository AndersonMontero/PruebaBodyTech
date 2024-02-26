package com.bodytech.prueba.web.controller;

import com.bodytech.prueba.domain.dto.ProductoDto;
import com.bodytech.prueba.domain.dto.request.ProductoRequest;
import com.bodytech.prueba.domain.exception.HttpGenericException;
import com.bodytech.prueba.domain.service.IProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/API/producto/")
public class ProductoCotroller {

    @Autowired
    private IProductoService iProductoService;

    @PostMapping("crear")
    public ResponseEntity<ProductoDto> postProducto(@RequestBody @Valid ProductoRequest productoRequest) {
        try {
            ProductoDto response = iProductoService.postProducto(productoRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (HttpGenericException e){
            throw e;
        }
    }

    @PutMapping("actualizar")
    public ResponseEntity<ProductoDto> putProducto(@RequestBody @Valid ProductoRequest productoRequest) {
        try {
            ProductoDto response = iProductoService.putProducto(productoRequest);
            return ResponseEntity.ok(response);
        } catch (HttpGenericException e){
            throw e;
        }
    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity<ProductoDto> deleteProducto(@PathVariable Integer productoId) {
        try {
            if (productoId == null) {
                throw new HttpGenericException(HttpStatus.LENGTH_REQUIRED, "Por favor ingrese un numero de producto válido.");
            }
            ProductoDto response = iProductoService.deleteProducto(productoId);
            return ResponseEntity.ok(response);
        }catch (HttpGenericException e){
            throw e;
        }
    }

    @GetMapping("/{productoId}")
    public ResponseEntity<ProductoDto> getProducto(@PathVariable Integer productoId) {
        try {
            if (productoId == null ) {
                throw new HttpGenericException(HttpStatus.LENGTH_REQUIRED, "Por favor ingrese un numero de producto válido.");
            }
            ProductoDto response = iProductoService.getProducto(productoId);
            return ResponseEntity.ok(response);
        } catch (HttpGenericException e){
            throw e;
        }
    }

}
