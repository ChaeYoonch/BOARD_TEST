package org.choongang.board.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.board.entities.Board;
import org.choongang.board.services.BoardDeleteService;
import org.choongang.board.services.BoardListService;
import org.choongang.board.services.BoardSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardListService boardListService; // 게시글 목록 연동
    private final BoardSaveService boardSaveService; // 게시글 저장 연동
    private final BoardDeleteService boardDeleteService; // 게시글 삭제 연동

    /* main.html : 게시글 메인 페이지 | list.html : 게시글 목록 페이지 | write.html : 게시글 등록 페이지 | update.html : 게시글 수정 페이지 */

    // 게시글 조회 1
    @GetMapping("/list")
    public String list(Model model) {
        List<Board> board = boardListService.getBoard(); // BoardListService 연동 -> 1번째
        model.addAttribute("board", board);

        return "board/list";
    }

    // 게시글 조회 2
    @GetMapping("/board/{id}")
    public String eachBoard(@PathVariable("id")Long id, Model model) {
        Board board = boardListService.getBoards(id); // BoardListService 연동 -> 2번째
        model.addAttribute("board", board);

        return "board/main";
    }

    // 게시글 등록
    @GetMapping("/write")
    public String writeBoard(Model model) {
        model.addAttribute("board", new Board());

        return "board/write";
    }

    // 게시글 수정
    @GetMapping("/update/{id}")
    public String changeBoard(@PathVariable("id") Long id, Model model) {
        Board board = boardListService.getBoards(id); // id 로 조회
        model.addAttribute("board", board);

        return "board/update";
    }

    // 게시글 삭제
    @GetMapping("/delete/{id}")
    public String deleteBoard(@PathVariable("id") Long id, Model model) {
        boardDeleteService.delete(id); // BoardDeleteService 연동

        return "board/main";
    }

    // 게시글 저장
    @PostMapping("/save")
    public String saveBoard(@ModelAttribute Board board) {
        if (board.getId() != null && boardListService.getBoards(board.getId()) != null) {
            boardSaveService.save(board); // BoardSaveService 연동
        } else {
            boardSaveService.save(board); // BoardSaveService 연동
        }

        return "redirect:/board/list";
    }
}