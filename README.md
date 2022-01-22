## Plugin Grails +  publish in nexus


## Steps 

### 1. Create a new plugin project in grails
``` 
$ grails create-plugin br.com.personal.myplugin
```

### 2. Run nexus in background

```
$ docker-compose up -d 
```

### 3. Configure a password for the nexus user
 
###4. Configure the project to publish in nexus

####4.1 Add user and passorwd of the nexus in gradle.properties

```
repoUser=admin
repoPassword=123456
```

#### 4.2 Verify the name of the plugin in settings.gradle

Put the name of the plugin in minuscule.

```
rootProject.name = 'myplugin'
```

#### 4.3 Configure the version and group in file build.gradle

```
version "1.0.0"
group "br.com.personal"

```

#### 4.4 Configure the gradle to publish in nexus repository. Add the code below in build.gradle

Add plugin in build.gradle

```
apply plugin:"maven-publish"
```

#### 4.5 Configure the gradle to publish in nexus repository. Add the code below in build.gradle 

```

publishing {
    publications {
        maven(MavenPublication) {
            artifact("build/libs/myplugin-$version" + "-plain.jar") {
                extension 'jar'
            }
        }
    }
    repositories {
        maven {
            name 'nexus'
            url "http://127.0.0.1:8081/repository/maven-releases/"
            credentials {
                username project.repoUser
                password project.repoPassword
            }
        }
    }
}

```



###5. Publish the plugin in nexus

```
$ ./gradlew clean build publish
``` 


### 6. To use the plugin in other project 

### 6.1 Add the repository in the project in file

```
repositories {
    maven { url "https://repo.grails.org/grails/core" }
    maven {
        url "http://localhost:8081/repository/maven-releases/"
        allowInsecureProtocol true
    }
}
```

### 6.2 Add the depedency in the project in file build.gradle

```
implementation 'br.com.personal:myplugin:1.0.1'
```


### 7 To use a view of plugin in other project

```
    render plugin:'myplugin', view :'/layouts/layoutplugin.gsp'
```