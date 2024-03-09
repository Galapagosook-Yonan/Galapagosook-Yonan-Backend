package GalapagosookYonan.GalapagosookYonan.farm;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CsvFarmWriter implements ItemWriter<FarmDto> {
    private final FarmRepository farmRepository;

    @Override
    public void write(Chunk<? extends FarmDto> items) throws Exception {
        List<Farm> scheduleList = new ArrayList<>();

        items.forEach(getScheduleDto -> {
            Farm schedule = getScheduleDto.toEntity();
            scheduleList.add(schedule);
        });

        farmRepository.saveAll(scheduleList);
    }
}
