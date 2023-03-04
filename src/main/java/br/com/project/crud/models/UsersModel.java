package br.com.project.crud.models;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Users")
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class UsersModel {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user", nullable = false)
	private Integer id_user;
	
	@Column(name="name", nullable = false, length = 50)
	@NonNull
	private String name;
	
	@Column(name="email", nullable = false, length = 255)
	@NonNull
	private String email;
	
	@Column(name="status", nullable = false)
	@NonNull
	public Integer status;	
	
	@CreationTimestamp
	@Column(name="created_at", nullable = false, updatable = false, insertable = false)
	private Timestamp created_at;
}
