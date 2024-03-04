package com.example.socialnetwork.services.catalogs;

import com.example.socialnetwork.entities.Color;
import com.example.socialnetwork.repositories.catalogs.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListColorService {

    @Autowired
    private ColorRepository colorRepository;

    public Page<Color> listColors(Pageable pageable) {
        return colorRepository.findAll(pageable);
    }
}
