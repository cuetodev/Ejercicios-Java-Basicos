package com.cuetodev.bs2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ciudad {
    private String nombre;
    private int numeroDeHabitantes;
}
