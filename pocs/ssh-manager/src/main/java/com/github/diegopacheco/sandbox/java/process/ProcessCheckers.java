package com.github.diegopacheco.sandbox.java.process;

import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

/**
 * Home for utility pre-build checkers.
 * 
 * @author diegopacheco
 *
 */
public class ProcessCheckers {

	public static ProcessChecker NO_CHECKER = new ProcessChecker() {
		@Override
		public boolean isDoingProgress(PIDMetadata pim) {
			return true;
		}

		@Override
		public boolean hasCompleted(PIDMetadata pim) {
			return true;
		}

		@Override
		public String toString() {
			return "NO_CHECKER";
		}
	};

	public static ProcessChecker PID_CHECKER = new ProcessChecker() {
		
		@Override
		public boolean isDoingProgress(PIDMetadata pim) {
			return true;
		}

		@Override
		public boolean hasCompleted(PIDMetadata pim) {
			return isPidRunning(pim);
		}

		private boolean isPidRunning(PIDMetadata pim) {
			try {
				
				String cmd = "ps aux | grep " + pim.getPid();
				ProcessBuilder pb = new ProcessBuilder("sh", "-c", cmd);
				Process p = pb.start();
				String content = IOUtils.toString(p.getInputStream(), Charset.defaultCharset());
				String error = IOUtils.toString(p.getErrorStream(), Charset.defaultCharset());
				
				if(content!=null) {
					content = content.replaceAll("grep " + pim.getPid(), "");
				}
				
				if (error!=null && (!error.equals("")))
					return false;
				
				if (content!=null && content.contains(pim.getPid().toString()))
					return true;
				
				return false;
			}catch(Exception e) {
				System.out.println(e);
				return false;
			}
		}

	};

}
