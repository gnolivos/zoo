package com.gnolivos.zoo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class ZooApplicationTests {
	
	@Autowired
    private MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {
		
//		HashMap<String, Object> updates = new HashMap<>();
//		updates.put("address", "5th avenue");
//		
//		mockMvc.perform(get("/api/v1/animals")
//			    .contentType(MediaType.APPLICATION_JSON_VALUE))
//				.andExpect(status().isOk());

//		mockMvc.perform(get("/api/v1/animals")
//		    .contentType(MediaType.APPLICATION_JSON_VALUE))
//			.andExpect(status().isOk()).andExpect(jsonPath("$").isArray())
//            .andExpect(jsonPath("$", hasSize(3)))
//            .andExpect(jsonPath("$[2].id", is(6)))
//            .andDo(MockMvcResultHandlers.print());
	}

}
