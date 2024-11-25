package com.financial.payroll.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class EmployeeResponseDetailDTO {

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String middleName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String positionTitle;

    @Getter
    @Setter
    private boolean status;

    @Getter
    @Setter
    private String locationCity;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private Date dateBirth;

    @Getter
    @Setter
    private String telephone;

    @Getter
    @Setter
    private Date hireDate;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private BigDecimal salary;

    @Getter
    @Setter
    private String timePosition;
}
