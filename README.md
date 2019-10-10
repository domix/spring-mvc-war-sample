# spring-mvc-war-sample

Este es un sencillo ejemplo de una aplicación `Spring MVC` sin `Spring Boot` que genera un archivo `War ` listo para ser desplegado en cualquier `Servlet Container`, como `JBoss EAP 7.2`

## Ejecutar la aplicación de forma local

Podemos ejecutar la aplicación de forma local con la siguiente instrucción:

```
./gradlew appRun
13:11:23 INFO  1 Spring WebApplicationInitializers detected on classpath
13:11:23 INFO  Initializing Spring DispatcherServlet 'dispatcher'
Oct 10, 2019 1:11:23 PM org.springframework.web.servlet.FrameworkServlet initServletBean
INFO: Initializing Servlet 'dispatcher'
Oct 10, 2019 1:11:23 PM org.springframework.web.servlet.FrameworkServlet initServletBean
INFO: Completed initialization in 525 ms
13:11:23 INFO  Jetty 9.2.22.v20170606 started and listening on port 8080
13:11:23 INFO  spring-mvc-war-sample runs at:
13:11:23 INFO    http://localhost:8080/spring-mvc-war-sample

> Task :appRun
Press any key to stop the server.
<===========--> 87% EXECUTING [10s]
> :appRun
```

La aplicación estará lista para ser usada en [esta ubicación](http://localhost:8080/spring-mvc-war-sample)

## Construir la aplicación

Se puede construir la `war ` con la siguiente instrucción:

```
$ ./gradlew clean war
```

Podremos ver la `war ` generada en el directorio `./build/libs/`

```
$ ls -lh build/libs
total 11096
-rw-r--r--  1 domix  staff   5.4M Oct 10 13:08 spring-mvc-war-sample.war
```

Ese archivo `war ` se puede desplegar en cualquier `Servlet Container`.


## Ejecutar la aplicación como Contenedor (Docker)

Es posible ejecutar la aplicación `War` dentro de un `Servlet Container` como `JBoss EAP 7.2` empacada como una imagén de contener `OCI`.

### Generando la imagén OCI

**ATENCIÓN**: Para poder generar la imagen del contenedor, se debe poder tener acceso al `Registry` de `RedHat`, [en este documento se describe como tener acceso](https://catalog.redhat.com/software/containers/search)


```
$ docker build -t domix/spring-mvc-war-sample:0.0.1 .
Sending build context to Docker daemon   8.08MB
Step 1/5 : FROM registry.redhat.io/jboss-eap-7/eap72-openjdk11-openshift-rhel8
 ---> 56a905695bb5
Step 2/5 : COPY build/libs/spring-mvc-war-sample.war $JBOSS_HOME/standalone/deployments/
 ---> Using cache
 ---> ee268789e1b0
Step 3/5 : USER root
 ---> Using cache
 ---> 62a1027b049d
Step 4/5 : RUN chown -R jboss:jboss $JBOSS_HOME/standalone/deployments/spring-mvc-war-sample.war
 ---> Using cache
 ---> 72d3418e1cad
Step 5/5 : USER jboss
 ---> Using cache
 ---> a5c7d50814e7
Successfully built a5c7d50814e7
Successfully tagged domix/spring-mvc-war-sample:0.0.1
```


### Ejecutando la aplicación

```
$ docker run --rm -p 8080:8080 -p 9990:9990 domix/spring-mvc-war-sample:0.0.1
```