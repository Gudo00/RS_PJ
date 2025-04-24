package org.gudo.backend.board.repo;

import org.gudo.backend.board.domain.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepo extends JpaRepository<Favorite, Integer> {
}