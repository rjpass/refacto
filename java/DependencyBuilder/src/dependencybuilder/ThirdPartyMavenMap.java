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
        
        put("apachemime4j", "\n        <dependency>\n" +
"            <groupId>org.apache.james</groupId>\n" +
"            <artifactId>apache-mime4j</artifactId>\n" +
"            <version>${apache-mime4j.version}</version>\n" +
"        </dependency>");
        
        put("axiom-api", "\n        <dependency>\n" +
"            <groupId>org.apache.ws.commons.axiom</groupId>\n" +
"            <artifactId>axiom-api</artifactId>\n" +
"            <version>${axiom.version}</version>\n" +
"        </dependency>");
        
        put("axiom-dom", "\n        <dependency>\n" +
"            <groupId>org.apache.ws.commons.axiom</groupId>\n" +
"            <artifactId>axiom-dom</artifactId>\n" +
"            <version>${axiom.version}</version>\n" +
"        </dependency>");
        
        put("axiom-impl", "\n        <dependency>\n" +
"            <groupId>org.apache.ws.commons.axiom</groupId>\n" +
"            <artifactId>axiom-impl</artifactId>\n" +
"            <version>${axiom.version}</version>\n" +
"        </dependency>");
        
        put("axis2-codegen", "\n        <dependency>\n" +
"            <groupId>org.apache.axis2</groupId>\n" +
"            <artifactId>axis2-codegen</artifactId>\n" +
"            <version>${axis2.version}</version>\n" +
"        </dependency>");
        
        put("axis2-kernel", "\n        <dependency>\n" +
"            <groupId>org.apache.axis2</groupId>\n" +
"            <artifactId>axis2-kernel</artifactId>\n" +
"            <version>${axis2.version}</version>\n" +
"        </dependency>");
        
        put("axis2-transport-http", "\n        <dependency>\n" +
"            <groupId>org.apache.axis2</groupId>\n" +
"            <artifactId>axis2-transport-http</artifactId>\n" +
"            <version>${axis2.version}</version>\n" +
"        </dependency>");
        
        put("axis2-transport-local", "\n        <dependency>\n" +
"            <groupId>org.apache.axis2</groupId>\n" +
"            <artifactId>axis2-transport-local</artifactId>\n" +
"            <version>${axis2.version}</version>\n" +
"        </dependency>");
        
        put("commons-beanutils" , "\n        <dependency>\n" +
"            <groupId>commons-beanutils</groupId>\n" +
"            <artifactId>commons-beanutils</artifactId>\n" +
"            <version>${commons-beanutils.version}</version>\n" +
"        </dependency>");
        
        put("commons-cli" , "\n        <dependency>\n" +
"            <groupId>commons-cli</groupId>\n" +
"            <artifactId>commons-cli</artifactId>\n" +
"            <version>${commons-cli.version}</version>\n" +
"        </dependency>");
        
        put("commons-codec" , "\n        <dependency>\n" +
"            <groupId>commons-codec</groupId>\n" +
"            <artifactId>commons-codec</artifactId>\n" +
"            <version>${commons-codec.version}</version>\n" +
"        </dependency>");
        
        put("commons-collections", "\n        <dependency>\n" +
"            <groupId>commons-collections</groupId>\n" +
"            <artifactId>commons-collections</artifactId>\n" +
"            <version>${commons-collections.version}</version>\n" +
"        </dependency>");
        
        put("commons-configuration", "\n        <dependency>\n" +
"            <groupId>commons-configuration</groupId>\n" +
"            <artifactId>commons-configuration</artifactId>\n" +
"            <version>${commons-configuration.version}</version>\n" +
"        </dependency>");
        
        put("commons-exec", "\n        <dependency>\n" +
"            <groupId>org.apache.commons</groupId>\n" +
"            <artifactId>commons-exec</artifactId>\n" +
"            <version>${commons-exec.version}</version>\n" +
"        </dependency>");
        
        put("commons-httpclient", "\n        <dependency>\n" +
"            <groupId>commons-httpclient</groupId>\n" +
"            <artifactId>commons-httpclient</artifactId>\n" +
"            <version>${commons-httpclient.version}</version>\n" +
"        </dependency>");
        
        put("commons-io", "\n        <dependency>\n" +
"            <groupId>commons-io</groupId>\n" +
"            <artifactId>commons-io</artifactId>\n" +
"            <version>${commons-io.version}</version>\n" +
"        </dependency>");
        
        put("commons-jxpath", "\n        <dependency>\n" +
"            <groupId>commons-jxpath</groupId>\n" +
"            <artifactId>commons-jxpath</artifactId>\n" +
"            <version>${commons-jxpath.version}</version>\n" +
"        </dependency>");
        
        put("commons-lang", "\n        <dependency>\n" +
"            <groupId>commons-lang</groupId>\n" +
"            <artifactId>commons-lang</artifactId>\n" +
"            <version>${commons-lang.version}</version>\n" +
"        </dependency>");
        
        put("commons-logging", "\n        <dependency>\n" +
"            <groupId>commons-logging</groupId>\n" +
"            <artifactId>commons-logging</artifactId>\n" +
"            <version>${commons-logging.version}</version>\n" +
"        </dependency>");
        
        put("freemarker", "\n        <dependency>\n" +
"            <groupId>org.freemarker</groupId>\n" +
"            <artifactId>freemarker</artifactId>\n" +
"            <version>${freemarker.version}</version>\n" +
"        </dependency>");
        
        put("geronimo-annotation_1.0_spec", "\n        <dependency>\n" +
"            <groupId>org.apache.geronimo.specs</groupId>\n" +
"            <artifactId>geronimo-annotation_1.0_spec</artifactId>\n" +
"            <version>${geronimo-annotation_1.0_spec.version}</version>\n" +
"        </dependency>");
        
        put("geronimo-stax-api_1.0_spec", "\n        <dependency>\n" +
"            <groupId>org.apache.geronimo.specs</groupId>\n" +
"            <artifactId>geronimo-stax-api_1.0_spec</artifactId>\n" +
"            <version>${geronimo-stax-api_1.0_spec.version}</version>\n" +
"        </dependency>");
        
        put("h2", "\n        <dependency>\n" +
"            <groupId>com.h2database</groupId>\n" +
"            <artifactId>h2</artifactId>\n" +
"            <version>${h2.version}</version>\n" +
"        </dependency>");
        
        put("httpcore", "\n        <dependency>\n" +
"            <groupId>org.apache.httpcomponents</groupId>\n" +
"            <artifactId>httpcore</artifactId>\n" +
"            <version>${httpcore.version}</version>\n" +
"        </dependency>");
        
        put("ini4j", "\n        <dependency>\n" +
"            <groupId>org.ini4j</groupId>\n" +
"            <artifactId>ini4j</artifactId>\n" +
"            <version>${ini4j.version}</version>\n" +
"        </dependency>");
        
        put("org.jacoco.ant", "\n        <dependency>\n" +
"            <groupId>org.jacoco</groupId>\n" +
"            <artifactId>org.jacoco.ant</artifactId>\n" +
"            <version>${org.jacoco.ant.version}</version>\n" +
"        </dependency>");
        
        put("jai-codec", "\n        <dependency>\n" +
"              <groupId>com.sun.media</groupId>\n" +
"              <artifactId>jai-codec</artifactId>\n" +
"              <version>${jai-codec.version}</version>\n" +
"        </dependency>");
        
        put("jaxen", "\n        <dependency>\n" +
"            <groupId>jaxen</groupId>\n" +
"            <artifactId>jaxen</artifactId>\n" +
"            <version>${jaxen.version}</version>\n" +
"        </dependency>");
        
        put("jfreechart", "\n        <dependency>\n" +
"            <groupId>jfree</groupId>\n" +
"            <artifactId>jfreechart</artifactId>\n" +
"            <version>${jfreechart.version}</version>\n" +
"        </dependency>");
        
        put("joda-time", "\n        <dependency>\n" +
"            <groupId>joda-time</groupId>\n" +
"            <artifactId>joda-time</artifactId>\n" +
"            <version>${joda-time.version}</version>\n" +
"        </dependency>");
        
        put("mex", "\n        <dependency>\n" +
"            <groupId>org.apache.axis2</groupId>\n" +
"            <artifactId>mex</artifactId>\n" +
"            <version>${axis2.version}</version>\n" +
"        </dependency>");
        
        put("neethi", "\n        <dependency>\n" +
"            <groupId>org.apache.neethi</groupId>\n" +
"            <artifactId>neethi</artifactId>\n" +
"            <version>${neethi.version}</version>\n" +
"        </dependency>");
        
        put("opensaml", "\n        <dependency>\n" +
"            <groupId>org.opensaml</groupId>\n" +
"            <artifactId>opensaml</artifactId>\n" +
"            <version>${opensaml.version}</version>\n" +
"        </dependency>");
        
        put("poi", "\n        <dependency>\n" +
"            <groupId>org.apache.poi</groupId>\n" +
"            <artifactId>poi</artifactId>\n" +
"            <version>${poi.version}</version>\n" +
"        </dependency>");
        
        put("recaptcha4j", "\n        <dependency>\n" +
"            <groupId>com.google.code.maven-play-plugin.net.tanesha.recaptcha4j</groupId>\n" +
"            <artifactId>recaptcha4j</artifactId>\n" +
"            <version>${recaptcha4j.version}</version>\n" +
"        </dependency>");
        
        put("serializer", "\n        <dependency>\n" +
"            <groupId>xalan</groupId>\n" +
"            <artifactId>serializer</artifactId>\n" +
"            <version>${serializer.version}</version>\n" +
"        </dependency>");
        
        put("slf4j-jdk14", "\n        <dependency>\n" +
"            <groupId>org.slf4j</groupId>\n" +
"            <artifactId>slf4j-jdk14</artifactId>\n" +
"            <version>${slf4j-jdk14.version}</version>\n" +
"        </dependency>");
        
        put("sonar-ant-task", "\n        <dependency>\n" +
"            <groupId>org.codehaus.sonar-plugins</groupId>\n" +
"            <artifactId>sonar-ant-task</artifactId>\n" +
"            <version>${sonar-ant-task.version}</version>\n" +
"        </dependency>");
        
        put("woden-api", "\n        <dependency>\n" +
"            <groupId>org.apache.woden</groupId>\n" +
"            <artifactId>woden-api</artifactId>\n" +
"            <version>${woden-api.version}</version>\n" +
"        </dependency>");
        
        put("wsdl4j", "\n        <dependency>\n" +
"            <groupId>wsdl4j</groupId>\n" +
"            <artifactId>wsdl4j</artifactId>\n" +
"            <version>${wsdl4j.version}</version>\n" +
"        </dependency>");
        
        put("wss4j", "\n        <dependency>\n" +
"            <groupId>org.apache.ws.security</groupId>\n" +
"            <artifactId>wss4j</artifactId>\n" +
"            <version>${wss4j.version}</version>\n" +
"        </dependency>");
        
        put("xalan", "\n        <dependency>\n" +
"            <groupId>xalan</groupId>\n" +
"            <artifactId>xalan</artifactId>\n" +
"            <version>${xalan.version}</version>\n" +
"        </dependency>");
        
        put("xercesImpl", "\n        <dependency>\n" +
"            <groupId>xerces</groupId>\n" +
"            <artifactId>xercesImpl</artifactId>\n" +
"            <version>${xercesImpl.version}</version>\n" +
"        </dependency>");
        
        put("xml-apis", "\n        <dependency>\n" +
"            <groupId>xml-apis</groupId>\n" +
"            <artifactId>xml-apis</artifactId>\n" +
"            <version>${xml-apis.version}</version>\n" +
"        </dependency>");
        
        put("xml-resolver", "\n        <dependency>\n" +
"            <groupId>xml-resolver</groupId>\n" +
"            <artifactId>xml-resolver</artifactId>\n" +
"            <version>${xml-resolver.version}</version>\n" +
"        </dependency>");
        
        put("xmlsec", "\n        <dependency>\n" +
"            <groupId>org.apache.santuario</groupId>\n" +
"            <artifactId>xmlsec</artifactId>\n" +
"            <version>${xmlsec.version}</version>\n" +
"        </dependency>");
        
        put("xml-writer", "\n        <dependency>\n" +
"            <groupId>com.megginson.sax</groupId>\n" +
"            <artifactId>xml-writer</artifactId>\n" +
"            <version>${xml-writer.version}</version>\n" +
"        </dependency>");
        
        put("antlr", "\n        <dependency>\n" +
"            <groupId>antlr</groupId>\n" +
"            <artifactId>antlr</artifactId>\n" +
"            <version>${antlr.version}</version>\n" +
"        </dependency>");
        
        put("c3p0", "\n        <dependency>\n" +
"            <groupId>com.mchange</groupId>\n" +
"            <artifactId>c3p0</artifactId>\n" +
"            <version>${c3p0.version}</version>\n" +
"        </dependency>");
        
        put("commons-lang3", "\n        <dependency>\n" +
"            <groupId>org.apache.commons</groupId>\n" +
"            <artifactId>commons-lang3</artifactId>\n" +
"            <version>${commons-lang3.version}</version>\n" +
"        </dependency>");
        
        put("dom4j", "\n        <dependency>\n" +
"            <groupId>dom4j</groupId>\n" +
"            <artifactId>dom4j</artifactId>\n" +
"            <version>${dom4j.version}</version>\n" +
"        </dependency>");
        
        put("hibernate-c3p0", "\n        <dependency>\n" +
"            <groupId>org.hibernate</groupId>\n" +
"            <artifactId>hibernate-c3p0</artifactId>\n" +
"            <version>${hibernate-c3p0.version}</version>\n" +
"        </dependency>");
        
        put("hibernate-commons-annotations", "\n        <dependency>\n" +
"            <groupId>org.hibernate.common</groupId>\n" +
"            <artifactId>hibernate-commons-annotations</artifactId>\n" +
"            <version>${hibernate-commons-annotations.version}</version>\n" +
"        </dependency>");
        
        put("hibernate-core", "\n        <dependency>\n" +
"            <groupId>org.hibernate</groupId>\n" +
"            <artifactId>hibernate-core</artifactId>\n" +
"            <version>${hibernate-core.version}</version>\n" +
"        </dependency>");
        
        put("hibernate-entitymanager", "\n        <dependency>\n" +
"            <groupId>org.hibernate</groupId>\n" +
"            <artifactId>hibernate-entitymanager</artifactId>\n" +
"            <version>${hibernate-entitymanager.version}</version>\n" +
"        </dependency>");
        
        put("hibernate-jpa-2.0-api", "\n        <dependency>\n" +
"            <groupId>org.hibernate.javax.persistence</groupId>\n" +
"            <artifactId>hibernate-jpa-2.0-api</artifactId>\n" +
"            <version>${hibernate-jpa-2.0-api.version}</version>\n" +
"        </dependency>");
        
        put("javassist", "\n        <dependency>\n" +
"            <groupId>org.javassist</groupId>\n" +
"            <artifactId>javassist</artifactId>\n" +
"            <version>${javassist.version}</version>\n" +
"        </dependency>");
        
        put("jboss-logging", "\n        <dependency>\n" +
"            <groupId>org.jboss.logging</groupId>\n" +
"            <artifactId>jboss-logging</artifactId>\n" +
"            <version>${jboss-logging.version}</version>\n" +
"        </dependency>");
        
        put("jboss-transaction-api_1.1_spec", "\n        <dependency>\n" +
"            <groupId>org.jboss.spec.javax.transaction</groupId>\n" +
"            <artifactId>jboss-transaction-api_1.1_spec</artifactId>\n" +
"            <version>${jboss-transaction-api_1.1_spec.version}</version>\n" +
"        </dependency>");
        
        put("mchange-commons-java", "\n        <dependency>\n" +
"            <groupId>com.mchange</groupId>\n" +
"            <artifactId>mchange-commons-java</artifactId>\n" +
"            <version>${mchange-commons-java.version}</version>\n" +
"        </dependency>");
        
        put("asm-debug-all", "\n        <dependency>\n" +
"            <groupId>org.ow2.asm</groupId>\n" +
"            <artifactId>asm-debug-all</artifactId>\n" +
"            <version>${asm-debug-all.version}</version>\n" +
"        </dependency>");
        
        put("guava", "\n        <dependency>\n" +
"            <groupId>com.google.guava</groupId>\n" +
"            <artifactId>guava</artifactId>\n" +
"            <version>${guava.version}</version>\n" +
"        </dependency>");
        
        put("hk2-api", "\n        <dependency>\n" +
"            <groupId>org.glassfish.hk2</groupId>\n" +
"            <artifactId>hk2-api</artifactId>\n" +
"            <version>${hk2-api.version}</version>\n" +
"        </dependency>");
        
        put("hk2-locator", "\n        <dependency>\n" +
"            <groupId>org.glassfish.hk2</groupId>\n" +
"            <artifactId>hk2-locator</artifactId>\n" +
"            <version>${hk2-locator.version}</version>\n" +
"        </dependency>");
        
        put("hk2-utils", "\n        <dependency>\n" +
"            <groupId>org.glassfish.hk2</groupId>\n" +
"            <artifactId>hk2-utils</artifactId>\n" +
"            <version>${hk2-utils.version}</version>\n" +
"        </dependency>");
        
        put("jackson-annotations", "\n        <dependency>\n" +
"            <groupId>com.fasterxml.jackson.core</groupId>\n" +
"            <artifactId>jackson-annotations</artifactId>\n" +
"            <version>${jackson-annotations.version}</version>\n" +
"        </dependency>");
        
        put("jackson-module-jaxb-annotations", "\n        <dependency>\n" +
"            <groupId>com.fasterxml.jackson.module</groupId>\n" +
"            <artifactId>jackson-module-jaxb-annotations</artifactId>\n" +
"            <version>${jackson-module-jaxb-annotations.version}</version>\n" +
"        </dependency>");
        
        put("javax.annotation-api", "\n        <dependency>\n" +
"            <groupId>javax.annotation</groupId>\n" +
"            <artifactId>javax.annotation-api</artifactId>\n" +
"            <version>${javax.annotation-api.version}</version>\n" +
"        </dependency>");
        
        put("javax.inject", "\n        <dependency>\n" +
"            <groupId>org.glassfish.hk2.external</groupId>\n" +
"            <artifactId>javax.inject</artifactId>\n" +
"            <version>${javax.inject.version}</version>\n" +
"        </dependency>");
        
        put("javax.ws.rs-api", "\n        <dependency>\n" +
"            <groupId>javax.ws.rs</groupId>\n" +
"            <artifactId>javax.ws.rs-api</artifactId>\n" +
"            <version>${javax.ws.rs-api.version}</version>\n" +
"        </dependency>");
        
        put("", "\n        <dependency>\n" +
"            <groupId>org.glassfish.jersey.core</groupId>\n" +
"            <artifactId>jersey-client</artifactId>\n" +
"            <version>${jersey-client.version}</version>\n" +
"        </dependency>");
        
        put("jersey-common", "\n        <dependency>\n" +
"            <groupId>org.glassfish.jersey.core</groupId>\n" +
"            <artifactId>jersey-common</artifactId>\n" +
"            <version>${jersey.version}</version>\n" +
"        </dependency>");
        
        put("jersey-container-servlet-core", "\n        <dependency>\n" +
"            <groupId>org.glassfish.jersey.containers</groupId>\n" +
"            <artifactId>jersey-container-servlet-core</artifactId>\n" +
"            <version>${jersey.version}</version>\n" +
"        </dependency>");
        
        put("jersey-container-servlet", "\n        <dependency>\n" +
"            <groupId>org.glassfish.jersey.containers</groupId>\n" +
"            <artifactId>jersey-container-servlet</artifactId>\n" +
"            <version>${jersey.version}</version>\n" +
"        </dependency>");
        
        put("jersey-entity-filtering", "\n        <dependency>\n" +
"            <groupId>org.glassfish.jersey.ext</groupId>\n" +
"            <artifactId>jersey-entity-filtering</artifactId>\n" +
"            <version>${jersey.version}</version>\n" +
"        </dependency>");
        
        put("jersey-guava", "\n        <dependency>\n" +
"            <groupId>org.glassfish.jersey.bundles.repackaged</groupId>\n" +
"            <artifactId>jersey-guava</artifactId>\n" +
"            <version>${jersey.version}</version>\n" +
"        </dependency>");
        
        put("jersey-media-jaxb", "\n        <dependency>\n" +
"            <groupId>org.glassfish.jersey.media</groupId>\n" +
"            <artifactId>jersey-media-jaxb</artifactId>\n" +
"            <version>${jersey.version}</version>\n" +
"        </dependency>");
        
        put("jersey-media-json-jackson", "\n        <dependency>\n" +
"            <groupId>org.glassfish.jersey.media</groupId>\n" +
"            <artifactId>jersey-media-json-jackson</artifactId>\n" +
"            <version>${jersey.version}</version>\n" +
"        </dependency>");
        
        put("jersey-media-multipart", "\n        <dependency>\n" +
"            <groupId>org.glassfish.jersey.media</groupId>\n" +
"            <artifactId>jersey-media-multipart</artifactId>\n" +
"            <version>${jersey.version}</version>\n" +
"        </dependency>");
        
        put("jersey-server", "\n        <dependency>\n" +
"            <groupId>org.glassfish.jersey.core</groupId>\n" +
"            <artifactId>jersey-server</artifactId>\n" +
"            <version>${jersey.version}</version>\n" +
"        </dependency>");
        
        put("mimepull", "\n        <dependency>\n" +
"            <groupId>org.jvnet.mimepull</groupId>\n" +
"            <artifactId>mimepull</artifactId>\n" +
"            <version>${mimepull.version}</version>\n" +
"        </dependency>");
        
        put("osgi-resource-locator", "\n        <dependency>\n" +
"            <groupId>org.glassfish.hk2</groupId>\n" +
"            <artifactId>osgi-resource-locator</artifactId>\n" +
"            <version>${osgi-resource-locator.version}</version>\n" +
"        </dependency>");
        
        put("validation-api", "\n        <dependency>\n" +
"            <groupId>javax.validation</groupId>\n" +
"            <artifactId>validation-api</artifactId>\n" +
"            <version>${validation-api.version}</version>\n" +
"        </dependency>");
        
        put("asm", "\n        <dependency>\n" +
"            <groupId>net.minidev</groupId>\n" +
"            <artifactId>asm</artifactId>\n" +
"            <version>${asm.version}</version>\n" +
"        </dependency>");
        
        put("gson", "\n        <dependency>\n" +
"            <groupId>com.google.code.gson</groupId>\n" +
"            <artifactId>gson</artifactId>\n" +
"            <version>${gson.version}</version>\n" +
"        </dependency>");
        
        put("jcip-annotations", "\n        <dependency>\n" +
"            <groupId>net.jcip</groupId>\n" +
"            <artifactId>jcip-annotations</artifactId>\n" +
"            <version>${jcip-annotations.version}</version>\n" +
"        </dependency>");
        
        put("json-smart", "\n        <dependency>\n" +
"            <groupId>net.minidev</groupId>\n" +
"            <artifactId>json-smart</artifactId>\n" +
"            <version>${json-smart.version}</version>\n" +
"        </dependency>");
        
        put("nimbus-jose-jwt", "\n        <dependency>\n" +
"            <groupId>com.nimbusds</groupId>\n" +
"            <artifactId>nimbus-jose-jwt</artifactId>\n" +
"            <version>${nimbus-jose-jwt.version}</version>\n" +
"        </dependency>");
        
        put("json", "\n        <dependency>\n" +
"            <groupId>com.unboundid.components</groupId>\n" +
"            <artifactId>json</artifactId>\n" +
"            <version>${json.version}</version>\n" +
"        </dependency>");
        
        put("scim-sdk", "\n        <dependency>\n" +
"            <groupId>com.unboundid.product.scim</groupId>\n" +
"            <artifactId>scim-sdk</artifactId>\n" +
"            <version>${scim-sdk.version}</version>\n" +
"        </dependency>");
        
        put("core-io", "\n        <dependency>\n" +
"            <groupId>com.couchbase.client</groupId>\n" +
"            <artifactId>core-io</artifactId>\n" +
"            <version>${core-io.version}</version>\n" +
"        </dependency>");
        
        put("hamcrest-core", "\n        <dependency>\n" +
"            <groupId>org.hamcrest</groupId>\n" +
"            <artifactId>hamcrest-core</artifactId>\n" +
"            <version>${hamcrest-core.version}</version>\n" +
"        </dependency>");
        
        put("java-client", "\n        <dependency>\n" +
"            <groupId>com.couchbase.client</groupId>\n" +
"            <artifactId>java-client</artifactId>\n" +
"            <version>${couchbase.java-client.version}</version>\n" +
"        </dependency>");
        
        put("mail", "\n        <dependency>\n" +
"            <groupId>javax.mail</groupId>\n" +
"            <artifactId>mail</artifactId>\n" +
"            <version>${mail.version}</version>\n" +
"        </dependency>");
        
        put("mysql-connector-java", "\n        <dependency>\n" +
"            <groupId>mysql</groupId>\n" +
"            <artifactId>mysql-connector-java</artifactId>\n" +
"            <version>${mysql-connector-java.version}</version>\n" +
"        </dependency>");
        
        put("rxjava", "\n        <dependency>\n" +
"            <groupId>io.reactivex</groupId>\n" +
"            <artifactId>rxjava</artifactId>\n" +
"            <version>${rxjava.version}</version>\n" +
"        </dependency>");
        
        put("tomcat-servlet-api", "\n        <dependency>\n" +
"            <groupId>org.apache.tomcat</groupId>\n" +
"            <artifactId>tomcat-servlet-api</artifactId>\n" +
"            <version>${tomcat-servlet-api.version}</version>\n" +
"        </dependency>");
        
        put("cglib-nodep", "\n        <dependency>\n" +
"            <groupId>cglib</groupId>\n" +
"            <artifactId>cglib-nodep</artifactId>\n" +
"            <version>${cglib-nodep.version}</version>\n" +
"        </dependency>");
        
        put("easymock", "\n        <dependency>\n" +
"            <groupId>org.easymock</groupId>\n" +
"            <artifactId>easymock</artifactId>\n" +
"            <version>${easymock.version}</version>\n" +
"        </dependency>");
        
        put("junit", "\n        <dependency>\n" +
"            <groupId>junit</groupId>\n" +
"            <artifactId>junit</artifactId>\n" +
"            <version>${junit.version}</version>\n" +
"        </dependency>");
        
        put("mockito-all", "\n        <dependency>\n" +
"            <groupId>org.mockito</groupId>\n" +
"            <artifactId>mockito-all</artifactId>\n" +
"            <version>${mockito-all.version}</version>\n" +
"            <scope>test</scope>\n" + 
"        </dependency>");
        
        put("winzipaes", "\n        <dependency>\n" +
"            <groupId>de.idyl</groupId>\n" +
"            <artifactId>winzipaes</artifactId>\n" +
"            <version>${winzipaes.version}</version>\n" +
"        </dependency>");
        
        put("jsoup", "\n        <dependency>\n" +
"            <groupId>org.jsoup</groupId>\n" +
"            <artifactId>jsoup</artifactId>\n" +
"            <version>${jsoup.version}</version>\n" +
"        </dependency>");
        
        put("vaadin-server", "\n        <dependency>\n" +
"            <groupId>com.vaadin</groupId>\n" +
"            <artifactId>vaadin-server</artifactId>\n" +
    "            <version>${vaadin-server.version}</version>\n" +
"        </dependency>");
        
        put("vaadin-shared-deps", "\n        <dependency>\n" +
"            <groupId>com.vaadin</groupId>\n" +
"            <artifactId>vaadin-shared-deps</artifactId>\n" +
    "            <version>${vaadin-shared-deps.version}</version>\n" +
"        </dependency>");
        
        put("vaadin-shared", "\n        <dependency>\n" +
"            <groupId>com.vaadin</groupId>\n" +
"            <artifactId>vaadin-shared</artifactId>\n" +
"            <version>${vaadin-shared.version}</version>\n" +
"        </dependency>");
        
        put("btf", "\n        <dependency>\n" +
"            <groupId>com.github.fge</groupId>\n" +
"            <artifactId>btf</artifactId>\n" +
"            <version>${btf.version}</version>\n" +
"        </dependency>");
        
        put("jackson-coreutils", "\n        <dependency>\n" +
"            <groupId>com.github.fge</groupId>\n" +
"            <artifactId>jackson-coreutils</artifactId>\n" +
"            <version>${jackson-coreutils.version}</version>\n" +
"        </dependency>");
        
        put("jackson-jaxrs-base", "\n        <dependency>\n" +
"            <groupId>com.fasterxml.jackson.jaxrs</groupId>\n" +
"            <artifactId>jackson-jaxrs-base</artifactId>\n" +
"            <version>${jackson-jaxrs-base.version}</version>\n" +
"        </dependency>");
        
        put("jackson-jaxrs-json-provider", "\n        <dependency>\n" +
"            <groupId>com.fasterxml.jackson.jaxrs</groupId>\n" +
"            <artifactId>jackson-jaxrs-json-provider</artifactId>\n" +
"            <version>${jackson-jaxrs-json-provider.version}</version>\n" +
"        </dependency>");
        
        put("json-schema-core", "\n        <dependency>\n" +
"            <groupId>com.github.fge</groupId>\n" +
"            <artifactId>json-schema-core</artifactId>\n" +
"            <version>${json-schema-core.version}</version>\n" +
"        </dependency>");
        
        put("json-schema-validator", "\n        <dependency>\n" +
"            <groupId>com.github.fge</groupId>\n" +
"            <artifactId>json-schema-validator</artifactId>\n" +
"            <version>${json-schema-validator.version}</version>\n" +
"        </dependency>");
        
        put("msg-simple", "\n        <dependency>\n" +
"            <groupId>com.github.fge</groupId>\n" +
"            <artifactId>msg-simple</artifactId>\n" +
"            <version>${msg-simple.version}</version>\n" +
"        </dependency>");
        
        put("uri-template", "\n        <dependency>\n" +
"            <groupId>com.github.fge</groupId>\n" +
"            <artifactId>uri-template</artifactId>\n" +
"            <version>${uri-template.version}</version>\n" +
"        </dependency>");
                
        put("javax.servlet", "\n        <dependency>\n" +
"            <groupId>javax.servlet</groupId>\n" +
"            <artifactId>servlet-api</artifactId>\n" +
"            <version>${javax.servlet.version}</version>\n" +
"        </dependency>");
       
        put("ajaxswing", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>ajaxswing</artifactId>\n" +
"            <version>${ajaxswing.version}</version>\n" +
"        </dependency>");
                
        put("iaik_ssl", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>iaik_ssl</artifactId>\n" +
"            <version>${iaik.version}</version>\n" +
"        </dependency>");
        
        put("junit-4.10", "\n        <dependency>\n" +
"            <groupId>junit</groupId>\n" +
"            <artifactId>junit</artifactId>\n" +
"            <version>${junit.version}</version>\n");
        
        put("mockito-all-1.9.5", "\n        <dependency>\n" +
"            <groupId>org.mockito</groupId>\n" +
"            <artifactId>mockito-all</artifactId>\n" +
"            <version>${mockito-all.version}</version>\n");
        
        put("bcprov", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>bcprov</artifactId>\n" +
"            <version>${bouncy-castle.version}</version>\n" +
"        </dependency>");
        
        put("jaxp", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>jaxp</artifactId>\n" +
"            <version>${jaxp.version}</version>\n" +
"        </dependency>");
        
        put("crimson", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>crimson</artifactId>\n" +
"            <version>${crimson.version}</version>\n" +
"        </dependency>");
        
        put("sax2", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>sax2</artifactId>\n" +
"            <version>${sax2.version}</version>\n" +
"        </dependency>");
        
        put("powermock-easymock-1.5.1-full", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>powermock-easymock-1.5.1-full</artifactId>\n" +
"            <version>${powermock-easymock-release-full.version}</version>\n");
        
        put("powermock-mockito-1.5.1-full", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>powermock-mockito-1.5.1-full</artifactId>\n" +
"            <version>${powermock-mockito-1.5.1-full.version}</version>\n");
        
        put("easymock-3.1", "\n        <dependency>\n" +
"            <groupId>org.easymock</groupId>\n" +
"            <artifactId>easymock</artifactId>\n" +
"            <version>${easymock.version}</version>\n");
        
        put("testng-6.8", "\n        <dependency>\n" +
"            <groupId>org.testng</groupId>\n" +
"            <artifactId>testng</artifactId>\n" +
"            <version>${testng.version}</version>\n");
        
        put("asboot", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>asboot</artifactId>\n" +
"            <version>${asboot.version}</version>\n" +
"        </dependency>");
        
        put("cglib-nodep-2.2.2", "\n        <dependency>\n" +
"            <groupId>cglib</groupId>\n" +
"            <artifactId>cglib-nodep</artifactId>\n" +
"            <version>${cglib.version}</version>\n");
        
        put("jt400", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>jt400</artifactId>\n" +
"            <version>${jt400.version}</version>\n" +
"        </dependency>");
        
        put("jacocoant", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>jacocoant</artifactId>\n" +
"            <version>${jacocoant.version}</version>\n" +
"        </dependency>");
        
        put("jsonrpc-1.0", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>jsonrpc-1.0</artifactId>\n" +
"            <version>${jsonrpc-1.0.version}</version>\n" +
"        </dependency>");
        
        put("log4j", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>log4j</artifactId>\n" +
"            <version>${log4j.version}</version>\n" +
"        </dependency>");
        
        put("xmlParserAPIs", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>xmlParserAPIs</artifactId>\n" +
"            <version>${xmlParserAPIs.version}</version>\n" +
"        </dependency>");
        
        put("jce-jdk13-119", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>bcpg</artifactId>\n" +
"            <version>${bouncy-castle.version}</version>\n" +
"        </dependency>");
        
        put("iaik_jce", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>iaik_jce</artifactId>\n" +
"            <version>${iaik.version}</version>\n" +
"        </dependency>");
        
        put("ant", "\n        <dependency>\n" +
"            <groupId>org.apache.ant</groupId>\n" +
"            <artifactId>ant</artifactId>\n" +
"            <version>${ant.version}</version>\n" +
"        </dependency>");
        
        put("iaik_cms", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>iaik_cms</artifactId>\n" +
"            <version>${iaik.version}</version>\n" +
"        </dependency>");
        
        put("bcpg", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>bcpg</artifactId>\n" +
"            <version>${bouncy-castle.version}</version>\n" +
"        </dependency>");
        
        put("gwt-servlet", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>gwt-servlet</artifactId>\n" +
"            <version>${gwt-servlet.version}</version>\n" +
"        </dependency>");

        put("apache-mime4j", "\n        <dependency>\n" +
"            <groupId>org.apache.james</groupId>\n" +
"            <artifactId>apache-mime4j</artifactId>\n" +
"            <version>${apache-mime4j.version}</version>\n" +
"        </dependency>");
        
        put("iaik_javax_crypto", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>iaik_javax_crypto</artifactId>\n" +
"            <version>${iaik.version}</version>\n" +
"        </dependency>");
        
        put("snmp4j-agent", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>snmp4j-agent</artifactId>\n" +
"            <version>${snmp4j-agent.version}</version>\n" +
"        </dependency>");
        
        put("snmp4j", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>snmp4j</artifactId>\n" +
"            <version>${snmp4j.version}</version>\n" +
"        </dependency>");
        
        put("jewt", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>jewt</artifactId>\n" +
"            <version>${jewt.version}</version>\n" +
"        </dependency>");
        
        put("share", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>share</artifactId>\n" +
"            <version>${share.version}</version>\n" +
"        </dependency>");
        
        put("oracle_ice", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>oracle_ice</artifactId>\n" +
"            <version>${oracle_ice.version}</version>\n" +
"        </dependency>");
        
        put("help-share", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>help-share</artifactId>\n" +
"            <version>${help-share.version}</version>\n" +
"        </dependency>");
        
        put("wcboot", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>wcboot</artifactId>\n" +
"            <version>${wcboot.version}</version>\n" +
"        </dependency>");
        
        put("wizardpane", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>wizardpane</artifactId>\n" +
"            <version>${wizardpane.version}</version>\n" +
"        </dependency>");
        
        put("ediframe", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>ediframe</artifactId>\n" +
"            <version>${ediframe.version}</version>\n" +
"        </dependency>");
        
        put("connector", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>connector</artifactId>\n" +
"            <version>${connector.version}</version>\n" +
"        </dependency>");
        
        put("com.ibm.mq", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>com.ibm.mq</artifactId>\n" +
"            <version>${com.ibm.mq.version}</version>\n" +
"        </dependency>");
        
        put("webcream", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>webcream</artifactId>\n" +
"            <version>${webcream.version}</version>\n" +
"        </dependency>");
        
        put("jcifs", "\n        <dependency>\n" +
"            <groupId>com.cleo.base</groupId>\n" +
"            <artifactId>jcifs-1.3.14</artifactId>\n" +
"            <version>${version.cleo}</version>\n" +
"        </dependency>");
        
        put("js", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>js</artifactId>\n" +
"            <version>${js.version}</version>\n" +
"        </dependency>");
        
        put("sfc", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>sfc</artifactId>\n" +
"            <version>${sfc.version}</version>\n" +
"        </dependency>");
        
        put("ohj", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>ohj</artifactId>\n" +
"            <version>${ohj.version}</version>\n" +
"        </dependency>");
        
        put("lexhelp-javahelp", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>lexhelp-javahelp</artifactId>\n" +
"            <version>${lexhelp-javahelp.version}</version>\n" +
"        </dependency>");
        
        put("slf4j-api", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>slf4j-api</artifactId>\n" +
"            <version>${slf4j-api.version}</version>\n" +
"        </dependency>");
        
        put("slf4j", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>slf4j</artifactId>\n" +
"            <version>${slf4j.version}</version>\n" +
"        </dependency>");
        
        put("aspera-faspmanager", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>aspera-faspmanager</artifactId>\n" +
"            <version>${aspera-faspmanager.version}</version>\n" +
"        </dependency>");
        
        put("aspera-cmdclient", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>aspera-cmdclient</artifactId>\n" +
"            <version>${aspera-cmdclient.version}</version>\n" +
"        </dependency>");
        
        put("com.ibm.mq.commonservices", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>com.ibm.mq.commonservices</artifactId>\n" +
"            <version>${com.ibm.mq.commonservices.version}</version>\n" +
"        </dependency>");
        
        put("com.ibm.mq.jmqi", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>com.ibm.mq.jmqi</artifactId>\n" +
"            <version>${com.ibm.mq.jmqi.version}</version>\n" +
"        </dependency>");
        
        put("com.ibm.mq.pcf", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>com.ibm.mq.pcf</artifactId>\n" +
"            <version>${com.ibm.mq.pcf.version}</version>\n" +
"        </dependency>");
        
        put("com.ibm.mq.headers", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>com.ibm.mq.headers</artifactId>\n" +
"            <version>${com.ibm.mq.headers.version}</version>\n" +
"        </dependency>");
        
        put("swing-layout", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>swing-layout</artifactId>\n" +
"            <version>${swing-layout.version}</version>\n" +
"        </dependency>");
        
        put("XmlSchema", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>XmlSchema</artifactId>\n" +
"            <version>${XmlSchema.version}</version>\n" +
"        </dependency>");
        
        put("xmltooling", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>xmltooling</artifactId>\n" +
"            <version>${xmltooling.version}</version>\n" +
"        </dependency>");
        
        put("rampart-core", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>rampart-core</artifactId>\n" +
"            <version>${rampart-core.version}</version>\n" +
"        </dependency>");
        
        put("wstx-asl", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>wstx-asl</artifactId>\n" +
"            <version>${wstx-asl.version}</version>\n" +
"        </dependency>");
        
        put("rampart-policy", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>rampart-policy</artifactId>\n" +
"            <version>${rampart-policy.version}</version>\n" +
"        </dependency>");
        
        put("rampart-trust", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>rampart-trust</artifactId>\n" +
"            <version>${rampart-trust.version}</version>\n" +
"        </dependency>");
        
        put("velocity", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>velocity</artifactId>\n" +
"            <version>${velocity.version}</version>\n" +
"        </dependency>");
        
        put("openws", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>openws</artifactId>\n" +
"            <version>${openws.version}</version>\n" +
"        </dependency>");
        
        put("assertj-core", "\n        <dependency>\n" +
"            <groupId>org.assertj</groupId>\n" +
"            <artifactId>assertj-core</artifactId>\n" +
"            <version>${assertj-core.version}</version>\n" +
"            <scope>test</scope>\n" + 
"        </dependency>");
        
        put("jackson-databind", "\n        <dependency>\n" +
"            <groupId>com.fasterxml.jackson.core</groupId>\n" +
"            <artifactId>jackson-databind</artifactId>\n" +
"            <version>${jackson-databind.version}</version>\n" +
"        </dependency>");
        
        put("javax.servlet-api", "\n        <dependency>\n" +
"            <groupId>javax.servlet</groupId>\n" +
"            <artifactId>javax.servlet-api</artifactId>\n" +
"            <version>${javax.servlet-api.version}</version>\n" +
"        </dependency>");
        
        put("servlet-api", "\n        <dependency>\n" +
"            <groupId>javax.servlet</groupId>\n" +
"            <artifactId>servlet-api</artifactId>\n" +
"            <version>${servlet-api.version}</version>\n" +
"        </dependency>");
        
        put("servlet-api-2.5", "\n        <dependency>\n" +
"            <groupId>javax.servlet</groupId>\n" +
"            <artifactId>servlet-api</artifactId>\n" +
"            <version>${servlet-api-2.5.version}</version>\n" +
"        </dependency>");
        
        put("jersey-client", "\n        <dependency>\n" +
"            <groupId>org.glassfish.jersey.core</groupId>\n" +
"            <artifactId>jersey-client</artifactId>\n" +
"            <version>${jersey-client.version}</version>\n" +
"        </dependency>");
        
        put("jta", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>jta</artifactId>\n" +
"            <version>${jta.version}</version>\n" +
"        </dependency>");
        
        put("slf4j-simple", "\n        <dependency>\n" +
"            <groupId>org.slf4j</groupId>\n" +
"            <artifactId>slf4j-simple</artifactId>\n" +
"            <version>${slf4j-simple.version}</version>\n" +
"        </dependency>");
        
        put("jersey-test-framework-core", "\n        <dependency>\n" +
"            <groupId>org.glassfish.jersey.test-framework</groupId>\n" +
"            <artifactId>jersey-test-framework-core</artifactId>\n" +
"            <version>${jersey-test-framework-core.version}</version>\n" +
"            <scope>test</scope>\n" +
"        </dependency>");
        
        put("jersey-test-framework-provider-inmemory", "\n        <dependency>\n" +
"            <groupId>org.glassfish.jersey.test-framework.providers</groupId>\n" +
"            <artifactId>jersey-test-framework-provider-inmemory</artifactId>\n" +
"            <version>${jersey-test-framework-provider-inmemory.version}</version>\n" +
"            <scope>test</scope>\n" +
"        </dependency>");
        
        put("testng", "\n        <dependency>\n" +
"            <groupId>org.testng</groupId>\n" +
"            <artifactId>testng</artifactId>\n" +
"            <version>${testng.version}</version>\n" +
"            <scope>test</scope>\n" +
"        </dependency>");
        
        put("java-diff", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>java-diff</artifactId>\n" +
"            <version>${java-diff.version}</version>\n" +
"        </dependency>");
        
        put("jcommon", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>jcommon</artifactId>\n" +
"            <version>${jcommon.version}</version>\n" +
"        </dependency>");
        
        put("JRESServlets", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>JRESServlets</artifactId>\n" +
"            <version>${JRESServlets.version}</version>\n" +
"        </dependency>");
        
        put("AppletIntegration", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>AppletIntegration</artifactId>\n" +
"            <version>${AppletIntegration.version}</version>\n" +
"        </dependency>");
        
        put("JREngine", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>JREngine</artifactId>\n" +
"            <version>${JREngine.version}</version>\n" +
"        </dependency>");
        
        put("elasticsearch", "\n        <dependency>\n" +
"            <groupId>org.elasticsearch</groupId>\n" +
"            <artifactId>elasticsearch</artifactId>\n" +
"            <version>${elasticsearch.version}</version>\n" +
"        </dependency>");
        
        put("jfreechart-1.0.9", "\n        <dependency>\n" +
"            <groupId>jfree</groupId>\n" +
"            <artifactId>jfreechart</artifactId>\n" +
"            <version>${jfreechart.version}</version>\n" +
"        </dependency>");
        
        put("jms", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>jms</artifactId>\n" +
"            <version>${jms.version}</version>\n" +
"        </dependency>");
        
        put("openbpm", "\n        <dependency>\n" +
"            <groupId>com.cleo</groupId>\n" +
"            <artifactId>openbpm</artifactId>\n" +
"            <version>${openbpm.version}</version>\n" +
"        </dependency>");
    }
    
}
