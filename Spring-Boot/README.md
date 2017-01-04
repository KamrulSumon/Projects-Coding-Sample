=====Description=====

This project will generate a plain web page listing a set of animals and their characteristics.

We're going to ask you to add the required code to add a page where the animals are rated and shown in order.
This page should support rating all animals, or rating only the animals of a user-selected type.

===== Setup and Run Commands =====

-- Install maven
See the instructions at http://maven.apache.org/install.html .
Or, use your existing package manager (e.g., brew install maven).

-- Build
cd to your unzip location of candidate-exercise
mvn package

-- Run
java -jar target/candidate.exercise-1.0.0.jar

-- View
Project should be deployed to localhost:8080 .

===== Resources =====

This project is built using SpringBoot and Thymeleaf.


===== Business Logic for Determining Rating =====

Animals have four characteristics (all integers): offense, defense, health, and items.

Animals are rated based on summing the values of the animal's characteristics using the following business logic:

1. Offense: weighted twice as much as the other three characteristics, and one point lost per item the animal is carrying.
2. Defense: value as is.
3. Health: If the animal's defense is less than 10, their health is halved and rounded up to the nearest integer.
4. Items: have no value.

Sum the results of applying the previous logic for each animal. The highest rated animal is the one with the highest total point value. Two or more
 animals may have the same rating, and an animal may have a rating less than zero.


===== Goals =====

1. Add another page similar to the one displayed by home.htm at /rate .
2. Add a way for a user to select either a single animal type or all animal types.
3. Rate the animals in the user-selected group using the above business logic.
4. Display the animals in the user-selected group, their characteristics, and their ratings on the /rate page, ordered by highest rated animal to lowest rated animal.
5. Calculate and display some statistics on the user-selected group: minimum rating, maximum rating, and average rating.


===== Deliverables =====

1. A brief description of your approach to the task, including any assumptions you made or known issues with your code.
2. Zipped candidate-exercise containing your work. If your zip file is too large, you can delete the contents of candidate-exercise/target before zipping to reduce the size.
3. Copy of versioning log if applicable
