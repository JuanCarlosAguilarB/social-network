package com.example.socialnetwork.controllers.catalogs;

import com.example.socialnetwork.entities.Color;
import com.example.socialnetwork.services.catalogs.ListColorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Catalogs", description = "Catalogs management operations")
@RestController
public class ListColorController {

    @Autowired
    private ListColorService listColorService;

    @Operation(summary = "List colors", description = "List all colors", tags = { "Catalogs" })
    @GetMapping("/catalogs/colors/")
    public ResponseEntity listColors(Pageable pageable) {
        Page<Color> colors = listColorService.listColors(pageable);
        return ResponseEntity.ok(colors);
    }

}
