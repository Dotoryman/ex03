package com.yedam.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {
	//등록
	@PostMapping("")
	public ResponseEntity<Todo> insert(Todo vo) {
		ResponseEntity<Todo> result = null;
		if( vo.getTitle() == null ) {
			result = ResponseEntity.status(HttpStatus.NOT_FOUND).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;		
	}
	
	//수정  수정은 json타입만 받음, 리퀘스트바디 써주쇼
	@PutMapping("/{no}")
	public Todo update(@PathVariable("no") int no, @RequestBody Todo vo) {
		vo.setNo(no);
		return vo;
	}
	
	//삭제
	@DeleteMapping("/{no}")
	public Integer delete(@PathVariable("no") int no) {
		return no;
	}
	
	
	//단건조회
	@GetMapping("/{no}")
	public Todo select(@PathVariable("no") int no) {
		Todo obj = new Todo();
		Todo todo = Todo.builder()
					.no(no)
					.title("오늘의 퀘스트")
					.complete("N")
					.build();
		return todo;
	}
	//전체조회
}
