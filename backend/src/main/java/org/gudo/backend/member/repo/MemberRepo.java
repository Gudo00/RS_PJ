package org.gudo.backend.member.repo;

import org.gudo.backend.member.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepo extends JpaRepository<Member, String> {

    @EntityGraph(attributePaths = {"roleSet"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("select m from Member m where m.mid = :mid")
    Member selectOne( @Param("mid") String mid);

}
