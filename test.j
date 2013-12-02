.class public test
.super java/lang/Object

.field public static i I
.field public static j I

.method public static main([Ljava/lang/String;)V
.limit stack  16
.limit locals 10

	ldc 1
	ldc 1
	iadd
	ldc 1
	iadd
	putstatic test/i I
	getstatic test/i I
	ldc 1
	iadd
	putstatic test/j I
	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic test/j I
	ldc 1
	iadd
	invokevirtual java/io/PrintStream/println(I)V
	return

.end method
