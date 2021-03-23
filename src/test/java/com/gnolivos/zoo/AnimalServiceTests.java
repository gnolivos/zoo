/**
 * 
 */
package com.gnolivos.zoo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.gnolivos.zoo.entity.Animal;
import com.gnolivos.zoo.repository.IAnimalRepository;
import com.gnolivos.zoo.service.AnimalService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gnolivos
 *
 */
@RunWith(MockitoJUnitRunner.Silent.class)
@Slf4j
public class AnimalServiceTests {
	
	@InjectMocks
    private AnimalService animalService;

    @Mock
    private IAnimalRepository animalRepository;
    
    @Before
    public void setup() {
        // MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testFindAllAnimalsTest() {
		// Arrange
		Animal animal = new Animal();
    	animal.setName("loro");
    	Optional<Animal> opt = Optional.of(animal);
    	when(animalRepository.findById(1L)).thenReturn(opt);
    	
		// Act
		Optional<Animal> found = this.animalService.findAnimalById(1L);

		// Assert
		assertThat("loro").isEqualTo(found.get().getName());
		log.info("{}", found.get().toString());
	}

}
