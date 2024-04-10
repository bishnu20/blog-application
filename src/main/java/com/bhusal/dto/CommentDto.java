package com.bhusal.dto;

import com.bhusal.entity.Post;
import com.bhusal.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
	private int comment_id;
	private String comment;
	private User user;
	private Post post;

}
