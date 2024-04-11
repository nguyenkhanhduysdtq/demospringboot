package com.laptrinhjava.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name ="news")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class NewEntity extends BaseEntity {
	
	@Column(name = "title")
	 String title;
	
	@Column(name = "thumbnail")
	 String thumbnail;
	
	@Column(name = "shortdescription")
	 String shortDescription;
	
	@Column(name = "content")
	 String content;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	CategoryEntity category;

	
	
	
	
	

}
