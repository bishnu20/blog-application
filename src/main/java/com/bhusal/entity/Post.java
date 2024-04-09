package com.bhusal.entity;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	@NotEmpty
	private String title;
	@NotEmpty
	private String content;
	private String image;
	private LocalDate postedDate = LocalDate.now();
	private LocalDate updatedDate;
	// One category can have many posts
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cat_id")
	private Category category;
	// one user can do multiple posts, table is created on multiple side.
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	
	

}
