package com.board.dh.Service.Impl;

import com.board.dh.Entity.BoardEntity;
import com.board.dh.Service.BoardService;
import com.board.dh.domain.Board;
import com.board.dh.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Page<Board> list(int pageNumber, String search) {
        Sort sort = Sort.by(Sort.Direction.DESC, "idx");
        Pageable pageable = PageRequest.of(pageNumber, 10, sort);

        Page<BoardEntity> page = null;

        if(search == null){
            page = boardRepository.findAll(pageable);
        }else {
            page = boardRepository.findByTitleContaining(pageable, search);
        }
        return page.map(Board::toDomain);
    }

    @Override
    public Board write(Board board) {
        BoardEntity boardEntity = Board.toEntity(board);
        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm");
        Date date = new Date();
        boardEntity.setWriteTime(dateFormat.format(date));
        boardRepository.save(boardEntity);
        return board;
    }

    @Override
    public Board read(int id) {
        BoardEntity entity = boardRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Post not found"));
        return Board.toDomain(entity);
    }

    @Override
    public Board update(Board board) {
       BoardEntity entity = Board.toEntity(board);
        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm");
        Date date = new Date();
        entity.setWriteTime(dateFormat.format(date));
        boardRepository.save(entity);
        return board;
    }

    @Override
    public void delete(int idx) {
        boardRepository.deleteById(idx);
    }
}
