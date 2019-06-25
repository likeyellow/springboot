package com.petit;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.petit.domain.Board;
import com.petit.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTests {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void inspect() {
		//실제 객체의 클래스 이름
		Class<?> clz = boardRepo.getClass();
		
		System.out.println(clz.getName());
		//클래스가 구현하고 있는 인터페이스 목록
		Class<?>[] interfaces = clz.getInterfaces();
		
		Stream.of(interfaces).forEach(inter -> System.out.println(inter.getName()));
		//클래스의 부모 클래스
		Class<?> superClasses = clz.getSuperclass();
		
		System.out.println(superClasses.getName());
			
	}
	@Test
	public void testInsert() {
		
		Board board = new Board();
		board.setTitle("게시물의 제목");
		board.setContent("게시물 내용 넣기.....");
		board.setWriter("user00");
		
		boardRepo.save(board);
		
	}
	@Test
	public void testRead() {
		
		//Board board = boardRepo.findById(1L);
		Optional<Board> board = boardRepo.findById(1L);
		
		System.out.println(board);
		
		
	}

}
