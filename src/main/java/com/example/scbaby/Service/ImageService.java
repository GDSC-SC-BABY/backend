package com.example.scbaby.Service;

import com.example.scbaby.Bean.ImageBean.ImageListUpdateBean;
import com.example.scbaby.Bean.ImageBean.ImageListUploadBean;
import com.example.scbaby.Bean.ImageBean.ImageUploadBean;
import com.example.scbaby.Model.DTO.Image.UrlListRes;
import com.example.scbaby.Model.DTO.Image.UrlRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageUploadBean imageUploadBean;
    private final ImageListUploadBean imageListUploadBean;
    private final ImageListUpdateBean imageListUpdateBean;

    public UrlRes uploadImage(MultipartFile file) throws IOException {
        return UrlRes.builder().ImageUrl(imageUploadBean.exec(file)).build();
    }

    public UrlListRes uploadImageList(List<MultipartFile> file) throws IOException {
        return UrlListRes.builder().ImageUrl(imageListUploadBean.exec(file)).build();
    }

    public UrlListRes updateImageList(List<MultipartFile> file) throws IOException {
        return UrlListRes.builder().ImageUrl(imageListUpdateBean.exec(file)).build();
    }

}
