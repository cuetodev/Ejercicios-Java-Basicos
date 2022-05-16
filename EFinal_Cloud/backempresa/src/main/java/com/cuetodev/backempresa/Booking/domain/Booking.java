package com.cuetodev.backempresa.Booking.domain;

import com.cuetodev.backempresa.Mail.domain.Mail;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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

    private String status;

    @OneToMany
    @JoinColumn(name = "mail_id")
    private Set<Mail> mailSet;
}
