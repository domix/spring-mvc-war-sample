FROM registry.redhat.io/jboss-eap-7/eap72-openjdk11-openshift-rhel8

# Copy war to deployments folder
COPY build/libs/spring-mvc-war-sample.war $JBOSS_HOME/standalone/deployments/

# User root to modify war owners
USER root

# Modify owners war
RUN chown -R jboss:jboss $JBOSS_HOME/standalone/deployments/

# Important, use jboss user to run image
USER jboss