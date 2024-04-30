package com.board.dh.Service;

import com.board.dh.Entity.BoardEntity;
import com.board.dh.domain.Board;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface BoardService {

    public Page<Board> list(int pageNumber, String search);

    public Board write(Board board);

    public Board read(int idx);

    public Board update(Board board);

    public void delete(int idx);
}
