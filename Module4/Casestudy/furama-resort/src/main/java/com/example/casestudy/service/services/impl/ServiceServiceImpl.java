package com.example.casestudy.service.services.impl;

import com.example.casestudy.repository.services.ServiceRepository;
import com.example.casestudy.service.services.ServiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceServices {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<com.example.casestudy.model.service.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Page<com.example.casestudy.model.service.Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public com.example.casestudy.model.service.Service findById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public com.example.casestudy.model.service.Service findBySerId(String id) {
        return serviceRepository.findBySerId(id);
    }

    @Override
    public void deleteById(String id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public void save(com.example.casestudy.model.service.Service service) {
        serviceRepository.save(service);
    }
}
