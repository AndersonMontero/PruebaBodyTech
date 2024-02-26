package com.bodytech.prueba.domain.service;

import com.bodytech.prueba.domain.dto.ProductoDto;
import com.bodytech.prueba.domain.dto.request.ProductoRequest;

public interface IProductoService {
    ProductoDto getProducto(Integer productoId);

    ProductoDto deleteProducto(Integer productoId);

    ProductoDto putProducto(ProductoRequest productoRequest);

    ProductoDto postProducto(ProductoRequest productoRequest);

}
