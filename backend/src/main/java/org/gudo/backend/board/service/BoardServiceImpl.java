package org.gudo.backend.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.gudo.backend.board.domain.Board;
import org.gudo.backend.board.domain.Reply;
import org.gudo.backend.board.dto.BoardListDTO;
import org.gudo.backend.board.dto.PageRequestDTO;
import org.gudo.backend.board.dto.PageResponseDTO;
import org.gudo.backend.board.dto.ReplyDTO;
import org.gudo.backend.board.repo.BoardRepo;
import org.gudo.backend.board.repo.ReplyRepo;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepo boardRepo;
    private final ReplyRepo replyRepo;

    @Override
    public PageResponseDTO<BoardListDTO> list(PageRequestDTO pageRequestDTO, boolean withDetail) {

        PageResponseDTO<BoardListDTO> result = boardRepo.search(pageRequestDTO);

        if(withDetail) {
            List<Integer> bnos = result.getDtoList().stream().map(dto -> dto.getBno()).collect(Collectors.toUnmodifiableList());

            List<Object[]> etcInfos = replyRepo.listOfBnos(bnos);

            etcInfos.stream().forEach(arr -> {

                Reply reply = (Reply) arr[0];
                Board board = (Board) arr[1];
                List<String> tags = board.getTags();
                List<String> images = board.getImages().stream().map(boardImage -> boardImage.getFileName()).toList();


                BoardListDTO target = result.getDtoList().stream()
                        .filter(dto -> dto.getBno().equals(board.getBno()))
                        .findFirst().get();

                ReplyDTO replyDTO = ReplyDTO.builder()
                        .rno(reply.getRno())
                        .str(reply.getStr())
                        .mid(reply.getMid())
                        .bno(board.getBno())
                        .build();

                target.addReplyDTO(replyDTO);

                target.setTags(tags);
                target.setImages(images);

            });
        }
        return result;
    }
}
