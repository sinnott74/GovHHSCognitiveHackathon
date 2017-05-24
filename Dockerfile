# For reference only

FROM websphere-liberty
ADD target/GovHHSCognitiveHackathon.war /opt/ibm/wlp/usr/servers/defaultServer/dropins/
ENV LICENSE accept
EXPOSE 9080

## Running the container locally
# mvn clean install
# docker build -t GovHHSCognitiveHackathon .
# docker run -d --name myjavacontainer GovHHSCognitiveHackathon
# docker run -p 9080:9080 --name myjavacontainer GovHHSCognitiveHackathon
# Visit http://localhost:9080/GovHHSCognitiveHackathon/

## Push container to Bluemix
# Install cli and dependencies: https://console.ng.bluemix.net/docs/containers/container_cli_cfic_install.html#container_cli_cfic_install
# docker tag GovHHSCognitiveHackathon registry.ng.bluemix.net/<my_namespace>/GovHHSCognitiveHackathon
# docker push registry.ng.bluemix.net/<my_namespace>/GovHHSCognitiveHackathon
# bx ic images # Verify new image
