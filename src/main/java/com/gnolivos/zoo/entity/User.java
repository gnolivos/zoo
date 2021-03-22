/**
 * 
 */
package com.gnolivos.zoo.entity;

import java.time.LocalDateTime;

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
@Table(name = "USER")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@NotBlank(message = "Name field is mandatory")
    @Size(min = 0, max = 20, message = "Name must be between {min} and {max} characters long")
    private String name;

	@Column(name = "EMAIL")
    private String email;

	@Column(name = "PASSWORD")
    private String password;

	@Column(name = "USERCREATED")
    private final LocalDateTime userCreated = LocalDateTime.now();

    @Column(name = "USERMODIFIED")
    private LocalDateTime userModified;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "STATUS")
    private String status;

}
