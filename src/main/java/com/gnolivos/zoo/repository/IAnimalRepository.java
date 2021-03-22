/**
 * 
 */
package com.gnolivos.zoo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gnolivos.zoo.entity.Animal;

/**
 * @author gnolivos
 *
 */
@Repository
public interface IAnimalRepository extends CrudRepository<Animal, Long>{

}
