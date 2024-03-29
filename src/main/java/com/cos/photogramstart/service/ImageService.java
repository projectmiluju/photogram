package com.cos.photogramstart.service;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.domain.image.Image;
import com.cos.photogramstart.domain.image.ImageRepository;
import com.cos.photogramstart.web.dto.image.ImageUploadDto;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Value("${file.path}")
    private String uploadFolder;

    @Transactional
    public void 사진업로드(ImageUploadDto imageUploadDto,
                     PrincipalDetails principalDetails) {

        UUID uuid = UUID.randomUUID();


        String imageFileName = uuid + "_" + imageUploadDto.getFile().getOriginalFilename();
//        System.out.println(imageFileName);
        Path imageFilePath = Paths.get(uploadFolder+imageFileName);
        try {
            Files.write(imageFilePath, imageUploadDto.getFile().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Image image = imageUploadDto.toEntity(imageFileName, principalDetails.getUser());
        imageRepository.save(image);
//        System.out.println(imageEntity);
    }

    @Transactional(readOnly = true)
    public List<Image> 이미지스토리(Integer principalId, Pageable pageable){
        List<Image> images = imageRepository.mStory(principalId, pageable);

        images.forEach((image) -> {

            image.setLikesCount(image.getLikes().size());

            image.getLikes().forEach((like) -> {
                if (Objects.equals(like.getUser().getId(), principalId)){
                    image.setLikesState(true);
                }
            });
        });

        return images;
    }
}
