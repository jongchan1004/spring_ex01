package org.zerock.domain;

import java.beans.PropertyEditorSupport;

public class CustomMemberEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// text: john-99
		String[] strs = text.split("-");
		String name = strs[0];
		int age = Integer.valueOf(strs[1]);
		
		Member member = new Member();
		member.setName(name);
		member.setAge(age);
		
		setValue(member);//전달해 주는 메소드
	}
}
