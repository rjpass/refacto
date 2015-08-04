/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencybuilder;

import java.util.HashMap;

/**
 *
 * @author rpassmore
 */
public class ThirdPartyMavenMap extends HashMap<String,String> {
    
    public ThirdPartyMavenMap() {
        put("activation", 
"\n        <dependency>\n" +
"            <groupId>javax.activation</groupId>\n" +
"            <artifactId>activation</artifactId>\n" +
"            <version>${activation.version}</version>\n" +
"        </dependency>");
        
        put("apachemime4j", "<dependency>\n" +
"  <groupId>org.apache.james</groupId>\n" +
"  <artifactId>apache-mime4j</artifactId>\n" +
"  <version>${apache-mime4j.version}</version>\n" +
"</dependency>");
        
        put("axiom-api", "<dependency>\n" +
"	<groupId>org.apache.ws.commons.axiom</groupId>\n" +
"	<artifactId>axiom-api</artifactId>\n" +
"	<version>${axiom.version}</version>\n" +
"</dependency>");
        
        put("axiom-dom", "<dependency>\n" +
"	<groupId>org.apache.ws.commons.axiom</groupId>\n" +
"	<artifactId>axiom-dom</artifactId>\n" +
"	<version>${axiom.version}</version>\n" +
"</dependency>");
        
        put("axiom-impl", "<dependency>\n" +
"	<groupId>org.apache.ws.commons.axiom</groupId>\n" +
"	<artifactId>axiom-impl</artifactId>\n" +
"	<version>${axiom.version}</version>\n" +
"</dependency>");
        
        put("axis2-codegen", "<dependency>\n" +
"	<groupId>org.apache.axis2</groupId>\n" +
"	<artifactId>axis2-codegen</artifactId>\n" +
"	<version>${axis2.version}</version>\n" +
"</dependency>");
        
        put("axis2-kernel", "<dependency>\n" +
"	<groupId>org.apache.axis2</groupId>\n" +
"	<artifactId>axis2-kernel</artifactId>\n" +
"	<version>${axis2.version}</version>\n" +
"</dependency>");
        
        put("axis2-transport-http", "<dependency>\n" +
"  <groupId>org.apache.axis2</groupId>\n" +
"  <artifactId>axis2-transport-http</artifactId>\n" +
"  <version>${axis2.version}</version>\n" +
"</dependency>");
        
        put("axis2-transport-local", "<dependency>\n" +
"	<groupId>org.apache.axis2</groupId>\n" +
"	<artifactId>axis2-transport-local</artifactId>\n" +
"	<version>${axis2.version}</version>\n" +
"</dependency>");
        
        put("commons-beanutils" , "<dependency>\n" +
"	<groupId>commons-beanutils</groupId>\n" +
"	<artifactId>commons-beanutils</artifactId>\n" +
"	<version>${commons-beanutils.version}</version>\n" +
"</dependency>");
        
        put("commons-cli" , "<dependency>\n" +
"	<groupId>commons-cli</groupId>\n" +
"	<artifactId>commons-cli</artifactId>\n" +
"	<version>${commons-cli.version}</version>\n" +
"</dependency>");
        
        put("commons-codec" , "<dependency>\n" +
"	<groupId>commons-codec</groupId>\n" +
"	<artifactId>commons-codec</artifactId>\n" +
"	<version>${commons-codec.version}</version>\n" +
"</dependency>");
        
        put("commons-collections", "<dependency>\n" +
"	<groupId>commons-collections</groupId>\n" +
"	<artifactId>commons-collections</artifactId>\n" +
"	<version>${commons-collections.version}</version>\n" +
"</dependency>");
        
        put("commons-configuration", "<dependency>\n" +
"	<groupId>commons-configuration</groupId>\n" +
"	<artifactId>commons-configuration</artifactId>\n" +
"	<version>${commons-configuration.version}</version>\n" +
"</dependency>");
        
        put("commons-exec", "<dependency>\n" +
"	<groupId>org.apache.commons</groupId>\n" +
"	<artifactId>commons-exec</artifactId>\n" +
"	<version>${commons-exec.version}</version>\n" +
"</dependency>");
        
        put("commons-httpclient", "<dependency>\n" +
"	<groupId>commons-httpclient</groupId>\n" +
"	<artifactId>commons-httpclient</artifactId>\n" +
"	<version>${commons-httpclient.version}</version>\n" +
"</dependency>");
        
        put("commons-io", "<dependency>\n" +
"	<groupId>commons-io</groupId>\n" +
"	<artifactId>commons-io</artifactId>\n" +
"	<version>${commons-io.version}</version>\n" +
"</dependency>");
        
        put("commons-jxpath", "<dependency>\n" +
"	<groupId>commons-jxpath</groupId>\n" +
"	<artifactId>commons-jxpath</artifactId>\n" +
"	<version>${commons-jxpath.version}</version>\n" +
"</dependency>");
        
        put("commons-lang", "<dependency>\n" +
"	<groupId>commons-lang</groupId>\n" +
"	<artifactId>commons-lang</artifactId>\n" +
"	<version>${commons-lang.version}</version>\n" +
"</dependency>");
        
        put("commons-logging", "<dependency>\n" +
"	<groupId>commons-logging</groupId>\n" +
"	<artifactId>commons-logging</artifactId>\n" +
"	<version>${commons-logging.version}</version>\n" +
"</dependency>");
        
        put("freemarker", "<dependency>\n" +
"	<groupId>org.freemarker</groupId>\n" +
"	<artifactId>freemarker</artifactId>\n" +
"	<version>${freemarker.version}</version>\n" +
"</dependency>");
        
        put("geronimo-annotation_1.0_spec", "<dependency>\n" +
"	<groupId>org.apache.geronimo.specs</groupId>\n" +
"	<artifactId>geronimo-annotation_1.0_spec</artifactId>\n" +
"	<version>${geronimo-annotation_1.0_spec.version}</version>\n" +
"</dependency>");
        
        put("", "<dependency>\n" +
"	<groupId>org.apache.geronimo.specs</groupId>\n" +
"	<artifactId>geronimo-stax-api_1.0_spec</artifactId>\n" +
"	<version>${geronimo-stax-api_1.0_spec}</version>\n" +
"</dependency>");
        
        put("h2", "<dependency>\n" +
"  <groupId>com.h2database</groupId>\n" +
"  <artifactId>h2</artifactId>\n" +
"  <version>${h2.version}</version>\n" +
"</dependency>");
        
        put("httpcore", "<dependency>\n" +
"	<groupId>org.apache.httpcomponents</groupId>\n" +
"	<artifactId>httpcore</artifactId>\n" +
"	<version>${httpcore.version}</version>\n" +
"</dependency>");
        
        put("ini4j", "<dependency>\n" +
"	<groupId>org.ini4j</groupId>\n" +
"	<artifactId>ini4j</artifactId>\n" +
"	<version>${ini4j.version}</version>\n" +
"</dependency>");
        
        put("org.jacoco.ant", "<dependency>\n" +
"	<groupId>org.jacoco</groupId>\n" +
"	<artifactId>org.jacoco.ant</artifactId>\n" +
"	<version>${org.jacoco.ant.version}</version>\n" +
"</dependency>");
        
        put("jai-codec", "<dependency>\n" +
"    <groupId>com.sun.media</groupId>\n" +
"    <artifactId>jai-codec</artifactId>\n" +
"    <version>${jai-codec.version}</version>\n" +
"</dependency>");
        
        put("jaxen", "<dependency>\n" +
"	<groupId>jaxen</groupId>\n" +
"	<artifactId>jaxen</artifactId>\n" +
"	<version>${jaxen.version}</version>\n" +
"</dependency>");
        
        put("jfreechart", "<dependency>\n" +
"	<groupId>jfree</groupId>\n" +
"	<artifactId>jfreechart</artifactId>\n" +
"	<version>${jfreechart.version}</version>\n" +
"</dependency>");
        
        put("joda-time", "<dependency>\n" +
"	<groupId>joda-time</groupId>\n" +
"	<artifactId>joda-time</artifactId>\n" +
"	<version>${joda-time.version}</version>\n" +
"</dependency>");
        
        put("mex", "<dependency>\n" +
"	<groupId>org.apache.axis2</groupId>\n" +
"	<artifactId>mex</artifactId>\n" +
"	<version>${axis2.version}</version>\n" +
"</dependency>");
        
        put("neethi", "<dependency>\n" +
"	<groupId>org.apache.neethi</groupId>\n" +
"	<artifactId>neethi</artifactId>\n" +
"	<version>${neethi.version}</version>\n" +
"</dependency>");
        
        put("opensaml", "<dependency>\n" +
"	<groupId>org.opensaml</groupId>\n" +
"	<artifactId>opensaml</artifactId>\n" +
"	<version>${opensaml.version}</version>\n" +
"</dependency>");
        
        put("poi", "<dependency>\n" +
"	<groupId>org.apache.poi</groupId>\n" +
"	<artifactId>poi</artifactId>\n" +
"	<version>${poi.version}</version>\n" +
"</dependency>");
        
        put("recaptcha4j", "<dependency>\n" +
"	<groupId>com.google.code.maven-play-plugin.net.tanesha.recaptcha4j</groupId>\n" +
"	<artifactId>recaptcha4j</artifactId>\n" +
"	<version>${recaptcha4j.version}</version>\n" +
"</dependency>");
        
        put("serializer", "<dependency>\n" +
"	<groupId>xalan</groupId>\n" +
"	<artifactId>serializer</artifactId>\n" +
"	<version>${serializer.version}</version>\n" +
"</dependency>");
        
        put("slf4j-jdk14", "<dependency>\n" +
"	<groupId>org.slf4j</groupId>\n" +
"	<artifactId>slf4j-jdk14</artifactId>\n" +
"	<version>${slf4j-jdk14.version}</version>\n" +
"</dependency>");
        
        put("sonar-ant-task", "<dependency>\n" +
"	<groupId>org.codehaus.sonar-plugins</groupId>\n" +
"	<artifactId>sonar-ant-task</artifactId>\n" +
"	<version>${sonar-ant-task.version}</version>\n" +
"</dependency>");
        
        put("woden-api", "<dependency>\n" +
"	<groupId>org.apache.woden</groupId>\n" +
"	<artifactId>woden-api</artifactId>\n" +
"	<version>${woden-api.version}</version>\n" +
"</dependency>");
        
        put("wsdl4j", "<dependency>\n" +
"	<groupId>wsdl4j</groupId>\n" +
"	<artifactId>wsdl4j</artifactId>\n" +
"	<version>${wsdl4j.version}</version>\n" +
"</dependency>");
        
        put("wss4j", "<dependency>\n" +
"	<groupId>org.apache.ws.security</groupId>\n" +
"	<artifactId>wss4j</artifactId>\n" +
"	<version>${wss4j.version}</version>\n" +
"</dependency>");
        
        put("xalan", "<dependency>\n" +
"	<groupId>xalan</groupId>\n" +
"	<artifactId>xalan</artifactId>\n" +
"	<version>${xalan.version}</version>\n" +
"</dependency>");
        
        put("xercesImpl", "<dependency>\n" +
"	<groupId>xerces</groupId>\n" +
"	<artifactId>xercesImpl</artifactId>\n" +
"	<version>${xercesImpl.version}</version>\n" +
"</dependency>");
        
        put("xml-apis", "<dependency>\n" +
"	<groupId>xml-apis</groupId>\n" +
"	<artifactId>xml-apis</artifactId>\n" +
"	<version>${xml-apis.version}</version>\n" +
"</dependency>");
        
        put("xml-resolver", "<dependency>\n" +
"	<groupId>xml-resolver</groupId>\n" +
"	<artifactId>xml-resolver</artifactId>\n" +
"	<version>${xml-resolver.version}</version>\n" +
"</dependency>");
        
        put("xmlsec", "<dependency>\n" +
"	<groupId>org.apache.santuario</groupId>\n" +
"	<artifactId>xmlsec</artifactId>\n" +
"	<version>${xmlsec.version}</version>\n" +
"</dependency>");
        
        put("xml-writer", "<dependency>\n" +
"	<groupId>com.megginson.sax</groupId>\n" +
"	<artifactId>xml-writer</artifactId>\n" +
"	<version>${xml-writer.version}</version>\n" +
"</dependency>");
        
        put("antlr", "<dependency>\n" +
"	<groupId>antlr</groupId>\n" +
"	<artifactId>antlr</artifactId>\n" +
"	<version>${antlr.version}</version>\n" +
"</dependency>");
        
        put("c3p0", "<dependency>\n" +
"	<groupId>com.mchange</groupId>\n" +
"	<artifactId>c3p0</artifactId>\n" +
"	<version>${c3p0.version}</version>\n" +
"</dependency>");
        
        put("commons-lang3", "<dependency>\n" +
"	<groupId>org.apache.commons</groupId>\n" +
"	<artifactId>commons-lang3</artifactId>\n" +
"	<version>${commons-lang3.version}</version>\n" +
"</dependency>");
        
        put("dom4j", "<dependency>\n" +
"	<groupId>dom4j</groupId>\n" +
"	<artifactId>dom4j</artifactId>\n" +
"	<version>${dom4j.version}</version>\n" +
"</dependency>");
        
        put("hibernate-c3p0", "<dependency>\n" +
"	<groupId>org.hibernate</groupId>\n" +
"	<artifactId>hibernate-c3p0</artifactId>\n" +
"	<version>${hibernate-c3p0.version}</version>\n" +
"</dependency>");
        
        put("hibernate-commons-annotations", "<dependency>\n" +
"	<groupId>org.hibernate.common</groupId>\n" +
"	<artifactId>hibernate-commons-annotations</artifactId>\n" +
"	<version>${hibernate-commons-annotations.version}</version>\n" +
"</dependency>");
        
        put("hibernate-core", "<dependency>\n" +
"	<groupId>org.hibernate</groupId>\n" +
"	<artifactId>hibernate-core</artifactId>\n" +
"	<version>${hibernate-core.version}</version>\n" +
"</dependency>");
        
        put("hibernate-entitymanager", "<dependency>\n" +
"	<groupId>org.hibernate</groupId>\n" +
"	<artifactId>hibernate-entitymanager</artifactId>\n" +
"	<version>${hibernate-entitymanager.version}</version>\n" +
"</dependency>");
        
        put("hibernate-jpa-2.0-api", "<dependency>\n" +
"	<groupId>org.hibernate.javax.persistence</groupId>\n" +
"	<artifactId>hibernate-jpa-2.0-api</artifactId>\n" +
"	<version>${hibernate-jpa-2.0-api.version}</version>\n" +
"</dependency>");
        
        put("javassist", "<dependency>\n" +
"	<groupId>org.javassist</groupId>\n" +
"	<artifactId>javassist</artifactId>\n" +
"	<version>${javassist.version}</version>\n" +
"</dependency>");
        
        put("jboss-logging", "<dependency>\n" +
"	<groupId>org.jboss.logging</groupId>\n" +
"	<artifactId>jboss-logging</artifactId>\n" +
"	<version>${jboss-logging.version}</version>\n" +
"</dependency>");
        
        put("jboss-transaction-api_1.1_spec", "<dependency>\n" +
"	<groupId>org.jboss.spec.javax.transaction</groupId>\n" +
"	<artifactId>jboss-transaction-api_1.1_spec</artifactId>\n" +
"	<version>${jboss-transaction-api_1.1_spec.version}</version>\n" +
"</dependency>");
        
        put("mchange-commons-java", "<dependency>\n" +
"	<groupId>com.mchange</groupId>\n" +
"	<artifactId>mchange-commons-java</artifactId>\n" +
"	<version>${mchange-commons-java.version}</version>\n" +
"</dependency>");
        
        put("asm-debug-all", "<dependency>\n" +
"	<groupId>org.ow2.asm</groupId>\n" +
"	<artifactId>asm-debug-all</artifactId>\n" +
"	<version>${asm-debug-all.version}</version>\n" +
"</dependency>");
        
        put("guava", "<dependency>\n" +
"	<groupId>com.google.guava</groupId>\n" +
"	<artifactId>guava</artifactId>\n" +
"	<version>${guava.version}</version>\n" +
"</dependency>");
        
        put("hk2-api", "<dependency>\n" +
"	<groupId>org.glassfish.hk2</groupId>\n" +
"	<artifactId>hk2-api</artifactId>\n" +
"	<version>${hk2-api.version}</version>\n" +
"</dependency>");
        
        put("hk2-locator", "<dependency>\n" +
"	<groupId>org.glassfish.hk2</groupId>\n" +
"	<artifactId>hk2-locator</artifactId>\n" +
"	<version>${hk2-locator.version}</version>\n" +
"</dependency>");
        
        put("hk2-utils", "<dependency>\n" +
"	<groupId>org.glassfish.hk2</groupId>\n" +
"	<artifactId>hk2-utils</artifactId>\n" +
"	<version>${hk2-utils.version}</version>\n" +
"</dependency>");
        
        put("jackson-annotations", "<dependency>\n" +
"	<groupId>com.fasterxml.jackson.core</groupId>\n" +
"	<artifactId>jackson-annotations</artifactId>\n" +
"	<version>${jackson-annotations.version}</version>\n" +
"</dependency>");
        
        put("jackson-module-jaxb-annotations", "<dependency>\n" +
"	<groupId>com.fasterxml.jackson.module</groupId>\n" +
"	<artifactId>jackson-module-jaxb-annotations</artifactId>\n" +
"	<version>${jackson-module-jaxb-annotations.version}</version>\n" +
"</dependency>");
        
        put("javax.annotation-api", "<dependency>\n" +
"	<groupId>javax.annotation</groupId>\n" +
"	<artifactId>javax.annotation-api</artifactId>\n" +
"	<version>${javax.annotation-api.version}</version>\n" +
"</dependency>");
        
        put("javax.inject", "<dependency>\n" +
"	<groupId>org.glassfish.hk2.external</groupId>\n" +
"	<artifactId>javax.inject</artifactId>\n" +
"	<version>${javax.inject.version}</version>\n" +
"</dependency>");
        
        put("javax.ws.rs-api", "<dependency>\n" +
"	<groupId>javax.ws.rs</groupId>\n" +
"	<artifactId>javax.ws.rs-api</artifactId>\n" +
"	<version>${javax.ws.rs-api.version}</version>\n" +
"</dependency>");
        
        put("", "<dependency>\n" +
"	<groupId>org.glassfish.jersey.core</groupId>\n" +
"	<artifactId>jersey-client</artifactId>\n" +
"	<version>${jersey-client.version}</version>\n" +
"</dependency>");
        
        put("jersey-common", "<dependency>\n" +
"	<groupId>org.glassfish.jersey.core</groupId>\n" +
"	<artifactId>jersey-common</artifactId>\n" +
"	<version>${jersey.version}</version>\n" +
"</dependency>");
        
        put("jersey-container-servlet-core", "<dependency>\n" +
"	<groupId>org.glassfish.jersey.containers</groupId>\n" +
"	<artifactId>jersey-container-servlet-core</artifactId>\n" +
"	<version>${jersey.version}</version>\n" +
"</dependency>");
        
        put("jersey-container-servlet", "<dependency>\n" +
"	<groupId>org.glassfish.jersey.containers</groupId>\n" +
"	<artifactId>jersey-container-servlet</artifactId>\n" +
"	<version>${jersey.version}</version>\n" +
"</dependency>");
        
        put("jersey-entity-filtering", "<dependency>\n" +
"	<groupId>org.glassfish.jersey.ext</groupId>\n" +
"	<artifactId>jersey-entity-filtering</artifactId>\n" +
"	<version>${jersey.version}</version>\n" +
"</dependency>");
        
        put("jersey-guava", "<dependency>\n" +
"	<groupId>org.glassfish.jersey.bundles.repackaged</groupId>\n" +
"	<artifactId>jersey-guava</artifactId>\n" +
"	<version>${jersey.version}</version>\n" +
"</dependency>");
        
        put("jersey-media-jaxb", "<dependency>\n" +
"	<groupId>org.glassfish.jersey.media</groupId>\n" +
"	<artifactId>jersey-media-jaxb</artifactId>\n" +
"	<version>${jersey.version}</version>\n" +
"</dependency>");
        
        put("jersey-media-json-jackson", "<dependency>\n" +
"	<groupId>org.glassfish.jersey.media</groupId>\n" +
"	<artifactId>jersey-media-json-jackson</artifactId>\n" +
"	<version>${jersey.version}</version>\n" +
"</dependency>");
        
        put("jersey-media-multipart", "<dependency>\n" +
"	<groupId>org.glassfish.jersey.media</groupId>\n" +
"	<artifactId>jersey-media-multipart</artifactId>\n" +
"	<version>${jersey.version}</version>\n" +
"</dependency>");
        
        put("jersey-server", "<dependency>\n" +
"	<groupId>org.glassfish.jersey.core</groupId>\n" +
"	<artifactId>jersey-server</artifactId>\n" +
"	<version>${jersey.version}</version>\n" +
"</dependency>");
        
        put("mimepull", "<dependency>\n" +
"	<groupId>org.jvnet.mimepull</groupId>\n" +
"	<artifactId>mimepull</artifactId>\n" +
"	<version>${mimepull.version}</version>\n" +
"</dependency>");
        
        put("osgi-resource-locator", "<dependency>\n" +
"	<groupId>org.glassfish.hk2</groupId>\n" +
"	<artifactId>osgi-resource-locator</artifactId>\n" +
"	<version>${osgi-resource-locator.version}</version>\n" +
"</dependency>");
        
        put("validation-api", "<dependency>\n" +
"	<groupId>javax.validation</groupId>\n" +
"	<artifactId>validation-api</artifactId>\n" +
"	<version>${validation-api.version}</version>\n" +
"</dependency>");
        
        put("asm", "<dependency>\n" +
"	<groupId>net.minidev</groupId>\n" +
"	<artifactId>asm</artifactId>\n" +
"	<version>${asm.version}</version>\n" +
"</dependency>");
        
        put("gson", "<dependency>\n" +
"	<groupId>com.google.code.gson</groupId>\n" +
"	<artifactId>gson</artifactId>\n" +
"	<version>${gson.version}</version>\n" +
"</dependency>");
        
        put("jcip-annotations", "<dependency>\n" +
"	<groupId>net.jcip</groupId>\n" +
"	<artifactId>jcip-annotations</artifactId>\n" +
"	<version>${jcip-annotations.version}</version>\n" +
"</dependency>");
        
        put("json-smart", "<dependency>\n" +
"	<groupId>net.minidev</groupId>\n" +
"	<artifactId>json-smart</artifactId>\n" +
"	<version>${json-smart.version}</version>\n" +
"</dependency>");
        
        put("nimbus-jose-jwt", "<dependency>\n" +
"	<groupId>com.nimbusds</groupId>\n" +
"	<artifactId>nimbus-jose-jwt</artifactId>\n" +
"	<version>${nimbus-jose-jwt.version}</version>\n" +
"</dependency>");
        
        put("json", "<dependency>\n" +
"	<groupId>com.unboundid.components</groupId>\n" +
"	<artifactId>json</artifactId>\n" +
"	<version>${json.version}</version>\n" +
"</dependency>");
        
        put("scim-sdk", "<dependency>\n" +
"	<groupId>com.unboundid.product.scim</groupId>\n" +
"	<artifactId>scim-sdk</artifactId>\n" +
"	<version>${scim-sdk.version}</version>\n" +
"</dependency>");
        
        put("core-io", "<dependency>\n" +
"	<groupId>com.couchbase.client</groupId>\n" +
"	<artifactId>core-io</artifactId>\n" +
"	<version>${core-io.version}</version>\n" +
"</dependency>");
        
        put("hamcrest-core", "<dependency>\n" +
"	<groupId>org.hamcrest</groupId>\n" +
"	<artifactId>hamcrest-core</artifactId>\n" +
"	<version>${hamcrest-core.version}</version>\n" +
"</dependency>");
        
        put("java-client", "<dependency>\n" +
"	<groupId>com.couchbase.client</groupId>\n" +
"	<artifactId>java-client</artifactId>\n" +
"	<version>${couchbase.java-client.version}</version>\n" +
"</dependency>");
        
        put("mail", "<dependency>\n" +
"	<groupId>javax.mail</groupId>\n" +
"	<artifactId>mail</artifactId>\n" +
"	<version>${mail.version}</version>\n" +
"</dependency>");
        
        put("mysql-connector-java", "<dependency>\n" +
"	<groupId>mysql</groupId>\n" +
"	<artifactId>mysql-connector-java</artifactId>\n" +
"	<version>${mysql-connector-java.version}</version>\n" +
"</dependency>");
        
        put("rxjava", "<dependency>\n" +
"	<groupId>io.reactivex</groupId>\n" +
"	<artifactId>rxjava</artifactId>\n" +
"	<version>${rxjava.version}</version>\n" +
"</dependency>");
        
        put("tomcat-servlet-api", "<dependency>\n" +
"	<groupId>org.apache.tomcat</groupId>\n" +
"	<artifactId>tomcat-servlet-api</artifactId>\n" +
"	<version>${tomcat-servlet-api.version}</version>\n" +
"</dependency>");
        
        put("cglib-nodep", "<dependency>\n" +
"	<groupId>cglib</groupId>\n" +
"	<artifactId>cglib-nodep</artifactId>\n" +
"	<version>${cglib-nodep.version}</version>\n" +
"</dependency>");
        
        put("easymock", "<dependency>\n" +
"	<groupId>org.easymock</groupId>\n" +
"	<artifactId>easymock</artifactId>\n" +
"	<version>${easymock.version}</version>\n" +
"</dependency>");
        
        put("junit", "<dependency>\n" +
"	<groupId>junit</groupId>\n" +
"	<artifactId>junit</artifactId>\n" +
"	<version>${junit.version}</version>\n" +
"</dependency>");
        
        put("", "<dependency>\n" +
"	<groupId>org.mockito</groupId>\n" +
"	<artifactId>mockito-all</artifactId>\n" +
"	<version>${mockito-all.version}</version>\n" +
"</dependency>");
        
        put("", "<dependency>\n" +
"	<groupId>de.idyl</groupId>\n" +
"	<artifactId>winzipaes</artifactId>\n" +
"	<version>${winzipaes.version}</version>\n" +
"</dependency>");
        
        put("jsoup", "<dependency>\n" +
"	<groupId>org.jsoup</groupId>\n" +
"	<artifactId>jsoup</artifactId>\n" +
"	<version>${jsoup.version}</version>\n" +
"</dependency>");
        
        put("vaadin-server", "<dependency>\n" +
"	<groupId>com.vaadin</groupId>\n" +
"	<artifactId>vaadin-server</artifactId>\n" +
    "	<version>${vaadin-server.version}</version>\n" +
"</dependency>");
        
        put("vaadin-shared-deps", "<dependency>\n" +
"	<groupId>com.vaadin</groupId>\n" +
"	<artifactId>vaadin-shared-deps</artifactId>\n" +
    "	<version>${vaadin-shared-deps.version}</version>\n" +
"</dependency>");
        
        put("vaadin-shared", "<dependency>\n" +
"	<groupId>com.vaadin</groupId>\n" +
"	<artifactId>vaadin-shared</artifactId>\n" +
"	<version>${vaadin-shared.version}</version>\n" +
"</dependency>");
        
        put("btf", "<dependency>\n" +
"	<groupId>com.github.fge</groupId>\n" +
"	<artifactId>btf</artifactId>\n" +
"	<version>${btf.version}</version>\n" +
"</dependency>");
        
        put("jackson-coreutils", "<dependency>\n" +
"	<groupId>com.github.fge</groupId>\n" +
"	<artifactId>jackson-coreutils</artifactId>\n" +
"	<version>${jackson-coreutils.version}</version>\n" +
"</dependency>");
        
        put("jackson-jaxrs-base", "<dependency>\n" +
"	<groupId>com.fasterxml.jackson.jaxrs</groupId>\n" +
"	<artifactId>jackson-jaxrs-base</artifactId>\n" +
"	<version>${jackson-jaxrs-base.version}</version>\n" +
"</dependency>");
        
        put("jackson-jaxrs-json-provider", "<dependency>\n" +
"	<groupId>com.fasterxml.jackson.jaxrs</groupId>\n" +
"	<artifactId>jackson-jaxrs-json-provider</artifactId>\n" +
"	<version>${jackson-jaxrs-json-provider.version}</version>\n" +
"</dependency>");
        
        put("json-schema-core", "<dependency>\n" +
"	<groupId>com.github.fge</groupId>\n" +
"	<artifactId>json-schema-core</artifactId>\n" +
"	<version>${json-schema-core.version}</version>\n" +
"</dependency>");
        
        put("json-schema-validator", "<dependency>\n" +
"	<groupId>com.github.fge</groupId>\n" +
"	<artifactId>json-schema-validator</artifactId>\n" +
"	<version>${json-schema-validator.version}</version>\n" +
"</dependency>");
        
        put("msg-simple", "<dependency>\n" +
"	<groupId>com.github.fge</groupId>\n" +
"	<artifactId>msg-simple</artifactId>\n" +
"	<version>${msg-simple.version}</version>\n" +
"</dependency>");
        
        put("uri-template", "<dependency>\n" +
"	<groupId>com.github.fge</groupId>\n" +
"	<artifactId>uri-template</artifactId>\n" +
"	<version>${uri-template.version}</version>\n" +
"</dependency>");
                
                
        
    }
    
}
