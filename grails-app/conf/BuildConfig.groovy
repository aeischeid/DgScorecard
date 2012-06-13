grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()

        // uncomment these to enable remote dependency resolution from public Maven repositories
        //mavenCentral()
        //mavenLocal()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        compile 'org.apache.poi:poi:3.8'

        compile 'commons-httpclient:commons-httpclient:3.1'

        runtime 'postgresql:postgresql:8.4-702.jdbc3'

        test ('org.gmock:gmock:0.8.2') {
            excludes 'junit'
        }
    }

    plugins {
        compile ":github-gist:0.1"
        compile ":spring-security-core:1.2.7.3"
        compile (":spring-security-openid:1.0.3") {
            excludes "commons-httpclient"
        }

        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.7.1"
        runtime ":resources:1.1.6"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.4"

        build ":tomcat:$grailsVersion"

        test ":functional-test:1.3-RC1"
        test ":remote-control:1.2"

        compile(':heroku:1.0.1') {
            exclude 'database-session'
        }
        compile ':cloud-support:1.0.8'
        compile ':webxml:1.4.1'
    }
}
