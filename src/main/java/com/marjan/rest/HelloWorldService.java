package com.marjan.rest;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;

@Path("/hello")
public class HelloWorldService {

    @GET
    @Path("get/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        // http://localhost:8080/rest/hello/get/theMessage
        String output = "Server response: " + msg;
        return Response.status(200).entity(output).build();
    }

    @POST
    @Path("/pdf")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Response uploadPdfFile(@FormDataParam("fileFormAttribute") InputStream fileInputStream,
                                  @FormDataParam("fileFormAttribute") FormDataContentDisposition fileMetaData) throws Exception {
        // http://localhost:8080/rest/hello/pdf
        String UPLOAD_PATH = "C:\\Users\\Antic\\Desktop\\Upload_Files\\";
        try {
            int read = 0;
            byte[] bytes = new byte[1024];

            OutputStream out = new FileOutputStream(new File(UPLOAD_PATH + fileMetaData.getFileName()));
            while ((read = fileInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            return Response.ok("ERROR !!" + e.getMessage()).build();
        }
        return Response.ok("Data uploaded successfully !!").build();
    }
}