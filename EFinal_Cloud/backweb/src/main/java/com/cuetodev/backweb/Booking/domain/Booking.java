package com.cuetodev.backweb.Booking.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @NotNull
    private String destinationCity;

    @NotNull
    private String name;

    private String surname;

    private String phone;

    @NotNull
    private String email;

    @NotNull
    private Date date;

    private Float hour;

}
