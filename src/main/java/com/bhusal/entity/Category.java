package com.bhusal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cateId;
	private String category;
	
	/*
	 * // one category many have many posts
	 * 
	 * @OneToMany(mappedBy = "category",cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY) private List<Post> posts = new ArrayList<>();
	 */

}
