package com.github.megatronking.stringfog.plugin;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;
import org.objectweb.asm.commons.Method;

import java.util.Random;

/**
 * Copyright (C), 2016-2023
 * Author: 超人迪加
 * Date: 2023/7/13 3:18 PM
 */
class MethodVisitorAdviceAdapter extends AdviceAdapter {

    String lowercase = "abcdefghijklmnopqrstuvwxyz";
    private int start;

    private String mJunkCodeClass;

    /**
     * Constructs a new {@link AdviceAdapter}.
     *
     * @param api           the ASM API version implemented by this visitor. Must be one of {@link
     *                      Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6} or {@link Opcodes#ASM7}.
     * @param methodVisitor the method visitor to which this adapter delegates calls.
     * @param access        the method's access flags (see {@link Opcodes}).
     * @param name          the method's name.
     * @param descriptor    the method's descriptor (see {@link Type Type}).
     */
    protected MethodVisitorAdviceAdapter(int api, MethodVisitor methodVisitor, int access, String name, String descriptor, String junkCodeClass) {
        super(api, methodVisitor, access, name, descriptor);
        mJunkCodeClass = junkCodeClass;
    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();
        invokeStatic(Type.getType("Ljava/lang/System;"), new Method("currentTimeMillis", "()J"));
        //创建一个long类型的本地变量
        start = newLocal(Type.LONG_TYPE);
        //用一个本地变量接受上一步执行的结果
        storeLocal(start);
        loadLocal(start);
        mv.visitMethodInsn(INVOKESTATIC, mJunkCodeClass.replace(".", "/"), String.valueOf(lowercase.charAt(new Random().nextInt(lowercase.length()))), "(J)V", false);
    }

    /**
     * int IRETURN = 172; // visitInsn
     * int LRETURN = 173; // -
     * int FRETURN = 174; // -
     * int DRETURN = 175; // -
     * int ARETURN = 176; // -
     * int RETURN = 177; // -
     *
     * @param opcode one of {@link Opcodes#RETURN}, {@link Opcodes#IRETURN}, {@link Opcodes#FRETURN},
     *               {@link Opcodes#ARETURN}, {@link Opcodes#LRETURN}, {@link Opcodes#DRETURN} or {@link
     *               Opcodes#ATHROW}.
     */
    @Override
    protected void onMethodExit(int opcode) {
        super.onMethodExit(opcode);
        if (opcode >= IRETURN && opcode <= RETURN) {
            invokeStatic(Type.getType("Ljava/lang/System;"), new Method("currentTimeMillis", "()J"));
            //创建一个long类型的本地变量
            int end = newLocal(Type.LONG_TYPE);
            //用一个本地变量接受上一步执行的结果
            storeLocal(end);

            //getStatic(Type.getType("Ljava/lang/System;"), "out", Type.getType("Ljava/io/PrintStream;"));
            newInstance(Type.getType("Ljava/lang/StringBuilder;"));
            dup();
            invokeConstructor(Type.getType("Ljava/lang/StringBuilder;"), new Method("<init>", "()V"));
            visitLdcInsn(lowercase.charAt(new Random().nextInt(lowercase.length())) + "_time :");
            invokeVirtual(Type.getType("Ljava/lang/StringBuilder;"), new Method("append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;"));
            //减法
            loadLocal(end);
            loadLocal(start);
            math(SUB, Type.LONG_TYPE);
            invokeVirtual(Type.getType("Ljava/lang/StringBuilder;"), new Method("append", "(J)Ljava/lang/StringBuilder;"));
            visitLdcInsn(" ms_" + lowercase.charAt(new Random().nextInt(lowercase.length())));
            invokeVirtual(Type.getType("Ljava/lang/StringBuilder;"), new Method("append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;"));
            invokeVirtual(Type.getType("Ljava/lang/StringBuilder;"), new Method("toString", "()Ljava/lang/String;"));
            //--- invokeVirtual(Type.getType("Ljava/io/PrintStream;"),new  Method("println","(Ljava/lang/String;)V"));
            //--  invokeVirtual(Type.getType("L" + mJunkCodeClass.replace(".", "/") + ";"), new Method("println", "(Ljava/lang/String;)V"));
            mv.visitMethodInsn(INVOKESTATIC, mJunkCodeClass.replace(".", "/"), "println", "(Ljava/lang/String;)V", false);

            loadLocal(end);
            mv.visitMethodInsn(INVOKESTATIC, mJunkCodeClass.replace(".", "/"), String.valueOf(lowercase.charAt(new Random().nextInt(lowercase.length()))), "(J)V", false);
        }
    }
}
