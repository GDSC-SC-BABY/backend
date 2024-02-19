package com.example.scbaby.Controller;

import com.example.scbaby.Model.DTO.Image.UrlListRes;
import com.example.scbaby.Model.DTO.Image.UrlRes;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class ImageController {

    private final ImageService ImageService;

    @Operation(summary = "사진 업로드")
    @PostMapping(value = "/Image",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UrlRes uploadImage(@RequestBody MultipartFile file) throws IOException {
        return ImageService.uploadImage(file);
    }

    @Operation(summary = "사진 리스트 업로드")
    @PostMapping(value = "/Image",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UrlListRes uploadImageList(@RequestBody List<MultipartFile> file) throws IOException {
        return ImageService.uploadImageList(file);
    }

    @Operation(summary = "사진 리스트 업데이트")
    @PostMapping(value = "/Image",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UrlListRes updateImageList(@RequestBody List<MultipartFile> file) throws IOException {
        return ImageService.updateImageList(file);
    }
}
