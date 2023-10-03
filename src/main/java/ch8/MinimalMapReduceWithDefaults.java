package ch8;

import common.JobBuilder;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class MinimalMapReduceWithDefaults extends Configured implements Tool {
    @Override
    public int run(String[] args) throws Exception {
        Job job = JobBuilder.parseInputAndOutput(this, getConf(), args);
        if (job == null) {
            return -1;
        }

        job.setInputFormatClass(TextInputFormat.class); // 기본 입력 포멧

        job.setMapperClass(Mapper.class);

        job.setMapOutputKeyClass(LongWritable.class); // 해당 타입의 key 생성
        job.setMapOutputValueClass(Text.class); // 해당 타입의 value 생성

        job.setPartitionerClass(HashPartitioner.class); // 키로 어느 파티션으로 들어갈지 결정해 주는 함수 (해시를 만들던지 하는 등...)

        // 리듀서 수는 기본적으로 하나이므로, 결국 단일 파티션만 존재하게 됨 (보통 이렇게는 안함, 모든 중간 데이터가 하나로 모이기 떄문)
        // 너무 많이 늘리면 작은 파일이 많이 생성되는 준최적화에 빠지게 됨
        job.setNumReduceTasks(1);
        job.setReducerClass(Reducer.class);

        job.setOutputKeyClass(LongWritable.class);
        job.setOutputValueClass(Text.class);

        job.setOutputFormatClass(TextOutputFormat.class);

        return job.waitForCompletion(true) ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        int exitCode = ToolRunner.run(new MinimalMapReduceWithDefaults(), args);
        System.exit(exitCode);
    }

}
