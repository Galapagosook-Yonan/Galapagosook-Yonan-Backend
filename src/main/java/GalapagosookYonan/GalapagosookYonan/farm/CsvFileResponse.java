//package GalapagosookYonan.GalapagosookYonan.farm;
//
//import org.springframework.context.annotation.Bean;
//
//@Bean
//
//public class CsvFileResponse {
//
//    @Bean
//    @StepScope
//    public FlatFileItemReader<TestCsvFieldVo> csvFileReader() throws Exception {
//        DefaultLineMapper<TestCsvFieldVo> lineMapper = new DefaultLineMapper<>();
//        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
//
//        tokenizer.setNames("id","name","address");
//        lineMapper.setLineTokenizer(tokenizer);
//        lineMapper.setFieldSetMapper(fieldSet -> {
//            int id = fieldSet.readInt("id");
//            String name = fieldSet.readString("name");
//            String address = fieldSet.readString("address");
//
//            return new TestCsvFieldVo(id,name,address);
//        });
//
//        FlatFileItemReader reader = new FlatFileItemReaderBuilder<TestCsvFieldVo>()
//                .name("csvItemReader")
//                .encoding("UTF-8")
//                .resource(new ClassPathResource("infotemp.csv"))
//                .linesToSkip(1)
//                .lineMapper(lineMapper)
//                .build();
//
//        //itemreader에서 필요한 설정들이 제대로 됬는지 검증하는 함수 (throw Exception으로 넘김)
//        reader.afterPropertiesSet();
//
//        return reader;
//    }
//}
