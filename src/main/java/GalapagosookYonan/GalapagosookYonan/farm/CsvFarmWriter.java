package GalapagosookYonan.GalapagosookYonan.farm;

import GalapagosookYonan.GalapagosookYonan.entity.FarmEntity;
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
        List<FarmEntity> scheduleList = new ArrayList<>();

        items.forEach(getScheduleDto -> {
            FarmEntity schedule = getScheduleDto.toEntity();
            scheduleList.add(schedule);
        });

//        farmRepository.saveAll(scheduleList);
    }
}
