package com.yedam.app;

import java.util.Date;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class JacksonTest {

	@Test
	public void writeTest() throws JsonProcessingException {
		//VO
		ObjectMapper om = new ObjectMapper();
		BoardVO vo = new BoardVO();
		vo.setBno(1L);
		vo.setTitle("testoast");
		vo.setContent("����");
		vo.setWriter("���ٵ���");
		vo.setRegdate(new Date());
		
		String result = om.writeValueAsString(vo);
		log.info(result);
		
	}
	
	@Test
	public void readTest() throws JsonMappingException, JsonProcessingException {
		String jsonstr = "{\"bno\":1,\"title\":\"testoast\",\"content\":\"����\",\"writer\":\"���ٵ���\",\"regdate\":\"2023-08-08 / 04:02:50\"}";
		ObjectMapper om = new ObjectMapper();
		BoardVO vo = om.readValue(jsonstr, BoardVO.class);
		log.info(vo);
	}
	
}
