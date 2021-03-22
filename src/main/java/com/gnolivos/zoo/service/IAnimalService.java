/**
 * 
 */
package com.gnolivos.zoo.service;

import java.util.List;
import java.util.Optional;

import com.gnolivos.zoo.entity.Animal;

/**
 * @author gnolivos
 *
 */
public interface IAnimalService {

	/**
	 * Find all animals
	 * @return
	 */
	List<Animal> findAllAnimals();
	
	/**
	 * Find animal by id
	 * @param id
	 * @return
	 */
    Optional<Animal> findAnimalById(Long id);
    
    /**
     * Save animal
     * @param animal
     * @return
     */
    Animal save(Animal animal);
    
    /**
     * Save or update animal
     * @param animal
     * @return
     */
    Animal saveOrUpdate(Animal animal);
    
    /**
     * Delete animal
     * @param id
     */
    void delete(Long id);
    
}
