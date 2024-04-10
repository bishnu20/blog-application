package com.bhusal.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
@Table(name="comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int comment_id;
	private String comment;	
	// multiple comments can be associated with a user or a user can do multiple comments.
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	@NotEmpty(message="User can't be empty.")
	private User user;

	// multiple comments can be done with a post
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @ManyToOne(cascade = CascadeType.ALL)	  
	  @JoinColumn(name="post_id") 
	  private Post post;
	 
	 

}
