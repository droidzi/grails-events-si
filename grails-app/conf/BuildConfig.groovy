grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.5
grails.project.source.level = 1.5
//grails.project.war.file = "target/${appName}-${appVersion}.war"


grails.project.dependency.resolution = {
	inherits("global") {
		excludes("xml-apis", "commons-digester")
	}
	log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
	repositories {
        mavenLocal()
        mavenRepo 'https://repo.springsource.org/libs-milestone/'
		grailsCentral()
	}
	dependencies {
		compile('org.springframework.integration:spring-integration-core:2.1.4.RELEASE') {
			excludes 'spring-context', 'spring-aop', "xml-apis", "commons-digester"
		}
        compile('org.springframework.integration:spring-integration-dsl-groovy-core:1.0.0.M1')
		// runtime 'mysql:mysql-connector-java:5.1.5'
	}

	plugins {
		build(":tomcat:$grailsVersion",
				":release:2.0.4",
				":hibernate:$grailsVersion"
				) {
					export = false
				}
		compile (':platform-core:1.0.RC1')

	}
}