package com.lzyd.test.pojo;

import lombok.Data;

@Data
public class Prize {
	public Prize(Integer id, String name, Integer proportion) {
		this.id = id;
		this.name = name;
		this.proportion = proportion;
	}

	private Integer id;

	private String name;

	private Integer proportion;
}
