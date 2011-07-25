/*    */ package fmcom;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.IOException;
/*    */ import java.net.URLEncoder;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletOutputStream;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.commons.codec.binary.Base64;
/*    */ 
/*    */ public class SaveFile extends HttpServlet
/*    */ {
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 11 */     doPost(request, response);
/*    */   }
/*    */ 
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 15 */     String path = request.getParameter("path");
/* 16 */     String name = request.getParameter("name");
/*    */ 
/* 18 */     String fpath = new String(Base64.decodeBase64(name.getBytes()));
/* 19 */     File file = new File(fpath);
/* 20 */     if (file.isFile()) {
/* 21 */       response.setContentType("application/x-unknown;charset=GB2312");
/* 22 */       response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF8"));
/* 23 */       response.setContentLength((int)file.length());
/* 24 */       int i = 0;
/* 25 */       byte[] bt = new byte[8192];
/* 26 */       FileInputStream fis = new FileInputStream(file);
/* 27 */       ServletOutputStream sos = response.getOutputStream();
/* 28 */       while ((i = fis.read(bt)) != -1) {
/* 29 */         sos.write(bt, 0, i);
/*    */       }
/* 31 */       sos.flush();
/* 32 */       sos.close();
/* 33 */       sos = null;
/* 34 */       fis.close();
/*    */     }
/*    */   }
/*    */ }

/* Location:           D:\project\代码\b2b-new-20090709\b2bv2-Pure-Simplify\WEB-INF\classes\
 * Qualified Name:     fmcom.SaveFile
 * JD-Core Version:    0.6.0
 */