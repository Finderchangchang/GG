package wz.gg;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/10/29.
 */

public class KeyModel implements Serializable{

    /**
     * appForwardurl : http://www.baidu1.com
     * appName : a???
     * id : 1
     * navigationStatus : on
     * navigationTitle1 :
     * navigationTitle2 :
     * navigationUrl1 :
     * navigationUrl2 :
     * updateStatus : on
     * updateUrl : http://tengxu1.com
     * version : 1
     */

    private String appForwardurl;
    private String appName;
    private int id;
    private String navigationStatus;
    private String navigationTitle1;
    private String navigationTitle2;
    private String navigationUrl1;
    private String navigationUrl2;
    private String updateStatus;
    private String updateUrl;
    private String version;

    public String getAppForwardurl() {
        return appForwardurl;
    }

    public void setAppForwardurl(String appForwardurl) {
        this.appForwardurl = appForwardurl;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavigationStatus() {
        return navigationStatus;
    }

    public void setNavigationStatus(String navigationStatus) {
        this.navigationStatus = navigationStatus;
    }

    public String getNavigationTitle1() {
        return navigationTitle1;
    }

    public void setNavigationTitle1(String navigationTitle1) {
        this.navigationTitle1 = navigationTitle1;
    }

    public String getNavigationTitle2() {
        return navigationTitle2;
    }

    public void setNavigationTitle2(String navigationTitle2) {
        this.navigationTitle2 = navigationTitle2;
    }

    public String getNavigationUrl1() {
        return navigationUrl1;
    }

    public void setNavigationUrl1(String navigationUrl1) {
        this.navigationUrl1 = navigationUrl1;
    }

    public String getNavigationUrl2() {
        return navigationUrl2;
    }

    public void setNavigationUrl2(String navigationUrl2) {
        this.navigationUrl2 = navigationUrl2;
    }

    public String getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
