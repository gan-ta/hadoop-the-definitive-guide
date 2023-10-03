# hadoop-the-definitive-guide
하둡 완벽 가이드 예제 정리 저장소입니다.
## 설정
- hadoop 2.10.2 버전으로 실습 진행
- hadoop download: https://hadoop.apache.org/release/2.10.2.html

## 2장
1. mvn package로 jar 파일 생성
2. target 폴더 jar 파일 확인 및 다음과 같은 명령어 실행
```
 HADOOP_CLASSPATH=hadoop-the-definitive-guide-1.0-SNAPSHOT.jar
 hadoop ch2.MaxTemperature ../input/ncdc/sample.txt output 
```
3. target 폴더 output 디렉토리에서 결과물 확인

## 3장
1. 로컬에 하둡 의사분산 모드로 실행 (./conf/...-site.xml 파일 참고)
2. 로컬에 있는 데이터 hdfs로 카피
```
hadoop fs -copyFromLocal ./input/docs/quangle.txt hdfs://localhost/usr/$USER/quangle.txt
```
3. 하둡 URL로 파일 내용 출력
```
hadoop ch3.URLCat hdfs://localhost/usr/$USER/quangle.txt
```
4. FileSystem API를 이용한 파일 내용 출력
```
hadoop ch3.FileSystemCat hdfs://localhost/usr/$USER/quangle.txt
```
5. seek를 이용한 파일 내용 2번 출력
```
hadoop ch3.FileSystemDoubleCat hdfs://localhost/usr/$USER/quangle.txt
```
6. 로컬 파일을 하둡 파일시스템으로 복사
```
hadoop ch3.FileCopyWithProgress ../input/docs/1400-8.txt hdfs://localhost/usr/$USER/1400-8.txt
```
7. 하둡 파일시스템 경로 집합에 대한 파일 상태 보기
```
hadoop ch3.ListStatus hdfs://localhost/ hdfs://localhost/usr/$USER
```

## 5장
<독립 모드 수행> <br />
1. Text 문자열을 압축하고 gunzip을 사용하여 표준 입력으로부터 압축 해제
```
echo "Text" | hadoop ch5.StreamCompressor org.apache.hadoop.io.compress.GzipCodec | gunzip -
```
2. codec을 path 명으로 찾고 압축 해제
```
hadoop ch5.FileDecompressor /Users/kimheesup/Desktop/hadoop-the-definitive-guide/input/codec/file.gz
```

## 6장
1. conf 파일을 적용한 hadoop fs 명령어
```
hadoop fs -conf conf/hadoop-localhost.xml -ls .
```
2. conf 파일 내용 확인
```
hadoop ch6.ConfigurationPrinter -conf ../input/conf/hadoop-localhost.xml | grep yarn.resourcemanager.address=
```
3. 개별 속성 지정 (기본 값 정의 위에 새롭게 값을 정의 가능)
```
hadoop ch6.ConfigurationPrinter -D color=yellow | grep color 
```
4. 유닛테스트 후 로컬에서 잡 테스트 (독립모드)
```
hadoop ch6.MaxTemperatureDriver -conf ../input/conf/hadoop-local.xml ../input/ncdc/micro/sample.txt ../output
hadoop ch6.MaxTemperatureDriver -fs file:/// -jt local ../input/ncdc/micro/sample.txt ../output
```

## 8장
1. 심플한 맵 리듀스 잡 실행
```
hadoop ch8.MinimalMapReduce "../input/ncdc/all/190{1,2}.gz" ../output
```

## 9장
1. 카운터 적용
```
hadoop jar hadoop-the-definitive-guide-1.0-SNAPSHOT.jar ch9.MaxTemperatureWithCounters ../input/ncdc/all ../output-counters
```
2. 카운터 반환
```
hadoop jar hadoop-the-definitive-guide-1.0-SNAPSHOT.jar ch9.MissingTemperatureFields ${JOB_ID}
```

## Reference
1. 하둡 완벽 가이드 (톰 화이트)
2. input 데이터: https://github.com/tomwhite/hadoop-book
