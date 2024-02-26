package com.bodytech.prueba.domain.service.impl;

import com.bodytech.prueba.domain.dto.ProductoDto;
import com.bodytech.prueba.domain.dto.request.ProductoRequest;
import com.bodytech.prueba.domain.exception.HttpGenericException;
import com.bodytech.prueba.domain.repository.IProductoRepository;
import com.bodytech.prueba.domain.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository iProductoRepository;

    @Override
    public ProductoDto getProducto(Integer productoId) throws HttpGenericException {
        boolean existsId = iProductoRepository.existsById(productoId);
        if ( existsId ) throw new HttpGenericException(HttpStatus.NOT_FOUND,"No existe este número de producto.");
        return iProductoRepository.findById(productoId);
    }

    @Override
    public ProductoDto deleteProducto(Integer productoId) throws HttpGenericException {
        boolean existsId = iProductoRepository.existsById(productoId);
        ProductoDto validaData = iProductoRepository.findById(productoId);
        if ( existsId ) throw new HttpGenericException(HttpStatus.NOT_FOUND,"No existe este número de producto.");
        if ( validaData.getEstado().equals(2) ) throw new HttpGenericException(HttpStatus.NOT_FOUND,"Ya esta borrado el producto.");
        return iProductoRepository.deleteProducto(productoId, 2);
    }

    @Override
    public ProductoDto putProducto(ProductoRequest productoRequest) throws HttpGenericException {
        return null;
    }

    @Override
    public ProductoDto postProducto(ProductoRequest productoRequest) throws HttpGenericException {
        return null;
    }

}
