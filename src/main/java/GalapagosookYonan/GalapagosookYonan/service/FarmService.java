package GalapagosookYonan.GalapagosookYonan.service;
import GalapagosookYonan.GalapagosookYonan.dto.PlanTermsDto;
import GalapagosookYonan.GalapagosookYonan.farm.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FarmService {

    @Value("${google.maps.api-key}")
    private String apiKey;
    /**
     * public String getLatLng(String address) {
     * GeoApiContext context = new GeoApiContext.Builder()
     * .apiKey(apiKey)
     * .build();
     * <p>
     * try {
     * GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
     * if (results.length > 0) {
     * double lat = results[0].geometry.location.lat;
     * double lng = results[0].geometry.location.lng;
     * return String.format("Latitude: %s, Longitude: %s", lat, lng);
     * }
     * return "Address not found.";
     * } catch (Exception e) {
     * return "Error fetching geocode: " + e.getMessage();
     * }
     * }
     **/

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
