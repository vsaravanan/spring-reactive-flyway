git pull
mvn clean package install -Dmaven.test.skip=true -T 1C
pm2 restart SpringReactiveFlyway
tail -f /data/logs/SpringReactiveFlyway/*
