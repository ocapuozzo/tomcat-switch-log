package nagios;



public class Switch  {
private String name;
private String fullName;
private String ip;
private String parent;

    public Switch(String name, String fullName, String ip, String parent) {
        this.name = name;
        this.fullName = fullName;
        this.ip = ip;
        this.parent = parent;
    }

    public Switch() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
