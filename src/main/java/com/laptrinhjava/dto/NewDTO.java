package com.laptrinhjava.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewDTO extends BaseDTO<NewDTO> {
	
	 String title;
	 String content;
	 String shortDescription;
	 String thumbnail;
	 CategoryDTO category;

}
