# MCIT ONLINE FLEA MARKET

## Overview

### Project summary

Youtube demo video: https://youtu.be/FiKS6F8g29s


This project is based on Spring boot + Thymeleaf + MongoDB + Bootstrap + Javasript 


This online flea market is not ONLY about online trasaction or shopping, instead, I hope this can provide a platform to meet fellow students, so all trasactions happen face to face. 
Inspired by a post on our #community channel on slack (a student passed her textbook after using for a semester to someone who needs it and also lives in the same area), I think passing and selling your used textbooks can be a great way to meet fellow students. It is not only true for MCIT program but for all programs and schools, as we are all social distancing in the pandenmic, a traditional on-campus flea market is no longer feasible, therefore I came up with this platform, on which each transaction only takes 2 people to complete, so it's easy to SOCIAL and SOCIAL DISTANCING.

Include the link to your Devpost project page here: [Devpost](https://devpost.com/software/mcit-online-flea-market)

### Authors

Ziwei Ran - ziweiran – ziweiran@seas.upenn.edu – [GitHub](https://github.com/ziweiran)


## Usage

This section walks a prospective user through the process of installing and running the project on their local machine. The more detailed and the more accurate, the better. User-friendly instructions will entice prospective users (including judges) to engage more deeply with your project, which could improve your hackathon score.

### Prerequisites

What prerequisites must be installed in order to run your project, and how do you install them?
1. JDK 11
2. Apache Maven
3. MongoDB

#### for Apache Maven: 
download : https://maven.apache.org/download.cgi mac users can download the bin.tar.gz version.
check out this tutorial for installation:  https://www.tutorialspoint.com/maven/maven_environment_setup.htm or follow this video: https://www.youtube.com/watch?v=j0OnSAP-KtU
Last, verify correct installation on Mac:
```
mvn --version
```
output will be somthing like this: 
Apache Maven 3.3.1 (r801777; 2009-08-07 00:46:01+0530)
Java version: 1.7.0_60
Java home: C:\Program Files\Java\jdk1.7.0_60 \jre

#### for MongoDB
If you use a Mac with Homebrew, you can run the following command:
```
$ brew install mongodb
```
After you install MongoDB, you can launch it in a console window by running the following command (which also starts up a server process):
```
$ mongod
```


### Deployment

After installing MongoDB, you need in import data into it, otherwise, you'll have NO items to display on the webpage (the app will still work in this case, just empty pages).
for this step, I recommend download MongoDB compass: https://www.mongodb.com/try/download/compass it's great visulization of database like this, and allows you to access/edit data directly: 
![alt text](https://www.google.com/url?sa=i&url=https%3A%2F%2Fdocs.mongodb.com%2Fcompass%2Fmaster%2Fquery%2Fskip%2F&psig=AOvVaw05R0Dx83Y2R-koC7WjKgIv&ust=1598920683166000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJjZiu2ZxOsCFQAAAAAdAAAAABAD)

#### import data into your database:
 1.open MongoDB compass, after username and password, choose localhost:27017 and then connect.
 2. Now you're officially in your database. Click on "CREATE DATABASE" green button to create a database called "fleamarket". **please use the exact same database name, case sensetive**.
 3. Click on the fleamarket database you just created, then click on "CREATE COLLECTION" to create collection called "item".**please use the exact same database name, case sensetive**. Open item, now your database should have a header **fleamarket.item**. 
 4. Click on "ADD DATA, import file", select JSON, then upload the file "data.json" from git repository. (in same folder with README)
 5. Done! your database now should filled with sample data. 


#### After installing and configuring Maven and MongoDB, you can download the .jar file from the target folder, and run on your command line like this: 
```
java -jar target/gs-accessing-data-mongodb-0.1.0.jar
```
#### final step: open up your browser and enter: localhost:8080

a screeshot of one of the page from this web app:
![alt text](https://challengepost-s3-challengepost.netdna-ssl.com/photos/production/software_photos/001/203/524/datas/original.png)

Bravo!


### Tools used

Which frameworks, libraries, or other tools did you use to create your project?

* [Tool 1](https://maven.apache.org/) - Maven is used to build and manage this project
* [Tool 2](https://spring.io/projects/spring-boot) - Spring Boot is an open source Java-based framework I used to develop my web app.
* [Tool 3](https://www.thymeleaf.org/) - Thymeleaf is a modern server-side Java template engine for both web and standalone environments, I used it so that HTML can have plug in my own functionality. [more on Thymeleaf](https://www.tutorialspoint.com/spring_boot/spring_boot_thymeleaf.htm)
* [Tool 4](https://www.mongodb.com/) - MongoDB is used for database, version: community server (free)


### Acknowledgments

Use anyone else's code? Inspired by a particular project? List / link here.

* UI design inspired by https://templatemo.com/


### License


>This package is licensed under the GNU General Public License v3.0 (<a href="https://choosealicense.com/licenses/gpl-3.0/" target="_blank">GPL-3</a>).
