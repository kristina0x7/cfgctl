# cfgctl - config control

Config-as-Code backend written in Java with Gradle, using Git as the source of truth. This tool helps you deploy, track, and rollback configuration files for different environments (prod/dev/staging) in a structured way.


###### **Gradle installed (or use the wrapper ./gradlew)**
###### **Config files should be versioned in a Git repository**

### Run
###### Build the project
``
cd cfgctl
./gradlew clean build
``
###### Deploy an environment: deploys the config in prod/ and updates .active-prod with the current Git commit.
``
./gradlew run --args="prod"
``

###### Check status: Shows which commit is currently active for each environment.
``
./gradlew status
``

###### Rollback to a previous commit: Restores .active-<env> to the previous commit hash. (Does not automatically change, use Git commands)
``
./gradlew rollback
``

---
###### *Always commit changes in Git before deploying, otherwise rollback cannot reference the commit hash.*
###### *You can manage multiple environments (dev/, staging/, prod/) independently.*
###### *YAML files can contain any configuration - Docker Compose, service settings, API keys etc.*
###### *You can manage multiple environments (dev/, staging/, prod/) independently.*
---

#### Future Growth

###### *Add more commands*

###### *Support more config formats (JSON, TOML, etc.).*

###### *Integrate with CI/CD pipelines for automatic deployment.*

###### *Add user authentication and audit logs for production environments.*
