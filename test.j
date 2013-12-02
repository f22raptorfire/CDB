.class public test
.super java/lang/Object

.field public static i I
.field public static j I

.method public static main([Ljava/lang/String;)V
.limit stack  16
.limit locals 10

	ldc 4
	putstatic test/j I
	ldc 0
	putstatic test/i I
L000:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic test/i I
	invokevirtual java/io/PrintStream/println(I)V
	getstatic test/i I
	ldc 1
	iadd
	putstatic test/i I
	getstatic test/j I
	getstatic test/i I
	if_icmpgt L000
	return

.end method
