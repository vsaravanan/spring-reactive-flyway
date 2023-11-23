mvn clean package install -Dmaven.test.skip=true -T 1C
sudo service spring-reactive-flyway restart
tail -f /data/logs/spring-reactive/*
