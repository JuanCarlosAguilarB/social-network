package com.example.socialnetwork.controllers.catalogs;

import com.example.socialnetwork.entities.Color;
import com.example.socialnetwork.services.catalogs.CreateColorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Catalogs", description = "Catalogs management operations")
@RestController
public class CreateColorController {


    @Autowired
    private CreateColorService createColorService;

    @Operation(summary = "Create color", description = "Create a new color", tags = { "Catalogs" })
    @PostMapping("/catalogs/colors/")
    public ResponseEntity createColor(@RequestBody CreateColorRequest requestColor){

        Color color = new Color().builder()
                .name(requestColor.getName())
                .hex(requestColor.getHex())
                .build();

        createColorService.createColor(color);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}


@Getter
@Setter
class CreateColorRequest {
    private String name;
    private String hex;
}


