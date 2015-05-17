/*
 * ByteArrayDataSource.java
 *
 * Created on 17 november 2004, 16:55
 */

package org.apache.commons.mail;

import javax.activation.DataSource;
import java.io.*;

/** 
 * A DataSource implementation that may be used to feed images
 * to emails (inline or attached), that are available as byte arrays.
 *
 * <p>It saves the trouble of saving and reading them back in.
 *
 * @author <a href="mailto:chrisvanlith@b3partners.nl">Chris van Lith</a>
 * @version $Id: ByteArrayDataSource.java,v 1.0 2004/11/17 16:55 epugh Exp $
 */
public class ByteArrayDataSource implements DataSource {
 
    String contentType = "text/plain";
    ByteArrayOutputStream baos = null;
    
    /** Creates a new instance of ByteArrayDataSource */
    public ByteArrayDataSource(byte[] anArray, String aContentType) throws IOException {
        baos = new ByteArrayOutputStream();
        baos.write(anArray);
        contentType = aContentType;
    }
    
    public String getContentType() {
        return contentType;
    }
    
    public java.io.InputStream getInputStream() throws java.io.IOException {
       return new ByteArrayInputStream(baos.toByteArray());
    }
    
    public String getName() {
        return "Dummy";
    }
    
    public java.io.OutputStream getOutputStream() throws java.io.IOException {
       return baos;
    }
    
}
