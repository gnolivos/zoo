/**
 * 
 */
package com.gnolivos.zoo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gnolivos.zoo.entity.Animal;
import com.gnolivos.zoo.service.IAnimalService;
import com.gnolivos.zoo.vo.AnimalNameOnly;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author gnolivos
 *
 */
@RestController
@RequestMapping("/api/v1/animals")
@Tag(name = "Animal", description = "The Animal API v1")
public class AnimalController {
	
	@Lazy
    @Autowired
    private IAnimalService animalService;

	/**
	 * http://localhost:8081/api/v1/animals (GET)
	 * 
	 * @return
	 */
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found animals",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Animal.class)) }),
            @ApiResponse(responseCode = "204 ", description = "Animals not found",
                    content = @Content) })
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Animal>> getAnimals() {
		List<Animal> result = this.animalService.findAllAnimals();
		if(CollectionUtils.isEmpty(result)) {
			return ResponseEntity.noContent().build();
		}
        return ResponseEntity.ok(this.animalService.findAllAnimals());
    }

	/**
	 * http://localhost:8081/api/v1/animals/{id} (GET)
	 * 
	 * @param id
	 * @return
	 */
    @Operation(summary = "Get an animal by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found animal",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Animal.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Method not found",
                    content = @Content) })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Animal> getAnimalById(@Parameter(description = "Id of animal to be searched") @PathVariable Long id) {
    	Optional<Animal> animalOptional = animalService.findAnimalById(id);
        if (!animalOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(animalOptional.get());
    }

    /**
     * http://localhost:8081/api/v1/animals (POST)
     * 
     * @param request
     * @return
     */
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created animal",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Animal.class)) }),
            @ApiResponse(responseCode = "404", description = "Method not found",
                    content = @Content) })
    @PostMapping
    public ResponseEntity<Animal> create(@Valid @RequestBody Animal request) {
        return ResponseEntity.ok(this.animalService.save(request));
    }

    /**
     * http://localhost:8081/api/v1/animals (PUT)
     * 
     * @param request
     * @return
     */
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modified animal",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Animal.class)) }),
            @ApiResponse(responseCode = "404", description = "Method not found",
                    content = @Content) })
    @PutMapping
    public ResponseEntity<Animal> update(@Valid @RequestBody Animal request) {
        return ResponseEntity.ok(this.animalService.saveOrUpdate(request));
    }

    /**
     * http://localhost:8081/api/v1/animals/{id} (DELETE)
     * 
     * @param id
     */
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted animal",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Animal.class)) }),
            @ApiResponse(responseCode = "404", description = "Method not found",
                    content = @Content) })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
    	this.animalService.delete(id);
    	ResponseEntity.ok();
    }
    
    /**
     * http://localhost:8081/api/v1/animals/{id} (Patch)
     * 
     * @param partialUpdate
     * @param id
     * @return
     */
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modified animal",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Animal.class)) }),
            @ApiResponse(responseCode = "404", description = "Method not found",
                    content = @Content) })
    @PatchMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@Valid
      @RequestBody AnimalNameOnly partialUpdate, @PathVariable("id") Long id) {
    	Optional<Animal> animalOptional = animalService.findAnimalById(id);
        if (!animalOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Animal animal = animalOptional.get();
        if(partialUpdate.getName() != null) {
        	animal.setName(partialUpdate.getName());
        }
        return ResponseEntity.ok(this.animalService.save(animal));
    }
	
}
