# How to use
- Run build of project `./gradlew clean build`
- Publish SDK to maven local `./gradlew publishToMavenLocal`
- Inject dependency `implementation 'com.andrew.lewis.sdk:andrew-lewis-sdk'`

# How to test
- Run `gradlew test`. Tests are written to hit actual API (make sure to remember to update auth token in `application.properties`)