
# Programming exercise requirements
This exercise is to use NASA Open APIs described [here](https://api.nasa.gov) to build a project in GitHub that calls the Mars Rover API and selects a picture on a given day. We want your application to download and store each image locally.

### Acceptance Criteria

* Use list of dates below to pull the images were captured on that day by reading in a text ﬁle:
    * 02/27/17
    * June 2, 2018
    * Jul-13-2016
    * April 31, 2018
* Language needs to be *Java*.
* We should be able to run and build (if applicable) locally after you submit it
* Include relevant documentation (.MD, etc.) in the repo

### Bonus 

* Bonus - Unit Tests, Static Analysis, Performance tests or any other things you feel are important for deﬁnition of Done
* Double Bonus - Have the app display the image in a web browser
* Triple Bonus – Have it run in a Docker or K8s (Preferable)


# Solutions

This application will call NASA open API to retrieve image's info on a given day

* Image info contains: title, explanation, imageUrl, image and so on; 
  We store varieties of image attributes on our application cache
* When clients make the same request, our server will retrieve image info from cache instead of NASA open API.
* Cache TTL and max objects to be cached is configurable in properties file

### Steps to build and run application 
* Pre-requisites: 
    * Install [JDK 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
    * Install [docker desktop](https://www.docker.com/products/docker-desktop)
    * Install Maven
* Download this application using git clone or download directly zip file
* Get into the root directory of this project and then run: mvn spring-boot:run
* (Optional) this step is optional; In case you want to run Springboot application using docker image
    * mvn clean install : the docker image will be built using docker maven plugin
    * docker run -it [imageId]: run application in interactive mode in the container using port 8082

### Steps to test 

* Here is the API available 
    * get image by date: [http://localhost:8082/images?date=2020-2-5]


* Also you can test our APIs directly using our Swagger via this [link](http://localhost:8082/api/v1/swagger-ui.html) after you start our application
 
### Technologies/Frameworks

* Springboot
* Java 8
* Lambok: remove boiler-plate codes in POJO classes
* Mockito: Unit test
* SonarLint: static analysis
* Spring Test: integration testing
* Spring Cache, Caffeine: Caching
* Docker: containerized plate-form
* Github: codes repositories
* Swagger: APIs documentation
 
###Future Improvement

* These APIs need to implement security: Authenticate client using API Key and access token
* It will be nice to have UI which can display this image information
