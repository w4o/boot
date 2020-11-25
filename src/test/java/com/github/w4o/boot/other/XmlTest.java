package com.github.w4o.boot.other;

import com.github.w4o.boot.bean.N2root;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

/**
 * @author frank
 * @date 2020/4/21
 */
public class XmlTest {

    @Test
    public void testN2Root() throws Exception {
        N2root n2root = N2root.builder()
                .id("20041608501803200702")
                .action("splacetrade")
                .request(
                        N2root.Request.builder()
                                .trades(
                                        List.of(
                                                N2root.Request.Trade.builder().id(900978).area("bank").build(),
                                                N2root.Request.Trade.builder().id(900979).area("bank").build()
                                        )
                                )
                                .userId("test041").build()
                ).build();

        JAXBContext jaxbContext = JAXBContext.newInstance(N2root.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-16");
        marshaller.marshal(n2root, new File("c.xml"));
        marshaller.marshal(n2root, System.out);
    }

}


