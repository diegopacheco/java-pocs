package com.github.diegopacheco.sandboxspring.agent;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class SubjectClassTransformer implements ClassFileTransformer, Opcodes {
    @Override
    public byte[] transform(Module module, ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (!"javax/security/auth/Subject".equals(className)) {
            return null;
        }
        ClassReader reader = new ClassReader(classfileBuffer);
        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        ClassVisitor visitor = new ClassVisitor(ASM9, writer) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                if ("getSubject".equals(name) && "(Ljava/security/AccessControlContext;)Ljavax/security/auth/Subject;".equals(descriptor)) {
                    MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
                    mv.visitCode();
                    Label tryStart = new Label();
                    Label tryEnd = new Label();
                    Label catchBlock = new Label();
                    mv.visitTryCatchBlock(tryStart, tryEnd, catchBlock, "java/lang/Throwable");
                    mv.visitLabel(tryStart);
                    mv.visitLdcInsn(Type.getType("Ljavax/security/auth/Subject;"));
                    mv.visitLdcInsn("current");
                    mv.visitInsn(ICONST_0);
                    mv.visitTypeInsn(ANEWARRAY, "java/lang/Class");
                    mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Class", "getDeclaredMethod", "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", false);
                    mv.visitVarInsn(ASTORE, 1);
                    mv.visitVarInsn(ALOAD, 1);
                    mv.visitInsn(ICONST_1);
                    mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/reflect/Method", "setAccessible", "(Z)V", false);
                    mv.visitVarInsn(ALOAD, 1);
                    mv.visitInsn(ACONST_NULL);
                    mv.visitInsn(ICONST_0);
                    mv.visitTypeInsn(ANEWARRAY, "java/lang/Object");
                    mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/reflect/Method", "invoke", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", false);
                    mv.visitTypeInsn(CHECKCAST, "javax/security/auth/Subject");
                    mv.visitVarInsn(ASTORE, 2);
                    mv.visitLabel(tryEnd);
                    mv.visitVarInsn(ALOAD, 2);
                    mv.visitInsn(ARETURN);
                    mv.visitLabel(catchBlock);
                    mv.visitVarInsn(ASTORE, 3);
                    mv.visitInsn(ACONST_NULL);
                    mv.visitInsn(ARETURN);
                    mv.visitMaxs(0, 0);
                    mv.visitEnd();
                    return new MethodVisitor(ASM9) {};
                }
                return super.visitMethod(access, name, descriptor, signature, exceptions);
            }
        };
        reader.accept(visitor, ClassReader.SKIP_FRAMES);
        return writer.toByteArray();
    }
}
