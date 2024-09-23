package com.github.diegopacheco.java23.features.JEP_466;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Label;
import java.lang.classfile.*;
import java.lang.classfile.instruction.InvokeInstruction;
import java.lang.constant.ClassDesc;
import static java.lang.classfile.ClassFile.*;
import static org.objectweb.asm.Opcodes.V1_8;

/**
 * JEP 466: Class-File API (Second Preview)
 * https://openjdk.org/jeps/466
 */
public class FeatureJEP466 {
    public static void main(String[] args) {
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        classWriter.visit(V1_8, ACC_PUBLIC, "Foo", null, "java/lang/Object", null);

        MethodVisitor mv = classWriter.visitMethod(ACC_PUBLIC, "fooBar", "(ZI)V", null, null);
        mv.visitCode();
        mv.visitVarInsn(ILOAD, 1);
        Label label1 = new Label();
        mv.visitJumpInsn(IFEQ, label1);
        mv.visitVarInsn(ALOAD, 0);
        mv.visitVarInsn(ILOAD, 2);
        mv.visitMethodInsn(INVOKEVIRTUAL, "Foo", "foo", "(I)V", false);
        Label label2 = new Label();
        mv.visitJumpInsn(GOTO, label2);
        mv.visitLabel(label1);
        mv.visitVarInsn(ALOAD, 0);
        mv.visitVarInsn(ILOAD, 2);
        mv.visitMethodInsn(INVOKEVIRTUAL, "Foo", "bar", "(I)V", false);
        mv.visitLabel(label2);
        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        classWriter.visitEnd();

        byte[] code = classWriter.toByteArray();
        for (int i = 0; i < code.length; i++) {
            System.out.printf("%02x ", code[i]);
        }

        ClassFile cf = ClassFile.of();
        ClassModel classModel = cf.parse(code);
        MethodTransform methodTransform = MethodTransform.transformingCode((codeBuilder, e) -> {
            switch (e) {
                case InvokeInstruction i when i.owner().asInternalName().equals("Foo") ->
                        codeBuilder.invoke(i.opcode(), ClassDesc.of("Bar"),
                                i.name().stringValue(),
                                i.typeSymbol(), i.isInterface());
                default -> codeBuilder.accept(e);
            }
        });

        ClassTransform classTransform = ClassTransform.transformingMethods(methodTransform);
        byte[] newBytes = cf.transform(cf.parse(code), classTransform);
        for (int i = 0; i < newBytes.length; i++) {
            System.out.printf("%02x ", newBytes[i]);
        }
    }
}