package com.example.demo;
import org.junit.jupiter.api.Test;

import com.example.demo.board.mapper.ReplyMapper;
import lombok.Setter;

public class ReplyMapperTests {
@Setter(onMethod_ =@Autowired)
private ReplyMapper mapper;

@Test
public void testMapper() {
	log.info(mapper);
}

}
