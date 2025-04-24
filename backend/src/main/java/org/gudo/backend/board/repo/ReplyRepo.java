package org.gudo.backend.board.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.gudo.backend.board.domain.Reply;

import java.util.List;

public interface ReplyRepo extends JpaRepository<Reply, Integer> {

    @Query("select r, b from Reply r left join Board b on r.board = b " +
            "where r.board.bno in (:bnos) group by r, b order by r.rno asc ")
    List<Object[]> listOfBnos( @Param("bnos") List<Integer> bnos);
}
