package com.github.diegopacheco.scannotations.annotations.core;

import org.scannotation.AnnotationDB;
import org.scannotation.ClasspathUrlFinder;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class AnnotationsDiscovery {

    public static Set<Object> getPrintables() {
        try {
            URL[] urls = ClasspathUrlFinder.findClassPaths();
            AnnotationDB db = new AnnotationDB();
            db.scanArchives(urls);
            Set<String> printableClasses =
                    db.getAnnotationIndex().get(Printable.class.getName());

            Set<Object> result = new HashSet<>();
            for (String clazz : printableClasses) {
                result.add(Class.forName(clazz).newInstance());
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
