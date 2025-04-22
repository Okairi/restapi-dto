package com.application.rest.service.impl;

import com.application.rest.entities.Maker;
import com.application.rest.persistence.IMakerDAO;
import com.application.rest.service.IMarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakerServiceImpl implements IMarkerService {

    @Autowired
    private IMakerDAO iMakerDAO;

    @Override
    public Optional<Maker> findById(Long id) {
        return this.iMakerDAO.findById(id);
    }

    @Override
    public List<Maker> findAll() {
        return this.iMakerDAO.findAll();
    }

    @Override
    public void save(Maker maker) {

        this.iMakerDAO.save(maker);

    }

    @Override
    public void deleteById(Long id) {
this.iMakerDAO.deleteById(id);
    }
}
