package com.bhusal.dto;

import java.time.LocalDate;

import com.bhusal.entity.Category;
import com.bhusal.entity.Comment;
import com.bhusal.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
	private int post_id;
	private String title;
	private String content;
	private String image;
	private LocalDate postedDate = LocalDate.now();
	private LocalDate updatedDate;
	private Category category;
	private User user;
	private Comment comment;

}
