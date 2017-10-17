package com.github.diegopacheco.sandbox.java.task.ant;

import java.io.File;
import java.io.PrintStream;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DefaultLogger;
import org.apache.tools.ant.DemuxOutputStream;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Echo;
import org.apache.tools.ant.taskdefs.Java;
import org.apache.tools.ant.types.Path;

import com.github.diegopacheco.sandbox.java.task.MyHelloWorldClass;

public class AntRunner {
	public static void main(String[] args) throws Exception {

		Project project = new Project();
		project.setBaseDir( new File(new File(".").getCanonicalPath() + "/build")  );
		project.init();
		DefaultLogger logger = new DefaultLogger();
		project.addBuildListener(logger);
		logger.setOutputPrintStream(System.out);
		logger.setErrorPrintStream(System.err);
		logger.setMessageOutputLevel(Project.MSG_INFO);
		System.setOut(new PrintStream(new DemuxOutputStream(project, false)));
		System.setErr(new PrintStream(new DemuxOutputStream(project, true)));
		project.fireBuildStarted();

		System.out.println("running");
		Throwable caught = null;
		try {
			Echo echo = new Echo();
			echo.setTaskName("Echo");
			echo.setProject(project);
			echo.init();
			echo.setMessage("Launching Some Class");
			echo.execute();

			Java javaTask = new Java();
			javaTask.setTaskName("runjava");
			javaTask.setProject(project);
			javaTask.setFork(true);
			javaTask.setFailonerror(true);
			javaTask.setClassname(MyHelloWorldClass.class.getName());
			Path path = new Path(project, new File( new File(new File(".").getCanonicalPath() + "/build") + "/classes/main/").getAbsolutePath());
			javaTask.setClasspath(path);
			javaTask.init();
			int ret = javaTask.executeJava();
			System.out.println("java task return code: " + ret);

		} catch (BuildException e) {
			caught = e;
		}
		project.log("finished");
		project.fireBuildFinished(caught);
	}

}
