FROM openjdk:8-jre-slim

# Add the jar with all the dependencies
# Maven creates container-test.jar in the target folder of my workspace.
# We need this in some location - say - /usr/share/tag folder of the container

WORKDIR /usr/share/tag

#ADD  target/ICU-2.0.7-icu.jar /usr/share/tag/container-test.jar
#ADD testng.xml /usr/share/tag/testng.xml
#ADD  target/ICU-2.0.7-icu.jar selenium-docker.jar
ADD  target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD  target/libs libs

# Add the suite xmls
ADD testng.xml testng.xml
#ADD search-module.xml search-module.xml

#ENV SELENIUM_HUB=10.100.11.70

# Command line to execute the test
CMD ["java", "-cp","/usr/share/tag/container-test.jar","-DseleniumHubHost=$SELENIUM_HUB","-Dbrowser=chrome", "org.testng.TestNG","testng"]
#/usr/local/openjdk-8/bin/java, -cp, /usr/share/tag/container-test.jar, -DseleniumHubHost=$SELENIUM_HUB -Dbrowser=$BROWSER org.testng.TestNG,  /usr/share/tag/$TESTNG]