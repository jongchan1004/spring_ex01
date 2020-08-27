package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Member {
	private String name;
	private int age;
	public Member() {};
}
