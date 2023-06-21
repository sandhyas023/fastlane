# fastlane-android-sample

Sample repo to upload app to lambdatest and test app on real devices.

## Prerequisites

* Install fastlane to your local machine .
* Lambdatest Authentication credentials . Please refer this [page](https://accounts.lambdatest.com/security) for credentials.

  ```
    LT_USERNAME=<YOUR_LAMBDATEST_USERNAME>
    LT_ACCESS_KEY=<YOUR_LAMBDATEST_ACCESS_KEY>
  ```
* Install Gradle and Java for running tests.

**_NOTE:_**  Also create `local.properties` file with sdk path , if any issue occurs related to sdk Path.

## Getting Started

* Add [Lambdatest-fastlane-plugin](https://rubygems.org/gems/fastlane-plugin-lambdatest) in your project.
```
  fastlane add_plugin lambdatest
```

* Add below action in project fastfile in desired lane to upload app to lambdatest.   
```
upload_to_lambdatest(
    lt_username: ENV["LT_USERNAME"],
    lt_access_key: ENV["LT_ACCESS_KEY"],
    file_path: "app_file_path"
)
```
or if you want to used custom_id.

```
upload_to_lambdatest(
    lt_username: ENV["LT_USERNAME"],
    lt_access_key: ENV["LT_ACCESS_KEY"],
    file_path: "<app_file_path>",
    custom_id: "<custom_id>
)
```
This will set  value for ```APP_URL``` environment variable.

**_NOTE:_**  custom_id is an optional field.

* Add command in same lane to run tests.
```
 gradle(task: "test")
```

* Build project and provide apk file path in fastfile Example - `app/build/outputs/apk/debug/app-debug.apk`
```
gradle build
```

* You can run below command to upload app and execute tests on real devices.

```
    fastlane test
```

## View Test Execution

Once you have run your tests, you can view the test execution along with logs. You will be able to see the test cases passing or failing. You can view the same at [LambdaTest Automation](https://accounts.lambdatest.com/login).

## About LambdaTest

[LambdaTest](https://www.lambdatest.com/) is a cloud based selenium grid infrastructure that can help you run automated cross browser compatibility tests on 2000+ different browser and operating system environments. LambdaTest supports all programming languages and frameworks that are supported with Selenium, and have easy integrations with all popular CI/CD platforms. It's a perfect solution to bring your [selenium automation testing](https://www.lambdatest.com/selenium-automation) to cloud based infrastructure that not only helps you increase your test coverage over multiple desktop and mobile browsers, but also allows you to cut down your test execution time by running tests on parallel.