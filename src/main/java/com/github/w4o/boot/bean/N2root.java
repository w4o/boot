package com.github.w4o.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author frank
 */
@Data
@Builder
@XmlRootElement(name = "n2root", namespace = "urn:n2ns")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
public class N2root {

    @XmlAttribute(name = "action")
    private String action;

    @XmlAttribute(name = "id")
    private String id;

    @XmlElement(name = "request")
    private Request request;

    @Data
    @Builder
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Request {

        @XmlElement(name = "userid")
        private String userId;
        @XmlElement(name = "trades")
        private List<Trade> trades;

        @Data
        @Builder
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Trade {
            @XmlAttribute
            private Integer id;
            @XmlElement
            private String area;
        }
    }
}