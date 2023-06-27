package com.ohgiraffers.mtvsreserve.board.domain.repository;

import com.ohgiraffers.mtvsreserve.board.domain.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
