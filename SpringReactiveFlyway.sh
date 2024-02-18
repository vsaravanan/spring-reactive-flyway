rootdir=`pwd`
jarname=SpringReactiveFlyway
rm -rf $rootdir/logs/*
rm -rf $rootdir/logPath_IS_UNDEFINED
rm -rf /data/logs/SpringReactiveFlyway
# mvn clean package install -Dmaven.test.skip=true -T 1C
## java -jar -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=*:5566,suspend=n -Dspring.profiles.active=dev  ./$jarname.jar
java -jar target/$jarname.jar 

