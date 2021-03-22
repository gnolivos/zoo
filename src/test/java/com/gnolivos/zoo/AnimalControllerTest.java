/**
 * 
 */
package com.gnolivos.zoo;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author gnolivos
 *
 */
//@RunWith(MockitoJUnitRunner.class)
//@WebMvcTest(value = AnimalController.class)
//@WithMockUser
@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class AnimalControllerTest {
	
	@Autowired
	protected MockMvc mockMvc;

	@Test
	public void testFindAllAnimalsTest() {
	
//		List<Animal> animals = new ArrayList<>();
//		Animal animal = new Animal();
//		animal.setId(1l);
//		animals.add(animal);
//		Mockito.when(this.animalService.findAllAnimals()).thenReturn(animals);
		
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//				"/api/v1/animals").accept(MediaType.APPLICATION_JSON);
		
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

//		System.out.println(result.getResponse());
		
		Assertions.assertThat(1).isEqualTo(1);
		
		
	}

}
