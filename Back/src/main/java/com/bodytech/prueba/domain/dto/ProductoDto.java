package com.bodytech.prueba.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDto {

    private Integer id;

    private String nombre;

    private String descripcion;

    private Integer precio;

    private Integer estado;

}
