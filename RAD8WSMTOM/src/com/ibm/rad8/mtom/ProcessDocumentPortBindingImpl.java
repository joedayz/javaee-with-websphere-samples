package com.ibm.rad8.mtom;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.activation.DataHandler;
import javax.imageio.ImageIO;


@javax.jws.WebService (endpointInterface="com.ibm.rad8.mtom.ProcessDocumentDelegate", targetNamespace="http://mtom.rad8.ibm.com/", serviceName="ProcessDocumentService", portName="ProcessDocumentPort")
@javax.xml.ws.BindingType (value=javax.xml.ws.soap.SOAPBinding.SOAP11HTTP_MTOM_BINDING)
public class ProcessDocumentPortBindingImpl{

	public byte[] sendWordFile(byte[] arg0) {
		try {
			FileOutputStream fileOut = new FileOutputStream
				(new File("D:\\7835code\\webservices\\mtomresult\\RAD-intro.doc"));
			fileOut.write(arg0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arg0;
	}

    public Image sendImage(Image arg0) {
		try {
			File file = new File("D:/7835code/webservices/mtomresult/BlueHills.jpg");
			BufferedImage bi = new BufferedImage(arg0.getWidth(null), 
								arg0.getHeight(null), BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = bi.createGraphics();
			g2d.drawImage(arg0, 0, 0, null);
			ImageIO.write(bi, "jpeg", file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arg0;
    }

    public DataHandler sendPDFFile(DataHandler arg0) {
		try {
			FileOutputStream fileOut = new FileOutputStream(
					new File("D:/7835code/webservices/mtomresult/JAX-WS.pdf"));
			BufferedInputStream fileIn = new BufferedInputStream(arg0.getInputStream());
			while (fileIn.available() != 0) {
				fileOut.write(fileIn.read());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arg0;
	}

}