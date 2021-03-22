/**
 * 
 */
package com.gnolivos.zoo.vo;

import java.util.Date;

import lombok.Data;

/**
 * @author gnolivos
 *
 */
@Data
public class AnimalRequest {
	private String name;
	private String age;
	private Date dateBorn;
	private Long weight;
}
