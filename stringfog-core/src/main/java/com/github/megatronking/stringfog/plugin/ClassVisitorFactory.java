/*
 * Copyright (C) 2017, Megatron King
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.github.megatronking.stringfog.plugin;


import com.github.megatronking.stringfog.IKeyGenerator;
import com.github.megatronking.stringfog.IStringFog;
import com.github.megatronking.stringfog.plugin.utils.Log;
import com.github.megatronking.stringfog.plugin.utils.TextUtils;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

/**
 * A factory creates {@link ClassVisitor}.
 *
 * @author Megatron King
 * @since 2017/3/7 19:56
 */

public final class ClassVisitorFactory {

    private ClassVisitorFactory() {
    }

    public static ClassVisitor create(IStringFog stringFogImpl, StringFogMappingPrinter mappingPrinter,
                                      String[] fogPackages, IKeyGenerator kg, String fogClassName,
                                      String className, StringFogMode mode, ClassVisitor cv, String junkCodeClass, int junkCodeClassLen) {
        if (WhiteLists.inWhiteList(className) || !isInFogPackages(fogPackages, className)) {
            Log.v("StringFog ignore: " + className);
            return createEmpty(cv);
        }
        Log.v("StringFog execute: " + className);
        return new StringFogClassVisitor(stringFogImpl, mappingPrinter, fogClassName, cv, kg, mode, junkCodeClass, junkCodeClassLen);
    }

    private static ClassVisitor createEmpty(ClassVisitor cv) {
        return new ClassVisitor(Opcodes.ASM7, cv) {
        };
    }

    private static boolean isInFogPackages(String[] fogPackages, String className) {
        if (TextUtils.isEmpty(className)) {
            return false;
        }
        if (fogPackages == null || fogPackages.length == 0) {
            // default we fog all packages.
            return true;
        }
        for (String fogPackage : fogPackages) {
            if (className.replace('/', '.').startsWith(fogPackage + ".")) {
                return true;
            }
        }
        return false;
    }

}
