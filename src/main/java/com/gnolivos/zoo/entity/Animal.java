/**
 * 
 */
package com.gnolivos.zoo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gnolivos
 *
 */
@Entity
@Table(name = "ANIMAL")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@NotBlank(message = "Name field is mandatory")
    @Size(min = 0, max = 30, message = "Name must be between {min} and {max} characters long")
    private String name;

	@Column(name = "AGE")
    private Integer age;
	
	@Column(name = "DATEBORN")
    private LocalDate dateBorn;
    
	@Column(name = "WEIGHT")
    private Long weight;
	
}
