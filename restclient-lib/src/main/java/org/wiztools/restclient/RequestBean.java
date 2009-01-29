package org.wiztools.restclient;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author schandran
 */
public final class RequestBean implements Cloneable{
    
    private URL url;
    private String method;
    private boolean authPreemptive;
    private List<String> authMethods;
    private String authHost;
    private String authRealm;
    private String authUsername;
    private char[] authPassword;
    private Map<String, String> headers;
    private ReqEntityBean body;
    private String testScript;
    private String sslTrustStore;
    private char[] sslTrustStorePassword;
    private SSLHostnameVerifier sslHostNameVerifier;
    private HTTPVersion httpVersion = HTTPVersion.getDefault(); // Initialize to the default version

    public HTTPVersion getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(HTTPVersion httpVersion) {
        this.httpVersion = httpVersion;
    }

    public String getSslTrustStore() {
        return sslTrustStore;
    }

    public void setSslTrustStore(String sslKeyStore) {
        this.sslTrustStore = sslKeyStore;
    }

    public char[] getSslTrustStorePassword() {
        return sslTrustStorePassword;
    }

    public void setSslTrustStorePassword(char[] sslKeyStorePassword) {
        this.sslTrustStorePassword = sslKeyStorePassword;
    }

    public SSLHostnameVerifier getSslHostNameVerifier() {
        return sslHostNameVerifier;
    }

    public void setSslHostNameVerifier(SSLHostnameVerifier sslHostNameVerifier) {
        this.sslHostNameVerifier = sslHostNameVerifier;
    }
    
    public String getTestScript() {
        return testScript;
    }

    public void setTestScript(String testScript) {
        this.testScript = testScript;
    }

    public ReqEntityBean getBody() {
        return body;
    }
    
    public void setBody(final ReqEntityBean body){
        this.body = body;
    }
    
    public boolean isAuthPreemptive() {
        return authPreemptive;
    }

    public void setAuthPreemptive(boolean authPreemptive) {
        this.authPreemptive = authPreemptive;
    }

    public List<String> getAuthMethods() {
        return Collections.unmodifiableList(authMethods);
    }

    public void addAuthMethod(final String authMethod) {
        this.authMethods.add(authMethod);
    }

    public String getAuthHost() {
        return authHost;
    }

    public void setAuthHost(String authHost) {
        this.authHost = authHost;
    }

    public char[] getAuthPassword() {
        return authPassword;
    }

    public void setAuthPassword(char[] authPassword) {
        this.authPassword = authPassword;
    }

    public String getAuthRealm() {
        return authRealm;
    }

    public void setAuthRealm(String authRealm) {
        this.authRealm = authRealm;
    }

    public String getAuthUsername() {
        return authUsername;
    }

    public void setAuthUsername(String authUsername) {
        this.authUsername = authUsername;
    }

    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(headers);
    }

    public void addHeader(final String key, final String value){
        this.headers.put(key, value);
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
    
    public RequestBean(){
        headers = new LinkedHashMap();
        authMethods = new ArrayList<String>();
    }
    
    @Override
    public Object clone(){
        RequestBean cloned = new RequestBean();
        cloned.setAuthHost(authHost);
        cloned.setAuthPassword(authPassword);
        cloned.setAuthPreemptive(authPreemptive);
        cloned.setAuthRealm(authRealm);
        cloned.setAuthUsername(authUsername);
        cloned.setSslTrustStore(sslTrustStore);
        cloned.setSslTrustStorePassword(sslTrustStorePassword);
        cloned.setHttpVersion(httpVersion);
        if(body != null){
            cloned.setBody((ReqEntityBean)body.clone());
        }
        if(headers.size() != 0){
            for(String header: headers.keySet()){
                cloned.addHeader(header, headers.get(header));
            }
        }
        cloned.setMethod(method);
        cloned.setTestScript(testScript);
        cloned.setUrl(url);
        return cloned;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o instanceof RequestBean){
            final RequestBean bean = (RequestBean)o;
            boolean isEqual = true;
            isEqual = isEqual && (this.method == null? bean.method == null: this.method.equals(bean.method));
            isEqual = isEqual && (this.headers == null? bean.headers == null: this.headers.equals(bean.headers));
            isEqual = isEqual && (this.body == null? bean.body == null: this.body.equals(bean.body));
            isEqual = isEqual && (this.authHost == null? bean.authHost == null: this.authHost.equals(bean.authHost));
            isEqual = isEqual && (this.authMethods == null? bean.authMethods == null: this.authMethods.equals(bean.authMethods));
            isEqual = isEqual && (this.authPassword == null? bean.authPassword == null: Arrays.equals(this.authPassword, bean.authPassword));
            isEqual = isEqual && (this.authPreemptive == bean.authPreemptive);
            isEqual = isEqual && (this.authRealm == null? bean.authRealm == null: this.authRealm.equals(bean.authRealm));
            isEqual = isEqual && (this.authUsername == null? bean.authUsername == null: this.authUsername.equals(bean.authUsername));
            isEqual = isEqual && (this.sslTrustStore == null? bean.sslTrustStore == null: this.sslTrustStore.equals(bean.sslTrustStore));
            isEqual = isEqual && (this.sslTrustStorePassword == null? bean.sslTrustStorePassword == null: Arrays.equals(this.sslTrustStorePassword, bean.sslTrustStorePassword));
            isEqual = isEqual && (this.sslHostNameVerifier == null? bean.sslHostNameVerifier == null: this.sslHostNameVerifier == bean.sslHostNameVerifier);
            isEqual = isEqual && (this.httpVersion == null? bean.httpVersion == null: this.httpVersion == bean.httpVersion);
            isEqual = isEqual && (this.testScript == null? bean.testScript == null: this.testScript.equals(bean.testScript));
            isEqual = isEqual && (this.url == null? bean.url == null: this.url.equals(bean.url));
            return isEqual;
        }
        return false;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (this.url != null ? this.url.hashCode() : 0);
        hash = 61 * hash + (this.method != null ? this.method.hashCode() : 0);
        hash = 61 * hash + (this.authPreemptive ? 1 : 0);
        hash = 61 * hash + (this.authMethods != null ? this.authMethods.hashCode() : 0);
        hash = 61 * hash + (this.authHost != null ? this.authHost.hashCode() : 0);
        hash = 61 * hash + (this.authRealm != null ? this.authRealm.hashCode() : 0);
        hash = 61 * hash + (this.authUsername != null ? this.authUsername.hashCode() : 0);
        hash = 61 * hash + (this.authPassword != null ? this.authPassword.hashCode() : 0);
        hash = 61 * hash + (this.headers != null ? this.headers.hashCode() : 0);
        hash = 61 * hash + (this.body != null ? this.body.hashCode() : 0);
        hash = 61 * hash + (this.testScript != null ? this.testScript.hashCode() : 0);
        hash = 61 * hash + (this.sslTrustStore != null ? this.sslTrustStore.hashCode() : 0);
        hash = 61 * hash + (this.sslTrustStorePassword != null ? this.sslTrustStorePassword.hashCode() : 0);
        hash = 61 * hash + (this.sslHostNameVerifier != null ? this.sslHostNameVerifier.hashCode() : 0);
        hash = 61 * hash + (this.httpVersion != null ? this.httpVersion.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("@Request[");
        sb.append(url).append(", ");
        sb.append(method).append(", ");
        sb.append(headers.toString()).append(", ");
        sb.append(body).append(", ");
        sb.append(authMethods).append(", ");
        sb.append(authPreemptive).append(", ");
        sb.append(authHost).append(", ");
        sb.append(authRealm).append(", ");
        sb.append(authUsername).append(", ");
        sb.append(authPassword==null?"null": new String(authPassword).replaceAll(".", "X")).append(", ");
        sb.append(sslTrustStore).append(", ");
        sb.append(sslTrustStorePassword==null?"null": new String(sslTrustStorePassword).replaceAll(".", "X")).append(", ");
        sb.append(sslHostNameVerifier).append(", ");
        sb.append(httpVersion).append(", ");
        sb.append(testScript);
        sb.append("]");
        return sb.toString();
    }
}