package com.cts;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestBooks {
	@Autowired
	BookRepository myBookRepository;
	
	@Test
	public void testGetBooks() throws Exception {
		List<Book> bookList = myBookRepository.loadBooks();
		Assert.assertNotEquals(null, bookList);
	}
	
	@Test
	public void testSearchBook() throws Exception {
		List<Book> searchedBook = myBookRepository.searchBook("chem");
		Assert.assertNotEquals(null, searchedBook);
		Assert.assertEquals(2, searchedBook.size());
	}
}
