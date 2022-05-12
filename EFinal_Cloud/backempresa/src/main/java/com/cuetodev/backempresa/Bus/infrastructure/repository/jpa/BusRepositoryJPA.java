package com.cuetodev.backempresa.Bus.infrastructure.repository.jpa;

import com.cuetodev.backempresa.Bus.domain.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BusRepositoryJPA extends JpaRepository<Bus, Integer> {
    @Query("SELECT b FROM Bus b where b.city like ?1 AND b.date like ?2 AND b.hour like ?3")
    public Bus getBusByData(String city, Date date, Float hour);
}
