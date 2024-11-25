package com.financial.payroll.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ErrorDTO {

    @Getter
    @Setter
    private String descripcion;

    @Getter
    @Setter
    private List<String> reasons;
    public ErrorDTO(String descripcion, String description, List<String> reasons){
        this.descripcion = descripcion;
        this.reasons = reasons;
    }
}
