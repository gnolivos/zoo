package com.gnolivos.zoo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.gnolivos.zoo.entity.Animal;
import com.gnolivos.zoo.repository.IAnimalRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
@Import( {BuildProperties.class })
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("/test.properties")
public class AnimalRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private IAnimalRepository animalRepository;

    @Test
    public void findAnimalByIdTest() {
        // given
        Animal bird = new Animal();
        bird.setName("bird");

        this.entityManager.persist(bird);
        this.entityManager.flush();

        // when
        Optional<Animal> found = this.animalRepository.findById(bird.getId());

        // then
        assertThat(bird.getName()).isEqualTo(found.get().getName());
        log.info("{}", found.get().toString());
    }
    
    @Test
    public void findAllAnimalsTest() {
        // given
        Animal bird = new Animal();
        bird.setName("bird");
        Animal monkey = new Animal();
        monkey.setName("monkey");

        this.entityManager.persist(bird);
        this.entityManager.persist(monkey);
        this.entityManager.flush();

        // when
        Iterable<Animal> iterable = this.animalRepository.findAll();

        List<Animal> result = new ArrayList<>();
        iterable.forEach(result::add);
        
        // then
        assertEquals(2, result.size());
        log.info("{}", result.size());
    }
    
    @Test
    public void createAnimalTest() {
    	
    	// given
    	Animal bird = new Animal();
        bird.setAge(2);
        bird.setDateBorn(LocalDate.now());
        bird.setName("bird");
        bird.setWeight(5L);
        
        this.entityManager.persist(bird);
        this.entityManager.flush();
        // when
        Optional<Animal> found = this.animalRepository.findById(bird.getId());
        
        // then
        this.animalRepository.save(found.get());
        Optional<Animal> foundNew = this.animalRepository.findById(bird.getId());
        log.info("{}", foundNew.get().toString());
    }
    
    @Test
    public void deleteAnimalTest() {
    	// given
        Animal bird = new Animal();
        bird.setName("bird");

        this.entityManager.persist(bird);
        this.entityManager.flush();

        // when
        Optional<Animal> found = this.animalRepository.findById(bird.getId());

        // then
        assertThat(bird.getName()).isEqualTo(found.get().getName());
        log.info("{}", found.get().toString());
        
        this.animalRepository.delete(found.get());
        Optional<Animal> foundDelete = this.animalRepository.findById(bird.getId());
        log.info("Empty {}", !foundDelete.isPresent());
    }
}
