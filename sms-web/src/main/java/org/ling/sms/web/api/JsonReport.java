package org.ling.sms.web.api;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//curl -v -X POST -H "Content-Type: application/json" http://127.0.0.1:8080/report/setJsonReport -d "{\"id\":\"aa\",\"content\":\"bbbbbb\"}"


@XmlRootElement(name = "report")
@XmlAccessorType(XmlAccessType.FIELD)
public class JsonReport {
  @XmlElement(name = "id")
  private String id;

  @XmlElement(name = "content")
  private String content;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
