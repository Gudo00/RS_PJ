package org.gudo.backend.board;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.gudo.backend.board.dto.BoardListDTO;
import org.gudo.backend.board.dto.PageRequestDTO;
import org.gudo.backend.board.dto.PageResponseDTO;
import org.gudo.backend.board.service.BoardService;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testListBoards() {

        PageResponseDTO<BoardListDTO> result = boardService.list(new PageRequestDTO(),false);

        result.getDtoList().forEach(board -> log.info(board));

    }

}