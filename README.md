**Requirements**
-----------------
- Git
- Node.js with NPM
- Maven
- Java 8

**Installation and Running Dev**
-----------------
- git clone <repository_url>
- cd count-me-up
- mvn spring-boot:run
- cd src/main/vue
- npm install
- npm run dev

the back-end will run on localhost:8080 and front-end on localhost:8081
we can use swagger on localhost:8080/swagger-ui.html to submit the vote (under "vote-controller")
the front-end will fetched vote result every 1s

**Unit test**
-------------
Unit test is located under /src/test/

**Dev Journey**
--------------
- The idea is to do a quick-count. Once a vote is received, will be directly counted to the atomic voteResult
- I mistakenly use Set for the list of candidates a voter had voted, and realized that the criteria allows the same candidate to be voted by the same voter (max 3x)
- The unit testing is still lacked of concurrency testing