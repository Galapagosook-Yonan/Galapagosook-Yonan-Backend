package GalapagosookYonan.GalapagosookYonan.service;

import GalapagosookYonan.GalapagosookYonan.dto.PlanTermsDto;
import GalapagosookYonan.GalapagosookYonan.farm.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FarmService {

    public final PlanRepository planRepository;
    @Transactional
    public boolean uploadCSVFile(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            try (InputStream inputStream = file.getInputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split("!"); // CSV 파일의 각 라인을 쉼표로 분리
                    if (data.length > 0) {
                        PlanTermsDto planTermsDto = PlanTermsDto.builder().build();
                        for (int i=0; i<4; i++) {
                            String value = data[i]; // 예를 들어 첫 번째 열에 이름이 있다고 가정
                            switch (i) {
                                case 0:
                                    planTermsDto.setTitle(value);
                                    continue;
                                case 1:
                                    if (value.length() > 50) {
                                        // 500자 이상이면 ...으로 잘라내어 설정
                                        planTermsDto.setDescription(value.substring(0, 50) + "...");
                                    } else {
                                        // 500자 이하이면 그대로 설정
                                        planTermsDto.setDescription(value);
                                    }
                                    continue;
                                case 2:
                                    if (value.length() > 50) {
                                        planTermsDto.setDetails(value.substring(0, 50) + "...");
                                    } else {
                                        planTermsDto.setDescription(value);
                                    }
                                    continue;
                                case 3:
                                    if (value.length() > 50) {
                                        planTermsDto.setImage_url(value.substring(0, 50) + "...");
                                    } else {
                                        planTermsDto.setDescription(value);
                                    }
                            }
                        }
                        planRepository.save(planTermsDto.toEntity());
                    }
                }
            }
        }
        return true;
    }
}
