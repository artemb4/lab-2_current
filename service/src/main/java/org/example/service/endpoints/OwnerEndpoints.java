package org.example.service.endpoints;

import org.example.service.dto.OwnerDTO;
import org.example.dto.schemas.Owner;
import org.example.service.services.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/owner")
public class OwnerEndpoints {
    @Autowired
    private OwnerService ownerService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/create")
    public ResponseEntity<Owner> CreateOwner(@RequestBody Owner owner) {
        return ResponseEntity.ok(mapper.map(ownerService.create(owner), Owner.class));
    }

    @GetMapping("/search_by_id")
    public ResponseEntity<OwnerDTO> SearchOwner(@RequestParam("id") Long id) {
        return new ResponseEntity<>(ownerService.readById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/update")
    public ResponseEntity<Owner> UpdateOwner(@RequestBody Owner owner) {
        return ResponseEntity.ok(mapper.map(ownerService.update(owner), Owner.class));
    }

    @PostMapping("/delete")
    public ResponseEntity<Owner> DeleteOwner(@RequestParam("id") Long id) {
        ownerService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/add_cat")
    public ResponseEntity<Owner> AddCat(@RequestParam("owner_id") Long owner_id,
                                        @RequestParam("cat_id") Long cat_id) {
        return ResponseEntity.ok(mapper.map(ownerService.addCat(owner_id, cat_id), Owner.class));
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<OwnerDTO>> GetAllOwners() {
        return new ResponseEntity<>(ownerService.getAll().stream().map(this::toDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    public OwnerDTO toDTO(Owner entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, OwnerDTO.class);
    }
}
