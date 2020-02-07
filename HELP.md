
# Programming exercise requirements
This exercise is to use NASA Open APIs described [here](https://api.nasa.gov) to build a project in GitHub that calls the Mars Rover API and selects a picture on a given day. We want your application to download and store each image locally.

### Acceptance Criteria

* Please send a link to the GitHub repo via <matt.hawkes@livingasone.com> when you are complete.
* Use list of dates below to pull the images were captured on that day by reading in a text ﬁle:
    * 02/27/17
    * June 2, 2018
    * Jul-13-2016
    * April 31, 2018
* Language needs to be *Java*.
* We should be able to run and build (if applicable) locally after you submit it
* Include relevant documentation (.MD, etc.) in the repo

### Bonus 

* Bonus - Unit Tests, Static Analysis, Performance tests or any other things you feel are important for Deﬁnition of Done
* Double Bonus - Have the app display the image in a web browser
* Triple Bonus – Have it run in a Docker or K8s (Preferable)


# Solutions

This application will call NASA open API to retrieve image's info on a given day

* Image info contains: title, explanation, imageUrl, image and so on; 
  We store varieties of image attributes on our application cache;

* The cache server TTL and max objects to be cached is configurable in the application configuration.

* When clients make the same request, our server will retrieve image info from cache.


### Steps to build and run application 
* Pre-requisites: 
    * Install [JDK 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
    * Install [docker desktop](https://www.docker.com/products/docker-desktop)
    * Install Maven
* Download this application using git clone or download directly zip file.
* Get into the root directory of this project and then run: mvn clean install
* (Optional) this step is optional; In case you want to run Springboot application using docker image
    * mvn clean install: the docker image will be built using docker maven plugin
    * docker run -it [imageId]: run application in interactive mode in the container using port 8082

### Steps to test 
*Here are the APIs available 


*Also you can test our APIs directly using our Swagger via this link after you start our application
 
### Technologies/Framework used

* Springboot
* Java 8
* lambok: remove boiler plate codes
* Mockito: Unit test
* SonarLint: static Analysis
* Spring Test: integration testing
* Spring Cache, Caffeine: Caching
* Docker: containerized plateform
* Git: source repositories
* 
 
###Future Improvement

* Provided API needs to implement security: Authenticate client using API_KEY and access_token

