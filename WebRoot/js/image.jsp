<%@ page import="java.awt.*" %>
<%@ page import="java.awt.event.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.awt.image.*"%>
<%@ page import="org.w3c.dom.*"%>
<%@ page import="com.sun.image.codec.jpeg.*"%>
<%@ page import="javax.imageio.*"%>

<%!
public static boolean  ImgYin(String Imagename_biao,String ImgName){
try{
File _file = new File(ImgName);
Image src = ImageIO.read(_file);
int wideth=src.getWidth(null);
int height=src.getHeight(null);
BufferedImage image=new BufferedImage(wideth,height,BufferedImage.TYPE_INT_RGB);
Graphics g=image.createGraphics();
g.drawImage(src,0,0,wideth,height,null);

//水印文件
File _filebiao = new File(Imagename_biao);
Image src_biao = ImageIO.read(_filebiao);
int wideth_biao=src_biao.getWidth(null);
int height_biao=src_biao.getHeight(null);
g.drawImage(src_biao,wideth-110,height-110,wideth_biao,height_biao,null);
//水印文件在原图片文件的位置，原图片文件的右下角为wideth-0,height-0
 g.dispose();
FileOutputStream out=new FileOutputStream(ImgName);
JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out); 
encoder.encode(image);
out.close();
return true;
}
catch(Exception e){
System.out.println(e);
return false;
}
}



%>



