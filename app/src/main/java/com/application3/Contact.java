package com.application3;

public class Contact
{
    String name;
    String address;
    String url;

    public Contact() {}
    public Contact(String name, String address, String url)
    {
        this.name=name;
        this.address=address;
        this.url=url;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
