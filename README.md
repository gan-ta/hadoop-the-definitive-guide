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

## Reference
1. 하둡 완벽 가이드 (톰 화이트)
2. ncdc input 데이터: https://github.com/tomwhite/hadoop-book
