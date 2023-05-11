<h1 align="center" style="font-weight: bold; margin-top: 20px; margin-bottom: 20px;">Hello Service</h1>

<p align="center">

  <img alt="Github Build" src="https://img.shields.io/github/actions/workflow/status/Wilddiary/hello-service/maven-build.yml" />
  <img alt="Synk Vulnerabilities" src="https://img.shields.io/snyk/vulnerabilities/github/Wilddiary/hello-service" />
  <img alt="GitHub Language Count" src="https://img.shields.io/github/languages/count/Wilddiary/hello-service" />
  <img alt="GitHub Top Language" src="https://img.shields.io/github/languages/top/Wilddiary/hello-service" />
  <img alt="GitHub Repo Size" src="https://img.shields.io/github/repo-size/Wilddiary/hello-service" />
  <img alt="GitHub File Count" src="https://img.shields.io/github/directory-file-count/Wilddiary/hello-service" />
  <img alt="GitHub Issues" src="https://img.shields.io/github/issues/Wilddiary/hello-service" />
  <img alt="GitHub Closed Issues" src="https://img.shields.io/github/issues-closed/Wilddiary/hello-service" />
  <img alt="GitHub Pull Requests" src="https://img.shields.io/github/issues-pr/Wilddiary/hello-service" />
  <img alt="GitHub Closed Pull Requests" src="https://img.shields.io/github/issues-pr-closed/Wilddiary/hello-service" />
  <img alt="GitHub Release" src="https://img.shields.io/github/v/release/Wilddiary/hello-service?date_order_by=created_at&sort=date" />
  <img alt="GitHub Tag" src="https://img.shields.io/github/v/tag/Wilddiary/hello-service" />
  <img alt="GitHub Contributors" src="https://img.shields.io/github/contributors/Wilddiary/hello-service" />
  <img alt="GitHub Last Commit" src="https://img.shields.io/github/last-commit/Wilddiary/hello-service" />
  <img alt="GitHub Commit Activity (Week)" src="https://img.shields.io/github/commit-activity/w/Wilddiary/hello-service" />
  <img alt="GitHub Commit Activity (Month)" src="https://img.shields.io/github/commit-activity/m/Wilddiary/hello-service" />
  <img alt="GitHub Commit Activity (Year)" src="https://img.shields.io/github/commit-activity/y/Wilddiary/hello-service" />
  <img alt="Github License" src="https://img.shields.io/github/license/Wilddiary/hello-service" />
  <img alt="Forks" src="https://img.shields.io/github/forks/Wilddiary/hello-service" />
  <img alt="Followers" src="https://img.shields.io/github/followers/Wilddiary" />
  <img alt="Discussions" src="https://img.shields.io/github/discussions/Wilddiary/hello-service" />

</p>

This is a demo service for general use and testing. This service is capable of responding with a greeting message for an optional input name and with an optional input delay of less than 5000 milliseconds.  

| URI      |        Query Parameters         |    Constraints |                         Response |
|----------|:-------------------------------:|---------------:|---------------------------------:|
| /hello   | name (String),<br/>delay (long) |  delay <= 5000 | Hello, World! or Hello, ${name}! |

The service registers with Spring Boot Admin during startup. Expect a harmless error message if the Admin server is unavailable.


# Build
> mvn clean package

# Build Docker Image
> mvn k8s:build
> 
Building the application jar is a pre-requisite for building the docker image.

# Deploy to Kubernetes
> mvn k8s:resource k8s:apply
> 
Building the docker image is a pre-requisite for deploy.

