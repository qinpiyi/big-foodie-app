#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -U

docker build -t registry.cn-beijing.aliyuncs.com/qinpiyi/eureka .

docker push registry.cn-beijing.aliyuncs.com/qinpiyi/eureka