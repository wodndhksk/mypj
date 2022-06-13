package com.example.mypj.content;

import com.example.mypj.DTO.ContentsDto;
import com.example.mypj.database.entity.Contents;
import com.example.mypj.database.repository.ContentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContentsService {
    private final ContentsRepository contentsRepository;

    public List<Contents> contentList(){
        return contentsRepository.findAll();
    }
    Optional<Contents> selectOneById(Long id){ return contentsRepository.findById(id); }

    public void saveContents(ContentsDto contentsDto){
        Contents contents = Contents.builder()
                .title(contentsDto.getInputTitle())
                .description(contentsDto.getInputDescription())
                .thumbnailImageUrl(contentsDto.getInputImageUrl())
                .build();
        contentsRepository.save(contents);
    }
    public void updateContents(ContentsDto contentsDto, Long idx){
        Contents contents = Contents.builder()
                .id(idx)
                .title(contentsDto.getInputTitle())
                .description(contentsDto.getInputDescription())
                .thumbnailImageUrl(contentsDto.getInputImageUrl())
                .build();
        contentsRepository.updateContents(contents);
    }
}
