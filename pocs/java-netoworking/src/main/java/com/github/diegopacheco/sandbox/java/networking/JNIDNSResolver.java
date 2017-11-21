package com.github.diegopacheco.sandbox.java.networking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class JNIDNSResolver {

	private static final String DNS_PROVIDER_URL = "dns:";
	private static final String DNS_NAMING_FACTORY = "com.sun.jndi.dns.DnsContextFactory";
	private static final String JAVA_NAMING_FACTORY_INITIAL = "java.naming.factory.initial";
	private static final String JAVA_NAMING_PROVIDER_URL = "java.naming.provider.url";
	private static final String TXT_RECORD_TYPE = "TXT";

	public static DirContext getContext() {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(JAVA_NAMING_FACTORY_INITIAL, DNS_NAMING_FACTORY);
		env.put(JAVA_NAMING_PROVIDER_URL, DNS_PROVIDER_URL);
		try {
			return new InitialDirContext(env);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	public static List<String> resolveDNS(String discoveryDnsName) {
		try {
			Attributes attrs = getContext().getAttributes(discoveryDnsName, new String[] { TXT_RECORD_TYPE });
			Attribute attr = attrs.get(TXT_RECORD_TYPE);
			String txtRecord = null;
			if (attr != null) {
				txtRecord = attr.get().toString();
			}

			List<String> cnamesSet = new ArrayList<>();
			if (txtRecord == null || txtRecord.trim().isEmpty()) {
				return cnamesSet;
			}
			String[] cnames = txtRecord.split(" ");
			Collections.addAll(cnamesSet, cnames);

			return cnamesSet;
		} catch (Exception e) {
			System.out.println(e);
			return Arrays.asList();
		}
	}

	public static void main(String[] args) {
		System.out.println(JNIDNSResolver.resolveDNS("google.com"));
		System.out.println(JNIDNSResolver.resolveDNS("_spf.google.com"));
		System.out.println(JNIDNSResolver.resolveDNS("_netblocks.google.com"));
	}
}
