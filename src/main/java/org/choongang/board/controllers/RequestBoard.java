package org.choongang.board.controllers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestBoard {

    @NotBlank @Size(min=1, max=10) // 제목 : 최소 1자리 최대 10자리
    private String title; // 제목

    @NotBlank @Size(min = 1, max = 30) // 내용 : 최소 1자리 최대 30자리
    private String content; // 내용
}