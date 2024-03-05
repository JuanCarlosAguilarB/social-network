package com.example.socialnetwork.services.catalogs;

import com.example.socialnetwork.entities.Color;
import com.example.socialnetwork.repositories.catalogs.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateColorService {

    @Autowired
    ColorRepository colorRepository;

    public void createColor(Color color) {
        colorRepository.save(color);
    }

}
