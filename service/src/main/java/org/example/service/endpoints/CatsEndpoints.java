package org.example.service.endpoints;


import org.example.service.dto.CatDTO;
import org.example.service.dto.CatFriendsDTO;
import org.example.dto.schemas.Cat;
import org.example.dto.schemas.Color;
import org.example.dto.schemas.Owner;
import org.example.service.services.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.service.services.CatService;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatsEndpoints {
    @Autowired
    private CatService catService;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/create")
    public ResponseEntity<Cat> create(@RequestBody Cat cat) {
        return ResponseEntity.ok(catService.create(cat));
    }

    @GetMapping("/search_by_id")
    public ResponseEntity<CatDTO> searchById(@RequestParam("id") Long id) {
        return new ResponseEntity<>(catService.readById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/update")
    public ResponseEntity<Cat> update(@RequestBody Cat cat) {
        return ResponseEntity.ok(catService.update(cat));
    }

    @PostMapping("/delete")
    public ResponseEntity<Cat> delete(@RequestParam("id") Long id) {
        catService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add_friends")
    public ResponseEntity<CatFriendsDTO> addFriends(@RequestBody Cat cat, Long id) {
        return ResponseEntity.ok().body(catService.addFriend(cat, id));
    }

    @GetMapping("/get_by_color")
    public ResponseEntity<List<Cat>> getByColor(@RequestParam("color") Color color) {
        return ResponseEntity.ok().body(catService.GetCatsByColor(color));
    }

    @GetMapping("/get_by_breed")
    public ResponseEntity<List<Cat>> getByBreed(@RequestParam("breed") String breed) {
        return ResponseEntity.ok().body(catService.GetCatsByBreed(breed));
    }

    @GetMapping("/get_by_owner")
    public ResponseEntity<List<Cat>> getByOwner(@RequestParam("owner") Owner owner) {
        return ResponseEntity.ok().body(catService.GetCatsByOwner(owner));
    }

}
