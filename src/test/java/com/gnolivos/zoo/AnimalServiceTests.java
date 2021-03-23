/**
 * 
 */
package com.gnolivos.zoo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
	
	private static final Long VALID_ID = 1L;
	
	@InjectMocks
    private AnimalService animalService;

    @Mock
    private IAnimalRepository animalRepository;
    
    @Before
    public void setup() {
        // MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void findAnimalByIdTest() {
		// Arrange
		Animal animal = new Animal();
    	animal.setName("bird");
    	Optional<Animal> opt = Optional.of(animal);
    	
    	when(this.animalRepository.findById(VALID_ID)).thenReturn(opt);
		// Act
		Optional<Animal> found = this.animalService.findAnimalById(VALID_ID);
		// Assert
		assertThat("bird").isEqualTo(found.get().getName());
		log.info("{}", found.get().toString());
	}
	
	@Test
    public void getAllAnimalsTest() {
		// Arrange
        List<Animal> list = new ArrayList<>();
        Animal bird = new Animal();
        bird.setId(VALID_ID);
        bird.setName("bird");
        Animal tiger = new Animal();
        tiger.setId(2L);
        tiger.setName("tiger");

        list.add(bird);
        list.add(tiger);

        when(this.animalRepository.findAll()).thenReturn(list);
        // Act
        List<Animal> empList = this.animalService.findAllAnimals();
        // Assert
        assertEquals(2, empList.size());
        verify(this.animalRepository, times(1)).findAll();
        log.info("{}", empList.size());
    }
	
	@Test
    public void createAnimalTest() {
		// Arrange
        Animal bird = new Animal();
        bird.setId(VALID_ID);
        bird.setAge(2);
        bird.setDateBorn(LocalDate.now());
        bird.setName("bird");
        bird.setWeight(5L);
        // Act
        this.animalService.save(bird);
        // Assert
        verify(this.animalRepository, times(1)).save(bird);
    }
	
	@Test
    public void deleteAnimalTest() {
		// Arrange
        Animal tiger = new Animal();
        tiger.setId(1L);
        tiger.setName("tiger");
        // Act
        this.animalService.delete(tiger.getId());
        // Assert
        verify(this.animalRepository, times(1)).deleteById(tiger.getId());
    }

}
