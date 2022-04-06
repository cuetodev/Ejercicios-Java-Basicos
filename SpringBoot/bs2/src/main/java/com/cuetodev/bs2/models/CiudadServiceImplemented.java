package com.cuetodev.bs2.models;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiudadServiceImplemented implements CiudadService {
    List<Ciudad> ciudadList = new ArrayList<>();

    @Override
    public void addCiudad(Ciudad ciudad) {
        ciudadList.add(ciudad);
    }

    @Override
    public List<Ciudad> getAllCiudades() {
        return this.ciudadList;
    }
}
