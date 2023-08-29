# hadoop-the-definitive-guide

## 설정
- hadoop 2.10.2 버전으로 실습 진행
- hadoop download: https://hadoop.apache.org/release/2.10.2.html

## 2장
1. mvn package로 jar 파일 생성
2. target 폴더 jar 파일 확인 및 다음과 같은 명령어 실행
```
 HADOOP_CLASSPATH=hadoop-the-definitive-guide-1.0-SNAPSHOT.jar
 hadoop MaxTemperature ../input/ncdc/sample.txt output 
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
hadoop URLCat hdfs://localhost/usr/$USER/quangle.txt
```
4. FileSystem API를 이용한 파일 내용 출력
```
hadoop FileSystemCat hdfs://localhost/usr/$USER/quangle.txt
```
5. seek를 이용한 파일 내용 2번 출력
```
hadoop FileSystemDoubleCat hdfs://localhost/usr/$USER/quangle.txt
```
6. 로컬 파일을 하둡 파일시스템으로 복사
```
hadoop FileCopyWithProgress ../input/docs/1400-8.txt hdfs://localhost/usr/$USER/1400-8.txt
```
7. 하둡 파일시스템 경로 집합에 대한 파일 상태 보기
```
hadoop ListStatus hdfs://localhost/ hdfs://localhost/usr/$USER
```

## Reference
1. 하둡 완벽 가이드 (톰 화이트)
2. input 데이터: https://github.com/tomwhite/hadoop-book
