/**
 * 
 */
package com.gnolivos.zoo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gnolivos.zoo.controller.AnimalController;
import com.gnolivos.zoo.entity.Animal;
import com.gnolivos.zoo.service.IAnimalService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gnolivos
 *
 */
@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class AnimalControllerTest {
	
	@InjectMocks
	AnimalController animalController;

	@Mock
	IAnimalService animalService;

	@Test
	public void findAllAnimalsTest() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	
		List<Animal> animals = new ArrayList<>();
		Animal bird = new Animal();
		bird.setId(1l);
		animals.add(bird);
		Animal tiger = new Animal();
		tiger.setId(2l);
		animals.add(tiger);
		when(animalService.findAllAnimals()).thenReturn(animals);

		ResponseEntity<List<Animal>> responseEntity = animalController.getAnimals();

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		assertThat(responseEntity.getBody()).isNotEmpty();
		log.info("{}", responseEntity.getBody().size());
	}
	
}
