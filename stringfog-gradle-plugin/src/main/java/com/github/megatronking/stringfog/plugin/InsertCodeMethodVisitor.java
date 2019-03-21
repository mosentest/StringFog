package com.github.megatronking.stringfog.plugin;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.*;

import java.util.Random;

import static org.objectweb.asm.Opcodes.*;

/**
 * 作者 : moziqi
 * 邮箱 : 709847739@qq.com
 * 时间   : 2019/3/21-9:41
 * desc   : 实现在所有方法都插入一些没用的逻辑代码
 * version: 1.0
 */
public class InsertCodeMethodVisitor extends MethodVisitor {

    public InsertCodeMethodVisitor(int api, MethodVisitor mv) {
        super(api, mv);
    }


    @Override
    public void visitCode() {
        /**
         * 方法前
         */
        insertCode();
        super.visitCode();
        /**
         * 方法后
         */
        insertCode();
    }

    @Override
    public void visitInsn(int opcode) {
        insertCode();
        //判断RETURN
        if (opcode == Opcodes.RETURN) {
            //在这里插入代码
            insertCode();
        }
        super.visitInsn(opcode);
    }


    /**
     * case 1:break;
     * case 2:break;
     * case 3:break;
     * case 4:break;
     * case 5:break;
     * case 6:break;
     * case 7:break;
     * case 8:break;
     * case 9:break;
     * case 10:break;
     */
    public void insertCode() {
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("");
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
        Random random = new Random();
        int go = random.nextInt(6);
        switch (go) {
            case 1:
                mv.visitMethodInsn(INVOKEVIRTUAL, "com/github/megatronking/stringfog/insert", "a", "()V", false);
                break;
            case 2:
                mv.visitMethodInsn(INVOKEVIRTUAL, "com/github/megatronking/stringfog/insert", "b", "()V", false);
                break;
            case 3:
                mv.visitMethodInsn(INVOKEVIRTUAL, "com/github/megatronking/stringfog/insert", "c", "()V", false);
                break;
            case 4:
                mv.visitMethodInsn(INVOKEVIRTUAL, "com/github/megatronking/stringfog/insert", "d", "()V", false);
                break;
            case 5:
                mv.visitMethodInsn(INVOKEVIRTUAL, "com/github/megatronking/stringfog/insert", "e", "()V", false);
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                break;
            case 19:
                break;
            case 20:
                break;
            default:
                mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                mv.visitLdcInsn("");
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);

                break;
        }
    }
}
