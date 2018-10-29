package com.cts;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSubjects {
	@Autowired
	SubjectRepository mySubjectRepository;
	
	@Test
	public void testGetSubjects() throws Exception {
		List<Subject> subjectList = mySubjectRepository.loadSubjects();
		Assert.assertNotEquals(null, subjectList);
	}
	
	@Test
	public void testSearchSubject() throws Exception {
		List<Subject> searchedSubject = mySubjectRepository.searchSubject("c");
		Assert.assertNotEquals(null, searchedSubject);
		Assert.assertEquals(2, searchedSubject.size());
	}
}
