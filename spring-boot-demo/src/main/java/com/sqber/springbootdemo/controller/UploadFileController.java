package com.sqber.springbootdemo.controller;

import com.sqber.springbootdemo.base.R;
import com.sqber.springbootdemo.base.UploadFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ValidationException;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.IOException;
import java.util.List;

@RestController
public class UploadFileController {

    @PostMapping("/test/file")
    public R batAddUser(@NotEmpty(message = "文件不能为空") @RequestParam("file") MultipartFile[] files) throws IOException {
        String savePath = System.getProperty("user.dir");
        List<String> fileList = UploadFile.createExcelUploadForExcel(savePath, files).save();
        return R.success(fileList);
    }

    @PostMapping("/test/file2")
    public R batAddUser(@NotBlank(message = "name不能为空") String name, @RequestParam("file") MultipartFile[] files) throws IOException {

        List<String> fileList = createFileUpload(files).save();
        return R.success(fileList);
    }

    private UploadFile createFileUpload(MultipartFile[] files) {
        String savePath = System.getProperty("user.dir");

        return new UploadFile(savePath, files, (fileName, ext, fileSize) -> {
            if (!ext.equals("xls") && !ext.equals("xlsx")) {
                throw new ValidationException(String.format("%s 类型不对。请上传 xls 或 xlsx 类型的文件", fileName));
            }
            long fileSizeM = (fileSize / 1024 / 1024);
            long sizeLimit = 1;
            if (fileSizeM > sizeLimit) {
                throw new ValidationException(String.format("%s(%sM) 文件不能大于%sM", fileName, fileSizeM, sizeLimit));
            }
        });
    }
}