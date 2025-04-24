package org.gudo.backend.board.service;

import org.gudo.backend.board.dto.BoardListDTO;
import org.gudo.backend.board.dto.PageRequestDTO;
import org.gudo.backend.board.dto.PageResponseDTO;

public interface BoardService {

    PageResponseDTO<BoardListDTO> list(PageRequestDTO pageRequestDTO, boolean withDetails);
}

