package com.financial.payroll.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Setter
    @Column(name = "middle_name")
    private String middleName;

    @Getter
    @Setter
    @Column(name = "last_name")
    private String lastName;

    @Getter
    @Setter
    @Column(name = "position_title")
    private String positionTitle;

    @Getter
    @Setter
    @Column(name = "status")
    private boolean status;

    @Getter
    @Setter
    @Column(name = "location_city")
    private String locationCity;

    @Getter
    @Setter
    @Column(name = "address")
    private String address;

    @Getter
    @Setter
    @Column(name = "date_birth")
    private Date dateBirth;

    @Getter
    @Setter
    @Column(name = "telephone")
    private String telephone;

    @Getter
    @Setter
    @Column(name = "hire_date")
    private Date hireDate;

    @Getter
    @Setter
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @Column(name = "salary")
    private BigDecimal salary;

    @Getter
    @Setter
    @Column(name = "time_position")
    private String timePosition;

}
