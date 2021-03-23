/**
 * 
 */
package com.gnolivos.zoo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.stereotype.Service;

import com.gnolivos.zoo.common.AnimalNotFoundException;
import com.gnolivos.zoo.entity.Animal;
import com.gnolivos.zoo.repository.IAnimalRepository;

/**
 * @author gnolivos
 *
 */
@Lazy
@Service
public class AnimalService implements IAnimalService{

	@Lazy
    @Autowired
    private IAnimalRepository animalRepository;
	
	/*
	 * (non-Javadoc)
	 * @see com.gnolivos.zoo.service.IAnimalService#findAllAnimal()
	 */
	@Override
	public List<Animal> findAllAnimals() throws ConversionFailedException {
		return StreamSupport.stream(animalRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
	}

	/*
	 * (non-Javadoc)
	 * @see com.gnolivos.zoo.service.IAnimalService#findAnimalById(java.lang.Long)
	 */
	@Override
	public Optional<Animal> findAnimalById(Long id) throws ConversionFailedException {
		return this.animalRepository.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gnolivos.zoo.service.IAnimalService#save(com.gnolivos.zoo.entity.Animal)
	 */
	@Override
	public Animal save(Animal animal) throws AnimalNotFoundException{
		try {
			return this.animalRepository.save(animal);
		} catch (Exception e) {
			throw new AnimalNotFoundException();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.gnolivos.zoo.service.IAnimalService#saveOrUpdate(com.gnolivos.zoo.entity.Animal)
	 */
	@Override
	public Animal saveOrUpdate(Animal animal) throws AnimalNotFoundException {
		return this.animalRepository.save(animal);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gnolivos.zoo.service.IAnimalService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) throws AnimalNotFoundException {
		this.animalRepository.deleteById(id);
	}
	
}
