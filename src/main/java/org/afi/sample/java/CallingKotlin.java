package org.afi.sample.java;

import org.afi.sample.kotlin.CallingJavaKt;
import org.eclipse.jdt.annotation.NonNull;

import java.io.IOException;

public class CallingKotlin {

    public static void main(String... args) {
        try {
            CallingJavaKt.throwIOException();
            assert false;
        } catch (IOException e) {
            assert true;
        }
    }

    public static void receivesNotNullParameter(@NonNull String param) {
        /*
         * The compiler supports several flavors of nullability annotations, including:
         * JetBrains (@Nullable and @NotNull from the org.jetbrains.annotations package)
         * Android (com.android.annotations and android.support.annotations)
         * JSR-305 (javax.annotation, more details below)
         * FindBugs (edu.umd.cs.findbugs.annotations)
         * Eclipse (org.eclipse.jdt.annotation)
         * Lombok (lombok.NonNull).
         */
    }
}
