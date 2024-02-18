mvn clean package install -Dmaven.test.skip=true -T 1C
# sudo service spring-reactive-flyway restart
pm2 restart SpringReactiveFlyway
tail -f /data/logs/spring-reactive/*
