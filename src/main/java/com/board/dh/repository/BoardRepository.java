package com.board.dh.repository;

import com.board.dh.Entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableArgumentResolver;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    Page<BoardEntity> findByTitleContaining(Pageable pageable, String title);
}
