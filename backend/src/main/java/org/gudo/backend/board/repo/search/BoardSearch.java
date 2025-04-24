package org.gudo.backend.board.repo.search;

import org.gudo.backend.board.dto.BoardListDTO;
import org.gudo.backend.board.dto.PageRequestDTO;
import org.gudo.backend.board.dto.PageResponseDTO;

public interface BoardSearch {

    PageResponseDTO<BoardListDTO> search(PageRequestDTO pageRequestDTO);

}
