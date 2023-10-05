package com.github.diegopacheco.pippo.advanced;

import ro.pippo.controller.*;
import ro.pippo.core.FileItem;

import java.io.File;

@Path("/files")
public class FilesController extends Controller {

    @GET
    public void index() {
        // send a template with name "files" as response
        getRouteContext().render("files");
    }

    @GET("/download")
    public File download() {
        // send a file as response
        return new File("pom.xml");
    }

    @POST("/upload")
    @Produces(Produces.TEXT)
    public String upload(FileItem file) {
        // send a text (the info about uploaded file) as response
//        return file.toString();
        return new StringBuilder()
                .append(file.getName()).append("\n")
                .append(file.getSubmittedFileName()).append("\n")
                .append(file.getSize()).append("\n")
                .append(file.getContentType())
                .toString();
    }

}
