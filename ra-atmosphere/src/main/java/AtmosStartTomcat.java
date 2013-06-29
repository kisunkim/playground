import ch.rasc.embeddedtc.EmbeddedTomcat;

public class AtmosStartTomcat {
	public static void main(String[] args) throws Exception {
		// Skip jars during Tomcat scanning for web fragments, TLD files, etc.
		// Improves startup time
		String skipJars = "antlr-*.jar;aopalliance-*.jar;aspectjrt-*.jar;commons-*.jar;dom4j-*.jar;guava-*.jar;extjs-*.jar;hibernate-*.jar;http*.jar";
		skipJars += "jackson-*.jar;javassist-*.jar;javax*.jar;jboss-*.jar;jcl-over-slf4j-*.jar;joda-*.jar;jsr305-*.jar;jul-to-slf4j-*.jar;liquibase-core*.jar;";
		skipJars += "logback-*.jar;mysema-commons-lang-*.jar;poi-*.jar;querydsl-*.jar;slf4j-api-*.jar;snakeyaml*.jar;spring-*.jar;uadetector*.jar;";
		skipJars += "usertype*.jar;validation-api-*.jar;xmlbeans-*.jar;yuicompressor*.jar";
		skipJars += "tomcat-*.jar;ecj-*.jar;h2*.jar";

		EmbeddedTomcat.create().skipJarsDefaultJarScanner(skipJars).startAndWait();
	}
}