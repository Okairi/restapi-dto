package com.application.rest.controller;

import com.application.rest.controller.dto.MakerDTO;
import com.application.rest.entities.Maker;
import com.application.rest.service.IMarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maker")
public class MakerController {


    @Autowired
    private IMarkerService iMarkerService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Maker> makerOptional= this.iMarkerService.findById(id);

        if(makerOptional.isPresent()){
            Maker maker= makerOptional.get();

            MakerDTO makerDTO = MakerDTO.builder().id(maker.getId()).name(maker.getName()).
                    products(maker.getProducts()).build();

            return ResponseEntity.ok(makerDTO);

        }

        return ResponseEntity.notFound().build();

    }

     @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

         List<MakerDTO> makerList = this.iMarkerService.findAll().stream().map(maker -> MakerDTO.builder().id(maker.getId()).name(maker.getName()).products(maker.getProducts()).build()).toList();


         return ResponseEntity.ok(makerList);

     }


     @PostMapping("/save")
     public  ResponseEntity<?> save(@RequestBody MakerDTO  makerDTO) throws URISyntaxException {


        if(makerDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
          iMarkerService.save(Maker.builder().name(makerDTO.getName()).build());

    return ResponseEntity.created(new URI("/api/maker/save")).build();
     }
}
