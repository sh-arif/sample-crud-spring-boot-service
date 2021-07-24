FROM openjdk:11
COPY target/sample-service.jar sample-service.jar
COPY entrypoint.sh entrypoint.sh
COPY getContainerIp.py getContainerIp.py
RUN chmod +x entrypoint.sh ; chmod +x getContainerIp.py
EXPOSE 8088
ENTRYPOINT ./entrypoint.sh alpha
