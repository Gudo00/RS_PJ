package org.gudo.backend.common.controller;

import lombok.RequiredArgsConstructor;
import org.gudo.backend.util.FileUploadUtil;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class FileViewController {

    private final FileUploadUtil fileUploadUtil;

    @GetMapping("/view/{fileName}")
    public ResponseEntity<Resource> viewFile(@PathVariable String fileName) {

        return fileUploadUtil.getFile(fileName);
    }
}
