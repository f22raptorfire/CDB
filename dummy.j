.class public Program
.super java/lang/Object

.field public static i I
.field public static j I

.method public static main([Ljava/lang/String;)V
.limit stack  16
.limit locals 10

;j = 1
	ldc 1
	putstatic Program/j I
;i = 8
	ldc 8
	putstatic Program/i I
;Print the integer in variable i
	getstatic     java/lang/System/out Ljava/io/PrintStream;
	getstatic Program/i I
	invokevirtual java/io/PrintStream/println(I)V
;Print the integer in variable j
	getstatic     java/lang/System/out Ljava/io/PrintStream;
	getstatic Program/j I
	invokevirtual java/io/PrintStream/println(I)V
	return

.end method
