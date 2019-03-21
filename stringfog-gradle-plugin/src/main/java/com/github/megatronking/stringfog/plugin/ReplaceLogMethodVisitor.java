package com.github.megatronking.stringfog.plugin;

import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.INVOKESTATIC;

/**
 * 作者 : moziqi
 * 邮箱 : 709847739@qq.com
 * 时间   : 2019/3/21-9:35
 * desc   : 替换log的工具类
 * version: 1.0
 */
public class ReplaceLogMethodVisitor extends MethodVisitor {

    public ReplaceLogMethodVisitor(int api, MethodVisitor mv) {
        super(api, mv);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        //super.visitMethodInsn(opcode, owner, name, desc, itf);
        if (owner.equalsIgnoreCase("android/util/Log")
                && name.equalsIgnoreCase("i")
                && desc.equalsIgnoreCase("(Ljava/lang/String;Ljava/lang/String;)I")) {
            //logHook(methodName, methodDesc);
            mv.visitMethodInsn(INVOKESTATIC,
                    "com/github/megatronking/stringfog/log/MzqLog",
                    "i",
                    "(Ljava/lang/String;Ljava/lang/String;)I",
                    false);
        } else if (owner.equalsIgnoreCase("android/util/Log")
                && name.equalsIgnoreCase("i")
                && desc.equalsIgnoreCase("(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I")) {
            //logHook(methodName, methodDesc);
            mv.visitMethodInsn(INVOKESTATIC,
                    "com/github/megatronking/stringfog/log/MzqLog",
                    "i",
                    "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I",
                    false);
        } else if (owner.equalsIgnoreCase("android/util/Log")
                && name.equalsIgnoreCase("v")
                && desc.equalsIgnoreCase("(Ljava/lang/String;Ljava/lang/String;)I")) {
            //logHook(methodName, methodDesc);
            mv.visitMethodInsn(INVOKESTATIC,
                    "com/github/megatronking/stringfog/log/MzqLog",
                    "v",
                    "(Ljava/lang/String;Ljava/lang/String;)I",
                    false);
        } else if (owner.equalsIgnoreCase("android/util/Log")
                && name.equalsIgnoreCase("v")
                && desc.equalsIgnoreCase("(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I")) {
            //logHook(methodName, methodDesc);
            mv.visitMethodInsn(INVOKESTATIC,
                    "com/github/megatronking/stringfog/log/MzqLog",
                    "v",
                    "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I",
                    false);
        } else if (owner.equalsIgnoreCase("android/util/Log")
                && name.equalsIgnoreCase("d")
                && desc.equalsIgnoreCase("(Ljava/lang/String;Ljava/lang/String;)I")) {
            //logHook(methodName, methodDesc);
            mv.visitMethodInsn(INVOKESTATIC,
                    "com/github/megatronking/stringfog/log/MzqLog",
                    "d",
                    "(Ljava/lang/String;Ljava/lang/String;)I",
                    false);
        } else if (owner.equalsIgnoreCase("android/util/Log")
                && name.equalsIgnoreCase("d")
                && desc.equalsIgnoreCase("(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I")) {
            //logHook(methodName, methodDesc);
            mv.visitMethodInsn(INVOKESTATIC,
                    "com/github/megatronking/stringfog/log/MzqLog",
                    "d",
                    "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I",
                    false);
        } else if (owner.equalsIgnoreCase("android/util/Log")
                && name.equalsIgnoreCase("w")
                && desc.equalsIgnoreCase("(Ljava/lang/String;Ljava/lang/String;)I")) {
            //logHook(methodName, methodDesc);
            mv.visitMethodInsn(INVOKESTATIC,
                    "com/github/megatronking/stringfog/log/MzqLog",
                    "w",
                    "(Ljava/lang/String;Ljava/lang/String;)I",
                    false);
        } else if (owner.equalsIgnoreCase("android/util/Log")
                && name.equalsIgnoreCase("w")
                && desc.equalsIgnoreCase("(Ljava/lang/String;Ljava/lang/Throwable;)I")) {
            //logHook(methodName, methodDesc);
            mv.visitMethodInsn(INVOKESTATIC,
                    "com/github/megatronking/stringfog/log/MzqLog",
                    "w",
                    "(Ljava/lang/String;Ljava/lang/Throwable;)I",
                    false);
        } else if (owner.equalsIgnoreCase("android/util/Log")
                && name.equalsIgnoreCase("w")
                && desc.equalsIgnoreCase("(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I")) {
            //logHook(methodName, methodDesc);
            mv.visitMethodInsn(INVOKESTATIC,
                    "com/github/megatronking/stringfog/log/MzqLog",
                    "w",
                    "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I",
                    false);
        } else if (owner.equalsIgnoreCase("android/util/Log")
                && name.equalsIgnoreCase("e")
                && desc.equalsIgnoreCase("(Ljava/lang/String;Ljava/lang/String;)I")) {
            //logHook(methodName, methodDesc);
            mv.visitMethodInsn(INVOKESTATIC,
                    "com/github/megatronking/stringfog/log/MzqLog",
                    "e",
                    "(Ljava/lang/String;Ljava/lang/String;)I",
                    false);
        } else if (owner.equalsIgnoreCase("android/util/Log")
                && name.equalsIgnoreCase("e")
                && desc.equalsIgnoreCase("(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I")) {
            //logHook(methodName, methodDesc);
            mv.visitMethodInsn(INVOKESTATIC,
                    "com/github/megatronking/stringfog/log/MzqLog",
                    "e",
                    "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I",
                    false);
        } else if (owner.equalsIgnoreCase("android/util/Log")
                && name.equalsIgnoreCase("wtf")
                && desc.equalsIgnoreCase("(Ljava/lang/String;Ljava/lang/String;)I")) {
            //logHook(methodName, methodDesc);
            mv.visitMethodInsn(INVOKESTATIC,
                    "com/github/megatronking/stringfog/log/MzqLog",
                    "wtf",
                    "(Ljava/lang/String;Ljava/lang/String;)I",
                    false);
        } else if (owner.equalsIgnoreCase("android/util/Log")
                && name.equalsIgnoreCase("wtf")
                && desc.equalsIgnoreCase("(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I")) {
            //logHook(methodName, methodDesc);
            mv.visitMethodInsn(INVOKESTATIC,
                    "com/github/megatronking/stringfog/log/MzqLog",
                    "wtf",
                    "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I",
                    false);
        } else if (owner.equalsIgnoreCase("android/util/Log")
                && name.equalsIgnoreCase("wtf")
                && desc.equalsIgnoreCase("(Ljava/lang/String;Ljava/lang/Throwable;)I")) {
            //logHook(methodName, methodDesc);
            mv.visitMethodInsn(INVOKESTATIC,
                    "com/github/megatronking/stringfog/log/MzqLog",
                    "wtf",
                    "(Ljava/lang/String;Ljava/lang/Throwable;)I",
                    false);
        } else {
            super.visitMethodInsn(opcode, owner, name, desc, itf);
        }
    }
}
