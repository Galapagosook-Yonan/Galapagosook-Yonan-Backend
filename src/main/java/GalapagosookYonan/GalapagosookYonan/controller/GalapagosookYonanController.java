package GalapagosookYonan.GalapagosookYonan.controller;

import GalapagosookYonan.GalapagosookYonan.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class GalapagosookYonanController {
    public final FarmService farmService;


    @PostMapping("/upload")
    public ResponseEntity<?> uploadCSVFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a CSV file to upload.");
        } else {
            boolean uploadStatus = farmService.uploadCSVFile(file);
            if (uploadStatus) {
                return ResponseEntity.ok("File uploaded successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file.");
            }
        }
    }
}
