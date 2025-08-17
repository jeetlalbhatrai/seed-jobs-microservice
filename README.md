# seed-jobs-microservice
Prerequisite->
-We have jenkins should be install.
-Install the "Job DSL" plugins should be install.
-We have to create the Free Stype Jenkins Jobs as Seed Jobs.
 Under Git--> "https://github.com/jeetlalbhatrai/seed-jobs-microservice.git"
 Branch Should be main.
 Under Build Steps---> Find Process Jobs DSL --> Look on Filessystem --> "dsl/**/*.groovy" --> save.

====>>>
-Below is the structure of github where we put seedjobs and service jenkins jobs..

https://github.com/jeetlalbhatrai/seed-jobs-microservice.git
seed-jobs/
├── Jenkinsfile
├── README.md
├── dsl
│   └── pipelines.groovy
└── service-jobs
    ├── config-server
    │   └── Jenkinsfile
    └── kyc-service
        └── Jenkinsfile



