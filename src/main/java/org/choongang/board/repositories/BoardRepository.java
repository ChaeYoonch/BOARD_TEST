package org.choongang.board.repositories;

import org.choongang.board.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>, QuerydslPredicateExecutor<Board>  {
    Board findByTitle(String title);

    List<Board> findAllByOrderByIdAsc();
}