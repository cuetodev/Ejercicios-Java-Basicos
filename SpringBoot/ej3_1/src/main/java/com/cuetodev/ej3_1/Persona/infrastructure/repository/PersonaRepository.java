package com.cuetodev.ej3_1.Persona.infrastructure.repository;

import com.cuetodev.ej3_1.ErrorHandling.NotFoundException;
import com.cuetodev.ej3_1.ErrorHandling.UnprocesableException;
import com.cuetodev.ej3_1.Persona.domain.Persona;
import com.cuetodev.ej3_1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.cuetodev.ej3_1.Persona.infrastructure.repository.jpa.PersonaRepositoryJPA;
import com.cuetodev.ej3_1.Persona.infrastructure.repository.port.PersonaRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PersonaRepository implements PersonaRepositoryPort {

    @Autowired
    private PersonaRepositoryJPA personaRepositoryJPA;

    @Override
    public Persona save(Persona persona) {
        if (persona == null) return new Persona();
        personaRepositoryJPA.save(persona);
        return persona;
    }

    public Persona findPersonaById(int id) throws NotFoundException {
        return personaRepositoryJPA.findById(id).orElseThrow(() -> new NotFoundException("Id no encontrada"));
    }

    public List<Persona> findPersonaByUsuario(String usuario) throws Exception {
        return personaRepositoryJPA.findPersonaByUsuario(usuario);
    }

    public List<Persona> getAllPeople() throws Exception {
        return personaRepositoryJPA.getAllPeople();
    }

    @Override
    public int deletePerson(int id) throws Exception {
        try {
            return personaRepositoryJPA.deletePerson(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Persona updatePerson(Persona personaActualizada) throws UnprocesableException {
        Persona persona;
        try {
            persona = personaRepositoryJPA.save(personaActualizada);
        } catch (UnprocesableException e) {
            throw new UnprocesableException("Validación de campos no completada");
        }

        return persona;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Persona> getData(HashMap<String, Object> conditions, String orderBy) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> query= cb.createQuery(Persona.class);
        Root<Persona> root = query.from(Persona.class);

        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field,value) ->
        {
            switch (field)
            {
                case "usuario":
                case "name":
                case "surname":
                    predicates.add(cb.like(root.get(field), "%"+(String)value+"%"));
                    break;

                case "fechaCreacion":
                    String dateCondition=(String) conditions.get("condition");
                    switch (dateCondition)
                    {
                        case "greater":
                            predicates.add(cb.greaterThan(root.<Date>get(field),(Date)value));
                            break;
                        case "less":
                            predicates.add(cb.lessThan(root.<Date>get(field),(Date)value));
                            break;
                        case "equal":
                            predicates.add(cb.equal(root.<Date>get(field),(Date)value));
                            break;
                    }
                    break;
            }

        });
        if ("user".equals(orderBy)) {
            query.select(root).where(predicates.toArray(new Predicate[predicates.size()])).orderBy(cb.asc(root.get("usuario")));
        } else if ("name".equals(orderBy)) {
            query.select(root).where(predicates.toArray(new Predicate[predicates.size()])).orderBy(cb.asc(root.get("name")));
        } else {
            query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        }

        List<Persona> peopleList = entityManager.createQuery(query).getResultList();
        
        return peopleList;
    }
}
