package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class MemberList {
	
	private List<Member> list;
	
	private MemberList() {
		list = new ArrayList<>();
	}

}
