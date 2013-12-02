.class public test
.super java/lang/Object

.field public static i I
.field public static j I

.method public static main([Ljava/lang/String;)V
.limit stack  16
.limit locals 10

	ldc 1
	putstatic test/i I
	ldc 2
	putstatic test/j I
	getstatic test/i I
	getstatic test/j I
	if_icmplt L000
	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic test/i I
	invokevirtual java/io/PrintStream/println(I)V
	goto L001
L000:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	getstatic test/j I
	invokevirtual java/io/PrintStream/println(I)V
L001:
	return

.end method
