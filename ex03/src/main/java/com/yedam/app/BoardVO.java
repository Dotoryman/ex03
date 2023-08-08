package com.yedam.app;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class BoardVO {
	private long bno;
	private String title;
	private String content;
	private String writer;
	@JsonFormat(pattern="yyyy-MM-dd / hh:mm:ss")
	private Date regdate;
	
	@JsonIgnore
	private Date updatedate;
}
