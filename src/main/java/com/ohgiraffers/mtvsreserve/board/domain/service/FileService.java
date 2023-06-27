package com.ohgiraffers.mtvsreserve.board.domain.service;

import com.ohgiraffers.mtvsreserve.board.domain.entity.File;
import com.ohgiraffers.mtvsreserve.board.domain.repository.FileRepository;
import com.ohgiraffers.mtvsreserve.board.domain.dto.FileDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FileService {
    private FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Transactional
    public Long saveFile(FileDTO fileDTO) {
        return fileRepository.save(fileDTO.toEntity()).getId();
    }

    @Transactional
    public FileDTO getFile(Long id) {
        File file = fileRepository.findById(id).get();

        FileDTO fileDTO = FileDTO.builder()
                .id(id)
                .origFilename(file.getOrigFilename())
                .filename(file.getFilename())
                .filePath(file.getFilePath())
                .build();
        return fileDTO;
    }
}
