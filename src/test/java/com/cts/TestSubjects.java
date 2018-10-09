package com.cts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.cts")
public class TestSubjects {
	@Autowired
	SubjectRepository mySubjectRepository;
	
	@Test
	public void testSearchSubject(){
		mySubjectRepository.searchSubject("chem");
	}
}
